package com.example.ripleyapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ripleyapp.componentes.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Ripley App", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xff5d1e7b))
            )
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)
            .padding(horizontal = 5.dp )
            .verticalScroll(
                rememberScrollState())

        ) {
            ContentHomeView(navController)
        }

    }

}

@Composable
fun ContentHomeView(navController: NavController) {
  /*  val items = arrayOf("Zapatos", "Prendas", "Electrodomesticos" , "Celulares" , "Ropa" , "Juguetes" , "Laptops")
    CheckboxList(items)

    textField2("Nombre del Producto")

        textField1("Precio")

        textField1("Cantidad")




   */
}