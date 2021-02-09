package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// 自定义View的流程;
public class MyView extends View {

    private Paint mpaint;

    // 在代码中使用，所调用的方法；
    public MyView(Context context) {
        super(context);
        initPaint();
    }
    // 在xml布局中，使用的方法；
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    // 测量View控件的方法；
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画布；
        canvas.drawCircle(60,60,60,mpaint);

        //画文本；
        canvas.drawText("黄世祥好帅！",200,200,mpaint);

        // 画...;
    };

    @NonNull
    private Paint initPaint(){
        // 画笔；
        mpaint = new Paint();
        // 设置抗锯齿；
        mpaint.setAntiAlias(true);
        // shezhi画笔宽度；
        mpaint.setStrokeWidth(5);
        // 设置画笔的颜色；
        mpaint.setColor(Color.BLUE);
        // 设置画笔的样式；
        mpaint.setStyle(Paint.Style.STROKE);
        // 设置字体大小；
        mpaint.setTextSize(50);
        return mpaint;
    };
}
