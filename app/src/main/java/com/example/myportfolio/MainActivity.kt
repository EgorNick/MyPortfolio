@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myportfolio

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myportfolio.ui.Projects
import com.example.myportfolio.ui.ShowCourses
import com.example.myportfolio.ui.ShowInformation
import com.example.myportfolio.ui.theme.MyPortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPortfolioTheme {
                   Navigation()
            }
        }
    }
}


@Composable
fun ShowTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(18.dp)
                )

            }
        },
        modifier = modifier
    )
}

@Composable
fun MainFunction(listProjects:List<Pair<Int, Set<Pair<Int, Int>>>>,
                 listCourses: List<Pair<Int, Int>>,
                 navController: NavController,
                 modifier: Modifier = Modifier) {
    var open1 by rememberSaveable { mutableStateOf(false) }
    var open2 by rememberSaveable { mutableStateOf(false)}
    Scaffold(topBar = {ShowTopAppBar()}) { it ->
        LazyColumn(contentPadding = it) {


            item {
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
                        Text(
                            text = stringResource(R.string.inform_bio),
                            textAlign = TextAlign.Start,
                        )
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(16.dp)) }


            item {
                Row {

                    Text(text = stringResource(R.string.used_libraries))
                    Spacer(modifier = Modifier.weight(1F))
                    IconButton(onClick = { open1 = !open1 }) {
                        Icon(
                            imageVector = if (open1) {
                                Icons.Filled.KeyboardArrowDown
                            } else {
                                Icons.Filled.KeyboardArrowUp
                            }, contentDescription = " "
                        )
                    }
                }
            }
            if (open1) items(listProjects) { (key, value) ->
                ShowProjects(key = key, project = value, navController)
            }

            item {
                Spacer(modifier = Modifier.padding(14.dp))

                Row(modifier = Modifier.wrapContentSize()) {

                    Text(text = stringResource(R.string.used_courses))
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
                    ShowCourses(name = key, link = value)
                }
            }
        }
    }
    }



@Composable
fun ShowProjects(key: Int, project:Set<Pair<Int, Int>>, navController: NavController){
    Column {
        project.forEach { (stringId, imageId) ->
            ClickableText(
                text = AnnotatedString(stringResource(key)),
                onClick = {
                    if (stringId.toString().isNotBlank()) {
                        // Кодируем projectName для безопасной передачи в URL
                        navController.navigate("project_detail/${Uri.encode(stringId.toString())}/$imageId")
                    }
                },
                modifier = Modifier.padding(top = 18.dp))
        }
    }
    }




@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "project_list") {
        composable("project_list") {
            MainFunction(
                listCourses = Projects().listCourses,
                listProjects = Projects().listProjects,
                navController = navController
            )
        }
        composable("project_detail/{projectName}/{image}") { backStackEntry ->
            val projectDescription = backStackEntry.arguments?.getString("projectName") ?: ""
            val projectImage = backStackEntry.arguments?.getString("image")?.toIntOrNull() ?: 0
            ShowInformation(projectDescription, projectImage)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyPortfolioTheme {
       Navigation()
    }
}