package com.binkes.kizito_portfolio.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.OverflowWrap
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.overflowWrap
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement
import org.w3c.dom.asList



// Top-level declarations
@JsName("showdown")
external object Showdown {
    class Converter(options: dynamic) {
        fun makeHtml(markdown: String): String
    }
}




@OptIn(DelicateApi::class)
@Composable
fun RenderMarkdown(
    editText: String,
    styleModifier: Modifier
) {



    val output = remember { mutableStateOf("") }


    LaunchedEffect(editText) {


        val options = js("{}")
        options.simpleLineBreaks = true
        options.strikethrough = true
        options.emoji = true
        options.tasklists = true
        options.ghCodeBlocks = true
        options.simplifiedAutoLink = true
        options.underline = true
        options.ellipsis = true

        options.smoothPreview = true
        options.parseBlockquotes = true

        options.openLinksInNewWindow = true
        options.noHeaderId =
            true
        options.tables = true
        options.tablesHeaderId = false
        options.encodeEmails = false
        options.parseImgDimension = true

        options.ghMentions = true

        options.ghMentionsLink = "http://mysite.com/{u}/profile"



        val converter = Showdown.Converter(options = options)

        output.value = converter.makeHtml(editText)  //Convert user input


    }



        var element by remember { mutableStateOf<HTMLElement?>(null) }



        Div(
            attrs = styleModifier
                .whiteSpace(WhiteSpace.Normal)
                .overflowWrap(OverflowWrap.BreakWord)
                .toAttrs(),
            content = {


                DisposableEffect(Unit) {

                    element = scopeElement

                    onDispose {
                        element?.innerHTML = ""
                    }
                }

                LaunchedEffect(output.value) {


                    if (element != null) {

                        val el = element!!
                        el.innerHTML = output.value



                        //  blockquote
                        fun replaceTags(line: String): String {
                            return when {
                                line.trim().startsWith("[error]") -> line.replaceFirst("[error]", "🚨 Error")
                                line.trim().startsWith("[warning]") -> line.replaceFirst("[warning]", "⚠️ Warning")
                                line.trim().startsWith("[success]") -> line.replaceFirst("[success]", "✅ Success")
                                line.trim().startsWith("[info]") -> line.replaceFirst("[info]", "ℹ️ Info")
                                else -> line
                            }
                        }


                        fun processBlockquote(blockquote: HTMLElement, nestingLevel: Int = 0) {

                            val paragraphs = blockquote.querySelectorAll(":scope > p").asList()

                            paragraphs.forEach { p ->
                                val pElement = p as HTMLElement
                                val content = pElement.textContent ?: ""
                                val processedLines = content
                                    .split("\n")
                                    .map(::replaceTags)

                                pElement.innerHTML = processedLines.joinToString("<br>")
                            }

                            // Style based on first line
                            val firstLine = paragraphs.firstOrNull()
                                ?.textContent
                                ?.split("\n")
                                ?.firstOrNull()
                                ?.trim() ?: ""



                            when {
                                firstLine.startsWith("🚨 Error") -> applyBlockquoteStyle(
                                    blockquote,
                                    nestingLevel,
                                    "error"
                                )

                                firstLine.startsWith("⚠️ Warning") -> applyBlockquoteStyle(
                                    blockquote,
                                    nestingLevel,
                                    "warning"
                                )

                                firstLine.startsWith("✅ Success") -> applyBlockquoteStyle(
                                    blockquote,
                                    nestingLevel,
                                    "success"
                                )

                                firstLine.startsWith("ℹ️ Info") -> applyBlockquoteStyle(
                                    blockquote,
                                    nestingLevel,
                                    "info"
                                )


                                else -> applyBlockquoteStyle(blockquote, nestingLevel, "default")
                            }

                            // Recursively handle nested blockquotes
                            val nestedBlockquotes = blockquote.querySelectorAll(":scope > blockquote").asList()
                            nestedBlockquotes.forEach { nested ->
                                processBlockquote(nested as HTMLElement, nestingLevel + 1)
                            }
                        }
                        // Start with top-level blockquotes
                        val topLevelBlockquotes = element!!.querySelectorAll("blockquote").asList()
                        topLevelBlockquotes.forEach {
                            processBlockquote(it as HTMLElement)
                        }


                    }


                }


            }
        )







}







private fun applyBlockquoteStyle(
    element: HTMLElement,
    nestingLevel: Int,
    type: String
) {
    val (baseR, baseG, baseB) = when (type) {
        "error" -> Triple(211, 47, 47)
        "warning" -> Triple(255, 152, 0)
        "success" -> Triple(46, 125, 50)
        "info" -> Triple(2, 136, 209)
        else -> Triple(85, 102, 140)
    }

    val bgColor = when (type) {
        "error" -> "rgb(${255 - (nestingLevel * 10)}, ${235 - (nestingLevel * 10)}, ${233 - (nestingLevel * 10)})"
        "warning" -> "rgb(${255 - (nestingLevel * 10)}, ${243 - (nestingLevel * 10)}, ${205 - (nestingLevel * 10)})"
        "success" -> "rgb(${223 - (nestingLevel * 10)}, ${240 - (nestingLevel * 10)}, ${216 - (nestingLevel * 10)})"
        "info" -> "rgb(${227 - (nestingLevel * 10)}, ${242 - (nestingLevel * 10)}, ${253 - (nestingLevel * 10)})"
        else -> "rgb(${48 + (nestingLevel * 10)}, ${50 + (nestingLevel * 10)}, ${54 + (nestingLevel * 10)})"
    }

    with(element.style) {
        fontFamily = "Roboto, sans-serif"
        setProperty("background-color", bgColor)
        setProperty("border-left", "4px solid rgb($baseR, $baseG, $baseB)")
        setProperty("padding", "10px")
        setProperty("color", when (type) {
            "error" -> "rgb(${183 - (nestingLevel * 10)}, ${28 - (nestingLevel * 2)}, ${28 - (nestingLevel * 2)})"
            "warning" -> "rgb(${230 - (nestingLevel * 10)}, ${81 - (nestingLevel * 2)}, 0)"
            "success" -> "rgb(${27 - (nestingLevel * 2)}, ${94 - (nestingLevel * 5)}, ${32 - (nestingLevel * 2)})"
            "info" -> "rgb(${1 - (nestingLevel * 0.5).toInt()}, ${87 - (nestingLevel * 5)}, ${155 - (nestingLevel * 5)})"
            else -> "rgb(${188 + (nestingLevel * 2)}, ${190 + (nestingLevel * 2)}, ${195 + (nestingLevel * 2)})"
        })
        setProperty("width", "${95 - (nestingLevel * 5)}%")
        setProperty("max-width", "70%")
        setProperty("margin", "0")
        setProperty("place-self", "center")
        setProperty("line-height", "1.5")

    }
}





