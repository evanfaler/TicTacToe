package com.dualranger.tictactoe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class TicTacToe_Activity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_framelayoutt);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null) {
            fragment = new TicTacToe_Fragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();

        }

    }
}
