package com.example.kcg_intellij;

// *Class representing a Journal entry. This is one type of citation entry.
public class Journal {

    // Attributes to store basic information for a Journal entry.
    private String author; // Primary author of the journal.
    private String title; // Title of the Journal.
    private boolean online; // T/F indicating if the journal is online (true) or offline (false).
    private String publisher; // Publisher of the Journal.
    private int publishedYear; // Year of publishment
    private int volumeNumber; // volume number of the Journal
    private int issueNumber; // issue number of the Journal
    private boolean pageApplicable; // T/F indicating if this entry have page numbers
    private int startingPageNumber; // Starting page number relevant to the citation.
    private int endingPageNumber; // Ending page number relevant to the citation.
    private String accessingDate; // Date of access for Journal.
    private String url; // URL of the online journal, if any.

    // Constructor to initialize all attributes of the Journal object.
    public Journal(String author, String title, boolean online, String publisher, int publishedYear,
            int volumeNumber,
            int issueNumber, boolean pageApplicable, int startingPageNumber, int endingPageNumber, String accessingDate,
            String url) {
        this.author = author;
        this.title = title;
        this.online = online;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
        this.volumeNumber = volumeNumber;
        this.issueNumber = issueNumber;
        this.pageApplicable = pageApplicable;
        this.startingPageNumber = startingPageNumber;
        this.endingPageNumber = endingPageNumber;
        this.accessingDate = accessingDate;
        this.url = url;
    }

    // Getter methods for accessing private attributes.
    public String getAuthor() {
        return author;
    } // Retrieve the main author.

    public String getTitle() {
        return title;
    } // Retrieve the journal title.

    public String getPublisher() {
        return publisher;
    } // Retrieve the publisher name.

    public int getPublishedYear() {
        return publishedYear;
    } // Retrieve the published year.

    public int getVolumeNumber() {
        return volumeNumber;
    } // Retrieve the vol. number.

    public int getIssueNumber() {
        return issueNumber;
    } // Retrieve the issue. number

    public int getStartingPageNumber() {
        return startingPageNumber;
    } // Retrieve starting page number.

    public int getEndingPageNumber() {
        return endingPageNumber;
    } // Retrieve ending page number.

    public String getUrl() {
        return url;
    } // Retrieve URL for online journal.

    public boolean isPageApplicable() {
        return pageApplicable;
    } // Retrieve the issue. number

    public boolean isOnline() {
        return online;
    } // Check if the journal is online.
    
    public String getAccessingDate(){
        return accessingDate;
    }
}
