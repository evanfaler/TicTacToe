package com.dualranger.tictactoe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class CoopGameBoardFragment extends Fragment implements View.OnClickListener {
    private static SpaceView space1;
    private static SpaceView space2;
    private static SpaceView space3;
    private static SpaceView space4;
    private static SpaceView space5;
    private static SpaceView space6;
    private static SpaceView space7;
    private static SpaceView space8;
    private static SpaceView space9;
    private List<SpaceView> gameSpaces;
    private int winner;
    private int xScore = 0;
    private int oScore = 0;
    private TextView xScoreView;
    private TextView oScoreView;

    private int alternateShape = 1;

    public void resetScore(){
        xScore = 0;
        oScore = 0;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_board, container, false);

        space1 = (SpaceView) v.findViewById(R.id.space_1);
        space1.setOnClickListener(this);

        space2 = (SpaceView) v.findViewById(R.id.space_2);
        space2.setOnClickListener(this);

        space3 = (SpaceView) v.findViewById(R.id.space_3);
        space3.setOnClickListener(this);

        space4 = (SpaceView) v.findViewById(R.id.space_4);
        space4.setOnClickListener(this);

        space5 = (SpaceView) v.findViewById(R.id.space_5);
        space5.setOnClickListener(this);

        space6 = (SpaceView) v.findViewById(R.id.space_6);
        space6.setOnClickListener(this);

        space7 = (SpaceView) v.findViewById(R.id.space_7);
        space7.setOnClickListener(this);

        space8 = (SpaceView) v.findViewById(R.id.space_8);
        space8.setOnClickListener(this);

        space9 = (SpaceView) v.findViewById(R.id.space_9);
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
                    isWin();
                    System.gc();
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
                    isWin();
                    System.gc();
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
                    isWin();
                    System.gc();
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
                    isWin();
                    System.gc();
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
                    isWin();
                    System.gc();
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
                    isWin();
                    System.gc();
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
                    isWin();
                    System.gc();
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
                    isWin();
                    System.gc();
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
                    isWin();
                    System.gc();
                }else{
                    Toast.makeText(v.getContext(),"Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void clearBoard(){
        for(SpaceView space:gameSpaces){
            space.setPlayer(2);
            space.setPlayable(true);
            space.setBackgroundColor(0x000000);
            space.invalidate();
        }
    }

    private void isWin(){
        if(space1.getPlayer() == space5.getPlayer() && space5.getPlayer() == space9.getPlayer() && space1.getPlayer() != 2){
            winner = space1.getPlayer();
        }else if (space3.getPlayer() == space5.getPlayer() && space5.getPlayer() == space7.getPlayer()&& space3.getPlayer() != 2){
            winner = space3.getPlayer();
        }else if (space1.getPlayer() == space4.getPlayer() && space4.getPlayer() == space7.getPlayer() && space1.getPlayer() != 2){
            winner = space1.getPlayer();
        }else if (space2.getPlayer() == space5.getPlayer() && space5.getPlayer() == space8.getPlayer() && space2.getPlayer() != 2){
            winner = space2.getPlayer();
        }else if (space3.getPlayer() == space6.getPlayer() && space6.getPlayer() == space9.getPlayer() && space3.getPlayer() != 2){
            winner = space3.getPlayer();
        }else if (space1.getPlayer() == space2.getPlayer() && space2.getPlayer() == space3.getPlayer() && space1.getPlayer() != 2){
            winner = space1.getPlayer();
        }else if (space4.getPlayer() == space5.getPlayer() && space5.getPlayer() == space6.getPlayer() && space4.getPlayer() != 2){
            winner = space4.getPlayer();
        }else if (space7.getPlayer() == space8.getPlayer() && space8.getPlayer() == space9.getPlayer() && space7.getPlayer() != 2){
            winner = space7.getPlayer();
        }else {
            winner = 2;
        }


        if (winner == 1){
            xScore++;
            ((CoopActivity) getActivity()).updateScoreboard(xScore, oScore);
            disableSpaces(); //disable all clicks until reset button is pressed.
            //Change player via changing color of X or O
            alternateShape = 2;
        }else if (winner == 0){
            oScore++;
            ((CoopActivity) getActivity()).updateScoreboard(xScore, oScore);
            disableSpaces(); //disable all clicks until reset button is pressed.
            alternateShape = 1;
            //Change player via changing color of X or O
        }else{
            if(alternateShape % 2 != 0){
                //Change player via changing color of X or O
            }else{
                //Change player via changing color of X or O
            }
            //Do something/Continue Play
        }

    }

    private void disableSpaces(){
        space1.setEnabled(false);
        space2.setEnabled(false);
        space3.setEnabled(false);
        space4.setEnabled(false);
        space5.setEnabled(false);
        space6.setEnabled(false);
        space7.setEnabled(false);
        space8.setEnabled(false);
        space9.setEnabled(false);
    }

    public void enableSpaces(){
        space1.setEnabled(true);
        space2.setEnabled(true);
        space3.setEnabled(true);
        space4.setEnabled(true);
        space5.setEnabled(true);
        space6.setEnabled(true);
        space7.setEnabled(true);
        space8.setEnabled(true);
        space9.setEnabled(true);
    }

}
