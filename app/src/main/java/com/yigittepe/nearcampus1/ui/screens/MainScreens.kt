package com.yigittepe.nearcampus1.ui.screens

import com.yigittepe.nearcampus1.data.AuthManager
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items as gridItems
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.FilterChip
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yigittepe.nearcampus1.data.MockNearCampusRepository
import com.yigittepe.nearcampus1.model.Venue
import com.yigittepe.nearcampus1.model.Campaign
import com.yigittepe.nearcampus1.model.UserAvatar
import com.yigittepe.nearcampus1.ui.components.CompactVenueRow
import com.yigittepe.nearcampus1.ui.components.SearchBar
import com.yigittepe.nearcampus1.ui.components.AllVenuesSectionHeader
import com.yigittepe.nearcampus1.ui.components.SectionHeader
import com.yigittepe.nearcampus1.ui.components.VenueMapView
import com.yigittepe.nearcampus1.ui.components.SettingsGroup
import com.yigittepe.nearcampus1.ui.components.SmallVenueCard
import com.yigittepe.nearcampus1.ui.components.StatusTag
import com.yigittepe.nearcampus1.ui.components.TagTone
import com.yigittepe.nearcampus1.ui.components.HeaderBar
import com.yigittepe.nearcampus1.ui.components.TopTitle
import com.yigittepe.nearcampus1.ui.components.VenueCard
import com.yigittepe.nearcampus1.ui.components.venueTags
import com.yigittepe.nearcampus1.ui.theme.Border
import com.yigittepe.nearcampus1.ui.theme.Gold
import com.yigittepe.nearcampus1.ui.theme.GoldText
import com.yigittepe.nearcampus1.ui.theme.Ink
import com.yigittepe.nearcampus1.ui.theme.Muted
import com.yigittepe.nearcampus1.ui.theme.Navy

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import com.yigittepe.nearcampus1.data.FirestoreRepository
import androidx.compose.ui.platform.LocalContext
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import android.Manifest
import com.yigittepe.nearcampus1.data.LocationService
import com.yigittepe.nearcampus1.ui.components.VenueChipVariant
import androidx.compose.material.icons.filled.LocationOn
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.compose.runtime.DisposableEffect
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.OutlinedButton
import com.yigittepe.nearcampus1.ui.theme.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
internal fun CampaignCarousel(openVenue: (String) -> Unit, navigateToSearchWithQuery: (String) -> Unit) {
    var campaigns by remember { mutableStateOf<List<Campaign>?>(null) }
    LaunchedEffect(Unit) {
        FirestoreRepository.fetchAllCampaigns { campaigns = it }
    }

    if (campaigns == null) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Border),
            modifier = Modifier.fillMaxWidth().height(130.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            listOf(Color(0xFFF5F5F5), Color(0xFFE0E0E0), Color(0xFFF5F5F5))
                        )
                    )
                    .padding(16.dp)
            ) {
                Column(
                    Modifier.fillMaxHeight().fillMaxWidth(0.72f),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(Modifier.size(width = 80.dp, height = 20.dp).clip(RoundedCornerShape(8.dp)).background(Color.White.copy(alpha = 0.5f)))
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Box(Modifier.size(width = 180.dp, height = 18.dp).clip(RoundedCornerShape(4.dp)).background(Color.White.copy(alpha = 0.5f)))
                        Box(Modifier.size(width = 240.dp, height = 12.dp).clip(RoundedCornerShape(4.dp)).background(Color.White.copy(alpha = 0.5f)))
                    }
                }
                Box(
                    Modifier
                        .align(Alignment.CenterEnd)
                        .size(64.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color.White.copy(alpha = 0.4f))
                )
            }
        }
        return
    }

    if (campaigns!!.isEmpty()) {
        return
    }

    val pagerState = rememberPagerState(pageCount = { campaigns!!.size })

    LaunchedEffect(campaigns) {
        if (campaigns!!.size > 1) {
            while (true) {
                kotlinx.coroutines.delay(4000)
                val nextPage = (pagerState.currentPage + 1) % campaigns!!.size
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth().height(130.dp)
        ) { page ->
            val campaign = campaigns!![page]
            Card(
                onClick = {
                    val sameTitleCampaignsCount = campaigns!!.count {
                        it.title.equals(campaign.title, ignoreCase = true) && !it.venueId.isNullOrBlank()
                    }
                    if (sameTitleCampaignsCount > 1) {
                        navigateToSearchWithQuery(campaign.title)
                    } else {
                        val vId = campaign.venueId
                        if (!vId.isNullOrBlank()) {
                            openVenue(vId)
                        } else {
                            navigateToSearchWithQuery("")
                        }
                    }
                },
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp)
            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Brush.linearGradient(campaign.gradientColors))
                        .padding(16.dp)
                ) {
                    Column(
                        Modifier.fillMaxHeight().fillMaxWidth(0.72f),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color.White.copy(alpha = 0.24f),
                            contentColor = Color.White
                        ) {
                            Text(
                                text = campaign.badge,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = campaign.title,
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = campaign.description,
                                color = Color.White.copy(alpha = 0.9f),
                                fontSize = 11.sp,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    Box(
                        Modifier
                            .align(Alignment.CenterEnd)
                            .size(64.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color.White.copy(alpha = 0.18f))
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = campaign.discountText,
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                }
            }
        }

        if (campaigns!!.size > 1) {
            Row(
                Modifier.align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                campaigns!!.forEachIndexed { index, _ ->
                    val active = index == pagerState.currentPage
                    Box(
                        Modifier
                            .size(if (active) 12.dp else 6.dp, 6.dp)
                            .clip(RoundedCornerShape(3.dp))
                            .background(if (active) Navy else Color.Gray.copy(alpha = 0.4f))
                    )
                }
            }
        }
    }
}

