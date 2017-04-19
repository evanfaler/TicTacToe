package com.dualranger.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DrawView extends View {
    private Paint paint = new Paint();
    final float SCALE = getContext().getResources().getDisplayMetrics().density;
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

   public DrawView(Context context) {
       super(context);
       float valueWidthDips = 10.0f;
       int strokeWidthPix = (int)(valueWidthDips * SCALE + 0.5f);
       paint.setStrokeWidth(strokeWidthPix);
       paint.setStyle(Paint.Style.STROKE);
       paint.setStrokeCap(Paint.Cap.ROUND);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);

        float valueWidthDips = 10.0f;
        int strokeWidthPix = (int)(valueWidthDips * SCALE + 0.5f);
        paint.setStrokeWidth(strokeWidthPix);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }


    @Override
    public void onDraw(Canvas canvas) {
        if(player == 1){ //Draw X
            paint.setColor(getResources().getColor(R.color.xColor));
            int width = this.getMeasuredWidth();
            Double percentWidth = (this.getMeasuredWidth()*.3)/2;
            Integer percentWidthInt = percentWidth.intValue();
            int dimension = width - percentWidthInt;

            canvas.drawLine(percentWidthInt, percentWidthInt,dimension,dimension,paint);
            canvas.drawLine(dimension,percentWidthInt,percentWidthInt,dimension,paint);

            playable = false;
        } else if(player == 0) { //Draw O
            paint.setColor(getResources().getColor(R.color.oColor));
            float viewWidth = this.getMeasuredWidth();
            double percentWidth = (this.getMeasuredWidth()*.3)/2;
            float width = viewWidth - Double.valueOf(percentWidth).floatValue();

            canvas.drawCircle(viewWidth/2,viewWidth/2,width/2,paint);

            playable = false;
        } else {
            //Do nothing
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int viewDimension = (int) Math.round(parentWidth * .3);

        Log.d("TicTacToe", "View: " + this.getResources().getResourceName(this.getId()) + "parentWidth: " + parentWidth + ", viewDimension: " + viewDimension);

        this.getLayoutParams().width = 500;
        this.getLayoutParams().height = 500;
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        this.invalidate();

    }

}
