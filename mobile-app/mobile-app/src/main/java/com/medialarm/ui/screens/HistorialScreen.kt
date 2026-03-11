package com.medialarm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.ChipPendiente
import com.medialarm.ui.components.ChipTomada
import com.medialarm.ui.components.ListItemCard
import com.medialarm.ui.theme.*

@Composable
fun HistorialScreen(
    onNavigateHome: () -> Unit,
    onNavigateConfig: () -> Unit,
    onBack: () -> Unit
) {
    var activeTab by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .padding(top = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Historial",
                style = MaterialTheme.typography.headlineLarge,
                color = TextPrimary,
                modifier = Modifier.weight(1f),
                maxLines = 1
            )
            Text(
                text = "\uD83D\uDCC5 Hoy",
                style = MaterialTheme.typography.bodyMedium,
                color = Primary
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            shape = RoundedCornerShape(14.dp),
            color = Color(0xFFEEF2FF)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Hoy: 3 de 4", style = MaterialTheme.typography.titleMedium, color = TextPrimary)
                Text("75% completado", style = MaterialTheme.typography.bodyMedium, color = TextMeta)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
            shape = RoundedCornerShape(999.dp),
            color = Color(0xFFE5E7EB)
        ) {
            Row(
                modifier = Modifier.padding(3.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                listOf("Activas", "Resueltas").forEachIndexed { i, label ->
                    Surface(
                        shape = RoundedCornerShape(999.dp),
                        color = if (activeTab == i) Surface else androidx.compose.ui.graphics.Color.Transparent,
                        modifier = Modifier.clickable { activeTab = i }
                    ) {
                        Text(
                            text = label,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (activeTab == i) Primary else TextPrimary
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Surface,
                border = androidx.compose.foundation.BorderStroke(1.dp, Border)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ChipTomada("Tomada")
                    Column {
                        Text(
                            text = "Metformina",
                            style = MaterialTheme.typography.titleMedium,
                            color = TextPrimary
                        )
                        Text(
                            text = "8:02 AM",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextMeta
                        )
                    }
                }
            }
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Surface,
                border = androidx.compose.foundation.BorderStroke(1.dp, Border)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ChipTomada("Tomada")
                    Column {
                        Text(
                            text = "Losartán",
                            style = MaterialTheme.typography.titleMedium,
                            color = TextPrimary
                        )
                        Text(
                            text = "8:05 AM",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextMeta
                        )
                    }
                }
            }
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Surface,
                border = androidx.compose.foundation.BorderStroke(1.dp, Border)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ChipPendiente("Pendiente")
                    Column {
                        Text(
                            text = "Insulina",
                            style = MaterialTheme.typography.titleMedium,
                            color = TextPrimary
                        )
                        Text(
                            text = "20:00",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextMeta
                        )
                    }
                }
            }
        }
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
                color = Primary
            )
            Text(
                "\u2699 Config",
                style = MaterialTheme.typography.bodyMedium,
                color = TextMeta,
                modifier = Modifier.clickable(onClick = onNavigateConfig)
            )
        }
    }
}
