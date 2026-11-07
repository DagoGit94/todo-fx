# TodoFX

A modern, desktop To-Do List application built with Java and JavaFX. This project utilizes the **MVC (Model-View-Controller)** architecture and features a custom-styled user interface.

## Key Features
- **Task Management:** Add, complete, reopen, and delete tasks dynamically.
- **Data Persistence:** Automatically saves tasks to a local file (`~/.todos.txt`) so your list is saved between sessions.
- **Live Counter:** Displays a real-time count of completed vs. total tasks.
- **Custom UI:** Styled with an external CSS file for a clean, modern look.
- **Bilingual UI:** The user interface is presented in French.

## What I Practiced
- **JavaFX & FXML:** Designed the UI layout using `.fxml` files and injected elements into the controller using `@FXML`.
- **MVC Architecture:** Separated the data model (`Task.java`), the logic (`TodoController.java`), and the view (`todo.fxml`).
- **Observable Data:** Used `ObservableList` and JavaFX properties to ensure the UI automatically updates when tasks change.
- **File I/O:** Implemented reading and writing to a local text file using `java.nio.file.Files` and Java Streams.
- **CSS Styling:** Applied custom stylesheets to buttons, lists, and text fields.

## Project Structure
- `App.java`: The main entry point that loads the FXML and CSS.
- `TodoController.java`: Handles UI events (button clicks) and file saving/loading.
- `Task.java`: The data model representing a single to-do item.
- `todo.fxml`: The XML layout for the GUI.
- `style.css`: The stylesheet controlling colors, fonts, and spacing.

## Tech Stack
- Java, JavaFX, FXML, CSS
