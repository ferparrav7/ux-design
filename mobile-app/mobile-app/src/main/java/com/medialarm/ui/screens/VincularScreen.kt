package com.medialarm.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.medialarm.ui.components.PrimaryButton
import com.medialarm.ui.components.SecondaryButton
import com.medialarm.ui.theme.*

@Composable
fun VincularScreen(
    onNavigateHome: () -> Unit,
    onSkip: () -> Unit,
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
            text = "Vincula a tu familiar",
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
        )
        Text(
            text = "Comparte tu código para que un familiar pueda recibir alertas cuando no confirmes tus tomas.",
            style = MaterialTheme.typography.bodyLarge,
            color = TextMuted,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 4
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(24.dp),
            color = Color(0xFFECFEFF)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "\uD83D\uDD17",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextMeta
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Tu código",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextMeta
                )
                Text(
                    text = "R0B-123",
                    style = MaterialTheme.typography.titleLarge,
                    color = TextPrimary
                )
            }
        }
        PrimaryButton(text = "Enviar por WhatsApp", onClick = onNavigateHome)
        SecondaryButton(text = "Mostrar código QR", onClick = onNavigateHome)
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            TextButton(onClick = onSkip) {
                Text("Omitir por ahora", color = TextMeta)
            }
        }
    }
}
