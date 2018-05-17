package com.example.akashravi.vriksha;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */



public class MenuFragment extends Fragment {

    public MenuFragment() {
        // Required empty public constructor

    }
    //private Button home_buy,prdt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view=null;
        view=inflater.inflate(R.layout.fragment_home, container, false);
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

}
