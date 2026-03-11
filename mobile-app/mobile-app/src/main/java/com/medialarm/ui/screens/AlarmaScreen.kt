package com.medialarm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.medialarm.ui.icons.PillIcon
import com.medialarm.ui.theme.Primary

@Composable
fun AlarmaScreen(
    onNavigateHome: () -> Unit,
    onNavigateDetalle: () -> Unit,
    onBack: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        listOf(
                            Color(0xFF0F172A), // dark top
                            Primary
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "\u23F0 8:00 AM",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFCBD5F5),
                    maxLines = 1
                )
                PillIcon()
                Text(
                    text = "METFORMINA",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color(0xFFF9FAFB),
                    maxLines = 1
                )
                Text(
                    text = "1 pastilla",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFCBD5F5)
                )
                Spacer(modifier = Modifier.height(20.dp))

                // ✓ Ya tomé – botón claro 80% de ancho
                Button(
                    onClick = onNavigateHome,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF9FAFB),
                        contentColor = Color(0xFF0F172A)
                    ),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(text = "\u2713 Ya tomé", style = MaterialTheme.typography.labelLarge)
                }

                // ⏰ En 10 min – botón secundario transparente con borde claro
                Button(
                    onClick = onNavigateHome,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color(0xFFE5E7EB)
                    ),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFCBD5F5)),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(text = "\u23F0 En 10 min", style = MaterialTheme.typography.labelLarge)
                }

                Spacer(modifier = Modifier.height(16.dp))
                androidx.compose.material3.TextButton(onClick = onNavigateDetalle) {
                    Text(
                        text = "\u270F Ver / Editar alarma",
                        color = Color(0xFFCBD5F5)
                    )
                }
            }
        }
    }
}
