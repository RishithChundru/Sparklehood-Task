# Sparklehood-Task



#  AI Safety Incident Tracker (Android App)

##  Project Overview

The **AI Safety Incident Tracker** is an Android application built using Kotlin that allows users  to:

- View a list of AI-related safety incidents
- Filter them by severity level (High, Medium, Low)
- Report new incidents with key information like title, description, and severity
- View complete details of each incident

This app is entirely local and stores the data in-memory (using `MutableList`). It is designed using **Material Design principles** and standard Android architecture with clear screen separation.

---

## Project Structure and Roles of Each File

### Kotlin Files (`.kt`)

| File Name | Role |
|-----------|------|
| `MainActivity.kt` | The home screen of the app. Displays the scrollable incident list using `RecyclerView`. Includes severity filter and FloatingActionButton (FAB) to report new incidents. |
| `DetailActivity.kt` | Displays full details of a selected incident when tapped. Handles back navigation. |
| `ReportIncidentActivity.kt` | Screen where users report a new incident. Contains input fields and validation. Upon save, sends new data back to MainActivity. |
| `IncidentAdapter.kt` |  Custom `RecyclerView.Adapter` that binds incident data to each CardView item. Handles click listeners to open the detail screen. |
| `Incident.kt` | A `data class` that defines the structure of each incident (id, title, description, severity, reported date). |

---

### XML Layout Files (`.xml`)

| File Name | Purpose |
|-----------|---------|
| `activity_main.xml` | UI for the home screen. Contains `Spinner`, `RecyclerView`, and `FAB`. |
| `activity_report.xml` | UI for reporting a new incident. Includes `EditText`, `Spinner`, and a `Button`. |
| `activity_detail.xml` | UI for the detail screen. Displays title, severity, date, and description. |
| `item_incident.xml` | Custom layout for each item in the RecyclerView (CardView). |

---

## How to Run This Project on Your Laptop

### Prerequisites
- Android Studio installed (latest version preferred)
- Kotlin support enabled
- Emulator or Physical Android Device

---

### Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/RishithChundru/Sparklehood-Task
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Click on **"Open"**, then browse and select the cloned folder

3. **Wait for Gradle Build**
   - Android Studio will sync Gradle and download dependencies (you'll see progress at the bottom)

4. **Run the App**
   - Connect an Android device or open an emulator
   - Press the green **Run ▶️** button or use **Shift + F10**

5. **Test the App**
   - View the incidents list
   - Try filtering by severity
   - Click the `+` (FAB) button to add a new incident
   - Fill in the form and hit "Save"
   - Click any incident to view full details

---

## Mock Data Example

```kotlin
val incidents = mutableListOf(
    Incident(1, "Biased Recommendation Algorithm", "Algorithm consistently favored...", "Medium", "2025-03-15T10:00:00Z"),
    Incident(2, "Unauthorized Data Sharing", "Sensitive data leaked to third party.", "High", "2025-03-18T14:45:00Z")
)
```

---

## Features Summary

- **RecyclerView** to show a scrollable incident list
- **CardView** to display incident info clearly
- **Severity Filter** using `Spinner`
- **FAB** to open incident report form
- **Detail screen** with full information
- **Validation** for input fields
- **Local data update** after saving new incidents

---

## Future Improvements (Optional Ideas)

- Use Room Database for persistent storage
- Add date filter or sort feature
- Integrate cloud-based backend or Firebase
- Add user authentication

---

## Developed By

Chundru Rishith Sai Chowdary  
Kotlin & Android Developer  
Email: [rishithrishith1@gmail.com]

---

