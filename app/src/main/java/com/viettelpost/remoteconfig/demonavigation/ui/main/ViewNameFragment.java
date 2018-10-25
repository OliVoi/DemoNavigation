package com.viettelpost.remoteconfig.demonavigation.ui.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.viettelpost.remoteconfig.demonavigation.R;

import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class ViewNameFragment extends Fragment {

    private View view;
    private TextView textView;

    public ViewNameFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_view_name, container, false);
        textView = view.findViewById(R.id.view_name);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String getName = String.valueOf(getArguments().getString("name"));
        textView.setText(getName);
    }
}
