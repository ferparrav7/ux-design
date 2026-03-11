package com.medialarm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.ListItemCard
import com.medialarm.ui.components.PrimaryButton
import com.medialarm.ui.components.SecondaryButton
import com.medialarm.ui.theme.*

@Composable
fun ConfirmarVozScreen(
    onConfirm: () -> Unit,
    onRetry: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "¿Es correcto?",
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        ListItemCard(
            title = "Metformina",
            subtitle = "Hora: 8:00 AM • Frecuencia: Diario",
            modifier = Modifier.background(Background)
        )
        PrimaryButton(text = "\u2713 Confirmar", onClick = onConfirm)
        SecondaryButton(text = "Reintentar", onClick = onRetry)
    }
}
