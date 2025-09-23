package com.binkes.kizito_portfolio.components


import androidx.compose.runtime.Composable
import com.binkes.kizito_portfolio.models.Service
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.styles.ServiceCardStyle
import com.binkes.kizito_portfolio.styles.showdownStyle
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun ServiceCard(
    service: Service,
    breakpoint: Breakpoint
){



    Column(modifier = ServiceCardStyle.toModifier()
        .maxWidth(if (breakpoint < Breakpoint.SM) 200.px else 300.px)
        .margin(all = if (breakpoint < Breakpoint.SM) 5.px else 20.px)
        .padding(all = if (breakpoint < Breakpoint.SM) 5.px else 20.px)
    ) {

        Box (modifier = Modifier
            .id("iconBox")
            .padding(all = if (breakpoint < Breakpoint.SM) 5.px else 10.px)
            .margin(bottom =if (breakpoint < Breakpoint.SM) 8.px else 20.px)
            .border(width = 2.px,
                style = LineStyle.Solid,
                color = ThemeByKizito.Primary.rgb
            )
            .borderRadius(
                topLeft = 20.px,
                topRight = 20.px,
                bottomLeft = 20.px,
                bottomRight = 0.px
            )
        ){

            Image(
                modifier = Modifier.size(if (breakpoint < Breakpoint.SM) 24.px else 40.px),
                src = service.icon,
                description = service.imageDesc
            )

        }

        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 10.px)
                .fontFamily(ConstantsObject.FONT_FAMILY)
                .fontSize(
                    if (breakpoint <= Breakpoint.ZERO) 12.px else
                    if (breakpoint <= Breakpoint.SM) 15.px else
                        if (breakpoint <= Breakpoint.MD) 16.px else
                            if (breakpoint <= Breakpoint.LG) 17.px else 18.px
                )
                .fontWeight(FontWeight.Bold)
                .userSelect(UserSelect.None)
                .toAttrs()
        ) {
            Text(service.title)
        }


        RenderMarkdown(
            editText = service.description,
            styleModifier = showdownStyle.toModifier()
                .margin(topBottom = 0.px)
                .fillMaxWidth()
                .fontFamily(ConstantsObject.FONT_FAMILY)
                .fontSize(
                        if (breakpoint <= Breakpoint.SM) 11.px else
                            if (breakpoint <= Breakpoint.MD) 12.px else
                                if (breakpoint <= Breakpoint.LG) 13.px else 14.px
                )
                .fontWeight(FontWeight.Normal)
                .color(ThemeByKizito.TextBlue.rgb)
        )


    }

}