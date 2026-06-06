package com.yigittepe.nearcampus1.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.yigittepe.nearcampus1.model.Venue
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.BoundingBox
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

@Composable
internal fun VenueMapView(
    venues: List<Venue>,
    onVenueClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val mapView = rememberMapViewWithLifecycle()

    LaunchedEffect(venues) {
        if (venues.isEmpty()) return@LaunchedEffect

        mapView.post {
            if (venues.size == 1) {
                val venue = venues.first()
                mapView.controller.setZoom(16.0)
                mapView.controller.setCenter(GeoPoint(venue.latitude, venue.longitude))
            } else {
                val points = venues.map { GeoPoint(it.latitude, it.longitude) }
                val bounds = BoundingBox.fromGeoPoints(points)
                mapView.zoomToBoundingBox(bounds, true, 120)
            }
        }
    }

    AndroidView(
        modifier = modifier
            .fillMaxWidth()
            .height(420.dp)
            .clip(RoundedCornerShape(16.dp)),
        factory = { mapView },
        update = { view ->
            view.overlays.removeAll { it is Marker }
            venues.forEach { venue ->
                val marker = Marker(view).apply {
                    position = GeoPoint(venue.latitude, venue.longitude)
                    title = venue.name
                    snippet = "${venue.category} • ${venue.distanceText}"
                    setOnMarkerClickListener { _, _ ->
                        onVenueClick(venue.id)
                        true
                    }
                }
                view.overlays.add(marker)
            }
            view.invalidate()
        }
    )
}

@Composable
private fun rememberMapViewWithLifecycle(): MapView {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val mapView = remember {
        MapView(context).apply {
            setTileSource(TileSourceFactory.MAPNIK)
            setMultiTouchControls(true)
            zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)
        }
    }

    DisposableEffect(lifecycleOwner, mapView) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> mapView.onResume()
                Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                else -> Unit
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            mapView.onDetach()
        }
    }

    return mapView
}
