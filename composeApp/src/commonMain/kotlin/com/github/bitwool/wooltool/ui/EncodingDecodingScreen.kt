package com.github.bitwool.wooltool.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.bitwool.wooltool.model.ScreenState

@Composable
fun EncodingDecodingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "编码解码",
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Button to navigate to Base64 screen
        Button(
            onClick = { ScreenState.currentScreen = { Base64Screen() } },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Base64 编解码")
        }

        // Button to navigate to URL screen
        Button(
            onClick = {  ScreenState.currentScreen = { UrlScreen() } },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "URL 编解码")
        }
    }
}