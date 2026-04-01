package com.meridian.regreporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReportPublisher {

    private static final Logger log = LoggerFactory.getLogger(ReportPublisher.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void submitReport(String reportJson) {
        log.info("Submitting regulatory report to REG.REPORT.SUBMIT");
        jmsTemplate.convertAndSend("REG.REPORT.SUBMIT", reportJson);
    }
}
