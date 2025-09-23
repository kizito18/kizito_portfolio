package com.binkes.kizito_portfolio.pages

import androidx.compose.runtime.*
import com.binkes.kizito_portfolio.components.BackToTopButton
import com.binkes.kizito_portfolio.components.OverflowMenu
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.sections.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun navigateScrollToSection(id: String) {
    val section = document.getElementById(id)
    if (section != null) {
        val options = js("({})") // Create a dynamic object
        options.behavior = "smooth" // Set smooth scrolling
        options.block = "start" // Align to the start of the section

        section.scrollIntoView(options)
    }
}




@OptIn(DelicateApi::class)
@Page
@Composable
fun HomePage() {



    var isMenuOpened by remember { mutableStateOf(false) }

    val breakpoint = rememberBreakpoint()

    var isContentReady by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()




    /*
    // Entire HTML page + assets (like images, scripts, styles) are loaded
    LaunchedEffect(Unit) {
        window.onload = {
            console.log("✅ Page fully loaded (all assets).")
        }
    }

     */


    // DOM content is ready (without waiting for images/fonts)
    LaunchedEffect(Unit) {
        document.addEventListener("DOMContentLoaded", {
            //console.log("✅ DOM is fully built, but assets may still be loading.")
            scope.launch {
                delay(300)
                isContentReady = true
            }
        })
    }


    Box(modifier = Modifier
        .background(ThemeByKizito.White.rgb)
    ) {

        Box(modifier = Modifier.then(
            if (isMenuOpened) {
                Modifier
                    .background(ThemeByKizito.Primary_ALPHA1.rgb)
                    .onClick {
                        isMenuOpened = false
                    }
            } else {
                Modifier
            })
        ) {


            if (isContentReady) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(ThemeByKizito.Primary_ALPHA1.rgb),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                    MainSection(
                        onMenuClicked = {
                            isMenuOpened = true
                        }
                    )

                    AboutSection()

                    ServiceSection()

                    PortfolioSection()

                    AchievementsSection()

                    ExperienceSection()

                    ContactSection()

                    FooterSection(isFromInfoScreen = false)

                }


                BackToTopButton()

                if (isMenuOpened && breakpoint <= Breakpoint.SM) {

                    OverflowMenu(
                        onMenuClosed = {
                            isMenuOpened = false
                        }
                    )
                }

            }


        }

    }


}
