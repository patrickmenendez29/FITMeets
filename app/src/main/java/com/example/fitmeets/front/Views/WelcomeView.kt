package com.example.fitmeets.front.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.fitmeets.back.Account
import com.example.fitmeets.back.WelcomeViewController


@Composable
fun WelcomeView() {

    val usernameState = remember { mutableStateOf(TextFieldValue())}
    val passwordState = remember { mutableStateOf(TextFieldValue())}
    val controller = WelcomeViewController()

    fun login() {
        val account: Account? = controller.login(usernameState.value.text, passwordState.value.text)
        if (account !is Account) return // guard clause
        // transition to next page
    }

    fun createAccount(){
        // push create account form
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "FIT Meets")

        Text(text = "Welcome, please login")

        TextField(value = usernameState.value, onValueChange = { usernameState.value = it })

        TextField(value = passwordState.value, onValueChange = { passwordState.value = it })

        Button(onClick = { login() }) {
            Text(text = "Login")
        }

        Text(text = "Not registered yet?")
        Button(onClick = { createAccount() }) {
            Text(text = "Create account")
        }

    }


}


@Composable
@Preview(showBackground = true)
fun WelcomePreview() {
    WelcomeView()
}