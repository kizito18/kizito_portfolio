package com.binkes.kizito_portfolio.sections

import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.binkes.kizito_portfolio.components.RenderMarkdown
import com.binkes.kizito_portfolio.components.SectionTitle
import com.binkes.kizito_portfolio.components.SkillBar
import com.binkes.kizito_portfolio.models.Section
import com.binkes.kizito_portfolio.models.Skill
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.styles.AboutImageStyle
import com.binkes.kizito_portfolio.styles.AboutTextStyle
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.binkes.kizito_portfolio.util.ConstantsObject.WHY_HIRE_ME_TEXT
import com.binkes.kizito_portfolio.util.ObserveViewportEntered
import com.binkes.kizito_portfolio.util.ResObject
import com.binkes.kizito_portfolio.util.animatedNumbers
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@OptIn(DelicateApi::class)
@Composable
fun AboutSection(){

    val breakpoint = rememberBreakpoint()

    Box(modifier = Modifier
        .id(Section.About.id)
        .maxWidth(ConstantsObject.SECTION_WIDTH.px)
        .padding(top = if (breakpoint <= Breakpoint.ZERO) 100.px else 140.px , bottom = 20.px),
        contentAlignment = Alignment.Center
    ) {

        AboutContent()


    }


}


@OptIn(DelicateApi::class)
@Composable
fun AboutContent(){

    val breakpoint = rememberBreakpoint()


    val scope = rememberCoroutineScope()
    var isViewportEntered by remember { mutableStateOf(false) }
    val animatedPercentage = remember { mutableStateListOf(0,0,0,0,0,)  }


    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 300.0,
        onViewportEntered = {

            isViewportEntered = true

            Skill.entries.forEach { skill->
                scope.launch {
                    animatedNumbers(
                        number = skill.percentage.value.toInt(),
                        onUpdate = {

                            animatedPercentage[skill.ordinal] = it

                        }
                    )
                }
            }
        }
    )


    var titleMargin by remember { mutableStateOf(50.px) }
    var subtitleMargin by remember { mutableStateOf(50.px) }


    ObserveViewportEntered(
        sectionId =Section.About.id,
        distanceFromTop = 800.0,
        onViewportEntered = {
            scope.launch {
                delay(2000)

                titleMargin = 20.px

                delay(500)

                subtitleMargin = 80.px
            }
        }
    )


    Column(modifier = Modifier
        .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 90.percent
        else 100.percent)
        .maxWidth(1200.px),
        horizontalAlignment = if (breakpoint >= Breakpoint.MD) Alignment.CenterHorizontally else Alignment.Start
    ) {



        P (
            attrs = Modifier
                .margin(
                    left = titleMargin ,
                    top = 0.px,
                    bottom = 0.px
                )
                .textAlign(TextAlign.Start)
                .fontFamily(ConstantsObject.FONT_FAMILY)
                .fontSize(if (breakpoint <= Breakpoint.ZERO)  18.px else
                    if (breakpoint <= Breakpoint.SM) 20.px else
                        if (breakpoint <= Breakpoint.MD) 22.px else 25.px
                )
                .fontWeight(FontWeight.Normal)
                .color(ThemeByKizito.Primary.rgb)
                .transition(Transition.of(property = "margin", duration = 300.ms))
                .userSelect(UserSelect.None)
                .toAttrs()
        ){

            Text(Section.About.title)

        }



        P (
            attrs = Modifier
                .margin(
                    left = subtitleMargin,
                    right = 0.px,
                    bottom = 10.px,
                    top = 0.px
                )
                .textAlign(TextAlign.Start)
                .fontFamily(ConstantsObject.FONT_FAMILY)
                .fontSize(if (breakpoint <= Breakpoint.ZERO)  25.px else
                    if (breakpoint <= Breakpoint.SM) 30.px else
                        if (breakpoint <= Breakpoint.MD) 35.px else 40.px
                )
                .fontWeight(FontWeight.Bold)
                .color(ThemeByKizito.TextBlue.rgb)
                .transition(Transition.of(property = "margin", duration = 300.ms))
                .padding(all = 0.px)
                .userSelect(UserSelect.None)
                .toAttrs()
        ){

            Text("How It All Began")


            HorizontalDivider(Modifier
                .height(2.px)
                .padding(all = 0.px)
                .margin(top = if (breakpoint <= Breakpoint.ZERO)  5.px else
                    if (breakpoint <= Breakpoint.SM) 8.px else
                        if (breakpoint <= Breakpoint.MD) 12.px else 15.px,
                    bottom = 0.px
                )
                .overflow(Overflow.Hidden)
            )
        }



        MyJourney()



        if (breakpoint >= Breakpoint.MD) {

            SimpleGrid(
                numColumns = numColumns(base = 2),
                modifier = Modifier
                    .margin(top = 10.px)
                    .fillMaxWidth(80.percent)
            ) {

                AboutImage(breakpoint = breakpoint)

                AboutMe(
                    breakpoint = breakpoint,
                    isViewportEntered = isViewportEntered,
                    animatedPercentage = animatedPercentage
                )

            }

        }else{
            if (breakpoint == Breakpoint.SM){

                Row(modifier = Modifier
                    .fillMaxWidth(95.percent),
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    AboutImage(breakpoint = breakpoint)

                    AboutMe(
                        breakpoint = breakpoint,
                        isViewportEntered = isViewportEntered,
                        animatedPercentage = animatedPercentage
                    )
                }

                Column(modifier = Modifier
                    .fillMaxWidth(50.percent)
                    .margin(left = 20.px),
                    horizontalAlignment = Alignment.Start
                ) {
                    Skill.entries.forEach { skill ->

                        SkillBar(
                            name = skill.title,
                            index = skill.ordinal,
                            percentage = if (isViewportEntered) skill.percentage else 0.percent,
                            animatedPercentage = if (isViewportEntered) animatedPercentage[skill.ordinal] else 0,
                            breakpoint = breakpoint
                        )
                    }
                }

            }else{

                Column(modifier = Modifier
                    .fillMaxWidth(95.percent),
                ) {

                    Column(modifier = Modifier
                        .margin(left = 8.px, right = 8.px)
                    ) {
                        AboutMe(
                            breakpoint = breakpoint,
                            isViewportEntered = isViewportEntered,
                            animatedPercentage = animatedPercentage
                        )
                    }

                    AboutImage(breakpoint = breakpoint)

                    Column(modifier = Modifier
                        .fillMaxWidth(50.percent)
                        .margin(left = 20.px),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Skill.entries.forEach { skill ->

                            SkillBar(
                                name = skill.title,
                                index = skill.ordinal,
                                percentage = if (isViewportEntered) skill.percentage else 0.percent,
                                animatedPercentage = if (isViewportEntered) animatedPercentage[skill.ordinal] else 0,
                                breakpoint = breakpoint
                            )
                        }
                    }


                }

            }


        }






    }


}



