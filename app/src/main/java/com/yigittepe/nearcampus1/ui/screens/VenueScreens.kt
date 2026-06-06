package com.yigittepe.nearcampus1.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Verified
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.LaunchedEffect
import com.yigittepe.nearcampus1.data.FirestoreRepository
import com.yigittepe.nearcampus1.data.AuthManager
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import com.yigittepe.nearcampus1.ui.theme.Navy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yigittepe.nearcampus1.data.MockNearCampusRepository
import com.yigittepe.nearcampus1.model.Review
import com.yigittepe.nearcampus1.model.ReviewContext
import com.yigittepe.nearcampus1.model.Venue
import com.yigittepe.nearcampus1.model.MenuCategory
import com.yigittepe.nearcampus1.model.MenuItem
import com.yigittepe.nearcampus1.model.Discount
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import com.yigittepe.nearcampus1.ui.components.DetailSection
import com.yigittepe.nearcampus1.ui.components.optimizeImageUrl
import com.yigittepe.nearcampus1.ui.components.DiscountRow
import com.yigittepe.nearcampus1.ui.components.HeaderBar
import com.yigittepe.nearcampus1.ui.components.MenuCategorySelector
import com.yigittepe.nearcampus1.ui.components.MenuRow
import com.yigittepe.nearcampus1.ui.components.RatingPill
import com.yigittepe.nearcampus1.ui.components.ReviewRow
import com.yigittepe.nearcampus1.ui.components.VenueHero
import com.yigittepe.nearcampus1.ui.theme.Border
import com.yigittepe.nearcampus1.ui.theme.Canvas
import com.yigittepe.nearcampus1.ui.theme.GoldText
import com.yigittepe.nearcampus1.ui.theme.Ink
import com.yigittepe.nearcampus1.ui.theme.Muted
import kotlinx.coroutines.launch

