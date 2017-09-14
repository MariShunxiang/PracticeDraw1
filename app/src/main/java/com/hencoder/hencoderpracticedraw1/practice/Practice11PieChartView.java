package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

  Paint paint      = new Paint();
  Paint textPaint  = new Paint();
  Paint linePaint  = new Paint();
  Path  path       = new Path();
  RectF rectF      = new RectF();
  Rect  textBounds = new Rect();

  String text;

  private static final int TEXT_DISTANCE = 20;

  public Practice11PieChartView(Context context) {
    super(context);
  }

  public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //        综合练习
    //        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

    paint.setAntiAlias(true);

    textPaint.setAntiAlias(true);
    textPaint.setColor(Color.WHITE);
    textPaint.setStyle(Paint.Style.STROKE);
    textPaint.setTextSize(40);

    linePaint.setAntiAlias(true);
    linePaint.setColor(Color.parseColor("#B8B8B8"));
    linePaint.setStyle(Paint.Style.STROKE);
    linePaint.setStrokeWidth(5);

    int centerWidth = getWidth() / 2;
    int centerHeight = getHeight() / 2;

    int circleWidthCenter = centerWidth - 150;
    int circleHeightCenter = centerHeight - 120;

    int radius = Math.min(circleWidthCenter, circleHeightCenter) - 100;

    /*************** 画线 **************/
    // Lollipop
    path.moveTo(circleWidthCenter - radius, centerHeight - radius - 70);
    path.rLineTo(-100, 0);
    path.moveTo(circleWidthCenter - radius, centerHeight - radius - 70);
    path.rLineTo(50, 50);

    // KitKat
    path.moveTo(circleWidthCenter - radius + 150, circleHeightCenter + radius - 70);
    path.rLineTo(-50, 50);
    path.rLineTo(-150, 0);

    // Marshmallow
    path.moveTo(circleWidthCenter + radius - 50, circleHeightCenter - 100);
    path.rLineTo(70, -70);
    path.rLineTo(70, 0);

    // 右边文字的起始位置
    int rightTextStart = circleWidthCenter + radius - 50 + 70 + 70 + TEXT_DISTANCE;

    // Froyo
    path.moveTo(circleWidthCenter + radius, circleHeightCenter + 5);
    path.rLineTo(rightTextStart - circleWidthCenter - radius - TEXT_DISTANCE, 0);

    // Gingerbread
    path.moveTo(circleWidthCenter + radius - 10, circleHeightCenter + 40);
    path.rLineTo(50, 50);
    path.rLineTo(48, 0);

    // Ice Cream Sandwich
    path.moveTo(circleWidthCenter + radius - 15, circleHeightCenter + 95);
    path.rLineTo(55, 50);
    path.rLineTo(48, 0);

    // Jelly Bean
    path.rMoveTo(0, 100);
    path.rLineTo(-130, 0);
    path.rLineTo(-50, -50);

    canvas.drawPath(path, linePaint);

    /*************** 画文字 **************/
    text = "Lollipop";
    textPaint.getTextBounds(text, 0, text.length(), textBounds);
    int textWidth = textBounds.width();
    canvas.drawText(text, circleWidthCenter - radius - textWidth - 100 - TEXT_DISTANCE, centerHeight - radius - 70,
        textPaint);

    text = "KitKat";
    textPaint.getTextBounds(text, 0, text.length(), textBounds);
    textWidth = textBounds.width();
    canvas.drawText(text, circleWidthCenter - radius + 150 - 50 - 150 - textWidth - TEXT_DISTANCE,
        circleHeightCenter + radius - 70 + 50, textPaint);

    text = "Marshmallow";
    canvas.drawText(text, rightTextStart, circleHeightCenter - 100 - 70, textPaint);

    text = "Froyo";
    canvas.drawText(text, rightTextStart, circleHeightCenter + 5, textPaint);

    text = "Gingerbread";
    canvas.drawText(text, circleWidthCenter + radius - 10 + 50 + 48 + TEXT_DISTANCE, circleHeightCenter + 40 + 50 + 0,
        textPaint);

    text = "Ice Cream Sandwich";
    canvas.drawText(text, circleWidthCenter + radius - 15 + 55 + 48 + TEXT_DISTANCE, circleHeightCenter + 95 + 50 + 0,
        textPaint);

    text = "Jelly Bean";
    canvas.drawText(text, circleWidthCenter + radius - 15 + 55 + 48 + TEXT_DISTANCE,
        circleHeightCenter + 95 + 50 + 0 + 100, textPaint);

    /*************** 画扇形 **************/
    paint.setColor(Color.RED);

    int distance = 20; // 红色圆弧离圆心距离

    rectF.set(circleWidthCenter - radius - distance, circleHeightCenter - radius - distance,
        circleWidthCenter + radius - distance, circleHeightCenter + radius - distance);

    canvas.drawArc(rectF, 180, 135, true, paint);

    rectF.set(circleWidthCenter - radius, circleHeightCenter - radius, circleWidthCenter + radius,
        circleHeightCenter + radius);

    paint.setColor(Color.YELLOW);

    canvas.drawArc(rectF, 0, -45, true, paint);

    paint.setColor(Color.parseColor("#8A2BE2")); // 紫色

    canvas.drawArc(rectF, 3, 10, true, paint);

    paint.setColor(Color.GRAY);

    canvas.drawArc(rectF, 16, 7, true, paint);

    paint.setColor(Color.parseColor("#3CB371")); // JellyBean

    canvas.drawArc(rectF, 26, 50, true, paint);

    paint.setColor(Color.parseColor("#436EEE"));

    canvas.drawArc(rectF, 79, 101, true, paint);

    /*************** 底部文字 **************/
    textPaint.setTextSize(80);
    text = "饼图";
    textPaint.getTextBounds(text, 0, text.length(), textBounds);
    textWidth = textBounds.width();
    canvas.drawText(text, circleWidthCenter - textWidth / 2, getHeight() - 100, textPaint);
  }
}
