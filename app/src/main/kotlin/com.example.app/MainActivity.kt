package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui-Modifier
import com.example.app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // TODO: Navigate to the root composable here
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Placeholder for your composable UI
                }
            }
        }
    }
}

// FILE: app/src/main/kotlin/com.example.app/ui/theme.kt
package com.example.app.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object AppTheme {
    val lightColorScheme = ColorScheme(
        primary = Purple40,
        secondary = Teal200,
        tertiary = Orange50,
    )

    val typography = Typography(
        bodyLarge = TextStyle(language = "English", fontSize = 16.sp),
        displayMedium = TextStyle(language = "English", fontWeight = FontWeight.Bold, fontSize = 20.sp),
    )

    @Composable
    fun AppTheme(
        content: @Composable () -> Unit
    ) {
        MaterialTheme(
            colorScheme = lightColorScheme,
            typography = typography,
            content = content
        )
    }
}