private const val ALL_VENUES_SECTION_INDEX = 4

@Composable
internal fun HomeScreen(openVenue: (String) -> Unit, navigateToSearchWithQuery: (String) -> Unit) {
    var venues by remember { mutableStateOf<List<Venue>>(emptyList()) }
    var showAllVenuesMap by remember { mutableStateOf(false) }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        FirestoreRepository.fetchVenues { venues = it }
    }

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item { SearchBar("Find discounts, cafes, spaces...") }
        item {
            SectionHeader(
                title = "Nearby Favorites",
                action = "SEE ALL",
                onActionClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(ALL_VENUES_SECTION_INDEX)
                    }
                }
            )
        }
        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                if (venues.isEmpty()) {
                    items(3) { SmallVenueCardSkeleton() }
                } else {
                    items(venues.take(3)) { SmallVenueCard(it, openVenue) }
                }
            }
        }
        item { CampaignCarousel(openVenue, navigateToSearchWithQuery) }
        item {
            AllVenuesSectionHeader(
                showMap = showAllVenuesMap,
                onToggleView = { showAllVenuesMap = it }
            )
        }
        if (venues.isEmpty()) {
            items(3) { VenueCardSkeleton() }
        } else if (showAllVenuesMap) {
            item { VenueMapView(venues = venues, onVenueClick = openVenue) }
        } else {
            items(venues) { VenueCard(it, openVenue) }
        }
    }
}

private data class DistanceFilterOption(val label: String, val maxKm: Double?)

private val distanceFilterOptions = listOf(
    DistanceFilterOption("Any distance", null),
    DistanceFilterOption("Within 1 km", 1.0),
    DistanceFilterOption("Within 5 km", 5.0),
    DistanceFilterOption("Within 10 km", 10.0)
)

private val priceLevelLabels = (1..5).map { "₺".repeat(it) }

@Composable
internal fun SearchScreen(
    openVenue: (String) -> Unit,
    initialQuery: String = "",
    onQueryChange: (String) -> Unit = {}
) {
    var venues by remember { mutableStateOf<List<Venue>>(emptyList()) }
    var selectedTags by remember { mutableStateOf(emptySet<String>()) }
    var selectedDistance by remember { mutableStateOf(distanceFilterOptions.first()) }
    var minPriceLevel by remember { mutableStateOf<Int?>(null) }
    var maxPriceLevel by remember { mutableStateOf<Int?>(null) }

    LaunchedEffect(Unit) {
        FirestoreRepository.fetchVenues { venues = it }
    }

    val allTags = remember(venues) {
        venues.flatMap { venueTags(it) }.map { it.label }.distinct()
    }

    val results = venues.filter { venue ->
        val tags = venueTags(venue).map { it.label }
        val matchesTags = selectedTags.isEmpty() || selectedTags.all { selectedTag ->
            tags.any { it.equals(selectedTag, ignoreCase = true) }
        }

        val matchesText = venue.name.contains(initialQuery, true) ||
                          venue.category.contains(initialQuery, true) ||
                          (venue.discount != null && venue.discount.contains(initialQuery, true))

        val inCampaigns = FirestoreRepository.fetchAllCampaignsMatch(venue.id, initialQuery)

        val maxDistanceKm = selectedDistance.maxKm
        val matchesDistance = maxDistanceKm == null || venue.distanceKm <= maxDistanceKm

        val matchesMinPrice = minPriceLevel == null || venue.priceLevel >= minPriceLevel!!
        val matchesMaxPrice = maxPriceLevel == null || venue.priceLevel <= maxPriceLevel!!
        val matchesPrice = matchesMinPrice && matchesMaxPrice

        (matchesText || inCampaigns || initialQuery.isBlank()) &&
            matchesTags &&
            matchesDistance &&
            matchesPrice
    }

    LazyColumn(Modifier.fillMaxSize(), contentPadding = androidx.compose.foundation.layout.PaddingValues(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item { TopTitle("Search") }
        item {
            OutlinedTextField(
                initialQuery,
                onQueryChange,
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Search venues, discounts, tags") },
                leadingIcon = { Icon(Icons.Default.Search, null) },
                singleLine = true
            )
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Distance", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Muted)
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(distanceFilterOptions) { option ->
                        FilterChip(
                            selected = selectedDistance == option,
                            onClick = { selectedDistance = option },
                            label = { Text(option.label) }
                        )
                    }
                }
            }
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Price range", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Muted)
                Text("Min", fontSize = 12.sp, color = Muted)
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        FilterChip(
                            selected = minPriceLevel == null,
                            onClick = { minPriceLevel = null },
                            label = { Text("Any") }
                        )
                    }
                    items(priceLevelLabels.size) { index ->
                        val level = index + 1
                        val label = priceLevelLabels[index]
                        FilterChip(
                            selected = minPriceLevel == level,
                            onClick = {
                                minPriceLevel = level
                                if (maxPriceLevel != null && maxPriceLevel!! < level) {
                                    maxPriceLevel = level
                                }
                            },
                            label = { Text(label) }
                        )
                    }
                }
                Text("Max", fontSize = 12.sp, color = Muted)
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        FilterChip(
                            selected = maxPriceLevel == null,
                            onClick = { maxPriceLevel = null },
                            label = { Text("Any") }
                        )
                    }
                    items(priceLevelLabels.size) { index ->
                        val level = index + 1
                        val label = priceLevelLabels[index]
                        FilterChip(
                            selected = maxPriceLevel == level,
                            onClick = {
                                maxPriceLevel = level
                                if (minPriceLevel != null && minPriceLevel!! > level) {
                                    minPriceLevel = level
                                }
                            },
                            label = { Text(label) }
                        )
                    }
                }
            }
        }
        if (allTags.isNotEmpty()) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Tags", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Muted)
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(allTags) { tagLabel ->
                            val isSelected = selectedTags.contains(tagLabel)
                            FilterChip(
                                selected = isSelected,
                                onClick = {
                                    selectedTags = if (isSelected) {
                                        selectedTags - tagLabel
                                    } else {
                                        selectedTags + tagLabel
                                    }
                                },
                                label = { Text(tagLabel) }
                            )
                        }
                    }
                }
            }
        }
        if (venues.isEmpty()) {
            items(3) { VenueCardSkeleton() }
        } else if (results.isEmpty()) {
            item {
                Box(Modifier.fillMaxWidth().padding(vertical = 40.dp), contentAlignment = Alignment.Center) {
                    Text("No venues match your filters.", color = Muted, fontSize = 14.sp)
                }
            }
        } else {
            items(results) { VenueCard(it, openVenue) }
        }
    }
}

