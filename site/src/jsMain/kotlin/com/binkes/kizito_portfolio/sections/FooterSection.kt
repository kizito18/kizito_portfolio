package com.binkes.kizito_portfolio.sections


import androidx.compose.runtime.Composable
import com.binkes.kizito_portfolio.components.SocialBar
import com.binkes.kizito_portfolio.models.Section
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.pages.navigateScrollToSection
import com.binkes.kizito_portfolio.styles.NavigationItemStyle
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.binkes.kizito_portfolio.util.ResObject
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.UserSelect
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
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text


@OptIn(DelicateApi::class)
@Composable
fun FooterSection(
    isFromInfoScreen: Boolean
){

    val breakpoint = rememberBreakpoint()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(topBottom = if (breakpoint <= Breakpoint.ZERO) 40.px else
                if (breakpoint <= Breakpoint.SM) 60.px else
                    if (breakpoint <= Breakpoint.MD) 70.px else 80.px
            )
            .backgroundColor(ThemeByKizito.LighterGray.rgb),
        contentAlignment = Alignment.Center
    ) {

        FooterContent(
            breakpoint = breakpoint,
            isFromInfoScreen = isFromInfoScreen
        )

    }


}




@Composable
fun FooterContent(
    breakpoint: Breakpoint,
    isFromInfoScreen: Boolean
) {


    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint <= Breakpoint.ZERO) 90.percent else
                    if (breakpoint <= Breakpoint.SM) 80.percent else
                        if (breakpoint <= Breakpoint.MD) 50.percent else 40.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .size(100.px)
                 // Disable right-click / long-press
                .onContextMenu { event ->
                    event.preventDefault()
                    event.stopPropagation()
                },
            src = ResObject.Image.logo,
            description = "Logo Image"
        )

        if (!isFromInfoScreen) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                FooterMenu(
                    breakpoint = breakpoint
                )
            }

        }


        SocialBar(
            isRow = true
        )

    }

}


@Composable
fun FooterMenu(
    isRow: Boolean = true,
    breakpoint: Breakpoint
){




Section.entries.take(6).forEach { section->



    A(href = "/${section.path}",
        attrs = NavigationItemStyle.toModifier()
            .cursor(Cursor.Pointer)
            .fontFamily(ConstantsObject.FONT_FAMILY)
            .padding(
                right = if (isRow){
                    if (breakpoint <= Breakpoint.ZERO) 8.px else
                        if (breakpoint <= Breakpoint.SM) 15.px else 20.px
                } else {
                    0.px
                },
                bottom = if (isRow){
                    0.px
                } else {
                    if (breakpoint <= Breakpoint.ZERO) 8.px else
                        if (breakpoint <= Breakpoint.SM) 15.px else 20.px
                }
            )
            .fontSize(if (breakpoint <= Breakpoint.ZERO) 8.px else
                if (breakpoint <= Breakpoint.SM) 11.px else 12.px
            )
            .fontWeight(FontWeight.Normal)
            .textDecorationLine(TextDecorationLine.None)
            .userSelect(UserSelect.None)
            .toAttrs{
                onClick {
                    it.preventDefault()
                    it.stopPropagation()

                    navigateScrollToSection(section.id)


                }

            }
    ) {

        Text(value = section.title)

    }


}



}