package br.com.android.jhowcs.changebackground;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.com.android.jhowcs.changebackground.fragments.FragmentFour;
import br.com.android.jhowcs.changebackground.fragments.FragmentOne;
import br.com.android.jhowcs.changebackground.fragments.FragmentThree;
import br.com.android.jhowcs.changebackground.fragments.FragmentTwo;

/**
 * Created by jonathan_campos on 05/02/2016.
 */
public class SecondActivity extends FragmentActivity implements View.OnClickListener {

    private Button btnFragment1;
    private Button btnFragment2;
    private Button btnFragment3;
    private Button btnFragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        btnFragment1 = (Button) findViewById(R.id.btnFragment1);
        btnFragment2 = (Button) findViewById(R.id.btnFragment2);
        btnFragment3 = (Button) findViewById(R.id.btnFragment3);
        btnFragment4 = (Button) findViewById(R.id.btnFragment4);

        btnFragment1.setOnClickListener(this);
        btnFragment2.setOnClickListener(this);
        btnFragment3.setOnClickListener(this);
        btnFragment4.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        Log.i(getClass().getCanonicalName().toString(), "Second has started!");

        super.onStart();
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.btnFragment1:
                ft.add(R.id.second_activity_placeholder, new FragmentOne());
                break;
            case R.id.btnFragment2:
                ft.replace(R.id.second_activity_placeholder, new FragmentTwo());
                break;
            case R.id.btnFragment3:
                ft.replace(R.id.second_activity_placeholder, new FragmentThree());
                break;
            case R.id.btnFragment4:
                ft.replace(R.id.second_activity_placeholder, new FragmentFour());
                break;
            default:
        }

        ft.commit();
    }
}
