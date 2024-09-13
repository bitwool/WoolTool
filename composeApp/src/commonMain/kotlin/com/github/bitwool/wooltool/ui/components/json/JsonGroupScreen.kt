package com.github.bitwool.wooltool.ui.components.json

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.bitwool.wooltool.model.Constants
import com.github.bitwool.wooltool.model.ScreenState

@Composable
fun JsonGroupScreen() {
    Row(modifier = Modifier.fillMaxSize()) {
        // Button to navigate to Base64 screen

        Constants.jsonFunctions.forEach { (text, screen) ->
            Button(
                onClick = { ScreenState.functionScreen = screen },
                modifier = Modifier.padding(8.dp),
            ) {
                Text(text = text)
            }
        }
    }
}