package com.github.bitwool.wooltool.utils

import java.util.Base64

object Base64Utils {
    fun encode(input: String): String {
        return Base64.getEncoder().encodeToString(input.toByteArray())
    }

    fun decode(input: String): String {
        return String(Base64.getDecoder().decode(input))
    }
}