package com.binkes.kizito_portfolio.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.focus
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms

val ArrowBackStyleForDesktop = CssStyle {
    base {
        Modifier
            .scale(1f)
            .transition(Transition.of(property = "translate", duration = 200.ms))

    }

    hover{
        Modifier
            .scale(0.9f)
            .transition(Transition.of(property = "translate", duration = 200.ms))

    }


}


val ArrowBackStyleForMobile = CssStyle {
    base {
        Modifier
            .scale(1f)
            .transition(Transition.of(property = "translate", duration = 200.ms))

    }

    active{
        Modifier
            .scale(0.9f)
            .transition(Transition.of(property = "translate", duration = 200.ms))
    }

}