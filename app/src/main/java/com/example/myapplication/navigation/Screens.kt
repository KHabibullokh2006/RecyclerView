package com.example.myapplication.navigation

sealed class Screens(var route:String){
    object Info: Screens("info" + "/{name_key}" + "/{price_key}"+ "/{img_key}")
}
