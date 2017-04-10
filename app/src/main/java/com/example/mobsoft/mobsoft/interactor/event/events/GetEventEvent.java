package com.example.mobsoft.mobsoft.interactor.event.events;

import com.example.mobsoft.mobsoft.model.Event;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class GetEventEvent {
    private int code;
    private Event ev;
    private Throwable throwable;

    public GetEventEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Event getEvent() {
        return ev;
    }

    public void setEvents(Event ev) {
        this.ev = ev;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
