package com.dualranger.tictactoe;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

public class CoopActivity extends AppCompatActivity {
    private CoopGameBoardFragment gameBoardFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_framelayoutt);
        Toolbar appToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(appToolbar);

        gameBoardFragment = new CoopGameBoardFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.add(R.id.game_board_container, gameBoardFragment, "GameBoard Fragment");

        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_cog, menu);
        return true;
    }

    public void clearGameBoard(){
        if(gameBoardFragment != null){
            gameBoardFragment.clearBoard();
            gameBoardFragment.enableSpaces();
        } else {
            Toast.makeText(getApplicationContext(),"fragment 2  is null", Toast.LENGTH_SHORT).show();
        }

    }

}
