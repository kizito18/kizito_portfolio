package com.binkes.kizito_portfolio.styles

import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px



val PortfolioSectionStyleForDesktop = CssStyle {
    cssRule(" > #columnParent > #boxParent > #greenOverlay") {
        Modifier
            .width(0.px)
            .transition(Transition.of(property = "width", duration = 500.ms))
    }

    cssRule(":hover > #columnParent > #boxParent > #greenOverlay") {
        Modifier.fillMaxWidth()//width(300.px)
    }

    cssRule(" > #columnParent > #boxParent > #greenOverlay > #linkIcon") {
        Modifier.visibility(Visibility.Hidden)
    }

    cssRule(":hover > #columnParent > #boxParent > #greenOverlay > #linkIcon") {
        Modifier.visibility(Visibility.Visible)
    }

    cssRule(" > #columnParent > #portfolioTitle") {
        Modifier
            .color(ThemeByKizito.Secondary.rgb)
            .translateX(0.percent)
            .transition(
                Transition.of(property = "color", duration = 200.ms),
                Transition.of(property = "translate", duration = 200.ms)
            )
    }

    cssRule(":hover > #columnParent > #portfolioTitle") {
        Modifier
            .color(ThemeByKizito.Primary.rgb)
            .translateX(5.percent)
    }

    cssRule(" > #columnParent > #portfolioDesc") {
        Modifier
            .translateX(0.percent)
            .transition(Transition.of(property = "translate", duration = 200.ms))
    }

    cssRule(":hover > #columnParent > #portfolioDesc") {
        Modifier.translateX(5.percent)
    }
}




val PortfolioSectionStyleForMobile = CssStyle {
    // Base green overlay
    cssRule(" > #columnParent > #boxParent > #greenOverlay") {
        Modifier
            .width(0.px)
            .transition(Transition.of(property = "width", duration = 500.ms))
    }

    // Expand overlay on hover OR active
    cssRule(//":hover > #columnParent > #boxParent > #greenOverlay, " +
            ":active > #columnParent > #boxParent > #greenOverlay") {
        Modifier.fillMaxWidth()
    }

    // Hide link icon initially
    cssRule(" > #columnParent > #boxParent > #greenOverlay > #linkIcon") {
        Modifier.visibility(Visibility.Hidden)
    }

    // Show icon on hover OR active
    cssRule(//":hover > #columnParent > #boxParent > #greenOverlay > #linkIcon, " +
            ":active > #columnParent > #boxParent > #greenOverlay > #linkIcon") {
        Modifier.visibility(Visibility.Visible)
    }

    // Portfolio title default
    cssRule(" > #columnParent > #portfolioTitle") {
        Modifier
            .color(ThemeByKizito.Secondary.rgb)
            .translateX(0.percent)
            .transition(
                Transition.of(property = "color", duration = 200.ms),
                Transition.of(property = "translate", duration = 200.ms)
            )
    }

    // Title hover OR active
    cssRule(//":hover > #columnParent > #portfolioTitle, " +
            ":active > #columnParent > #portfolioTitle") {
        Modifier
            .color(ThemeByKizito.Primary.rgb)
            .translateX(5.percent)
    }

    // Portfolio description default
    cssRule(" > #columnParent > #portfolioDesc") {
        Modifier
            .translateX(0.percent)
            .transition(Transition.of(property = "translate", duration = 200.ms))
    }

    // Description hover OR active
    cssRule(//":hover > #columnParent > #portfolioDesc, " +
            ":active > #columnParent > #portfolioDesc") {
        Modifier.translateX(5.percent)
    }
}


val PortfolioArrowIconStyleForDesktop = CssStyle {
    base {
        Modifier
            .color(ThemeByKizito.Gray.rgb)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }

    hover {
        Modifier.color(ThemeByKizito.Primary.rgb)
    }
}


val PortfolioArrowIconStyleForMobile = CssStyle {
    base {
        Modifier
            .color(ThemeByKizito.Gray.rgb)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }

    active {
        Modifier.color(ThemeByKizito.Primary.rgb)
    }
}