package com.example.myportfolio.ui

import com.example.myportfolio.R

class Projects {

    val mars_photos: Set<Pair<Int, Int>> = setOf<Pair<Int, Int>>(
        R.string.description_mars_photos to R.drawable.mars_photos
    )

    val inventory_app: Set<Pair<Int, Int>> = setOf<Pair<Int, Int>>(
        R.string.description_inventory_app to R.drawable.inventory_app
    )


    val listProjects: List<Pair<Int, Set<Pair<Int, Int>>>> =
        listOf<Pair<Int, Set<Pair<Int, Int>>>>(
        R.string.mars_photos to mars_photos,
        R.string.inventory_app to inventory_app,
        R.string.list_notes to inventory_app
    )
    val listCourses: List<Pair<String, String>> = listOf<Pair<String, String>>(
        "Information" to "Retrofit",
        "scaj" to "Room",
        "Json" to "Json"
    )

}