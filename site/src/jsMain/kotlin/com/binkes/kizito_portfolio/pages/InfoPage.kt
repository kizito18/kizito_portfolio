package com.binkes.kizito_portfolio.pages

import androidx.compose.runtime.*
import com.binkes.kizito_portfolio.components.RenderMarkdown
import com.binkes.kizito_portfolio.models.Portfolio
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.models.getPortfolioByTitle
import com.binkes.kizito_portfolio.sections.FooterSection
import com.binkes.kizito_portfolio.styles.ArrowBackStyle
import com.binkes.kizito_portfolio.styles.VisitProjectStyle
import com.binkes.kizito_portfolio.util.ConstantsObject
import com.binkes.kizito_portfolio.util.ResObject
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Video
import org.w3c.dom.HTMLVideoElement
import org.w3c.dom.PopStateEvent


@OptIn(DelicateApi::class)
@Page("/info/{docId}")
@Composable
fun InfoPage() {

    val context = rememberPageContext()

    val breakpoint = rememberBreakpoint()

    var portfolioSelected by remember { mutableStateOf<Portfolio?>(null) }

    var isContentReady by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()



    LaunchedEffect(Unit) {

        val documentId = context.route.params["docId"] ?: "No ID"

         portfolioSelected = getPortfolioByTitle( documentId = documentId)

    }


    // DOM content is ready (without waiting for images/fonts)
    LaunchedEffect(Unit) {
        document.addEventListener("DOMContentLoaded", {
            //console.log("DOM is fully built, but assets may still be loading.")
            scope.launch {
                delay(300)
                isContentReady = true
            }
        })
    }




    Box(modifier = Modifier
        .height(100.vh)
        .width(100.vw)
        .backgroundColor(ThemeByKizito.White.rgb)
    ) {

        if (isContentReady) {
            if (portfolioSelected != null) {


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .backgroundColor(ThemeByKizito.Primary_ALPHA2.rgb)
                        .overflow(Overflow.Scroll)
                ) {


                    Image(
                        modifier = ArrowBackStyle.toModifier()
                            .cursor(Cursor.Pointer)
                            .margin(top = 20.px, left = 20.px)
                            .onClick {

                                //context.router.navigateTo("/")
                                //  window.location.href = "/"

                                // Simulate browser back button behavior
                                if (window.history.length > 1) {

                                    window.history.back()

                                } else {
                                    window.history.replaceState(null, "", "/")
                                    window.dispatchEvent(PopStateEvent("popstate"))

                                }
                            }
                            .size(
                                if (breakpoint <= Breakpoint.ZERO) 20.px else
                                    if (breakpoint <= Breakpoint.SM) 30.px else
                                        if (breakpoint <= Breakpoint.MD) 35.px else
                                            if (breakpoint <= Breakpoint.LG) 40.px else 44.px
                            ),
                        src = ResObject.Icon.arrowBack,
                        alt = "close icon"
                    )



                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .scrollBehavior(ScrollBehavior.Smooth),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {

                        VideoPlayer(
                            videoUrl = portfolioSelected!!.videoLink,
                            thumbnail = portfolioSelected!!.thumbnail,
                            breakpoint = breakpoint
                        )
                     //   VideoPlayer("https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8", type = "application/x-mpegURL")



                        Column(
                            modifier = Modifier
                                .fillMaxWidth(
                                    if (breakpoint <= Breakpoint.ZERO) 98.percent else
                                        if (breakpoint <= Breakpoint.SM) 88.percent else
                                            if (breakpoint <= Breakpoint.MD) 78.percent else
                                                if (breakpoint <= Breakpoint.LG) 78.percent else 65.percent
                                )
                        ) {


                            Column(
                                modifier = Modifier
                                    .padding { 8.px }
                                    .fillMaxWidth(96.percent)
                            ) {

                                if (portfolioSelected!!.projectLogo.isNotEmpty()) {

                                    Image(
                                        modifier = Modifier
                                            .cursor(Cursor.Pointer)
                                            .margin(top = 20.px, left = 20.px)
                                            .size(
                                                if (breakpoint <= Breakpoint.ZERO) 30.px else
                                                    if (breakpoint <= Breakpoint.SM) 38.px else
                                                        if (breakpoint <= Breakpoint.MD) 42.px else
                                                            if (breakpoint <= Breakpoint.LG) 48.px else 50.px
                                            )
                                            .borderRadius(r = 100.percent),
                                        src = portfolioSelected!!.projectLogo,
                                        alt = "project logo"
                                    )

                                }


                                P(
                                    attrs = Modifier
                                        .fillMaxWidth()
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

                                    Text(portfolioSelected!!.title)

                                }

                            }


                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        left = if (breakpoint <= Breakpoint.ZERO) 8.px else
                                            if (breakpoint <= Breakpoint.SM) 12.px else
                                                if (breakpoint <= Breakpoint.MD) 15.px else 20.px
                                    )
                            ) {

                                RenderMarkdown(
                                    editText = portfolioSelected!!.description,
                                    styleModifier = Modifier
                                        .margin(topBottom = 0.px)
                                        .fillMaxWidth()
                                        .fontFamily(ConstantsObject.FONT_FAMILY)
                                        .fontSize(
                                            if (breakpoint <= Breakpoint.SM) 11.px else
                                                if (breakpoint <= Breakpoint.MD) 12.px else
                                                    if (breakpoint <= Breakpoint.LG) 13.px else 14.px
                                        )
                                        .fontWeight(FontWeight.Normal)
                                        .color(ThemeByKizito.TextBlue.rgb)
                                )

                            }


                            if (portfolioSelected != null) {

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .margin(bottom = 25.px),
                                    contentAlignment = Alignment.Center
                                ) {

                                    VisitProject(
                                        portfolioSelected = portfolioSelected!!,
                                        breakpoint = breakpoint
                                    )

                                }

                            }


                        }



                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            contentAlignment = Alignment.BottomStart
                        ) {

                            FooterSection(
                                isFromInfoScreen = true
                            )

                        }

                    }


                }


            }

        }

    }

}





