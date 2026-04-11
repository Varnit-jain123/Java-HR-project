# HR Automation Project

A comprehensive HR Management System built with Java, focusing on a robust multi-layered architecture to manage corporate designations and employees efficiently.

## 🚀 Overview

The **HR Automation Project** is a desktop application designed to streamline HR administrative tasks. It provides a clean, user-friendly interface for managing organizational hierarchies (Designations) and personnel records (Employees).

## 🏗️ Architecture

The project follows a clean, decoupled **Layered Architecture**, ensuring scalability and ease of maintenance:

-   **`pl` (Presentation Layer)**: Built with **Java Swing**, this layer handles all UI components and user interactions.
-   **`bl` (Business Logic Layer)**: Contains the core business rules, validation logic, and coordinators that bridge the UI and Data layers.
-   **`dl` (Data Layer)**: Defines interfaces and basic data access logic.
-   **`dbdl` (Database Data Layer)**: A MySQL-specific implementation of the Data Layer, managing persistence.
-   **`common`**: Shared interfaces, POJOs, and exceptions used across all layers.

## ✨ Features

### 📋 Designation Management
-   **Create**: Add new organizational roles.
-   **Read**: View all designations in a dynamic table with real-time search.
-   **Update**: Modify existing designation titles.
-   **Delete**: Remove designations with safety confirmation.
-   **Export**: Generate professional PDF reports of all designations using **iText7**.

### 👤 Employee Management
-   **CRUD Operations**: Full lifecycle management of employee records (Added via `EmployeeInterface`).
-   **Validation**: Robust business logic to ensure data integrity.

## 🛠️ Technology Stack

-   **Language**: Java (JDK 8+)
-   **UI Framework**: Java Swing
-   **Database**: MySQL
-   **Libraries**:
    -   **iText7**: For high-quality PDF generation.
    -   **MySQL Connector/J**: For database connectivity.
-   **Build Tool**: Gradle

## ⚙️ Setup & Installation

### Prerequisites
-   **Java Development Kit (JDK)** 8 or higher.
-   **MySQL Server** installed and running.
-   **Libraries**: Ensure the following are available on your system:
    -   `C:\itext7\*` (iText7 core and dependencies)
    -   `C:\mysqljar\*` (MySQL Connector)

### Database Configuration
1.  Create a MySQL database (e.g., `hrdb`).
2.  Configure your connection settings in the `dbdl` layer (specifically in `DAOConnection` or relevant config files).

### Building the Project
Navigate to each module directory (`common`, `dbdl`, `bl`, `pl`) and run:
```bash
gradle build
```
Wait for the build to generate the `.jar` files in their respective `build/libs` or `dist` directories.

## 🏃 Usage

Once built, you can run the application from the `pl` directory using the following command:

```bash
java -classpath ..\common\dist\hr-common.jar;..\dbdl\build\libs\dbdl.jar;..\bl\build\libs\bl.jar;build\libs\pl.jar;C:\itext7\*;C:\mysqljar\*;. com.varnit.jain.hr.pl.Main
```

---

*Developed by Varnit Jain*
