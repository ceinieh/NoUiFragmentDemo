package com.example.android.nouifragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyInivisibleFragment.MyCallback{
    private static final String TAG = "MainActivity_TAG_";
    private MyInivisibleFragment myInivisibleFragment;
    private static final String FRAGMENT_TAG = "MyInivisibleFragment";
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: " + "Main Activity");

        textView = (TextView) findViewById(R.id.a_main_textview);


        FragmentManager fm = getSupportFragmentManager();


        myInivisibleFragment = (MyInivisibleFragment) fm.findFragmentByTag(FRAGMENT_TAG);
        if (myInivisibleFragment == null) {
            myInivisibleFragment = new MyInivisibleFragment();
            fm.beginTransaction().add(myInivisibleFragment, FRAGMENT_TAG).commit();
    }

    }

    @Override
    public void sendMessage(String message) {
        Log.d(TAG, "sendMessage: " + message);
       textView.setText(message);
        Toast.makeText(this, "message", Toast.LENGTH_LONG).show();
    }
}
