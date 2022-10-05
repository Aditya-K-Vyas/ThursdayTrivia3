package com.gdsccrce.restaurantapp.data

import com.gdsccrce.restaurantapp.R
import com.gdsccrce.restaurantapp.model.Restaurant

class Datasource() {
    fun loadRestaurants():List<Restaurant>{
        return listOf<Restaurant>(
            Restaurant(R.string.imag_name1, R.drawable.rimage1),
            Restaurant(R.string.imag_name2, R.drawable.rimage2),
            Restaurant(R.string.imag_name3, R.drawable.rimage3),
            Restaurant(R.string.imag_name4, R.drawable.rimage4),
            Restaurant(R.string.imag_name5, R.drawable.rimage5),
            Restaurant(R.string.imag_name6, R.drawable.rimage6),
            Restaurant(R.string.imag_name7, R.drawable.rimage7),
            Restaurant(R.string.imag_name8, R.drawable.rimage8),





            )

    }
}