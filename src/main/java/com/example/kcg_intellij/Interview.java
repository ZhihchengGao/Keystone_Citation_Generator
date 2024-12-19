package com.example.kcg_intellij;

// *Class representing a Interview entry. This is one type of citation entry.
public class Interview {

    // Attributes to store basic information for a Interview entry.
    private String interviewee; // name of the interviewee
    private String interviewer; // name of the interviewer
    private String title; // Title of the Interview.
    private boolean online; // T/F indicating if the interview is online (true) or offline (false).
    private String publisher; // Publisher of the Interview.
    private String interviewDate; // date of Interview
    private String accessingDate; // Date of access for Interview.
    private String url; // URL of the online interview, if any.

    // Constructor to initialize all attributes of the Interview object.
    public Interview(String interviewee, String interviewer, String title, boolean online, String publisher,
            String interviewDate, String accessingDate, String url) {
        this.interviewee = interviewee;
        this.interviewer = interviewer;
        this.title = title;
        this.online = online;
        this.publisher = publisher;
        this.interviewDate = interviewDate;
        this.accessingDate = accessingDate;
        this.url = url;
    }

    // Getter methods for accessing private attributes.
    public String getInterviewer() {
        return interviewer;
    } // Retrieve the interviewer

    public String getInterviewee() {
        return interviewee;
    } // Retrieve the interviewee

    public String getTitle() {
        return title;
    } // Retrieve the interview title.

    public String getPublisher() {
        return publisher;
    } // Retrieve the publisher name.

    public String getUrl() {
        return url;
    } // Retrieve URL for online interview

    public String getInterviewDate() {
        return interviewDate;
    } // Retrieve interview date

    public String getAccessingDate() {
        return accessingDate;
    } // Retrieve accessing date

    public boolean isOnline() {
        return online;
    } // Check if the interview is online.
}
