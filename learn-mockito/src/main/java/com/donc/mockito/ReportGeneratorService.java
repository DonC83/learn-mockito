package com.donc.mockito;

import java.util.Date;

/**
 * Created by donovan on 24/10/16.
 */
public class ReportGeneratorService {

    private IReportGenerator generator;

    public void generateReport(Date startDate, Date endDate, byte[] content) {
        ReportEntity report = new ReportEntity();
        report.setContent(content);
        report.setStartDate(startDate);
        report.setEndDate(endDate);
        generator.generateReport(report);
    }
}
