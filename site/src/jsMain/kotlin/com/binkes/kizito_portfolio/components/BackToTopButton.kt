package com.binkes.kizito_portfolio.components

import androidx.compose.runtime.*
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.pages.mainScreenScrollLayoutId
import com.binkes.kizito_portfolio.styles.BackToTopButtonStyle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.VerticalAlign
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowDown
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event


@OptIn(DelicateApi::class)
@Composable
fun BackToTopButton(
){

    val breakpoint = rememberBreakpoint()
    var scrollT: Double? by remember { mutableStateOf(null) }

    val scope = rememberCoroutineScope()

    var showButton by remember { mutableStateOf(Visibility.Hidden) }

    /*
    LaunchedEffect(Unit){

        window.addEventListener(
            type = "scroll",
            callback = {
                scrollT = document.documentElement?.scrollTop
            }
        )

    }

     */


    DisposableEffect(Unit) {
        val element = document.getElementById(mainScreenScrollLayoutId) as? HTMLElement
        if (element != null) {
            val listener: (Event) -> Unit = {
                scrollT = element.scrollTop.toDouble()
            }
            element.addEventListener("scroll", listener)

            // Cleanup when this Composable leaves composition
            onDispose {
                element.removeEventListener("scroll", listener)
            }
        } else {
            onDispose { }
        }
    }


    LaunchedEffect(scrollT){

       // showButton = true

        scope.launch {

             if (scrollT != null && scrollT!! > 400.0) {
                delay(700)
                if (scrollT != null && scrollT!! > 400.0) {
                    if (showButton != Visibility.Visible) {
                        showButton = Visibility.Visible
                    }
                }
            } else {
                 delay(500)
                 if (scrollT != null && scrollT!! > 400.0) {

                 }else{
                     if (showButton != Visibility.Hidden) {
                         showButton = Visibility.Hidden
                     }
                 }
            }
        }



    }


    Column(
        modifier = Modifier
            //.height(Height.MaxContent)
           // .position(Position.Static)
            .fillMaxWidth()
            .alignSelf(AlignSelf.SelfEnd)
            .verticalAlign(VerticalAlign.Bottom)
            .margin(bottom = 70.px, right = 10.px, left = 10.px)
            .styleModifier {
                property("pointer-events", "none")
            }
            .zIndex(4),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {



        Box(
            modifier = BackToTopButtonStyle.toModifier()
                .size(if (breakpoint <= Breakpoint.SM) 40.px else 50.px)
                .visibility(visibility = showButton)
                .borderRadius(20.percent)
                .margin(
                    right = if (breakpoint <= Breakpoint.SM) 30.px else 40.px,
                    bottom = if (breakpoint <= Breakpoint.SM) 30.px else 40.px
                )
                .backgroundColor(ThemeByKizito.Primary.rgb)
                .cursor(Cursor.Pointer)
                .onClick {

                    document.documentElement?.scroll(x = 0.0, y = 0.0)

                }
                .styleModifier {
                    property("pointer-events", "auto")
                },
            contentAlignment = Alignment.Center
        ){


            FaArrowDown(
                modifier = Modifier
                    .color(Color.white)
                        // Disable right-click / long-press
                    . onContextMenu { event ->
                        event.preventDefault()
                        event.stopPropagation()
                    }
                ,
                size = if (breakpoint <= Breakpoint.SM) IconSize.SM else IconSize.LG


            )


        }



    }


}