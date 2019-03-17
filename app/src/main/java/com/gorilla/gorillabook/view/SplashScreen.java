package com.gorilla.gorillabook.view;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gorilla.gorillabook.R;
import com.gorilla.gorillabook.model.Feed;
import com.gorilla.gorillabook.viewModel.SplashViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashScreen extends Fragment implements SplashView{

    private SplashViewModel viewModel;


    public SplashScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new SplashViewModel(this);
        viewModel.getFeeds();
    }

    @Override
    public void onFeedLoadFinish(List<Feed> feeds) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        Bundle arguments = new Bundle();
        arguments.putParcelableArrayList( "FEEDS" , (ArrayList<? extends Parcelable>) feeds);

        FeedsScreen fragment = new FeedsScreen();
        fragment.setArguments(arguments);

        transaction.replace(R.id.content, fragment);
        transaction.commit();
    }
}
