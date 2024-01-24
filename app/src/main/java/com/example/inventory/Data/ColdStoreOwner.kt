package com.example.inventory.Data

  class ColdStoreOwner (
      val userId : String,
     val name: String,
     val age: String,
     val street: String,
     val city:String,
     val  State: String,
     val storeName: String
 ){
      fun toMap(): MutableMap<String, String>{
 return mutableMapOf(
     "User_Id" to this.userId,
     "nameOfTheStoreOwner" to this.name,
     "ageOfTheStoreOwner" to this.age,
     "storeName" to this.storeName,
     "address_street" to this.street,
     "address_city" to this.city,
     "address_state" to this.State


 )
      }
  }
