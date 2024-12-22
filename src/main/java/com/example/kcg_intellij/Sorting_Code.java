package com.example.kcg_intellij;

import java.util.ArrayList;
import com.example.kcg_intellij.PinyinTranslator;

import javax.print.DocFlavor.INPUT_STREAM;

public class Sorting_Code {

    public StringBuilder citationOutput = new StringBuilder();

    // Private ArrayList to store citation entries
    private ArrayList<String> citationEntries;

    // Constructor to initialize the ArrayList
    public Sorting_Code() {
        citationEntries = new ArrayList<>();
    }

    // Getter method that allows access to the ArrayList
    public ArrayList<String> getCitationEntries() {
        return citationEntries;
    }

    public void outputCitations(ArrayList<String> citations) { 
        citationEntries = bubbleSortCitations(citations); // Sort citations
        citationOutput.setLength(0);
        for (String entry : citationEntries) { // Output each sorted citation
            citationOutput.append(entry).append("\n\n");
        }
    }   

    public String getCitationOutput() {
        return citationOutput.toString();
    }

    public String generateBook(Book bookEntry) {
        String author = bookEntry.getAuthor();
        String title = bookEntry.getTitle();
        String otherAuthor = bookEntry.getOtherAuthor();
        String publishedPlace = bookEntry.getPublishedPlace();
        String publisher = bookEntry.getPublisher();
        int startingPageNumber = bookEntry.getStartingPageNumber();
        int endingPageNumber = bookEntry.getEndingPageNumber();
        String accessingDate = bookEntry.getAccessingDate();
        String url = bookEntry.getUrl();

        if (bookEntry.isOnline()) { // Check if the book is online
            if (bookEntry.hasOtherAuthor()) { // Check if there's another author
                return author + "." + title + "[M/OL]." + otherAuthor + "."
                        + publishedPlace + ":" + publisher + "," + startingPageNumber
                        + "-" + endingPageNumber + "[" + accessingDate + "]" + "." + url + ".";
            } else {
                return author + "." + title + "[M/OL]."
                        + publishedPlace + ":" + publisher + "," + startingPageNumber
                        + "-" + endingPageNumber + "[" + accessingDate + "]" + "." + url + ".";
            }
        } else { // Book is offline
            if (bookEntry.hasOtherAuthor()) { // Check if there's another author
                return author + "." + title + "[M]." + otherAuthor + "."
                        + publishedPlace + ":" + publisher + "," + startingPageNumber
                        + "-" + endingPageNumber + '.';
            } else {
                return author + "." + title + "[M]."
                        + publishedPlace + ":" + publisher + "," + startingPageNumber
                        + "-" + endingPageNumber + '.';
            }
        }
    }

    public String generateNewspaper(Newspaper NewspaperEntry) {
        String author = NewspaperEntry.getAuthor();
        String title = NewspaperEntry.getTitle();
        String publisher = NewspaperEntry.getPublisher();
        int publishedYear = NewspaperEntry.getPublishedYear();
        int volumeNumber = NewspaperEntry.getVolumeNumber();
        int issueNumber = NewspaperEntry.getIssueNumber();
        int startingPageNumber = NewspaperEntry.getStartingPageNumber();
        int endingPageNumber = NewspaperEntry.getEndingPageNumber();
        String accessingDate = NewspaperEntry.getAccessingDate();
        String url = NewspaperEntry.getUrl();

        if (NewspaperEntry.isOnline()) {
            if (NewspaperEntry.isPageApplicable()) {
                return author + "." + title + "[N/OL]." + publisher + "," + publishedYear
                        + "," + volumeNumber + "(" + issueNumber + ")" + ":" + startingPageNumber
                        + "-" + endingPageNumber + "[" + accessingDate + "]" + "." + url + ".";
            } else {
                return author + "." + title + "[N/OL]." + publisher + "," + publishedYear
                        + "," + volumeNumber + "(" + issueNumber + ")" + "[" + accessingDate + "]"
                        + "." + url + ".";
            }
        } else {
            if (NewspaperEntry.isPageApplicable()) {
                return author + "." + title + "[N]." + publisher + "," + publishedYear
                        + "," + volumeNumber + "(" + issueNumber + ")" + ":" + startingPageNumber
                        + "-" + endingPageNumber + ".";
            } else {
                return author + "." + title + "[N]." + publisher + "," + publishedYear
                        + "," + volumeNumber + "(" + issueNumber + ")"
                        + ".";
            }
        }
    }

