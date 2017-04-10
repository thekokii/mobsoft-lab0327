package com.example.mobsoft.mobsoft.interactor.event.events;

import com.example.mobsoft.mobsoft.model.Event;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class SaveEventEvent {
    private int code;
    private Event e;
    private Throwable throwable;

    public SaveEventEvent() {
    }

    public SaveEventEvent(int code, Event e, Throwable throwable) {
        this.code = code;
        this.e = e;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Event getEvent() {
        return e;
    }

    public void setEvent(Event e) {
        this.e = e;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
