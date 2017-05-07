package com.dualranger.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class SpaceView extends View {
    //No Player = 2
    //X = 1
    //O = 0
    private int player = 2;
    private boolean playable = true;

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

   public SpaceView(Context context) {
       super(context);
    }

    public SpaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onDraw(Canvas canvas) {
        if (player == 1) { //Draw X
            setBackgroundResource(R.drawable.x_mark);
            playable = false;
        } else if (player == 0) { //Draw O
            setBackgroundResource(R.drawable.o_mark);
            playable = false;
        } else {
            //Do nothing
        }
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentWidth);

    }

}
