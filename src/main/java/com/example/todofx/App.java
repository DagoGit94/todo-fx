package com.example.todofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                App.class.getResource("todo.fxml"));
        VBox root = loader.load();

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add(
                App.class.getResource("style.css").toExternalForm());

        stage.setTitle("📝 Ma To-Do List");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}