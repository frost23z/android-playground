package me.zayedbinhasan.mymensinghguide.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import me.zayedbinhasan.mymensinghguide.data.Category
import me.zayedbinhasan.mymensinghguide.data.Place
import me.zayedbinhasan.mymensinghguide.data.SampleData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navigationType: NavigationType, contentType: ContentType) {
    val categories = SampleData.categories
    val (selectedCategory, setSelectedCategory) = remember { mutableStateOf<Category?>(null) }
    val (selectedPlace, setSelectedPlace) = remember { mutableStateOf<Place?>(null) }

    // Navigation for compact mode
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(topBar = {
        // compute title and whether to show back
        val title = if (contentType == ContentType.LIST_AND_DETAIL) {
            selectedPlace?.name ?: selectedCategory?.displayName ?: "Mymensingh Guide"
        } else {
            when (navBackStackEntry?.destination?.route) {
                "places" -> selectedCategory?.displayName ?: "Places"
                "detail" -> selectedPlace?.name ?: "Detail"
                else -> "Mymensingh Guide"
            }
        }

        val canPop =
            if (contentType == ContentType.LIST_AND_DETAIL) false else (navController.previousBackStackEntry != null)

        TopAppBar(
            title = { Text(text = title) }, navigationIcon =
                {
                    if (canPop) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                }
        )
    }) { innerPadding ->

    if (contentType == ContentType.LIST_AND_DETAIL) {
            // Two-pane: left always shows categories; right shows placeholder / places / detail
            Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(8.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.36f)
                ) {
                    // left: category list
                    CategoryList(
                        categories = categories,
                        selectedCategory = selectedCategory,
                        onCategorySelected = { cat ->
                            setSelectedCategory(cat)
                            // when user selects a category on larger screen show places by default
                            setSelectedPlace(null)
                        })
                }

                // right: depends on selection
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    when {
                        selectedPlace != null -> {
                            // show detail
                            DetailScreen(place = selectedPlace)
                        }

                        selectedCategory != null -> {
                            // show places for category
                            val places = SampleData.placesForCategory(selectedCategory)
                            PlacesList(
                                category = selectedCategory,
                                places = places,
                                onPlaceSelected = { p -> setSelectedPlace(p) })
                        }

                        else -> {
                            RightHomePlaceholder()
                        }
                    }
                }
            }
        } else {
            // Compact: NavHost with three routes: categories, places, detail
            NavHost(
                navController = navController,
                startDestination = "categories",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("categories") {
                    CategoryList(categories = categories, onCategorySelected = { cat ->
                        setSelectedCategory(cat)
                        navController.navigate("places")
                    }, modifier = Modifier.fillMaxSize())
                }

                composable("places") {
                    val cat = selectedCategory ?: categories.first()
                    val places = SampleData.placesForCategory(cat)
                    PlacesList(category = cat, places = places, onPlaceSelected = { p ->
                        setSelectedPlace(p)
                        navController.navigate("detail")
                    }, onBack = { navController.popBackStack() }, modifier = Modifier.fillMaxSize())
                }

                composable("detail") {
                    selectedPlace?.let { p ->
                        Column(modifier = Modifier.fillMaxSize()) {
                            DetailScreen(p)
                        }
                    } ?: run { navController.popBackStack("places", false) }
                }
            }
        }
    }
}

