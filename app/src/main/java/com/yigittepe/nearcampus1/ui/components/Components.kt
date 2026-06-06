package com.yigittepe.nearcampus1.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.yigittepe.nearcampus1.data.FirestoreRepository
import com.yigittepe.nearcampus1.data.AuthManager
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yigittepe.nearcampus1.model.Discount
import com.yigittepe.nearcampus1.model.MenuCategory
import com.yigittepe.nearcampus1.model.MenuItem
import com.yigittepe.nearcampus1.model.Review
import com.yigittepe.nearcampus1.model.Venue
import com.yigittepe.nearcampus1.ui.theme.Border
import com.yigittepe.nearcampus1.ui.theme.Gold
import com.yigittepe.nearcampus1.ui.theme.GoldText
import com.yigittepe.nearcampus1.ui.theme.Ink
import com.yigittepe.nearcampus1.ui.theme.Muted

internal fun optimizeImageUrl(url: String?): String? {
    if (url.isNullOrBlank()) return null
    if (url.contains("wixstatic.com/media/")) {
        val fillIndex = url.indexOf("/v1/fill/")
        val baseUrl = if (fillIndex != -1) url.substring(0, fillIndex) else url
        return "$baseUrl/v1/fill/w_800,h_800,q_85/image.webp"
    }
    return url
}

internal enum class TagTone {
    Neutral,
    Positive,
    Promo,
    Warning
}

internal enum class VenueChipVariant(
    val maxTags: Int,
    val maxChars: Int
) {
    LargeCard(maxTags = 2, maxChars = 18),
    MiniCard(maxTags = 1, maxChars = 18),
    Default(maxTags = Int.MAX_VALUE, maxChars = Int.MAX_VALUE)
}

internal data class VenueTag(
    val label: String,
    val tone: TagTone = TagTone.Neutral,
    val icon: ImageVector? = null
)

internal fun venueTags(venue: Venue): List<VenueTag> = buildList {
    venue.discount?.let { add(VenueTag(it, TagTone.Promo, Icons.Default.LocalOffer)) }
    add(VenueTag(if (venue.openNow) "Open now" else "Closed", if (venue.openNow) TagTone.Positive else TagTone.Warning))
    add(VenueTag(venue.category.substringBefore("/").trim()))
}

private fun String.limitTagChars(maxChars: Int): String {
    if (length <= maxChars) return this
    return take((maxChars - 3).coerceAtLeast(0)).trimEnd() + "..."
}

