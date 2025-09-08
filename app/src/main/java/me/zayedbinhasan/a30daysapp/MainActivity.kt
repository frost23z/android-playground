package me.zayedbinhasan.a30daysapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.zayedbinhasan.a30daysapp.data.DataSource
import me.zayedbinhasan.a30daysapp.model.Event
import me.zayedbinhasan.a30daysapp.ui.theme._30DaysAppTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    CenterAlignedTopAppBar(title = { Text(text = "30 Days of June") })
                }) { innerPadding ->
                    App(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateStartPadding(layoutDirection)
            )
    ) {
        EventList(eventlist = DataSource().loadEvents())
    }
}

@Composable
fun EventList(eventlist: List<Event>, modifier: Modifier = Modifier) {
    val (expandedEvent, setExpandedEvent) = remember { mutableStateOf<Event?>(null) }
    LazyColumn(modifier = modifier) {
        items(eventlist) { event ->
            EventCard(
                event = event, isExpanded = expandedEvent == event, onClick = {
                    setExpandedEvent(if (expandedEvent == event) null else event)
                }, modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun EventCard(
    event: Event,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(), onClick = onClick
    ) {
        Text(
            text = stringResource(id = event.day),
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = stringResource(id = event.name),
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        AnimatedVisibility(
            visible = isExpanded,
            enter = fadeIn(animationSpec = tween(durationMillis = 300)) + expandVertically(),
            exit = fadeOut(animationSpec = tween(durationMillis = 300)) + shrinkVertically()
        ) {
            Text(
                text = stringResource(id = event.description),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    _30DaysAppTheme {
        EventCard(
            event = Event(
                R.string.event_day_june_01, R.string.event_name_june_01, R.string.event_desc_june_01
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ListPreview() {
    _30DaysAppTheme {
        EventList(
            listOf(
                Event(
                    R.string.event_day_june_01,
                    R.string.event_name_june_01,
                    R.string.event_desc_june_01
                ), Event(
                    R.string.event_day_june_02,
                    R.string.event_name_june_02,
                    R.string.event_desc_june_02
                ), Event(
                    R.string.event_day_june_03,
                    R.string.event_name_june_03,
                    R.string.event_desc_june_03
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppPreview() {
    _30DaysAppTheme {
        App()
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun AppPreviewDark() {
    _30DaysAppTheme {
        App()
    }
}