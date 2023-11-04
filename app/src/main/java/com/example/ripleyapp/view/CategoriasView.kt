package com.example.ripleyapp.view

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ripleyapp.componentes.Boton_2
import com.example.ripleyapp.componentes.CheckboxList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriasView(navController: NavController){
    Scaffold(

    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )

        ) {
            ContentCategoriasView(navController)
        }

    }
}

@Composable
fun ContentCategoriasView(navController: NavController){
    val items = arrayOf("Zapatos", "Prendas", "Electrodomesticos" , "Celulares" , "Ropa" , "Juguetes" , "Laptops")

    var selected by remember { mutableStateOf<String?>(null) }

    Column (modifier = Modifier.fillMaxWidth().background(color = Color(0xFF4d1a88)).padding(horizontal = 10.dp)){
        Spacer(modifier = Modifier.height(50.dp))
        Text(text="Hola!" , fontSize = 40.sp , fontWeight = FontWeight.Bold , color = Color.White)
        Text(text = "Elige una Categoría" , fontSize = 20.sp , color = Color.White)
        Spacer(modifier = Modifier.height(20.dp))
    }

    Column (modifier = Modifier.fillMaxSize()){
        CheckboxList(items) {
            selected = it
        }
        Boton_2(text = "Siguiente" , onClick = {
            navController.navigate("Calculadora/${selected ?: ""}")
        } , size = 20.dp, isEnabled = selected != null)


    }
}
