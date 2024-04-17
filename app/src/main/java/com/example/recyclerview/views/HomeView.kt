package com.example.recyclerview.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.recyclerview.R


@Composable
fun HomeView(navController: NavHostController) {

    //Variables
    var age: Int by remember {mutableStateOf(0)}
    var budget: Int by remember {mutableStateOf(0)}

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Ingresa tus datos",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = age.toString(),
            onValueChange = {age = it.toInt()},
            label = { Text("Edad") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            leadingIcon = {
                Icon (
                    painter = painterResource(id = R.drawable.age),
                    contentDescription = "Password",
                    tint = Color(0xFF009688),
                )},
        )

        Spacer(modifier = Modifier.height(2.dp))

        OutlinedTextField(
            value = budget.toString(),
            onValueChange = {budget = it.toInt()},
            label = { Text("Presupuesto") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            leadingIcon = {
                Icon (
                    painter = painterResource(id = R.drawable.cash),
                    contentDescription = "Password",
                    tint = Color(0xFF009688),
                )},
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                navController.navigate("GameView/$age/$budget")
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF009688)),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(
                text = "Ver productos",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFFFFF),
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Home() {
    HomeView(navController = rememberNavController())
}