package com.mac.fireflies.wgt.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
    private String TAG = "ListFragment => ";

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
        Log.d(TAG, "onCreateView: ");
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
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
        Log.d(TAG, "onDetach: ");
    }

    interface ListenerListFragment{
        void setText(String text);
    }
}