@Composable
internal fun FavoritesScreen(openVenue: (String) -> Unit) {
    var venues by remember { mutableStateOf<List<Venue>>(emptyList()) }
    LaunchedEffect(Unit) {
        FirestoreRepository.fetchVenues { venues = it }
    }
    
    val favorites = if (AuthManager.isUserSignedIn()) {
        venues.filter { FirestoreRepository.favoriteStates[it.id] ?: it.favorite }
    } else {
        emptyList()
    }
    val recentlyViewed = FirestoreRepository.recentlyViewedIds.mapNotNull { id ->
        venues.firstOrNull { it.id == id }
    }

    LazyColumn(Modifier.fillMaxSize(), contentPadding = androidx.compose.foundation.layout.PaddingValues(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item { TopTitle("Favorites") }
        if (venues.isEmpty()) {
            items(2) { VenueCardSkeleton() }
        } else {
            if (favorites.isEmpty()) {
                item {
                    Box(Modifier.fillMaxWidth().padding(vertical = 40.dp), contentAlignment = Alignment.Center) {
                        Text("No favorites added yet", color = Muted)
                    }
                }
            } else {
                items(favorites, key = { it.id }) { VenueCard(it, openVenue) }
            }
            if (recentlyViewed.isNotEmpty()) {
                item { SectionHeader("Recently Viewed") }
                items(recentlyViewed, key = { "recent_${it.id}" }) { CompactVenueRow(it, openVenue) }
            }
        }
    }
}

private enum class LegalDocument {
    Terms,
    Privacy
}

@Composable
private fun HelpCenterDialog(onDismiss: () -> Unit) {
    androidx.compose.ui.window.Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = Color.White,
            tonalElevation = 6.dp,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null,
                    tint = Navy,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    "Work in Progress",
                    color = Ink,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Help Center is coming soon. We are building guides and support tools to help you get the most out of Near Campus.",
                    color = Muted,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )
                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(containerColor = Navy),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text("Got it", fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }
    }
}

@Composable
private fun LegalDocumentScreen(document: LegalDocument, onBack: () -> Unit) {
    val title = when (document) {
        LegalDocument.Terms -> "Terms of Service"
        LegalDocument.Privacy -> "Privacy Policy"
    }
    val sections = when (document) {
        LegalDocument.Terms -> termsOfServiceSections()
        LegalDocument.Privacy -> privacyPolicySections()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Canvas)
    ) {
        HeaderBar(title, onBack)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                "Last updated: June 6, 2026",
                color = Muted,
                fontSize = 13.sp
            )
            Text(
                when (document) {
                    LegalDocument.Terms -> "Please read these terms carefully before using Near Campus."
                    LegalDocument.Privacy -> "This policy explains how Near Campus collects, uses, and protects your information."
                },
                color = Ink,
                fontSize = 15.sp,
                lineHeight = 22.sp
            )
            sections.forEach { section ->
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(section.title, color = Ink, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(section.body, color = Color(0xFF43474E), fontSize = 14.sp, lineHeight = 21.sp)
                }
            }
            Spacer(Modifier.height(12.dp))
        }
    }
}

