package com.example.mobsoft.mobsoft.interactor;

import com.example.mobsoft.mobsoft.interactor.event.EventsInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

@Module
public class InteractorModule {

    @Provides
    public EventsInteractor provideEvents() {
        return new EventsInteractor();
    }

}
