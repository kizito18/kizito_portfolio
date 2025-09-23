package com.binkes.kizito_portfolio.sections


import androidx.compose.runtime.Composable
import com.binkes.kizito_portfolio.components.Header
import com.binkes.kizito_portfolio.components.RenderMarkdown
import com.binkes.kizito_portfolio.components.SocialBar
import com.binkes.kizito_portfolio.models.Section
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.pages.navigateScrollToSection
import com.binkes.kizito_portfolio.styles.MainButtonStyle
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.binkes.kizito_portfolio.util.ConstantsObject.MY_INTRO_TEXT
import com.binkes.kizito_portfolio.util.ResObject
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection( onMenuClicked: () -> Unit){




    Box(modifier = Modifier
        .id(Section.Home.id)
        .maxWidth(ConstantsObject.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {

        MainBackground()

        MainContent(
            onMenuClicked = {
                onMenuClicked()
            }
        )


    }


}



@Composable
fun MainBackground(){

    Image(
        modifier = Modifier
            .fillMaxSize()
            .objectFit(ObjectFit.Cover),
        src = ResObject.Image.background,
        description = "background image"
    )

}


@OptIn(DelicateApi::class)
@Composable
fun MainContent( onMenuClicked: () -> Unit){

    val breakpoint = rememberBreakpoint()


    Column(modifier = Modifier
        .fillMaxSize()
        .scrollBehavior(ScrollBehavior.Smooth),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {


        Header(
            onMenuClicked = {
                onMenuClicked()
            }
        )



        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SimpleGrid(
                modifier = Modifier
                    .fillMaxWidth( if (breakpoint <= Breakpoint.LG) 100.percent else 90.percent),
                numColumns = numColumns(base = 1, sm = 2)
            ){

                MainText(
                    breakpoint = breakpoint,
                    modifier = Modifier
                        .margin( left =
                            if (breakpoint <= Breakpoint.ZERO) 8.px else
                                if (breakpoint <= Breakpoint.SM) 8.px else 20.px,
                            right =   if (breakpoint <= Breakpoint.ZERO) 8.px else 0.px
                        )
                )

                MainImage(breakpoint = breakpoint)

            }

        }

    }
}




@Composable
fun MainText(
    breakpoint: Breakpoint,
             modifier: Modifier
){

    Row ( modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){

        if (breakpoint >= Breakpoint.MD) {
            SocialBar()
        }



        Column(modifier = Modifier
            .margin(right = if (breakpoint != Breakpoint.MD) 4.px else 8.px)
        ){

            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG)45.px else 20.px)
                    .fontWeight(FontWeight.Normal)
                    .color(ThemeByKizito.Primary.rgb)
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {
                Text("Hello, I'm")
            }

            P(
                attrs = Modifier
                    .margin(topBottom = if (breakpoint <= Breakpoint.ZERO) 14.px else
                        if (breakpoint <= Breakpoint.SM) 16.px else
                            if (breakpoint <= Breakpoint.MD) 18.px else 20.px

                    )
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(
                        if (breakpoint <= Breakpoint.ZERO) 30.px else
                            if (breakpoint <= Breakpoint.SM) 48.px else
                                if (breakpoint <= Breakpoint.MD) 52.px else
                                    if (breakpoint <= Breakpoint.LG) 62.px else 68.px
                    )
                    .fontWeight(FontWeight.Bolder)
                    .color(ThemeByKizito.Secondary.rgb)
                    .lineHeight(
                        if (breakpoint <= Breakpoint.ZERO) 38.px else
                            if (breakpoint <= Breakpoint.SM) 50.px else
                                if (breakpoint <= Breakpoint.MD) 56.px else
                                    if (breakpoint <= Breakpoint.LG) 62.px else 70.px
                    )
                    .whiteSpace(WhiteSpace.BreakSpaces)
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {
                Text("Kizito Okparanwankwo")
            }


            P(
                attrs = Modifier
                    .margin(top = 10.px, bottom = 5.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(
                        if (breakpoint <= Breakpoint.ZERO) 16.px else
                            if (breakpoint <= Breakpoint.SM) 17.px else
                                if (breakpoint <= Breakpoint.MD) 18.px else
                                    if (breakpoint <= Breakpoint.LG) 19.px else 20.px
                    )
                    .fontWeight(FontWeight.Bolder)
                    .color(ThemeByKizito.Secondary.rgb)
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {
                Text("Mobile & Web Developer")
            }



            RenderMarkdown(
                editText = MY_INTRO_TEXT,
                styleModifier = Modifier
                    .margin(bottom = 25.px)
                    .maxWidth(400.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(if (breakpoint <= Breakpoint.ZERO) 11.5.px else
                        if (breakpoint <= Breakpoint.SM) 13.5.px else
                            if (breakpoint <= Breakpoint.MD) 14.px else 15.px
                    )
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(FontWeight.Normal)
            )






            A(href = "/${Section.Contact.path}",
                attrs = Modifier
                    .textDecorationLine(TextDecorationLine.None)
                    .padding(all = 0.px)
                    .cursor(Cursor.Pointer)
                    .margin(all = 0.px)
                    .toAttrs{
                        onClick {
                            it.preventDefault()
                            it.stopPropagation()


                            navigateScrollToSection(Section.Contact.id)

                        }
                    }
            ) {

                Button (
                    attrs = MainButtonStyle.toModifier()
                        .height(if (breakpoint <= Breakpoint.ZERO) 34.px else
                            if (breakpoint <= Breakpoint.SM) 36.px else
                                if (breakpoint <= Breakpoint.MD) 38.px else 40.px)
                        .border(width = 0.px)
                        .borderRadius(r = 5.px)
                        .background(ThemeByKizito.Primary.rgb)
                        .color(Color.white)
                        .cursor(Cursor.Pointer)
                        .userSelect(UserSelect.None)
                        .toAttrs()
                ) {

                    Text(value = "Hire me")

                }

            }





        }

    }

}



@Composable
fun MainImage(
    breakpoint: Breakpoint,
){


        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .transition(Transition.of(property = "filter", duration = 200.ms))
                .overflow(Overflow.Hidden),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = if (breakpoint <= Breakpoint.SM) Alignment.End else Alignment.Start
        ) {


            if (breakpoint <= Breakpoint.SM) {

                Image(
                    modifier = Modifier
                    .fillMaxWidth()
                    .minHeight(370.px)
                    .objectFit(ObjectFit.Cover)
                        .borderRadius(bottomLeft = 20.percent, bottomRight = 15.percent),
                    src = ResObject.Image.main,
                    description = "Main Image"
                )
            }else{
                if (breakpoint <= Breakpoint.MD) {

                    Image(
                        modifier = Modifier
                             .fillMaxWidth()
                            .minHeight(800.px)
                            .objectFit(ObjectFit.Cover)
                            .borderRadius(bottomLeft = 20.percent, bottomRight = 15.percent),
                        src = ResObject.Image.main,
                        description = "Main Image"
                    )
                }else{


                    Image(
                        modifier = Modifier
                            .borderRadius(bottomLeft = 20.percent, bottomRight = 15.percent),
                        src = ResObject.Image.main,
                        description = "Main Image"
                    )


                }
            }

        }


}