@Composable
internal fun VenueDetailScreen(
    venue: Venue,
    onBack: () -> Unit,
    onReviews: () -> Unit,
    onDiscount: () -> Unit,
    onMenuItemSelected: (MenuItem) -> Unit
) {
    var menuCategories by remember(venue.id) { mutableStateOf<List<MenuCategory>>(emptyList()) }
    var discounts by remember(venue.id) { mutableStateOf<List<Discount>>(emptyList()) }
    var reviews by remember(venue.id) { mutableStateOf<List<Review>?>(null) }
    val isFavorite = AuthManager.isUserSignedIn() && (FirestoreRepository.favoriteStates[venue.id] ?: venue.favorite)
    val context = LocalContext.current

    val calculatedRating by remember(reviews, venue.rating) {
        derivedStateOf {
            val rList = reviews
            if (rList != null) {
                if (rList.isNotEmpty()) {
                    val average = rList.map { it.rating }.average()
                    Math.round(average * 10.0) / 10.0
                } else {
                    venue.rating
                }
            } else {
                null
            }
        }
    }

    LaunchedEffect(venue.id) {
        menuCategories = emptyList()
        discounts = emptyList()
        reviews = null
        FirestoreRepository.fetchMenuCategories(venue.id) { menuCategories = it }
        FirestoreRepository.fetchDiscounts(venue.id) { discounts = it }
        FirestoreRepository.fetchReviews(venue.id) { reviews = it }
    }

    val listState = rememberLazyListState()
    LaunchedEffect(venue.id) {
        listState.scrollToItem(0)
    }
    val coroutineScope = rememberCoroutineScope()
    val menuStartIndex = 4
    val showStickyButton by remember(listState, menuCategories) {
        derivedStateOf {
            menuCategories.isNotEmpty() && listState.firstVisibleItemIndex > 3
        }
    }
    val selectedCategory by remember(listState, menuCategories) {
        derivedStateOf {
            val categoryItems = listState.layoutInfo.visibleItemsInfo
                .filter { item ->
                    item.index in menuStartIndex until menuStartIndex + menuCategories.size
                }
            val activeItem = categoryItems
                .lastOrNull { item -> item.offset <= 0 }
                ?: categoryItems.firstOrNull()

            activeItem?.let { menuCategories[it.index - menuStartIndex].name }
                ?: menuCategories.firstOrNull()?.name.orEmpty()
        }
    }

    // Shared scroll handler: smooth animated scroll to a category
    val scrollToCategory: (String) -> Unit = { categoryName ->
        val categoryIndex = menuCategories.indexOfFirst { it.name == categoryName }
        if (categoryIndex >= 0) {
            coroutineScope.launch {
                val targetIndex = menuStartIndex + categoryIndex
                listState.animateScrollToItem(targetIndex)
            }
        }
    }

    Column(Modifier.fillMaxSize()) {
        HeaderBar("Venue Detail", onBack)
        Box(Modifier.fillMaxSize()) {
            LazyColumn(Modifier.fillMaxSize(), state = listState, verticalArrangement = Arrangement.spacedBy(18.dp)) {
                item {
                    VenueHero(venue, Modifier.fillMaxWidth().height(260.dp))
                }
                item {
                    Column(Modifier.padding(horizontal = 20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Text(venue.name, Modifier.weight(1f), fontSize = 26.sp, fontWeight = FontWeight.Bold)
                            if (reviews == null) {
                                Box(
                                    Modifier
                                        .size(width = 110.dp, height = 36.dp)
                                        .clip(RoundedCornerShape(18.dp))
                                        .background(Color(0xFFF0F0F0))
                                )
                            } else {
                                RatingPill(rating = calculatedRating, label = "${reviews!!.size} reviews", onClick = onReviews)
                            }
                        }
                        Text("${venue.category} • ${venue.distanceText} • ${if (venue.openNow) "Open now" else "Closed"}", color = Muted)
                        Text(venue.address, color = Muted)
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(
                                onClick = {
                                    if (!AuthManager.isUserSignedIn()) {
                                        AuthManager.onRequireAuth?.invoke()
                                    } else {
                                        val nextFavorite = !isFavorite
                                        FirestoreRepository.toggleFavorite(venue.id, nextFavorite) { success ->
                                            if (success) {
                                                android.widget.Toast.makeText(
                                                    context,
                                                    if (nextFavorite) "${venue.name} is added to your favorites" else "${venue.name} is no longer your favorite",
                                                    android.widget.Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                },
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Icon(if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder, null)
                                Spacer(Modifier.width(6.dp))
                                Text("Favorite")
                            }
                            if (!venue.phone.isNullOrBlank()) {
                                OutlinedButton(
                                    onClick = {
                                        val intent = android.content.Intent(android.content.Intent.ACTION_DIAL).apply {
                                            data = android.net.Uri.parse("tel:${venue.phone}")
                                        }
                                        context.startActivity(intent)
                                    },
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Icon(Icons.Default.Call, null)
                                    Spacer(Modifier.width(6.dp))
                                    Text("Call")
                                }
                            }
                        }
                    }
                }
                if (discounts.isNotEmpty()) {
                    item { DetailSection("Today's Deals") { discounts.forEach { DiscountRow(it, onDiscount) } } }
                }
                if (menuCategories.isNotEmpty()) {
                    item {
                        MenuCategorySelector(
                            categories = menuCategories,
                            selectedCategory = selectedCategory,
                            onCategorySelected = scrollToCategory
                        )
                    }
                }
                menuCategories.forEach { category ->
                    item {
                        DetailSection(category.name) {
                            category.products.forEach { product ->
                                MenuRow(product, onClick = { onMenuItemSelected(product) })
                            }
                        }
                    }
                }
            }

            androidx.compose.animation.AnimatedVisibility(
                visible = showStickyButton,
                enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 }),
                exit = fadeOut() + slideOutVertically(targetOffsetY = { it / 2 }),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 24.dp, bottom = 24.dp)
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(3)
                        }
                    },
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Ink,
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 6.dp,
                        pressedElevation = 8.dp
                    ),
                    modifier = Modifier.size(48.dp),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Go up to categories",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun VerificationRequiredDialog(
    onDismiss: () -> Unit,
    onOpenProfile: () -> Unit
) {
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
                    imageVector = Icons.Default.Verified,
                    contentDescription = null,
                    tint = GoldText,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    "Verification Required",
                    color = Ink,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Only verified students can write reviews. Complete verification from your Profile to continue.",
                    color = Muted,
                    fontSize = 14.sp,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    lineHeight = 20.sp
                )
                Spacer(Modifier.height(8.dp))
                Button(
                    onClick = {
                        onDismiss()
                        onOpenProfile()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Navy),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text("Open Profile", fontWeight = FontWeight.Bold, color = Color.White)
                }
                OutlinedButton(
                    onClick = onDismiss,
                    border = BorderStroke(1.dp, Border),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text("Not Now", color = Ink, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
internal fun WriteReviewButton(
    onWriteReview: () -> Unit,
    onOpenProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isStudentVerified by remember { mutableStateOf<Boolean?>(null) }
    var showVerificationDialog by remember { mutableStateOf(false) }

    LaunchedEffect(AuthManager.getCurrentUser()?.uid) {
        FirestoreRepository.fetchStudentVerificationStatus(AuthManager.getCurrentUser()?.uid) {
            isStudentVerified = it
        }
    }

    if (showVerificationDialog) {
        VerificationRequiredDialog(
            onDismiss = { showVerificationDialog = false },
            onOpenProfile = onOpenProfile
        )
    }

    Button(
        onClick = {
            if (!AuthManager.isUserSignedIn()) {
                AuthManager.onRequireAuth?.invoke()
            } else if (isStudentVerified == true) {
                onWriteReview()
            } else {
                showVerificationDialog = true
            }
        },
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Icon(Icons.Default.Star, null, Modifier.size(16.dp))
        Spacer(Modifier.width(6.dp))
        Text("Write Review", fontSize = 14.sp)
    }
}

@Composable
internal fun ReviewListScreen(
    reviewContext: ReviewContext,
    onBack: () -> Unit,
    onWriteReview: () -> Unit,
    onOpenProfile: () -> Unit
) {
    var reviews by remember { mutableStateOf<List<Review>?>(null) }
    LaunchedEffect(reviewContext) {
        when (reviewContext) {
            is ReviewContext.VenueReview -> {
                FirestoreRepository.fetchReviews(reviewContext.venue.id) { reviews = it }
            }
            is ReviewContext.ItemReview -> {
                FirestoreRepository.fetchItemReviews(
                    reviewContext.venueId,
                    reviewContext.item.itemId
                ) { reviews = it }
            }
        }
    }
    val averageRating = remember(reviews) {
        val rList = reviews
        if (rList != null && rList.isNotEmpty()) {
            rList.map { it.rating }.average()
        } else {
            0.0
        }
    }
    val ratingCounts = remember(reviews) {
        val rList = reviews
        if (rList != null) {
            (1..5).associateWith { star -> rList.count { it.rating == star } }
        } else {
            (1..5).associateWith { 0 }
        }
    }
    val maxCount = ratingCounts.values.maxOrNull()?.coerceAtLeast(1) ?: 1

    Column(Modifier.fillMaxSize()) {
        HeaderBar("Reviews", onBack)
        LazyColumn(
            Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // ── Rating overview card ──
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(Modifier.fillMaxWidth().padding(20.dp)) {
                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            // Left: big number + stars
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                if (reviews == null) {
                                    Box(
                                        Modifier
                                            .size(width = 64.dp, height = 48.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(Color(0xFFE0E0E0))
                                    )
                                    Spacer(Modifier.height(8.dp))
                                    Box(
                                        Modifier
                                            .size(width = 90.dp, height = 18.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(Color(0xFFE0E0E0))
                                    )
                                } else {
                                    Text(
                                        String.format("%.1f", averageRating),
                                        fontSize = 48.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Ink
                                    )
                                    Row {
                                        (1..5).forEach { star ->
                                            Icon(
                                                Icons.Default.Star, null,
                                                Modifier.size(18.dp),
                                                tint = if (star <= averageRating.toInt()) Color(0xFFFFB000) else Border
                                            )
                                        }
                                    }
                                    Spacer(Modifier.height(4.dp))
                                    Text(
                                        "${reviews!!.size} reviews",
                                        color = Muted,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }
                            Spacer(Modifier.width(24.dp))
                            // Right: distribution bars
                            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                (5 downTo 1).forEach { star ->
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text("$star", fontSize = 13.sp, color = Muted, fontWeight = FontWeight.Medium)
                                        Spacer(Modifier.width(6.dp))
                                        Box(
                                            Modifier
                                                .weight(1f)
                                                .height(8.dp)
                                                .clip(androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
                                                .background(Color(0xFFEEEEEE))
                                        ) {
                                            if (reviews != null) {
                                                val fraction = (ratingCounts[star] ?: 0).toFloat() / maxCount.toFloat()
                                                Box(
                                                    Modifier
                                                        .fillMaxWidth(fraction)
                                                        .height(8.dp)
                                                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
                                                        .background(Color(0xFFFFB000))
                                                )
                                            }
                                        }
                                        Spacer(Modifier.width(6.dp))
                                        Text(
                                            if (reviews == null) "-" else "${ratingCounts[star] ?: 0}",
                                            fontSize = 12.sp,
                                            color = Muted,
                                            modifier = Modifier.width(16.dp)
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                        androidx.compose.material3.HorizontalDivider(color = Border)
                        Spacer(Modifier.height(12.dp))
                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Column(Modifier.weight(1f)) {
                                Text(reviewContext.subjectName, color = Ink, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                                Text(reviewContext.subjectSubtitle, color = Muted, fontSize = 12.sp)
                            }
                            WriteReviewButton(
                                onWriteReview = onWriteReview,
                                onOpenProfile = onOpenProfile
                            )
                        }
                    }
                }
            }

            // ── Sort / filter label ──
            item {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("All Reviews", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Ink)
                    Text("Most recent", color = Muted, fontSize = 13.sp)
                }
            }

            // ── Individual review cards ──
            if (reviews == null) {
                items(3) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp),
                        elevation = CardDefaults.cardElevation(1.dp)
                    ) {
                        Column(Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    Modifier
                                        .size(36.dp)
                                        .clip(androidx.compose.foundation.shape.CircleShape)
                                        .background(Color(0xFFE0E0E0))
                                )
                                Spacer(Modifier.width(12.dp))
                                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                    Box(
                                        Modifier
                                            .size(width = 80.dp, height = 14.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(Color(0xFFE0E0E0))
                                    )
                                    Box(
                                        Modifier
                                            .size(width = 40.dp, height = 10.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(Color(0xFFE0E0E0))
                                    )
                                }
                            }
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .height(48.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFFF5F5F5))
                            )
                        }
                    }
                }
            } else {
                items(reviews!!) { review ->
                    ReviewCard(review)
                }
            }

            // ── Bottom spacer for safe area ──
            item { Spacer(Modifier.height(20.dp)) }
        }
    }
}