private data class LegalSection(val title: String, val body: String)

private fun termsOfServiceSections(): List<LegalSection> = listOf(
    LegalSection(
        "1. Acceptance of Terms",
        "By accessing or using Near Campus, you agree to these Terms of Service. If you do not agree, please discontinue use of the app."
    ),
    LegalSection(
        "2. Eligibility",
        "Near Campus is designed for students and campus communities. You must provide accurate account information and comply with applicable university policies when using student verification features."
    ),
    LegalSection(
        "3. User Content",
        "Reviews, ratings, and other content you submit must be honest and respectful. We may remove content that is misleading, abusive, or violates these terms."
    ),
    LegalSection(
        "4. Venue Information",
        "Menus, prices, discounts, and venue details are provided by partner businesses and may change without notice. Near Campus does not guarantee availability of offers."
    ),
    LegalSection(
        "5. Account Security",
        "You are responsible for maintaining the confidentiality of your login credentials and for activity that occurs under your account."
    ),
    LegalSection(
        "6. Limitation of Liability",
        "Near Campus is provided on an \"as is\" basis. To the fullest extent permitted by law, we are not liable for indirect or consequential damages arising from your use of the service."
    ),
    LegalSection(
        "7. Changes to Terms",
        "We may update these terms from time to time. Continued use of the app after updates constitutes acceptance of the revised terms."
    ),
    LegalSection(
        "8. Contact",
        "For questions about these terms, contact us at support@nearcampus.app."
    )
)

