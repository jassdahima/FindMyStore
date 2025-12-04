package com.example.findmystore.screens.results

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.findmystore.R

@Composable
fun Search(){
    var text by rememberSaveable {mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {text = it},
        label = {
            Text(text = "Find Stores",
                fontSize = 16.sp,
                color = Color.LightGray,
            )
        }, shape = RoundedCornerShape(10.dp),
        leadingIcon = {
            Image(painter = painterResource(id = R.drawable.search_icon),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(R.color.black3),
            unfocusedContainerColor = colorResource(R.color.black3),
            disabledContainerColor = colorResource(R.color.black3),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedTextColor = Color.White,
            cursorColor = Color.White,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(50.dp)
            .background(Color.White, shape = RoundedCornerShape(10.dp)),
    )
}