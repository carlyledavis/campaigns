package com.jdb.tracks;

import org.junit.Test;

import static java.util.Arrays.asList;

public class NewCustomerCampaignTest {

    @Test
    public void shouldAddTracksToACampaign(){
        NewCustomerCampaign campaign = new NewCustomerCampaign(asList(new Track()));
    }

}