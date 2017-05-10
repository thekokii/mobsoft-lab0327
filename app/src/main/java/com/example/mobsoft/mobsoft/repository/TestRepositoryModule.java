package com.example.mobsoft.mobsoft.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Koki on  010 - 2017 May 10.
 */

@Module
public class TestRepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }
}