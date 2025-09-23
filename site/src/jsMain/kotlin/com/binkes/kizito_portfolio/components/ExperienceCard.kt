package com.binkes.kizito_portfolio.components


import androidx.compose.runtime.Composable
import com.binkes.kizito_portfolio.models.Experience
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.styles.showdownStyle
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun ExperienceCard(
    breakpoint: Breakpoint,
    isActive: Boolean = false,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {

    SimpleGrid(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(
                if (breakpoint >= Breakpoint.MD)60.percent
                else 90.percent
            ),
        numColumns = numColumns(base = 1, md = 2)
    ){

        ExperienceDescription(
            isActive = isActive,
            description = experience.description,
            breakpoint = breakpoint
        )

        ExperienceDetails(
            breakpoint = breakpoint,
            isActive = isActive,
            experience = experience,
            animatedMargin = animatedMargin
        )


    }


}



@Composable
fun ExperienceDescription(
    isActive: Boolean = false,
    description: String,
    breakpoint: Breakpoint
) {



    Box(modifier = Modifier
        .fillMaxWidth()
        .margin(top = if(breakpoint <= Breakpoint.SM)25.px else 14.px,
            bottom = if(breakpoint <= Breakpoint.SM)8.px else 14.px
        )
        .padding(all = 14.px)
        .backgroundColor(if (isActive) ThemeByKizito.DEEP_GREEN_ALPHA.rgb else ThemeByKizito.LighterGray.rgb)
    ) {



        RenderMarkdown(
            editText = description,
            styleModifier = showdownStyle.toModifier()
                .margin(topBottom = 0.px)
                .fontFamily(ConstantsObject.FONT_FAMILY)
                .fontSize(

                    if (breakpoint <= Breakpoint.ZERO) 11.px else
                        if (breakpoint <= Breakpoint.SM) 12.px else
                            if (breakpoint <= Breakpoint.MD) 13.px else 14.px

                )
                .fontWeight(FontWeight.Normal)
                .color(if (isActive) Color.white else ThemeByKizito.Secondary.rgb)


        )


    }


}


@Composable
fun ExperienceDetails(
    breakpoint: Breakpoint,
    isActive: Boolean,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .margin(left = if (breakpoint >= Breakpoint.MD)14.px else 0.px),
        verticalAlignment = Alignment.CenterVertically
    ){

        if (breakpoint >= Breakpoint.MD) {

            ExperienceNumber(
                isActive = isActive,
                experience = experience
            )

        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .margin(left = if(breakpoint <= Breakpoint.SM) 0.px else animatedMargin )
                .transition(
                    Transition.Companion.of(property = "margin",
                        duration = 200.ms,
                        delay = experience.ordinal * 100.ms)


                ),
            verticalArrangement = Arrangement.Center
        ){


            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(if (breakpoint <= Breakpoint.ZERO) 14.px else
                        if (breakpoint <= Breakpoint.SM) 16.px else
                            if (breakpoint <= Breakpoint.MD) 18.px else 20.px
                    )
                    .fontWeight(FontWeight.Bold)
                    .color( ThemeByKizito.Secondary.rgb)
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {
                Text(experience.jobPosition)
            }


            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(if (breakpoint <= Breakpoint.ZERO) 11.px else
                        if (breakpoint <= Breakpoint.SM) 12.px else
                            if (breakpoint <= Breakpoint.MD) 13.px else 14.px
                    )
                    .fontWeight(FontWeight.Normal)
                    .color( ThemeByKizito.Secondary.rgb)
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {
                Text("${experience.from} - ${experience.to}")
            }


            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(if (breakpoint <= Breakpoint.ZERO) 11.px else
                        if (breakpoint <= Breakpoint.SM) 12.px else
                            if (breakpoint <= Breakpoint.MD) 13.px else 14.px
                    )
                    .fontWeight(FontWeight.Normal)
                    .color( ThemeByKizito.Primary.rgb)
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {
                Text(experience.company)
            }




        }

    }



}






@Composable
fun ExperienceNumber(
    isActive: Boolean,
    experience: Experience
) {


    Box(
        modifier = Modifier
            .margin(right = 14.px)
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(3.px)
                .backgroundColor(ThemeByKizito.Primary.rgb)
        )

        Box(
            modifier = Modifier
                .size(40.px)
                .border(
                    width = 3.px,
                    style = LineStyle.Solid,
                    color = ThemeByKizito.Primary.rgb
                )
                .backgroundColor(if (isActive) ThemeByKizito.Primary.rgb else Color.white)
                .borderRadius(50.px),
            contentAlignment = Alignment.Center
        ) {


            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Bold)
                    .color(if (isActive) Color.white else ThemeByKizito.Primary.rgb)
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {
                Text(experience.number)
            }

        }

    }

}