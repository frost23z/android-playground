package me.zayedbinhasan.mymensinghguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.zayedbinhasan.mymensinghguide.ui.App
import me.zayedbinhasan.mymensinghguide.ui.theme.MymensinghGuideTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MymensinghGuideTheme {
                Scaffold { innerPadding->
                    val windowSize = calculateWindowSizeClass(this)

                    App(
                        windowSize = windowSize.widthSizeClass,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Phone preview (compact width)
@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun PreviewPhone() {
    MymensinghGuideTheme {
        App(windowSize = WindowWidthSizeClass.Compact)
    }
}

// Foldable / small-tablet preview (medium width)
@Preview(showBackground = true, device = "spec:width=673dp,height=841dp")
@Composable
fun PreviewFoldable() {
    MymensinghGuideTheme {
        App(windowSize = WindowWidthSizeClass.Medium)
    }
}

// Tablet / large preview (expanded width)
@Preview(showBackground = true, device = "spec:width=1280dp,height=800dp,dpi=240")
@Composable
fun PreviewTablet() {
    MymensinghGuideTheme {
        App(windowSize = WindowWidthSizeClass.Expanded)
    }
}