package com.gorilla.gorillabook.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gorilla.gorillabook.R;
import com.gorilla.gorillabook.model.Feed;

import java.util.ArrayList;
import java.util.List;

import static com.gorilla.gorillabook.util.Constants.FEEDS_ARGUMENT;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedsScreen extends Fragment {

    private RecyclerView feedRecyclerView;
    private FeedAdapter feedAdapter;
    private List<Feed> feeds;


    public FeedsScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feeds_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().findViewById(R.id.toolbar).setVisibility(View.VISIBLE);

        feedRecyclerView = view.findViewById(R.id.feeds_recycler_view);
       if(getArguments() != null){
           Bundle arguments = getArguments();
           feeds = arguments.getParcelableArrayList(FEEDS_ARGUMENT);
       }
        feedAdapter = new FeedAdapter(feeds, this);
        feedRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        feedRecyclerView.setAdapter(feedAdapter);
    }
}
