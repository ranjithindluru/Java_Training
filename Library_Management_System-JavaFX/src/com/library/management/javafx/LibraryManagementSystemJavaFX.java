package com.library.management.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;

/**
 * The LibraryManagementSystemJavaFX class is the main class that extends
 * the JavaFX Application class. It provides a GUI-based Library Management System
 * allowing users to manage library resources.
 */
public class LibraryManagementSystemJavaFX extends Application {

    private static final String DATA_FILE = "library_data.txt";

    private TableView<Library> tableView;
    private ObservableList<Library> resources;

    private TextField titleField;
    private TextField authorField;
    private TextField typeField;

    private Library selectedResource;

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library Management System");

        // Create table columns
        TableColumn<Library, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());

        TableColumn<Library, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());

        TableColumn<Library, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());

        // Create table view
        tableView = new TableView<>();
        tableView.getColumns().addAll(titleColumn, authorColumn, typeColumn);

        // Create form fields
        titleField = new TextField();
        authorField = new TextField();
        typeField = new TextField();

        // Create buttons
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addLibraryDetails(titleField.getText(), authorField.getText(), typeField.getText()));

        Button editButton = new Button("Select");
        editButton.setOnAction(e -> selectLibraryDetailForEdit());

        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> updateLibraryDetails());

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteLibraryDetail());

        // Create layout
        GridPane formLayout = new GridPane();
        formLayout.setHgap(10);
        formLayout.setVgap(5);
        formLayout.setPadding(new Insets(10));
        formLayout.addRow(0, new Label("Title:"), titleField);
        formLayout.addRow(1, new Label("Author:"), authorField);
        formLayout.addRow(2, new Label("Type:"), typeField);
        formLayout.addRow(3, addButton, editButton, updateButton, deleteButton);

        VBox vbox = new VBox(tableView, formLayout);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

        // Load data from file
        resources = FXCollections.observableArrayList();
        loadResourcesFromFile();

        // Bind data to table view
        tableView.setItems(resources);

        primaryStage.setScene(new Scene(vbox, 600, 400));
        primaryStage.show();
    }

    /**
     * Loads the library resources from the data file.
     */
    private void loadResourcesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 3) {
                    String title = fields[0];
                    String author = fields[1];
                    String type = fields[2];
                    resources.add(new Library(title, author, type));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading resources from file: " + e.getMessage());
        }
    }

    /**
     * Adds a new library resource to the system.
     *
     * @param title  The title of the resource.
     * @param author The author of the resource.
     * @param type   The type of the resource.
     */
    private void addLibraryDetails(String title, String author, String type) {
        Library resource = new Library(title, author, type);
        resources.add(resource);
        saveLibraryDetailsToFile();
        clearFormFields();
    }

    /**
     * Selects a library resource from the table for editing.
     */
    private void selectLibraryDetailForEdit() {
        selectedResource = tableView.getSelectionModel().getSelectedItem();
        if (selectedResource != null) {
            titleField.setText(selectedResource.getTitle());
            authorField.setText(selectedResource.getAuthor());
            typeField.setText(selectedResource.getType());
        }
    }

    /**
     * Updates the details of the selected library resource.
     */
    private void updateLibraryDetails() {
        if (selectedResource != null) {
            selectedResource.setTitle(titleField.getText());
            selectedResource.setAuthor(authorField.getText());
            selectedResource.setType(typeField.getText());
            saveLibraryDetailsToFile();
            clearFormFields();
            selectedResource = null;
        }
    }

    /**
     * Deletes the selected library resource.
     */
    private void deleteLibraryDetail() {
        selectedResource = tableView.getSelectionModel().getSelectedItem();
        if (selectedResource != null) {
            resources.remove(selectedResource);
            saveLibraryDetailsToFile();
            clearFormFields();
        }
    }

    /**
     * Saves the library details to the data file.
     */
    private void saveLibraryDetailsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Library resource : resources) {
                writer.write(resource.getTitle() + "," + resource.getAuthor() + "," + resource.getType());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving resources to file: " + e.getMessage());
        }
    }

    /**
     * Clears the form fields.
     */
    private void clearFormFields() {
        titleField.clear();
        authorField.clear();
        typeField.clear();
    }
}
