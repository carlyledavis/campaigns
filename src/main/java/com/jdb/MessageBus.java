package com.jdb;

import com.jdb.events.CustomerDrivenMessage;
import com.jdb.messaging.Listener;

import java.util.ArrayList;
import java.util.List;

public class MessageBus {

    private List<Listener> listeners;

    public MessageBus() {
        listeners = new ArrayList<Listener>();
    }

    public void publish(CustomerDrivenMessage message) {
        for(Listener listener : listeners ){
            listener.processMessage(message);
        }
    }

    public void register(Listener service) {
        listeners.add(service);
    }
}
