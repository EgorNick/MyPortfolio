package com.example.myportfolio.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShowInformation(projectName: String){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (projectName.isNotBlank()) {
            Column {
                Text(text = "Project: $projectName")
            }
        } else {
            Text(text = "No project information available")
        }
    }
}