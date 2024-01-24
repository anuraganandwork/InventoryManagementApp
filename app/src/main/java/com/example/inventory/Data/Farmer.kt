package com.example.inventory.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Farmer_Database")
data class Farmer(

    @PrimaryKey(autoGenerate = true)
    val id:Int= 0,

    @ColumnInfo("name of farmers")
    val name: String,

    @ColumnInfo("mobileNumber of farmers")
    val mobileNumber : String,

    @ColumnInfo("aadharNumber of farmers")
    val aadharNumber: String,

    @ColumnInfo("Address of farmers")
    val address: String,

//    @ColumnInfo("Product")
//    val product: List<String>,
//
//    @ColumnInfo("Quanity")
//    val quantity : List<String>,

    @ColumnInfo("PaymentDues")
    val paymentDues : String,

    @ColumnInfo("PaymentDone")
    val paymentDone : String,


    @ColumnInfo("StockInDate")
    val stockInDate : String,

    @ColumnInfo("StockOutDate")
    val stockOutDate : String
)

