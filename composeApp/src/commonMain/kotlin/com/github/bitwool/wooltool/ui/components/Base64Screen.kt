package com.github.bitwool.wooltool.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.bitwool.wooltool.model.ScreenState
import com.github.bitwool.wooltool.utils.Base64Utils
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

@Composable
fun Base64Screen() {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("输入") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        Row(modifier = Modifier.padding(16.dp)) {
            Button(onClick = { output = Base64Utils.encode(input) }) {
                Text("编码")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { output = Base64Utils.decode(input) }) {
                Text("解码")
            }
        }
        TextField(
            value = output,
            onValueChange = { },
            label = { Text("输出") },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            readOnly = true
        )
        Button(
            onClick = {
                val clipboard = Toolkit.getDefaultToolkit().systemClipboard
                clipboard.setContents(StringSelection(output), null)
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("复制到剪切板")
        }
        Button(
            onClick = { ScreenState.functionScreen = { EncodingDecodingScreen() } },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("返回")
        }
    }
}