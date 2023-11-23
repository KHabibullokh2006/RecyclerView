package com.example.myapplication


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun AllPlants(list: MutableList<Plant>, navController: NavHostController) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
    ) {
//        item {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Text(
//                    "\uD83C\uDF3F  Plants for sales",
//                    style = MaterialTheme.typography.titleMedium
//                )
//            }
//        }
        plantCard(list, navController)

    }

}

@OptIn(ExperimentalMaterial3Api::class)
fun LazyGridScope.plantCard(list: MutableList<Plant>, navController: NavHostController) {
    var img: Painter
    items(list.size) {

        if (list[it].status){
            img = painterResource(id = R.drawable.baseline_favorite_24)
        }else{
            img = painterResource(id = R.drawable.baseline_favorite_border_24)
        }

        Card(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(10.dp),
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            onClick = {
                navController.navigate("info" + list[it].name + list[it].price + list[it].name)
            }
        ) {
            Column {
                Image(painter = img, contentDescription = "favourite",Modifier.clickable{}.size(50.dp))
                Image(
                    painter = painterResource(id = list[it].img),
                    contentDescription = list[it].name,
                    modifier = Modifier
                        .size(130.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = list[it].name,
                    color = Color.Black,
                    fontSize = 20.sp
                )
                Text(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    text = list[it].price.toString()
                )
                Row(
                    modifier = Modifier.padding(5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "star",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = list[it].rating.toString(),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }


            }

        }
    }
}

@Composable
fun PlantCard2(list: MutableList<Plant>) {

    Column {
        (1..list.size).forEach {
            Image(
                painter = painterResource(id = list[it].img),
                contentDescription = list[it].name,
                modifier = Modifier
                    .size(130.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = list[it].name,
                color = Color.Black,
                fontSize = 20.sp
            )
            Text(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                text = list[it].price.toString()
            )
            Row(
                modifier = Modifier.padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "star",
                    modifier = Modifier.size(30.dp)
                )
                Text(
                    text = list[it].rating.toString(),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            }
        }
    }

}



