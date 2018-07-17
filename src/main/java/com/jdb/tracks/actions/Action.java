package com.jdb.tracks.actions;

import com.jdb.Customer;
import com.jdb.events.CustomerDrivenMessage;
import com.jdb.tracks.Activatable;

public abstract class Action implements Activatable{
    abstract void execute(Customer customer, CustomerDrivenMessage message );
}
