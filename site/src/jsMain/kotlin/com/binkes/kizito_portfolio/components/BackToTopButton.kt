package com.binkes.kizito_portfolio.components

import androidx.compose.runtime.*
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.styles.BackToTopButtonStyle
import com.varabyte.kobweb.compose.css.Cursor
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
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


@OptIn(DelicateApi::class)
@Composable
fun BackToTopButton(
){

    val breakpoint = rememberBreakpoint()
    var scroll: Double? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit){

        window.addEventListener(
            type = "scroll",
            callback = {
                scroll = document.documentElement?.scrollTop
            }
        )

    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .position(Position.Fixed)
            .zIndex(1)
            .styleModifier {
                property("pointer-events", "none")
            },
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {

        Box(
            modifier = BackToTopButtonStyle.toModifier()
                .size(if (breakpoint <= Breakpoint.SM) 40.px else 50.px)
                .visibility(
                    if (scroll != null && scroll!! > 400.0) Visibility.Visible
                    else Visibility.Hidden
                )
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
                    .color(Color.white),
                size = if (breakpoint <= Breakpoint.SM) IconSize.SM else IconSize.LG


            )


        }



    }


}