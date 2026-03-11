package com.medialarm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.PrimaryButton
import com.medialarm.ui.theme.*

@Composable
fun WizardNombreScreen(
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    var nombre by remember { mutableStateOf("Metformina") }
    var selectedSuggestion by remember { mutableStateOf("Metformina") }
    val suggestions = listOf("Metformina", "Losartán", "Insulina")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Paso 1 de 4", style = MaterialTheme.typography.bodyMedium, color = TextMeta, modifier = Modifier.fillMaxWidth())
        Text(
            text = "¿Qué medicina?",
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
        Text("Sugerencias", style = MaterialTheme.typography.labelSmall, color = TextMeta)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            suggestions.forEach { s ->
                val isActive = s == selectedSuggestion
                Surface(
                    shape = RoundedCornerShape(999.dp),
                    color = if (isActive) ChipTomadaBg else Background,
                    modifier = Modifier.clickable { selectedSuggestion = s; nombre = s }
                ) {
                    Text(
                        text = s,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = if (isActive) ChipTomadaText else TextPrimary
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        PrimaryButton(text = "Siguiente", onClick = onNext)
    }
}
