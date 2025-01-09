package com.example.kcg_intellij;

import java.util.ArrayList;

public class Sorting_Code {

    public StringBuilder citationOutput = new StringBuilder();

    // Private ArrayList to store citation entries
    // This ArrayList will hold all the citation strings for sorting and retrieval.
    ArrayList<String> citationEntries;

    // Constructor to initialize the ArrayList
    // The constructor is private to restrict instantiation of the class from outside.
    private Sorting_Code() {
        // Initialize the citationEntries ArrayList.
        citationEntries = new ArrayList<>();
    }

    // Static instance of the Sorting_Code class
    private static Sorting_Code sortingCode = new Sorting_Code();

    // Public method to retrieve the single instance of Sorting_Code
    public static Sorting_Code getSortingCode() {
        return sortingCode;
    }

    // Public getter method that provides access to the sorted ArrayList of citations
    public ArrayList<String> getCitationEntries() {
        // Return the sorted list of citation entries.
        return bubbleSortCitations(citationEntries);
    }

    // Outputs a sorted list of citations by appending them to a StringBuilder.
    // Each citation is numbered and separated by double newlines.
    public void outputCitations(ArrayList<String> citations) { 
        citationEntries = bubbleSortCitations(citations); // Sort citations
        citationOutput.setLength(0);
        int i = 1;
        for (String entry : citationEntries) { // Output each sorted citation
            citationOutput.append("["+ i +"] ").append(entry).append("\n\n");
            i ++;
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

        if (OnlineSourcesEntry.getSourceType().equals("EB")) {
            return author + "." + title + "[EB/OL]." + publisher + ",("
                    + publishedDate + ")" + "[" + accessingDate + "]" + "." + url + ".";
        } else if (OnlineSourcesEntry.getSourceType().equals("DB")) {
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

    /**
     * INPUT: citations An ArrayList of citation strings to be sorted.
     * OUTPUT: The sorted ArrayList of citation strings.
     */
    public ArrayList<String> bubbleSortCitations(ArrayList<String> citations) {
        // Get the number of elements in the citations list.
        int n = citations.size();

        // Outer loop runs for n-1 passes over the list to ensure sorting.
        for (int i = 0; i < n - 1; i++) {
            // Inner loop iterates through the unsorted portion of the list.
            for (int j = 0; j < n - i - 1; j++) {
                // Convert both citations[j] and citations[j+1] to HanYu Pinyin
                // for lexicographical comparison.
                if (PinyinTranslator.textToHanYuPinyin(citations.get(j))
                        .compareToIgnoreCase(PinyinTranslator.textToHanYuPinyin(citations.get(j + 1))) > 0) {
                    // If citations[j] is greater than citations[j+1], swap them.

                    // Temporarily store citations[j] in a variable.
                    String temp = citations.get(j);
                    // Replace citations[j] with citations[j+1].
                    citations.set(j, citations.get(j + 1));
                    // Place the temporary value (original citations[j]) in citations[j+1].
                    citations.set(j + 1, temp);
                }
            }
        }

        // Return the sorted list of citations.
        return citations;
    }

}
