package com.dualranger.tictactoe;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

public class TicTacToe_Activity extends FragmentActivity {
    private GameBoard_Fragment gameBoardFragment;
    private Bottom_Fragment bottomFragment;
    private Top_Fragment topFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_framelayoutt);

        gameBoardFragment = new GameBoard_Fragment();
        bottomFragment = new Bottom_Fragment();
        topFragment = new Top_Fragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.add(R.id.game_board_container, gameBoardFragment, "GameBoard Fragment");
        transaction.add(R.id.bottom_area_container, bottomFragment, "Bottom Area Fragment");
        transaction.add(R.id.top_area_container, topFragment, "Top Area Fragment");

        transaction.commit();
    }

    public void clearGameBoard(){
        if(gameBoardFragment != null){
            gameBoardFragment.clearBoard();
            gameBoardFragment.enableSpaces();
        } else {
            Toast.makeText(getApplicationContext(),"fragment 2  is null", Toast.LENGTH_SHORT).show();
        }

    }

    public void changePlayer(int player){
        topFragment.changePlayer(player);

    }

    public void updateScore(int x, int o){
        topFragment.updateScore(x, o);
    }
}
