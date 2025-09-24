package com.binkes.kizito_portfolio.components

import androidx.compose.runtime.Composable
import com.binkes.kizito_portfolio.models.Achievement
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun AchievementCard(
    modifier: Modifier = Modifier,
    breakpoint: Breakpoint,
    animatedNumber: Int,
    achievement: Achievement
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier
                .size(if (breakpoint <= Breakpoint.ZERO)  40.px else
                    if (breakpoint <= Breakpoint.SM) 50.px else
                        if (breakpoint <= Breakpoint.MD) 58.px else 70.px
                )
                .margin(right = if (breakpoint <= Breakpoint.ZERO)  14.px else
                    if (breakpoint <= Breakpoint.SM) 16.px else
                        if (breakpoint <= Breakpoint.MD) 17.px else 20.px
                ),
            src = achievement.icon,
            alt = "Achievement Icon"
        )
        Column {
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(
                        if (breakpoint <= Breakpoint.ZERO)  24.px else
                            if (breakpoint <= Breakpoint.SM) 26.px else
                                if (breakpoint <= Breakpoint.MD) 28.px else 30.px
                    )
                    .fontWeight(FontWeight.Bolder)
                    .color(ThemeByKizito.Primary.rgb)
                    .userSelect(UserSelect.None)
                     // Disable right-click / long-press
                    .onContextMenu { event ->
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    .toAttrs()
            ) {
                Text(
                    if (achievement == Achievement.Completed)
                        "${animatedNumber}+" else "$animatedNumber"
                )
            }
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(
                        if (breakpoint <= Breakpoint.ZERO)  13.px else
                            if (breakpoint <= Breakpoint.SM) 14.px else
                                if (breakpoint <= Breakpoint.MD) 15.px else 16.px
                    )
                    .fontWeight(FontWeight.Normal)
                    .color(ThemeByKizito.Secondary.rgb)
                    .opacity(50.percent)
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {
                Text(achievement.description)
            }
        }
    }
}