@Composable
fun  AboutImage(
    breakpoint: Breakpoint
){


    Box(modifier = Modifier
        .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 35.percent),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = AboutImageStyle.toModifier()
                .fillMaxWidth(
                        if (breakpoint <= Breakpoint.ZERO) 60.percent else
                            if (breakpoint <= Breakpoint.ZERO) 40.percent else
                            if (breakpoint <= Breakpoint.MD) 60.percent else 80.percent
                ),
            src = ResObject.Image.about ,
            description = "About Image"
        )
    }

}




@Composable
fun  AboutMe(
    breakpoint: Breakpoint,
    isViewportEntered: Boolean,
    animatedPercentage: SnapshotStateList<Int>
){


    val isViewportEntered by rememberUpdatedState(isViewportEntered)
    val animatedPercentage by rememberUpdatedState ( animatedPercentage)



    Column(modifier = Modifier
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {

        SectionTitle(section = Section.About)



        RenderMarkdown(
            editText = WHY_HIRE_ME_TEXT,
            styleModifier = AboutTextStyle.toModifier()
                .margin(topBottom = 25.px)
                .maxWidth(500.px)
                .fontFamily(ConstantsObject.FONT_FAMILY)
                .fontSize(
                    if (breakpoint <= Breakpoint.ZERO) 15.px else
                        if (breakpoint <= Breakpoint.SM) 14.px else
                            if (breakpoint <= Breakpoint.MD) 16.px else
                                if (breakpoint <= Breakpoint.LG) 17.px else 18.px
                )
                .fontWeight(FontWeight.Normal)
                .fontStyle(FontStyle.Italic)


        )





        if (breakpoint >= Breakpoint.MD) {

            Skill.entries.forEach { skill ->

                SkillBar(
                    name = skill.title,
                    index = skill.ordinal,
                    percentage = if (isViewportEntered) skill.percentage else 0.percent,
                    animatedPercentage = if (isViewportEntered) animatedPercentage[skill.ordinal] else 0,
                    breakpoint = breakpoint
                )

            }

        }



    }

}




