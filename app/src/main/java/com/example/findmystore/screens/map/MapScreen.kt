package com.example.findmystore.screens.map

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.findmystore.R
import com.example.findmystore.domain.StoreModel
import com.example.findmystore.screens.results.ItemNearest
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberUpdatedMarkerState


@Composable
fun MapScreen(store : StoreModel){
val latlng = LatLng(store.Latitude,store.Longitude)
    val cameraPositionState = rememberCameraPositionState{
        position = CameraPosition.fromLatLngZoom(latlng,15f)
    }
    val markerState = rememberUpdatedMarkerState(latlng)

    val context = LocalContext.current

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (map,detail) = createRefs()
        GoogleMap (modifier = Modifier
            .fillMaxSize()
            .constrainAs(map){
                centerTo(parent)
            },
            cameraPositionState = cameraPositionState){
            Marker (state = markerState, title = "Location Marker")

        }
        LazyColumn(
            modifier = Modifier
                .wrapContentHeight()
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .fillMaxWidth()
                .background(colorResource(R.color.black3), shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
                .constrainAs(detail){
                    centerHorizontallyTo(parent)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            item { ItemNearest(store) }
            item {

                Button(
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.gold)
                    ),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    onClick = {
                        val phoneNumber = "tel:"+store.Call
                        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))
                        context.startActivity(dialIntent)
                    }
                )
                {
                    Text("Call to Store",
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

























}