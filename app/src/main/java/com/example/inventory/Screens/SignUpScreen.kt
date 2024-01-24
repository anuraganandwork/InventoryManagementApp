package com.example.inventory.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.inventory.AllScreens.AllScreens
import com.example.inventory.Viewmodel.LogInSignInViewmodel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(navController: NavController, viewModel: LogInSignInViewmodel){
   val context= LocalContext.current

    var email = rememberSaveable{
        mutableStateOf("")
    }
    var password = rememberSaveable{
        mutableStateOf("")
    }
    val StoreName= rememberSaveable {
        mutableStateOf("")
    }
    val StreetAddress= rememberSaveable {
        mutableStateOf("")
    }

    val City= rememberSaveable {
        mutableStateOf("")
    }

    val StateName= rememberSaveable {
        mutableStateOf("")
    }

    val age= rememberSaveable {
        mutableStateOf("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    val showError = remember {
        mutableStateOf(false)
    }
    val showEmailError = remember {
        mutableStateOf(false)
    }
    val focusManager= LocalFocusManager.current
    val focusRequester = remember{ FocusRequester() }
    var passwordVisible = remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(500.dp)
        .padding(10.dp)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "InventoryMaster",  fontSize = 30.sp, fontWeight = FontWeight.ExtraBold,
        )
        Spacer(modifier = Modifier.padding(30.dp))

        if (showEmailError.value == true){
            Text(text = "Email is not appropriate!", color = Color.Red, textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth())
        }
        TextField(value =  email.value, onValueChange = {email.value = it} ,
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            label={ Text(text="Enter Email") },
            keyboardOptions =  KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {keyboardController?.hide()
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )
        )

        Spacer(modifier = Modifier.padding(10.dp))

        TextField(value =  password.value,
            onValueChange = {password.value = it},
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            label = { Text(text = "Enter Password") },

            keyboardOptions =  KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Password),
            keyboardActions = KeyboardActions(
                onNext = {keyboardController?.hide()
                    focusManager.clearFocus(false)
                }
            ),
            singleLine = true,


            )


        Spacer(modifier = Modifier.padding(10.dp))

        TextField(value =  StoreName.value, onValueChange = {email.value = it} ,
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            label={ Text(text="Enter StoreName") },
            keyboardOptions =  KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {keyboardController?.hide()
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )
        )

        Spacer(modifier = Modifier.padding(10.dp))

        TextField(value =  StreetAddress.value, onValueChange = {email.value = it} ,
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            label={ Text(text="Enter Street Address") },
            keyboardOptions =  KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {keyboardController?.hide()
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )
        )

        Spacer(modifier = Modifier.padding(10.dp))

        TextField(value =  City.value, onValueChange = {email.value = it} ,
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            label={ Text(text="Enter your city") },
            keyboardOptions =  KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {keyboardController?.hide()
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )
        )

        Spacer(modifier = Modifier.padding(10.dp))

        TextField(value =  StateName.value, onValueChange = {email.value = it} ,
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            label={ Text(text="Enter your state") },
            keyboardOptions =  KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {keyboardController?.hide()
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )
        )

        Spacer(modifier = Modifier.padding(10.dp))

        TextField(value =  age.value, onValueChange = {email.value = it} ,
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            label={ Text(text="Enter your aqe") },
            keyboardOptions =  KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {keyboardController?.hide()
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )
        )




        if (showError.value){
            Text(text = "Please check the information and retry. ", color = Color.Red)
        }
        Button(onClick = {

            if(email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()){

                if (email.value.contains('@') && email.value.contains('.'))

                {
                    viewModel.CreateUserWithEmailAndPass(email.value,password.value, context  ){
                        navController.navigate(AllScreens.HomeScreen.name)
                    }

                    email.value=""
                    password.value=""
                }
                else
                {showEmailError.value= true}

            }
            else { showError.value = true}




        }) {
            Text(text = "Sign Up")
        }
        Spacer(modifier = Modifier.padding(20.dp))

        Row {
            Text(text = "Already user?")
            Text(text = "Log in", fontWeight = FontWeight.Bold ,
                modifier = Modifier.clickable {
                    navController.navigate(AllScreens.LogInScreen.name)
                })
        }

    }
}

// check pass and email, add small text under if that email is emply on clicking buttion

//@Preview
//@Composable
//fun preLOg(){
//    LoginScreen()
//}


