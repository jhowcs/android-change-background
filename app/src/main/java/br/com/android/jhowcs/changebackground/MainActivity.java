package br.com.android.jhowcs.changebackground;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Android example of how to schedule a background color change based
 * on a specific time using Runnable and Handler to do the job.
 *
 * Created by jonathan_campos on 05/02/2016.
 *
 */
public class MainActivity extends Activity {

    private Handler mHandler;
    private Runnable mRunnable;

    private RelativeLayout rlvBackground;

    private final int[] bgColors = {R.color.blue,
                                    R.color.green,
                                    R.color.purple,
                                    R.color.red};

    private int bgCount = 0;

    private Button btnSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlvBackground = (RelativeLayout) findViewById(R.id.rlvBackground);
        btnSecond     = (Button) findViewById(R.id.btnSecond);

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


        mRunnable = new Runnable() {
            @Override
            public void run() {
                bgCount++;

                if(bgCount > 3) {
                    bgCount = 0;
                }

                rlvBackground.setBackgroundResource(bgColors[bgCount]);

                /**
                 * You can think: Why this guy put a Toast here?
                 * And I going to answers you: I put this toast here to demonstrate
                 * that if you don't call "mHandler.removeCallbacks(mRunnable);" on onPause
                 * method your mRunnable will still working...
                 */
                Toast.makeText(MainActivity.this, "TESTE", Toast.LENGTH_SHORT).show();

                mHandler.postDelayed(this, 5000);
            }
        };

        mHandler = new Handler();


        startBgAnimation();

    }

    private void startBgAnimation() {
        mHandler.post(mRunnable);
    }


    /**
     * Hey man, don't forget to call the removeCallbacks method from Handler,
     * otherwise the runnable will be working on the background;
     */
    @Override
    protected void onPause() {
        Log.i(getClass().getCanonicalName().toString(), "Paused!");

        mHandler.removeCallbacks(mRunnable);

        super.onPause();
    }

    /**
     * Now that the Activity is visible(executing, on the top...) you can
     * continue changing your background again
     */
    @Override
    protected void onRestart() {
        startBgAnimation();

        super.onRestart();
    }
}
