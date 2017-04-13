package com.dualranger.tictactoe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TicTacToe_Fragment extends Fragment implements View.OnClickListener {
    private DrawView space1;
    private DrawView space2;
    private DrawView space3;
    private DrawView space4;
    private DrawView space5;
    private DrawView space6;
    private DrawView space7;
    private DrawView space8;
    private DrawView space9;
    int alternateShape = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_board, container, false);

        space1 = (DrawView) v.findViewById(R.id.space_1);
        space1.setOnClickListener(this);
        space2 = (DrawView) v.findViewById(R.id.space_2);
        space2.setOnClickListener(this);
        space3 = (DrawView) v.findViewById(R.id.space_3);
        space3.setOnClickListener(this);
        space4 = (DrawView) v.findViewById(R.id.space_4);
        space4.setOnClickListener(this);
        space5 = (DrawView) v.findViewById(R.id.space_5);
        space5.setOnClickListener(this);
        space6 = (DrawView) v.findViewById(R.id.space_6);
        space6.setOnClickListener(this);
        space7 = (DrawView) v.findViewById(R.id.space_7);
        space7.setOnClickListener(this);
        space8 = (DrawView) v.findViewById(R.id.space_8);
        space8.setOnClickListener(this);
        space9 = (DrawView) v.findViewById(R.id.space_9);
        space9.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.space_1:
                space1.setPlayer(alternateShape%2);
                alternateShape++;
                space1.invalidate();
                break;
            case R.id.space_2:
                space2.setPlayer(alternateShape%2);
                alternateShape++;
                space2.invalidate();
                break;
            case R.id.space_3:
                space3.setPlayer(alternateShape%2);
                alternateShape++;
                space3.invalidate();
                break;
            case R.id.space_4:
                space4.setPlayer(alternateShape%2);
                alternateShape++;
                space4.invalidate();
                break;
            case R.id.space_5:
                space5.setPlayer(alternateShape%2);
                alternateShape++;
                space5.invalidate();
                break;
            case R.id.space_6:
                space6.setPlayer(alternateShape%2);
                alternateShape++;
                space6.invalidate();
                break;
            case R.id.space_7:
                space7.setPlayer(alternateShape%2);
                alternateShape++;
                space7.invalidate();
                break;
            case R.id.space_8:
                space8.setPlayer(alternateShape%2);
                alternateShape++;
                space8.invalidate();
                break;
            case R.id.space_9:
                space9.setPlayer(alternateShape%2);
                alternateShape++;
                space9.invalidate();
                break;
        }
    }

}
