package com.meridian.regreporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CounterpartySubscriber {

    private static final Logger log = LoggerFactory.getLogger(CounterpartySubscriber.class);

    @JmsListener(
        destination = "REFDATA.COUNTERPARTY",
        subscription = "REGREPORT_CPTY_SUB",
        containerFactory = "topicListenerFactory"
    )
    public void onCounterpartyUpdate(String counterpartyJson) {
        log.info("Received counterparty reference data update: {}", counterpartyJson);
        // Process counterparty updates for regulatory reporting
    }
}
