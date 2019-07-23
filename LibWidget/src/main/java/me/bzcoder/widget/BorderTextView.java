package me.bzcoder.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import me.bzcoder.libwidget.R;

/**
 * 带边框新闻小标签
 * 可选项：
 * 1.实心，空心
 * 2.颜色
 * 3.是否圆角
 *
 * @author : BaoZhou
 * @date : 2019/7/23 9:10
 */
public class BorderTextView extends AppCompatTextView {
    private int strokeWidth;
    private int borderColor;
    private Paint borderPaint;
    private Paint solidPaint;

    private boolean isSolid;
    private boolean isRoundCorner;

    public BorderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.BorderTextView, 0, 0);
        try {
            strokeWidth = a.getInteger(R.styleable.BorderTextView_BorderSize, 0);
            borderColor = a.getInteger(R.styleable.BorderTextView_Color, 0);
            isSolid = a.getBoolean(R.styleable.BorderTextView_IsSolid, false);
            isRoundCorner = a.getBoolean(R.styleable.BorderTextView_IsRoundCorner, false);
        } finally {
            a.recycle();
        }

        borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(strokeWidth);
        borderPaint.setAntiAlias(true);

        solidPaint = new Paint();
        solidPaint.setStyle(Paint.Style.FILL);
        solidPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (0 == this.getText().toString().length()) {
            return;
        }

        borderPaint.setColor(borderColor);
        solidPaint.setColor(borderColor);
        int w = this.getMeasuredWidth();
        int h = this.getMeasuredHeight();
        RectF r = new RectF(strokeWidth, strokeWidth, w - strokeWidth, h - strokeWidth);
        if (isRoundCorner) {
            canvas.drawRoundRect(r, 10, 10, isSolid ? solidPaint : borderPaint);
        } else {
            canvas.drawRect(r, isSolid ? solidPaint : borderPaint);
        }
        super.onDraw(canvas);
    }


    public int getBordderColor() {
        return borderColor;
    }

    public void setBorderColor(int color) {
        borderColor = color;
        invalidate();
        requestLayout();
    }


    public void setSolid(boolean solid) {
        isSolid = solid;
        invalidate();
        requestLayout();
    }

    public void setRoundCorner(boolean roundCorner) {
        isRoundCorner = roundCorner;
        invalidate();
        requestLayout();
    }


}
 