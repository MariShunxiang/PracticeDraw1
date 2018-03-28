package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class Practice5DrawOvalView extends View {

  public Practice5DrawOvalView(Context context) {
    super(context);
  }

  public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //        练习内容：使用 canvas.drawOval() 方法画椭圆
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    //paint.setColor(Color.BLACK);
    //
    //RectF rectF = new RectF(getMeasuredWidth() / 2 - 200, getMeasuredHeight() / 2 - 100, getMeasuredWidth() / 2 + 200,
    //    getMeasuredHeight() / 2 + 100);
    //
    //canvas.drawOval(rectF, paint);

    Path path = new Path();

    path.moveTo(0, dpToPixel(10));
    path.lineTo(dpToPixel(7), dpToPixel(2));
    path.lineTo(dpToPixel(116), dpToPixel(58));
    path.lineTo(dpToPixel(116), dpToPixel(70));
    path.lineTo(dpToPixel(7), dpToPixel(128));
    path.lineTo(0, dpToPixel(120));
    path.close();

    canvas.drawPath(path, paint);
  }

  public static float dpToPixel(float dp) {
    DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
    return dp * metrics.density;
  }
}