private fun privacyPolicySections(): List<LegalSection> = listOf(
    LegalSection(
        "1. Information We Collect",
        "We collect information you provide directly, such as your name, email, profile avatar, reviews, and verification status. We may also collect device and usage data to improve the app experience."
    ),
    LegalSection(
        "2. Location Data",
        "With your permission, we use location data to sort nearby venues and improve local recommendations. You can disable location access in your device settings at any time."
    ),
    LegalSection(
        "3. How We Use Information",
        "We use your information to operate Near Campus, personalize recommendations, display relevant campus deals, maintain account security, and improve our services."
    ),
    LegalSection(
        "4. Sharing of Information",
        "We do not sell your personal information. We may share limited data with service providers that help us run the app, or when required by law."
    ),
    LegalSection(
        "5. Your Choices",
        "You can manage notification and privacy preferences in your profile, update your avatar, and request account deletion by contacting support."
    ),
    LegalSection(
        "6. Data Retention",
        "We retain account and review data while your account is active or as needed to provide services, comply with legal obligations, and resolve disputes."
    ),
    LegalSection(
        "7. Security",
        "We use reasonable administrative, technical, and organizational safeguards to protect your information, but no method of transmission or storage is completely secure."
    ),
    LegalSection(
        "8. Children's Privacy",
        "Near Campus is intended for university-age users and is not directed to children under 13."
    ),
    LegalSection(
        "9. Policy Updates",
        "We may revise this Privacy Policy periodically. Material changes will be reflected by updating the date at the top of this page."
    ),
    LegalSection(
        "10. Contact Us",
        "If you have privacy questions or requests, email privacy@nearcampus.app."
    )
)

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
internal fun ProfileScreen(onLogout: () -> Unit, onLogin: () -> Unit, onRegister: () -> Unit) {
    val user = AuthManager.getCurrentUser()
    val isSignedIn = user != null
    val displayName = user?.displayName ?: ""
    val email = user?.email ?: ""
    var avatarOptions by remember { mutableStateOf<List<UserAvatar>>(emptyList()) }
    var selectedAvatarId by remember(user?.uid) { mutableStateOf(DefaultProfileAvatarId) }
    var showAvatarSheet by remember { mutableStateOf(false) }
    var avatarMessage by remember { mutableStateOf<String?>(null) }
    var isStudentVerified by remember(user?.uid) { mutableStateOf<Boolean?>(null) }
    var isVerifyingStudent by remember { mutableStateOf(false) }
    var verificationMessage by remember { mutableStateOf<String?>(null) }
    var generalNotifications by remember(user?.uid) { mutableStateOf(true) }
    var dealNotifications by remember(user?.uid) { mutableStateOf(true) }
    var reviewNotifications by remember(user?.uid) { mutableStateOf(true) }
    var isSavingNotifications by remember { mutableStateOf(false) }
    var notificationMessage by remember { mutableStateOf<String?>(null) }
    var personalizedRecommendations by remember(user?.uid) { mutableStateOf(true) }
    var analyticsEnabled by remember(user?.uid) { mutableStateOf(true) }
    var isSavingPrivacy by remember { mutableStateOf(false) }
    var privacyMessage by remember { mutableStateOf<String?>(null) }
    var showHelpDialog by remember { mutableStateOf(false) }
    var showPasswordChangeDialog by remember { mutableStateOf(false) }
    var activeLegalDocument by remember { mutableStateOf<LegalDocument?>(null) }

    LaunchedEffect(user?.uid) {
        if (user == null) {
            selectedAvatarId = DefaultProfileAvatarId
            avatarMessage = null
            isStudentVerified = null
            generalNotifications = true
            dealNotifications = true
            reviewNotifications = true
            personalizedRecommendations = true
            analyticsEnabled = true
        } else {
            FirestoreRepository.fetchAvatars { avatars ->
                avatarOptions = avatars
            }
            FirestoreRepository.fetchAvatarId(user.uid) {
                selectedAvatarId = it
            }
            FirestoreRepository.fetchStudentVerificationStatus(user.uid) {
                isStudentVerified = it
            }
            FirestoreRepository.fetchNotificationPreferences(user.uid) { general, deals, reviews ->
                generalNotifications = general
                dealNotifications = deals
                reviewNotifications = reviews
            }
            FirestoreRepository.fetchPrivacyPreferences(user.uid) { personalized, analytics ->
                personalizedRecommendations = personalized
                analyticsEnabled = analytics
            }
        }
    }

    val selectedAvatar = profileAvatarById(selectedAvatarId, avatarOptions)
    val avatarSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    fun saveNotificationPreferences(general: Boolean, deals: Boolean, reviews: Boolean) {
        generalNotifications = general
        dealNotifications = deals
        reviewNotifications = reviews
        isSavingNotifications = true
        notificationMessage = null
        FirestoreRepository.updateNotificationPreferences(user?.uid, general, deals, reviews) { success ->
            isSavingNotifications = false
            notificationMessage = if (success) {
                "Notification preferences saved."
            } else {
                "Could not save notification preferences."
            }
        }
    }

    fun savePrivacyPreferences(personalized: Boolean, analytics: Boolean) {
        personalizedRecommendations = personalized
        analyticsEnabled = analytics
        isSavingPrivacy = true
        privacyMessage = null
        FirestoreRepository.updatePrivacyPreferences(user?.uid, personalized, analytics) { success ->
            isSavingPrivacy = false
            privacyMessage = if (success) {
                "Privacy preferences saved."
            } else {
                "Could not save privacy preferences."
            }
        }
    }

    val context = LocalContext.current
    var isPermissionGranted by remember {
        mutableStateOf(
            androidx.core.content.ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == android.content.pm.PackageManager.PERMISSION_GRANTED
        )
    }
    var showSettingsDialog by remember { mutableStateOf(false) }

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                val granted = androidx.core.content.ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == android.content.pm.PackageManager.PERMISSION_GRANTED ||
                androidx.core.content.ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == android.content.pm.PackageManager.PERMISSION_GRANTED
                isPermissionGranted = granted
                if (granted) {
                    LocationService.updateLocation(context)
                    FirestoreRepository.refreshVenuesCache()
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                      permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        isPermissionGranted = granted
        if (granted) {
            LocationService.updateLocation(context)
            FirestoreRepository.refreshVenuesCache()
        } else {
            showSettingsDialog = true
        }
    }

    if (activeLegalDocument != null) {
        LegalDocumentScreen(
            document = activeLegalDocument!!,
            onBack = { activeLegalDocument = null }
        )
        return
    }

    if (showHelpDialog) {
        HelpCenterDialog(onDismiss = { showHelpDialog = false })
    }

    if (showPasswordChangeDialog) {
        PasswordChangeDialog(onDismiss = { showPasswordChangeDialog = false })
    }

    if (showSettingsDialog) {
        androidx.compose.material3.AlertDialog(
            onDismissRequest = { showSettingsDialog = false },
            title = { Text("Location Permission Required") },
            text = { Text("Near Campus needs location access to list and sort venues closest to you. Please enable location permission in App Settings.") },
            confirmButton = {
                androidx.compose.material3.TextButton(onClick = {
                    showSettingsDialog = false
                    val intent = android.content.Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                        data = android.net.Uri.fromParts("package", context.packageName, null)
                    }
                    context.startActivity(intent)
                }) {
                    Text("Open Settings")
                }
            },
            dismissButton = {
                androidx.compose.material3.TextButton(onClick = { showSettingsDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showAvatarSheet && isSignedIn) {
        ModalBottomSheet(
            onDismissRequest = { showAvatarSheet = false },
            sheetState = avatarSheetState,
            containerColor = Color.White
        ) {
            AvatarSelectionSheet(
                avatars = avatarOptions.ifEmpty { listOf(selectedAvatar) },
                selectedAvatarId = selectedAvatarId,
                onSelect = { avatar ->
                    selectedAvatarId = avatar.id
                    avatarMessage = null
                    FirestoreRepository.updateAvatarId(user?.uid, avatar.id) { success ->
                        avatarMessage = if (success) {
                            "Avatar updated."
                        } else {
                            "Could not update avatar."
                        }
                    }
                    showAvatarSheet = false
                }
            )
        }
    }

    LazyColumn(Modifier.fillMaxSize(), contentPadding = androidx.compose.foundation.layout.PaddingValues(20.dp), verticalArrangement = Arrangement.spacedBy(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        item { TopTitle("Near Campus") }
        item {
            Box(contentAlignment = Alignment.BottomEnd) {
                ProfileAvatarPreview(avatar = selectedAvatar, size = 128)
                if (isSignedIn) {
                    IconButton(
                        onClick = { showAvatarSheet = true },
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Ink)
                    ) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit avatar", tint = Color.White, modifier = Modifier.size(18.dp))
                    }
                }
            }
        }
        if (isSignedIn) {
            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(displayName, color = Ink, fontSize = 24.sp, fontWeight = FontWeight.SemiBold, fontFamily = FontFamily.Serif)
                    Text(email, color = Muted)
                    when (isStudentVerified) {
                        null -> StatusTag("Checking Status", tone = TagTone.Neutral)
                        true -> StatusTag("Verified Student", tone = TagTone.Promo, icon = Icons.Default.Verified)
                        false -> StatusTag("Unverified Student", tone = TagTone.Warning, icon = Icons.Default.Verified)
                    }
                }
            }
            if (avatarMessage != null) {
                item {
                    Text(
                        avatarMessage!!,
                        color = if (avatarMessage!!.contains("updated")) GoldText else Color.Red,
                        fontSize = 13.sp
                    )
                }
            }
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Border),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Verified, null, tint = if (isStudentVerified == true) GoldText else Color(0xFF8A4B00), modifier = Modifier.size(22.dp))
                            Spacer(Modifier.width(12.dp))
                            Column(Modifier.weight(1f)) {
                                Text("Student Verification", fontSize = 17.sp, fontWeight = FontWeight.Medium, color = Ink)
                                Text(
                                    text = when (isStudentVerified) {
                                        null -> "Checking your university verification status."
                                        true -> "You can write trusted student reviews."
                                        false -> "Verify here to unlock review writing."
                                    },
                                    color = Muted,
                                    fontSize = 12.sp
                                )
                            }
                        }
                        verificationMessage?.let {
                            Text(it, color = if (isStudentVerified == true) GoldText else Color.Red, fontSize = 13.sp)
                        }
                        if (isStudentVerified == false) {
                            Button(
                                onClick = {
                                    isVerifyingStudent = true
                                    verificationMessage = null
                                    FirestoreRepository.verifyStudentFromProfile(user?.uid) { success ->
                                        isVerifyingStudent = false
                                        if (success) {
                                            isStudentVerified = true
                                            verificationMessage = "Student verification completed."
                                        } else {
                                            verificationMessage = "Verification could not be completed. Please try again."
                                        }
                                    }
                                },
                                enabled = !isVerifyingStudent,
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(containerColor = Navy),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                if (isVerifyingStudent) {
                                    androidx.compose.material3.CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp))
                                } else {
                                    Text("Verify Student Status")
                                }
                            }
                        }
                    }
                }
            }
            item {
                SettingsGroup(
                    title = "ACCOUNT SETTINGS",
                    rows = listOf(Icons.Default.Lock to "Password Change"),
                    onRowClick = { label ->
                        if (label == "Password Change") {
                            showPasswordChangeDialog = true
                        }
                    }
                )
            }
            item {
                Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("PREFERENCES", Modifier.padding(horizontal = 16.dp), color = Muted, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, Border),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Notifications, null, tint = Color(0xFF43474E), modifier = Modifier.size(20.dp))
                                Spacer(Modifier.width(16.dp))
                                Column(Modifier.weight(1f)) {
                                    Text("Notifications", fontSize = 17.sp, fontWeight = FontWeight.Medium, color = Ink)
                                    Text("Choose which updates you want to receive.", color = Muted, fontSize = 12.sp)
                                }
                                if (isSavingNotifications) {
                                    androidx.compose.material3.CircularProgressIndicator(color = Navy, modifier = Modifier.size(20.dp))
                                }
                            }
                            NotificationPreferenceRow(
                                title = "General updates",
                                subtitle = "Important app and account notices",
                                checked = generalNotifications,
                                enabled = !isSavingNotifications,
                                onCheckedChange = { enabled ->
                                    saveNotificationPreferences(enabled, dealNotifications && enabled, reviewNotifications && enabled)
                                }
                            )
                            NotificationPreferenceRow(
                                title = "Student deals",
                                subtitle = "New campaigns and nearby discounts",
                                checked = dealNotifications,
                                enabled = generalNotifications && !isSavingNotifications,
                                onCheckedChange = { enabled ->
                                    saveNotificationPreferences(generalNotifications, enabled, reviewNotifications)
                                }
                            )
                            NotificationPreferenceRow(
                                title = "Review activity",
                                subtitle = "Review reminders and related updates",
                                checked = reviewNotifications,
                                enabled = generalNotifications && !isSavingNotifications,
                                onCheckedChange = { enabled ->
                                    saveNotificationPreferences(generalNotifications, dealNotifications, enabled)
                                }
                            )
                            notificationMessage?.let {
                                Text(it, color = if (it.contains("saved")) GoldText else Color.Red, fontSize = 13.sp)
                            }
                        }
                    }
                }
            }
            item {
                Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("PRIVACY & DATA", Modifier.padding(horizontal = 16.dp), color = Muted, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, Border),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.PrivacyTip, null, tint = Color(0xFF43474E), modifier = Modifier.size(20.dp))
                                Spacer(Modifier.width(16.dp))
                                Column(Modifier.weight(1f)) {
                                    Text("Privacy Controls", fontSize = 17.sp, fontWeight = FontWeight.Medium, color = Ink)
                                    Text("Manage basic data use preferences.", color = Muted, fontSize = 12.sp)
                                }
                                if (isSavingPrivacy) {
                                    androidx.compose.material3.CircularProgressIndicator(color = Navy, modifier = Modifier.size(20.dp))
                                }
                            }
                            NotificationPreferenceRow(
                                title = "Personalized recommendations",
                                subtitle = "Use activity to improve venue suggestions",
                                checked = personalizedRecommendations,
                                enabled = !isSavingPrivacy,
                                onCheckedChange = { enabled ->
                                    savePrivacyPreferences(enabled, analyticsEnabled)
                                }
                            )
                            NotificationPreferenceRow(
                                title = "Analytics",
                                subtitle = "Share usage data to improve Near Campus",
                                checked = analyticsEnabled,
                                enabled = !isSavingPrivacy,
                                onCheckedChange = { enabled ->
                                    savePrivacyPreferences(personalizedRecommendations, enabled)
                                }
                            )
                            privacyMessage?.let {
                                Text(it, color = if (it.contains("saved")) GoldText else Color.Red, fontSize = 13.sp)
                            }
                        }
                    }
                }
            }
        } else {
            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Browsing as Guest", color = Ink, fontSize = 24.sp, fontWeight = FontWeight.SemiBold, fontFamily = FontFamily.Serif)
                    Text("Log in or create an account to manage your profile, preferences, and student verification.", color = Muted, fontSize = 14.sp)
                }
            }
        }
        item {
            Card(
                onClick = {
                    if (!isPermissionGranted) {
                        launcher.launch(
                            arrayOf(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                        )
                    } else {
                        val intent = android.content.Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = android.net.Uri.fromParts("package", context.packageName, null)
                        }
                        context.startActivity(intent)
                    }
                },
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Border),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = if (isPermissionGranted) Navy else Color.Gray,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(Modifier.width(16.dp))
                    Column(Modifier.weight(1f)) {
                        Text("Location Access", fontSize = 17.sp, fontWeight = FontWeight.Medium, color = Ink)
                        Text(
                            text = if (isPermissionGranted) "Closest venues sorted automatically" else "Disabled. Tap to enable location sorting.",
                            color = Muted,
                            fontSize = 12.sp
                        )
                    }
                    if (isPermissionGranted) {
                        StatusTag("Enabled", tone = TagTone.Promo, variant = VenueChipVariant.Default)
                    } else {
                        Text("›", color = Muted, fontSize = 24.sp)
                    }
                }
            }
        }
        item {
            SettingsGroup(
                title = "SUPPORT & LEGAL",
                rows = listOf(
                    Icons.Default.Settings to "Help Center",
                    Icons.AutoMirrored.Filled.MenuBook to "Terms of Service",
                    Icons.Default.Security to "Privacy Policy"
                ),
                onRowClick = { label ->
                    when (label) {
                        "Help Center" -> showHelpDialog = true
                        "Terms of Service" -> activeLegalDocument = LegalDocument.Terms
                        "Privacy Policy" -> activeLegalDocument = LegalDocument.Privacy
                    }
                }
            )
        }
        item {
            if (isSignedIn) {
                Button(
                    onClick = {
                        AuthManager.signOut()
                        onLogout()
                    },
                    modifier = Modifier.fillMaxWidth().height(52.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFDAD6), contentColor = Color(0xFF93000A)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(Icons.AutoMirrored.Filled.Logout, null, Modifier.size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("LOG OUT", letterSpacing = 1.sp)
                }
            } else {
                Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(
                        onClick = onLogin,
                        modifier = Modifier.fillMaxWidth().height(52.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Navy),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("LOG IN", letterSpacing = 1.sp)
                    }
                    androidx.compose.material3.OutlinedButton(
                        onClick = onRegister,
                        modifier = Modifier.fillMaxWidth().height(52.dp),
                        border = BorderStroke(1.dp, Border),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("CREATE ACCOUNT", color = Ink, letterSpacing = 1.sp)
                    }
                }
            }
        }
    }
}

