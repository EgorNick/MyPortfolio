package com.example.myportfolio.ui

import com.example.myportfolio.R

class Projects {

    val retrofit: Set<Pair<Int, Int>> = setOf<Pair<Int, Int>>(
        R.string.app_name to R.drawable.img
    )

    val listProjects: List<Pair<String, Set<Pair<Int, Int>>>> =
        listOf<Pair<String, Set<Pair<Int, Int>>>>(
        "Information" to retrofit,
        "scaj" to retrofit,
        "Json" to retrofit
    )
    val listCourses: List<Pair<String, String>> = listOf<Pair<String, String>>(
        "Information" to "Retrofit",
        "scaj" to "Room",
        "Json" to "Json"
    )

}