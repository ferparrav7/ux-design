package com.medialarm.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.ListItemCard
import com.medialarm.ui.components.PrimaryButton
import com.medialarm.ui.theme.*

@Composable
fun WizardFrecuenciaScreen(
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    var selected by remember { mutableStateOf("Todos los días") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Paso 4 de 5", style = MaterialTheme.typography.bodyMedium, color = TextMeta, modifier = Modifier.fillMaxWidth())
        Text(
            text = "¿Cada cuánto?",
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            ListItemCard(
                title = "Todos los días",
                subtitle = "Se repetirá todos los días a las 8:00 AM.",
                modifier = Modifier.fillMaxWidth(),
                onClick = { selected = "Todos los días" },
                cardBackgroundColor = if (selected == "Todos los días") Color(0xFFECFDF3) else null,
                cardBorderColor = if (selected == "Todos los días") Color(0xFFBBF7D0) else null,
                trailing = { if (selected == "Todos los días") Text("\u2713", color = Primary) else null }
            )
            ListItemCard(
                title = "Días específicos",
                subtitle = "Elige manualmente los días.",
                modifier = Modifier.fillMaxWidth(),
                onClick = { selected = "Días específicos" },
                cardBackgroundColor = if (selected == "Días específicos") Color(0xFFECFDF3) else null,
                cardBorderColor = if (selected == "Días específicos") Color(0xFFBBF7D0) else null,
                trailing = { if (selected == "Días específicos") Text("\u2713", color = Primary) else null }
            )
            ListItemCard(
                title = "Cada X horas",
                subtitle = "Por ejemplo, cada 8 horas.",
                modifier = Modifier.fillMaxWidth(),
                onClick = { selected = "Cada X horas" },
                cardBackgroundColor = if (selected == "Cada X horas") Color(0xFFECFDF3) else null,
                cardBorderColor = if (selected == "Cada X horas") Color(0xFFBBF7D0) else null,
                trailing = { if (selected == "Cada X horas") Text("\u2713", color = Primary) else null }
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        PrimaryButton(text = "Siguiente", onClick = onNext)
    }
}
