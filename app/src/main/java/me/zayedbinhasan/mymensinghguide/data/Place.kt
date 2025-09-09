package me.zayedbinhasan.mymensinghguide.data

import me.zayedbinhasan.mymensinghguide.R

/**
 * A simple data model representing a recommended place in the city.
 * All fields are kept simple so the model is easy to use in Composables and previews.
 */
data class Place(
    val id: Int,
    val name: String,
    val category: Category,
    val shortDescription: String,
    val description: String,
    val address: String,
    val phone: String? = null,
    val imageResId: Int? = R.drawable.baseline_image_24
)
