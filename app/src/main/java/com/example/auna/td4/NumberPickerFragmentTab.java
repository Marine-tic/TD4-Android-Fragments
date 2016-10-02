package com.example.auna.td4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Created by Auna on 02/10/2016.
 */

public class NumberPickerFragmentTab extends Fragment {
   private OnActionListener mCallback;
    private TextView mTextView;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.number_picker_fragment_tab, container, false);
    }

    // Container Activity must implement this interface
    public interface OnActionListener {
        void onAction(int number);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnActionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnActionListener");
        }
    }

    public void onNumberPickerClick(View v, int number) {
        // Send the event to the other fragment
        switch (v.getId()){
            case R.id.NumberPicker:
                mCallback.onAction(number);
                break;
        }
    }


}

