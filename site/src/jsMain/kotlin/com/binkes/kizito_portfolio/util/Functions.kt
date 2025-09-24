package com.binkes.kizito_portfolio.util

import androidx.compose.runtime.*
import com.binkes.kizito_portfolio.pages.mainScreenScrollLayoutId
import kotlinx.browser.document
import kotlinx.coroutines.delay
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.EventListener




@Composable
fun ObserveViewportEntered(
   // scrollContainerId: String,   // <- id of your scroll layout (mainScreenScrollLayoutId)
    sectionId: String,           // <- the id of the section you want to observe
    distanceFromTop: Double,
    onViewportEntered: () -> Unit
) {
    var isViewportEntered by remember { mutableStateOf(false) }

    val listener = remember {
        EventListener {
            val container = document.getElementById(mainScreenScrollLayoutId) as? HTMLElement
            val target = document.getElementById(sectionId)

            if (container != null && target != null) {
                val containerRect = container.getBoundingClientRect()
                val targetRect = target.getBoundingClientRect()

                // Distance between top of target and top of container
                val relativeTop = targetRect.top - containerRect.top

                if (relativeTop < distanceFromTop) {
                    isViewportEntered = true
                }
            }
        }
    }

    LaunchedEffect(isViewportEntered) {
        val container = document.getElementById(mainScreenScrollLayoutId) as? HTMLElement

        if (container != null) {
            if (isViewportEntered) {
                onViewportEntered()
                container.removeEventListener(type = "scroll", callback = listener)
            } else {
                container.addEventListener(type = "scroll", callback = listener)
            }
        }
    }
}





suspend fun animatedNumbers(
    number: Int,
    delay: Long = 10L,
    onUpdate: (Int) -> Unit
){

    (0..number).forEach {

        delay(delay)

        onUpdate(it)

    }


}



/*
@Composable
fun ObserveViewportEntered(
    sectionId: String,
    distanceFromTop: Double,
    onViewportEntered: () -> Unit
){

    var isViewportEntered by remember { mutableStateOf(false) }

    val listener = remember {
        EventListener {
            val top = document.getElementById(sectionId)?.getBoundingClientRect()?.top
            if (top != null && top < distanceFromTop){
                isViewportEntered = true
            }
        }
    }



    LaunchedEffect(isViewportEntered){

        if(isViewportEntered){

            onViewportEntered()
            window.removeEventListener(type = "scroll", callback =  listener)
        }else{

            window.addEventListener(type = "scroll", callback = listener)
        }


    }

}

 */
