package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

  Paint paint = new Paint();

  Rect textBounds = new Rect();

  String text;

  public Practice10HistogramView(Context context) {
    super(context);
  }

  public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //        综合练习
    //        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

    paint.setColor(Color.WHITE);
    paint.setAntiAlias(true);
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(5);

    int centerWidth = getWidth() / 2;
    int centerHeight = getHeight() / 2;

    canvas.drawLine(centerWidth - 600, centerHeight - 300, centerWidth - 600, centerHeight + 300, paint);
    canvas.drawLine(centerWidth - 600, centerHeight + 300, centerWidth + 600, centerHeight + 300, paint);

    paint.setStyle(Paint.Style.FILL);

    // 矩形的底部高度
    int bottom = centerHeight + 300;
    // 左边的起点
    int left = centerWidth - 600;

    left += 40;

    canvas.drawRect(left, bottom - 10, left + 120, bottom, paint);

    paint.setColor(Color.GREEN);

    left += 160;

    canvas.drawRect(left, bottom - 50, left + 120, bottom, paint);

    left += 160;

    canvas.drawRect(left, bottom - 50, left + 120, bottom, paint);

    left += 160;

    canvas.drawRect(left, bottom - 250, left + 120, bottom, paint);

    left += 160;

    canvas.drawRect(left, bottom - 460, left + 120, bottom, paint);

    left += 160;

    canvas.drawRect(left, bottom - 540, left + 120, bottom, paint);

    left += 160;

    canvas.drawRect(left, bottom - 220, left + 120, bottom, paint);

    paint.setColor(Color.WHITE);
    paint.setTextSize(45);

    text = "Froyo";

    paint.getTextBounds(text, 0, text.length(), textBounds);

    int textHeight = textBounds.height(); // 计算出文字的高度

    int textBottom = bottom + textHeight + 5; // 计算出文字y轴坐标

    int textLeft = centerWidth - 600;

    textLeft += 100; // 计算出第一个矩形的x轴方向中点

    // x轴的中点减去文字的一半宽度, 得到文字起始位置
    canvas.drawText(text, textLeft - textBounds.width() / 2, textBottom, paint);

    textLeft += 160; // 计算出第二个矩形的x轴方向中点
    text = "GB";
    paint.getTextBounds(text, 0, text.length(), textBounds);
    canvas.drawText(text, textLeft - textBounds.width() / 2, textBottom, paint);

    textLeft += 160;
    text = "IC S";
    paint.getTextBounds(text, 0, text.length(), textBounds);
    canvas.drawText(text, textLeft - textBounds.width() / 2, textBottom, paint);

    textLeft += 160;
    text = "JB";
    paint.getTextBounds(text, 0, text.length(), textBounds);
    canvas.drawText(text, textLeft - textBounds.width() / 2, textBottom, paint);

    textLeft += 160;
    text = "KitKat";
    paint.getTextBounds(text, 0, text.length(), textBounds);
    canvas.drawText(text, textLeft - textBounds.width() / 2, textBottom, paint);

    textLeft += 160;
    text = "L";
    paint.getTextBounds(text, 0, text.length(), textBounds);
    canvas.drawText(text, textLeft - textBounds.width() / 2, textBottom, paint);

    textLeft += 160;
    text = "M";
    paint.getTextBounds(text, 0, text.length(), textBounds);
    canvas.drawText(text, textLeft - textBounds.width() / 2, textBottom, paint);

    paint.setTextSize(80);

    text = "直方图";
    paint.getTextBounds(text, 0, text.length(), textBounds);
    canvas.drawText(text, centerWidth - textBounds.width() / 2, textBottom + 100, paint);
  }
}