@Composable
private fun VideoPlayer(
    videoUrl: String,
    thumbnail: String,
    breakpoint: Breakpoint
) {
    val videoRef = remember {   mutableStateOf<HTMLVideoElement?>(null) }
    var isPlaying by remember { mutableStateOf(false) }

    var showCustomControl by remember { mutableStateOf(false) }
    var isVideoFreamFocused  by remember { mutableStateOf(false) }
    var isCustomControlFocused  by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    var showThumbnail by remember { mutableStateOf(false) }

    LaunchedEffect(Unit){
        delay(2000)
        if (videoRef.value == null){
            showThumbnail = true
        }
    }

    LaunchedEffect(isVideoFreamFocused,isCustomControlFocused ){

        if (!isVideoFreamFocused && !isCustomControlFocused){
            if (showCustomControl) {
                scope.launch {
                    delay(2000)
                    if (!isVideoFreamFocused && !isCustomControlFocused) {
                        showCustomControl = false
                    }
                }

            }
        }else{
            if (!showCustomControl) {
                showCustomControl = true
            }
        }

    }



    Box(
        modifier = Modifier
            .margin(top = if (breakpoint <= Breakpoint.ZERO) 10.px else
                if (breakpoint <= Breakpoint.SM) 20.px else
                    if (breakpoint <= Breakpoint.MD) 30.px else
                        if (breakpoint <= Breakpoint.LG) 20.px else   30.px,

                bottom = if (breakpoint <= Breakpoint.ZERO) 20.px else
                    if (breakpoint <= Breakpoint.SM) 30.px else
                        if (breakpoint <= Breakpoint.MD) 40.px else
                            if (breakpoint <= Breakpoint.LG) 50.px else 60.px
            )
            .fillMaxWidth(
                if (breakpoint <= Breakpoint.ZERO) 85.percent else
                    if (breakpoint <= Breakpoint.SM) 70.percent else
                        if (breakpoint <= Breakpoint.MD) 67.percent else
                            if (breakpoint <= Breakpoint.LG) 60.percent else 45.percent
            )
            .height(
                if (breakpoint <= Breakpoint.ZERO) 150.px else
                    if (breakpoint <= Breakpoint.SM) 300.px else
                        if (breakpoint <= Breakpoint.MD) 350.px else 400.px
            )
            .position(Position.Relative)
        ,
        contentAlignment = Alignment.Center
    ) {



        if (showThumbnail) {
            Image(
                modifier = Modifier
                    .width(100.percent)
                    .height(100.percent)
                    .aspectRatio(16.0 / 9.0)
                    .borderRadius(15.px),
                src = thumbnail,
                alt = "video thumbnail logo"
            )
        }



        Box {



            // Video element without controls
            Video(
                attrs = Modifier
                    .width(100.percent)
                    .height(100.percent)
                    .borderRadius(20.px)
                    //.objectFit(ObjectFit.Contain)
                    .onMouseOut {
                        isVideoFreamFocused = false
                    }
                    .onMouseEnter {
                        isVideoFreamFocused = true
                    }
                    .aspectRatio(16.0 / 9.0)  // 16:9 aspect ratio
                    .toAttrs {
                        attr("src", videoUrl)
                        //attr("poster", thumbnail)
                        attr("controls", "false")
                        attr("playsinline", "true")
                       // attr("playsinline", "true")

                        attr("muted", "true")      // required for autoplay
                        attr("autoplay", "true")   // hint browser to autoplay

                        attr("preload", "auto") // Helps with caching by preloading metadata
                        attr("loop", "true")

                        ref { element ->
                            videoRef.value = element

                            videoRef.value?.playsInline = true
                            videoRef.value?.controls = false
                            videoRef.value?.muted = true
                            videoRef.value?.autoplay = true
                            //videoRef.value?.poster = thumbnail
                            videoRef.value?.preload = "auto"
                            videoRef.value?.loop = true


                            videoRef.value?.onended = {
                                showThumbnail = false
                                isPlaying = false
                            }

                            // play as soon as it's ready
                            videoRef.value?.oncanplay = {
                                showThumbnail = false
                               // element.muted = true  // ensure muted
                                //element.controls = false

                                // Try to play and handle any errors
                                /*
                                element.play().catch { e ->
                                    console.log("Autoplay prevented: ", e)
                                    // Fallback: show controls if autoplay is blocked
                                    element.setAttribute("controls", "true")
                                }
                                 */

                               // element.play()
                                isPlaying = true
                                videoRef.value?.play()?.catch {
                                    isPlaying = false
                                }
                            }


                            // video failed to load (invalid or broken URL)
                            videoRef.value?.onerror = { _: dynamic, _: String, _: Int, _: Int, _: Any? ->
                                // console.log(" Video failed to load: $videoUrl")
                                videoRef.value = null
                                null // must return dynamic (usually null)
                            }


                            // Listen for video error
//                        element.addEventListener("error", {
//                            console.log("Video failed to load: $videoUrl")
//                            videoRef.value = null
//                        })


                            onDispose {
                                videoRef.value?.pause()
                                isPlaying = false
                                videoRef.value = null
                            }
                        }
                    }
            )





            if (videoRef.value != null && showCustomControl) {

                Image(
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .size(
                            if (breakpoint <= Breakpoint.ZERO) 28.px else
                                if (breakpoint <= Breakpoint.SM) 37.px else
                                    if (breakpoint <= Breakpoint.MD) 40.px else
                                        if (breakpoint <= Breakpoint.LG) 45.px else 50.px
                        )

                        .borderRadius(r = 100.percent)
                        .background(color = ThemeByKizito.Primary_ALPHA3.rgb)
                        .padding(5.px)
                        .transition(Transition.Companion.of(property = "translate", duration = 200.ms))
                        // .position(Position.Sticky)
                       // .position(Position.Absolute)
                        .align(Alignment.Center)
                        .onMouseOut {
                            isCustomControlFocused = false
                        }
                        .onMouseEnter {
                            isCustomControlFocused = true
                        }
                        .onClick {
                            val video = videoRef.value
                            if (video != null) {
                                if (isPlaying) {
                                    video.pause()
                                    isPlaying = false
                                } else {
                                    video.play()
                                    isPlaying = true
                                }
                            }
                        }
                        .zIndex(2),
                    src = if (isPlaying) ResObject.Icon.pause_icon else ResObject.Icon.play_icon,
                    alt = "Play pause icon"
                )


                // Fullscreen toggle
                Image(
                    modifier = Modifier
                        .size(
                            if (breakpoint <= Breakpoint.ZERO) 20.px else
                                if (breakpoint <= Breakpoint.MD) 25.px else
                                    if (breakpoint <= Breakpoint.LG) 30.px else 32.px
                        )
                        .align(Alignment.BottomEnd)
                        .alignSelf(AlignSelf.SelfEnd)
                        .cursor(Cursor.Pointer)
                        //.position(Position.Sticky)
                        //.position(Position.Absolute)
                        .margin(12.px)
                        .borderRadius(20.percent)
                        .padding(all = 2.px)
                        .background(color = ThemeByKizito.Primary_ALPHA3.rgb)
                        .onMouseOut {
                            isCustomControlFocused = false
                        }
                        .onMouseEnter {
                            isCustomControlFocused = true
                        }
                        .onClick {

                            if (videoRef.value != null) {
                                if (js("document.fullscreenElement") == null) {
                                    videoRef.value!!.requestFullscreen()
                                } else {
                                    js("document.exitFullscreen()")
                                }
                            }
                        }
                        .zIndex(2),
                    src = ResObject.Icon.video_full_screen_icon,
                    alt = "Fullscreen"
                )

            }

        }



    }
}






