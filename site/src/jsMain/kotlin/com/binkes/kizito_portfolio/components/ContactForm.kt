package com.binkes.kizito_portfolio.components

import androidx.compose.runtime.Composable
import com.binkes.kizito_portfolio.models.ThemeByKizito
import com.binkes.kizito_portfolio.styles.InputStyle
import com.binkes.kizito_portfolio.styles.MainButtonStyle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.css.transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
fun ContactForm(breakpoint: Breakpoint) {




    Form(
        action = "https://formspree.io/f/xandvroa",
        attrs = Modifier
            .fillMaxWidth()
            .attrsModifier {
                attr("method", "POST")
            }
            .toAttrs()
    ) {

        Label(
            attrs = Modifier
                .classNames("form-label")
                .fontSize(if (breakpoint <= Breakpoint.ZERO) 12.px else
                    if (breakpoint <= Breakpoint.SM) 16.px else 17.px)
                .lineHeight(0.px)
                .toAttrs(),
                    forId = "inputName"
        ) {
            Text("Name")
        }



        Input(
            type = InputType.Text,
            attrs = InputStyle.toModifier()
                .id("inputName")
                .classNames("form-control")
                .fillMaxWidth(90.percent)
                .margin(bottom = 10.px)
                .backgroundColor(ThemeByKizito.LighterGray.rgb)
                .boxShadow(0.px,0.px,0.px,0.px,null)
                .fontSize(if (breakpoint <= Breakpoint.ZERO) 12.px else
                    if (breakpoint <= Breakpoint.SM) 14.px else
                        if (breakpoint <= Breakpoint.MD) 16.px else 17.px)
                .attrsModifier {
                    attr("placeholder", "Full Name")
                    attr("name", "name")
                    attr("required", "true")

                    // Add hover styles directly in CSS
                    attr("onmouseover", "this.style.borderColor='${ThemeByKizito.Primary.rgb}'")
                    attr("onmouseout", "this.style.borderColor='${ThemeByKizito.LightGray.rgb}'")
                }
                .toAttrs()
        )


        Label(
            attrs = Modifier
                .classNames("form-label")
                .fontSize(if (breakpoint <= Breakpoint.ZERO) 12.px else
                    if (breakpoint <= Breakpoint.SM) 16.px else 18.px)
                .lineHeight(0.px)
                .toAttrs(),
            forId = "inputEmail"
        ) {
            Text("Email")
        }

        Input(
            type = InputType.Text,
            attrs = Modifier
                .id("inputEmail")
                .classNames("form-control")
                .fillMaxWidth(90.percent)
                .margin(bottom = 10.px)
                .backgroundColor(ThemeByKizito.LighterGray.rgb)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .styleModifier {
                    border( width = 2.px, style = LineStyle.Solid, color = ThemeByKizito.LightGray.rgb )
                    transition(Transition.of(property = "border", duration = 200.ms))
                }
                .fontSize(if (breakpoint <= Breakpoint.ZERO) 12.px else
                    if (breakpoint <= Breakpoint.SM) 14.px else
                        if (breakpoint <= Breakpoint.MD) 16.px else 17.px)
                .attrsModifier {
                    attr("placeholder", "Email Address")
                    attr("name", "email")
                    attr("required", "true")

                    // Add hover styles directly in CSS
                    attr("onmouseover", "this.style.borderColor='${ThemeByKizito.Primary.rgb}'")
                    attr("onmouseout", "this.style.borderColor='${ThemeByKizito.LightGray.rgb}'")
                }
                .toAttrs()
        )


        Label(
            attrs = Modifier
                .classNames("form-label")
                .fontSize(if (breakpoint <= Breakpoint.ZERO) 12.px else
                    if (breakpoint <= Breakpoint.SM) 16.px else 17.px)
                .lineHeight(0.px)
                .toAttrs(),
            forId = "inputMessage"
        ) {
            Text("Massage")
        }

        TextArea(
            attrs = Modifier
                .id("inputMessage")
                .classNames("form-control")
                .height(150.px)
                .fillMaxWidth()
                .margin(bottom = 20.px)
                .backgroundColor(ThemeByKizito.LighterGray.rgb)
                .boxShadow(0.px,0.px,0.px,0.px,null)
                .styleModifier {
                    border( width = 2.px, style = LineStyle.Solid, color = ThemeByKizito.LightGray.rgb )
                    transition(Transition.of(property = "border", duration = 200.ms))
                }
                .fontSize(if (breakpoint <= Breakpoint.ZERO) 12.px else
                    if (breakpoint <= Breakpoint.SM) 14.px else
                        if (breakpoint <= Breakpoint.MD) 16.px else 17.px)
                .attrsModifier {
                    attr("placeholder", "Your Message")
                    attr("name", "message")
                    attr("required", "true")
                    // Add hover styles directly in CSS
                    attr("onmouseover", "this.style.borderColor='${ThemeByKizito.Primary.rgb}'")
                    attr("onmouseout", "this.style.borderColor='${ThemeByKizito.LightGray.rgb}'")
                }
                .toAttrs()
        )



        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                attrs = MainButtonStyle.toModifier()
                    .height(if (breakpoint <= Breakpoint.ZERO) 30.px else
                        if (breakpoint <= Breakpoint.MD) 35.px else 38.px)
                    .fontSize(if (breakpoint <= Breakpoint.ZERO) 14.px else
                        if (breakpoint <= Breakpoint.MD) 16.px else 17.px)
                    .border(width = 0.px)
                    .borderRadius(r = 5.px)
                    .backgroundColor(ThemeByKizito.Primary.rgb)
                    .color(Colors.White)
                    .cursor(Cursor.Pointer)
                    .userSelect(UserSelect.None)
                    // Disable right-click / long-press
                    .onContextMenu { event ->
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    .toAttrs()
            ) {
                Text("Submit")
            }
        }


    }

}

