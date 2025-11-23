# 📺 **TV Series Explorer**
*Une application Android moderne pour explorer les séries TV via l'API [Episodate](https://www.episodate.com/api)*

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-1.6.0-4285F4)](https://developer.android.com/jetpack/compose)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

---

## 📝 **À propos du projet**
**TV Series Explorer** est une application Android développée en **Kotlin** avec **Jetpack Compose**, respectant les bonnes pratiques modernes :
- **Architecture MVVM** pour une séparation claire des responsabilités.
- **Zéro XML** : Interface 100% déclarative avec Compose.
- **Injection de dépendances** via Hilt pour une modularité optimale.

### ✨ **Fonctionnalités clés**
| Fonctionnalité               | Description                                                                 |
|------------------------------|-----------------------------------------------------------------------------|
| **Liste des séries populaires** | Récupération via `/most-popular` (pagination possible en bonus).           |
| **Recherche dynamique**       | Filtre en temps réel via `/search?q={query}` (debounce implémenté).        |
| **Détails d'une série**       | Affiche poster, synopsis, note, genre et nombre d'épisodes.                |
| **Gestion des états**         | Loading (⏳), Success (✅), Error (❌) avec messages adaptés.               |
| **Navigation fluide**         | Utilisation de `Navigation Compose` pour passer entre écrans.              |

---

## 🛠 **Stack Technique**
### **Langages & Outils**
- **Kotlin** (100% du code, coroutines + Flow pour l'asynchrone).
- **Jetpack Compose** (UI déclarative, animations Lottie en bonus).
- **Android Studio Koala** (ou plus récent).

### **Architecture & Bibliothèques**
| Composant          | Technologie                          | Rôle                                                                 |
|--------------------|--------------------------------------|----------------------------------------------------------------------|
| **UI**             | Jetpack Compose                     | Écrans et composables réutilisables.                                |
| **Navigation**     | Navigation Compose (`2.9.5`)        | Gestion des routes et passage d'arguments.                          |
| **Réseau**         | Retrofit (`3.0.0`) + GSON           | Appels API REST avec conversion JSON automatique.                   |
| **Images**         | Coil (`2.7.0`)                      | Chargement asynchrone et cache des posters.                        |
| **DI**             | Hilt (`2.57.2`)                     | Injection des dépendances (ViewModel, Repository, ApiService).      |
| **State Management** | MVI (Model-View-Intent) via ViewModel | Gestion centralisée des états (Loading/Success/Error).              |

---

## 📂 **Structure du Projet**
📦com.example.tvseriesexplorer
├── 📂 data                          # Couche données
│   ├── 📄 api/
│   │   └── TvSeriesApi.kt          # Déclaration des endpoints Retrofit
│   ├── 📄 model/
│   │   ├── TvShow.kt                # Data class pour une série (liste)
│   │   └── TvShowDetail.kt          # Data class pour les détails
│   └── 📄 repository/
│       └── TvSeriesRepository.kt   # Logique métier + appels API
│
├── 📂 di                            # Injection de dépendances
│   └── 📄 AppModule.kt              # Fournit Retrofit, Repository, etc.
│
├── 📂 ui                            # Couche présentation
│   ├── 📄 theme/
│   │   └── Theme.kt                # Couleurs, typographie, formes
│   ├── 📄 screens/
│   │   ├── HomeScreen.kt           # Écran d'accueil (liste + recherche)
│   │   ├── DetailScreen.kt         # Écran de détails
│   │   └── components/             # Composables réutilisables (ex: TvShowCard)
│   └── 📄 MainActivity.kt          # Point d'entrée (setup Navigation)
│
└── 📂 viewmodel                     # Logique métier
    └── 📄 TvSeriesViewModel.kt     # États (UiState) et logiques

---

## 🚀 **Installation & Lancement**
### **Prérequis**
- Android Studio **Koala ou supérieur**.
- Un appareil/émulateur avec **Android 8.0 (Oreo) ou plus**.

### **Étapes**
1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/votre-utilisateur/TV-Series-Explorer.git

Ouvrir dans Android Studio :
Lancer Android Studio → File → Open → Sélectionner le dossier du projet.


Synchroniser Gradle :
Attendre que les dépendances se téléchargent (vérifier build.gradle).


Lancer l'application :
Brancher un appareil ou lancer un émulateur (Pixel 5 recommandé).
Cliquer sur ▶️ (Run).
