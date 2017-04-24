package com.dualranger.tictactoe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Top_Fragment extends Fragment implements View.OnClickListener{
    double strokeWidth;
    private View x_line;
    private View o_line;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.top_area_fragment, container, false);

        x_line = v.findViewById(R.id.x_play_marker);
        o_line = v.findViewById(R.id.o_play_marker);

        return v;
    }

    @Override
    public void onClick(View v) {
        //Handle onClicks Here
    }

    public void changePlayer(int player){
        if(player == 1){
            o_line.setVisibility(View.INVISIBLE);
            x_line.setVisibility(View.VISIBLE);
        }else{
            o_line.setVisibility(View.VISIBLE);
            x_line.setVisibility(View.INVISIBLE);
        }

    }

}
