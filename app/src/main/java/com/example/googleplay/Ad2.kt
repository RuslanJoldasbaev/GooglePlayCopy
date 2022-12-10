package com.example.googleplay

import androidx.annotation.DrawableRes

data class Ad2(
    @DrawableRes val image: Int,
    val name: String,
    val description: String,
    val add:String
): Item()
