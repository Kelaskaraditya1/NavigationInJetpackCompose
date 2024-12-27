package com.starkindustries.navigationjetpackcompose.Frontend.Screens.SplashScreen.Compose

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.starkindustries.navigationjetpackcompose.Navigation.FirstScreen
import com.starkindustries.navigationjetpackcompose.Navigation.SecondScreen
import com.starkindustries.navigationjetpackcompose.R
import com.starkindustries.navigationjetpackcompose.Routes.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreenNavigation(){
    var navController= rememberNavController()
    NavHost(navController = navController,"SplashScreen"){
        composable("SplashScreen") {
            SplashScreen(navController)
        }
        composable("MainScreen") {
            MainScreen()
        }
    }
}

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.navigate("MainScreen")
    }
    Box(modifier = Modifier
        .background(Color.Black)
        .fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column {
            Image(painter = painterResource(id = R.drawable.insta_logo), contentDescription = "",
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = "from",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 200.dp),
                fontSize = 18.sp)
            Text(text = "Meta",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 210.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

    }
}

@Composable
fun MainScreen(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Hello,Aditya",
            fontSize = 18.sp)
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreViewFunction(){
    MainScreen()
}