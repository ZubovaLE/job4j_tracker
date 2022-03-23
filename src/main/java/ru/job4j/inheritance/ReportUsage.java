package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        HtmlReport report = new HtmlReport();
        System.out.println(report.generate("Report's name", "Report's body"));
    }
}
