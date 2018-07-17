package com.jdb.tracks;

import java.util.List;

public class NewCustomerCampaign implements Campaign {

    private List<Track> tracks;

    public NewCustomerCampaign(List<Track> tracks) {
        this.tracks = tracks;
    }
}
