package com.github.bitwool.wooltool.utils

import java.net.URLDecoder
import java.net.URLEncoder

object UrlUtils {
    fun encode(input: String): String {
        return URLEncoder.encode(input, "UTF-8")
    }

    fun decode(input: String): String {
        return URLDecoder.decode(input, "UTF-8")
    }
}