@Composable
private fun VisitProject(
    portfolioSelected: Portfolio,
    breakpoint: Breakpoint
){


    Column(
        modifier = Modifier
            .fillMaxWidth(85.percent)
    ) {




        SimpleGrid(
            numColumns = numColumns(base = 2, sm = 2, md =3),
            modifier = Modifier.fillMaxWidth()
        ) {


            if (portfolioSelected.playStoreLink.isNotEmpty()){
                CustomImage(
                    breakpoint = breakpoint,
                    projectLink = portfolioSelected.playStoreLink,
                    icon = ResObject.Icon.playStore
                )
            }

            if (portfolioSelected.appStoreLink.isNotEmpty()){
                CustomImage(
                    breakpoint = breakpoint,
                    projectLink = portfolioSelected.appStoreLink,
                    icon = ResObject.Icon.appStore
                )
            }

            if (portfolioSelected.apkLink.isNotEmpty()){
                CustomImage(
                    breakpoint = breakpoint,
                    projectLink = portfolioSelected.apkLink,
                    icon = ResObject.Icon.apk
                )
            }

            if (portfolioSelected.githubLink.isNotEmpty()){
                CustomImage(
                    breakpoint = breakpoint,
                    projectLink = portfolioSelected.githubLink,
                    icon = ResObject.Icon.github
                )
            }

            if (portfolioSelected.otherLink.isNotEmpty()){
                CustomImage(
                    breakpoint = breakpoint,
                    projectLink = portfolioSelected.otherLink,
                    icon = ResObject.Icon.linkBig
                )
            }



        }



    }



}



