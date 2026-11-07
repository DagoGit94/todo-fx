package com.example.todofx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TodoController {

    // ===== Éléments du FXML (injectés automatiquement) =====
    @FXML private TextField inputField;
    @FXML private ListView<Task> taskList;
    @FXML private Label statusLabel;

    // ===== La liste observable des tâches =====
    private final ObservableList<Task> tasks = FXCollections.observableArrayList();

    // ===== Fichier de sauvegarde =====
    private final Path saveFile = Path.of(
            System.getProperty("user.home"), ".todos.txt");

    // ===== Initialisation =====
    @FXML
    public void initialize() {
        taskList.setItems(tasks);   // lie la liste observable à l'affichage
        loadFromFile();              // charge les tâches sauvegardées
        updateStatus();              // met à jour le compteur
    }

    // ===== Ajouter une tâche =====
    @FXML
    public void handleAdd() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;

        tasks.add(new Task(text));
        inputField.clear();
        saveToFile();
        updateStatus();
    }

    // ===== Terminer / Rouvrir une tâche =====
    @FXML
    public void handleToggle() {
        Task selected = taskList.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        selected.setDone(!selected.isDone());
        taskList.refresh();
        saveToFile();
        updateStatus();
    }

    // ===== Supprimer une tâche =====
    @FXML
    public void handleDelete() {
        Task selected = taskList.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        tasks.remove(selected);
        saveToFile();
        updateStatus();
    }

    // ===== Tout effacer =====
    @FXML
    public void handleClearAll() {
        tasks.clear();
        saveToFile();
        updateStatus();
    }

    // ===== Mettre à jour le compteur =====
    private void updateStatus() {
        int total = tasks.size();
        long done = tasks.stream().filter(Task::isDone).count();
        statusLabel.setText(done + " / " + total + " terminée(s)");
    }

    // ===== Sauvegarder dans le fichier =====
    private void saveToFile() {
        try {
            List<String> lines = tasks.stream()
                    .map(t -> t.isDone() + "|" + t.getDescription())
                    .toList();
            Files.write(saveFile, lines);
        } catch (IOException e) {
            System.err.println("Erreur de sauvegarde : " + e.getMessage());
        }
    }

    // ===== Charger depuis le fichier =====
    private void loadFromFile() {
        if (!Files.exists(saveFile)) return;

        try {
            List<String> lines = Files.readAllLines(saveFile);
            for (String line : lines) {
                String[] parts = line.split("\\|", 2);
                if (parts.length < 2) continue;

                Task t = new Task(parts[1]);
                t.setDone(Boolean.parseBoolean(parts[0]));
                tasks.add(t);
            }
        } catch (IOException e) {
            System.err.println("Erreur de chargement : " + e.getMessage());
        }
    }
}