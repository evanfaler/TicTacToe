package com.dualranger.tictactoe;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class SinglePlayerActivity extends AppCompatActivity {

    private SinglePlayerGameBoardFragment gameBoardFragment;
    private View leftSpace;
    private View centerSpace;
    private View rightSpace;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_single_player_framelayoutt);
        Toolbar appToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(appToolbar);

        gameBoardFragment = new SinglePlayerGameBoardFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.add(R.id.game_board_container, gameBoardFragment, "GameBoard Fragment");

        transaction.commit();

        //Give width to spaces in scoreboard.
        int width = this.getWindow().getDecorView().getWidth();
        float spaceWidth = width * .1f; //Set each space width to 10% of screen width.
        int viewWidth = Math.round(spaceWidth);
        leftSpace = findViewById(R.id.left_space);
        leftSpace.getLayoutParams().width = viewWidth;
        centerSpace = findViewById(R.id.center_space);
        centerSpace.getLayoutParams().width = viewWidth;
        rightSpace = findViewById(R.id.right_space);
        rightSpace.getLayoutParams().width = viewWidth;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_cog, menu);
        return true;
    }

}
