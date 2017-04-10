package com.example.mobsoft.mobsoft.interactor.user.events;

import com.example.mobsoft.mobsoft.model.Event;
import com.example.mobsoft.mobsoft.model.User;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class GetUserEvent {
    private int code;
    private User user;
    private Throwable throwable;

    public GetUserEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User u) {
        this.user = user;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
