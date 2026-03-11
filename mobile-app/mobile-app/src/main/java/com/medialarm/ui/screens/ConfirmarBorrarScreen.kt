package com.medialarm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.DangerButton
import com.medialarm.ui.components.SecondaryButton
import com.medialarm.ui.theme.*

@Composable
fun ConfirmarBorrarScreen(
    onConfirm: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¿Borrar alarma?",
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Text(
            text = "Metformina • 08:15 AM",
            style = MaterialTheme.typography.bodyLarge,
            color = TextMuted
        )
        Surface(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFFFFF5F5),
            border = androidx.compose.foundation.BorderStroke(4.dp, Danger.copy(alpha = 0.3f))
        ) {
            Text(
                text = "Esta acción eliminará la alarma y no recibirás más recordatorios.",
                modifier = Modifier.fillMaxWidth().padding(10.dp, 12.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = TextPrimary,
                maxLines = 4
            )
        }
        DangerButton(text = "Borrar", onClick = onConfirm)
        SecondaryButton(text = "Cancelar", onClick = onCancel)
    }
}
