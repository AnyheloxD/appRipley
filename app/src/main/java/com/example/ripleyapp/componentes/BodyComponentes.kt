package com.example.ripleyapp.componentes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun SpacerW(size: Dp = 10.dp){
    Spacer(modifier = Modifier.width(20.dp))
}

@Composable
fun CheckboxList(items: Array<String> ,  onItemSelected: (String?) -> Unit) {
    var selected by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.fillMaxSize()) {
        items.forEach { itemName ->
            val isChecked = itemName == selected

            Row(
                modifier = Modifier.toggleable(
                    value = isChecked,
                    role = Role.Checkbox,
                    onValueChange = {
                        selected = if (isChecked) null else itemName
                        onItemSelected(selected)
                    }
                ).padding(16.dp).fillMaxWidth()
            ) {
                Text(itemName, modifier = Modifier.weight(1f))
                Checkbox(checked = isChecked, onCheckedChange = null)
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textField1(text: String , onValueChange: (String) -> Unit , value: String){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text=text)},
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textField2(text: String , onValueChange: (String) -> Unit , value: String){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text=text)},
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Composable
fun Boton_1(text: String , onClick: () -> Unit , size: Dp = 0.dp ){

    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp).padding(top = size),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4d1a88)),

    ) {
        Text(text = text)
    }


}

@Composable
fun Boton_2(text: String , onClick: () -> Unit , size: Dp = 0.dp , isEnabled: Boolean){

    Button(
        onClick = { onClick() },
        modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp).padding(top = size),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4d1a88)),
        enabled = isEnabled
    ) {
        Text(text = text)
    }


}