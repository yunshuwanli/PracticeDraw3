package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice13GetTextBoundsView extends View {
    private static final String TAG = "Practice13GetTextBoundsView";
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "A";
    String text2 = "a";
    String text3 = "J";
    String text4 = "j";
    String text5 = "Â";
    String text6 = "â";
    int top = 200;
    int bottom = 400;

    public Practice13GetTextBoundsView(Context context) {
        super(context);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Rect rect;

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);

        rect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差
        //这个算法就是  偏移量x = -( rect.bottom + rect.top)/2;
        //而不能 是 x =  (rect.bottom - rect.top) / 2;
        //解释 文字上的top 基线以上为负数  bottom为正在基线下  http://hencoder.com/ui-1-3/ 中 2.2.2 FontMetircs getFontMetrics() 解释

        int middle = (top + bottom) / 2;

        paint2.getTextBounds(text1, 0, 1, rect);
        int middle1 = -(rect.bottom + rect.top) / 2;
        canvas.drawText(text1, 100, middle + middle1, paint2);

        paint2.getTextBounds(text2, 0, 1, rect);
        int middle2 = -(rect.bottom + rect.top) / 2;
        canvas.drawText(text2, 200, middle + middle2, paint2);

        paint2.getTextBounds(text3, 0, 1, rect);
        int middle3 = -(rect.bottom + rect.top) / 2;
        canvas.drawText(text3, 300, middle + middle3, paint2);

        paint2.getTextBounds(text4, 0, 1, rect);
        int middle4 = -(rect.top + rect.bottom) / 2; //40
        canvas.drawText(text4, 400, middle + middle4, paint2);

        paint2.getTextBounds(text5, 0, 1, rect);
        int middle5 = -(rect.bottom + rect.top) / 2;
        canvas.drawText(text5, 500, middle + middle5, paint2);

        paint2.getTextBounds(text6, 0, 1, rect);
        int middle6 = -(rect.bottom + rect.top) / 2;
        canvas.drawText(text6, 600, middle + middle6, paint2);
    }
}