@Composable
private fun CustomImage(
    breakpoint: Breakpoint,
    projectLink: String,
    icon: String
){




    Link(
        modifier = Modifier
            .textDecorationLine(TextDecorationLine.None),
        path = projectLink,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ){


        Column(modifier = VisitProjectStyle.toModifier()
            .padding(top = 5.px)
            .borderRadius(10.px)
            .height(
                if (breakpoint <= Breakpoint.ZERO) 90.px else
                if (breakpoint <= Breakpoint.SM) 120.px else
                    if (breakpoint <= Breakpoint.MD) 150.px else
                        if (breakpoint <= Breakpoint.LG) 170.px else 200.px
            )
            .border(width = 1.px, style = LineStyle.Solid, color = ThemeByKizito.Gray.rgb)
            .margin(all = if (breakpoint <= Breakpoint.ZERO) 8.px else
                if (breakpoint <= Breakpoint.SM) 14.px else
                if (breakpoint <= Breakpoint.MD) 16.px else
                    if (breakpoint <= Breakpoint.LG) 18.px else 20.px),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {



            Image(
                src = icon,
                alt = "close icon",
                modifier = Modifier
                    .cursor(Cursor.Pointer)
                    .maxHeight(if (breakpoint <= Breakpoint.ZERO) 70.percent else
                if (breakpoint <= Breakpoint.SM) 80.percent else
                    if (breakpoint <= Breakpoint.MD) 90.percent else
                        if (breakpoint <= Breakpoint.LG) 95.percent else 98.percent
                    )
                    .maxWidth(100.percent)


            )

            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY)
                    .fontSize(
                        if (breakpoint <= Breakpoint.SM) 10.px else
                        if (breakpoint <= Breakpoint.SM) 11.px else
                            if (breakpoint <= Breakpoint.MD) 12.px else
                                if (breakpoint <= Breakpoint.LG) 13.px else 14.px
                    )
                    .fontWeight(FontWeight.Normal)
                    .whiteSpace(WhiteSpace.BreakSpaces)
                    .opacity(50.percent)
                    .userSelect(UserSelect.None)
                    .toAttrs()
            ) {
                Text("Visit Project")
            }

        }


    }


}