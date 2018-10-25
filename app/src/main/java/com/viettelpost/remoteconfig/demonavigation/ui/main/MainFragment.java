package com.viettelpost.remoteconfig.demonavigation.ui.main;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.viettelpost.remoteconfig.demonavigation.R;

import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private View view;
    private Button button, btnChild, btnDeepLink;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment, container, false);
        find();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_next));
        btnChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_navigation_child);
            }
        });

        btnDeepLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);

                PendingIntent pendingIntent = Navigation.findNavController(v).createDeepLink()
                        .setDestination(R.id.mainFragment)
                        .createPendingIntent();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        getContext(), "deeplink")
                        .setContentTitle(pendingIntent.toString())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);
                notificationManager.notify(0, builder.build());
            }
        });
    }

    private void find() {
        button = view.findViewById(R.id.button);
        btnChild = view.findViewById(R.id.view_group);
        btnDeepLink = view.findViewById(R.id.btn_deep);
    }

}
