package com.binkes.kizito_portfolio.sections


import androidx.compose.runtime.*
import com.binkes.kizito_portfolio.components.AchievementCard
import com.binkes.kizito_portfolio.models.Achievement
import com.binkes.kizito_portfolio.models.Section
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.util.ConstantsObject.SECTION_WIDTH
import com.binkes.kizito_portfolio.util.ObserveViewportEntered
import com.binkes.kizito_portfolio.util.animatedNumbers
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.px


@OptIn(DelicateApi::class)
@Composable
fun AchievementsSection(){

    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .id(Section.Achievements.id)
            .fillMaxWidth()
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = if (breakpoint <= Breakpoint.ZERO) 60.px else
                if (breakpoint <= Breakpoint.SM) 70.px else
                    if (breakpoint <= Breakpoint.MD) 80.px else 100.px
            )
            .backgroundColor(ThemeByKizito.LighterGray.rgb),
        contentAlignment = Alignment.Center
    ) {
        AchievementsContent(breakpoint = breakpoint)
    }

}



@Composable
fun AchievementsContent(breakpoint: Breakpoint) {
    val scope = rememberCoroutineScope()
    var isViewportEntered by remember{ mutableStateOf(false) }
    val numberToAnimate = remember { mutableStateListOf(0, 0, 0, 0) }
    ObserveViewportEntered(
        sectionId = Section.Achievements.id,
        distanceFromTop = 700.0,
        onViewportEntered = {
            isViewportEntered = true
            Achievement.entries.forEach { achievement ->
                scope.launch {

                    animatedNumbers(
                        number = achievement.number,
                        onUpdate = {
                            numberToAnimate[achievement.ordinal] = it
                        }
                    )


                }
            }
        }
    )

    SimpleGrid(numColumns = numColumns(base = 2, md = 4, lg = 4)) {
        Achievement.entries.forEach { achievement ->
            AchievementCard(
                modifier = Modifier.margin(
                    right = if (achievement == Achievement.Team) 0.px
                    else {
                        if (breakpoint > Breakpoint.SM) 36.px else 15.px
                    },
                    bottom = if (breakpoint > Breakpoint.MD) 0.px else 40.px
                ),
                breakpoint = breakpoint,
                animatedNumber = if (isViewportEntered) numberToAnimate[achievement.ordinal] else 0,
                achievement = achievement
            )
        }
    }
}