package com.example.thirtydays.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip (
    val dayNumber : Int,
    @StringRes val title : Int,
    @StringRes val description : Int,
    @DrawableRes val imageResourceId: Int
)