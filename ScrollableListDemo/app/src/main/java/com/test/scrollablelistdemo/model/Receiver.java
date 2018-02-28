package com.test.scrollablelistdemo.model;

/**
 * Created by filippo on 19/02/2018.
 */

public class Receiver extends User {

    public Receiver(String firsName, String lastName, String userMessage) {
        super(firsName, lastName, userMessage);
    }

    @Override
    public int getUserType() {
        return 0;
    }
}
