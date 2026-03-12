package com.medialarm.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.ChipPendiente
import com.medialarm.ui.components.ChipTomada
import com.medialarm.ui.components.KpiCard
import com.medialarm.ui.components.ListItemCard

@Composable
fun HomeScreen(
    onNavigateConfig: () -> Unit,
    onNavigateHistorial: () -> Unit,
    onNavigateAgregar: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "MediAlarm",
                style = MaterialTheme.typography.titleLarge,
                color = com.medialarm.ui.theme.TextPrimary,
                maxLines = 1
            )
            Text(
                text = "\u2699",
                style = MaterialTheme.typography.bodyMedium,
                color = com.medialarm.ui.theme.TextMeta,
                modifier = Modifier.clickable(onClick = onNavigateConfig)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            KpiCard(icon = "\uD83D\uDC8A", label = "Medicinas", value = "2/7", modifier = Modifier.weight(1f))
            KpiCard(icon = "\uD83D\uDCC8", label = "Cumplimiento", value = "92%", modifier = Modifier.weight(1f))
            KpiCard(icon = "\u26A0\uFE0F", label = "Alertas", value = "1", modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Próximas",
            style = MaterialTheme.typography.labelSmall,
            color = com.medialarm.ui.theme.TextMeta
        )
        Spacer(modifier = Modifier.height(4.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ListItemCard(
                title = "Metformina",
                subtitle = "Hoy • 8:00 AM",
                pill = { Text("\uD83D\uDC8A") },
                trailing = { ChipPendiente("Pendiente") }
            )
            ListItemCard(
                title = "Insulina",
                subtitle = "Hoy • 12:00 PM",
                pill = { Text("\uD83D\uDC89") },
                trailing = { ChipTomada("Tomada") }
            )
            ListItemCard(
                title = "Losartán",
                subtitle = "Hoy • 20:00",
                pill = { Text("\uD83D\uDC8A") },
                trailing = { ChipPendiente("Pendiente") }
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        com.medialarm.ui.components.PrimaryButton(
            text = "\u2795 Agregar alarma",
            onClick = onNavigateAgregar
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                "\uD83C\uDFE0 Home",
                style = MaterialTheme.typography.bodyMedium,
                color = com.medialarm.ui.theme.Primary,
                modifier = Modifier.clickable { }
            )
            Text(
                "\uD83D\uDCCB Historial",
                style = MaterialTheme.typography.bodyMedium,
                color = com.medialarm.ui.theme.TextMeta,
                modifier = Modifier.clickable(onClick = onNavigateHistorial)
            )
            Text(
                "\u2699 Config",
                style = MaterialTheme.typography.bodyMedium,
                color = com.medialarm.ui.theme.TextMeta,
                modifier = Modifier.clickable(onClick = onNavigateConfig)
            )
        }
    }
}
