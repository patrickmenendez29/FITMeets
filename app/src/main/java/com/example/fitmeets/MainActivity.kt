package com.example.fitmeets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.fitmeets.ui.theme.FITMeetsTheme
import com.example.fitmeets.ui.theme.greenColor
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FITMeetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    TabLayout()
                }
            }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@ExperimentalPagerApi
@Composable
fun TabLayout() {
    // tab state manager
    val pagerState = rememberPagerState(pageCount = 3)

    Column(modifier = Modifier.background(Color.White)) {
        TopAppBar(backgroundColor = greenColor) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Tab Layout",
                    style = TextStyle(color = Color.White),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(all = Dp(5f)),
                    textAlign = TextAlign.Center
                )
            }
        }

        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState)
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf(
        "Home" to Icons.Default.Home,
        "Shopping" to Icons.Default.ShoppingCart,
        "Settings" to Icons.Default.Settings
    )

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = greenColor,
        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )

        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(

                icon = {
                    Icon(imageVector = list[index].second, contentDescription = null)
                },

                text = {
                    Text(
                        list[index].first,
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )

        }
    }
}



// on below line we are creating a tab content method
// in which we will be displaying the individual page of our tab .
@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    // on below line we are creating
    // horizontal pager for our tab layout.
    HorizontalPager(state = pagerState) {
        // on below line we are specifying
        // the different pages.
            page ->
        when (page) {
            // on below line we are calling tab content screen
            // and specifying data as Home Screen.
            0 -> TabContentScreen(data = "Welcome to Home Screen")
            // on below line we are calling tab content screen
            // and specifying data as Shopping Screen.
            1 -> TabContentScreen(data = "Welcome to Shopping Screen")
            // on below line we are calling tab content screen
            // and specifying data as Settings Screen.
            2 -> TabContentScreen(data = "Welcome to Settings Screen")
        }
    }
}

// on below line we are creating a Tab Content
// Screen for displaying a simple text message.
@Composable
fun TabContentScreen(data: String) {
    // on below line we are creating a column
    Column(
        // in this column we are specifying modifier
        // and aligning it center of the screen on below lines.
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // in this column we are specifying the text
        Text(
            // on below line we are specifying the text message
            text = data,

            // on below line we are specifying the text style.
            style = MaterialTheme.typography.h5,

            // on below line we are specifying the text color
            color = greenColor,

            // on below line we are specifying the font weight
            fontWeight = FontWeight.Bold,

            //on below line we are specifying the text alignment.
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable


fun DefaultPreview() {
    FITMeetsTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            TabLayout()
        }
    }
}