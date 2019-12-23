package com.app;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimelineTest {

    @Test
    public void setFetchCount() {
        Timeline timeline = new Timeline(); int expected = 5;
        timeline.setFetchCount( expected ); int actual = timeline.getFetchCount();
        assertEquals( expected, actual );
    }
}