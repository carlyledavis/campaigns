package com.jdb.messaging;

import com.jdb.events.CustomerDrivenMessage;

public interface Listener {
    void processMessage(CustomerDrivenMessage message);
}
