package com.hencoder.hencoderpracticedraw2.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Sample15FillPathView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    Path path1 = new Path();
    Path path2 = new Path();
    Path path3 = new Path();

    public Sample15FillPathView(Context context) {
        super(context);
    }

    public Sample15FillPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample15FillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);

        pathPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.getFillPath() 获取实际绘制的 Path

        // 第一处：获取 Path
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(0);
        paint.getFillPath(path, path1);
        paint.setColor(Color.RED);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(0, 120);
        pathPaint.setColor(Color.GREEN);
        canvas.drawPath(path, pathPaint);
        canvas.restore();

    }
}
