package com.medialarm.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.medialarm.ui.theme.Primary
import com.medialarm.ui.theme.TextMeta
import com.medialarm.ui.theme.TextPrimary

@Composable
fun SeleccionarContactosScreen(
    onSend: () -> Unit,
    onCancel: () -> Unit
) {
    val contactosFrecuentes = remember {
        mutableStateMapOf<String, Boolean>().apply {
            put("Contacto 1", true)
            put("Contacto 2", false)
        }
    }
    val chatsRecientes = remember {
        mutableStateMapOf<String, Boolean>().apply {
            put("Contacto 3", false)
            put("Contacto 4", false)
        }
    }
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
            androidx.compose.material3.TextButton(onClick = onCancel) {
                Text("Cancelar", color = TextMeta)
            }
            Button(
                onClick = onSend,
                colors = ButtonDefaults.buttonColors(containerColor = Primary)
            ) {
                Text("Enviar")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("Contactos frecuentes", style = MaterialTheme.typography.labelSmall, color = TextPrimary, modifier = Modifier.fillMaxWidth())
        listOf("Contacto 1", "Contacto 2").forEach { name ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { contactosFrecuentes[name] = !(contactosFrecuentes[name] ?: false) }
                    .padding(10.dp, 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("\uD83E\uDDD1 $name", style = MaterialTheme.typography.bodyLarge, color = TextPrimary)
                Text(
                    text = if (contactosFrecuentes[name] == true) "\u2713" else "\u25CB",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextMeta
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("Chats recientes", style = MaterialTheme.typography.labelSmall, color = TextPrimary, modifier = Modifier.fillMaxWidth())
        listOf("Contacto 3", "Contacto 4").forEach { name ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { chatsRecientes[name] = !(chatsRecientes[name] ?: false) }
                    .padding(10.dp, 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("\uD83E\uDDD1 $name", style = MaterialTheme.typography.bodyLarge, color = TextPrimary)
                Text(
                    text = if (chatsRecientes[name] == true) "\u2713" else "\u25CB",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextMeta
                )
            }
        }
    }
}
