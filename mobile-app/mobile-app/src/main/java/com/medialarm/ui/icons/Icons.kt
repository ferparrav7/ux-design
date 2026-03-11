package com.medialarm.ui.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text

@Composable
fun PillIcon(modifier: Modifier = Modifier) {
    Text(
        text = "💊",
        fontSize = 40.sp,
        modifier = modifier
    )
}

@Composable
fun MicIcon(modifier: Modifier = Modifier) {
    Text(
        text = "🎤",
        fontSize = 40.sp,
        modifier = modifier
    )
}

