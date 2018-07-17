package com.jdb.tracks;

import com.jdb.tracks.actions.Action;
import com.jdb.tracks.actions.EmailAction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrackTest {

    @Test
    public void shouldExecuteActionsIfTrackIsExecutable(){

        List<Action> actions = new ArrayList<Action>();
        actions.add(new EmailAction());

        new Track(actions);
    }

}