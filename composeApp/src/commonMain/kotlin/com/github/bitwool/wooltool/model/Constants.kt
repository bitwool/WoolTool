package com.github.bitwool.wooltool.model

import androidx.compose.runtime.Composable
import com.github.bitwool.wooltool.ui.components.Base64Screen
import com.github.bitwool.wooltool.ui.components.EncodingDecodingScreen
import com.github.bitwool.wooltool.ui.components.UrlScreen

/**
 * @Description Constants
 * @Author wuchuanming@cmss.chinamobile.com
 * @Datetime 2024-08-28 12:47
 */

object Constants {

    val menuItems: List<Pair<String, @Composable () -> Unit>> = listOf(
        "编码解码" to { EncodingDecodingScreen() },
        "JSON" to { UrlScreen() },
    )

    val encodingFunctions: List<Pair<String, @Composable () -> Unit>> = listOf(
        "Base64" to { Base64Screen() },
        "URL" to { UrlScreen() }
    )
}
