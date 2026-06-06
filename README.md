# Near Campus

Near Campus is a premium, modern Android application designed for university students to discover venues, view menus, access campus-exclusive discounts, and read student-verified reviews.

Built natively with **Kotlin**, **Jetpack Compose**, and backed by **Firebase (Auth & Firestore)**, the app delivers a fluid, high-end user experience tailored to university campus environments.

---

## 🌟 Key Features

* **Discover Nearby Venues**: List and explore restaurants, cafes, and study spots near campus.
* **Dynamic Location Sorting**: Displays physical distances (e.g., `< 100 km` formatting for distant venues) and automatically sorts venues closest to the user using device location services.
* **Premium Theme & Animations**: Custom typography, dark-mode tones, glassmorphism overlays, and smooth micro-animations.
* **Dynamic Campaign Carousels**: Automated sliding banners showing verified student deals linked directly to campus venues.
* **Unified Review System**: Sourced from verified student profiles (`isStudentVerified` verification flag) with beautiful skeleton loaders during database fetch.
* **Interactive Venue Map Views**: Embedded interactive campus map integration with OpenStreetMap (OSMDroid) showing relative positioning.
* **Secure Student Accounts**: Complete email-password sign-up, secure guest-browsing support, password change options, and avatar selectors directly linked to Firebase Authentication and Cloud Storage.

---

## 🛠️ Tech Stack & Architecture

* **UI Layer**: Jetpack Compose (Declarative UI)
* **Image Loading**: Coil Async Image Loader
* **Database**: Cloud Firestore (Real-time syncing and offline-caching)
* **Auth**: Firebase Authentication (Email/Password & Guest flow)
* **Maps**: OpenStreetMap integration via OSMDroid

---

## 🚀 Getting Started

### Prerequisites

* Android Studio Ladybug (or newer)
* Android SDK 29+ (Targeting SDK 35/36)
* A Firebase Project with **Firestore** and **Email/Password Authentication** enabled.

### Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yigittepe/Near-Campus.git
   ```

2. **Add Firebase configuration**:
   * Create an Android App in your Firebase Console with package name `com.yigittepe.nearcampus`.
   * Download the `google-services.json` file.
   * Place it in the `/app` folder of the project directory.

3. **Build & Run**:
   * Open the project in Android Studio.
   * Let Gradle sync dependencies.
   * Run the app on an emulator or physical device.
