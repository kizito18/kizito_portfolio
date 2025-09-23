package com.binkes.kizito_portfolio.models

import com.binkes.kizito_portfolio.util.ResObject



fun getPortfolioByTitle(documentId: String): Portfolio? {
    return Portfolio.entries.firstOrNull { it.documentId.equals(documentId, ignoreCase = true) }
}

//"https://test-videos.co.uk/vids/sintel/mp4/h264/360/Sintel_360_10s_1MB.mp4"

enum class Portfolio(
    val documentId: String,
    val thumbnail: String,
    val projectLogo: String,
    val title: String,
    val description: String,
    val videoLink: String,
    val playStoreLink: String,
    val appStoreLink: String,
    val githubLink: String,
    val apkLink: String,
    val otherLink: String
) {
    ColorPickerPro(
        documentId = "Color-Picker-Pro",
        thumbnail = ResObject.Image.colorPickerPro,
        projectLogo = ResObject.Logo.colorPickerPro,
        title = "Color Picker Pro",
        videoLink = "https://videos.zitoscode.com/color picker short.mp4",
        playStoreLink = "https://play.google.com/store/apps/details?id=com.my.zitos.binkes.color.picker.pro",
        appStoreLink = "",
        githubLink = "",
        apkLink = "",
        otherLink = "",
        description = "This feature-rich Android application allows users to **save, create, and extract color codes from images** by simply dragging around the screen in an interactive and fun way.\n" +
                "\n" +
                "This project challenged me to **grow as a developer**, pushing me to apply advanced concepts in Android development. Over the course of **8 months**, I built a complete, production-ready app that strengthened my skills in architecture, **UI/UX design, and scalable development practices**.\n" +
                "\n" +
                "**Technologies & Practices Used**\n" +
                "\n" +
                "* **Kotlin & Jetpack Compose** – modern, declarative UI development\n" +
                "\n" +
                "* **Room Database** – reliable local data persistence\n" +
                "\n" +
                "* **Dependency Injection** – modular, testable architecture\n" +
                "\n" +
                "* **Bitmap & Offset Handling** – precise color extraction with DpOffset and IntOffset\n" +
                "\n" +
                "* **DataStore** – lightweight key-value storage for user preferences\n" +
                "\n" +
                "* **Firestore** – for app update remote syncing\n" +
                "\n" +
                "* **ViewModel (MVVM)** – lifecycle-aware state management\n" +
                "\n" +
                "* **AdMob SDK** – ads integration for monetization\n" +
                "\n" +
                "* **JSON &  Map** – data handling and fast color access\n" +
                "* **IDE** : Android Studio"
    ),




    WhatsAppStatusSaver(
        documentId = "WhatsApp-Status-Saver",
        thumbnail = ResObject.Image.whatsappStatusSaver,
        projectLogo = ResObject.Logo.whatsappStatusSaverLogo,
        title = "Status Saver Oz | Video-Audio",
        videoLink = "https://videos.zitoscode.com/whatsapp_short.mp4",
        playStoreLink = "https://play.google.com/store/apps/details?id=com.my.zitos.binkes.status.saver.plus",
        appStoreLink = "",
        githubLink = "",
        apkLink = "",
        otherLink = "",
        description = "This Android application lets users easily **view, save, and manage WhatsApp statuses (images, videos, and audio)** directly from their device. The app emphasizes simplicity, performance, and clean UI design, while leveraging modern Android libraries to provide a smooth and reliable user experience.\n" +
                "\n" +
                "A key feature of this app is the ability to **convert audio statuses into video format using FFmpeg**, enhancing compatibility and accessibility.\n" +
                "\n" +
                "This project helped me refine my skills in **media handling, permission management, UI customization, and system integration** with core Android components.\n" +
                "\n" +
                "**Technologies & Practices Used**\n" +
                "\n" +
                "* **Kotlin & Jetpack Compose** – modern, declarative UI development\n" +
                "\n" +
                "* **Permission Handling** – secure storage access across multiple Android versions\n" +
                "\n" +
                "* **MediaStore & Media3** – efficient media access and playback\n" +
                "\n" +
                "* **FFmpeg** – audio-to-video conversion for enhanced media support\n" +
                "\n" +
                "* **Firestore** – remote syncing for app updates\n" +
                "\n" +
                "* **ViewModel (MVVM)** – lifecycle-aware state management\n" +
                "\n" +
                "* **AdMob SDK** – ads integration for monetization\n" +
                "\n" +
                "* **IDE** : Android Studio",
    ),

    DOdds(
        documentId = "D-Odds",
        thumbnail = ResObject.Image.dOdds,
        projectLogo = "",
        title = "D Odds",
        videoLink = "https://videos.zitoscode.com/d_odds_short.mp4",
        playStoreLink = "",
        appStoreLink = "",
        githubLink = "",
        apkLink = "",
        otherLink = "",
        description = "DOdds is a cross-platform (Android & iOS) application currently in development.\n" +
                "It’s designed as a **sports prediction app** with extended features for **crypto and forex signals**, combining real-time data, subscriptions, and monetization.\n" +
                "\n" +
                "This ongoing project is pushing me to deepen my expertise in **Kotlin Multiplatform (KMP), Swift**, and scalable cross-platform architecture.\n" +
                "\n" +
                "**Key Features (Planned & In Progress)**\n" +
                "\n" +
                "* Sports prediction engine\n" +
                "\n" +
                "* Crypto & forex signal integration\n" +
                "\n" +
                "* Subscription-based model with Google Play Billing\n" +
                "\n" +
                "* Cross-platform support (Android & iOS)\n" +
                "\n" +
                "* Real-time sync with Firebase (Auth, Firestore, Realtime Database)\n" +
                "\n" +
                "**Technologies & Practices Used**\n" +
                "\n" +
                "* **Kotlin Multiplatform (KMP)** – shared logic for Android & iOS\n" +
                "\n" +
                "* **Jetpack Compose & SwiftUI** – modern UI frameworks\n" +
                "\n" +
                "* **Firebase (Auth, Firestore, Realtime Database)** – cloud sync & authentication\n" +
                "\n" +
                "* **Koin** – dependency injection\n" +
                "\n" +
                "* **Ktor** – networking\n" +
                "\n" +
                "* **DateTime API** – time handling\n" +
                "\n" +
                "* **Google Play Billing** – subscription management\n" +
                "\n" +
                "* **IDE** : Android Studio & Xcode\n" +
                "> [warning] This project is still under development.\n" +
                "Project link will be shared once the first stable release is ready." +
                "\n <br> <br> <p>"
    ),

    ZitosCode(
        documentId = "Zitos-Code",
        thumbnail = ResObject.Image.zitoscode,
        projectLogo = ResObject.Logo.zitosCode,
        title = "Zitos Code",
        videoLink = "https://videos.zitoscode.com/zitoscode_short.mp4",
        playStoreLink = "",
        appStoreLink = "",
        githubLink = "",
        apkLink = "",
        otherLink = "https://zitoscode.com/",
        description = "It's my personal website, designed and developed to showcase my projects, skills, and journey as a developer.\n" +
                "It was built with **Kobweb** and **Kotlin**, running on a modern, scalable web architecture.\n" +
                "\n" +
                "**Technologies & Practices Used**\n" +
                "\n" +
                "* **Kotlin & Kobweb** – full-stack web development\n" +
                "\n" +
                "* **IntelliJ IDEA** – primary IDE for development\n" +
                "\n" +
                "* **Responsive Design** – optimized for desktop and mobile\n" +
                "\n" +
                "* **Clean Architecture** – maintainable and extensible structure\n" +
                "\n" +
                "* **Firestore** –  for dynamic content and data syncing"
    ),

    MultiBrowserToolPro(
        documentId = "Multi-Browser-Tool-Pro",
        thumbnail = ResObject.Image.multiBrowserToolPro,
        projectLogo =  ResObject.Logo.multiBrowserToolLogo,
        title = "Multi Browser Tool Pro",
        videoLink = "https://videos.zitoscode.com/multi_browser_short.mp4",
        playStoreLink = "https://play.google.com/store/apps/details?id=com.my.Zitos.MultiBroser.Tools",
        appStoreLink = "",
        githubLink = "",
        apkLink = "",
        otherLink = "",
        description = "This Android application has over **1,000+ downloads** on Google Play. It enables users to open and operate **multiple web browsers simultaneously**, offering a powerful and flexible browsing experience.\n" +
                "\n" +
                "Key features include:\n" +
                "\n" +
                "* **Multi-browser support** – run and manage multiple web sessions at the same time\n" +
                "\n" +
                "* **Auto-refresh** – users can set custom refresh intervals to automatically reload web pages\n" +
                "\n" +
                "* **Auto-scrolling** – with customizable scroll speeds for seamless content viewing\n" +
                "\n" +
                "* **In-app purchases** – integrated via Google Play Billing for monetization\n" +
                "\n" +
                "This project allowed me to strengthen my skills in **custom WebView handling, multitasking UI, monetization, and advanced Android development practices.**\n" +
                "\n" +
                "**Technologies & Practices Used**\n" +
                "\n" +
                "* **Kotlin & Jetpack Compose** – core app development\n" +
                "\n" +
                "* **WebView API** – powering multi-browser functionality\n" +
                "\n" +
                "* **Google Play Billing** – in-app purchases & monetization\n" +
                "\n" +
                "* **Custom UI Components** – smooth auto-scroll and refresh handling\n" +
                "\n" +
                "* **MVVM Architecture** – clean and maintainable code\n" +
                "\n" +
                "* **IDE** : Android Studio"
    ),

    /*
    ZitosProjectStore(
        documentId = "Zitos-Project-Store",
        thumbnail = ResObject.Image.portfolio5,
        projectLogo = "",
        title = "Zitos Project Store",
        videoLink = "",
        playStoreLink = "",
        appStoreLink = "",
        githubLink = "",
        apkLink = "",
        otherLink = "",
        description = "Android App"
    ),

     */

    TicTacToeGame(
        documentId = "Tic-Tac-Toe-Game",
        thumbnail = ResObject.Image.ticTacToeGameThumbnail,
        projectLogo = "",
        title = "Tic Tac Toe Game",
        videoLink = "https://videos.zitoscode.com/tic_tac_toe_game_short.mp4",
        playStoreLink = "",
        appStoreLink = "",
        githubLink = "https://github.com/kizito18/TicTacToeGame.git",
        apkLink = "",
        otherLink = "",
        description = "This is a fun and interactive Android application that supports both **single-player (with AI opponent)** and **multiplayer modes.**\n" +
                "\n" +
                "The AI opponent was implemented with basic decision-making logic to provide a challenging experience for solo players, while the multiplayer mode allows two users to play on the same device.\n" +
                "\n" +
                "This project helped me strengthen my understanding of **game logic, UI design, and handling user interactions in Android apps.**\n" +
                "\n" +
                "**Technologies & Practices Used**\n" +
                "\n" +
                "* **Kotlin** – core logic and implementation\n" +
                "\n" +
                "* **XML** – UI design and layout management\n" +
                "\n" +
                "* **AI Opponent** – simple decision-making logic\n" +
                "\n" +
                "* **Game State Management** – detecting wins, losses, and draws\n" +
                "\n" +
                "* **IDE** : Android Studio"
    ),


    MyPortfolio(
        documentId = "My-Portfolio",
        thumbnail = ResObject.Image.myPortfolioThumbnail,
        projectLogo = ResObject.Logo.myPortfolio,
        title = "My Portfolio",
        videoLink = "https://videos.zitoscode.com/my_portfolio_short.mp4",
        playStoreLink = "",
        appStoreLink = "",
        githubLink = "",
        apkLink = "",
        otherLink = "https://kizito-portfolio.zitoscode.com/",
        description = "This is my personal **developer portfolio website**, built to showcase my projects, experience, and skills in mobile and web development. It reflects my style of clean UI, modern architecture, and performance-oriented design.\n" +
                "\n" +
                "**Technologies & Practices Used**\n" +
                "\n" +
                "* **Kotlin & Kobweb** – full-stack web development\n" +
                "\n" +
                "* **IntelliJ IDEA** – primary IDE for development\n" +
                "\n" +
                "* **Responsive Design** – optimized for both desktop and mobile\n" +
                "\n" +
                "* **Clean Architecture** – maintainable and scalable project structure"
    ),

    CopyTextOnScreenImages(
    documentId = "Copy-Text-On-Screen-Images",
    thumbnail = ResObject.Image.copyTextOnImage,
    projectLogo = ResObject.Logo.copyTextFromImage,
    title = "Copy Text On Screen Image",
    videoLink = "https://videos.zitoscode.com/copy_text_on_image_short.mp4",
    playStoreLink = "",
    appStoreLink = "",
    githubLink = "",
    apkLink = "https://videos.zitoscode.com/copy_text_from_image.apk",
    otherLink = "",
    description = "This Android application was designed to make extracting and working with text from images simple and accessible.\n" +
            "\n" +
            "**The app allows users to**:\n" +
            "\n" +
            "* Extract text from images \n" +
            "\n" +
            "* Edit, translate, and manage extracted text seamlessly\n" +
            "\n" +
            "* Convert text into multiple formats: PDF, TXT, Document, and PNG\n" +
            "\n" +
            "* Text-to-Speech\n" +
            "\n" +
            "* Cloud saving & sync with Firebase Realtime Database – securely store and retrieve text\n" +
            "\n" +
            "* User Authentication with Firebase – sign in and secure personal data\n" +
            "\n" +
            "* In-app purchases – monetization through Google Play Billing\n" +
            "\n" +
            "This project was originally built using **Sketchware**, showing my ability to deliver a feature-rich product with limited resources early in my journey. It was a key stepping stone that motivated me to transition into **Android Studio, Kotlin, and modern frameworks** for more advanced projects.\n" +
            "\n" +
            "**Technologies & Practices Used**\n" +
            "\n" +
            "* **Sketchware (Visual Programming)** – mobile development platform\n" +
            "\n" +
            "* **OCR (Optical Character Recognition)** – text extraction from images\n" +
            "\n" +
            "* **File Exporting** – PDF, TXT, DOC, and PNG formats\n" +
            "\n" +
            "* **Translation API** \n" +
            "\n" +
            "* **Text-to-Speech**\n" +
            "\n" +
            "* **Firebase Realtime Database** – cloud storage and sync\n" +
            "\n" +
            "* **Firebase Authentication** – secure user login & data access\n" +
            "\n" +
            "* **Google Play Billing** – in-app monetization\n" +
            "\n" +
            "* **IDE** : Sketchware\n" +
            "\n" +
            "<br>\n" +
            "\n" +
            "> [warning]" +
            " Note: This project is deprecated and no longer fully functional.\n " +
            "It represents one of my earliest projects and an important step in my developer journey\n" +
            "\n <br> <br> <p>"

    )
}



