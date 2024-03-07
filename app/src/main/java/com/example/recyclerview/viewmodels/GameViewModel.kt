package com.example.recyclerview.viewmodels

import androidx.lifecycle.ViewModel
import com.example.recyclerview.R
import com.example.recyclerview.models.Game

class GameViewModel: ViewModel() {
    init {
        //constructor
    }

    fun getGameList(): ArrayList<Game> {
        val game: Game = Game("Minecraft", 890, "PS4", R.drawable.minecraft)
        val gameList:ArrayList <Game> =ArrayList<Game> () //Lista vacia de Juegos
        gameList.add(game)

        gameList.add (Game("Minecraft Legends", 920, "PS4", R.drawable.minecraftlegends))
        gameList.add (Game("Minecraft Dungeons", 350, "PS4", R.drawable.minecraftdungeons))
        gameList.add (Game("OverCooked2!", 450, "XboxOne", R.drawable.overcooked2))
        gameList.add (Game("It Takes Two", 1100, "Nintendo Switch", R.drawable.ittakestwo))
        gameList.add (Game("Hitman", 1200, "PS4", R.drawable.hitman))
        gameList.add (Game("Hitman 2", 330, "XboxOne", R.drawable.hitman2))
        gameList.add (Game("Hitman 3", 2460, "PS5", R.drawable.hitman3))
        gameList.add (Game("Don't Starve Together", 499, "PS4", R.drawable.dontstarvetogether))
        gameList.add (Game("Overwatch 2", 499, "XboxOne", R.drawable.overwatch2))
        gameList.add (Game("Apex Legends", 499, "Xbox", R.drawable.apex))
        gameList.add (Game("Call of Duty: Modern Warfare ", 600, "PS4", R.drawable.cod))

        //
        return gameList //regresamos la lista de juegos
    }
}