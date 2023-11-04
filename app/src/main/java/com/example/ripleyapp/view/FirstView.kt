package com.example.ripleyapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ripleyapp.componentes.Boton_2
import com.example.ripleyapp.R
import com.example.ripleyapp.componentes.Boton_1

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstView(navController: NavController){

    Scaffold (

        bottomBar = {
            Column (modifier = Modifier.fillMaxWidth().padding(bottom = 50.dp).padding(horizontal = 20.dp) , horizontalAlignment = Alignment.CenterHorizontally){
                Text("¡Bienvenido!" , color = Color.White , fontSize = 30.sp , fontWeight = FontWeight.Bold , modifier = Modifier.padding(bottom = 10.dp))
                Text("Calculador Personal de Ripley para averiguar tus descuentos" , color = Color.White , fontSize = 15.sp  , modifier = Modifier.padding(bottom = 25.dp) , textAlign = TextAlign.Center)
                Boton_1("Ingresar" , onClick = {
                    navController.navigate("Categorias")
                })
            }
        }
    ) {

     Box(modifier = Modifier
         .fillMaxSize()

         .verticalScroll(rememberScrollState())
     ){
         Image(
             painter = painterResource(id = R.drawable.fondo_ripley),
             contentDescription = "Background",
             contentScale = ContentScale.FillBounds,
             modifier = Modifier.matchParentSize()

         )
     }
    }

}

