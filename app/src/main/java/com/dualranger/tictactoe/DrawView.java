package com.dualranger.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {
    private Paint paint = new Paint();
    private Paint shadow = new Paint();
    final float SCALE = getContext().getResources().getDisplayMetrics().density;
    private int player = 2;
    private boolean playable = true;
    private int shadowOffset = 15;

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

   public DrawView(Context context) {
       super(context);
       float valueWidthDips = 10.0f;
       int strokeWidthPix = (int)(valueWidthDips * SCALE + 0.5f);
       paint.setStrokeWidth(strokeWidthPix);
       paint.setStyle(Paint.Style.STROKE);
       paint.setStrokeCap(Paint.Cap.ROUND);
       shadow.setStrokeWidth(strokeWidthPix);
       shadow.setStyle(Paint.Style.STROKE);
       shadow.setStrokeCap(Paint.Cap.ROUND);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);

        float strokeWidth = .03f * getContext().getResources().getDisplayMetrics().widthPixels;
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        shadow.setStrokeWidth(strokeWidth);
        shadow.setStyle(Paint.Style.STROKE);
        shadow.setStrokeCap(Paint.Cap.ROUND);
    }


    @Override
    public void onDraw(Canvas canvas) {
        if (player == 1) { //Draw X
            paint.setColor(getResources().getColor(R.color.xColor));
            shadow.setColor(getResources().getColor(R.color.boardLines));
            shadow.setAlpha(191);
            int width = this.getMeasuredWidth();
            Double percentWidth = (this.getMeasuredWidth() * .3) / 2;
            Integer percentWidthInt = percentWidth.intValue();
            int dimension = width - percentWidthInt;

            canvas.drawLine(percentWidthInt + shadowOffset, percentWidthInt + shadowOffset, dimension + shadowOffset, dimension + shadowOffset, shadow); //Shadow to Main line
            canvas.drawLine(dimension + shadowOffset, percentWidthInt + shadowOffset, percentWidthInt + shadowOffset, dimension + shadowOffset, shadow); //Shadow to Main line
            canvas.drawLine(percentWidthInt, percentWidthInt, dimension, dimension, paint); //Main line
            canvas.drawLine(dimension, percentWidthInt, percentWidthInt, dimension, paint); //Main Line

            playable = false;
        } else if (player == 0) { //Draw O
            paint.setColor(getResources().getColor(R.color.oColor));
            shadow.setColor(getResources().getColor(R.color.boardLines));
            shadow.setAlpha(191);
            float viewWidth = this.getMeasuredWidth();
            double percentWidth = (this.getMeasuredWidth() * .45) / 2;
            float width = viewWidth - Double.valueOf(percentWidth).floatValue();

            canvas.drawCircle((viewWidth / 2) + shadowOffset, (viewWidth / 2) + shadowOffset, width / 2, shadow); //Shadow
            canvas.drawCircle(viewWidth / 2, viewWidth / 2, width / 2, paint); //Main Line

            playable = false;
        } else {
            //Do nothing
        }

    }

}