    public String generateJournal(Journal JournalEntry) {
        String author = JournalEntry.getAuthor();
        String title = JournalEntry.getTitle();
        String publisher = JournalEntry.getPublisher();
        int publishedYear = JournalEntry.getPublishedYear();
        int volumeNumber = JournalEntry.getVolumeNumber();
        int issueNumber = JournalEntry.getIssueNumber();
        int startingPageNumber = JournalEntry.getStartingPageNumber();
        int endingPageNumber = JournalEntry.getEndingPageNumber();
        String accessingDate = JournalEntry.getAccessingDate();
        String url = JournalEntry.getUrl();

        if (JournalEntry.isOnline()) {
            if (JournalEntry.isPageApplicable()) {
                return author + "." + title + "[J/OL]." + publisher + "," + publishedYear
                        + "," + volumeNumber + "(" + issueNumber + ")" + ":" + startingPageNumber
                        + "-" + endingPageNumber + "[" + accessingDate + "]" + "." + url + ".";
            } else {
                return author + "." + title + "[J/OL]." + publisher + "," + publishedYear
                        + "," + volumeNumber + "(" + issueNumber + ")" + "[" + accessingDate + "]"
                        + "." + url + ".";
            }
        } else {
            if (JournalEntry.isPageApplicable()) {
                return author + "." + title + "[J]." + publisher + "," + publishedYear
                        + "," + volumeNumber + "(" + issueNumber + ")" + ":" + startingPageNumber
                        + "-" + endingPageNumber + ".";
            } else {
                return author + "." + title + "[J]." + publisher + "," + publishedYear
                        + "," + volumeNumber + "(" + issueNumber + ")"
                        + ".";
            }
        }
    }

    public String generateArticle(Article ArticleEntry) {
        String author = ArticleEntry.getAuthor();
        String title = ArticleEntry.getTitle();
        String publisher = ArticleEntry.getPublisher();
        int publishedYear = ArticleEntry.getPublishedYear();
        String publishedPlace = ArticleEntry.getPublishedPlace();
        String accessingDate = ArticleEntry.getAccessingDate();
        String url = ArticleEntry.getUrl();

        if (ArticleEntry.isOnline()) {
            return author + "." + title + "[D/OL]" + publishedPlace + ":" + publisher + ","
                    + publishedYear + "[" + accessingDate + "]" + "." + url + ".";
        } else {
            return author + "." + title + "[D]" + publishedPlace + ":" + publisher + ","
                    + publishedYear + ".";
        }
    }

    public String generateOnlineSources(OnlineSources OnlineSourcesEntry) {
        String author = OnlineSourcesEntry.getAuthor();
        String title = OnlineSourcesEntry.getTitle();
        String publisher = OnlineSourcesEntry.getPublisher();
        String publishedDate = OnlineSourcesEntry.getPublishedDate();
        String accessingDate = OnlineSourcesEntry.getAccessingDate();
        String url = OnlineSourcesEntry.getUrl();

        if (OnlineSourcesEntry.getSourceType() == "EB") {
            return author + "." + title + "[EB/OL]." + publisher + ",("
                    + publishedDate + ")" + "[" + accessingDate + "]" + "." + url + ".";
        } else if (OnlineSourcesEntry.getSourceType() == "DB") {
            return author + "." + title + "[DB/OL]." + publisher + ",("
                    + publishedDate + ")" + "[" + accessingDate + "]" + "." + url + ".";
        } else {
            return author + "." + title + "[Z/OL]." + publisher + ",("
                    + publishedDate + ")" + "[" + accessingDate + "]" + "." + url + ".";
        }
    }

    public String generateInterview(Interview InterviewEntry) {
        String interviewee = InterviewEntry.getInterviewee();
        String interviewer = InterviewEntry.getInterviewer();
        String title = InterviewEntry.getTitle();
        String publisher = InterviewEntry.getPublisher();
        String interviewDate = InterviewEntry.getInterviewDate();
        String accessingDate = InterviewEntry.getAccessingDate();
        String url = InterviewEntry.getUrl();

        if (InterviewEntry.isOnline()) {
            return interviewee + "." + title + "[Z/OL]." + interviewer + "." + publisher + ","
                    + interviewDate + "[" + accessingDate + "]." + url + ".";
        } else {
            return interviewee + "." + title + "[Z]." + interviewer + "." + publisher + ","
                    + interviewDate + ".";
        }
    }

    public String generateReport(Report ReportEntry) {
        String author = ReportEntry.getAuthor();
        String title = ReportEntry.getTitle();
        String publisher = ReportEntry.getPublisher();
        String PublishedDate = ReportEntry.getPublishedDate();
        String accessingDate = ReportEntry.getAccessingDate();
        String url = ReportEntry.getUrl();

        if (ReportEntry.isOnline()) {
            return author + "." + title + "[R/OL]." + publisher + "," + PublishedDate + "["
                    + accessingDate + "]." + url + ".";
        } else {
            return author + "." + title + "[R]." + publisher + "," + PublishedDate + ".";
        }
    }

    public ArrayList<String> bubbleSortCitations(ArrayList<String> citations) {
        int n = citations.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (PinyinTranslator.textToHanYuPinyin(citations.get(j)).compareToIgnoreCase(PinyinTranslator.textToHanYuPinyin(citations.get(j + 1))) > 0) {
                    // Swap citations[j] and citations[j+1]
                    String temp = citations.get(j);
                    citations.set(j, citations.get(j + 1));
                    citations.set(j + 1, temp);
                }
            }
        }
        return citations;
    }
}
