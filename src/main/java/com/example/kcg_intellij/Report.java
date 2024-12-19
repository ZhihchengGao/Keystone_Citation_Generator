package com.example.kcg_intellij;

// *Class representing a Report entry. This is one type of citation entry.
public class Report {

    // Attributes to store basic information for a Report entry.
    private String author; // Primary author of the news.
    private String title; // Title of the Report.
    private boolean online; // T/F indicating if the news is online (true) or offline (false).
    private String publisher; // Publisher of the Report.
    private String publishedDate; // Year of publishment
    private String accessingDate; // Date of access for Report.
    private String url; // URL of the online news, if any.

    // Constructor to initialize all attributes of the Report object.
    public Report(String author, String title, boolean online, String publisher, String publishedDate,
            String accessingDate, String url) {
        this.author = author;
        this.title = title;
        this.online = online;
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
    } // Retrieve the news title.

    public String getPublisher() {
        return publisher;
    } // Retrieve the publisher name.

    public String getPublishedDate() {
        return publishedDate;
    } // Retrieve the published year.

    public String getAccessingDate() {
        return accessingDate;
    }

    public String getUrl() {
        return url;
    } // Retrieve URL for online newspaper.

    public boolean isOnline() {
        return online;
    } // Check if the news is online.
}
