package com.medialarm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.DangerButton
import com.medialarm.ui.components.ListItemCard
import com.medialarm.ui.components.PrimaryButton
import com.medialarm.ui.theme.TextMeta

@Composable
fun DetalleAlarmaScreen(
    onEdit: () -> Unit,
    onCancelAlarm: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            androidx.compose.material3.TextButton(onClick = onBack) {
                Text("\u2190 Home", color = TextMeta)
            }
            Text("MediAlarm", style = MaterialTheme.typography.bodyMedium, color = TextMeta)
        }
        Spacer(modifier = Modifier.height(12.dp))
        ListItemCard(
            title = "Metformina",
            subtitle = "08:15 AM • L–V • 1 pastilla",
            cardBackgroundColor = Color(0xFFF8FAFC)
        )
        Spacer(modifier = Modifier.height(8.dp))
        PrimaryButton(text = "\u270F Editar", onClick = onEdit)
        Spacer(modifier = Modifier.height(4.dp))
        DangerButton(text = "\uD83D\uDDD1 Cancelar alarma", onClick = onCancelAlarm)
    }
}
