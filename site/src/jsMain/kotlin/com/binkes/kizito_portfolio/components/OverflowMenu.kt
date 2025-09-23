package com.binkes.kizito_portfolio.components
import androidx.compose.runtime.*
import com.binkes.kizito_portfolio.models.Section
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.pages.navigateScrollToSection
import com.binkes.kizito_portfolio.styles.NavigationItemStyle
import com.binkes.kizito_portfolio.util.ConstantsObject.FONT_FAMILY
import com.binkes.kizito_portfolio.util.ResObject
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text


@OptIn(DelicateApi::class)
@Composable
fun OverflowMenu(onMenuClosed: () -> Unit) {
    val scope = rememberCoroutineScope()
    val breakpoint = rememberBreakpoint()
    var translateX by remember { mutableStateOf((-100).percent) }
    var opacity by remember { mutableStateOf(0.percent) }

    LaunchedEffect(breakpoint) {
        translateX = 0.percent
        opacity = 100.percent
        if(breakpoint > Breakpoint.MD) {
            scope.launch {
                translateX = (-100).percent
                opacity = 0.percent
                delay(500)
                onMenuClosed()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(2)
            .opacity(opacity)
            .backgroundColor(argb(a = 0.5f, r = 0.0f, g = 0.0f, b = 0.0f))
            .transition(Transition.of(property = "opacity", duration = 500.ms))
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(all = 25.px)
                .width(if (breakpoint < Breakpoint.MD) 50.percent else 25.percent)
                .overflow(Overflow.Auto)
                .scrollBehavior(ScrollBehavior.Smooth)
                .backgroundColor(Colors.White)
                .translateX(tx = translateX)
                .transition(Transition.of(property = "translate", duration = 500.ms))
        ) {
            Row(
                modifier = Modifier.margin(bottom = 25.px),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Image(
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .margin(right = 20.px)
                        .onClick {
                            scope.launch {
                                translateX = (-100).percent
                                opacity = 0.percent
                                delay(500)
                                onMenuClosed()
                            }
                        }
                       .size(
                           if (breakpoint <= Breakpoint.ZERO) 30.px else 35.px
                       )
                    ,
                    src = ResObject.Icon.close_icon,
                    alt = "close icon"
                )


                Image(
                    modifier = Modifier.size(80.px),
                    src = ResObject.Image.logo,
                    alt = "Logo Image"
                )
            }
            Section.entries.toTypedArray().take(6).forEach { section ->




                A(href = "/${section.path}",
                    attrs = NavigationItemStyle.toModifier()
                        .cursor(Cursor.Pointer)
                        .margin(bottom = 10.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Normal)
                        .textDecorationLine(TextDecorationLine.None)
                        .color(ThemeByKizito.TextBlue.rgb)
                        .userSelect(UserSelect.None)
                        .toAttrs{
                            onClick {
                                it.preventDefault()
                                it.stopPropagation()

                                navigateScrollToSection(section.id)

                                scope.launch {
                                    translateX = (-100).percent
                                    opacity = 0.percent
                                    delay(500)
                                    onMenuClosed()
                                }

                            }

                        }
                ) {

                    Text(value = section.title)

                }

            }
        }
    }
}