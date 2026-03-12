package com.medialarm.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
fun WizardTipoScreen(
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    var selected by remember { mutableStateOf("\uD83D\uDC8A Pastilla") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Paso 3 de 4", style = MaterialTheme.typography.bodyMedium, color = TextMeta, modifier = Modifier.fillMaxWidth())
        Text(
            text = "¿Qué tipo de medicina?",
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(
                listOf("\uD83D\uDC8A Pastilla", "\uD83D\uDC89 Inyección", "\uD83E\uDDF4 Jarabe"),
                listOf("\uD83E\uDED9 Sobres", "\uD83D\uDC8A Cápsula", "\u22EE Otro")
            ).forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowItems.forEach { item ->
                        val isActive = selected == item
                        Surface(
                            shape = RoundedCornerShape(999.dp),
                            color = if (isActive) ChipTomadaBg else Background,
                            modifier = Modifier
                                .weight(1f)
                                .clickable { selected = item }
                        ) {
                            Text(
                                text = item,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                style = MaterialTheme.typography.labelSmall,
                                color = if (isActive) ChipTomadaText else TextPrimary
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        PrimaryButton(text = "Siguiente", onClick = onNext)
    }
}