private const val DefaultProfileAvatarId = "avatar_1_afro_and_glasses"
private val FallbackProfileAvatar = UserAvatar(DefaultProfileAvatarId, "Afro And Glasses", "AA", listOf(Navy, Color(0xFF111827)))

private fun profileAvatarById(id: String, avatars: List<UserAvatar>): UserAvatar {
    return avatars.firstOrNull { it.id == id } ?: avatars.firstOrNull() ?: FallbackProfileAvatar
}

@Composable
private fun ProfileAvatarPreview(avatar: UserAvatar, size: Int) {
    val context = LocalContext.current
    val hasSvg = avatar.kind == "vector" && !avatar.svgMarkup.isNullOrBlank()
    val avatarModifier = Modifier
        .size(size.dp)
        .clip(RoundedCornerShape(12.dp))
        .let { modifier ->
            if (hasSvg) modifier else modifier.background(Brush.linearGradient(avatar.colors))
        }

    Box(
        avatarModifier,
        contentAlignment = Alignment.Center
    ) {
        if (hasSvg) {
            val request = remember(avatar.svgMarkup) {
                ImageRequest.Builder(context)
                    .data(avatar.svgMarkup.toByteArray())
                    .decoderFactory(SvgDecoder.Factory())
                    .crossfade(false)
                    .build()
            }
            AsyncImage(
                model = request,
                contentDescription = avatar.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        } else {
            Text(
                avatar.label,
                color = Color.White,
                fontSize = (size / 3).sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        }
    }
}

@Composable
private fun AvatarSelectionSheet(
    avatars: List<UserAvatar>,
    selectedAvatarId: String,
    onSelect: (UserAvatar) -> Unit
) {
    Column(
        Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Choose Avatar", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Ink)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxWidth().height(336.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            gridItems(avatars.take(9), key = { it.id }) { avatar ->
                AvatarOptionCard(
                    avatar = avatar,
                    selected = selectedAvatarId == avatar.id,
                    onSelect = { onSelect(avatar) }
                )
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun AvatarOptionCard(avatar: UserAvatar, selected: Boolean, onSelect: () -> Unit) {
    Card(
        onClick = onSelect,
        colors = CardDefaults.cardColors(containerColor = if (selected) Color(0xFFFFF7E0) else Color.White),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, if (selected) GoldText else Border),
        modifier = Modifier.fillMaxWidth().height(96.dp)
    ) {
        Box(Modifier.fillMaxSize().padding(8.dp), contentAlignment = Alignment.Center) {
            ProfileAvatarPreview(avatar = avatar, size = 76)
        }
    }
}

@Composable
private fun NotificationPreferenceRow(
    title: String,
    subtitle: String,
    checked: Boolean,
    enabled: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.weight(1f)) {
            Text(title, fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Ink)
            Text(subtitle, color = Muted, fontSize = 12.sp)
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled
        )
    }
}

@Composable
private fun VenueCardSkeleton() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth().height(240.dp)
    ) {
        Column {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(Color(0xFFF0F0F0))
            )
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Box(
                    Modifier
                        .fillMaxWidth(0.6f)
                        .height(18.dp)
                        .background(Color(0xFFF0F0F0), RoundedCornerShape(4.dp))
                )
                Box(
                    Modifier
                        .fillMaxWidth(0.3f)
                        .height(12.dp)
                        .background(Color(0xFFF0F0F0), RoundedCornerShape(4.dp))
                )
            }
        }
    }
}

