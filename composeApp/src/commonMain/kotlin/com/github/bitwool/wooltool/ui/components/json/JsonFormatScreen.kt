package com.github.bitwool.wooltool.ui.components.json

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

@Composable
fun JsonFormatScreen() {

    var inputText by remember { mutableStateOf("") }
    var outputText by remember { mutableStateOf("") }
    var isFormatted by remember { mutableStateOf(false) }


    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Input JSON") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {
                outputText = formatJson(inputText)
                isFormatted = true
            }) {
                Text("格式化")
            }
            Button(onClick = {
                outputText = compressJson(inputText)
                isFormatted = false
            }) {
                Text("压缩")
            }
            Button(onClick = {
                outputText = unescapeJson(inputText)
                isFormatted = false
            }) {
                Text("去转义")
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {
                val clipboard = Toolkit.getDefaultToolkit().systemClipboard
                clipboard.setContents(StringSelection(outputText), null)
            }) {
                Text("复制")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

//        Text("Output:")
//        HighlightedJsonText(outputText)
        if (isFormatted) {
            HighlightedJsonText(outputText)
        } else {
            Text(outputText, Modifier.background(Color.White))
        }
    }
}

private val json = Json { prettyPrint = true }

fun formatJson(jsonString: String): String {
    return try {
        val jsonElement = Json.parseToJsonElement(jsonString)
        json.encodeToString(JsonObject.serializer(), jsonElement.jsonObject)
    } catch (e: Exception) {
        println(e)
        "Invalid JSON"
    }
}

fun compressJson(jsonString: String): String {
    return try {
        val jsonElement = Json.parseToJsonElement(jsonString)
        Json.encodeToString(JsonObject.serializer(), jsonElement.jsonObject)
    } catch (e: Exception) {
        println(e)

        "Invalid JSON"
    }
}

fun unescapeJson(jsonString: String): String {
    // 替换反斜杠后的双引号 \"
    val unescapedString = jsonString
        .replace("\\\"", "\"")   // 移除转义的双引号
        .replace("\\\\", "\\")   // 移除转义的反斜杠
        .replace("\\/", "/")     // 移除转义的斜杠（如果有）
        .replace("\\b", "\b")    // 移除转义的退格符
        .replace("\\n", "\n")    // 移除转义的换行符
        .replace("\\r", "\r")    // 移除转义的回车符
        .replace("\\t", "\t")    // 移除转义的制表符
        .replace("\\f", "\u000C") // 移除转义的换页符

    return unescapedString

}

