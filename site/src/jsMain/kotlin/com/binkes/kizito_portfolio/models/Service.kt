package com.binkes.kizito_portfolio.models

import com.binkes.kizito_portfolio.util.ConstantsObject.ANDROID_SERVICE_TEXT
import com.binkes.kizito_portfolio.util.ConstantsObject.IOS_SERVICE_TEXT
import com.binkes.kizito_portfolio.util.ConstantsObject.WEB_SERVICE_TEXT
import com.binkes.kizito_portfolio.util.ResObject


enum class Service(
    val icon: String,
    val imageDesc: String,
    val title: String,
    val description: String
) {
    Android(
        icon = ResObject.Icon.android,
        imageDesc = "Android Icon",
        title = "Android Development",
        description = ANDROID_SERVICE_TEXT
    ),
    IOS(
        icon = ResObject.Icon.apple,
        imageDesc = "Apple Icon",
        title = "iOS Development",
        description = IOS_SERVICE_TEXT
    ),
    Web(
        icon = ResObject.Icon.web,
        imageDesc = "Desktop Icon",
        title = "Web Development",
        description = WEB_SERVICE_TEXT
    )
}