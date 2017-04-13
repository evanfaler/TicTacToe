package com.dualranger.tictactoe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class GameBoard_Fragment extends Fragment implements View.OnClickListener {
    private DrawView space1;
    private DrawView space2;
    private DrawView space3;
    private DrawView space4;
    private DrawView space5;
    private DrawView space6;
    private DrawView space7;
    private DrawView space8;
    private DrawView space9;
    List<DrawView> gameSpaces;

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

        gameSpaces = Arrays.asList(space1, space2, space3, space4, space5, space6, space7, space8, space9);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.space_1:
                if(space1.isPlayable()){
                    space1.setPlayer(alternateShape%2);
                    space1.setPlayable(false);
                    alternateShape++;
                    space1.invalidate();
                }else{
                    Toast.makeText(v.getContext(),"Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_2:
                if(space2.isPlayable()){
                    space2.setPlayer(alternateShape%2);
                    space2.setPlayable(false);
                    alternateShape++;
                    space2.invalidate();
                }else{
                    Toast.makeText(v.getContext(),"Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_3:
                if(space3.isPlayable()){
                    space3.setPlayer(alternateShape%2);
                    space3.setPlayable(false);
                    alternateShape++;
                    space3.invalidate();
                }else{
                    Toast.makeText(v.getContext(),"Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_4:
                if(space4.isPlayable()){
                    space4.setPlayer(alternateShape%2);
                    space4.setPlayable(false);
                    alternateShape++;
                    space4.invalidate();
                }else{
                    Toast.makeText(v.getContext(),"Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_5:
                if(space5.isPlayable()){
                    space5.setPlayer(alternateShape%2);
                    space5.setPlayable(false);
                    alternateShape++;
                    space5.invalidate();
                }else{
                    Toast.makeText(v.getContext(),"Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_6:
                if(space6.isPlayable()){
                    space6.setPlayer(alternateShape%2);
                    space6.setPlayable(false);
                    alternateShape++;
                    space6.invalidate();
                }else{
                    Toast.makeText(v.getContext(),"Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_7:
                if(space7.isPlayable()){
                    space7.setPlayer(alternateShape%2);
                    space7.setPlayable(false);
                    alternateShape++;
                    space7.invalidate();
                }else{
                    Toast.makeText(v.getContext(),"Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_8:
                if(space8.isPlayable()){
                    space8.setPlayer(alternateShape%2);
                    space8.setPlayable(false);
                    alternateShape++;
                    space8.invalidate();
                }else{
                    Toast.makeText(v.getContext(),"Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_9:
                if(space9.isPlayable()){
                    space9.setPlayer(alternateShape%2);
                    space9.setPlayable(false);
                    alternateShape++;
                    space9.invalidate();
                }else{
                    Toast.makeText(v.getContext(),"Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void clearBoard(){
        for(DrawView space:gameSpaces){
            space.setPlayer(2);
            space.setPlayable(true);
            space.invalidate();
        }
    }

}
