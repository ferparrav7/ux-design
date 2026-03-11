package com.medialarm.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.PrimaryButton
import com.medialarm.ui.theme.*

@Composable
fun PerfilScreen(
    onNavigateVincular: () -> Unit,
    onBack: () -> Unit
) {
    var nombre by rememberSaveable { mutableStateOf("Roberto Méndez") }
    var diagnostico by rememberSaveable { mutableStateOf("Diabetes tipo 2") }
    var medico by rememberSaveable { mutableStateOf("Dra. López") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Tu perfil de salud",
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Text("Nombre", style = MaterialTheme.typography.titleMedium, color = TextPrimary, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Border,
                unfocusedBorderColor = Border,
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary
            )
        )
        Text("Diagnóstico principal", style = MaterialTheme.typography.titleMedium, color = TextPrimary)
        OutlinedTextField(
            value = diagnostico,
            onValueChange = { diagnostico = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Border,
                unfocusedBorderColor = Border,
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary
            )
        )
        Text("Médico tratante", style = MaterialTheme.typography.titleMedium, color = TextPrimary)
        OutlinedTextField(
            value = medico,
            onValueChange = { medico = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Border,
                unfocusedBorderColor = Border,
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary
            )
        )
        PrimaryButton(text = "Continuar", onClick = onNavigateVincular)
    }
}
