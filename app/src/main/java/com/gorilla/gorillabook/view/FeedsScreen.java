package com.gorilla.gorillabook.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gorilla.gorillabook.R;
import com.gorilla.gorillabook.viewModel.FeedsViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedsScreen extends Fragment implements FeedsView{

    private RecyclerView feedRecyclerView;
    private FeedAdapter feedAdapter;
    private FeedsViewModel viewModel;
    private EditText composeEditText;


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

        composeEditText = getActivity().findViewById(R.id.compose);

        //getting the toolbar
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();

        //placing toolbar in place of actionbar
        activity.setSupportActionBar(toolbar);

        viewModel = new FeedsViewModel(this);

        feedRecyclerView = view.findViewById(R.id.feeds_recycler_view);
        feedAdapter = new FeedAdapter(viewModel.getFeeds(), this);
        feedRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        feedRecyclerView.setAdapter(feedAdapter);

        composeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean isFocused) {
                if(isFocused){
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content, new ComposeScreen());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }
}
