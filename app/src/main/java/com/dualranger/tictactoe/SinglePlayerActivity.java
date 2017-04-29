package com.dualranger.tictactoe;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class SinglePlayerActivity extends AppCompatActivity {

    private SinglePlayerGameBoardFragment gameBoardFragment;
    private View leftSpace;
    private View centerSpace;
    private View rightSpace;
    private Button resetButton;
    private ScoreDotView x1;
    private ScoreDotView x2;
    private ScoreDotView x3;
    private ScoreDotView o1;
    private ScoreDotView o2;
    private ScoreDotView o3;
    private List<ScoreDotView> xScoreDots;
    private List<ScoreDotView> oScoreDots;
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

        //Initializing Reset Button and setting onclick.
        resetButton = (Button) findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearGameBoard();
            }
        });

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

        //Initialize score markers
        x1 = (ScoreDotView) findViewById(R.id.x1);
        x2 = (ScoreDotView) findViewById(R.id.x2);
        x3 = (ScoreDotView) findViewById(R.id.x3);
        o1 = (ScoreDotView) findViewById(R.id.o1);
        o2 = (ScoreDotView) findViewById(R.id.o2);
        o3 = (ScoreDotView) findViewById(R.id.o3);
        xScoreDots = Arrays.asList(x1, x2, x3); //x array to make changing score easier
        oScoreDots = Arrays.asList(o1, o2, o3); //o array to make changing score easier
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_cog, menu);
        return true;
    }

    private void clearGameBoard() {
        if (gameBoardFragment != null) {
            gameBoardFragment.resetGame();
            gameBoardFragment.enableSpaces();
        } else {
            Toast.makeText(getApplicationContext(), "fragment 2  is null", Toast.LENGTH_SHORT).show();
        }

    }

    private void resetScoreMarkers(){
        for(ScoreDotView marker : oScoreDots){
            marker.setBackgroundResource(R.drawable.dot_empty);
        }
        for(ScoreDotView marker : xScoreDots){
            marker.setBackgroundResource(R.drawable.dot_empty);
        }

    }

    public void updateScoreboard(int xScore, int oScore) {
        if (xScore <= 3 && oScore <= 3) {
            for (int i = 0; i < xScore; i++) {
                xScoreDots.get(i).setBackgroundResource(R.drawable.dot_filled);
            }
            for (int i = 0; i < oScore; i++) {
                oScoreDots.get(i).setBackgroundResource(R.drawable.dot_filled);
            }
        }
        if (xScore == 3 || oScore == 3) {
            gameOver();
        }
    }

    private void gameOver() {
        //Displays game over alert dialog
        final Dialog gameOverDialog = new Dialog(this);
        gameOverDialog.setContentView(R.layout.game_over_dialog);

        Button dialogMenuButton = (Button) gameOverDialog.findViewById(R.id.menu_button);
        dialogMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override //Go back to main menu
            public void onClick(View v) {
                gameOverDialog.dismiss();
                Intent intent = new Intent(SinglePlayerActivity.this, MainMenu.class);
                startActivity(intent);
            }
        });
        Button dialogNewGameButton = (Button) gameOverDialog.findViewById(R.id.new_game_button);
        dialogNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override //Clear board and start new game
            public void onClick(View v) {
                gameOverDialog.dismiss();
                clearGameBoard();
                CoopGameBoardFragment fragment = (CoopGameBoardFragment) getSupportFragmentManager().findFragmentById(R.id.game_board_container);
                fragment.resetScore();
                resetScoreMarkers();
                resetButton.setVisibility(View.VISIBLE);
            }
        });
        gameOverDialog.show();

        //Hides reset Button.
        resetButton.setVisibility(View.INVISIBLE);
        //TODO replace button with New Game button if dialog is cancelled.
    }

}
