package com.binkes.kizito_portfolio.components


import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.binkes.kizito_portfolio.models.Section
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.pages.navigateScrollToSection
import com.binkes.kizito_portfolio.styles.LogoStyle
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.binkes.kizito_portfolio.util.ResObject
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@OptIn(DelicateApi::class)
@Composable
fun Header (
    onMenuClicked: () -> Unit
){

    val breakPoint = rememberBreakpoint()



        Row(
            modifier = Modifier
                .fillMaxWidth(if (breakPoint > Breakpoint.MD) 80.percent else 90.percent)
                .background(ThemeByKizito.Primary_ALPHA1.rgb)
                .margin(topBottom = 50.px),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            LeftSide(
                breakpoint = breakPoint,
                onMenuClicked = {
                    onMenuClicked()
                }
            )

            if (breakPoint > Breakpoint.SM) {
                RightSide(breakpoint = breakPoint)
            }

        }



}


@Composable
fun LeftSide(
    breakpoint: Breakpoint,
    onMenuClicked: () -> Unit
){
    Row (verticalAlignment = Alignment.CenterVertically){

        if (breakpoint <= Breakpoint.SM) {

            Image(
                modifier = Modifier
                    .cursor(Cursor.Pointer)
                    .margin(right = 15.px)
                    .onClick {
                        onMenuClicked()
                    }
                    .size(
                        if (breakpoint <= Breakpoint.ZERO) 25.px else 28.px
                    ),
                src = ResObject.Icon.hamburger,
                alt = "Logo Image"
            )

        }

        Image(
            modifier = LogoStyle.toModifier()
                .maxWidth(if (breakpoint <= Breakpoint.MD){
                    150.px
                }else{
                    if (breakpoint <= Breakpoint.LG){
                        250.px
                    }else{
                      300.px
                    }
                }),
            src = if (breakpoint <= Breakpoint.MD){
            ResObject.Image.logo
        }else{
            if (breakpoint <= Breakpoint.LG){
                ResObject.Image.logo
            }else{
                ResObject.Image.logo
            }
        },
            description = "logo icon",
        )
    }
}



@Composable
fun RightSide(breakpoint: Breakpoint){


    Row( modifier = Modifier
        .fillMaxSize()
        .borderRadius(r = 50.px)
        .backgroundColor(ThemeByKizito.White.rgb)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .borderRadius(r = 50.px)
                .backgroundColor(ThemeByKizito.Primary_ALPHA4.rgb)
                .padding(all = 20.px),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        )
        {


            Section.entries.toTypedArray().take(6).forEachIndexed { index, section ->

                val linkColor = remember(index) { mutableStateOf(ThemeByKizito.Secondary.rgb) }

                Box(
                    modifier = Modifier
                        .padding(right = 30.px, left = 0.px, top = 0.px, bottom = 0.px)
                ) {


                    A(
                        href = "/${section.path}",
                        attrs = Modifier
                            .textDecorationLine(TextDecorationLine.None)
                            .padding(all = 0.px)
                            .cursor(Cursor.Pointer)
                            .margin(all = 0.px)
                            .toAttrs {
                                onClick {
                                    it.preventDefault()
                                    it.stopPropagation()


                                    navigateScrollToSection(section.id)

                                }
                            }
                    )
                    {

                        P(
                            attrs = Modifier
                                .margin(all = 0.px)
                                .transition(Transition.Companion.of(property = "background", duration = 200.ms))
                                .color(linkColor.value)
                                .padding(all = 0.px)
                                .fontFamily(ConstantsObject.FONT_FAMILY)//,"sans-serif")
                                .fontSize(
                                    if (breakpoint <= Breakpoint.MD) {
                                        13.px
                                    } else {
                                        if (breakpoint <= Breakpoint.LG) {
                                            16.px
                                        } else {
                                            18.px
                                        }
                                    }
                                )
                                .fontStyle(FontStyle.Normal)
                                .fontWeight(FontWeight.Normal)
                                .whiteSpace(WhiteSpace.NoWrap)//  force single line
                                .overflow(Overflow.Hidden) // (optional) cut off overflow
                                .textOverflow(TextOverflow.Ellipsis)
                                .onMouseOut {
                                    linkColor.value = ThemeByKizito.Secondary.rgb
                                }
                                .onMouseEnter {
                                    linkColor.value = ThemeByKizito.Primary.rgb
                                }
                                .userSelect(UserSelect.None)
                                .toAttrs()
                        ) {
                            Text(value = section.title)

                        }

                    }


                }


            }

        }

    }
}