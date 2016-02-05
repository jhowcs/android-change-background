package br.com.android.jhowcs.changebackground;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by jonathan_campos on 05/02/2016.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
    }

    @Override
    protected void onStart() {
        Log.i(getClass().getCanonicalName().toString(), "Second has started!");

        super.onStart();
    }
}
