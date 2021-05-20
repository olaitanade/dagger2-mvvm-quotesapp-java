package com.vastinc.daggerquotesapp.ui.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vastinc.daggerquotesapp.R;
import com.vastinc.daggerquotesapp.data.remote.model.Quote;
import com.vastinc.daggerquotesapp.ui.MainActivity;
import com.vastinc.daggerquotesapp.util.Resource;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    TextView quoteId;
    TextView quote;
    TextView author;
    Button refresh;
    @Inject
    HomeViewModel mViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        quoteId = rootView.findViewById(R.id.quoteid);
        quote = rootView.findViewById(R.id.quote);
        author = rootView.findViewById(R.id.author);
        refresh = rootView.findViewById(R.id.refresh);
        refresh.setOnClickListener(v -> mViewModel.getRandomQuote("en"));
        observers();
        mViewModel.getRandomQuote("en");
        return rootView;
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        ((MainActivity) getActivity()).mainComponent.inject(this);
    }

    void observers(){
        mViewModel.observeRandomQuote().observe(getViewLifecycleOwner(), quoteResource -> {
            if(quoteResource!=null){
                switch (quoteResource.status){
                    case LOADING:
                        String loading = "loading..";
                        author.setText(loading);
                        quote.setText(loading);
                        quoteId.setText(loading);
                        break;
                    case SUCCESS:
                        author.setText(quoteResource.data.getAuthor());
                        quote.setText(quoteResource.data.getText());
                        quoteId.setText("UUID : "+ quoteResource.data.getUuid());
                        Log.d(TAG, "onChanged: successful => "+quoteResource.data.toString());
                        break;
                    case ERROR:
                        break;
                }
            }
        });
    }

}