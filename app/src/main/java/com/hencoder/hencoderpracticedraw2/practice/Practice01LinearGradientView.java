package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
        paint.setShader(new LinearGradient(0, 200, 0, 400, Color.parseColor("#E91E63"),
                Color.parseColor("#33E91E63"), Shader.TileMode.CLAMP));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long time1 = System.currentTimeMillis();
        path.moveTo(0, 600);
        path.lineTo(0, 50);
        int sum = 0;
        for (int i = 1; i <= 4; i++) {
            sum = i * 50;
            path.rLineTo(10, 10);
            path.rLineTo(10, 20);
            path.rLineTo(10, -30);
            path.rLineTo(10, -10);
            path.rLineTo(10, 10);
        }
        path.lineTo(sum, 600);
        canvas.drawPath(path, paint);
        Toast.makeText(getContext(), (System.currentTimeMillis() - time1) + "", Toast.LENGTH_SHORT).show();
    }
}
