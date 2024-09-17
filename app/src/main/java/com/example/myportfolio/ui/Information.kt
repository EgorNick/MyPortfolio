package com.example.myportfolio.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myportfolio.R
import com.example.myportfolio.ui.theme.MyPortfolioTheme

@Composable
fun ShowInformation(projectName: String, image: Int){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (projectName.isNotBlank()) {
            Column(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                Text(text = stringResource(id = projectName.toInt()))
                Image(painter = painterResource(image), contentDescription = " " )
            }
        } else {
            Text(text = "No project information available")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartPreview(){
    MyPortfolioTheme {
        ShowInformation(projectName = "hdhsjkfh", image = R.drawable.photo_portfolio)
    }
}