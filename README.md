# Mobile Devices CCC: Workout Planner Application 
Team H : NGADJOU Jeremy PATUREL EMERIC POLIZZI Enzo SYED Tashfin 
## Project Structure

The project is organized into various packages and files to ensure modularity and maintainability. Below is an overview of the structure:

---

### **Packages and Files**

#### **1. `data`**
This package contains the data layer for the application, including the database, DAO (Data Access Object), and repository.

- **`Exercise`**: Defines the data model for exercises.
- **`ExerciseDao`**: Interface for database operations related to exercises.
- **`ExerciseDatabase`**: Room database for storing exercises.
- **`ExerciseRepository`**: Repository to manage data operations and provide data to the view models.

---

#### **2. `DBFunctions`**
This package includes database-related functions and UI interaction handlers.

- **`AllWorkoutDisplaying.kt`**: Handles displaying all saved workouts.
- **`CreateList.kt`**: Manages the creation of new workout lists.
- **`ExerciseListScreen.kt`**: Displays a list of exercises for a specific workout.

---

#### **3. `EachPageFunctions`**
Contains specific logic for handling UI interactions on each page.

- **`CurrentPageDisplaying.kt`**: Handles the display logic for the current workout page.
- **`HomePageDisplaying.kt`**: Logic for displaying the home page.
- **`RestTimeDisplaying.kt`**: Handles the rest time display functionality.
- **`WorkoutDisplaying.kt`**: Manages the workout display on the workout page.

---

#### **4. `modelviewpackage`**
This package includes ViewModel classes and related logic for managing UI data.

- **`CurrentPageListExercise.kt`**: ViewModel for managing the list of exercises on the current page.
- **`ExerciseScreen.kt`**: Handles logic for the main exercise screen.
- **`HomepageListExercise.kt`**: ViewModel for managing the exercises displayed on the home page.
- **`RestTimeTimerExercise.kt`**: Handles the timer functionality during rest periods.
- **`ViewModelGetAllData.kt`**: Fetches all data from the repository for the UI.
- **`ViewModelGetId.kt`**: Fetches data by specific identifiers for the UI.

---

#### **5. `navButton`**
Handles navigation logic for buttons across the application.

- **`NavigationButton.kt`**: Centralized navigation logic for buttons between pages.

---

#### **6. `pages`**
Contains the individual pages of the application. Each page corresponds to a specific screen.

- **`AddExercise.kt`**: Screen for adding a new exercise to a workout.
- **`CurrentProgram.kt`**: Displays the current workout program with exercises and their details.
- **`HomePage.kt`**: Main entry point to the application (home screen).
- **`Loginpage.kt`**: Login functionality for users.
- **`Pause.kt`**: Screen for pausing the workout timer.
- **`RestTime.kt`**: Manages the rest time countdown.
- **`RestTimeInput.kt`**: Input screen for specifying rest time durations.
- **`RoundInput.kt`**: Input screen for specifying the number of rounds for an exercise.
- **`UpdateExercice.kt`**: Screen for updating the details of a specific exercise.
- **`Workout.kt`**: Displays the main workout screen with exercise progress tracking.
- **`WorkoutPlanning.kt`**: Allows users to select and manage their workout plans.
- **`WorkoutProgram.kt`**: Displays detailed information about a selected workout program.

---

## How to Navigate the Project

- **Data Layer**: Located in the `data` package, it handles the database and repository.
- **UI Logic**: `EachPageFunctions` and `DBFunctions` packages manage the business logic and interactions for specific screens.
- **ViewModel**: The `modelviewpackage` contains ViewModel classes that bridge the data layer and the UI.
- **Pages**: The `pages` package contains all the screens available in the app.

---

## Getting Started

### Prerequisites
- Kotlin development environment.
- Android Studio installed.

### How to Run
1. Clone the repository:
   ```bash
   git clone git@github.com:EPZ2003/ProjetAppMobileCCC.git
   cd ProjetAppMobileCCC
### Data to insert into the table Exercice_table : 
   ```bash
INSERT INTO exercise (name, round, time, typeExercise) VALUES
('Squats', 1, '45', 'legs'),
('Lunges', 1, '56', 'legs'),
('Plank', 2, '65', 'abs'),
('Crunches', 2, '45', 'abs'),
('Push-Ups', 3, '76', 'push'),
('Bench Press', 3, '43', 'push')
