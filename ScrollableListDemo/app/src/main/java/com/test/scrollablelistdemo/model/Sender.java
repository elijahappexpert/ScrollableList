package com.test.scrollablelistdemo.model;

/**
 * Created by filippo on 19/02/2018.
 */

public class Sender extends User {

    public Sender(String firsName, String lastName, String userMessage) {
        super(firsName, lastName, userMessage);
    }

    @Override
    public int getUserType() {
        return 1;
    }
}
