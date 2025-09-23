package com.binkes.kizito_portfolio.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.rgba


enum class ThemeByKizito(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(hex = "#CB7154", rgb = rgb(r = 203, g = 113, b = 84)),
    Secondary(hex = "#121D34", rgb = rgb(r = 18, g = 29, b = 52)),
    Gray(hex = "#CFCFCF", rgb = rgb(r = 207, g = 207, b = 207)),
    LightGray(hex = "#EDEDED", rgb = rgb(r = 237, g = 237, b = 237)),
    LighterGray(hex = "#F9F9F9", rgb = rgb(r = 249, g = 249, b = 249)),
    White(hex = "#FFFFFF",rgb = rgb(r = 255, g = 255, b = 255)),

    TextBlue (hex = "#242424", rgb = rgb(r = 36, g = 36, b = 100)),

     DEEP_GREEN_ALPHA (hex = "#276221",  rgba(r = 39, g = 98, b = 33, a = 0.7)),

    Blue(hex = "#2C71F4",  rgb = rgb(r = 44, g = 133, b = 244)),

    Primary_ALPHA1(hex = "#CB7154", rgb = rgba(r = 203, g = 113, b = 84, a = 0.04f)),

    Primary_ALPHA2(hex = "#CB7154", rgb = rgba(r = 203, g = 113, b = 84, a = 0.1f)),

    Primary_ALPHA3(hex = "#CB7154", rgb = rgba(r = 203, g = 113, b = 84, a = 0.2f)),

    Primary_ALPHA4(hex = "#CB7154", rgb = rgba(r = 203, g = 113, b = 84, a = 0.02f)),

    HEADER_COLOR(hex = "#FDFAF9", rgb = rgb(r = 253, g = 250, b = 249)),



}