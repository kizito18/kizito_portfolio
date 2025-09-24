package com.binkes.kizito_portfolio.sections


import androidx.compose.runtime.*
import com.binkes.kizito_portfolio.components.PortfolioCard
import com.binkes.kizito_portfolio.components.SectionTitle
import com.binkes.kizito_portfolio.models.Portfolio
import com.binkes.kizito_portfolio.models.Section
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.styles.PortfolioArrowIconStyleForDesktop
import com.binkes.kizito_portfolio.styles.PortfolioArrowIconStyleForMobile
import com.binkes.kizito_portfolio.styles.PortfolioSectionStyleForDesktop
import com.binkes.kizito_portfolio.util.isDesktop
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun PortfolioSection(){

    Box(modifier = Modifier
        .id(Section.Portfolio.id)
        .fillMaxWidth()
        .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {

        PortfolioContent()

    }
}



@OptIn(DelicateApi::class)
@Composable
fun PortfolioContent(){

    val breakpoint = rememberBreakpoint()



    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        SectionTitle(
            modifier = Modifier
                .margin(bottom = 25.px),
            Section.Portfolio
        )


        PortfolioCards(
            breakpoint = breakpoint,
        )

    }

}


@Composable
fun PortfolioCards(
    breakpoint: Breakpoint,
){

    var showAllMyWorks by remember { mutableStateOf(true) }


    if (showAllMyWorks) {

        Column (modifier = Modifier
            .fillMaxWidth(
                if(breakpoint <= Breakpoint.ZERO) 98.percent else
               if(breakpoint <= Breakpoint.SM) 88.percent else
                   if(breakpoint <= Breakpoint.MD) 76.percent else 80.percent
            )
            .margin(bottom = 25.px)
        ) {

            ShowAllWorkText(
                breakpoint = breakpoint,
                showAllMyWorks = showAllMyWorks,
                onTextClicked = { isTrueFalse ->
                    showAllMyWorks = isTrueFalse
                }
            )


            SimpleGrid(
                numColumns = numColumns(base = 2, sm = 2, md =3),
                modifier = Modifier.fillMaxWidth()
            ) {

                Portfolio.entries.forEachIndexed { index, portfolio ->


                    Box(  modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            leftRight = if (breakpoint >= Breakpoint.XL) 30.px else
                                if (breakpoint >= Breakpoint.LG) 20.px else
                                    if (breakpoint >= Breakpoint.MD) 10.px else
                                        if (breakpoint >= Breakpoint.SM) 5.px else 10.px
                        )
                        .margin(bottom = if (breakpoint <= Breakpoint.ZERO) 25.px else
                            if (breakpoint <= Breakpoint.SM) 30.px else
                                if (breakpoint <= Breakpoint.MD) 40.px else
                                        if (breakpoint <= Breakpoint.LG) 46.px else 50.px
                        )
                        .transition(
                            Transition.of(
                                property = TransitionProperty.All,
                                duration = 300.ms,
                                timingFunction = null,
                                delay = null
                            )
                        )

                    ) {


                        PortfolioCard(
                            portfolio = portfolio,
                            index = index,
                            breakpoint = breakpoint,
                            isRow = if (showAllMyWorks) false else true,
                        )
                    }

                }
            }



        }

    }else{

        Column(modifier = Modifier
            .fillMaxWidth(
                if (breakpoint <= Breakpoint.ZERO) 90.percent else
                    if (breakpoint <= Breakpoint.SM) 80.percent else
                        if (breakpoint <= Breakpoint.MD) 76.percent else
                            if (breakpoint <= Breakpoint.LG) 70.percent else 67.percent
            )
            .alignSelf(AlignSelf.Center)


        ) {

            ShowAllWorkText(
                breakpoint = breakpoint,
                showAllMyWorks = showAllMyWorks,
                onTextClicked = { isTrueFalse ->
                    showAllMyWorks = isTrueFalse
                }
            )


            println(breakpoint.name)



                Row(
                    modifier = Modifier
                        .id("scrollableContainer")
                         .fillMaxWidth()
                        .margin(bottom = 25.px)
//                    .maxWidth(
//                        if (breakpoint > Breakpoint.MD) 950.px
//                        else if (breakpoint > Breakpoint.SM) 625.px
//                        else 300.px
//                    )

                        .overflow(Overflow.Scroll)
                        .scrollBehavior(ScrollBehavior.Smooth)
                        .styleModifier { // Hide scrollbar
                            property("overflow", "auto")
                            property("scrollbar-width", "none") // Firefox
                            property("-ms-overflow-style", "none") // IE and Edge
                            property("::-webkit-scrollbar", "display: none") // WebKit browsers
                        }
                ) {

                    Portfolio.entries.forEachIndexed { index, portfolio ->

                        PortfolioCard(
                            portfolio = portfolio,
                            index = index,
                            breakpoint = breakpoint,
                            isRow = if (showAllMyWorks) false else true
                        )


                    }

                }



        }

            PortfolioNavigation()




    }





}



@Composable
fun PortfolioNavigation() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        FaArrowLeft(
            modifier = Modifier
                .thenIf(
                    condition = isDesktop(),
                    other = PortfolioArrowIconStyleForDesktop.toModifier()
                )
                .thenIf(
                    condition = !isDesktop(),
                    other = PortfolioArrowIconStyleForMobile.toModifier()
                )
                .margin(right = 40.px)
                .cursor(Cursor.Pointer)
                .onClick {
                    document.getElementById("scrollableContainer")
                        ?.scrollBy(x = (-325.0), y = 0.0)
                },
            size = IconSize.LG
        )
        FaArrowRight(
            modifier = Modifier
                .thenIf(
                    condition = isDesktop(),
                    other = PortfolioArrowIconStyleForDesktop.toModifier()
                )
                .thenIf(
                    condition = !isDesktop(),
                    other = PortfolioArrowIconStyleForMobile.toModifier()
                )
                .cursor(Cursor.Pointer)
                .onClick {
                    document.getElementById("scrollableContainer")
                        ?.scrollBy(x = 325.0, y = 0.0)
                },
            size = IconSize.LG
        )
    }
}



@Composable
fun ShowAllWorkText(
    breakpoint: Breakpoint,
    showAllMyWorks: Boolean,
    onTextClicked: (isTrueFalse: Boolean) -> Unit
){

    val textColor = remember { mutableStateOf(ThemeByKizito.Blue.rgb) }


    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        P(
            attrs = Modifier
                .color(textColor.value)
                .fontSize(if(breakpoint <= Breakpoint.ZERO) 10.px else
                    if(breakpoint <= Breakpoint.SM) 12.px else
                        if(breakpoint <= Breakpoint.MD) 13.px else 15.px
                )
                .onClick {
                    onTextClicked(
                        !showAllMyWorks
                    )
                }
                .onMouseOut {
                    textColor.value = ThemeByKizito.Blue.rgb
                }
                .onMouseEnter {
                    textColor.value = ThemeByKizito.Secondary.rgb
                }
                .userSelect(UserSelect.None)
                .toAttrs()
        ) {
            //Text(if (showAllMyWorks) "Show less..." else "Show all..")
            Text("Change view")
        }
    }


}