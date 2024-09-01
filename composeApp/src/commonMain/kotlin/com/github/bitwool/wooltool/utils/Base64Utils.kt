package com.github.bitwool.wooltool.utils

import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

object Base64Utils {
    @OptIn(ExperimentalEncodingApi::class)
    fun encode(input: String): String {
        return Base64.Default.encode(input.encodeToByteArray())
    }

    @OptIn(ExperimentalEncodingApi::class)
    fun decode(input: String): String {
        return Base64.Default.decode(input.toByteArray(Charsets.UTF_8), 0, input.length).toString(Charsets.UTF_8);
    }
}