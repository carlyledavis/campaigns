package com.jdb;

import com.jdb.events.VehicleViewedEvent;
import com.jdb.messaging.Listener;
import com.jdb.services.CampaignManagementService;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MessageBusTest {

    @Test
    public void shouldInvokeCustomerServiceProcessEventMethod(){
        MessageBus messageBus = new MessageBus();
        Listener listener = mock(CampaignManagementService.class);
        messageBus.register(listener);

        VehicleViewedEvent message = new VehicleViewedEvent();
        messageBus.publish(message);

        verify(listener).processMessage(message);
    }

}