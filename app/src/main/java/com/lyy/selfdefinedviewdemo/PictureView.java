package com.lyy.selfdefinedviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/1/4.
 */

public class PictureView extends View {


    private Picture picture;

    public PictureView(Context context) {
        super(context);
    }

    public PictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        recording();
    }

    private void recording() {
        picture = new Picture();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

        Canvas canvas = picture.beginRecording(getWidth(), getHeight());
        canvas.translate(getWidth()/2, getHeight()/2);
        canvas.drawCircle(0, 0, 400, paint);
        canvas.drawCircle(0, 0, 380, paint);

        for (int i=0; i<=360; i+=10){
            canvas.drawLine(0, 380, 0, 400, paint);
            canvas.rotate(10);
        }

        picture.endRecording();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.translate(getWidth()/2, getHeight()/2);

        PictureDrawable pictureDrawable = new PictureDrawable(picture);
        pictureDrawable.setBounds(0, 0, getWidth(), getHeight());
        pictureDrawable.draw(canvas);

//        picture.draw(canvas);

//        canvas.drawPicture(picture, new RectF(0, 0, 500, 500));
    }
}
