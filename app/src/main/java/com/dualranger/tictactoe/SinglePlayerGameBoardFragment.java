package com.dualranger.tictactoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by evanfaler on 4/27/17.
 */

public class SinglePlayerGameBoardFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_board, container, false);

        return v;
    }

    @Override
    public void onClick(View v) {
    }


}
