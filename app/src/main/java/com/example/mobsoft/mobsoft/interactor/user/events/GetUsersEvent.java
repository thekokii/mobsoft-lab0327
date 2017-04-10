package com.example.mobsoft.mobsoft.interactor.user.events;

import com.example.mobsoft.mobsoft.model.User;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class GetUsersEvent {
    private int code;
    private List<User> users;
    private Throwable throwable;

    public GetUsersEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> u) {
        this.users = u;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
