package com.dualranger.tictactoe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by evanfaler on 4/13/17.
 */

public class Bottom_Fragment extends Fragment implements View.OnClickListener {
    private Button resetButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_area_fragment, container, false);

        resetButton = (Button) v.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        //Handle onClicks Here
        switch (v.getId()) {
            case R.id.reset_button:
                ((TicTacToe_Activity) getActivity()).clearGameBoard();
                break;
        }

    }
}
