package com.jdb;


import com.jdb.events.CustomerDrivenMessage;
import com.jdb.tracks.Campaign;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Campaign activeCampaign;
    private List<Object> events;

    public Customer(){
        events = new ArrayList<Object>();
    }

    public Campaign getActiveCampaign() {
        return activeCampaign;
    }

    public void setActiveCampaign(Campaign activeCampaign) {
        this.activeCampaign = activeCampaign;
    }

    public List<Object> getEvents() {
        return events;
    }

    public void addEvent(CustomerDrivenMessage message) {
        events.add(message);
    }
}
