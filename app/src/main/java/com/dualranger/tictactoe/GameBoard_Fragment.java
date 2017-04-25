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
    private View xLine;
    private View oLine;
    List<DrawView> gameSpaces;
    private int winner;
    private int xScore = 0;
    private int oScore = 0;
    private TextView xScoreView;
    private TextView oScoreView;

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
                    isWin();
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

    public void isWin(){
        int winner = 0;

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
            ((TicTacToe_Activity) getActivity()).updateScore(xScore, oScore);
            disableSpaces(); //disable all clicks until reset button is pressed.
            ((TicTacToe_Activity) getActivity()).changePlayer(0);
            alternateShape = 2;
        }else if (winner == 0){
            oScore++;
            ((TicTacToe_Activity) getActivity()).updateScore(xScore, oScore);
            disableSpaces(); //disable all clicks until reset button is pressed.
            alternateShape = 1;
            ((TicTacToe_Activity) getActivity()).changePlayer(1);
        }else{
            if(alternateShape % 2 != 0){
                ((TicTacToe_Activity) getActivity()).changePlayer(1);
            }else{
                ((TicTacToe_Activity) getActivity()).changePlayer(0);
            }
            //Do something/Continue Play
        }

    }

    public void disableSpaces(){
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
