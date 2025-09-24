package com.binkes.kizito_portfolio.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.css.functions.grayscale
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


val AboutImageStyleForDesktop = CssStyle {
    base {
        Modifier
            .filter(grayscale(100.percent))
            .borderRadius(r = 0.px)
            .rotate(0.deg)
            .transition(Transition.of(property = TransitionProperty.All, duration = 200.ms))

    }

    hover{
        Modifier
            .filter(grayscale(0.percent))
            .borderRadius(r = 100.px)
            .rotate(2.deg)

    }
}


val AboutImageStyleForMobile = CssStyle {
    base {
        Modifier
            .filter(grayscale(100.percent))
            .borderRadius(r = 0.px)
            .rotate(0.deg)
            .transition(Transition.of(property = TransitionProperty.All, duration = 200.ms))

    }

    active{
        Modifier
            .filter(grayscale(0.percent))
            .borderRadius(r = 100.px)
            .rotate(2.deg)

    }
}






val AboutTextStyleForDesktop = CssStyle {
    base {
        Modifier
            .opacity(50.percent)
            .transition(Transition.of(property = "opacity", duration = 200.ms))

    }

    hover{
        Modifier
            .opacity(100.percent)

    }
}


val AboutTextStyleForMobile = CssStyle {
    base {
        Modifier
            .opacity(50.percent)
            .transition(Transition.of(property = "opacity", duration = 200.ms))

    }

    active{
        Modifier
            .opacity(100.percent)

    }
}




