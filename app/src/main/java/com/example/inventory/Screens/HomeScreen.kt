package com.example.inventory.Screens

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inventory.AllScreens.AllScreens
import com.example.inventory.Data.Farmer
import com.example.inventory.R
import java.util.Date

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun HomeScreen(navController: NavController){
   Scaffold(topBar = {
       TopAppBar(title = { Text(text = "Iventory Master")},
           navigationIcon = { Icon(painter = painterResource(id = R.drawable.dots), contentDescription ="three dots" , modifier = Modifier.size(16.dp))},
           modifier = Modifier.clickable {  }, contentColor = Color.White, elevation = 5.dp)
     },
       bottomBar = {
           BottomAppBar() {
               Row(horizontalArrangement = Arrangement.SpaceBetween  ) {
                   Icon(painter = painterResource(id = R.drawable.homepage), contentDescription = "HOme"
                       ,modifier = Modifier.clickable {  }.size(16.dp))

                   Icon(painter = painterResource(id = R.drawable.user), contentDescription = "Farmers"
                       ,modifier = Modifier.clickable {  }.size(16.dp))

                   Icon(painter = painterResource(id = R.drawable.setting), contentDescription = "Farmers"
                       ,modifier = Modifier.clickable {  }.size(16.dp))

               }
           }
       }
   
   
   ){
  homeContent(modifier = Modifier.padding(it), navController)
   }

}

@SuppressLint("SimpleDateFormat")
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun homeContent(modifier: Modifier,navController: NavController){
    Column {
        Surface(shape = RectangleShape, color= Color(83, 120, 102, 255)) {
            Column {
                Text(text = SimpleDateFormat("dd-MM-yyyy" ).format(Date()))

                Divider(thickness = 1.dp, modifier = Modifier.fillMaxWidth())

                Text(text = "Sales")

            }

        }

        Button(onClick = { navController.navigate(AllScreens.AddFarmerScreen.name) }) {
            Text(text = "Add farmer")
        }
    }
}



//1252