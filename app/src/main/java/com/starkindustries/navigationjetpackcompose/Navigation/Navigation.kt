package com.starkindustries.navigationjetpackcompose.Navigation

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.starkindustries.navigationjetpackcompose.Keys.Keys
import com.starkindustries.navigationjetpackcompose.Routes.Routes

@Composable
fun Navigation(){
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MainScreen.route){
        composable(route = Routes.MainScreen.route){
            FirstScreen(navController = navController)
        }
        composable(route=Routes.SecondScreen.route+"/{name}",
            arguments = listOf(
                navArgument("name"){
                    type=NavType.StringType
                    defaultValue="Aditya"
                    nullable=true
                }
            )
        ){it->
            SecondScreen(navController,name = it.arguments?.getString("name"))
        }
}
}

@Composable
fun FirstScreen(navController: NavController){
    var state by rememberSaveable {
        mutableStateOf("")
    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()){
        Column {
            TextField(value = state, onValueChange ={
                state=it
            } ,
                label ={
                    Text(text = "Name",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                } )
            Button(onClick = {
                navController.navigate(Routes.SecondScreen.addData(state))
            },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp)) {
                Text(text = "Submit")
            }
        }
    }
}

@Composable
fun SecondScreen(navController: NavController,name:String?){

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column {
            Text(text = "Welcome, $name",
                fontSize = 18.sp,
                fontWeight = FontWeight.W400)
            Button(onClick = {
                navController.navigate(Routes.MainScreen.route){
                    popUpTo(Routes.MainScreen.route){
                        inclusive=true
                    }
                }
            },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp)) {
                Text(text = "Logout")
            }
        }

    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewFunction(){
    var navController= rememberNavController()
FirstScreen(navController = navController)
}
