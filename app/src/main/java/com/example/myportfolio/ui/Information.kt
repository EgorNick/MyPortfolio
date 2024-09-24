package com.example.myportfolio.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
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
                    modifier = Modifier
                        .size(200.dp)
                        .padding(top = 14.dp))
            }
        } else {
            Text(text = stringResource(id = R.string.no_description))
        }
    }
}

@Composable
fun ShowCourses(name: Int, link: Int){
    val context = LocalContext.current
    val url = stringResource(id = link)
    Column(modifier = Modifier.padding(14.dp)) {
        Text(text = stringResource(name, link))
        ClickableText(
            text = AnnotatedString(stringResource(id = link)),
            onClick = {
                val url = url
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            },
            style = TextStyle(
                color = Cyan,
            )
        )
        }
    }

@Preview(showBackground = true)
@Composable
fun StartPreview(){
    MyPortfolioTheme {
        ShowInformation(projectDescription = "hdhsjkfh", image = R.drawable.photo_portfolio)
    }
}