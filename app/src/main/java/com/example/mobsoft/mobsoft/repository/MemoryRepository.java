package com.example.mobsoft.mobsoft.repository;

import android.content.Context;

import com.example.mobsoft.mobsoft.model.Event;
import com.example.mobsoft.mobsoft.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class MemoryRepository implements Repository {

    private static final long MINUTE = 60 * 1000;

    public static List<Event> events;
    public static List<User> users;

    @Override
    public void open(Context context) {
        Event event1 = new Event((long) 1, "Event1", new Date(), "Street1", "Description1", "1,1");
        Event event2 = new Event((long) 2, "Event2", new Date(), "Street2", "Description2", "2,2");

        events = new ArrayList<>();
        events.add(event1);
        events.add(event1);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Event> getAllEvents() {
        return events;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public Event getEvent(Long id) {

        for(Event e : events){
            if(e.getId().equals(id)) return e;
        }

        return null;
    }

    @Override
    public User getUser(Long id) {

        for(User u : users){
            if(u.getId().equals(id)) return u;
        }

        return null;
    }

    @Override
    public void save(Event e) {
        events.add(e);
    }

    @Override
    public void update(Event e) {

        for (int i = 0; i < this.events.size(); i++) {
            if(events.get(i).getId().equals(e.getId())) this.events.set(i, e);
        }
    }

    @Override
    public void remove(Event e) {
        events.remove(e);
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {

        for (int i = 0; i < this.users.size(); i++) {
            if(users.get(i).getId().equals(user.getId())) this.users.set(i, user);
        }
    }

    @Override
    public void remove(User user) {
        users.remove(user);
    }

    @Override
    public boolean isInDB(Event e) {
        return events.contains(e);
    }

    @Override
    public boolean isInDB(User user) {
        return false;
    }
}
