package com.example.ripleyapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ripleyapp.componentes.Boton_1
import com.example.ripleyapp.componentes.textField1
import com.example.ripleyapp.componentes.textField2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculadoraView(navController: NavController , selectedItem: String){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        IconButton(onClick = {  navController.popBackStack() }) {
                            Icon(Icons.Filled.ArrowBack, "Categoria" , tint = Color.White,)
                        }
                        Text(text = "", fontSize = 20.sp , color = Color.White)


                        Text(text = "", fontSize = 20.sp , color = Color.White)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF4d1a88))
            )
        },

    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )

        ) {
            ContenidoCalculadoraView(navController , selectedItem)
        }

    }
}
@Composable
fun ContenidoCalculadoraView(navController: NavController , selectedItem: String){
    var descuentoTotal by remember { mutableStateOf(0.0) }
    var precioTotal by remember { mutableStateOf(0.0) }
    var precio by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }


    Column (modifier = Modifier.fillMaxWidth().background(color = Color(0xFF4d1a88)).padding(horizontal = 10.dp)){
         Spacer(modifier = Modifier.height(50.dp))
        Text(text="Calculadora" , fontSize = 40.sp , fontWeight = FontWeight.Bold , color = Color.White)
        Text(text = "Llene los campos" , fontSize = 20.sp , color = Color.White)
        Spacer(modifier = Modifier.height(20.dp))
    }

    Column (modifier = Modifier.fillMaxSize().padding(vertical = 20.dp)){
        Text(text = "Categoria Seleccionada: $selectedItem",  modifier = Modifier.padding(horizontal = 20.dp , vertical = 20.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Row (modifier = Modifier.padding(horizontal = 20.dp).padding(bottom = 40.dp)){
            Column(modifier = Modifier.weight(1f)){
                Text(text="Precio Total" , fontSize = 20.sp , fontWeight = FontWeight.Bold)
                Text(text = precioTotal.toString() , fontSize = 15.sp)
            }

            Box(modifier = Modifier.weight(1f)){
                Text(text = descuentoTotal.toString())
            }
        }

        textField1(text = "Precio" , value = precio , onValueChange = { precio = it } )
        Spacer(modifier = Modifier.height(20.dp))
        textField1(text = "Cantidad" , value = cantidad , onValueChange = {cantidad = it})
        Button( modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp).padding(top = 20.dp) , onClick = {


            if (!selectedItem.isNullOrBlank() && precio.isNotBlank() && cantidad.isNotBlank()){
                val precioDouble = precio.toDoubleOrNull() ?: 0.0
                val cantidadInt = cantidad.toIntOrNull() ?: 0

                precioTotal = calcularPrecio(precioDouble , cantidadInt.toDouble())

                if(selectedItem == "Zapatos" && precioTotal > 10000){

                        val descuento = precioDouble * 0.10
                        descuentoTotal = descuento
                        precioTotal = (precioDouble - descuento) * cantidadInt
                } else if(selectedItem == "Prendas" && precioTotal > 500){
                    val descuento = precioDouble * 0.18
                    descuentoTotal = descuento
                    precioTotal = (precioDouble - descuento) * cantidadInt
                }else if(selectedItem == "Electrodomesticos" && precioTotal > 6000){
                    val descuento = precioDouble * 0.07
                    descuentoTotal = descuento
                    precioTotal = (precioDouble - descuento) * cantidadInt
                }else if(selectedItem == "Celulares" && precioTotal > 3500){
                    val descuento = precioDouble * 0.09
                    descuentoTotal = descuento
                    precioTotal = (precioDouble - descuento) * cantidadInt
                }else if(selectedItem == "Ropa" && precioTotal > 1500){
                    val descuento = precioDouble * 0.05
                    descuentoTotal = descuento
                    precioTotal = (precioDouble - descuento) * cantidadInt
                }else if(selectedItem == "Laptops" && precioTotal > 8000){
                    val descuento = precioDouble * 0.19
                    descuentoTotal = descuento
                    precioTotal = (precioDouble - descuento) * cantidadInt
                }
            }

        }){
            Text(text="Calcular" )

        }

    }
}


fun calcularPrecio(precio: Double , cantidad : Double): Double {
    val res = precio * cantidad
    return kotlin.math.round(res)
}