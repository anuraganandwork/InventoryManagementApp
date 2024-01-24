package com.example.inventory.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Farmer::class], version = 1)
abstract class Databasse: RoomDatabase() {

  abstract fun Farmer_Dao():Farmer_Dao
}