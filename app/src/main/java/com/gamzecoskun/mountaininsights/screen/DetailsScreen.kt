package com.gamzecoskun.mountaininsights.screen

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gamzecoskun.mountaininsights.model.Mountain

@Composable
fun DetailsScreen(
    mountain: Mountain,
    sharedElement: @Composable () -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        sharedElement()
        AnimatedVisibility(
            remember { MutableTransitionState(false) }
                .apply { targetState = true },
            enter = fadeIn(tween(durationMillis = 600)),
            exit = fadeOut(tween(durationMillis = 600))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .padding(horizontal = 24.dp)
            ) {
                Text(
                    text = mountain.title,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    modifier = Modifier.alpha(0.5f),
                    text = mountain.description
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = { Log.d("DetailScreenss", "Clicledd") }) {
                    Text(text = "Click Me")
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}