package com.jdb.tracks;

import com.jdb.events.VehicleViewedEvent;
import com.jdb.tracks.actions.Action;
import com.jdb.tracks.actions.EmailAction;

import java.util.List;

public class Track implements Activatable, Exitable {

    private List<Action> actions;

    public Track(List<Action> actions) {
        this.actions = actions;
    }

    public boolean canExecute(Object Message) {
        return Message.getClass().equals(VehicleViewedEvent.class);
    }

    public boolean canExit(Object message) {
        return true;
    }
}
