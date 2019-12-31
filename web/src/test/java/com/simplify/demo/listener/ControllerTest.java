package com.simplify.demo.listener;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


public class ControllerTest {
 
    @InjectMocks
    private DemoApplication demoApplication;

    @Mock
    private Send send;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestDemoApplication() throws java.io.IOException {
        String result = demoApplication.send("Hello World");
        assertEquals(result, "Hello World");
    }

 
}