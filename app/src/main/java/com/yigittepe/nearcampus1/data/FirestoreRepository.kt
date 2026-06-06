package com.yigittepe.nearcampus1.data

import android.util.Log
import androidx.compose.ui.graphics.Color
import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.yigittepe.nearcampus1.model.Discount
import com.yigittepe.nearcampus1.model.MenuCategory
import com.yigittepe.nearcampus1.model.MenuItem
import com.yigittepe.nearcampus1.model.Review
import com.yigittepe.nearcampus1.model.UserAvatar
import com.yigittepe.nearcampus1.model.Venue
import com.yigittepe.nearcampus1.model.Campaign

internal object FirestoreRepository {
    private val db: FirebaseFirestore
        get() = FirebaseFirestore.getInstance()

    private var cachedVenues: List<Venue>? = null
    private val cachedMenuCategories = mutableMapOf<String, List<MenuCategory>>()
    private val cachedDiscounts = mutableMapOf<String, List<Discount>>()
    private val cachedReviews = mutableMapOf<String, List<Review>>()
    private val cachedDirectReviews = mutableMapOf<String, List<Review>>()
    private val cachedItemReviews = mutableMapOf<String, List<Review>>()
    private var cachedCampaigns: List<Campaign>? = null
    private var cachedAvatars: List<UserAvatar>? = null
    val favoriteStates = androidx.compose.runtime.mutableStateMapOf<String, Boolean>()
    val recentlyViewedIds = androidx.compose.runtime.mutableStateListOf<String>()

    private const val DefaultAvatarId = "avatar_1_afro_and_glasses"
    private val avatarAssetIds = listOf(
        "avatar_1_afro_and_glasses",
        "avatar_2_student_with_book",
        "avatar_3_wavy_hair_student",
        "avatar_4_braided_hair_student",
        "avatar_5_student_with_cap",
        "avatar_6_braids_and_glasses",
        "avatar_7_student_in_blazer",
        "avatar_8_student_with_tablet",
        "avatar_9_red_hair_and_glasses"
    )
    private val NavyFallback = Color(0xFF0B1F3A)
    private val fallbackAvatars = listOf(
        UserAvatar(DefaultAvatarId, "Afro And Glasses", "AA", listOf(NavyFallback, Color(0xFF111827))),
        UserAvatar("avatar_2_student_with_book", "Student With Book", "SW", listOf(Color(0xFF2563EB), Color(0xFF14B8A6))),
        UserAvatar("avatar_3_wavy_hair_student", "Wavy Hair Student", "WH", listOf(Color(0xFFB45309), Color(0xFFC48918))),
        UserAvatar("avatar_4_braided_hair_student", "Braided Hair Student", "BH", listOf(Color(0xFF7C3AED), Color(0xFFDB2777))),
        UserAvatar("avatar_5_student_with_cap", "Student With Cap", "SC", listOf(Color(0xFF0F766E), Color(0xFF22C55E))),
        UserAvatar("avatar_6_braids_and_glasses", "Braids And Glasses", "BG", listOf(Color(0xFF4338CA), Color(0xFF06B6D4))),
        UserAvatar("avatar_7_student_in_blazer", "Student In Blazer", "SB", listOf(Color(0xFF1F2937), Color(0xFF64748B))),
        UserAvatar("avatar_8_student_with_tablet", "Student With Tablet", "ST", listOf(Color(0xFFBE123C), Color(0xFFF97316))),
        UserAvatar("avatar_9_red_hair_and_glasses", "Red Hair And Glasses", "RH", listOf(Color(0xFF9F1239), Color(0xFFE11D48)))
    )

    fun createUserEntry(
        uid: String,
        email: String?,
        displayName: String?,
        onComplete: (Boolean) -> Unit
    ) {
        val data = mapOf(
            "uid" to uid,
            "email" to (email ?: ""),
            "displayName" to (displayName ?: ""),
            "isStudentVerified" to false,
            "avatarId" to DefaultAvatarId,
            "notificationPreferences" to mapOf(
                "general" to true,
                "deals" to true,
                "reviews" to true
            ),
            "privacyPreferences" to mapOf(
                "personalizedRecommendations" to true,
                "analytics" to true
            )
        )

        db.collection("users").document(uid)
            .set(data, SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to create user entry", e)
                onComplete(false)
            }
    }

