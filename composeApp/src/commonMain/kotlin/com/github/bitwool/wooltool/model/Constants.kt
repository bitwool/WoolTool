package com.github.bitwool.wooltool.model

import androidx.compose.runtime.Composable
import com.github.bitwool.wooltool.ui.components.encoding.Base64Screen
import com.github.bitwool.wooltool.ui.components.encoding.EncodingDecodingGroupScreen
import com.github.bitwool.wooltool.ui.components.json.JsonGroupScreen
import com.github.bitwool.wooltool.ui.components.encoding.UrlScreen
import com.github.bitwool.wooltool.ui.components.json.JsonFormatScreen

/**
 * @Description Constants
 * @Author wuchuanming@cmss.chinamobile.com
 * @Datetime 2024-08-28 12:47
 */

object Constants {

    val menuItems: List<Pair<String, @Composable () -> Unit>> = listOf(
        "编码解码" to { EncodingDecodingGroupScreen() },
        "JSON" to { JsonGroupScreen() },
    )

    val encodingFunctions: List<Pair<String, @Composable () -> Unit>> = listOf(
        "Base64" to { Base64Screen() },
        "URL" to { UrlScreen() }
    )

    val jsonFunctions: List<Pair<String, @Composable () -> Unit>> = listOf(
        "JSON格式化" to { JsonFormatScreen() },
    )
}
