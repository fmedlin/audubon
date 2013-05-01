package com.twotoasters.audubon;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.twotoasters.android.hoot.Hoot;

public class MainActivity extends Activity {

    private static String TAG = "Audubon";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        discoverApis();
    }

    public void discoverApis() {
        Hoot.createInstanceWithBaseUrl("https://www.googleapis.com/discovery/v1/")
                .createRequest()
                .setResource("apis")
                .get()
                .execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

