package com.example.famgithubuser.config

import java.lang.Boolean

object BuildConfig {
    val DEBUG = Boolean.parseBoolean("true")
    const val APPLICATION_ID = "com.artworkspace.github"
    const val BUILD_TYPE = "debug"
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    // Field from default config.
    const val API_KEY = "null"
}