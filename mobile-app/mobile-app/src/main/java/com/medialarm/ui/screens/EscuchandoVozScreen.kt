package com.medialarm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.medialarm.ui.icons.MicIcon
import com.medialarm.ui.theme.DarkBackground
import com.medialarm.ui.theme.Primary

@Composable
fun EscuchandoVozScreen(
    onContinue: () -> Unit,
    onCancel: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .background(Primary, androidx.compose.foundation.shape.CircleShape),
                contentAlignment = Alignment.Center
            ) {
                MicIcon()
            }
            Text(
                text = "Escuchando...",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                maxLines = 1
            )
            Text(
                text = "\"Agregar Metformina a las 8 AM todos los días\"",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFCBD5E1),
                modifier = Modifier.fillMaxWidth(0.9f),
                maxLines = 3
            )
            // Botón blanco \"Continuar\"
            Button(
                onClick = onContinue,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF9FAFB),
                    contentColor = Color(0xFF0F172A)
                ),
                shape = MaterialTheme.shapes.large
            ) {
                Text(text = "Continuar", style = MaterialTheme.typography.labelLarge)
            }
            // Botón contorno \"Cancelar\"
            Button(
                onClick = onCancel,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFFF9FAFB)
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFF9FAFB)),
                shape = MaterialTheme.shapes.large
            ) {
                Text(text = "Cancelar", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}
