package com.dualranger.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
    private Paint paint = new Paint();

    public DrawView(Context context) {
        super(context);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(0,0,this.getWidth(),this.getHeight(),paint);
        canvas.drawLine(this.getWidth(),0,0,this.getHeight(),paint);
    }

}
