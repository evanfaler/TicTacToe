package com.dualranger.tictactoe;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;


public class ScoreDotView extends AppCompatImageView {

    public ScoreDotView(Context context) {
        super(context);
    }

    public ScoreDotView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        float dotDimension = parentHeight * .2f; //Make dot height and width 20% of layout height.
        int dimension = Math.round(dotDimension);
        this.setMeasuredDimension(dimension, dimension);

    }

}
