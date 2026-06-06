package com.yigittepe.nearcampus1.data

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationManager

internal object LocationService {
    var userLocation: Location? = null

    @SuppressLint("MissingPermission")
    fun updateLocation(context: Context) {
        try {
            val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val providers = locationManager.getProviders(true)
            var bestLocation: Location? = null
            for (provider in providers) {
                val loc = locationManager.getLastKnownLocation(provider) ?: continue
                if (bestLocation == null || loc.accuracy < bestLocation.accuracy) {
                    bestLocation = loc
                }
            }
            userLocation = bestLocation
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // Helper to calculate distance in km between two coordinates
    fun calculateDistanceKm(
        lat1: Double, lon1: Double,
        lat2: Double, lon2: Double
    ): Double {
        val results = FloatArray(1)
        Location.distanceBetween(lat1, lon1, lat2, lon2, results)
        return (results[0] / 1000.0)
    }
}
