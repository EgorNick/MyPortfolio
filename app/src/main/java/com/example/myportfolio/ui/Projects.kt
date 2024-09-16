package com.example.myportfolio.ui

import com.example.myportfolio.R

class Projects {
    val listProjects: List<Pair<String, Int>> = listOf<Pair<String, Int>>(
        "Information" to R.string.app_name,
        "scaj" to R.string.app_name,
        "Json" to R.string.app_name
    )
    val listCourses: List<Pair<String, String>> = listOf<Pair<String, String>>(
        "Information" to "Retrofit",
        "scaj" to "Room",
        "Json" to "Json"
    )
}