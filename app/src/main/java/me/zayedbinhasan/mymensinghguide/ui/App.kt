package me.zayedbinhasan.mymensinghguide.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class NavigationType {
    BOTTOM_NAVIGATION, NAVIGATION_RAIL, PERMANENT_NAVIGATION_DRAWER
}

/**
 * Content shown depending on size and state of device.
 */
enum class ContentType {
    LIST_ONLY, LIST_AND_DETAIL
}

/** Top-level App entry that chooses layout based on window size class. */
@Composable
fun App(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {

    val navigationType = when (windowSize) {
        WindowWidthSizeClass.Compact -> NavigationType.BOTTOM_NAVIGATION
        WindowWidthSizeClass.Medium -> NavigationType.NAVIGATION_RAIL
        else -> NavigationType.PERMANENT_NAVIGATION_DRAWER
    }

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Expanded -> ContentType.LIST_AND_DETAIL
        else -> ContentType.LIST_ONLY
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        HomeScreen(navigationType = navigationType, contentType = contentType)
    }
}