package com.example.android.week10_dem03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by Kevin on 3/28/2016.
 */
public class MyPanel extends View {
    Paint paint = new Paint();

    public MyPanel(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawARGB(255, 255, 255, 0);
        paint.setARGB(255, 0, 0, 255);
        Log.d("KSM", "Draw"+SharedValuesXY.startX);
        canvas.drawRect(
                Math.min(SharedValuesXY.startX,SharedValuesXY.endX),
                Math.min(SharedValuesXY.startY,SharedValuesXY.endY),
                Math.max(SharedValuesXY.startX, SharedValuesXY.endX),
                Math.max(SharedValuesXY.startY, SharedValuesXY.endY),
                paint);

        invalidate();

    }


}
