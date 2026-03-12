package com.medialarm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.ListItemCard
import com.medialarm.ui.theme.*

@Composable
fun ConfigScreen(
    onNavigateHome: () -> Unit,
    onNavigateHistorial: () -> Unit,
    onNavigateDetalleAlarma: () -> Unit,
    onNavigateContactos: () -> Unit,
    onBack: () -> Unit
) {
    var volumeOn by remember { mutableStateOf(true) }
    var voiceOn by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp)
    ) {
        Text(
            text = "Configuración",
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Perfil", style = MaterialTheme.typography.labelSmall, color = TextPrimary, modifier = Modifier.fillMaxWidth())
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            ListItemCard(title = "Roberto Méndez", pill = { Text("\uD83D\uDC64") })
            ListItemCard(title = "+57 3XX XXX XXXX", pill = { Text("\uD83D\uDCF1") })
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("Alarma", style = MaterialTheme.typography.labelSmall, color = TextPrimary, modifier = Modifier.fillMaxWidth())
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp, 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("\uD83C\uDFA4 Volumen máximo", style = MaterialTheme.typography.bodyLarge, color = TextPrimary)
            Switch(checked = volumeOn, onCheckedChange = { volumeOn = it }, colors = SwitchDefaults.colors(checkedThumbColor = Surface, checkedTrackColor = Primary))
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp, 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("\uD83E\uDDE4 Voz alarma", style = MaterialTheme.typography.bodyLarge, color = TextPrimary)
            Switch(checked = voiceOn, onCheckedChange = { voiceOn = it }, colors = SwitchDefaults.colors(checkedThumbColor = Surface, checkedTrackColor = Primary))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("Alarmas", style = MaterialTheme.typography.labelSmall, color = TextPrimary, modifier = Modifier.fillMaxWidth())
        ListItemCard(
            title = "Ver / Editar alarma",
            pill = { Text("\u270F") },
            onClick = onNavigateDetalleAlarma
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Familiar", style = MaterialTheme.typography.labelSmall, color = TextPrimary, modifier = Modifier.fillMaxWidth())
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            ListItemCard(title = "Carlos (hijo)", pill = { Text("\uD83D\uDC68") })
            ListItemCard(
                title = "Notificar a contactos",
                pill = { Text("\uD83D\uDCE4") },
                modifier = Modifier.background(Color(0xFFECFEFF)),
                onClick = onNavigateContactos
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        androidx.compose.material3.TextButton(onClick = { }) {
            Text("Cerrar sesión", color = Danger)
        }
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
                color = TextMeta,
                modifier = Modifier.clickable(onClick = onNavigateHome)
            )
            Text(
                "\uD83D\uDCCB Historial",
                style = MaterialTheme.typography.bodyMedium,
                color = TextMeta,
                modifier = Modifier.clickable(onClick = onNavigateHistorial)
            )
            Text(
                "\u2699 Config",
                style = MaterialTheme.typography.bodyMedium,
                color = Primary
            )
        }
    }
}
