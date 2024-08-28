package com.github.bitwool.wooltool

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.bitwool.wooltool.model.Constants
import com.github.bitwool.wooltool.model.ScreenState
import com.github.bitwool.wooltool.ui.EncodingDecodingScreen

@Composable
fun App() {
    var selectedMenu by remember { mutableStateOf("编码解码") }

    Surface {
        Row(modifier = Modifier.fillMaxSize()) {
            // Left-side menu
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .background(Color.LightGray)
                    .fillMaxHeight()
            ) {
                Text(
                    text = "WoolTool",
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Menu items
                Constants.menuItems.forEach { (text, screen) ->
                    MenuItem(text, selectedMenu) {
                        selectedMenu = text
                        ScreenState.functionScreen = screen
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Display the current screen (right side)
            ScreenState.functionScreen()
        }
    }
}

@Composable
fun MenuItem(text: String, selectedMenu: String,  onSelect: @Composable () -> Unit) {
    Button(
        onClick = {
            ScreenState.functionScreen = { onSelect() }
                  },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (text == selectedMenu) Color.Gray else Color.LightGray
        )
    ) {
        Text(text = text)
    }
}

