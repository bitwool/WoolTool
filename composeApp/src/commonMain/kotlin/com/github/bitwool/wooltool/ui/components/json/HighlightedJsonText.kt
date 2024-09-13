package com.github.bitwool.wooltool.ui.components.json

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

/**
 * @Description HighlightedJsonText
 * @Author wuchuanming@cmss.chinamobile.com
 * @Datetime 2024-09-11 12:53
 */

@Composable
fun HighlightedJsonText(jsonString: String) {
    val formattedJson = remember { formatJson(jsonString) }
//    val annotatedString = remember { buildAnnotatedJsonString(formattedJson) }

    Column(modifier = Modifier.padding(16.dp)) {
        BasicText(
            text = buildAnnotatedJsonString(formattedJson),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.background(Color.White).padding(8.dp)
        )
    }
}


@Composable
fun buildAnnotatedJsonString(jsonString: String): AnnotatedString {
    val regex = "\"(.*?)\"\\s*:\\s*\"(.*?)\"".toRegex()
    return buildAnnotatedString {
        var lastIndex = 0
        for (match in regex.findAll(jsonString)) {
            // Append the part before the current match
            append(jsonString.substring(lastIndex, match.range.first))

            // Append the key part in default color (black)
            withStyle(style = SpanStyle(color = Color.Black)) {
                append("\"${match.groups[1]?.value}\"")
            }
            append(": ")

            // Append the value part in green
            withStyle(style = SpanStyle(color = Color(55, 126, 34))) {
                append("\"${match.groups[2]?.value}\"")
            }

            // Update the last index
            lastIndex = match.range.last + 1
        }
        // Append the remaining part of the string
        append(jsonString.substring(lastIndex))
    }
}

