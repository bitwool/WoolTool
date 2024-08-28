package com.github.bitwool.wooltool.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.github.bitwool.wooltool.ui.EncodingDecodingScreen

object ScreenState {
    // 全局状态变量，初始值为 ScreenA
    var functionScreen by mutableStateOf<@Composable () -> Unit>({ EncodingDecodingScreen() })
}