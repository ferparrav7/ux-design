package com.medialarm.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.ListItemCard
import com.medialarm.ui.theme.*

@Composable
fun SelectorAgregarScreen(
    onNavigateVoz: () -> Unit,
    onNavigateManual: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Agregar alarma",
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Text(
            text = "¿Cómo prefieres crear tu alarma?",
            style = MaterialTheme.typography.bodyLarge,
            color = TextMuted,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            ListItemCard(
                title = "Por voz",
                subtitle = "Dile a MediAlarm qué medicina tomarás.",
                pill = { Text("\uD83C\uDFA4") },
                onClick = onNavigateVoz,
                cardBackgroundColor = Color(0xFFECFDF3),
                cardBorderColor = Color(0xFFBBF7D0),
                pillBackgroundColor = Color(0xFFCFFAFE)
            )
            ListItemCard(
                title = "Manual",
                subtitle = "Ingresa nombre, hora y frecuencia.",
                pill = { Text("\u270F\uFE0F") },
                onClick = onNavigateManual
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            androidx.compose.material3.TextButton(onClick = onCancel) {
                Text("Cancelar", color = TextMeta)
            }
        }
    }
}
