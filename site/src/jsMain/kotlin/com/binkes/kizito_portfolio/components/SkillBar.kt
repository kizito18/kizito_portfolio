package com.binkes.kizito_portfolio.components


import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun SkillBar(
    name: String,
    index: Int,
    percentage: CSSSizeValue<CSSUnit.percent>,
    animatedPercentage: Int,
    breakpoint: Breakpoint
){

    val progressBarHeight by remember { derivedStateOf {
        if (breakpoint <= Breakpoint.ZERO)  2.px else
            if (breakpoint <= Breakpoint.SM) 3.px else
                if (breakpoint <= Breakpoint.MD) 4.px else 5.px
    } }

    Column(modifier = Modifier
        .fillMaxWidth()
        .margin(bottom = if (breakpoint <= Breakpoint.ZERO)  4.px else
            if (breakpoint <= Breakpoint.SM) 6.px else
                if (breakpoint <= Breakpoint.MD) 8.px else 10.px
        )
        .maxWidth(500.px)
        .padding(topBottom = 5.px)
    ) {

        Row (modifier = Modifier
            .fillMaxWidth()
            .margin(bottom = if (breakpoint <= Breakpoint.ZERO)  2.px else
                if (breakpoint <= Breakpoint.SM) 3.px else
                    if (breakpoint <= Breakpoint.MD) 4.px else 5.px
            ),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
           P (
               attrs = Modifier
                   .margin(topBottom = 0.px)
                   .fontFamily(ConstantsObject.FONT_FAMILY)
                   .fontSize(if (breakpoint <= Breakpoint.ZERO)  12.5.px else
                       if (breakpoint <= Breakpoint.SM) 14.px else
                           if (breakpoint <= Breakpoint.MD) 16.px else 18.px
                   )
                   .fontWeight(FontWeight.Normal)
                   .color(ThemeByKizito.Secondary.rgb)
                   .userSelect(UserSelect.None)
                   .toAttrs()
           ){

               Text(name)

           }

            P (
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(if (breakpoint <= Breakpoint.ZERO)  12.5.px else
                            if (breakpoint <= Breakpoint.SM) 14.px else
                                if (breakpoint <= Breakpoint.MD) 16.px else 18.px
                    )
                    .fontWeight(FontWeight.Normal)
                    .color(ThemeByKizito.Secondary.rgb)
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ){

                Text("$animatedPercentage%")

            }
        }

        Box(modifier = Modifier
            .fillMaxWidth()
        ) {

            Box(modifier = Modifier
                .fillMaxWidth()
                .height( progressBarHeight)
                .backgroundColor(ThemeByKizito.LightGray.rgb)
            )

            Box(modifier = Modifier
                .fillMaxWidth(percentage)
                .height(progressBarHeight)
                .backgroundColor(ThemeByKizito.Primary.rgb)

                .transition(
                    Transition.Companion.of(property = "width", duration = 1000.ms, delay = 100.ms * index)
                )

            )

        }

    }


}