@Composable
internal fun StatusTag(
    label: String,
    modifier: Modifier = Modifier,
    tone: TagTone = TagTone.Neutral,
    icon: ImageVector? = null,
    variant: VenueChipVariant = VenueChipVariant.Default
) {
    val containerColor = when (tone) {
        TagTone.Neutral -> Color(0xFFF1F3F4)
        TagTone.Positive -> Color(0xFFE6F4EA)
        TagTone.Promo -> GoldText
        TagTone.Warning -> Color(0xFFFFF4E5)
    }
    val contentColor = when (tone) {
        TagTone.Neutral -> Ink
        TagTone.Positive -> Color(0xFF146C2E)
        TagTone.Promo -> Color.White
        TagTone.Warning -> Color(0xFF8A4B00)
    }

    val chipHeight = when (variant) {
        VenueChipVariant.MiniCard -> 22.dp
        VenueChipVariant.LargeCard -> 28.dp
        VenueChipVariant.Default -> 28.dp
    }
    val horizontalPadding = when (variant) {
        VenueChipVariant.MiniCard -> 10.dp
        VenueChipVariant.LargeCard -> 10.dp
        VenueChipVariant.Default -> 10.dp
    }
    val verticalPadding = when (variant) {
        VenueChipVariant.MiniCard -> 0.dp
        VenueChipVariant.LargeCard -> 0.dp
        VenueChipVariant.Default -> 0.dp
    }
    val iconSize = when (variant) {
        VenueChipVariant.MiniCard -> 10.5.dp
        VenueChipVariant.LargeCard -> 11.667.dp
        VenueChipVariant.Default -> 13.dp
    }
    val textSize = when (variant) {
        VenueChipVariant.MiniCard -> 10.sp
        VenueChipVariant.LargeCard -> 12.sp
        VenueChipVariant.Default -> 12.sp
    }
    val textWeight = when (variant) {
        VenueChipVariant.MiniCard -> FontWeight.Normal
        VenueChipVariant.LargeCard -> FontWeight.Bold
        VenueChipVariant.Default -> FontWeight.SemiBold
    }

    Surface(
        modifier = modifier.heightIn(min = chipHeight),
        shape = RoundedCornerShape(999.dp),
        color = containerColor
    ) {
        Row(
            Modifier.height(chipHeight).padding(horizontal = horizontalPadding, vertical = verticalPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(icon, null, Modifier.size(iconSize), tint = contentColor)
                Spacer(Modifier.width(4.dp))
            }
            Text(
                label.limitTagChars(variant.maxChars),
                color = contentColor,
                fontSize = textSize,
                fontWeight = textWeight,
                letterSpacing = 0.6.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
internal fun VenueTagRow(
    tags: List<VenueTag>,
    modifier: Modifier = Modifier,
    variant: VenueChipVariant,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(6.dp)
) {
    Row(modifier, horizontalArrangement = horizontalArrangement, verticalAlignment = Alignment.CenterVertically) {
        tags.take(variant.maxTags).forEach { tag ->
            StatusTag(
                label = tag.label,
                tone = tag.tone,
                icon = tag.icon,
                variant = variant
            )
        }
    }
}

@Composable
internal fun SearchBar(text: String, button: String? = null) {
    Surface(shape = RoundedCornerShape(16.dp), color = Color.White, shadowElevation = 4.dp, border = BorderStroke(1.dp, Border)) {
        Row(Modifier.fillMaxWidth().height(58.dp).padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Search, null, tint = Muted)
            Text(text, Modifier.weight(1f).padding(horizontal = 12.dp), color = Muted)
            if (button != null) {
                Button(onClick = {}, shape = RoundedCornerShape(8.dp), contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 14.dp)) {
                    Text(button)
                }
            }
        }
    }
}



@Composable
internal fun SectionHeader(
    title: String,
    action: String? = null,
    onActionClick: (() -> Unit)? = null
) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {
        Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        if (action != null) {
            Text(
                action,
                color = Ink,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = if (onActionClick != null) Modifier.clickable { onActionClick() } else Modifier
            )
        }
    }
}

private data class VenueViewOption(
    val showMap: Boolean,
    val label: String,
    val icon: ImageVector
)

@Composable
internal fun AllVenuesSectionHeader(
    showMap: Boolean,
    onToggleView: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("All Venues", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        VenueViewToggle(showMap = showMap, onToggleView = onToggleView)
    }
}

@Composable
private fun VenueViewToggle(
    showMap: Boolean,
    onToggleView: (Boolean) -> Unit
) {
    val options = listOf(
        VenueViewOption(showMap = false, label = "List", icon = Icons.AutoMirrored.Filled.List),
        VenueViewOption(showMap = true, label = "Map", icon = Icons.Default.Map)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Border.copy(alpha = 0.45f))
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        options.forEach { option ->
            val selected = showMap == option.showMap
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (selected) Ink else Color.Transparent)
                    .clickable { onToggleView(option.showMap) },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    option.icon,
                    contentDescription = null,
                    tint = if (selected) Color.White else Muted,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    option.label,
                    color = if (selected) Color.White else Muted,
                    fontSize = 14.sp,
                    fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Medium
                )
            }
        }
    }
}

@Composable
internal fun VenueCard(venue: Venue, openVenue: (String) -> Unit) {
    var reviews by remember(venue.id) { mutableStateOf<List<Review>?>(null) }
    LaunchedEffect(venue.id) {
        FirestoreRepository.fetchReviews(venue.id) {
            reviews = it
        }
    }
    val calculatedRating = remember(reviews) {
        if (reviews != null) {
            if (reviews!!.isNotEmpty()) {
                val average = reviews!!.map { it.rating }.average()
                Math.round(average * 10.0) / 10.0
            } else {
                venue.rating
            }
        } else {
            null
        }
    }

    Card(
        onClick = { openVenue(venue.id) },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        VenueHero(
            venue = venue,
            modifier = Modifier.fillMaxWidth().height(350.dp),
            chipVariant = VenueChipVariant.LargeCard
        )
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(venue.name, fontSize = 20.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                RatingPill(calculatedRating)
            }
            Text("${venue.distanceText} • ${venue.category} • ${venue.price}", color = Muted, fontSize = 12.sp)
        }
    }
}

