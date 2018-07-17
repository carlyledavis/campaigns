package com.jdb.services;

import com.jdb.Customer;
import com.jdb.MessageBus;
import com.jdb.events.CustomerDrivenMessage;
import com.jdb.messaging.Listener;
import com.jdb.repository.CustomerRepository;
import com.jdb.tracks.Campaign;

public class CampaignManagementService implements Listener{
    private MessageBus messageBus;
    private CustomerRepository repository;
    private CampaignSelector campaignSelector;

    public CampaignManagementService() {
    }

    public CampaignManagementService(MessageBus messageBus) {
        this.messageBus = messageBus;
        this.messageBus.register(this);
    }

    public CampaignManagementService(CustomerRepository repository, CampaignSelector campaignSelector) {
        this.repository = repository;
        this.campaignSelector = campaignSelector;
    }

    public void processMessage(CustomerDrivenMessage message) {
        Customer customer = repository.findCustomerById(message.getCustomerId());
        Campaign campaign = campaignSelector.getCampaign(customer, message);

        if(customer != null ) {
            customer.addEvent(message);
            customer.setActiveCampaign(campaign);
        }
    }
}
