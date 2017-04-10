package com.example.mobsoft.mobsoft.interactor.event.events;

import com.example.mobsoft.mobsoft.model.Event;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class GetEventsEvent {
    private int code;
    private List<Event> events;
    private Throwable throwable;

    public GetEventsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Event> getEvent() {
        return events;
    }

    public void setEvents(List<Event> evs) {
        this.events = evs;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
