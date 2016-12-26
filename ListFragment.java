package com.mac.fireflies.wgt.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    EditText editText;
    Button button;
    ListenerListFragment listener;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        editText = (EditText) view.findViewById(R.id.txt_list);
        button = (Button) view.findViewById(R.id.button_list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.setText(editText.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (ListenerListFragment) context;
        }catch (NoClassDefFoundError error){
            throw  new NoClassDefFoundError(error.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    interface ListenerListFragment{
        void setText(String text);
    }
}
