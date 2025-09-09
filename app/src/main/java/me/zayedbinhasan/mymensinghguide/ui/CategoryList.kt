package me.zayedbinhasan.mymensinghguide.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.zayedbinhasan.mymensinghguide.data.Category
import me.zayedbinhasan.mymensinghguide.data.Place

@Composable
fun CategoryList(
    categories: List<Category>,
    selectedCategory: Category? = null,
    onCategorySelected: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        categories.forEach { cat ->
            val isSelected = cat == selectedCategory
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
                    .clickable { onCategorySelected(cat) },
                shape = RoundedCornerShape(8.dp),
                // subtle elevation/highlight when selected
            ) {
                val padding = 12.dp
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(padding)
                ) {
                    Text(
                        text = cat.displayName,
                        style = if (isSelected) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Composable
fun PlacesList(
    category: Category,
    places: List<Place>,
    onPlaceSelected: (Place) -> Unit,
    onBack: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(12.dp)) {
        // lightweight title row instead of a full TopAppBar to avoid duplicate bars
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (onBack != null) {
                IconButton(onClick = onBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
            Text(text = category.displayName, style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(start = 8.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            places.forEach { place ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp)
                        .clickable { onPlaceSelected(place) }, shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                    ) {
                        place.imageResId?.let { res ->
                            Image(
                                painter = painterResource(id = res),
                                contentDescription = place.name,
                                modifier = Modifier
                                    .size(72.dp)
                                    .clip(RoundedCornerShape(6.dp)),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Column(modifier = Modifier.padding(start = 12.dp)) {
                            Text(text = place.name, style = MaterialTheme.typography.titleMedium)
                            Text(
                                text = place.shortDescription,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RightHomePlaceholder(modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(12.dp), shape = RoundedCornerShape(12.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Welcome to Mymensingh Guide", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Select a category from the left to see places; tap a place to see details.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
