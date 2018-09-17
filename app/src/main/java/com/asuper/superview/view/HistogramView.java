package com.asuper.superview.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.asuper.superview.R;


/*
* 自定义进度(类似柱状图)
* */

public class HistogramView extends View {

    private Paint hLinePaint;// 坐标轴水平内部 虚线画笔
    private Paint titlePaint;// 绘制文本的画笔
    private Paint mBitPaint;//绘制标尺图片的画笔
    private Paint tv_piant;//绘制标尺图片里面的百分比数字

    private String[] ySteps;// 坐标轴左侧的数标

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
        requestLayout();//相当于调用onMeasure方法
        invalidate();//相当于调用onDraw方法
    }

    private int percent =0;//标的购买百分比
    private String percentStr ;//标的购买百分比


    public HistogramView(Context context) {
        super(context);
        init();
    }

    public HistogramView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        percent = getPercent();
        ySteps = new String[] { "100%","80%" ,"60%","40%","20%","0%"};

        //初始化画笔
        hLinePaint = new Paint();//平行线
        titlePaint = new Paint();//百分百文字
        mBitPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//标尺图片
        tv_piant = new Paint(Paint.ANTI_ALIAS_FLAG);//标尺里面百分比数字


        // 给画笔设置颜色

        hLinePaint.setColor(getResources().getColor(R.color.white));
        titlePaint.setColor(getResources().getColor(R.color.white));
        //tv_piant.setColor(0XFFFFB637);
        tv_piant.setColor(getResources().getColor(R.color.yellowtext));
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight() - dp2px(37);

        int leftHeight = height - dp2px(5);// 左侧外周的 需要划分的高度：

        int hPerHeight = leftHeight / 5;// 分成5部分

        hLinePaint.setTextAlign(Align.CENTER);
        // 设置6条平行线
        for (int i = 0; i < 6; i++) {
            canvas.drawLine(dp2px(40), dp2px(10) + i * hPerHeight, width - dp2px(40), dp2px(10) + i * hPerHeight, hLinePaint);
        }

        // 绘制 Y 周坐标
        titlePaint.setTextAlign(Align.RIGHT);
        titlePaint.setTextSize(sp2px(10));
        titlePaint.setAntiAlias(true);
        titlePaint.setStyle(Paint.Style.FILL);
        // 设置左部的数字
        for (int i = 0; i < ySteps.length; i++) {
            canvas.drawText(ySteps[i], dp2px(30), dp2px(13) + i * hPerHeight, titlePaint);
        }

         /*进度条右上角的标尺图标*/
        Bitmap photo = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ruler);
        int mWidth = photo.getWidth();
        int mHight = photo.getHeight();
        Rect mSrcRect = new Rect(0, 0, mWidth, mHight);//是对图片进行裁截，若是空null则显示整个图片
        RectF mDestRect = new RectF(width - dp2px(38),hPerHeight*6-hPerHeight*percent/20-mHight/4-dp2px(7), width - dp2px(10), hPerHeight*6-hPerHeight*percent/20+mHight/4+dp2px(2));//图片所在区域

        //绘制标尺图片
        mBitPaint.setFilterBitmap(true);
        mBitPaint.setDither(true);
        canvas.drawBitmap(photo, mSrcRect, mDestRect, mBitPaint);

        /**绘制标尺里面进度百分比的文字*/
        percentStr = percent+"%";
        Log.e("Histogram percentStr：",percentStr);

        tv_piant.setStrokeWidth(3);
        tv_piant.setTextSize(dp2px(10));
        tv_piant.setTextAlign(Align.CENTER);

        Rect tv_Rect = new Rect();
        tv_piant.getTextBounds(percentStr,0, percentStr.length(), tv_Rect);
        canvas.drawText(percentStr, width - dp2px(28)+mWidth/4, hPerHeight*6-hPerHeight*percent/20, tv_piant);

    }

    private int dp2px(int value) {
        float v = getContext().getResources().getDisplayMetrics().density;
        return (int) (v * value + 0.5f);
    }

    private int sp2px(int value) {
        float v = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (v * value + 0.5f);
    }


}
