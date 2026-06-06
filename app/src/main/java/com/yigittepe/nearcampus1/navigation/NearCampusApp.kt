package com.yigittepe.nearcampus1.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yigittepe.nearcampus1.data.AuthManager
import com.yigittepe.nearcampus1.data.FirestoreRepository
import com.yigittepe.nearcampus1.data.MockNearCampusRepository
import com.yigittepe.nearcampus1.model.BottomTab
import com.yigittepe.nearcampus1.model.Screen
import com.yigittepe.nearcampus1.ui.screens.DiscountDetailScreen
import com.yigittepe.nearcampus1.ui.screens.FavoritesScreen
import com.yigittepe.nearcampus1.ui.screens.HomeScreen
import com.yigittepe.nearcampus1.ui.screens.LoginScreen
import com.yigittepe.nearcampus1.ui.screens.ProfileScreen
import com.yigittepe.nearcampus1.ui.screens.RegisterScreen
import com.yigittepe.nearcampus1.ui.screens.ReviewListScreen
import com.yigittepe.nearcampus1.ui.screens.ReviewScreen
import com.yigittepe.nearcampus1.ui.screens.SearchScreen
import com.yigittepe.nearcampus1.ui.screens.SplashScreen
import com.yigittepe.nearcampus1.model.MenuItem
import com.yigittepe.nearcampus1.ui.screens.VenueDetailScreen
import com.yigittepe.nearcampus1.ui.screens.WelcomeScreen
import com.yigittepe.nearcampus1.ui.screens.MenuItemDetailScreen
import com.yigittepe.nearcampus1.ui.theme.Canvas
import com.yigittepe.nearcampus1.ui.theme.Ink
import com.yigittepe.nearcampus1.ui.theme.Navy
import com.yigittepe.nearcampus1.ui.theme.Border
import com.yigittepe.nearcampus1.ui.theme.Muted
import com.yigittepe.nearcampus1.ui.theme.NearCampusTheme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton

import com.yigittepe.nearcampus1.model.ReviewContext
import com.yigittepe.nearcampus1.model.Venue
import androidx.compose.runtime.LaunchedEffect
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import android.Manifest
import com.yigittepe.nearcampus1.data.LocationService
import androidx.compose.ui.platform.LocalContext

private val bottomTabs = listOf(
    BottomTab("Home", Icons.Default.Home, Screen.Home),
    BottomTab("Search", Icons.Default.Search, Screen.Search),
    BottomTab("Favorites", Icons.Default.FavoriteBorder, Screen.Favorites),
    BottomTab("Profile", Icons.Default.Person, Screen.Profile)
)

