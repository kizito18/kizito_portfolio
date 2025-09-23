package com.binkes.kizito_portfolio.models

import com.binkes.kizito_portfolio.util.ConstantsObject


enum class Experience(
    val number: String,
    val jobPosition: String,
    val description: String,
    val company: String,
    val from: String,
    val to: String
) {
    First(
        number = "01",
        jobPosition = "Android Developer",
        description = ConstantsObject.ANDROID_DEVELOPMENT_EXPERIENCE_TEXT,
        company = "Zitos",
        from = "February 2020",
        to = "Till Date",
    ),
    Second(
        number = "02",
        jobPosition = "Ios Developer",
        description = ConstantsObject.IOS_DEVELOPMENT_EXPERIENCE_TEXT,
        company = "Zitos",
        from = "January 2024",
        to = "Till Date",
    ),
    Third(
        number = "03",
        jobPosition = "Web Developer",
        description = ConstantsObject.WEB_DEVELOPMENT_EXPERIENCE_TEXT,
        company = "Zitos",
        from = "March 2024",
        to = "Till Date",
    )
}