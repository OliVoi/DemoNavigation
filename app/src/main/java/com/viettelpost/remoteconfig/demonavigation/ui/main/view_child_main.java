package com.viettelpost.remoteconfig.demonavigation.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viettelpost.remoteconfig.demonavigation.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class view_child_main extends Fragment {


    public view_child_main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_child_main, container, false);
    }

}
