package com.binkes.kizito_portfolio.models

import com.binkes.kizito_portfolio.util.ResObject


enum class Achievement(
    val icon: String,
    val number: Int,
    val description: String
) {
    Completed(
        icon = ResObject.Icon.checkmark,
        number = 20,
        description = "Completed Projects"
    ),
    Active(
        icon = ResObject.Icon.shield,
        number = 2,
        description = "Active Projects"
    ),
    Satisfied(
        icon = ResObject.Icon.happy,
        number = 8,
        description = "Satisfied Clients"
    ),
    Team(
        icon = ResObject.Icon.user,
        number = 3,
        description = "Team Members"
    )
}