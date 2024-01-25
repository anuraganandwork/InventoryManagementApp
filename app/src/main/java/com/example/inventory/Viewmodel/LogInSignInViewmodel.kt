package com.example.inventory.Viewmodel

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.Data.ColdStoreOwner
import com.example.inventory.Data.Farmer
import com.example.inventory.Data.Farmer_Dao
import com.example.inventory.Repository.Repo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInSignInViewmodel @Inject constructor(val dao:Farmer_Dao): ViewModel()  {
    val auth: FirebaseAuth = Firebase.auth


   private var _listOfFarmers =MutableStateFlow<List<Farmer>>(emptyList())
    val listOFFarmer = _listOfFarmers.asStateFlow()
    init {
viewModelScope.launch {
        dao.getListOfFarmer().collect{
            _listOfFarmers.value=it
        }}
    }

    fun LogInWithEmailAndPass(email: String, password: String,  context: Context ,call:()-> Unit){
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email,password)

                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(context, "Logging In", Toast.LENGTH_SHORT).show()
                            call()
//                            val user = Firebase.auth.currentUser
//                            user!!.sendEmailVerification()
//                                .addOnCompleteListener {
//                                    if (it.isSuccessful){
//                                        call()
//                                    }
//
//                                }
                        }
                    }


            }
            catch (e: Exception){

            }
        }
    }


    fun CreateUserWithEmailAndPass(email: String, password: String,  context:Context,call:()->Unit,){
        viewModelScope.launch {
            try {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            val user = Firebase.auth.currentUser
                            user!!
                                .sendEmailVerification()
                                .addOnCompleteListener {
                                    if (it.isSuccessful){
                                        Toast.makeText(context, "Verification email sent", Toast.LENGTH_SHORT).show()

                                        val nameofstoreowner= user.email?.split('@')?.get(0).toString()
                                        call()
                                        CreateUser(nameofstoreowner,"45","modeltown","jalandahar","Punjab",
                                           " Inj")
                                    }

                                }
                        }
                    }
            }
            catch (e: Exception){

            }
        }
    }

    fun CreateUser(name: String, age: String, street: String,city:String,State: String, storeName: String){

        val userID = auth.currentUser?.uid.toString()
        FirebaseFirestore.getInstance().collection("ColdStoreOwners")
            .add(ColdStoreOwner(userID,name,age,street,city,State,storeName).toMap())
    }


    fun addFarmer(farmer: Farmer){
        viewModelScope.launch {
            dao.AddFarmer(farmer)
        }
    }
}