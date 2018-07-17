package com.jdb.tracks.actions;


import com.jdb.Customer;

public class EmailAction extends Action{
    public void execute(Customer customer) {

    }

    public boolean canExecute(Object Message) {
        return false;
    }

    public boolean canExit(Object message) {
        return false;
    }
}
