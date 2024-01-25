package com.example.inventory.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inventory.Data.Farmer
import com.example.inventory.Viewmodel.LogInSignInViewmodel

@Composable
fun FarmersListScreen(viewmodel: LogInSignInViewmodel){

    val list = viewmodel.listOFFarmer.collectAsState().value


 LazyColumn(){
     items(list){
        farmerCard(farmer = it)
         Spacer(modifier = Modifier.padding(10.dp))
     }
 }

}

@Composable
fun farmerCard(farmer: Farmer){
    Surface(color = Color(170, 229, 173, 255),

        modifier = Modifier.fillMaxWidth().padding(10.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Column {
            Text(text = farmer.name, modifier = Modifier.padding(10.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(10.dp)) {
                Text(text = "Last transaction : ", fontSize = 10.sp)
                Text(text = farmer.stockInDate , fontSize = 10.sp)  //DATE
            }

        }
    }

}

//1240