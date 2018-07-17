package com.jdb.events;

import java.util.UUID;

public class VehicleViewedEvent extends CustomerDrivenMessage{
    UUID customerId;
    UUID vehicleId;

    public VehicleViewedEvent() {
    }

    public VehicleViewedEvent(UUID vehicleId, UUID customerId) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public UUID getCustomerId() {

        return customerId;
    }
}
