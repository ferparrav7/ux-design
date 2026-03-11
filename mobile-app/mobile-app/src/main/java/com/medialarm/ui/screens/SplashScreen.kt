package com.medialarm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.medialarm.ui.icons.PillIcon
import com.medialarm.ui.theme.Primary
import com.medialarm.ui.theme.Success
import com.medialarm.ui.theme.DarkMuted

@Composable
fun SplashScreen(onNavigate: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(Primary, Success))),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(24.dp)
        ) {
            PillIcon()
            Text(
                text = "MediAlarm",
                style = MaterialTheme.typography.headlineLarge,
                color = androidx.compose.ui.graphics.Color(0xFFF9FAFB),
                maxLines = 1
            )
            Text(
                text = "Recordatorios de medicación para ti y tu familia",
                style = MaterialTheme.typography.bodyMedium,
                color = androidx.compose.ui.graphics.Color(0xFFE2E8F0),
                modifier = Modifier.fillMaxWidth(0.85f),
                maxLines = 3
            )
            Button(
                onClick = onNavigate,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .widthIn(max = 200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = androidx.compose.ui.graphics.Color(0xFFF9FAFB),
                    contentColor = Primary
                ),
                shape = MaterialTheme.shapes.large
            ) {
                Text(text = "Comenzar", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}
