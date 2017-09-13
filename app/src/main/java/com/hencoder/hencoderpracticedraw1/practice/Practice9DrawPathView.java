package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

  Paint paint = new Paint();
  Path  path  = new Path();

  public Practice9DrawPathView(Context context) {
    super(context);
  }

  public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    // 练习内容：使用 canvas.drawPath() 方法画心形

    paint.setAntiAlias(true);
    paint.setColor(Color.BLACK);

    int centerWidth = getMeasuredWidth() / 2;
    int centerHeight = getMeasuredHeight() / 2;

    RectF rectF = new RectF(centerWidth - 200, centerHeight - 100, centerWidth, centerHeight + 100);
    path.addArc(rectF, 135, 225);

    rectF = new RectF(centerWidth, centerHeight - 100, centerWidth + 200, centerHeight + 100);
    path.arcTo(rectF, 180, 225);

    path.lineTo(centerWidth, centerHeight + 242);

    canvas.drawPath(path, paint);
  }
}
