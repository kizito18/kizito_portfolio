package com.binkes.kizito_portfolio.components



import androidx.compose.runtime.Composable
import com.binkes.kizito_portfolio.styles.SocialLinkStyle
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px


@OptIn(DelicateApi::class)
@Composable
fun SocialBar(
    isRow: Boolean = false
){

    val breakpoint = rememberBreakpoint()

    if (isRow){

        Row  (
            modifier = Modifier
                .fillMaxWidth()
                .margin(
                    top = if (breakpoint <= Breakpoint.ZERO) 10.px else
                        if (breakpoint <= Breakpoint.SM) 20.px else 25.px
                )
                .padding(leftRight =  if (breakpoint <= Breakpoint.ZERO) 10.px else
                    if (breakpoint <= Breakpoint.SM) 20.px else 25.px
                )
                .minHeight(40.px)
                .borderRadius(r = 20.px)
                .backgroundColor(Color.white),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            SocialLinks(
                isRow = true,
                breakpoint = breakpoint
            )
        }

    }else{

        Column (
            modifier = Modifier
                .margin(
                    right = if (breakpoint <= Breakpoint.ZERO) 10.px else
                        if (breakpoint <= Breakpoint.SM) 20.px else 25.px
                )
                .padding(topBottom =  25.px)
                .minWidth(40.px)
                .borderRadius(r = 20.px)
                .backgroundColor(Color.white),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            SocialLinks(
                breakpoint = breakpoint
            )
        }




    }



}



@Composable
private fun SocialLinks(
    isRow: Boolean = false,
    breakpoint: Breakpoint
) {




    Link(
        path = ConstantsObject.FACE_BOOK_WEB_LINK,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {

        FaFacebook(
            modifier = SocialLinkStyle.toModifier()
                .margin(
                    bottom = if (isRow){
                        0.px
                    } else{
                        if(breakpoint <= Breakpoint.ZERO) 25.px else
                            if (breakpoint <= Breakpoint.SM)  35.px else 40.px
                    },
                    right = if (isRow){
                        if(breakpoint <= Breakpoint.ZERO) 25.px else
                            if (breakpoint <= Breakpoint.SM)  35.px else 40.px
                    } else{
                        0.px
                    }
                ),
            size =  if(breakpoint <= Breakpoint.ZERO) IconSize.SM else IconSize.LG
        )

    }

    Link(
        path =  ConstantsObject.X_WEB_LINK,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaXTwitter(
            modifier = SocialLinkStyle.toModifier()
                .margin(
                    bottom = if (isRow){
                        0.px
                    } else{
                        if(breakpoint <= Breakpoint.ZERO) 25.px else
                            if (breakpoint <= Breakpoint.SM)  35.px else 40.px
                    },
                    right = if (isRow){
                        if(breakpoint <= Breakpoint.ZERO) 25.px else
                            if (breakpoint <= Breakpoint.SM)  35.px else 40.px
                    } else{
                        0.px
                    }
                ),
            size =  if(breakpoint <= Breakpoint.ZERO) IconSize.SM else IconSize.LG
        )
    }

    Link(
        path =  ConstantsObject.INSTAGRAM_WEB_LINK,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {

        FaInstagram(
            modifier = SocialLinkStyle.toModifier()
                .margin(
                    bottom = if (isRow){
                        0.px
                    } else{
                        if(breakpoint <= Breakpoint.ZERO) 25.px else
                            if (breakpoint <= Breakpoint.SM)  35.px else 40.px
                    },
                    right = if (isRow){
                        if(breakpoint <= Breakpoint.ZERO) 25.px else
                            if (breakpoint <= Breakpoint.SM)  35.px else 40.px
                    } else{
                        0.px
                    }
                ),
            size =  if(breakpoint <= Breakpoint.ZERO) IconSize.SM else IconSize.LG
        )
    }

    Link(
        path =  ConstantsObject.LINKEDIN_WEB_LINK,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {

        FaLinkedin(
            modifier = SocialLinkStyle.toModifier()
                .margin(
                    bottom = if (isRow){
                        0.px
                    } else{
                        if(breakpoint <= Breakpoint.ZERO) 25.px else
                            if (breakpoint <= Breakpoint.SM)  35.px else 40.px
                    },
                ),
            size =  if(breakpoint <= Breakpoint.ZERO) IconSize.SM else IconSize.LG
        )
    }


}