@Composable
internal fun NearCampusApp() {
    NearCampusTheme {
        var isAppInitialized by remember { mutableStateOf(false) }
        val initialScreen = if (AuthManager.isUserSignedIn()) Screen.Home else Screen.Welcome
        var navStack by remember { mutableStateOf(listOf(initialScreen)) }
        var screen by remember { mutableStateOf(initialScreen) }
        var selectedVenueId by remember { mutableStateOf(MockNearCampusRepository.venues.first().id) }
        var selectedVenue by remember { mutableStateOf<Venue?>(null) }
        var selectedMenuItem by remember { mutableStateOf<MenuItem?>(null) }
        var reviewContext by remember { mutableStateOf<ReviewContext?>(null) }
        var authReturnScreen by remember { mutableStateOf<Screen>(Screen.Home) }

        val context = LocalContext.current
        val locationPermissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestMultiplePermissions()
        ) { _ ->
            LocationService.updateLocation(context)
            FirestoreRepository.prefetchAvatars {}
            FirestoreRepository.prefetchVenues {
                isAppInitialized = true
            }
        }

        LaunchedEffect(Unit) {
            locationPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }

        LaunchedEffect(selectedVenueId) {
            if (selectedVenue?.id != selectedVenueId) {
                selectedVenue = FirestoreRepository.getCachedVenue(selectedVenueId)
            }
            FirestoreRepository.fetchVenues { venues ->
                selectedVenue = venues.firstOrNull { it.id == selectedVenueId }
            }
        }

        val navigate: (Screen) -> Unit = { next ->
            if (screen != next || navStack.lastOrNull() != next) {
                navStack = navStack + next
                screen = next
            }
        }
        val goBack: () -> Unit = {
            if (navStack.size > 1) {
                navStack = navStack.dropLast(1)
                screen = navStack.last()
            }
        }
        val backToVenueDetail: () -> Unit = {
            val detailIndex = navStack.lastIndexOf(Screen.Detail)
            if (detailIndex >= 0) {
                navStack = navStack.take(detailIndex + 1)
                screen = Screen.Detail
            } else {
                goBack()
            }
        }
        val openVenue: (String) -> Unit = { venueId ->
            selectedVenueId = venueId
            selectedVenue = FirestoreRepository.getCachedVenue(venueId)
            selectedMenuItem = null
            FirestoreRepository.addRecentlyViewed(venueId)
            navigate(Screen.Detail)
        }

        val navigateToLogin: () -> Unit = {
            authReturnScreen = screen
            screen = Screen.Login
        }
        val navigateToRegister: () -> Unit = {
            authReturnScreen = screen
            screen = Screen.Register
        }

        var showAuthDialog by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            AuthManager.onRequireAuth = {
                showAuthDialog = true
            }
        }

        if (showAuthDialog) {
            androidx.compose.ui.window.Dialog(onDismissRequest = { showAuthDialog = false }) {
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
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = Color(0xFFE91E63),
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            "Login Required",
                            color = Ink,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "Join Near Campus to add venues to your favorites and view curated student deals!",
                            color = Muted,
                            fontSize = 14.sp,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                            lineHeight = 20.sp
                        )
                        Spacer(Modifier.height(8.dp))
                        Button(
                            onClick = {
                                showAuthDialog = false
                                navigateToLogin()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Navy),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth().height(48.dp)
                        ) {
                            Text("Log In", fontWeight = FontWeight.Bold, color = Color.White)
                        }
                        OutlinedButton(
                            onClick = {
                                showAuthDialog = false
                                navigateToRegister()
                            },
                            border = BorderStroke(1.dp, Border),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth().height(48.dp)
                        ) {
                            Text("Create Account", color = Ink, fontWeight = FontWeight.Bold)
                        }
                        androidx.compose.material3.TextButton(
                            onClick = { showAuthDialog = false },
                            modifier = Modifier.fillMaxWidth().height(40.dp)
                        ) {
                            Text("Maybe Later", color = Muted, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
        }

        Surface(Modifier.fillMaxSize(), color = Canvas) {
            if (!isAppInitialized) {
                SplashScreen()
            } else {
                when (screen) {
                    Screen.Welcome -> WelcomeScreen(
                        onLogin = { navigateToLogin() },
                        onRegister = { navigateToRegister() },
                        onGuest = { navigate(Screen.Home) }
                    )
                    Screen.Login -> LoginScreen(
                        onBack = {
                            val dest = if (authReturnScreen == Screen.Login || authReturnScreen == Screen.Register) Screen.Home else authReturnScreen
                            navigate(dest)
                        },
                        onSuccess = { navigate(Screen.Home) }
                    )
                    Screen.Register -> RegisterScreen(
                        onBack = {
                            val dest = if (authReturnScreen == Screen.Login || authReturnScreen == Screen.Register) Screen.Home else authReturnScreen
                            navigate(dest)
                        },
                        onSuccess = { navigate(Screen.Home) }
                    )
                    Screen.Detail -> {
                        val venue = selectedVenue?.takeIf { it.id == selectedVenueId }
                        if (venue != null) {
                            VenueDetailScreen(
                                venue = venue,
                                onBack = goBack,
                                onReviews = {
                                    reviewContext = ReviewContext.VenueReview(venue)
                                    navigate(Screen.Reviews)
                                },
                                onDiscount = { navigate(Screen.Discount) },
                                onMenuItemSelected = {
                                    selectedMenuItem = it
                                    navigate(Screen.MenuItemDetail)
                                }
                            )
                        }
                    }
                    Screen.Reviews -> {
                        reviewContext?.let { context ->
                            ReviewListScreen(
                                reviewContext = context,
                                onBack = goBack,
                                onWriteReview = { navigate(Screen.Review) },
                                onOpenProfile = { navigate(Screen.Profile) }
                            )
                        }
                    }
                    Screen.Review -> {
                        reviewContext?.let { context ->
                            ReviewScreen(
                                reviewContext = context,
                                onBack = goBack
                            )
                        }
                    }
                    Screen.Discount -> {
                        selectedVenue?.takeIf { it.id == selectedVenueId }?.let { venue ->
                            DiscountDetailScreen(venue, onBack = goBack)
                        }
                    }
                    Screen.MenuItemDetail -> {
                        selectedMenuItem?.let { item ->
                            MenuItemDetailScreen(
                                venueId = selectedVenueId,
                                item = item,
                                onBack = backToVenueDetail,
                                onReviews = {
                                    reviewContext = ReviewContext.ItemReview(selectedVenueId, item)
                                    navigate(Screen.Reviews)
                                },
                                onWriteReview = {
                                    reviewContext = ReviewContext.ItemReview(selectedVenueId, item)
                                    navigate(Screen.Review)
                                },
                                onOpenProfile = { navigate(Screen.Profile) }
                            )
                        }
                    }
                    else -> MainShell(screen, navigate, openVenue, navigateToLogin, navigateToRegister)
                }
            }
        }
    }
}