@Composable
internal fun VenueHero(
    venue: Venue,
    modifier: Modifier,
    chipVariant: VenueChipVariant = VenueChipVariant.Default
) {
    val palette = venue.palette.ifEmpty { listOf(Color(0xFFF7F4EC), Color(0xFFE4DFD5)) }
    Box(modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)).background(Brush.linearGradient(palette))) {
        if (!venue.imageUrl.isNullOrEmpty()) {
            AsyncImage(
                model = optimizeImageUrl(venue.imageUrl),
                contentDescription = venue.name,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )
        } else {
            Icon(Icons.Default.Restaurant, null, Modifier.align(Alignment.Center).size(72.dp), tint = Color.White.copy(alpha = 0.72f))
        }
        VenueTagRow(
            tags = venueTags(venue),
            variant = chipVariant,
            modifier = Modifier.align(Alignment.TopStart).padding(if (chipVariant == VenueChipVariant.MiniCard) 8.dp else 16.dp)
        )
        if (chipVariant != VenueChipVariant.MiniCard) {
            val context = androidx.compose.ui.platform.LocalContext.current
            val isFav = AuthManager.isUserSignedIn() && (FirestoreRepository.favoriteStates[venue.id] ?: venue.favorite)
            Surface(
                Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
                    .size(40.dp)
                    .clickable {
                        if (!AuthManager.isUserSignedIn()) {
                            AuthManager.onRequireAuth?.invoke()
                        } else {
                            val nextFav = !isFav
                            FirestoreRepository.toggleFavorite(venue.id, nextFav) { success ->
                                if (success) {
                                    android.widget.Toast.makeText(
                                        context,
                                        if (nextFav) "${venue.name} is added to your favorites" else "${venue.name} is no longer your favorite",
                                        android.widget.Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    },
                shape = RoundedCornerShape(12.dp),
                color = Color.White.copy(alpha = 0.92f)
            ) {
                Icon(
                    imageVector = if (isFav) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.padding(10.dp),
                    tint = GoldText
                )
            }
        }
    }
}

@Composable
internal fun SmallVenueCard(venue: Venue, openVenue: (String) -> Unit) {
    var reviews by remember(venue.id) { mutableStateOf<List<Review>?>(null) }
    LaunchedEffect(venue.id) {
        FirestoreRepository.fetchReviews(venue.id) {
            reviews = it
        }
    }
    val calculatedRating = remember(reviews) {
        if (reviews != null) {
            if (reviews!!.isNotEmpty()) {
                val average = reviews!!.map { it.rating }.average()
                Math.round(average * 10.0) / 10.0
            } else {
                venue.rating
            }
        } else {
            null
        }
    }

    Column(Modifier.width(160.dp).clickable { openVenue(venue.id) }) {
        VenueHero(
            venue = venue,
            modifier = Modifier.fillMaxWidth().height(160.dp),
            chipVariant = VenueChipVariant.MiniCard
        )
        Spacer(Modifier.height(8.dp))
        Text(venue.name, fontSize = 12.sp, fontWeight = FontWeight.Medium, maxLines = 1)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("★ ", color = GoldText, fontSize = 12.sp)
            if (calculatedRating == null) {
                Box(
                    Modifier
                        .size(width = 24.dp, height = 12.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(
                            Brush.linearGradient(
                                listOf(Color(0xFFE0E0E0), Color(0xFFF5F5F5), Color(0xFFE0E0E0))
                            )
                        )
                )
            } else {
                Text(calculatedRating.toString(), color = Muted, fontSize = 12.sp)
            }
            Text(" • ${venue.distanceText}", color = Muted, fontSize = 12.sp)
        }
    }
}

@Composable
internal fun CompactVenueRow(venue: Venue, openVenue: (String) -> Unit) {
    Card(onClick = { openVenue(venue.id) }, colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(8.dp)) {
        Row(Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                Modifier
                    .size(58.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Brush.linearGradient(venue.palette.ifEmpty { listOf(Gold, Border) })),
                contentAlignment = Alignment.Center
            ) {
                if (!venue.imageUrl.isNullOrEmpty()) {
                    AsyncImage(
                        model = optimizeImageUrl(venue.imageUrl),
                        contentDescription = venue.name,
                        modifier = Modifier.matchParentSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(venue.name, fontWeight = FontWeight.Bold)
                Text("${venue.category} • ${venue.distanceText}", color = Muted, fontSize = 12.sp)
            }
        }
    }
}



@Composable
internal fun SettingsGroup(
    title: String,
    rows: List<Pair<ImageVector, String>>,
    onRowClick: ((String) -> Unit)? = null
) {
    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(title, Modifier.padding(horizontal = 16.dp), color = Muted, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(8.dp), border = BorderStroke(1.dp, Border)) {
            rows.forEachIndexed { index, row ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .then(
                            if (onRowClick != null) {
                                Modifier.clickable { onRowClick(row.second) }
                            } else {
                                Modifier
                            }
                        )
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(row.first, null, tint = Color(0xFF43474E), modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(16.dp))
                    Text(row.second, Modifier.weight(1f), fontSize = 17.sp, color = Ink)
                    Text("›", color = Muted, fontSize = 24.sp)
                }
                if (index != rows.lastIndex) HorizontalDivider(color = Border)
            }
        }
    }
}

@Composable
internal fun DetailSection(title: String, showTitle: Boolean = true, content: @Composable ColumnScope.() -> Unit) {
    Column(Modifier.padding(horizontal = 20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        if (showTitle) SectionHeader(title)
        Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(12.dp)) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp), content = content)
        }
    }
}

