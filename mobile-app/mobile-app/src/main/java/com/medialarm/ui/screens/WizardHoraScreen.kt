package com.medialarm.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.PrimaryButton
import com.medialarm.ui.components.SecondaryButton
import com.medialarm.ui.theme.*

@Composable
fun WizardHoraScreen(
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    var hour by remember { mutableStateOf("08:00 AM") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Paso 2 de 4", style = MaterialTheme.typography.bodyMedium, color = TextMeta, modifier = Modifier.fillMaxWidth())
        Text(
            text = "¿A qué hora?",
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = hour,
                style = MaterialTheme.typography.headlineMedium,
                color = TextPrimary
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                SecondaryButton(text = "−", onClick = { }, modifier = Modifier.widthIn(max = 80.dp))
                SecondaryButton(text = "+", onClick = { }, modifier = Modifier.widthIn(max = 80.dp))
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        PrimaryButton(text = "Siguiente", onClick = onNext)
    }
}
