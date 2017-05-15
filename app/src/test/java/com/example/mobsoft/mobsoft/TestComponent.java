package com.example.mobsoft.mobsoft;

import com.example.mobsoft.mobsoft.interactor.InteractorModule;
import com.example.mobsoft.mobsoft.mock.MockNetworkModule;
import com.example.mobsoft.mobsoft.repository.TestRepositoryModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

@Singleton
@Module
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}