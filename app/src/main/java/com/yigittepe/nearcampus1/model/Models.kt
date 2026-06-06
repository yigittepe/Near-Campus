package com.yigittepe.nearcampus1.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

internal enum class Screen {
    Welcome,
    Login,
    Register,
    Home,
    Search,
    Favorites,
    Profile,
    Detail,
    Reviews,
    Review,
    Discount,
    MenuItemDetail
}

internal data class BottomTab(
    val label: String,
    val icon: ImageVector,
    val screen: Screen
)

internal data class Venue(
    val id: String,
    val name: String,
    val category: String,
    val distanceKm: Double,
    val rating: Double,
    val price: String,
    val openNow: Boolean,
    val discount: String?,
    val address: String,
    val phone: String,
    val palette: List<Color>,
    val favorite: Boolean = false,
    val latitude: Double = 41.085221781433276,
    val longitude: Double = 29.04672283222164,
    val imageUrl: String? = null
) {
    val distanceText: String
        get() = if (distanceKm > 100.0) "100 km+" else "${distanceKm}km"

    val priceLevel: Int
        get() = price.count { it == '₺' }.coerceIn(1, 5)
}

internal data class MenuItem(
    val name: String,
    val category: String,
    val price: Int,
    val details: String = "",
    val image: String? = null,
    val visibleOnQr: Boolean = true,
    val passive: Boolean = false
) {
    val priceText: String
        get() = "₺$price"

    val itemId: String
        get() = slugify(name)

    companion object {
        fun slugify(name: String): String {
            val normalized = java.text.Normalizer.normalize(name, java.text.Normalizer.Form.NFD)
                .replace(Regex("\\p{Mn}+"), "")
                .lowercase()
            return normalized
                .replace(Regex("[^a-z0-9]+"), "-")
                .trim('-')
                .ifBlank { "item" }
        }
    }
}

internal data class MenuCategory(
    val name: String,
    val no: Int,
    val details: String = "",
    val image: String? = null,
    val visibleOnQr: Boolean = true,
    val products: List<MenuItem>
)

internal data class Review(
    val title: String,
    val author: String,
    val rating: Int,
    val body: String
)

internal sealed class ReviewContext {
    abstract val venueId: String
    abstract val subjectName: String
    abstract val subjectSubtitle: String

    data class VenueReview(val venue: Venue) : ReviewContext() {
        override val venueId: String = venue.id
        override val subjectName: String = venue.name
        override val subjectSubtitle: String = "Verified student reviews"
    }

    data class ItemReview(override val venueId: String, val item: MenuItem) : ReviewContext() {
        override val subjectName: String = item.name
        override val subjectSubtitle: String = "Verified student item reviews"
    }
}

internal data class Discount(
    val title: String,
    val value: String,
    val terms: String,
    val expires: String
)

internal data class Campaign(
    val id: String,
    val venueId: String?,
    val title: String,
    val description: String,
    val badge: String,
    val gradientColors: List<Color>,
    val discountText: String
)

internal data class UserAvatar(
    val id: String,
    val name: String,
    val label: String,
    val colors: List<Color>,
    val kind: String = "vector",
    val svgMarkup: String? = null
)
