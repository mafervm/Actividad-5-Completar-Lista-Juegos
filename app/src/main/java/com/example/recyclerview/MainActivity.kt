package com.example.recyclerview

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import com.example.recyclerview.ui.theme.RecyclerViewTheme
import com.example.recyclerview.viewmodels.GameViewModel
import com.example.recyclerview.views.CardGame
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainView(){
    val gamesViewModel = GameViewModel()
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Column {
            Text(text = "Bienvenido a My Game List")
            LazyColumn{
                item {
                    Text (text= "Selecciona un juego")
                }
                items(gamesViewModel.getGameList()){game ->
                    //dentro de los parentesis va la lista o arreglo de datos
                    //dentro de las llaver seria la vista a repetir
                    CardGame(game)
                }

                item{
                    Button(onClick = {}){
                        Text(text = "Ir al Carrito")
                    }
                }
            }
            Text(text = "Developed by I.E.S.T.")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun EnvioFunciones(){
    var resultado by remember {
        mutableStateOf(0)
    }
    Column(){

        Text("Ejercicio de 2 numeros sumados")
        Suma(onClickAddNumbers = {
            resultado = it
        })
        Text("El resultado fue $resultado")
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Suma( onClickAddNumbers: (Int) -> Unit ){
    var num1 by remember {
        mutableStateOf("")
    }
    var num2 by remember {
        mutableStateOf("")
    }
    TextField(value = num1 , onValueChange = {
        num1 = it
    })
    TextField(value = num2 , onValueChange = {
        num2 = it
    })
    Button(onClick = {
        onClickAddNumbers( num1.toInt() + num2.toInt() )
    }) {
        Text(text = "Suma")
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingPreview() {
    RecyclerViewTheme {
        MainView()
    }
}
