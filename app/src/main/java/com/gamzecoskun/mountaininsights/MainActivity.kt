package com.gamzecoskun.mountaininsights

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gamzecoskun.mountaininsights.screen.ListScreen
import com.gamzecoskun.mountaininsights.screen.MainScreen
import com.gamzecoskun.mountaininsights.ui.theme.MountainInsightsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MountainInsightsTheme {
                ListScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MountainInsightsTheme {
        ListScreen()
    }
}