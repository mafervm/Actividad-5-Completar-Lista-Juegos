package com.example.recyclerview.views

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.recyclerview.viewmodels.GamesViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

fun AgeCheck(age: Int, classification: String): Boolean {
    if (classification == "E") {
        return true
    } else if (classification == "E+10" && age >= 10) {
        return true
    } else if (classification == "T" && age >= 13) {
        return true
    } else if (classification == "M" && age >= 17) {
        return true
    } else if (classification == "AO" && age >= 18) {
        return true
    } else {
        return false
    }
    return false
}

@Composable
fun GameView(navController: NavHostController, age: Int, budget: Int) {
    val GamesViewModel = GamesViewModel()
    val Context = LocalContext.current
    var available: Int by remember { mutableStateOf(budget) }
    var total: Int by remember { mutableStateOf(0) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {

        Box (
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {navController.popBackStack()},
                colors = ButtonDefaults.buttonColors(Color(0xFF009688)),
            ) {
                Text(text = "<", fontWeight = FontWeight.Bold)
            }

            Text(
                text = "Videojuegos",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Total: $$total",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Disponible: $$available",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Edad: $age",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(2.dp))

        Button(
            onClick = {navController.navigate("FinalView/$total")},
            colors = ButtonDefaults.buttonColors(Color(0xFF009688)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Finalizar compra", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {
            items(GamesViewModel.getGameList()) {
                    game ->

                GameCard(game)

                Spacer(modifier = Modifier.height(5.dp))

                Button(
                    onClick = {
                        val isAbleToBuy = AgeCheck(age, game.classification)

                        if (isAbleToBuy) {
                            if (available >= game.price) {
                                available = available - game.price
                                total = total + game.price
                            } else {
                                Toast
                                    .makeText(Context, "Fondos insuficientes.", Toast.LENGTH_LONG)
                                    .show()
                            }
                        } else {
                            Toast
                                .makeText(Context, "Tu edad no te permite comprar este videojuego.", Toast.LENGTH_LONG)
                                .show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFF673AB7)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Agregar")
                }

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Game() {
    GameView(navController = rememberNavController(), 18, 10000)
}