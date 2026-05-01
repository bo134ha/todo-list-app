📝 Todo List App - MVVM & Kotlin Flow

A modern, reactive Android Todo application built with Kotlin and Jetpack Compose. This project serves as a showcase for Clean Architecture and MVVM, leveraging Kotlin Flow for a fully asynchronous and reactive data stream.
🏗️ Architecture Overview

The project follows the Clean Architecture pattern to ensure a scalable, testable, and maintainable codebase. It is divided into three primary layers:
1. Data Layer (data/)

    Local: Implements Room Database to provide persistent storage. All DAO queries return Flow to ensure the UI stays in sync with the database.

    Repository Implementation: Acts as the single source of truth, mediating between the local database and the domain layer.

2. Domain Layer (domain/)

    Model: Contains pure Kotlin data classes representing the business entities.

    Repository Interfaces: Defines the contract for data operations, abstracting the data source from the business logic.

    Use Cases: Encapsulates specific business rules (e.g., GetSortedTasksUseCase). They interact with flows and apply transformations where necessary.

3. UI Layer (ui/)

    ViewModel: Manages the UI state by collecting data from Use Cases. It converts cold Flows into StateFlow or SharedFlow to be consumed by Compose.

    Screens: Built with Jetpack Compose, observing the UI state in a lifecycle-aware manner.

    Navigation: Handles the routing and screen transitions within the app.
    
🛠️ Tech Stack

    Language: Kotlin

    UI Framework: Jetpack Compose

    Reactive Streams: Kotlin Flow (StateFlow, SharedFlow)

    Async Programming: Coroutines

    Local Database: Room

    Architecture: MVVM + Clean Architecture

📂 Project Structure

Based on the project's internal hierarchy:
Plaintext

com.boshra.mvvm
├── model
│   ├── data
│   │   ├── local      # Room DAO, Database & Entities
│   │   ├── remote     # API/Network configurations (if any)
│   │   └── repo       # Implementation of Domain Repositories
│   └── domain
│       ├── model      # Business Logic Entities
│       ├── repo       # Repository Interfaces
│       └── use_case   # Business Logic/Use Cases
└── ui
    ├── screens        # UI Components & Composables
    │   ├── component  # Reusable UI widgets
    │   └── navigation # App Navigation Graph
    ├── view_model     # State Management via Flows
    ├── theme          # Material3 Design System
    └── MainActivity   # Entry Point

🌊 Why Kotlin Flow?

This project utilizes Kotlin Flow to handle data streams because:

    Asynchronous Execution: Keeps the main thread free for UI rendering.

    Backpressure Support: Handles large streams of data efficiently.

    Lifecycle Awareness: When combined with collectAsStateWithLifecycle, it ensures that data collection only happens when the UI is active, saving battery and memory.
