package com.mac.fireflies.wgt.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFragment.ListenerListFragment{
    TextView textView;
    ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.txt_main);

        listFragment = new ListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.layout, listFragment)
                .commit();
    }

    @Override
    public void setText(String text) {
        textView.setText(text);
    }
}
