package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    val plantList:MutableList<Plant> = mutableListOf()
                    plantList.add(Plant("Aloe Vera", 35,4.5,R.drawable.aloe_vera))
                    plantList.add(Plant("Calendula", 36,4.7,R.drawable.calendula))
                    plantList.add(Plant("Chamomile", 37,3.9,R.drawable.chamomile))
                    plantList.add(Plant("Cilantro", 38,3.2,R.drawable.cilantro))
                    plantList.add(Plant("Cucumber", 39,4.4,R.drawable.cucumber))
                    plantList.add(Plant("Jojoba", 40,4.1,R.drawable.jojoba))
                    plantList.add(Plant("Kiwi", 41,3.5,R.drawable.kiwi))
                    plantList.add(Plant("Lavender", 52,2.1,R.drawable.lavender))
                    plantList.add(Plant("Orange", 29,1.3,R.drawable.orange))
                    plantList.add(Plant("Rose", 15,4.6,R.drawable.rose))
                    plantList.add(Plant("Rosemary", 63,3.8,R.drawable.rosemary))
                    plantList.add(Plant("Tea Tree", 78,5.0,R.drawable.tea_tree))
                    
                    AllPlants(list = plantList, navController)
                }
            }
        }
    }
}
