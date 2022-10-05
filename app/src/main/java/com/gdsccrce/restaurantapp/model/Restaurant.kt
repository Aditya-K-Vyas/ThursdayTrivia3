package com.gdsccrce.restaurantapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Restaurant(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,

    )
