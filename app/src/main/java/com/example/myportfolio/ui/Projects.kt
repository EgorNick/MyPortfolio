package com.example.myportfolio.ui

import com.example.myportfolio.R

class Projects {

    val mars_photos: Set<Pair<Int, Int>> = setOf<Pair<Int, Int>>(
        R.string.description_mars_photos to R.drawable.mars_photos
    )

    val inventory_app: Set<Pair<Int, Int>> = setOf<Pair<Int, Int>>(
        R.string.description_inventory_app to R.drawable.inventory_app
    )

    val notes_app: Set<Pair<Int, Int>> = setOf<Pair<Int, Int>>(
        R.string.description_notes to R.drawable.notes_to_self
    )


    val listProjects: List<Pair<Int, Set<Pair<Int, Int>>>> =
        listOf<Pair<Int, Set<Pair<Int, Int>>>>(
        R.string.mars_photos to mars_photos,
        R.string.inventory_app to inventory_app,
        R.string.list_notes to notes_app
    )

    val listCourses: List<Pair<Int, Int>> = listOf<Pair<Int, Int>>(
        R.string.android_developer_course to R.string.link_android_dev,
    )

}