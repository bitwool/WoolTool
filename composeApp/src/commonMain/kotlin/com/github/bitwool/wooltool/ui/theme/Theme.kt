package com.github.bitwool.wooltool.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

private val lightScheme = Colors(
    primary = primaryLight,
    primaryVariant = primaryLight, //todo
    onPrimary = onPrimaryLight,
    secondary = secondaryLight,
    secondaryVariant =  secondaryLight, //todo
    onSecondary = onSecondaryLight,
    error = errorLight,
    onError = onErrorLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    isLight = true

)

private val darkScheme = Colors(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryVariant = primaryDark, //todo
    secondary = secondaryDark,
    onSecondary = onSecondaryDark, //todo
    secondaryVariant = secondaryDark,
    error = errorDark,
    onError = onErrorDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
   isLight = false
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colors = colorScheme,
    content = content
  )
}

