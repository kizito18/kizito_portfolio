package com.binkes.kizito_portfolio.styles

import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.px


val showdownStyle = CssStyle {



    //  Ordered list styling
    cssRule("ol li::marker") {
        Modifier.fontWeight(FontWeight.Bold)
    }

    // Ordered list
    cssRule("ol") {
        Modifier
            .margin(0.px)
            .padding(left = 0.px)
            .lineHeight(1.5)
    }


    // Unordered list
    cssRule("ul li::marker") {
        Modifier.fontWeight(FontWeight.Bold)
    }

    // Unordered list styling
    cssRule("ul") {
        Modifier
            .margin(0.px)
            .padding(left = 0.px)
            .lineHeight(1.5)
    }

}


