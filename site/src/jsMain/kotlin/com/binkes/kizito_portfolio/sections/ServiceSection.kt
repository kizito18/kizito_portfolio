package com.binkes.kizito_portfolio.sections


import androidx.compose.runtime.Composable
import com.binkes.kizito_portfolio.components.SectionTitle
import com.binkes.kizito_portfolio.components.ServiceCard
import com.binkes.kizito_portfolio.models.Section
import com.binkes.kizito_portfolio.models.Service
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


@OptIn(DelicateApi::class)
@Composable
fun ServiceSection(){

    val breakpoint = rememberBreakpoint()

    Box(modifier = Modifier
        .id(Section.Service.id)
        .maxWidth(ConstantsObject.SECTION_WIDTH.px)
        .padding(topBottom = if (breakpoint <= Breakpoint.ZERO) 40.px else
            if (breakpoint <= Breakpoint.SM) 50.px else
                if (breakpoint <= Breakpoint.MD) 60.px else
                    if (breakpoint <= Breakpoint.LG) 70.px else 80.px
        ),
        contentAlignment = Alignment.Center
    ) {

        ServiceContent()

    }

}



@OptIn(DelicateApi::class)
@Composable
fun ServiceContent(){

    val breakpoint = rememberBreakpoint()

    Column(modifier = Modifier
        .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 90.percent
        else 100.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SectionTitle(
            modifier = Modifier.fillMaxWidth().margin(bottom = 20.px),
            section = Section.Service,
            alignment = Alignment.CenterHorizontally
        )

        SimpleGrid(
            numColumns = numColumns(base = 2, sm = 2, md =3),
            modifier = Modifier
        ) {

            Service.entries.forEach { service->

                ServiceCard(
                    service = service,
                    breakpoint = breakpoint
                )

            }
        }



   }

}