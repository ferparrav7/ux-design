package com.medialarm.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.ListItemCard
import com.medialarm.ui.components.PrimaryButton
import com.medialarm.ui.theme.*

@Composable
fun WizardDiasScreen(
    onCreate: () -> Unit,
    onBack: () -> Unit
) {
    val days = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    val selected = remember {
        mutableStateMapOf<String, Boolean>().apply {
            days.forEachIndexed { i, d -> put(d, i % 2 == 0) }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Paso 5 de 5", style = MaterialTheme.typography.bodyMedium, color = TextMeta, modifier = Modifier.fillMaxWidth())
        Text(
            text = "Selecciona los días",
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            days.forEach { day ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selected[day] = !(selected[day] ?: false) }
                        .padding(10.dp, 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(day, style = MaterialTheme.typography.bodyLarge, color = TextPrimary)
                    Text(
                        text = if (selected[day] == true) "\u2713" else "\u25CB",
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (selected[day] == true) TextPrimary else TextMeta
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        PrimaryButton(text = "\u2713 Crear alarma", onClick = onCreate)
    }
}
