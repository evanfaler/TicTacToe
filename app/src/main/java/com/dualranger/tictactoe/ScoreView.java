package com.dualranger.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by evanfaler on 4/28/2017.
 */

public class ScoreView extends AppCompatImageView {

    public ScoreView(Context context) {
        super(context);
    }

    public ScoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas){

    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        float actualWidth = parentHeight * 1.2386f;
        int width = Math.round(actualWidth);
        this.setMeasuredDimension(width, parentHeight);

    }
}
