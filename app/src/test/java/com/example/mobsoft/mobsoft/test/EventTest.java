package com.example.mobsoft.mobsoft.test;

import com.example.mobsoft.mobsoft.BuildConfig;
import com.example.mobsoft.mobsoft.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft.ui.main.MainScreen;
import com.example.mobsoft.mobsoft.utils.RobolectricDaggerTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static com.example.mobsoft.mobsoft.TestHelper.setTestInjector;
import static com.google.common.base.Verify.verify;
import static org.junit.Assert.assertEquals;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class TodoTest {

    private MainPresenter mianPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mianPresenter = new MainPresenter();
    }

    @Test
    public void testTodo() {
        MainScreen mainScreen = mock(MainScreen.class);
        mianPresenter.attachScreen(mainScreen);
        mianPresenter.getEvents();

        ArgumentCaptor<String> eventsCaptor = ArgumentCaptor.forClass(String.class);
        verify(mainScreen, times(2)).showMessage(eventsCaptor.capture());

        List<String> capturedTodos = eventsCaptor.getAllValues();
        assertEquals("todo one", capturedTodos.get(0));
        assertEquals("todo two", capturedTodos.get(1));
    }

    @After
    public void tearDown() {
        mianPresenter.detachScreen();
    }
}