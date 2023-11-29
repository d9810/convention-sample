package com.dhicc.convention

import org.gradle.api.Project

// SDK Versions
private const val PROPERTY_COMPILE_SDK = "compileSdk"
private const val PROPERTY_MIN_SDK = "minSdk"
private const val PROPERTY_TARGET_SDK = "targetSdk"

val Project.compileSdkProperty: Int
    get() = property(PROPERTY_COMPILE_SDK).toString().toInt()
val Project.minSdkProperty: Int
    get() = property(PROPERTY_MIN_SDK).toString().toInt()
val Project.targetSdkProperty: Int
    get() = property(PROPERTY_TARGET_SDK).toString().toInt()
// APP Versions
private const val PROPERTY_VERSION_CODE = "versionCode"
private const val PROPERTY_VERSION_NAME = "versionName"

val Project.versionCodeProperty: Int
    get() = property(PROPERTY_VERSION_CODE).toString().toInt()
val Project.versionNameProperty: String
    get() = property(PROPERTY_VERSION_NAME).toString()