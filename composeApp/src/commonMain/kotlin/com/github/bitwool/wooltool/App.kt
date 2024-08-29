package com.github.bitwool.wooltool

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.bitwool.wooltool.model.Constants
import com.github.bitwool.wooltool.model.ScreenState
import com.github.bitwool.wooltool.ui.theme.AppTheme

@Composable
fun App() {

    var selectedMenu by remember { mutableStateOf("") }

    AppTheme {
        Surface {

            Row(modifier = Modifier.fillMaxSize()) {
                // Left-side menu

                Column(
                    modifier = Modifier
                        .width(200.dp)
                        .fillMaxHeight()
//                        .background(Constants.appBgColor)
                ) {
                    Text(
                        text = "WoolTool",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally)
                    )
//                Spacer(modifier = Modifier.height(16.dp))
                    Divider(
                        color = Color.LightGray, // 自定义颜色
                        thickness = 1.dp,   // 自定义厚度
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    // Menu items
                    Constants.menuItems.forEach { (text, screen) ->
                        MenuItem(text, selectedMenu) {
                            selectedMenu = text
                            ScreenState.functionScreen = screen
                        }
                        Spacer(modifier = Modifier.width(0.dp))
                    }
                }

                // Display the current screen (right side)
                ScreenState.functionScreen()
            }
        }
    }

}

@Composable
fun MenuItem(text: String, selectedMenu: String, onSelect: @Composable () -> Unit) {
    Button(
        onClick = {
            ScreenState.functionScreen = { onSelect() }
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
//            backgroundColor = if (text == selectedMenu) Color.Gray else Color.LightGray
        )
    ) {
        Text(text = text)
    }
}

