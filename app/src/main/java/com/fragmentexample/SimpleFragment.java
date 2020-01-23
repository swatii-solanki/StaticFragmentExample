package com.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SimpleFragment extends Fragment {

    private static final int YES = 0;
    private static final int NO = 1;
    private String string="";
    public SimpleFragment() {
        // Required empty public constructor
    }
    public  static  SimpleFragment newInstance(){
        return new SimpleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_simple, container, false);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            View radiobutton = radioGroup.findViewById(checkedId);
            int index = radioGroup.indexOfChild(radiobutton);
            TextView textView = view.findViewById(R.id.fragment_header);
            switch (index) {
                case YES:
                    textView.setText("Yes");
                    break;
                case NO:
                    textView.setText("No");
                    break;
                default:
                    break;

            }

        });

        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> Toast.makeText(getContext(),String.valueOf(ratingBar1.getRating()),Toast.LENGTH_SHORT).show());
        return view;

    }


}
