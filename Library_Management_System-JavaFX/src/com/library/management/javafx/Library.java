package com.library.management.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Library {

    private String title;
    private String author;
    private String type;

    /**
     * Constructs a Library resource with the specified title, author, and type.
     *
     * @param title  The title of the resource.
     * @param author The author of the resource.
     * @param type   The type of the resource.
     */
    public Library(String title, String author, String type) {
        this.title = title;
        this.author = author;
        this.type = type;
    }

    /**
     * Returns the title of the resource.
     *
     * @return The title of the resource.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the resource.
     *
     * @return The author of the resource.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the type of the resource.
     *
     * @return The type of the resource.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the title of the resource.
     *
     * @param title The new title of the resource.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the author of the resource.
     *
     * @param author The new author of the resource.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the type of the resource.
     *
     * @param type The new type of the resource.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns a StringProperty representing the title of the resource.
     *
     * @return The StringProperty for the title of the resource.
     */
    public StringProperty titleProperty() {
        return new SimpleStringProperty(title);
    }

    /**
     * Returns a StringProperty representing the author of the resource.
     *
     * @return The StringProperty for the author of the resource.
     */
    public StringProperty authorProperty() {
        return new SimpleStringProperty(author);
    }

    /**
     * Returns a StringProperty representing the type of the resource.
     *
     * @return The StringProperty for the type of the resource.
     */
    public StringProperty typeProperty() {
        return new SimpleStringProperty(type);
    }
}
