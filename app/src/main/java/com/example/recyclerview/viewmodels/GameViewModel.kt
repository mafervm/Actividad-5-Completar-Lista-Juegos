package com.example.recyclerview.viewmodels

import androidx.lifecycle.ViewModel
import com.example.recyclerview.R
import com.example.recyclerview.models.Game

class GamesViewModel: ViewModel() {
    init {}

    fun getGameList(): ArrayList<Game> {

        var gameList: ArrayList<Game> = ArrayList<Game>()

        gameList.add (Game("Minecraft", 890, "PS4","E+10", R.drawable.minecraft))
        gameList.add (Game("Minecraft Legends", 920, "PS4","E+10", R.drawable.minecraftlegends))
        gameList.add (Game("Minecraft Dungeons", 350, "PS4","E+10", R.drawable.minecraftdungeons))
        gameList.add (Game("OverCooked2!", 450, "XboxOne","E", R.drawable.overcooked2))
        gameList.add (Game("It Takes Two", 1100, "Nintendo Switch","T", R.drawable.ittakestwo))
        gameList.add (Game("Hitman", 1200, "PS4","M", R.drawable.hitman))
        gameList.add (Game("Hitman 2", 330, "XboxOne", "M",R.drawable.hitman2))
        gameList.add (Game("Hitman 3", 2460, "PS5","M", R.drawable.hitman3))
        gameList.add (Game("Don't Starve Together", 499, "PS4","T", R.drawable.dontstarvetogether))
        gameList.add (Game("Overwatch 2", 499, "XboxOne","T", R.drawable.overwatch2))
        gameList.add (Game("Apex Legends", 499, "Xbox","M", R.drawable.apex))
        gameList.add (Game("Call of Duty: Modern Warfare", 600, "PS4","AO", R.drawable.cod))

        //
        return gameList //regresamos la lista de juegos
    }
}