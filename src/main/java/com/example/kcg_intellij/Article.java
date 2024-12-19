package com.example.kcg_intellij;

// *Class representing a Article entry. This is one type of citation entry.
public class Article {

    // Attributes to store basic information for a Article entry.
    private String author; // Primary author of the article.
    private String title; // Title of the Article.
    private boolean online; // T/F indicating if the article is online (true) or offline (false).
    private String publishedPlace; // place of publishment
    private String publisher; // Publisher of the Article.
    private int publishedYear; // Year of publishment
    private String accessingDate; // Date of access for Article.
    private String url; // URL of the online article, if any.

    // Constructor to initialize all attributes of the Article object.
    public Article(String author, String title, boolean online, String publishedPlace, String publisher,
            int publishedYear, String accessingDate, String url) {
        this.author = author;
        this.title = title;
        this.online = online;
        this.publishedPlace = publishedPlace;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
        this.accessingDate = accessingDate;
        this.url = url;
    }

    // Getter methods for accessing private attributes.
    public String getAuthor() {
        return author;
    } // Retrieve the main author.

    public String getTitle() {
        return title;
    } // Retrieve the article title.

    public String getPublishedPlace() {
        return publishedPlace;
    } // Retrieve place published.

    public String getPublisher() {
        return publisher;
    } // Retrieve the publisher name.

    public int getPublishedYear() {
        return publishedYear;
    } // Retrieve the published year.

    public String getUrl() {
        return url;
    } // Retrieve URL for online articlepaper.

    public String getAccessingDate() {
        return accessingDate;
    } // Retrieve accessing Date

    public boolean isOnline() {
        return online;
    } // Check if the article is online.
}
