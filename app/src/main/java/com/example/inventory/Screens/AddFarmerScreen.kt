package com.example.inventory.Screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.inventory.Data.Farmer
import com.example.inventory.Viewmodel.LogInSignInViewmodel
import javax.inject.Inject

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddFarmerScreen(viewmodel: LogInSignInViewmodel) {
    val name = rememberSaveable {
        mutableStateOf("")
    }

    val mobileNumber = rememberSaveable {
        mutableStateOf("")
    }

    val aadharNumber = rememberSaveable {
        mutableStateOf("")
    }

    val address = rememberSaveable {
        mutableStateOf("")
    }

    val product = rememberSaveable {
        mutableStateOf("")
    }
    val quantity = rememberSaveable {
        mutableStateOf("")
    }

    val paymentDone = rememberSaveable {
        mutableStateOf("")
    }
    val paymentdues = rememberSaveable {
        mutableStateOf("")
    }
    val stockInDate = rememberSaveable {
        mutableStateOf("")
    }

    val stockOutDate = rememberSaveable {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current
//    val focusManager = remember{FocusManager(}
    val focusManager = LocalFocusManager.current
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        TextField(value = name.value, onValueChange = {name.value = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext =
            {focusManager.moveFocus(FocusDirection.Down)
            keyboardController?.hide()})
            , modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp),
            label = { Text(text = "Enter name")}
        )
        TextField(value = mobileNumber.value, onValueChange = {mobileNumber.value = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext =
            {focusManager.moveFocus(FocusDirection.Down)
                keyboardController?.hide()})
            , modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp)
, label = { Text(text = "Enter mobileNumber")}
        )

        TextField(value = aadharNumber.value, onValueChange = {aadharNumber.value = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext =
            {focusManager.moveFocus(FocusDirection.Down)
                keyboardController?.hide()})
            , modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp)
            , label = { Text(text = "Enter aadharNumber")}
        )

        TextField(value = address.value, onValueChange = {address.value = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext =
            {focusManager.moveFocus(FocusDirection.Down)
                keyboardController?.hide()})
            , modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp)
            , label = { Text(text = "Enter address ")}
        )

        TextField(value = product.value, onValueChange = {product.value = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext =
            {focusManager.moveFocus(FocusDirection.Down)
                keyboardController?.hide()})
            , modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp)
            , label = { Text(text = "Enter product ")}
        )

        TextField(value = quantity.value, onValueChange = {quantity.value = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext =
            {focusManager.moveFocus(FocusDirection.Down)
                keyboardController?.hide()})
            , modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp)
            , label = { Text(text = "Enter quantity")}
        )


        TextField(value = paymentDone.value, onValueChange = {paymentDone.value = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext =
            {focusManager.moveFocus(FocusDirection.Down)
                keyboardController?.hide()})
            , modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp)
            , label = { Text(text = "Enter paymentDone ")}
        )


        TextField(value = paymentdues.value, onValueChange = {paymentdues.value = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext =
            {focusManager.moveFocus(FocusDirection.Down)
                keyboardController?.hide()})
            , modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp)
            , label = { Text(text = "Enter paymentdues ")}
        )

        TextField(value = stockInDate.value, onValueChange = {stockInDate.value = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext =
            {focusManager.moveFocus(FocusDirection.Down)
                keyboardController?.hide()})
            , modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp)
            , label = { Text(text = "Enter stockInDate ")}
        )

        TextField(value = stockOutDate.value, onValueChange = {stockOutDate.value = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext =
            {focusManager.moveFocus(FocusDirection.Down)
                keyboardController?.hide()})
            , modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp)
            , label = { Text(text = "Enter stockOutDate")}
        )

        Button(onClick = {
            viewmodel.addFarmer(Farmer(name = name.value,
                                       mobileNumber = mobileNumber.value,
                                       aadharNumber = aadharNumber.value,
                                       address = address.value,
                                       paymentDone = paymentDone.value,
                                       paymentDues = paymentdues.value,
                                       stockInDate = stockInDate.value,
                                       stockOutDate = stockOutDate.value

                )) }) {
            Text(text = "Add farmer")
        }
    }






}
//310

