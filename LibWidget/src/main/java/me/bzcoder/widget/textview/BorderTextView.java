package me.bzcoder.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import me.bzcoder.libwidget.R;

/**
 * 带边框的小标签
 * 可选项：
 * 1.实心，空心
 * 2.颜色
 * 3.是否圆角
 * 4.边框宽度
 *
 * @author : BaoZhou
 * @date : 2019/7/23 9:10
 */
public class BorderTextView extends AppCompatTextView {

    /*dialogfragment *
     * 边框宽度
     */
    private float strokeWidth;

    /**
     * 边框颜色
     */
    private int borderColor;

    /**
     * 是否实心
     */
    private boolean isSolid;

    /**
     * 是否圆角
     */
    private boolean isRoundCorner;

    private Paint borderPaint;
    private Paint solidPaint;

    public BorderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.BorderTextView, 0, 0);
        try {
            strokeWidth = a.getDimension(R.styleable.BorderTextView_stroke_width, 0);
            borderColor = a.getInteger(R.styleable.BorderTextView_stroke_color, 0);
            isSolid = a.getBoolean(R.styleable.BorderTextView_solid, false);
            isRoundCorner = a.getBoolean(R.styleable.BorderTextView_round_corner, false);
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
        postInvalidate();
    }


    public void setSolid(boolean solid) {
        isSolid = solid;
        postInvalidate();
    }

    public void setRoundCorner(boolean roundCorner) {
        isRoundCorner = roundCorner;
        postInvalidate();
    }


}
 