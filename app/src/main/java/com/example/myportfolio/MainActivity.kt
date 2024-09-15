package com.example.myportfolio

import android.os.Bundle
import android.service.autofill.OnClickAction
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myportfolio.ui.Projects
import com.example.myportfolio.ui.ShowInformation
import com.example.myportfolio.ui.theme.MyPortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPortfolioTheme {
                    MainFunction(listProjects = Projects().listProjects,
                        listCourses = Projects().listProjects)
            }
        }
    }
}

@Composable
fun MainFunction(listProjects:List<Pair<String, String>>,
                 listCourses: List<Pair<String, String>>,
                 modifier: Modifier = Modifier) {
    var open1 by rememberSaveable { mutableStateOf(false) }
    var open2 by rememberSaveable { mutableStateOf(false)}
    Box{

    Column(modifier = modifier
        .fillMaxSize()
        .padding(9.dp)) {
        Text(
            text = "Portfolio",
            textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Row(modifier = Modifier.wrapContentSize()) {

            Image(
                painter = painterResource(id = R.drawable.photo_portfolio),
                contentDescription = "",
                modifier = Modifier
                    .size(96.dp)
                    .padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.padding(9.dp))
            Column(modifier = Modifier) {
                Text(text = "Меня зовут Никульшин Егор")
                Text(text = "Возраст: 19 лет")
                Text(text = "Направление: Android-разработка")
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))


        LazyColumn {

            item {
                Row {

                    Text(text = "Библиотеки, с которыми я работал:")
                    Spacer(modifier = Modifier.weight(1F))
                    IconButton(onClick = { open1 =  !open1}) {
                        Icon(imageVector = if (open1){
                            Icons.Filled.KeyboardArrowDown}
                        else {
                            Icons.Filled.KeyboardArrowUp
                        }, contentDescription = " " )
                    }
                }
            }
            if (open1) {
                items(listCourses) { (key, value) ->
                    ShowProjects(project = key) }
            }

            item {
                Spacer(modifier = Modifier.padding(14.dp))
                Row(modifier = Modifier.wrapContentSize()) {

                    Text(text = "Курсы, которые я проходил:")
                    Spacer(modifier = Modifier.weight(1F))
                    IconButton(
                        onClick = { open2 = !open2 },
                    ) {
                        Icon(
                            imageVector = if (open2) {
                                Icons.Filled.KeyboardArrowDown
                            } else {
                                Icons.Filled.KeyboardArrowUp
                            },

                            contentDescription = ""
                        )
                    }
                }
            }
            if (open2) {
                items(listCourses) { (key, value) ->
                    ShowProjects(project = value)
                }
            }
        }
    }
    }
    Image(
            painter = painterResource(R.drawable.img),
            contentDescription = " ",
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.4f)
        )
    }


@Composable
fun ShowProjects(project: String){
    Column {
        ClickableText(
            text = AnnotatedString(project) ,
            onClick = {

            })
    }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyPortfolioTheme {
       MainFunction(listProjects = Projects().listProjects,
           listCourses = Projects().listProjects)
    }
}