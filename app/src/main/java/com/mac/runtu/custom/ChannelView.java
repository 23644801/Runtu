package com.mac.runtu.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.mac.runtu.R;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class ChannelView extends View {
    Paint textPaint;
    Paint rectPaint;
    List<String> datas = null;
    int startX = 0;
    int startY = 0;
    int rectColor = Color.BLACK;
    int rectRound = 3;
    int textColor = Color.BLACK;
    float textSize = 16;

    public ChannelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initParam(context, attrs, defStyleAttr);
        initPaint();
    }

    void initParam(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ChannelView, defStyleAttr, 0);
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.ChannelView_rectColor:
                    rectColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.ChannelView_rectRound:
                    rectRound = a.getInt(attr, 3);
                    break;
                case R.styleable.ChannelView_textColor:
                    textColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.ChannelView_textSize:
                    textSize = a.getDimension(attr, 16);
                    break;
            }

        }
        a.recycle();
    }


    void initPaint() {
        textPaint = new Paint();
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);
        rectPaint = new Paint();
        rectPaint.setColor(rectColor);
        rectPaint.setStyle(Paint.Style.STROKE);
    }

    public void setData(List<String> datas) {
        this.datas = datas;
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < 5; i++) {
            canvas.drawRoundRect(startX, 0, startX + 50, startY + 50, 5, 5, rectPaint);
            startX += 55;
        }
        super.onDraw(canvas);
    }

    public float getTextViewLength(Paint paint, String text) {
        float textLength = paint.measureText(text);
        return textLength;
    }
}
