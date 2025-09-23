package com.binkes.kizito_portfolio.styles

import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms


val VisitProjectStyle = CssStyle {
    base {
        Modifier
            .background(Color.transparent)
            .scale(1f)
            .transition(Transition.of(property = "translate", duration = 100.ms))
            .transition(Transition.of(property = "background", duration = 200.ms))

    }

    hover{
        Modifier
            .background(ThemeByKizito.Primary_ALPHA3.rgb)
            .scale(0.94f)
            .transition(Transition.of(property = "translate", duration = 200.ms))
            .transition(Transition.of(property = "background", duration = 200.ms))

    }
}
