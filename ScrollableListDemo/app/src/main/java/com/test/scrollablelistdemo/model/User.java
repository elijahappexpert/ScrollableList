package com.test.scrollablelistdemo.model;

/**
 * Created by filippo on 19/02/2018.
 */

public abstract class User {

    //common properties for sender and receiver

    private String mFirstName;
    private String mLastName;
    private String mUserMessage;

    public User(String firsName, String lastName, String userMessage) {
        mFirstName = firsName;
        mLastName = lastName;
        mUserMessage = userMessage;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getUserMessage() {
        return mUserMessage;
    }

    public abstract int getUserType();
}
