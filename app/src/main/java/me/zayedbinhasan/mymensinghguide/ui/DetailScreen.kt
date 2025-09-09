package me.zayedbinhasan.mymensinghguide.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.zayedbinhasan.mymensinghguide.data.Place

@Composable
fun DetailScreen(place: Place) {
    Card(modifier = Modifier.padding(12.dp), shape = RoundedCornerShape(12.dp)) {
        Column(modifier = Modifier.padding(12.dp)) {
            place.imageResId?.let { res ->
                Image(
                    painter = painterResource(id = res),
                    contentDescription = place.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = place.name, style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(6.dp))

            Text(text = place.description, style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = place.address, style = MaterialTheme.typography.bodySmall)
        }
    }
}
