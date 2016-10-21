package com.example.android.week10_dem03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.jar.Attributes;

/**
 * Created by Kevin on 3/28/2016.
 */
public class MyPanel extends View {
    Paint paint = new Paint();

    public MyPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawARGB(255, 255, 255, 0);
        paint.setARGB(255, 0, 0, 255);
        Log.d("KSM", "Draw" + SharedValuesXY.startX);
        switch (SharedValuesXY.drawingMode) {
            case "RECT": canvas.drawRect(
                    Math.min(SharedValuesXY.startX, SharedValuesXY.endX),
                    Math.min(SharedValuesXY.startY, SharedValuesXY.endY),
                    Math.max(SharedValuesXY.startX, SharedValuesXY.endX),
                    Math.max(SharedValuesXY.startY, SharedValuesXY.endY),
                    paint);
                break;
            case "CIRC":
                float x2 = (float)Math.pow(Math.abs(SharedValuesXY.startX-SharedValuesXY.endX),2);
                float y2 = (float)Math.pow(Math.abs(SharedValuesXY.startY-SharedValuesXY.endY),2);
                float r=(float)Math.sqrt(x2+y2);
                canvas.drawCircle(
                    SharedValuesXY.startX,
                    SharedValuesXY.startY,
                    r,
                    paint);
                break;
            case "LINE": canvas.drawLine(
                    SharedValuesXY.startX,
                    SharedValuesXY.startY,
                    SharedValuesXY.endX,
                    SharedValuesXY.endY,
                    paint);
                break;
        }

        invalidate();

    }


}
