## Find My Store -- Integrated with Google Maps

**An Android application built with Jetpack Compose that helps users find nearby stores. The app displays a list of the closest stores, allows users to search for specific locations, and provides an interactive map view to visualize store locations.**


## ✨ Features
- **Interactive Map View**: Integrates Google Maps to show the exact location of a selected store with a marker.
- **Dashboard**: A welcoming screen with user information and a summary.
- **Store Locator**: Displays a list of the nearest stores based on the user's location.
- **Search Functionality**: A dynamic search bar to filter and find stores easily.
- **Click to Call Intent**: Directly call the owner of the store
- **Clean & Modern UI**: Built entirely with Jetpack Compose, following modern design principles with a sleek dark theme.

 ## Screenshots

<img src="https://github.com/jassdahima/FindMyStore/blob/main/Screenshots/findmystore1.png" width="250" /> <img src="https://github.com/jassdahima/FindMyStore/blob/main/Screenshots/Findmystore2.png" width="250" />


<img src="https://github.com/jassdahima/FindMyStore/blob/main/Screenshots/findmystore3.png" width="250" /> <img src="https://github.com/jassdahima/FindMyStore/blob/main/Screenshots/findmystore4.png" width="250" />






## Google Maps Integration

- **GoogleMap Display**: The main container that renders the map view within the MapScreen.
- **Store Location**: Places a pin on the map to indicate the exact coordinates of the selected store.
- **Camera Control**: Manages the map's camera, allowing it to be centered on the store's location with a specified zoom level.
- **Marker Management**: Creates and remembers the state of a marker, including its position, to efficiently manage it across recompositions.
- **Data Model**: The object used to pass latitude and longitude coordinates from the StoreModel to the map components.
- **API Key Security**: The Google Maps API key is loaded securely at build time from a local, untracked properties file to prevent it from being exposed in the repository.

 



 

 ## 🛠️ Built With
 This project leverages the latest in Android development to provide a smooth, modern, and maintainable codebase.

 - **Kotlin**: First-party and official programming language for Android development.
 - **Jetpack** Compose: Android’s modern toolkit for building native UI.
 - **Firebase Realtime Database**: For fetching store data in real-time.
 - **Google Maps Platform**: For displaying interactive maps and markers.
 - **Coil**: A coroutine-based image loading library for Android.
 - **Material 3**: The latest version of Google's open-source design system.
 - ConstraintLayout for Compose: For creating complex and flexible layouts.
 - **Kotlin Coroutines**: For managing background threads and asynchronous operations.

## 🚀 Getting Started

1.Clone the RepositoryOpen your terminal, navigate to your desired directory, and run the following command:
 
2.sh
git clone https://github.com/your-username/FindMyStore.git





