package com.example.googleplay

import androidx.annotation.DrawableRes

data class Ad1(
    @DrawableRes val image: Int,
    @DrawableRes val image2: Int,
    val id: Int,
    val name: String,
    val description: String
)
