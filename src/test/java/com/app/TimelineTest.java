package com.app;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TimelineTest {

    private final static int NEW_FETCH_COUNT = new Timeline().getFetchCount() + 1;

    private Timeline timeline;

    @Before
    public void setUp() {
        timeline = new Timeline();
    }

    @Test
    public void setFetchCount() {
        Timeline timeline = new Timeline(); int expected = 5;
        timeline.setFetchCount( expected ); int actual = timeline.getFetchCount();
        assertEquals( expected, actual );
    }

    @Test
    public void initialState() {
        assertTrue( timeline.getFetchCount() > 0 );
    }

    @After
    public void tearDown() {
        timeline.dispose();
    }
}