    fun fetchStudentVerificationStatus(uid: String?, onResult: (Boolean) -> Unit) {
        if (uid.isNullOrBlank()) {
            onResult(false)
            return
        }

        db.collection("users").document(uid)
            .get()
            .addOnSuccessListener { document ->
                onResult(document.getBoolean("isStudentVerified") == true)
            }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to fetch student verification status", e)
                onResult(false)
            }
    }

    fun verifyStudentFromProfile(uid: String?, school: String = "", onComplete: (Boolean) -> Unit) {
        if (uid.isNullOrBlank()) {
            onComplete(false)
            return
        }

        val verification = mapOf(
            "verifiedAt" to com.google.firebase.Timestamp.now(),
            "verificationMethod" to "profile",
            "school" to school
        )
        val data = mapOf(
            "isStudentVerified" to true,
            "studentVerification" to verification
        )

        db.collection("users").document(uid)
            .set(data, SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to verify student from profile", e)
                onComplete(false)
            }
    }

    fun fetchNotificationPreferences(uid: String?, onResult: (Boolean, Boolean, Boolean) -> Unit) {
        if (uid.isNullOrBlank()) {
            onResult(true, true, true)
            return
        }

        db.collection("users").document(uid)
            .get()
            .addOnSuccessListener { document ->
                val preferences = document.get("notificationPreferences") as? Map<*, *>
                val general = preferences?.get("general") as? Boolean ?: true
                val deals = preferences?.get("deals") as? Boolean ?: true
                val reviews = preferences?.get("reviews") as? Boolean ?: true
                onResult(general, deals, reviews)
            }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to fetch notification preferences", e)
                onResult(true, true, true)
            }
    }

    fun updateNotificationPreferences(
        uid: String?,
        general: Boolean,
        deals: Boolean,
        reviews: Boolean,
        onComplete: (Boolean) -> Unit
    ) {
        if (uid.isNullOrBlank()) {
            onComplete(false)
            return
        }

        val data = mapOf(
            "notificationPreferences" to mapOf(
                "general" to general,
                "deals" to deals,
                "reviews" to reviews
            )
        )

        db.collection("users").document(uid)
            .set(data, SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to update notification preferences", e)
                onComplete(false)
            }
    }

    fun fetchPrivacyPreferences(uid: String?, onResult: (Boolean, Boolean) -> Unit) {
        if (uid.isNullOrBlank()) {
            onResult(true, true)
            return
        }

        db.collection("users").document(uid)
            .get()
            .addOnSuccessListener { document ->
                val preferences = document.get("privacyPreferences") as? Map<*, *>
                val personalizedRecommendations = preferences?.get("personalizedRecommendations") as? Boolean ?: true
                val analytics = preferences?.get("analytics") as? Boolean ?: true
                onResult(personalizedRecommendations, analytics)
            }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to fetch privacy preferences", e)
                onResult(true, true)
            }
    }

    fun updatePrivacyPreferences(
        uid: String?,
        personalizedRecommendations: Boolean,
        analytics: Boolean,
        onComplete: (Boolean) -> Unit
    ) {
        if (uid.isNullOrBlank()) {
            onComplete(false)
            return
        }

        val data = mapOf(
            "privacyPreferences" to mapOf(
                "personalizedRecommendations" to personalizedRecommendations,
                "analytics" to analytics
            )
        )

        db.collection("users").document(uid)
            .set(data, SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to update privacy preferences", e)
                onComplete(false)
            }
    }

    fun fetchAvatarId(uid: String?, onResult: (String) -> Unit) {
        if (uid.isNullOrBlank()) {
            onResult(DefaultAvatarId)
            return
        }

        db.collection("users").document(uid)
            .get()
            .addOnSuccessListener { document ->
                onResult(document.getString("avatarId") ?: DefaultAvatarId)
            }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to fetch avatar", e)
                onResult(DefaultAvatarId)
            }
    }

    fun updateAvatarId(uid: String?, avatarId: String, onComplete: (Boolean) -> Unit) {
        if (uid.isNullOrBlank()) {
            onComplete(false)
            return
        }

        db.collection("users").document(uid)
            .set(mapOf("avatarId" to avatarId), SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to update avatar", e)
                onComplete(false)
            }
    }

    fun fetchAvatars(onResult: (List<UserAvatar>) -> Unit) {
        val cached = cachedAvatars
        if (cached != null) {
            onResult(cached)
            return
        }

        val assetTasks = avatarAssetIds.map { assetId ->
            db.collection("interfaceAssets").document(assetId).get()
        }

        Tasks.whenAllSuccess<com.google.firebase.firestore.DocumentSnapshot>(assetTasks)
            .addOnSuccessListener { documents ->
                val avatars = documents.mapNotNull { document ->
                    if (!document.exists()) {
                        return@mapNotNull null
                    }

                    val assetId = document.getString("id")?.takeIf { it.isNotBlank() } ?: document.id
                    val kind = document.getString("kind") ?: ""
                    val svgMarkup = document.getString("svgMarkup")?.trim() ?: ""
                    if (assetId != document.id || kind != "vector" || svgMarkup.isBlank()) {
                        return@mapNotNull null
                    }

                    val name = document.getString("name") ?: nameFromAvatarId(document.id)
                    val label = document.getString("label") ?: name.take(2).uppercase()
                    val colorValues = document.get("colors") as? List<*>
                    val colors = colorValues
                        ?.mapNotNull { it as? String }
                        ?.map { parseColorSafe(it) }
                        ?.takeIf { it.isNotEmpty() }
                        ?: fallbackAvatars.first().colors
                    UserAvatar(document.id, name, label, colors, kind, svgMarkup)
                }
                if (avatars.isEmpty()) {
                    Log.w("FirestoreRepository", "No valid interface assets found; showing fallback avatars")
                    onResult(fallbackAvatars)
                } else {
                    Log.d("FirestoreRepository", "Fetched ${avatars.size} interface assets")
                    cachedAvatars = avatars
                    onResult(avatars)
                }
            }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to fetch interface assets", e)
                onResult(fallbackAvatars)
            }
    }

    fun prefetchAvatars(onComplete: () -> Unit) {
        fetchAvatars {
            onComplete()
        }
    }

    fun addRecentlyViewed(venueId: String) {
        recentlyViewedIds.remove(venueId)
        recentlyViewedIds.add(0, venueId)
        while (recentlyViewedIds.size > 5) {
            recentlyViewedIds.removeAt(recentlyViewedIds.lastIndex)
        }
    }

    private fun parseColorSafe(hex: String): Color {
        return try {
            Color(android.graphics.Color.parseColor(hex))
        } catch (e: Exception) {
            Color.Gray
        }
    }

    private fun nameFromAvatarId(id: String): String {
        return id
            .replace(Regex("^avatar_\\d+_"), "")
            .split("_")
            .joinToString(" ") { part -> part.replaceFirstChar { it.uppercase() } }
    }

    fun getCachedVenue(venueId: String): Venue? = cachedVenues?.firstOrNull { it.id == venueId }

    fun prefetchVenues(onComplete: () -> Unit) {
        fetchVenues {
            onComplete()
        }
    }

    fun fetchVenues(onResult: (List<Venue>) -> Unit) {
        val cached = cachedVenues
        if (cached != null) {
            onResult(cached)
            return
        }
        db.collection("venues")
            .get()
            .addOnSuccessListener { result ->
                if (result.isEmpty) {
                    val fallback = MockNearCampusRepository.venues
                    cachedVenues = fallback
                    onResult(fallback)
                } else {
                    val list = result.documents.mapNotNull { doc ->
                        try {
                            val id = doc.id
                            val name = doc.getString("name") ?: return@mapNotNull null
                            val category = doc.getString("category") ?: ""
                            val rating = doc.getDouble("rating") ?: 5.0
                            val priceRaw = doc.get("price")
                            val price = when (priceRaw) {
                                is String -> priceRaw
                                is Number -> "₺".repeat(priceRaw.toInt().coerceIn(1, 5))
                                else -> "₺"
                            }
                            val openNow = doc.getBoolean("openNow") ?: true
                            val discount = doc.getString("discount")
                            val address = doc.getString("address") ?: ""
                            val phone = doc.getString("phone") ?: ""
                            val paletteHex = doc.get("palette") as? List<*>
                            val palette = paletteHex?.mapNotNull { it as? String }?.map { parseColorSafe(it) } ?: emptyList()
                            val favorite = doc.getBoolean("favorite") ?: false
                            val imageUrl = doc.getString("cover") ?: doc.getString("imageUrl")

                            val coordinateMap = doc.get("coordinate") as? Map<*, *>
                            val latitude = doc.getDouble("latitude")
                                ?: coordinateMap?.get("latitude") as? Double
                                ?: (coordinateMap?.get("latitude") as? Number)?.toDouble()
                                ?: when(id) {
                                    "dynamite-kitchen" -> 41.08480
                                    "neon-noodle" -> 41.08900
                                    "brew-focus" -> 41.08420
                                    "study-bean" -> 41.08600
                                    "campus-burger" -> 41.08300
                                    "babs" -> 41.08250
                                    else -> 41.085221781433276
                                }
                            val longitude = doc.getDouble("longitude")
                                ?: coordinateMap?.get("longitude") as? Double
                                ?: (coordinateMap?.get("longitude") as? Number)?.toDouble()
                                ?: when(id) {
                                    "dynamite-kitchen" -> 29.04300
                                    "neon-noodle" -> 29.04700
                                    "brew-focus" -> 29.04900
                                    "study-bean" -> 29.04500
                                    "campus-burger" -> 29.04400
                                    "babs" -> 29.04750
                                    else -> 29.04672283222164
                                }

                            val distance = LocationService.userLocation?.let {
                                LocationService.calculateDistanceKm(it.latitude, it.longitude, latitude, longitude)
                            } ?: LocationService.calculateDistanceKm(41.085221781433276, 29.04672283222164, latitude, longitude)

                            val formattedDistance = Math.round(distance * 10.0) / 10.0

                            Venue(id, name, category, formattedDistance, rating, price, openNow, discount, address, phone, palette, favorite, latitude, longitude, imageUrl)
                        } catch (e: Exception) {
                            Log.e("FirestoreRepository", "Error parsing venue document", e)
                            null
                        }
                    }
                    val finalResult = (if (list.isEmpty()) MockNearCampusRepository.venues else list).sortedBy { it.distanceKm }
                    finalResult.forEach { venue ->
                        if (!favoriteStates.containsKey(venue.id)) {
                            favoriteStates[venue.id] = venue.favorite
                        }
                    }
                    cachedVenues = finalResult
                    onResult(finalResult)
                }
            }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to fetch venues, falling back to mock", e)
                val fallback = MockNearCampusRepository.venues.map { venue ->
                    val distance = LocationService.userLocation?.let {
                        LocationService.calculateDistanceKm(it.latitude, it.longitude, venue.latitude, venue.longitude)
                    } ?: LocationService.calculateDistanceKm(41.085221781433276, 29.04672283222164, venue.latitude, venue.longitude)
                    val formattedDistance = Math.round(distance * 10.0) / 10.0
                    venue.copy(distanceKm = formattedDistance)
                }.sortedBy { it.distanceKm }
                fallback.forEach { venue ->
                    if (!favoriteStates.containsKey(venue.id)) {
                        favoriteStates[venue.id] = venue.favorite
                    }
                }
                cachedVenues = fallback
                onResult(fallback)
            }
    }

    fun fetchMenuCategories(venueId: String, onResult: (List<MenuCategory>) -> Unit) {
        val cached = cachedMenuCategories[venueId]
        if (cached != null) {
            onResult(cached)
            return
        }
        db.collection("venues").document(venueId).collection("menuCategories")
            .get()
            .addOnSuccessListener { result ->
                if (result.isEmpty) {
                    val fallback = MockNearCampusRepository.menuCategories(venueId)
                    cachedMenuCategories[venueId] = fallback
                    onResult(fallback)
                } else {
                    val list = result.documents.mapNotNull { doc ->
                        try {
                            val name = doc.getString("name") ?: return@mapNotNull null
                            val no = doc.getLong("no")?.toInt() ?: 0
                            val details = doc.getString("details") ?: ""
                            val image = doc.getString("image")
                            val visibleOnQr = doc.getBoolean("visibleOnQr") ?: true
                            
                            val productsRaw = doc.get("products") as? List<*>
                            val products = productsRaw?.mapNotNull { item ->
                                val map = item as? Map<*, *> ?: return@mapNotNull null
                                val pName = map["name"] as? String ?: return@mapNotNull null
                                val pCategory = map["category"] as? String ?: ""
                                Log.d("FirestoreRepository", "Parsing product: $pName, Map content: $map")
                                val priceKeys = listOf("price", "fiyat", "cost", "amount", "priceText", "value", "fiyatı")
                                val priceVal = priceKeys.mapNotNull { map[it] }.firstOrNull()
                                val pPrice = when (priceVal) {
                                    is Number -> priceVal.toInt()
                                    is String -> priceVal.toIntOrNull() ?: priceVal.toDoubleOrNull()?.toInt() ?: 0
                                    else -> 0
                                }
                                val pDetails = map["details"] as? String ?: ""
                                val pImage = map["image"] as? String
                                val pVisibleOnQr = map["visibleOnQr"] as? Boolean ?: true
                                val pPassive = map["passive"] as? Boolean ?: false
                                MenuItem(pName, pCategory, pPrice, pDetails, pImage, pVisibleOnQr, pPassive)
                            } ?: emptyList()

                            MenuCategory(name, no, details, image, visibleOnQr, products)
                        } catch (e: Exception) {
                            Log.e("FirestoreRepository", "Error parsing category document", e)
                            null
                        }
                    }.sortedBy { it.no }
                    val finalResult = if (list.isEmpty()) MockNearCampusRepository.menuCategories(venueId) else list
                    cachedMenuCategories[venueId] = finalResult
                    onResult(finalResult)
                }
            }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to fetch categories, falling back to mock", e)
                val fallback = MockNearCampusRepository.menuCategories(venueId)
                cachedMenuCategories[venueId] = fallback
                onResult(fallback)
            }
    }

    fun fetchDiscounts(venueId: String, onResult: (List<Discount>) -> Unit) {
        val cached = cachedDiscounts[venueId]
        if (cached != null) {
            onResult(cached)
            return
        }
        db.collection("venues").document(venueId).collection("discounts")
            .get()
            .addOnSuccessListener { result ->
                if (result.isEmpty) {
                    val fallback = MockNearCampusRepository.discounts(venueId)
                    cachedDiscounts[venueId] = fallback
                    onResult(fallback)
                } else {
                    val list = result.documents.mapNotNull { doc ->
                        try {
                            val title = doc.getString("title") ?: return@mapNotNull null
                            val value = doc.getString("value") ?: ""
                            val terms = doc.getString("terms") ?: ""
                            val expires = doc.getString("expires") ?: ""
                            Discount(title, value, terms, expires)
                        } catch (e: Exception) {
                            null
                        }
                    }
                    val finalResult = if (list.isEmpty()) MockNearCampusRepository.discounts(venueId) else list
                    cachedDiscounts[venueId] = finalResult
                    onResult(finalResult)
                }
            }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to fetch discounts, falling back to mock", e)
                val fallback = MockNearCampusRepository.discounts(venueId)
                cachedDiscounts[venueId] = fallback
                onResult(fallback)
            }
    }

    private fun parseReviewDocument(doc: com.google.firebase.firestore.DocumentSnapshot): Review? {
        return try {
            val title = doc.getString("title") ?: return null
            val author = doc.getString("author") ?: ""
            val rating = doc.getLong("rating")?.toInt() ?: 5
            val body = doc.getString("body") ?: ""
            Review(title, author, rating, body)
        } catch (e: Exception) {
            null
        }
    }

    private fun itemReviewCacheKey(venueId: String, itemId: String) = "$venueId::$itemId"

    private fun recomputeVenueReviews(venueId: String): List<Review> {
        val directReviews = cachedDirectReviews[venueId] ?: emptyList()
        val itemReviews = cachedItemReviews
            .filterKeys { it.startsWith("$venueId::") }
            .values
            .flatten()
        val combined = directReviews + itemReviews
        cachedReviews[venueId] = combined
        updateVenueRating(venueId, combined)
        return combined
    }

    private fun fetchAllItemReviewsForVenue(venueId: String, onResult: (List<Review>) -> Unit) {
        val categories = cachedMenuCategories[venueId]
        if (categories != null) {
            loadItemReviewsForMenu(venueId, categories, onResult)
            return
        }
        fetchMenuCategories(venueId) { loadedCategories ->
            loadItemReviewsForMenu(venueId, loadedCategories, onResult)
        }
    }

    private fun loadItemReviewsForMenu(
        venueId: String,
        categories: List<MenuCategory>,
        onResult: (List<Review>) -> Unit
    ) {
        val items = categories.flatMap { it.products }.distinctBy { it.itemId }
        if (items.isEmpty()) {
            onResult(emptyList())
            return
        }

        val collected = mutableListOf<Review>()
        var pending = items.size
        items.forEach { item ->
            fetchItemReviews(venueId, item.itemId) { reviews ->
                collected.addAll(reviews)
                pending -= 1
                if (pending == 0) {
                    onResult(collected.toList())
                }
            }
        }
    }

    private fun loadCombinedReviews(venueId: String, directReviews: List<Review>, onResult: (List<Review>) -> Unit) {
        cachedDirectReviews[venueId] = directReviews
        fetchAllItemReviewsForVenue(venueId) {
            onResult(recomputeVenueReviews(venueId))
        }
    }

    fun fetchReviews(venueId: String, onResult: (List<Review>) -> Unit) {
        val cached = cachedReviews[venueId]
        if (cached != null) {
            onResult(cached)
            return
        }
        db.collection("venues").document(venueId).collection("reviews")
            .get()
            .addOnSuccessListener { result ->
                val directReviews = if (result.isEmpty) {
                    MockNearCampusRepository.reviews(venueId)
                } else {
                    val list = result.documents.mapNotNull { parseReviewDocument(it) }
                    if (list.isEmpty()) MockNearCampusRepository.reviews(venueId) else list
                }
                loadCombinedReviews(venueId, directReviews, onResult)
            }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to fetch reviews, falling back to mock", e)
                loadCombinedReviews(venueId, MockNearCampusRepository.reviews(venueId), onResult)
            }
    }

    private fun updateVenueRating(venueId: String, reviews: List<Review>) {
        val average = if (reviews.isNotEmpty()) {
            reviews.map { it.rating }.average()
        } else {
            5.0
        }
        val roundedAverage = Math.round(average * 10.0) / 10.0

        // 1. Update cachedVenues in memory
        cachedVenues = cachedVenues?.map { venue ->
            if (venue.id == venueId) {
                venue.copy(rating = roundedAverage)
            } else {
                venue
            }
        }

        // 2. Update the Firestore venues collection rating field
        db.collection("venues").document(venueId)
            .update("rating", roundedAverage)
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to update venue rating in DB", e)
            }
    }

    fun fetchItemReviews(venueId: String, itemId: String, onResult: (List<Review>) -> Unit) {
        val cacheKey = itemReviewCacheKey(venueId, itemId)
        val cached = cachedItemReviews[cacheKey]
        if (cached != null) {
            onResult(cached)
            return
        }

        db.collection("venues").document(venueId)
            .collection("menuItems").document(itemId)
            .collection("reviews")
            .get()
            .addOnSuccessListener { result ->
                if (result.isEmpty) {
                    val fallback = MockNearCampusRepository.itemReviews(venueId, itemId)
                    cachedItemReviews[cacheKey] = fallback
                    if (cachedDirectReviews.containsKey(venueId)) {
                        recomputeVenueReviews(venueId)
                    }
                    onResult(fallback)
                } else {
                    val list = result.documents.mapNotNull { parseReviewDocument(it) }
                    val finalResult = if (list.isEmpty()) {
                        MockNearCampusRepository.itemReviews(venueId, itemId)
                    } else {
                        list
                    }
                    cachedItemReviews[cacheKey] = finalResult
                    if (cachedDirectReviews.containsKey(venueId)) {
                        recomputeVenueReviews(venueId)
                    }
                    onResult(finalResult)
                }
            }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to fetch item reviews, falling back to mock", e)
                val fallback = MockNearCampusRepository.itemReviews(venueId, itemId)
                cachedItemReviews[cacheKey] = fallback
                if (cachedDirectReviews.containsKey(venueId)) {
                    recomputeVenueReviews(venueId)
                }
                onResult(fallback)
            }
    }

    fun submitItemReview(
        venueId: String,
        itemId: String,
        review: Review,
        authorUid: String?,
        onComplete: (Boolean) -> Unit
    ) {
        fetchStudentVerificationStatus(authorUid) { isStudentVerified ->
            if (!isStudentVerified) {
                onComplete(false)
                return@fetchStudentVerificationStatus
            }

            val data = mapOf(
                "title" to review.title,
                "author" to review.author,
                "authorUid" to (authorUid ?: ""),
                "rating" to review.rating,
                "body" to review.body,
                "timestamp" to com.google.firebase.Timestamp.now()
            )
            db.collection("venues").document(venueId)
                .collection("menuItems").document(itemId)
                .collection("reviews")
                .add(data)
                .addOnSuccessListener {
                    val cacheKey = itemReviewCacheKey(venueId, itemId)
                    val currentReviews = (cachedItemReviews[cacheKey] ?: emptyList()) + review
                    cachedItemReviews[cacheKey] = currentReviews
                    if (cachedDirectReviews.containsKey(venueId)) {
                        recomputeVenueReviews(venueId)
                    } else {
                        fetchReviews(venueId) { }
                    }
                    onComplete(true)
                }
                .addOnFailureListener { onComplete(false) }
        }
    }

    fun submitReview(venueId: String, review: Review, authorUid: String?, onComplete: (Boolean) -> Unit) {
        fetchStudentVerificationStatus(authorUid) { isStudentVerified ->
            if (!isStudentVerified) {
                onComplete(false)
                return@fetchStudentVerificationStatus
            }

            val data = mapOf(
                "title" to review.title,
                "author" to review.author,
                "authorUid" to (authorUid ?: ""),
                "rating" to review.rating,
                "body" to review.body,
                "timestamp" to com.google.firebase.Timestamp.now()
            )
            db.collection("venues").document(venueId).collection("reviews")
                .add(data)
                .addOnSuccessListener {
                    val currentDirect = (cachedDirectReviews[venueId] ?: emptyList()) + review
                    cachedDirectReviews[venueId] = currentDirect
                    recomputeVenueReviews(venueId)
                    onComplete(true)
                }
                .addOnFailureListener { onComplete(false) }
        }
    }

    fun refreshVenuesCache(onComplete: (() -> Unit)? = null) {
        cachedVenues = null
        fetchVenues {
            onComplete?.invoke()
        }
    }

    fun toggleFavorite(venueId: String, isFavorite: Boolean, onComplete: (Boolean) -> Unit) {
        db.collection("venues").document(venueId)
            .update("favorite", isFavorite)
            .addOnSuccessListener {
                favoriteStates[venueId] = isFavorite
                refreshVenuesCache()
                onComplete(true)
            }
            .addOnFailureListener { onComplete(false) }
    }

    fun clearCacheAndFavorites() {
        favoriteStates.clear()
        recentlyViewedIds.clear()
        cachedVenues = null
        cachedMenuCategories.clear()
        cachedDiscounts.clear()
        cachedReviews.clear()
        cachedDirectReviews.clear()
        cachedItemReviews.clear()
        cachedCampaigns = null
    }

    fun fetchAllCampaigns(onResult: (List<Campaign>) -> Unit) {
        val cached = cachedCampaigns
        if (cached != null) {
            onResult(cached)
            return
        }

        db.collectionGroup("discounts")
            .get()
            .addOnSuccessListener { result ->
                if (result.isEmpty) {
                    onResult(emptyList())
                } else {
                    val list = result.documents.mapNotNull { doc ->
                        try {
                            val title = doc.getString("title") ?: return@mapNotNull null
                            val value = doc.getString("value") ?: ""
                            val terms = doc.getString("terms") ?: ""
                            val expires = doc.getString("expires") ?: ""
                            val venueId = doc.reference.parent.parent?.id

                            // Dynamically select a beautiful color palette based on title / venueId hash
                            val hash = (venueId ?: title).hashCode()
                            val gradientIndex = Math.abs(hash) % 4
                            val gradientColors = when (gradientIndex) {
                                0 -> listOf(Color(0xFFFF5722), Color(0xFFFF9800)) // Orange-Red
                                1 -> listOf(Color(0xFFE91E63), Color(0xFF9C27B0)) // Purple-Pink
                                2 -> listOf(Color(0xFF3F51B5), Color(0xFF00BCD4)) // Indigo-Cyan
                                else -> listOf(Color(0xFF4CAF50), Color(0xFF8BC34A)) // Green-Lime
                            }

                            Campaign(
                                id = doc.id,
                                venueId = venueId,
                                title = title,
                                description = terms,
                                badge = "DISCOUNT DEAL",
                                gradientColors = gradientColors,
                                discountText = value
                            )
                        } catch (e: Exception) {
                            null
                        }
                    }
                    cachedCampaigns = list
                    onResult(list)
                }
            }
            .addOnFailureListener { e ->
                Log.w("FirestoreRepository", "Failed to fetch all campaigns", e)
                onResult(emptyList())
            }
    }

    fun fetchAllCampaignsMatch(venueId: String, query: String): Boolean {
        if (query.isBlank()) return false
        return cachedCampaigns?.any { campaign ->
            campaign.venueId == venueId && campaign.title.contains(query, true)
        } ?: false
    }
}
