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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.PrimaryButton
import com.medialarm.ui.theme.*

@Composable
fun LoginScreen(
    onNavigateVerificar: () -> Unit,
    onBack: () -> Unit
) {
    var phone by rememberSaveable { mutableStateOf("+57 3XX XXX XXXX") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Iniciar sesión",
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Text(
            text = "Ingresa tu número de teléfono para enviarte un código de verificación.",
            style = MaterialTheme.typography.bodyLarge,
            color = TextMuted,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Teléfono",
            style = MaterialTheme.typography.titleMedium,
            color = TextPrimary
        )
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
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
        PrimaryButton(text = "Enviar código", onClick = onNavigateVerificar)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Tus datos se usan solo para enviar recordatorios.",
            style = MaterialTheme.typography.bodyMedium,
            color = TextMeta,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
    }
}
