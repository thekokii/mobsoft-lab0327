package com.example.mobsoft.mobsoft.interactor.user.events;

import com.example.mobsoft.mobsoft.model.Event;
import com.example.mobsoft.mobsoft.model.User;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class SaveUserEvent {
    private int code;
    private User user;
    private Throwable throwable;

    public SaveUserEvent() {
    }

    public SaveUserEvent(int code, User user, Throwable throwable) {
        this.code = code;
        this.user = user;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getEvent() {
        return user;
    }

    public void setEvent(User user) {
        this.user = user;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
