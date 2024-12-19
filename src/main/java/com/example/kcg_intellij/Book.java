package com.example.kcg_intellij;

// *Class representing a Book entry. This is one type of citation entry.
public class Book {

    // Attributes to store basic information for a Book entry.
    private String author; // Primary author of the book.
    private boolean haveOtherAuthor; // T/F indicating if there is an additional author.
    private String otherAuthor; // Name of the additonal author, if any.
    private String title; // Title of the book.
    private boolean online; // T/F indicating if the book is online (true) or offline (false).
    private String publishedPlace; // Place where the book was published.
    private String publisher; // Publisher of the book.
    private int publishedYear; // Year of publishment
    private int startingPageNumber; // Starting page number relevant to the citation.
    private int endingPageNumber; // Ending page number relevant to the citation.
    private String accessingDate; // Date of access for online books.
    private String url; // URL of the online book, if any.

    // Constructor to initialize all attributes of the Book object.
    public Book(String author, boolean haveOtherAuthor, String otherAuthor, String title,
            boolean online, String publishedPlace, String publisher, int publishedYear,
            int startingPageNumber, int endingPageNumber, String accessingDate, String url) {
        this.author = author; // Initialize the main author.
        this.haveOtherAuthor = haveOtherAuthor; // Set if there is another author.
        this.otherAuthor = otherAuthor; // Initialize the secondary author, if any.
        this.title = title; // Set the title of the book.
        this.online = online; // Mark the book as online or offline.
        this.publishedPlace = publishedPlace; // Initialize place of publication.
        this.publisher = publisher; // Set the publisher name.
        this.publishedYear = publishedYear; // Set the year of publication.
        this.startingPageNumber = startingPageNumber; // Set starting page for citation.
        this.endingPageNumber = endingPageNumber; // Set ending page for citation.
        this.accessingDate = accessingDate; // Set access date for online sources.
        this.url = url; // Initialize URL for online books, if any.
    }

    // Getter methods for accessing private attributes.
    public String getAuthor() {
        return author;
    } // Retrieve the main author.

    public String getOtherAuthor() {
        return otherAuthor;
    } // Retrieve the secondary author.

    public String getTitle() {
        return title;
    } // Retrieve the book title.

    public String getPublishedPlace() {
        return publishedPlace;
    } // Retrieve the place of publication.

    public String getPublisher() {
        return publisher;
    } // Retrieve the publisher name.

    public int getStartingPageNumber() {
        return startingPageNumber;
    } // Retrieve starting page number.

    public int getEndingPageNumber() {
        return endingPageNumber;
    } // Retrieve ending page number.

    public String getUrl() {
        return url;
    } // Retrieve URL for online book.

    public String getAccessingDate() {
        return accessingDate;
    } // Retrieve accessing date

    public boolean isOnline() {
        return online;
    } // Check if the book is online.

    public boolean hasOtherAuthor() {
        return haveOtherAuthor;
    } // Check if there is an additional author.
}