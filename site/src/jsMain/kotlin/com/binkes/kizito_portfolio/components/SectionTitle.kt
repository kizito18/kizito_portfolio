package com.binkes.kizito_portfolio.components


import androidx.compose.runtime.*
import com.binkes.kizito_portfolio.models.Section
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.binkes.kizito_portfolio.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@OptIn(DelicateApi::class)
@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    section: Section,
    alignment: Alignment.Horizontal = Alignment.Start
){

    val scope = rememberCoroutineScope()
    var titleMargin by remember { mutableStateOf(50.px) }
    var subtitleMargin by remember { mutableStateOf(50.px) }

    val breakpoint = rememberBreakpoint()

    ObserveViewportEntered(
        sectionId = section.id,
        distanceFromTop = 600.0,
        onViewportEntered = {

            scope.launch {

                subtitleMargin = 0.px

                if (alignment == Alignment.Start){
                    delay(25)
                }

                titleMargin = 0.px


            }
        }
    )

    Column(modifier = modifier
        .overflow(Overflow.Hidden),
        horizontalAlignment = alignment
        ) {

        if (section != Section.About) {

            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(
                        left = titleMargin,
                        top = 0.px,
                        bottom = 0.px
                    )
                    .textAlign(
                        when (alignment) {
                            Alignment.CenterHorizontally -> TextAlign.Center
                            Alignment.End -> TextAlign.End
                            else -> TextAlign.Start
                        }
                    )
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(
                        if (breakpoint <= Breakpoint.ZERO) 18.px else
                            if (breakpoint <= Breakpoint.SM) 20.px else
                                if (breakpoint <= Breakpoint.MD) 22.px else 25.px
                    )
                    .fontWeight(FontWeight.Normal)
                    .color(ThemeByKizito.Primary.rgb)
                    .transition(Transition.of(property = "margin", duration = 300.ms))
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {

                Text(section.title)

            }

        }




        P (
            attrs = Modifier
                .fillMaxWidth()
                .margin(
                    left = if (alignment == Alignment.Start) subtitleMargin else 0.px,
                    right =  if (alignment == Alignment.CenterHorizontally) subtitleMargin else 0.px,
                    bottom = 10.px,
                    top = 0.px
                )
                .textAlign(
                    when (alignment) {
                        Alignment.CenterHorizontally -> TextAlign.Center
                        Alignment.End -> TextAlign.End
                        else -> TextAlign.Start
                    }
                )
                .fontFamily(ConstantsObject.FONT_FAMILY)
                .fontSize(if (breakpoint <= Breakpoint.ZERO)  25.px else
                    if (breakpoint <= Breakpoint.SM) 30.px else
                        if (breakpoint <= Breakpoint.MD) 35.px else 40.px
                )
                .fontWeight(FontWeight.Bold)
                .color(ThemeByKizito.Secondary.rgb)
                .transition(Transition.of(property = "margin", duration = 300.ms))
                .padding(all = 0.px)
                .userSelect(UserSelect.None)
                .toAttrs()
        ){

            Text(section.subtitle)

        }

        Box(modifier = Modifier
            .width(80.px)
            .height(2.px)
            .backgroundColor(ThemeByKizito.Primary.rgb)
            .borderRadius(r =50.px)
        )
    }


}