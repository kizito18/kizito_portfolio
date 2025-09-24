package com.binkes.kizito_portfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.binkes.kizito_portfolio.models.Portfolio
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.styles.PortfolioSectionStyleForDesktop
import com.binkes.kizito_portfolio.styles.PortfolioSectionStyleForMobile
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.binkes.kizito_portfolio.util.ResObject
import com.binkes.kizito_portfolio.util.isDesktop
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun PortfolioCard(
    portfolio: Portfolio,
    index: Int,
    breakpoint: Breakpoint,
    isRow: Boolean,
){


    A(href = "/info/${portfolio.documentId}/",
        attrs = Modifier
            .thenIf(
                condition = isDesktop(),
                other = PortfolioSectionStyleForDesktop.toModifier()
            )
            .thenIf(
                condition = !isDesktop(),
                other = PortfolioSectionStyleForMobile.toModifier()
            )
            .cursor(Cursor.Pointer)
            .thenIf(
                condition = isRow,
                other = Modifier
                    .margin(right = if (index != Portfolio.entries.lastIndex){

                        if (breakpoint <= Breakpoint.ZERO) 10.px else
                            if (breakpoint <= Breakpoint.SM) 20.px else 25.px

                    } else{
                        0.px
                    }
                    )
            )
            .textDecorationLine(TextDecorationLine.None)
            .toAttrs{
                /*
                onClick {
                   it.preventDefault()
                  it.stopPropagation()

                   window.location.href = "/info/${portfolio.documentId}"

                }

                 */

                // Disable right-click / long-press
                onContextMenu { event ->
                    event.preventDefault()
                    event.stopPropagation()
                }


            }
    ) {



        Column(modifier = Modifier
            .id("columnParent")

            .thenIf(
                condition = isRow,
                other = Modifier
                    .width(
                        if (breakpoint <= Breakpoint.ZERO) 30.vw else
                            if (breakpoint <= Breakpoint.SM) 20.vw else
                                if (breakpoint <= Breakpoint.MD) 24.vw else 28.vw
                    )
            )
            .thenIf(
                condition = !isRow,
                other = Modifier.fillMaxWidth()
            )

        ) {

            Box(modifier = Modifier
                .id("boxParent")
                .thenIf(
                    condition = isRow,
                    other = Modifier
                        .margin(bottom = 15.px)
                )
                .thenIf(
                    condition = !isRow,
                    other = Modifier
                        .fillMaxWidth()
                        .margin(bottom = 8.px)
                )
            ) {

                Image(
                    modifier = Modifier
                        .thenIf(
                            condition = isRow,
                            other = Modifier
                                .fillMaxWidth()
                                .height(
                                    if(breakpoint <= Breakpoint.ZERO) 180.px else
                                        if (breakpoint <= Breakpoint.SM) 220.px else
                                            if (breakpoint <= Breakpoint.MD) 250.px else 300.px
                                )
//                                .size(
//                                    if(breakpoint <= Breakpoint.ZERO) 47.vw else
//                                        if (breakpoint <= Breakpoint.SM) 40.vw else 300.px
//                                )
                        )
                        .thenIf(
                            condition = !isRow,
                            other = Modifier
                                .fillMaxWidth()
                                .height(
                                    if(breakpoint <= Breakpoint.ZERO) 200.px else
                                        if (breakpoint <= Breakpoint.SM) 250.px else 300.px
                                )
                        )
                        .objectFit(ObjectFit.Cover),
                    src = portfolio.thumbnail,
                    description = "Portfolio Image"

                )

                Box(  modifier = Modifier
                    .id("greenOverlay")


                    .thenIf(
                        condition = isRow,
                        other = Modifier
                            .fillMaxHeight()
                    )
                    .thenIf(
                        condition = !isRow,
                        other = Modifier
                            .height(
                                if(breakpoint <= Breakpoint.ZERO) 200.px else
                                    if (breakpoint <= Breakpoint.SM) 250.px else 300.px
                            )
                    )
                    //.backgroundColor(ThemeByKizito.Primary_ALPHA.rgb),
                    .backgroundColor(argb(a = 0.5f, r = 0, g = 167, b = 142)),
                    contentAlignment = Alignment.Center
                ) {


                    Image(
                        modifier = Modifier
                            .id("linkIcon")
                            .size(if (breakpoint <= Breakpoint.ZERO) 26.px else
                                if (breakpoint <= Breakpoint.SM) 28.px else
                                    if (breakpoint <= Breakpoint.MD) 30.px else 32.px
                            )
                            .objectFit(ObjectFit.Cover),
                        src = ResObject.Icon.link,
                        description = "Link Icon"
                    )


                }
            }

            P(
                attrs = Modifier
                    .id("portfolioTitle")
                    .width(Width.FitContent)
                    .margin(top = 0.px , bottom = 5.px, left = 0.px,right = 0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .thenIf(
                        condition = isRow,
                        other = Modifier
                            .fontSize(
                                if (breakpoint <= Breakpoint.ZERO) 11.px else
                                    if (breakpoint <= Breakpoint.SM) 14.px else
                                        if (breakpoint <= Breakpoint.MD) 15.px else
                                            if (breakpoint <= Breakpoint.LG) 16.px else 17.px
                            )
                            .lineHeight(
                                if (breakpoint <= Breakpoint.ZERO) 12.px else
                                    if (breakpoint <= Breakpoint.SM) 15.px else
                                        if (breakpoint <= Breakpoint.MD) 16.px else
                                            if (breakpoint <= Breakpoint.LG) 17.px else 18.px
                            )
                    )
                    .thenIf(
                        condition = !isRow,
                        other = Modifier
                            .fontSize(
                                if (breakpoint <= Breakpoint.ZERO) 12.px else
                                    if (breakpoint <= Breakpoint.SM) 15.px else
                                        if (breakpoint <= Breakpoint.MD) 16.px else
                                            if (breakpoint <= Breakpoint.LG) 17.px else 18.px
                            )
                            .lineHeight(
                                if (breakpoint <= Breakpoint.ZERO) 13.px else
                                    if (breakpoint <= Breakpoint.SM) 16.px else
                                        if (breakpoint <= Breakpoint.MD) 17.px else
                                            if (breakpoint <= Breakpoint.LG) 18.px else 19.px
                            )
                    )
                    .fontWeight(
                        if (breakpoint <= Breakpoint.ZERO) FontWeight.Medium else
                        if (breakpoint <= Breakpoint.SM) FontWeight.SemiBold else FontWeight.Bold
                    )
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {
                Text(portfolio.title)
            }


            P(
                attrs = Modifier
                    .id("portfolioDesc")
                    .width(Width.FitContent)
                    .margin(0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .thenIf(
                        condition = isRow,
                        other = Modifier
                            .fontSize(
                                if (breakpoint <= Breakpoint.SM) 10.px else
                                    if (breakpoint <= Breakpoint.MD) 11.px else
                                        if (breakpoint <= Breakpoint.LG) 13.px else 12.px
                            )
                            .lineHeight(
                                if (breakpoint <= Breakpoint.SM) 11.px else
                                    if (breakpoint <= Breakpoint.MD) 12.px else
                                        if (breakpoint <= Breakpoint.LG) 14.px else 13.px
                            )
                    )
                    .thenIf(
                        condition = !isRow,
                        other = Modifier
                            .fontSize(
                                if (breakpoint <= Breakpoint.SM) 11.px else
                                    if (breakpoint <= Breakpoint.MD) 12.px else
                                        if (breakpoint <= Breakpoint.LG) 13.px else 14.px
                            )
                            .lineHeight(
                                if (breakpoint <= Breakpoint.SM) 12.px else
                                    if (breakpoint <= Breakpoint.MD) 13.px else
                                        if (breakpoint <= Breakpoint.LG) 14.px else 15.px
                            )
                    )
                    .fontWeight(FontWeight.Normal)
                    .color(ThemeByKizito.Secondary.rgb)
                    .opacity(50.percent)
                    .overflow(Overflow.Hidden)
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {

                Div(
                    attrs = Modifier
                        .maxWidth(98.percent)
                        .userSelect(UserSelect.None)
                        .styleModifier {

                            property("overflow", "hidden")
                            property("text-overflow", "ellipsis")
                            property("display", "-webkit-box")
                            property("-webkit-line-clamp", "2") // Limit to 2 lines
                            property("-webkit-box-orient", "vertical")

                        }
                        .toAttrs()
                ) {
                    val descriptionNoAsterisks = remember { portfolio.description.replace(Regex("\\*+"), "")  }
                    Text(descriptionNoAsterisks)
                }

            }

        }


    }

}