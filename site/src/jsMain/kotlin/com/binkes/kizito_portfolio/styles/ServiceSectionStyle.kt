package com.binkes.kizito_portfolio.styles

import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px


val ServiceCardStyle = CssStyle {
    base {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = ThemeByKizito.LighterGray.rgb
            )
            .backgroundColor(Color.white)
            .transition(Transition.of(property = "border", duration = 200.ms))
            .transition(Transition.of(property = "background", duration = 200.ms))

    }

    hover{
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = ThemeByKizito.Primary.rgb
            )
            .backgroundColor(ThemeByKizito.Primary.rgb)

    }

    cssRule(" > #iconBox"){
        Modifier.backgroundColor(Color.transparent)
            .transition(Transition.of(property = "background", duration = 200.ms))

    }

    cssRule(":hover > #iconBox"){
        Modifier.backgroundColor(Color.white)

    }

    cssRule(" > p"){
        Modifier.color(ThemeByKizito.Secondary.rgb)
            .transition(Transition.of(property = "color", duration = 200.ms))

    }

    cssRule(":hover > p"){
        Modifier.color(Color.white)

    }

}