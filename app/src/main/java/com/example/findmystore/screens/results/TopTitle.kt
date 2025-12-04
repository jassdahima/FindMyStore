package com.example.findmystore.screens.results

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.findmystore.R

@Composable
fun TopTitle(title : String = "title",onBackClick : () -> Unit = {}){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(130.dp)
    ){
        Row(modifier = Modifier
            .align(Alignment.Center)
            .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .size(10.dp)
                    .clickable{onBackClick()}
            )

            Text(text = title + " Stores Result",
                fontSize = 20.sp,
                color = colorResource(R.color.gold),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                fontWeight = FontWeight.Bold
            )


        }
    }

}