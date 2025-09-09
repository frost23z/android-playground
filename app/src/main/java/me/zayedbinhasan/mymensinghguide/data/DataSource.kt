package me.zayedbinhasan.mymensinghguide.data

/**
 * Curated sample data for Mymensingh city. Entries are limited to locations inside
 * Mymensingh city proper (parks, cultural sites, markets, a few local restaurants,
 * and family-friendly attractions). Images and phone numbers left null for later
 * enrichment.
 */
object SampleData {

    val categories = listOf(
        Category.COFFEE_SHOP,
        Category.RESTAURANT,
        Category.PARK,
        Category.KID_FRIENDLY,
        Category.SHOPPING,
        Category.CULTURE,
        Category.ACCOMMODATION
    )

    val places = listOf(
        // Culture / Museums
        Place(
            id = 1,
            name = "Shilpacharya Zainul Abedin Sangrahashala (Museum)",
            category = Category.CULTURE,
            shortDescription = "Museum dedicated to the artist Zainul Abedin.",
            description = "The museum exhibits paintings and sketches by Shilpacharya Zainul Abedin and related collections; located beside the Udyan (park).",
            address = "Park Road, Mymensingh-2200"
        ),
        Place(
            id = 2,
            name = "Shashi Lodge",
            category = Category.CULTURE,
            shortDescription = "Historic palace and lakeside landmark.",
            description = "Shashi Lodge is a historic building with nearby lakeside views; notable for its colonial-era architecture and nearby 'Lake Side' area.",
            address = "Near District Commissioner's Office, Mymensingh"
        ),
        Place(
            id = 3,
            name = "Mymensingh Town Hall",
            category = Category.CULTURE,
            shortDescription = "Civic building hosting local events and performances.",
            description = "Town Hall is a civic and cultural center where exhibitions and community events are often held.",
            address = "Town Hall Area, Mymensingh"
        ),

        // Parks & Riverside
        Place(
            id = 10,
            name = "Shilpacharya Zainul Abedin Park (Udyan)",
            category = Category.PARK,
            shortDescription = "Large urban park beside the Brahmaputra.",
            description = "A popular green space for walks, public art, and riverside views; often visited at sunset by locals.",
            address = "Park Road, Mymensingh-2200"
        ),
        Place(
            id = 11,
            name = "Bepin Park",
            category = Category.PARK,
            shortDescription = "Public park with lawns and seating areas.",
            description = "A quiet park used for morning walks and small community gatherings.",
            address = "Bepin Park Area, Mymensingh"
        ),
        Place(
            id = 12,
            name = "Brahmaputra Riverside (Kewatkhali)",
            category = Category.PARK,
            shortDescription = "Riverside promenade with boat and ferry views.",
            description = "Open riverbank area popular for evening strolls, tea stalls, and watching boats on the Brahmaputra.",
            address = "Kewatkhali / Riverbank, Mymensingh"
        ),

        // Museums & Science (Kid-friendly overlaps)
        Place(
            id = 20,
            name = "Fish Museum & Biodiversity Centre",
            category = Category.KID_FRIENDLY,
            shortDescription = "Educational exhibits on local aquatic life.",
            description = "A small museum and research centre focused on fishes and aquatic biodiversity — great for students and families.",
            address = "Mymensingh (near research areas)"
        ),
        Place(
            id = 21,
            name = "Shishu Park",
            category = Category.KID_FRIENDLY,
            shortDescription = "Children's playground and amusement area.",
            description = "Playground equipment, small rides, and open lawns for kids and family outings.",
            address = "Near College Road, Mymensingh"
        ),
        Place(
            id = 22,
            name = "BAU Botanical Garden",
            category = Category.KID_FRIENDLY,
            shortDescription = "Botanical garden at Bangladesh Agricultural University.",
            description = "Part of BAU campus — features diverse plant collections, mango gardens, and outdoor learning spaces used by students and visitors.",
            address = "Bangladesh Agricultural University, Mymensingh"
        ),

        // Shopping & Markets
        Place(
            id = 30,
            name = "Chowk Bazaar (Haat Bazaar)",
            category = Category.SHOPPING,
            shortDescription = "Traditional market for produce and textiles.",
            description = "A bustling local market where you can buy fresh vegetables, fish, spices, and locally woven fabrics.",
            address = "Chowk Bazaar area, Mymensingh"
        ),
        Place(
            id = 31,
            name = "Book Street (near University)",
            category = Category.SHOPPING,
            shortDescription = "Book stalls and stationery shops popular with students.",
            description = "A street with new and second-hand book sellers and stationery; good for academic texts and bargains.",
            address = "Near Bangladesh Agricultural University, Mymensingh"
        ),
        Place(
            id = 32,
            name = "City Center Mall",
            category = Category.SHOPPING,
            shortDescription = "Small commercial center with shops and eateries.",
            description = "A compact mall with clothing shops, electronics, and a food court for quick meals and shopping.",
            address = "Sadar Road / City Center, Mymensingh"
        ),

        // Restaurants & Cafés
        Place(
            id = 40,
            name = "Khan Restaurant",
            category = Category.RESTAURANT,
            shortDescription = "Local favourite for biryani and kebabs.",
            description = "Serves traditional Bangladeshi dishes and Mughlai specialties; popular for family meals.",
            address = "Sadar Road area, Mymensingh"
        ),
        Place(
            id = 41,
            name = "Green Garden Restaurant",
            category = Category.RESTAURANT,
            shortDescription = "Vegetarian-friendly local restaurant.",
            description = "Offers a mix of vegetarian and seafood dishes, with simple seating and homestyle flavors.",
            address = "Shambhuganj Road vicinity, Mymensingh"
        ),
        Place(
            id = 42,
            name = "Riverside Tea & Snacks",
            category = Category.COFFEE_SHOP,
            shortDescription = "Tea stalls and cafés along the riverbank.",
            description = "Small cafés and tea stalls where locals gather for tea and snacks while enjoying the Brahmaputra views.",
            address = "Riverbank / Kewatkhali, Mymensingh"
        ),

        // Additional city landmarks, parks and cultural sites
        Place(
            id = 52,
            name = "Alexander Castle (Alexander Castle Ruins)",
            category = Category.CULTURE,
            shortDescription = "Historic 19th-century building and local landmark.",
            description = "A remnant of colonial-era architecture often called Alexander Castle; interesting for history enthusiasts and photographers.",
            address = "Sadar Road / Old Town area, Mymensingh"
        ),
        Place(
            id = 53,
            name = "Ramakrishna Mission Ashrama",
            category = Category.CULTURE,
            shortDescription = "Spiritual and cultural center with quiet grounds.",
            description = "Ramakrishna Ashrama offers a peaceful environment, community programs, and a modest temple complex popular with visitors seeking calm and reflection.",
            address = "Ram Krishna Mission Rd, Mymensingh"
        ),
        Place(
            id = 54,
            name = "Rafiq Uddin Bhuiyan Stadium",
            category = Category.PARK,
            shortDescription = "Local sports stadium hosting football and cricket matches.",
            description = "A central sports venue for district-level matches and public events; open areas around the stadium are often used for community activities.",
            address = "Stadium Road / Sports Complex area, Mymensingh"
        ),
        Place(
            id = 55,
            name = "Zero Point (City Intersection)",
            category = Category.CULTURE,
            shortDescription = "Notable city intersection and public landmark.",
            description = "Zero Point is a well-known junction in Mymensingh used as a local reference point and meeting area; nearby shops and eateries make it lively.",
            address = "Zero Point, Mymensingh"
        ),
        Place(
            id = 56,
            name = "Anjuman Eidgah",
            category = Category.CULTURE,
            shortDescription = "Large communal prayer ground used for Eid gatherings.",
            description = "Anjuman Eidgah is a major open ground used for communal prayers during Eid and occasional public events.",
            address = "Eidgah Road area, Mymensingh"
        ),
        Place(
            id = 57,
            name = "Bangobandhu Chottor",
            category = Category.PARK,
            shortDescription = "Public square and small park used for gatherings and events.",
            description = "A civic square named after Bangabandhu Sheikh Mujibur Rahman; commonly used for public gatherings, ceremonies, and small markets.",
            address = "Central Mymensingh, near administrative areas"
        ),
        Place(
            id = 58,
            name = "Central Shaheed Minar (BAU)",
            category = Category.CULTURE,
            shortDescription = "Memorial monument at BAU commemorating language movement martyrs.",
            description = "A symbolic monument located at Bangladesh Agricultural University; visited by students and those paying respects on national days.",
            address = "Bangladesh Agricultural University, Mymensingh"
        ),
        Place(
            id = 59,
            name = "Mymensingh Rajbari (Rajbari)",
            category = Category.CULTURE,
            shortDescription = "Historic rajbari (palace) reflecting local heritage.",
            description = "An old royal residence with architectural interest; part of local heritage trails and history walks.",
            address = "Old Town / Rajbari area, Mymensingh"
        ),
        Place(
            id = 60,
            name = "Priyokunjo Park",
            category = Category.PARK,
            shortDescription = "Neighbourhood park with children's play areas.",
            description = "A small community park equipped for families and children; used for morning and evening leisure by nearby residents.",
            address = "Priyokunjo area, Mymensingh"
        ),

        // Accommodation (replaced with verified hotels)
        Place(
            id = 50,
            name = "Hotel Hera",
            category = Category.ACCOMMODATION,
            shortDescription = "Well-known hotel near the railway station and river.",
            description = "Hotel Hera offers comfortable rooms, breakfast, and easy access to the railway station and riverside; recommended on Wikivoyage.",
            address = "36/B S. K. Moharaja Rd, Mymensingh"
        ),
        Place(
            id = 51,
            name = "Hotel Silver Castle",
            category = Category.ACCOMMODATION,
            shortDescription = "Popular mid-range hotel listed in local guides.",
            description = "A commonly recommended hotel in Mymensingh for visitors seeking central accommodation.",
            address = "Central Mymensingh area"
        )
    )

    fun placesForCategory(category: Category): List<Place> =
        places.filter { it.category == category }

}
