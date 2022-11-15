package com.example.fitmeets.front.Views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.fitmeets.back.WelcomeViewController


@Composable
fun WelcomeView() {

    val usernameState = remember { mutableStateOf(TextFieldValue())}
    val passwordState = remember { mutableStateOf(TextFieldValue())}

    Column {

        Text(text = "FIT Meets")

        Text(text = "Welcome, please login")

        TextField(value = usernameState.value, onValueChange = { usernameState.value = it })

        TextField(value = passwordState.value, onValueChange = { passwordState.value = it })

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Login")
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Create account")
        }

    }

}


@Composable
@Preview(showBackground = true)
fun WelcomePreview() {

}