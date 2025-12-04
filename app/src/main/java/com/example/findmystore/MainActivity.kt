package com.example.findmystore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.findmystore.domain.StoreModel
import com.example.findmystore.screens.dashboard.DashboardScreen
import com.example.findmystore.screens.map.MapScreen
import com.example.findmystore.screens.results.ResultList

import com.example.findmystore.ui.theme.FindMyStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FindMyStoreTheme {
                MainApp()



                }
            }
        }
    }

sealed class Screen{
    data object Dashboard : Screen()
    data class Results(val id : String,val title : String): Screen()
    data class Map(val store : StoreModel): Screen()
}

@Composable
fun MainApp() {

    val backStack = remember { mutableStateListOf<Screen>(Screen.Dashboard) }
    val currentScreen = backStack.last()

    fun popBackStack() {
        if (backStack.size > 1) {
            backStack.removeAt(backStack.lastIndex)
        }
    }

    BackHandler(enabled = backStack.size > 1) {
        popBackStack()
    }

    when (val screen = currentScreen) {
        Screen.Dashboard -> {
            DashboardScreen(onCategoryClick = {id,title ->
                backStack.add(Screen.Results(id,title))
            })
        }
        is Screen.Results -> {
            ResultList(
                id = screen.id,
                title = screen.title,
                onBackClick = {
                    popBackStack()
                }, onStoreClick = {
                    store ->
                    backStack.add(Screen.Map(store))

                }
            )
        }
        is Screen.Map ->{
            MapScreen(store = screen.store)
        }
    }
}


