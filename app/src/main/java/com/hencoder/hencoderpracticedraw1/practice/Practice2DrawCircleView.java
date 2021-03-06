package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

  Paint mPaint;

  public Practice2DrawCircleView(Context context) {
    this(context, null);
  }

  public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //        练习内容：使用 canvas.drawCircle() 方法画圆
    //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

    int radius = Math.min(getMeasuredWidth() / 4, getMeasuredHeight() / 4) - 20;

    int centerWidth = getMeasuredWidth() / 2;
    int centerHeight = getMeasuredHeight() / 2;

    mPaint.setColor(Color.BLACK);

    canvas.drawCircle(centerWidth / 2, centerHeight / 2, radius, mPaint);

    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeWidth(5);

    canvas.drawCircle(centerWidth + centerWidth / 2, centerHeight / 2, radius, mPaint);

    mPaint.setStyle(Paint.Style.FILL);
    mPaint.setColor(Color.GREEN);

    canvas.drawCircle(centerWidth / 2, centerHeight + centerHeight / 2, radius, mPaint);

    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setColor(Color.BLACK);
    mPaint.setStrokeWidth(20);

    canvas.drawCircle(centerWidth + centerWidth / 2, centerHeight + centerHeight / 2, radius, mPaint);
  }
}