@Composable
private fun SmallVenueCardSkeleton() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.size(width = 160.dp, height = 120.dp)
    ) {
        Column {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(Color(0xFFF0F0F0))
            )
            Column(Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Box(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .height(10.dp)
                        .background(Color(0xFFF0F0F0), RoundedCornerShape(2.dp))
                )
                Box(
                    Modifier
                        .fillMaxWidth(0.5f)
                        .height(8.dp)
                        .background(Color(0xFFF0F0F0), RoundedCornerShape(2.dp))
                )
            }
        }
    }
}

@Composable
private fun PasswordChangeDialog(onDismiss: () -> Unit) {
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var successMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(successMessage) {
        if (successMessage != null) {
            kotlinx.coroutines.delay(1500)
            onDismiss()
        }
    }

    androidx.compose.ui.window.Dialog(onDismissRequest = {
        if (!isLoading) {
            onDismiss()
        }
    }) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = Color.White,
            tonalElevation = 6.dp,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = Navy,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    "Change Password",
                    color = Ink,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Please enter and confirm your new password below.",
                    color = Muted,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )

                OutlinedTextField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("New Password") },
                    visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
                    enabled = !isLoading
                )

                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Confirm New Password") },
                    visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
                    enabled = !isLoading
                )

                if (errorMessage != null) {
                    Text(errorMessage!!, color = Color.Red, fontSize = 14.sp, textAlign = TextAlign.Center)
                }

                if (successMessage != null) {
                    Text(successMessage!!, color = GoldText, fontSize = 14.sp, textAlign = TextAlign.Center)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    androidx.compose.material3.OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f).height(48.dp),
                        enabled = !isLoading,
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, Border)
                    ) {
                        Text("Cancel", color = Ink)
                    }

                    Button(
                        onClick = {
                            if (newPassword.length < 6) {
                                errorMessage = "Password must be at least 6 characters."
                                return@Button
                            }
                            if (newPassword != confirmPassword) {
                                errorMessage = "Passwords do not match."
                                return@Button
                            }
                            isLoading = true
                            errorMessage = null
                            successMessage = null
                            AuthManager.changePassword(newPassword) { success, error ->
                                isLoading = false
                                if (success) {
                                    successMessage = "Password changed successfully."
                                    errorMessage = null
                                } else {
                                    errorMessage = error ?: "Failed to change password."
                                }
                            }
                        },
                        modifier = Modifier.weight(1f).height(48.dp),
                        enabled = !isLoading && newPassword.isNotEmpty() && confirmPassword.isNotEmpty(),
                        colors = ButtonDefaults.buttonColors(containerColor = Navy),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        if (isLoading) {
                            androidx.compose.material3.CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp))
                        } else {
                            Text("Save", fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}
