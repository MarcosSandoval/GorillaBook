package com.gorilla.gorillabook.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.gorilla.gorillabook.R;
import com.gorilla.gorillabook.viewModel.ComposeViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComposeScreen extends Fragment implements ComposeView{

    private EditText compositionEditText;
    private TextView textCounter;
    private ComposeViewModel viewModel;

    public ComposeScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compose_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ComposeViewModel(this);

        compositionEditText = getActivity().findViewById(R.id.gorilla_composer);
        textCounter = getActivity().findViewById(R.id.counter);
        compositionEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.validatePostSize(compositionEditText.getText().length());
            }
        });
    }

    @Override
    public void updateCounterMessage(String message) {
        textCounter.setText(message);
    }
}
