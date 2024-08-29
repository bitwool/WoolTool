package com.github.bitwool.wooltool.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

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

private val mediumContrastLightColorScheme = Colors(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryVariant = primaryLightMediumContrast, //todo
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryVariant = secondaryLightMediumContrast, //todo
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    isLight = true

)

private val highContrastLightColorScheme = Colors(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryVariant = primaryLightMediumContrast, //todo
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryVariant = secondaryLightMediumContrast, //todo
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    isLight = true

)

private val mediumContrastDarkColorScheme = Colors(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryVariant = primaryDarkMediumContrast, //todo
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryVariant = secondaryDarkMediumContrast, //todo
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    isLight = false
)

private val highContrastDarkColorScheme = Colors(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryVariant = primaryDarkHighContrast, //todo
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryVariant = secondaryDarkHighContrast, //todo
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    isLight = true
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
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
//      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//          val context = LocalContext.current
//          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//      }

      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colors = colorScheme,
//    typography = AppTypography,
    content = content
  )
}

