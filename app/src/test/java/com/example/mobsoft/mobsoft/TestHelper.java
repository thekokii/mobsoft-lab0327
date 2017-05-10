package com.example.mobsoft.mobsoft;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        MobSoftApplication application = (MobSoftApplication) RuntimeEnvironment.application;
        MobSoftApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.setInjector(injector);
    }
}