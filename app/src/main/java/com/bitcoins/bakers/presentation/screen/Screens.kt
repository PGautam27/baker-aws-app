package com.bitcoins.bakers.presentation.screen

sealed class Screens(val route:String){
    object FirstScreen : Screens("first_screen")
    object SecondScreen : Screens("second_screen")
}
