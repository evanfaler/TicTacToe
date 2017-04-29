package com.dualranger.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button singlePlayerButton;
    private Button coopButton;
    private Button multiplayerButton;
    private Button settingsButton;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        singlePlayerButton = (Button) findViewById(R.id.single_player_button);
        coopButton = (Button) findViewById(R.id.co_op_button);
        multiplayerButton = (Button) findViewById(R.id.multiplayer_button);
        settingsButton = (Button) findViewById(R.id.settings_button);

        //Handle Main Menu Button Clicks Here.
        singlePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to Single Player Activity
                Intent intent = new Intent(MainMenu.this, SinglePlayerActivity.class);
                startActivity(intent);
            }
        });

        coopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to Co-Op Play Activity
                Intent intent = new Intent(MainMenu.this, CoopActivity.class);
                startActivity(intent);
            }
        });

        multiplayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to MultiPlayer Activity
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to Settings Activity
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_cog, menu);
        return true;
    }

}
