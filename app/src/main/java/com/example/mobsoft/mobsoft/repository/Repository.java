package com.example.mobsoft.mobsoft.repository;

import android.content.Context;

import com.example.mobsoft.mobsoft.model.Event;
import com.example.mobsoft.mobsoft.model.User;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public interface Repository {

    void open(Context context);

    void close();

    List<Event> getAllEvents();

    List<User> getAllUsers();

    Event getEvent(Long id);

    User getUser(Long id);

    void save(Event e);

    void update(Event e);

    void remove(Event e);

    void save(User user);

    void update(User user);

    void remove(User user);

    boolean isInDB(Event event);

    boolean isInDB(User user);
}