@Composable
private fun ReviewCard(review: Review) {
    val avatarColors = listOf(
        Color(0xFF1A365D), Color(0xFF2D6A4F), Color(0xFF6C3483),
        Color(0xFFC0392B), Color(0xFF2E86C1), Color(0xFF239B56),
        Color(0xFFD68910), Color(0xFF5B2C6F)
    )
    val avatarColor = avatarColors[review.author.hashCode().mod(avatarColors.size).let { if (it < 0) it + avatarColors.size else it }]
    // Simulated relative dates
    val dateLabels = listOf("2 days ago", "1 week ago", "2 weeks ago", "1 month ago", "3 months ago", "5 months ago", "6 months ago", "1 year ago")
    val dateLabel = dateLabels[review.author.hashCode().mod(dateLabels.size).let { if (it < 0) it + dateLabels.size else it }]

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            // Header: avatar + name + date + stars
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
                // Avatar circle
                Box(
                    Modifier
                        .size(40.dp)
                        .clip(androidx.compose.foundation.shape.CircleShape)
                        .background(avatarColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        review.author.first().uppercase(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
                Spacer(Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Text(review.author, fontWeight = FontWeight.SemiBold, fontSize = 15.sp, color = Ink)
                    Text(dateLabel, color = Muted, fontSize = 12.sp)
                }
            }
            // Star rating row
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                (1..5).forEach { star ->
                    Icon(
                        Icons.Default.Star, null,
                        Modifier.size(16.dp),
                        tint = if (star <= review.rating) Color(0xFFFFB000) else Border
                    )
                }
            }
            // Title
            Text(review.title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Ink)
            // Body
            Text(review.body, color = Color(0xFF43474E), fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}

@Composable
internal fun ReviewScreen(reviewContext: ReviewContext, onBack: () -> Unit) {
    var rating by remember { mutableIntStateOf(4) }
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    var isSubmitting by remember { mutableStateOf(false) }
    var isStudentVerified by remember { mutableStateOf<Boolean?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        FirestoreRepository.fetchStudentVerificationStatus(AuthManager.getCurrentUser()?.uid) {
            isStudentVerified = it
        }
    }
 
    Column(Modifier.fillMaxSize()) {
        HeaderBar("Reviews", onBack)
        LazyColumn(Modifier.fillMaxSize(), contentPadding = androidx.compose.foundation.layout.PaddingValues(bottom = 24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                Column(Modifier.padding(horizontal = 20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    Text("Write Review", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text(reviewContext.subjectName, color = Muted, fontSize = 14.sp)
                    when (isStudentVerified) {
                        null -> Text("Checking student verification...", color = Muted, fontSize = 14.sp)
                        false -> Text("Only verified students can submit reviews.", color = Muted, fontSize = 14.sp)
                        true -> Text("Your verified student status is active.", color = Muted, fontSize = 14.sp)
                    }
                    Row {
                        (1..5).forEach {
                            Icon(
                                Icons.Default.Star,
                                null,
                                Modifier.size(34.dp).clickable { if (!isSubmitting) rating = it },
                                tint = if (it <= rating) Color(0xFFFFB000) else Border
                            )
                        }
                    }
                    OutlinedTextField(title, { title = it.take(80) }, Modifier.fillMaxWidth(), label = { Text("Review title") }, enabled = !isSubmitting)
                    OutlinedTextField(body, { body = it.take(1000) }, Modifier.fillMaxWidth().height(140.dp), label = { Text("Review content") }, enabled = !isSubmitting)
                    if (errorMessage != null) {
                        Text(errorMessage!!, color = Color.Red, fontSize = 14.sp)
                    }
                    Button(
                        onClick = {
                            if (isStudentVerified != true) {
                                errorMessage = "Only verified students can submit reviews."
                                return@Button
                            }

                            isSubmitting = true
                            errorMessage = null
                            val author = AuthManager.getCurrentUser()?.displayName ?: "Anonymous User"
                            val authorUid = AuthManager.getCurrentUser()?.uid
                            val review = Review(title, author, rating, body)
                            val onComplete: (Boolean) -> Unit = { success ->
                                isSubmitting = false
                                if (success) {
                                    onBack()
                                } else {
                                    errorMessage = "Review could not be submitted. Please confirm your student verification."
                                }
                            }
                            when (reviewContext) {
                                is ReviewContext.VenueReview -> {
                                    FirestoreRepository.submitReview(
                                        reviewContext.venue.id,
                                        review,
                                        authorUid,
                                        onComplete
                                    )
                                }
                                is ReviewContext.ItemReview -> {
                                    FirestoreRepository.submitItemReview(
                                        reviewContext.venueId,
                                        reviewContext.item.itemId,
                                        review,
                                        authorUid,
                                        onComplete
                                    )
                                }
                            }
                        },
                        enabled = rating > 0 && title.isNotBlank() && body.isNotBlank() && isStudentVerified == true && !isSubmitting,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (isSubmitting) {
                            androidx.compose.material3.CircularProgressIndicator(color = Color.White, modifier = Modifier.size(24.dp))
                        } else {
                            Text("Submit Review")
                        }
                    }
                }
            }
        }
    }
}

@Composable
internal fun DiscountDetailScreen(venue: Venue, onBack: () -> Unit) {
    val discount = MockNearCampusRepository.discounts(venue.id).first()
    Column(Modifier.fillMaxSize()) {
        HeaderBar("Discount Detail", onBack)
        Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Icon(Icons.Default.LocalOffer, null, Modifier.size(48.dp), tint = GoldText)
            Text(discount.title, fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Text(discount.value, fontSize = 36.sp, color = Ink, fontWeight = FontWeight.Black)
            Text("Venue: ${venue.name}", fontWeight = FontWeight.SemiBold)
            Text(discount.terms, color = Muted)
            Text(discount.expires, color = GoldText)
            Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) { Text("View Venue") }
        }
    }
}

@Composable
internal fun MenuItemDetailScreen(
    venueId: String,
    item: MenuItem,
    onBack: () -> Unit,
    onReviews: () -> Unit,
    onWriteReview: () -> Unit,
    onOpenProfile: () -> Unit
) {
    var reviews by remember(item.itemId) { mutableStateOf<List<Review>?>(null) }

    LaunchedEffect(venueId, item.itemId) {
        FirestoreRepository.fetchItemReviews(venueId, item.itemId) { reviews = it }
    }

    val calculatedRating by remember(reviews) {
        derivedStateOf {
            when (val rList = reviews) {
                null -> null
                else -> if (rList.isNotEmpty()) {
                    val average = rList.map { it.rating }.average()
                    Math.round(average * 10.0) / 10.0
                } else {
                    0.0
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Canvas)
    ) {
        HeaderBar("Item Detail", onBack)
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Hero Image Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color(0xFFF0F0F0))
            ) {
                if (!item.image.isNullOrEmpty()) {
                    AsyncImage(
                        model = optimizeImageUrl(item.image),
                        contentDescription = item.name,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(androidx.compose.ui.graphics.Brush.linearGradient(
                                listOf(Color(0xFFBACAC5), Color(0xFFEFF4EE))
                            )),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Restaurant,
                            contentDescription = null,
                            tint = Color.White.copy(alpha = 0.8f),
                            modifier = Modifier.size(96.dp)
                        )
                    }
                }
            }

            // Info Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Category & Badge
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Navy.copy(alpha = 0.08f),
                        contentColor = Navy
                    ) {
                        Text(
                            text = item.category.uppercase(),
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    }
                    
                    Text(
                        text = item.priceText,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Ink
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.name,
                        modifier = Modifier.weight(1f),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Ink,
                        lineHeight = 34.sp
                    )
                    if (reviews == null) {
                        Box(
                            Modifier
                                .size(width = 110.dp, height = 36.dp)
                                .clip(RoundedCornerShape(18.dp))
                                .background(Color(0xFFF0F0F0))
                        )
                    } else {
                        RatingPill(
                            rating = calculatedRating,
                            label = "${reviews!!.size} reviews",
                            onClick = onReviews
                        )
                    }
                }

                androidx.compose.material3.HorizontalDivider(color = Border)

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        Text("Student reviews", color = Ink, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                        Text(
                            if (reviews == null) "Loading reviews..." else "${reviews!!.size} verified reviews",
                            color = Muted,
                            fontSize = 12.sp
                        )
                    }
                    WriteReviewButton(
                        onWriteReview = onWriteReview,
                        onOpenProfile = onOpenProfile
                    )
                }

                androidx.compose.material3.HorizontalDivider(color = Border)

                // Details / Description
                if (item.details.isNotBlank()) {
                    Text(
                        text = item.details,
                        fontSize = 16.sp,
                        color = Ink,
                        lineHeight = 22.sp
                    )
                } else {
                    Text(
                        text = "No description available for this item.",
                        fontSize = 16.sp,
                        color = Muted,
                        lineHeight = 22.sp
                    )
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Button(
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Back to Menu", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
