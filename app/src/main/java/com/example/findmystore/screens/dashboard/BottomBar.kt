package com.example.findmystore.screens.dashboard

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.findmystore.R

data class BottomMenuItem(
    val label : String,
    val icon : Painter
)

@Composable
fun prepareBottomMenu() : List<BottomMenuItem>{
    val bottomMenuItemList = arrayListOf<BottomMenuItem>()

    bottomMenuItemList.add(
        BottomMenuItem(label = "Home",icon = painterResource(R.drawable.btn_1))
    )

    bottomMenuItemList.add(
        BottomMenuItem(label = "Support",icon = painterResource(R.drawable.btn_2))
    )

    bottomMenuItemList.add(
        BottomMenuItem(label = "Wishlist",icon = painterResource(R.drawable.btn_3))
    )

    bottomMenuItemList.add(
        BottomMenuItem(label = "Profile",icon = painterResource(R.drawable.btn_4))
    )

    return bottomMenuItemList
}

@Composable

fun BottomBar(){
    val bottomMenuItemList = prepareBottomMenu()
    val context = LocalContext.current
    var selected by remember{ mutableStateOf("home") }

    BottomAppBar(
        containerColor = colorResource(id = R.color.black3),
       tonalElevation = 3.dp
    ) {
        bottomMenuItemList.forEach { bottomMenuItemList ->
            NavigationBarItem(
                selected = (selected == bottomMenuItemList.label),
                onClick = {
                    selected = bottomMenuItemList.label
                    Toast.makeText(context, bottomMenuItemList.label, Toast.LENGTH_SHORT).show()
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = bottomMenuItemList.icon,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .size(20.dp)
                        )
                        Text(
                            text = bottomMenuItemList.label,
                            fontSize = 12.sp,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            )

        }
    }
}













































