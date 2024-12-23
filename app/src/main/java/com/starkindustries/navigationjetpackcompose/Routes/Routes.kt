package com.starkindustries.navigationjetpackcompose.Routes

import com.starkindustries.navigationjetpackcompose.Keys.Keys

sealed class Routes( val route:String) {
    object MainScreen : Routes(Keys.MAIN_SCREEN_ROUTE)
    object SecondScreen:Routes(Keys.SECOND_SCREEN_ROUTE)

    fun addData(vararg arg:String):String{
        return buildString {
            append(route)
            arg.forEach {
                arg->append("/$arg")
            }
        }

        }
    }