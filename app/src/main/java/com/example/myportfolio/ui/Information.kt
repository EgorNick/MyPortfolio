package com.example.myportfolio.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myportfolio.R
import com.example.myportfolio.ui.theme.MyPortfolioTheme

@Composable
fun ShowInformation(projectDescription: String, image: Int){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (projectDescription.isNotBlank()) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = projectDescription.toInt()),
                    modifier = Modifier.padding(14.dp),
                        textAlign = TextAlign.Center)
                Image(painter = painterResource(image),
                    contentDescription = " ",
                    modifier = Modifier.size(200.dp)
                            .padding(top = 14.dp))
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
        ShowInformation(projectDescription = "hdhsjkfh", image = R.drawable.photo_portfolio)
    }
}