package com.gorilla.gorillabook.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gorilla.gorillabook.R;
import com.gorilla.gorillabook.model.Feed;

import java.util.ArrayList;
import java.util.List;

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
        Bundle arguments = getArguments();
        feeds = arguments.getParcelableArrayList("FEEDS");
        return inflater.inflate(R.layout.fragment_feeds_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*Feed feed1 = new Feed(0,
                "John Smith",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut gravida, velit non dignissim ultrices, nisi nisi scelerisque tortor, vitae laoreet justo magna nec justo. Phasellus vehicula ac magna quis mollis. Donec a augue iaculis, laoreet purus id, venenatis leo. Sed rutrum justo ut nunc egestas malesuada. Nam sit amet erat malesuada, dapibus orci tristique, porttitor turpis. Quisque et auctor sem, at efficitur lectus. Ut nisl diam, mattis et luctus vel, tincidunt elementum velit",
                14422444,
                null);
        Feed feed2 = new Feed(1,
                "John Smith",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut gravida, velit non dignissim ultrices, nisi nisi scelerisque tortor, vitae laoreet justo magna nec justo. Phasellus vehicula ac magna quis mollis. Donec a augue iaculis, laoreet purus id, venenatis leo. Sed rutrum justo ut nunc egestas malesuada. Nam sit amet erat malesuada, dapibus orci tristique, porttitor turpis. Quisque et auctor sem, at efficitur lectus. Ut nisl diam, mattis et luctus vel, tincidunt elementum velit",
                14422444,
                null);
        Feed feed3 = new Feed(2,
                "John Smith",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut gravida, velit non dignissim ultrices, nisi nisi scelerisque tortor, vitae laoreet justo magna nec justo. Phasellus vehicula ac magna quis mollis. Donec a augue iaculis, laoreet purus id, venenatis leo. Sed rutrum justo ut nunc egestas malesuada. Nam sit amet erat malesuada, dapibus orci tristique, porttitor turpis. Quisque et auctor sem, at efficitur lectus. Ut nisl diam, mattis et luctus vel, tincidunt elementum velit",
                14422444,
                null);
        Feed feed4 = new Feed(3,
                "John Smith",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut gravida, velit non dignissim ultrices, nisi nisi scelerisque tortor, vitae laoreet justo magna nec justo. Phasellus vehicula ac magna quis mollis. Donec a augue iaculis, laoreet purus id, venenatis leo. Sed rutrum justo ut nunc egestas malesuada. Nam sit amet erat malesuada, dapibus orci tristique, porttitor turpis. Quisque et auctor sem, at efficitur lectus. Ut nisl diam, mattis et luctus vel, tincidunt elementum velit",
                14422444,
                null);

        feeds = new ArrayList<>();
        feeds.add(feed1);
        feeds.add(feed2);
        feeds.add(feed3);
        feeds.add(feed4);*/

        feedRecyclerView = (RecyclerView) view.findViewById(R.id.feeds_recycler_view);
        feedAdapter = new FeedAdapter(feeds);
        feedRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        feedRecyclerView.setAdapter(feedAdapter);
    }
}
