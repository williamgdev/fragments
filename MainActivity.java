package com.mac.fireflies.wgt.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFragment.ListenerListFragment,
        DetaillFragment.OnFragmentInteractionListener {
    TextView textView;
    ListFragment listFragment;
    DetaillFragment detaillFragment;
    private String TAG = "MainActivity => ";
    Layout layoutList, layoutDetaill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.txt_main);

        if (getSupportFragmentManager().findFragmentByTag("listFragment") == null) {
            listFragment = new ListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.layout, listFragment, "listFragment")
                    .commit();
        }
        if (getSupportFragmentManager().findFragmentByTag("detaillFragment") == null) {
            detaillFragment = new DetaillFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.layout_detaill, detaillFragment, "detaillFragment")
                    .addToBackStack(null)
                    .commit();
        }
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void setText(String text) {
        textView.setText(text);
    }

    @Override
    public void onFragmentInteraction(int element) {
        switch (element){
            case 1:
                textView.setText("We are recieving data from DetaillFragment");
                break;
        }
    }
}
