package com.binkes.kizito_portfolio.sections


import androidx.compose.runtime.*
import com.binkes.kizito_portfolio.components.ExperienceCard
import com.binkes.kizito_portfolio.components.SectionTitle
import com.binkes.kizito_portfolio.models.Experience
import com.binkes.kizito_portfolio.models.Section
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.binkes.kizito_portfolio.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


@Composable
fun ExperienceSection() {
    Box(
        modifier = Modifier
            .id(Section.Experience.id)
            .maxWidth(ConstantsObject.SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        ExperienceContent()
    }
}


@OptIn(DelicateApi::class)
@Composable
fun ExperienceContent() {

    val breakpoint = rememberBreakpoint()
    var animatedMargin by remember { mutableStateOf(200.px) }

    ObserveViewportEntered(
        sectionId = Section.Experience.id,
        distanceFromTop = 500.0,
        onViewportEntered = {

            animatedMargin = 50.px

        }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SectionTitle(
            modifier = Modifier
                .fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD)60.percent
                    else 90.percent
                )
                .margin(bottom = 25.px),
            section = Section.Experience
        )

        Experience.entries.forEach { experience->

            ExperienceCard(
                breakpoint = breakpoint,
                isActive = experience == Experience.First,
                experience = experience,
                animatedMargin = animatedMargin
            )

        }


    }




}
