package com.jdb.services;

import com.jdb.Customer;
import com.jdb.events.VehicleViewedEvent;
import com.jdb.repository.CustomerRepository;
import com.jdb.tracks.NewCustomerCampaign;
import com.jdb.tracks.Campaign;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CampaignManagementServiceTest {

    private UUID customerId;
    private UUID vehicleId;
    private Customer customer;
    private VehicleViewedEvent message;
    private CustomerRepository repository;
    private CampaignSelector campaignSelector;
    private Campaign campaign;

    @Before
    public void setUp() throws Exception {
        customerId = randomUUID();
        vehicleId = randomUUID();
        customer = new Customer();
        message = new VehicleViewedEvent(vehicleId, customerId);
        repository = mock(CustomerRepository.class);
        when(repository.findCustomerById(customerId)).thenReturn(customer);
        campaignSelector = mock(CampaignSelector.class);
        campaign = new NewCustomerCampaign();
        when(campaignSelector.getCampaign(customer, message)).thenReturn(campaign);
    }

    @Test
    public void shouldPlaceCustomerOnAnEmailTrackWhenNewVehicleHasBeenViewed(){

        CampaignManagementService service = new CampaignManagementService(repository, campaignSelector);
        service.processMessage(message);

        assertThat(customer.getActiveCampaign()).isEqualTo(campaign);
    }

    @Test
    public void shouldRegisterAllOfTheEventsThatACustomerSees(){
        CampaignManagementService service = new CampaignManagementService(repository, campaignSelector);
        service.processMessage(message);

        assertThat(customer.getEvents()).containsOnly(message);
    }

    @Test
    public void shouldRegisterAllOfTheEventsThatACustomerSeesThatisNotRegisteredToIt(){
        CampaignManagementService service = new CampaignManagementService(repository, campaignSelector);
        service.processMessage(new VehicleViewedEvent(randomUUID(), randomUUID()));

        assertThat(customer.getEvents()).isEmpty();
    }

}