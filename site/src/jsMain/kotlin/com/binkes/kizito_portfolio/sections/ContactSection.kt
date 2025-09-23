package com.binkes.kizito_portfolio.sections


import androidx.compose.runtime.*
import com.binkes.kizito_portfolio.components.ContactForm
import com.binkes.kizito_portfolio.components.SectionTitle
import com.binkes.kizito_portfolio.models.Section
import com.binkes.kizito_portfolio.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


@OptIn(DelicateApi::class)
@Composable
fun ContactSection(){

    val breakpoint = rememberBreakpoint()


    Box(
        modifier = Modifier
            .id(Section.Contact.id)
            .fillMaxWidth(if(breakpoint <= Breakpoint.ZERO) 85.percent else
                if(breakpoint <= Breakpoint.SM) 69.percent else
                if (breakpoint <= Breakpoint.MD) 58.percent else
                    if (breakpoint <= Breakpoint.LG) 50.percent else
                        if (breakpoint <= Breakpoint.XL) 40.percent else 35.percent
            )
            .padding(top = 60.px, bottom = 100.px),
        contentAlignment = Alignment.Center
    ) {

        ContactContent()

    }

}


@OptIn(DelicateApi::class)
@Composable
fun ContactContent() {

    val breakpoint = rememberBreakpoint()

    val scope = rememberCoroutineScope()

    var animatedRotation by remember { mutableStateOf(0.deg) }

    ObserveViewportEntered(
        sectionId = Section.Contact.id,
        distanceFromTop = 500.0,
        onViewportEntered = {
            animatedRotation = 10.deg
            scope.launch {
                delay(500)
                animatedRotation = 0.deg
            }
        }
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .overflow(Overflow.Hidden),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 25.px)
                .transform { rotate(animatedRotation) }
                .transition(Transition.of(property = "transform", duration = 500.ms)),
            section = Section.Contact,
            alignment = Alignment.CenterHorizontally
        )


        ContactForm(breakpoint = breakpoint)

    }


}
