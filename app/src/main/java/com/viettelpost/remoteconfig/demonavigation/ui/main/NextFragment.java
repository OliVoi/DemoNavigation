package com.viettelpost.remoteconfig.demonavigation.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.support.annotation.Dimension;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.viettelpost.remoteconfig.demonavigation.R;

import androidx.navigation.Navigation;

public class NextFragment extends Fragment {

    private Button btnRun;
    private View view;
    private EditText editText;


    public NextFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_next, container, false);
        btnRun = view.findViewById(R.id.btn_run);
        editText = view.findViewById(R.id.editText);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name", editText.getText().toString());
                Navigation.findNavController(v).navigate(R.id.go_to_view_name, bundle);

            }
        });
    }
}
