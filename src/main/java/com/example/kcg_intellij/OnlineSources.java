package com.example.kcg_intellij;

// *Class representing a OnlineSources entry. This is one type of citation entry.
public class OnlineSources {

    // Attributes to store basic information for a OnlineSources entry.
    private String author; // Primary author of the source.
    private String sourceType;
    private String title; // Title of the OnlineSources.
    private String publisher; // Publisher of the OnlineSources.
    private String publishedDate; // date of publishment
    private String accessingDate; // Date of access for OnlineSources.
    private String url; // URL of the online source, if any.

    // Constructor to initialize all attributes of the OnlineSources object.
    public OnlineSources(String author, String sourceType, String title, String publisher, String publishedDate,
            String accessingDate, String url) {
        this.author = author;
        this.sourceType = sourceType;
        this.title = title;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.accessingDate = accessingDate;
        this.url = url;
    }

    // Getter methods for accessing private attributes.
    public String getAuthor() {
        return author;
    } // Retrieve the main author.

    public String getTitle() {
        return title;
    } // Retrieve the source title.

    public String getPublisher() {
        return publisher;
    } // Retrieve the publisher name.

    public String getPublishedDate() {
        return publishedDate;
    } // Retrieve the published year.

    public String getSourceType() {
        return sourceType;
    }

    public String getAccessingDate() {
        return accessingDate;
    }

    public String getUrl() {
        return url;
    } // Retrieve URL for online source.
}
