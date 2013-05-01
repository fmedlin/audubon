package com.twotoasters.audubon;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.equalTo;

import java.net.URI;

import org.apache.http.client.methods.HttpUriRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class) public class MainActivityTest {

    MainActivity activity;

    @Before public void setUp() throws Exception {
		Robolectric.setDefaultHttpResponse(200, "OK");
        activity = new MainActivity();
        activity.onCreate(null);
    }

    @Test public void itShouldNotBeNull() {
    	assertNotNull(activity);
    }

    @Test public void itShouldDiscoverApis() {
    	URI uri = ((HttpUriRequest) Robolectric.getSentHttpRequest(0)).getURI();
    	assertThat(uri, equalTo(URI.create("https://www.googleapis.com/discovery/v1/apis")));
    }
}