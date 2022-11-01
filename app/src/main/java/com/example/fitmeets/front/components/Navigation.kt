package com.example.fitmeets.front.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

sealed class NavigationItem(var route: String, var icon: Int, var title: String ) {
    object Home: NavigationItem("home",0, "Home" )
    object Profile: NavigationItem("profile", 1, "My profile")
    object Search: NavigationItem("search", 2, "Search")
    object Inbox: NavigationItem("inbox", 3, "My inbox")

}


@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = colorResource(id = R.color.colorPrimary),
        contentColor = Color.White
    )
}


@Composable
fun BottomNavigationBar() {
    val items = listOf(

         NavigationItem.Home,
         NavigationItem.Profile,
         NavigationItem.Search,
         NavigationItem.Inbox

    )
    BottomNavigation(
        backgroundColor = Color.Red,
        contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    /* Add code later */
                }

            )
        }
    }
}


@Composable
fun NavigationView() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar()},
        backgroundColor = Color.LightGray,
        content = { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            )    {

            }

        }

    )
}