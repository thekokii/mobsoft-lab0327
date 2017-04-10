package com.example.mobsoft.mobsoft.interactor.event;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.event.events.GetEventEvent;
import com.example.mobsoft.mobsoft.interactor.event.events.GetEventsEvent;
import com.example.mobsoft.mobsoft.interactor.event.events.RemoveEventEvent;
import com.example.mobsoft.mobsoft.interactor.event.events.SaveEventEvent;
import com.example.mobsoft.mobsoft.model.Event;
import com.example.mobsoft.mobsoft.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class EventsInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public EventsInteractor() {
        MobSoftApplication.injector.inject(this);
    }


    public void getEvents() {
        GetEventsEvent event = new GetEventsEvent();
        try {
            List<Event> events = repository.getAllEvents();
            event.setEvents(events);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getEvent(Long id) {
        GetEventEvent event = new GetEventEvent();
        try {
            Event ev = repository.getEvent(id);
            event.setEvents(ev);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveEvent(Event ev) {

        SaveEventEvent event = new SaveEventEvent();
        event.setEvent(ev);
        try {
            repository.save(ev);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateEvent(Event ev) {
        try {
            repository.update(ev);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeEvent(Event ev) {
        RemoveEventEvent event = new RemoveEventEvent();
        event.setEvent(ev);
        try {
            repository.remove(ev);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
