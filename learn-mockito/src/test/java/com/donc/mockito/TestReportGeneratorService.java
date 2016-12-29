package com.donc.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by donovan on 24/10/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestReportGeneratorService {

    @InjectMocks
    private ReportGeneratorService service;
    @Mock
    private IReportGenerator generator;
    @Captor
    private ArgumentCaptor<ReportEntity> reportCaptor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws Exception {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2016, 11, 25);
        Calendar endDate = Calendar.getInstance();
        endDate.set(9999, 12, 31);
        String reportContent = "Report Content";
        service.generateReport(startDate.getTime(), endDate.getTime(), reportContent.getBytes());
        Mockito.verify(generator).generateReport(reportCaptor.capture());
        ReportEntity report = reportCaptor.getValue();
        assertEquals(116, report.getStartDate().getYear());
        assertEquals(11, report.getStartDate().getMonth());
        assertEquals(25, report.getStartDate().getDate());
        assertEquals(8100, report.getEndDate().getYear());
        assertEquals(0, report.getEndDate().getMonth());
        assertEquals(31, report.getEndDate().getDate());
        assertEquals("Report Content", new String(report.getContent()));

    }
}
