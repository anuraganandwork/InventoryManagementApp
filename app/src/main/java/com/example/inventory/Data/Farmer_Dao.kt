package com.example.inventory.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Farmer_Dao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun AddFarmer(farmer: Farmer)

    @Delete
    suspend fun DelFarmer(farmer: Farmer)

    @Query("SELECT * from Farmer_Database where id=:id")
    suspend fun getFarmer(id:Int):Farmer

    @Query("SELECT * from Farmer_Database")
    fun getListOfFarmer():Flow<List<Farmer>>

}
//1220