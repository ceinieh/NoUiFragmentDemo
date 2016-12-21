package com.example.android.nouifragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;


/**
 * Created by Chaker on 12/20/2016.
 */

public class MyInivisibleFragment extends Fragment {
    private static final String TAG = "Invisible Fragment_TAG_";
    private MyCallback  iNoUiFragment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Log.d(TAG, "onCreate: ");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
        iNoUiFragment = (MyCallback) getActivity();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
        iNoUiFragment.sendMessage("This is my invisible fragment");

    }

    public interface MyCallback{
        void sendMessage(String message);
    }
}
