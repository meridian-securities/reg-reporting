package com.meridian.regreporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Cross-QM subscriber for settlement status updates.
 * The SETTLE.STATUS topic originates from QM_SETTLE but is received
 * via the cross-QM channel on QM_REFDATA.
 */
@Component
public class StatusSubscriber {

    private static final Logger log = LoggerFactory.getLogger(StatusSubscriber.class);

    @JmsListener(
        destination = "SETTLE.STATUS",
        subscription = "REGREPORT_STATUS_SUB",
        containerFactory = "topicListenerFactory"
    )
    public void onSettlementStatus(String statusJson) {
        log.info("Received settlement status update (cross-QM from QM_SETTLE): {}", statusJson);
        // Process settlement status for regulatory reporting
    }
}