@Composable
internal fun MenuCategorySelector(
    categories: List<MenuCategory>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    Surface(Modifier.fillMaxWidth(), color = Color.White, shadowElevation = 3.dp) {
        Column(Modifier.padding(horizontal = 20.dp, vertical = 10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            SectionHeader("Menu Categories")
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(categories) { category ->
                    FilterChip(
                        selected = category.name == selectedCategory,
                        onClick = { onCategorySelected(category.name) },
                        label = { Text(category.name, maxLines = 1, overflow = TextOverflow.Ellipsis) }
                    )
                }
            }
        }
    }
}

@Composable
internal fun MenuRow(item: MenuItem, onClick: (() -> Unit)? = null) {
    val clickableModifier = if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 64.dp)
            .then(clickableModifier)
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFF7F7F7)),
            contentAlignment = Alignment.Center
        ) {
            if (!item.image.isNullOrEmpty()) {
                AsyncImage(
                    model = optimizeImageUrl(item.image),
                    contentDescription = item.name,
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.Crop
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Restaurant,
                    contentDescription = null,
                    tint = Ink,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Spacer(Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Ink,
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    text = item.priceText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Ink
                )
            }
            if (item.details.isNotBlank()) {
                Spacer(Modifier.height(2.dp))
                Text(
                    text = item.details,
                    color = Muted,
                    fontSize = 12.sp,
                    lineHeight = 16.sp
                )
            }
        }
    }
}

@Composable
internal fun ReviewRow(review: Review) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(review.title, Modifier.weight(1f), fontWeight = FontWeight.Bold)
            Text("★ ${review.rating}", color = GoldText)
        }
        Text(review.body, color = Muted)
        Text(review.author, color = Ink, fontSize = 12.sp)
    }
}

@Composable
internal fun DiscountRow(discount: Discount, onClick: () -> Unit) {
    Row(Modifier.fillMaxWidth().clickable(onClick = onClick), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.LocalOffer, null, tint = GoldText)
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {
            Text(discount.title, fontWeight = FontWeight.Bold)
            Text("${discount.value} • ${discount.expires}", color = Muted, fontSize = 12.sp)
        }
    }
}

@Composable
internal fun RatingPill(
    rating: Double?,
    label: String? = null,
    onClick: (() -> Unit)? = null
) {
    val clickableModifier = if (onClick != null && rating != null) Modifier.clickable(onClick = onClick) else Modifier
    Surface(shape = RoundedCornerShape(12.dp), color = Color(0xFFF8F9FA)) {
        if (rating == null) {
            Box(
                Modifier
                    .size(width = 48.dp, height = 20.dp)
                    .background(
                        Brush.linearGradient(
                            listOf(Color(0xFFE0E0E0), Color(0xFFF5F5F5), Color(0xFFE0E0E0))
                        )
                    )
            )
        } else {
            Row(clickableModifier.padding(horizontal = 8.dp, vertical = 3.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Star, null, tint = Color(0xFFFFB000), modifier = Modifier.size(14.dp))
                Spacer(Modifier.width(4.dp))
                Text(rating.toString(), fontSize = 12.sp, fontWeight = FontWeight.Medium)
                if (label != null) {
                    Spacer(Modifier.width(4.dp))
                    Text(label, color = Muted, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}

@Composable
internal fun HeaderBar(title: String, onBack: () -> Unit) {
    Row(Modifier.fillMaxWidth().background(Color.White).statusBarsPadding().height(64.dp).padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = Ink) }
        Text(title, Modifier.weight(1f), color = Ink, fontWeight = FontWeight.Medium)
        Spacer(Modifier.size(48.dp))
    }
}

@Composable
internal fun TopTitle(title: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(title, color = Ink, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
internal fun BrandTitle(size: Int, modifier: Modifier = Modifier) {
    Text("Near Campus", modifier, color = Ink, fontSize = size.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
}