@Composable
private fun MainShell(
    screen: Screen,
    navigate: (Screen) -> Unit,
    openVenue: (String) -> Unit,
    navigateToLogin: () -> Unit,
    navigateToRegister: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = { MainTopBar() },
        bottomBar = { BottomNav(screen, navigate) },
        containerColor = Canvas
    ) { padding ->
        Box(Modifier.padding(padding)) {
            when (screen) {
                Screen.Home -> HomeScreen(openVenue, { query ->
                    searchQuery = query
                    navigate(Screen.Search)
                })
                Screen.Search -> SearchScreen(openVenue, initialQuery = searchQuery, onQueryChange = { searchQuery = it })
                Screen.Favorites -> FavoritesScreen(openVenue)
                Screen.Profile -> ProfileScreen(
                    onLogout = { navigate(Screen.Welcome) },
                    onLogin = navigateToLogin,
                    onRegister = navigateToRegister
                )
                else -> HomeScreen(openVenue, { query ->
                    searchQuery = query
                    navigate(Screen.Search)
                })
            }
        }
    }
}

@Composable
private fun MainTopBar() {
    Surface(color = Color.White, shadowElevation = 4.dp) {
        Row(
            Modifier.fillMaxWidth().statusBarsPadding().padding(horizontal = 20.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Near Campus",
                color = Ink,
                fontSize = 36.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Serif,
                maxLines = 1
            )
        }
    }
}

@Composable
private fun BottomNav(screen: Screen, navigate: (Screen) -> Unit) {
    Surface(shadowElevation = 8.dp, color = Color.White) {
        Row(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            bottomTabs.forEach { tab ->
                val selected = screen == tab.screen
                Column(
                    Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .clickable {
                            if (tab.screen == Screen.Favorites && !AuthManager.isUserSignedIn()) {
                                AuthManager.onRequireAuth?.invoke()
                            } else {
                                navigate(tab.screen)
                            }
                        }
                        .background(if (selected) Navy else Color.Transparent)
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(tab.icon, tab.label, tint = if (selected) Color(0xFF86A0CD) else Color(0xFF43474E), modifier = Modifier.size(20.dp))
                    Text(tab.label, color = if (selected) Color(0xFF86A0CD) else Color(0xFF43474E), fontSize = 11.sp, fontWeight = FontWeight.Normal)
                }
            }
        }
    }
}
