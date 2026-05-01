# 📝 Todo List App — MVVM & Kotlin Flow

A modern, reactive Android Todo application built with **Kotlin** and **Jetpack Compose**.
This project showcases **Clean Architecture** with **MVVM**, leveraging **Kotlin Flow** for fully asynchronous and reactive data handling.

---

## 🏗️ Architecture Overview

The project follows **Clean Architecture** to ensure scalability, testability, and maintainability.
It is divided into three main layers:

### 1. Data Layer (`data/`)

* **Local**

  * Uses **Room Database** for persistent storage.
  * All DAO queries return `Flow` to keep the UI automatically in sync with data changes.

* **Repository Implementation**

  * Acts as the **single source of truth**.
  * Bridges the gap between the local data source and the domain layer.

---

### 2. Domain Layer (`domain/`)

* **Model**

  * Pure Kotlin data classes representing business entities.

* **Repository Interfaces**

  * Define contracts for data operations.
  * Decouple business logic from data sources.

* **Use Cases**

  * Encapsulate business rules (e.g., `GetSortedTasksUseCase`).
  * Work with `Flow` and apply transformations as needed.

---

### 3. UI Layer (`ui/`)

* **ViewModel**

  * Manages UI state.
  * Collects data from use cases.
  * Converts `Flow` into `StateFlow` or `SharedFlow`.

* **Screens**

  * Built with **Jetpack Compose**.
  * Observe state in a lifecycle-aware way.

* **Navigation**

  * Handles routing and screen transitions.

---

## 🛠️ Tech Stack

* **Language:** Kotlin
* **UI Framework:** Jetpack Compose
* **Reactive Streams:** Kotlin Flow (`StateFlow`, `SharedFlow`)
* **Async Programming:** Coroutines
* **Local Database:** Room
* **Architecture:** MVVM + Clean Architecture

---

## 📂 Project Structure

```plaintext
com.boshra.mvvm
├── model
│   ├── data
│   │   ├── local      # Room DAO, Database & Entities
│   │   ├── remote     # API / Network (optional)
│   │   └── repo       # Repository implementations
│   └── domain
│       ├── model      # Business entities
│       ├── repo       # Repository interfaces
│       └── use_case   # Business logic
└── ui
    ├── screens
    │   ├── component  # Reusable UI components
    │   └── navigation # Navigation graph
    ├── view_model     # State management (Flow)
    ├── theme          # Material3 theme
    └── MainActivity   # Entry point
```

---

## 🌊 Why Kotlin Flow?

* **Asynchronous Execution**
  Keeps the main thread free for smooth UI rendering.

* **Reactive Streams**
  Automatically updates UI when data changes.

* **Backpressure Handling**
  Efficiently processes large streams of data.

* **Lifecycle Awareness**
  With `collectAsStateWithLifecycle`, data is collected only when the UI is active — saving battery and resources.

---

## ✨ Summary

This project demonstrates how to build a **modern Android app** using:

* Reactive programming with Flow
* Clean separation of concerns
* Scalable architecture patterns

It serves as a solid foundation for real-world apps that require **maintainability, performance, and clean code structure**.
