package com.example.mobsoft.mobsoft.network.event;

/**
 * Created by mobsoft on 2017. 04. 24..
 */



import com.example.mobsoft.mobsoft.model.Event;



import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EventApi {

    /**
     * Get details of a concrete event
     *
     * @param id Passing the Id of the event
     * @return Call<Event>
     */

    @GET("event/")
    Call<Event> eventGet(
            @Query("id") BigDecimal id
    );


    /**
     * Respond to event.
     *
     * @param id Passing the Id of the event
     * @param respond Passing the respond to the event
     * @return Call<Void>
     */

    @POST("event/respond")
    Call<Void> eventRespondPost(
            @Query("id") BigDecimal id, @Query("respond") BigDecimal respond
    );


    /**
     * Get event list
     *
     * @return Call<List<Event>>
     */

    @GET("events")
    Call<List<Event>> eventsGet();



    /**
     * Create an event
     *
     * @param event Creates an event and adds to database.
     * @return Call<Void>
     */

    @POST("events/create")
    Call<Void> eventsCreatePost(
            @Body Event event
    );


}
