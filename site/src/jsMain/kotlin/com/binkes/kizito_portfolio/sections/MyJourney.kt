package com.binkes.kizito_portfolio.sections

import androidx.compose.runtime.Composable
import com.binkes.kizito_portfolio.components.RenderMarkdown
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.binkes.kizito_portfolio.util.ConstantsObject.MY_JOURNEY_TEXT
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


@OptIn(DelicateApi::class)
@Composable
fun MyJourney(){


    val breakpoint = rememberBreakpoint()

    Column(modifier = Modifier
        .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 90.percent
        else 100.percent)
        .margin(bottom = 20.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        RenderMarkdown(
            editText = MY_JOURNEY_TEXT,
            styleModifier = Modifier
                .margin(topBottom = 0.px)
                .fillMaxWidth(if (breakpoint <= Breakpoint.ZERO) 97.percent else
                    if (breakpoint <= Breakpoint.SM) 95.percent else
                        if (breakpoint <= Breakpoint.MD) 90.percent else 80.percent
                )
                .fontFamily(ConstantsObject.FONT_FAMILY)
                .fontSize(
                if (breakpoint <= Breakpoint.ZERO) 13.5.px else
                    if (breakpoint <= Breakpoint.SM) 16.px else
                        if (breakpoint <= Breakpoint.MD) 19.px else
                            if (breakpoint <= Breakpoint.LG) 19.5.px else 20.px
            )
                .fontWeight(FontWeight.Normal)
                .color(ThemeByKizito.TextBlue.rgb)
        )



    }


}