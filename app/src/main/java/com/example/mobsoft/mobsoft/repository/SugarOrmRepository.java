package com.example.mobsoft.mobsoft.repository;

import android.content.Context;

import com.example.mobsoft.mobsoft.model.Event;
import com.example.mobsoft.mobsoft.model.User;

import com.orm.SugarContext;
import com.orm.SugarRecord;
import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Event> getAllEvents() {
        return SugarRecord.listAll(Event.class);
    }

    @Override
    public List<User> getAllUsers() {
        return SugarRecord.listAll(User.class);
    }

    @Override
    public Event getEvent(Long id) {
        return SugarRecord.findById(Event.class, id);
    }

    @Override
    public User getUser(Long id) {
        return SugarRecord.findById(User.class, id);
    }

    @Override
    public void save(Event e) {
        SugarRecord.saveInTx(e);
    }

    @Override
    public void update(Event e) {
        Event eventToUpdate = getEvent(e.getId());

        eventToUpdate.setAddress(e.getAddress());
        eventToUpdate.setCoordinates(e.getCoordinates());
        eventToUpdate.setDate(e.getDate());
        eventToUpdate.setDescription(e.getDescription());
        eventToUpdate.setTitle(e.getTitle());

        SugarRecord.saveInTx(eventToUpdate);
    }

    @Override
    public void remove(Event e) {
        SugarRecord.deleteInTx(e);
    }

    @Override
    public void save(User user) {
        SugarRecord.saveInTx(user);
    }

    @Override
    public void update(User user) {
        User userToUpdate = getUser(user.getId());

        userToUpdate.setPhone(user.getPhone());
        userToUpdate.setUsername(user.getUsername());

        SugarRecord.saveInTx(userToUpdate);
    }

    @Override
    public void remove(User user) {
        SugarRecord.deleteInTx(user);
    }

    @Override
    public boolean isInDB(Event event) {
        return SugarRecord.findById(Event.class, event.getId()) != null;
    }

    @Override
    public boolean isInDB(User user) {
        return SugarRecord.findById(User.class, user.getId()) != null;
    }
}
