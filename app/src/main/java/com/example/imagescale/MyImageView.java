package com.example.imagescale;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import androidx.annotation.NonNull;
// commit1 - 기본 설계 완료.
// commit2 - 기능1 구현
// commit3 - 기능 2 추가
// commit4 - 구현 완료 _ 가상 기계 지우고 다시 설치해서 실행해보기
public class MyImageView extends View {
    Drawable image;
    float scale = 1f;
    ScaleGestureDetector gestureDetector;
    public MyImageView(Context context) {
        super(context);
        image = context.getResources().getDrawable(R.drawable.starry_night);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight() );
        gestureDetector = new ScaleGestureDetector(context, new ScaleListener());

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.scale(scale, scale);
        image.draw(canvas);
        canvas.restore();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        invalidate();
        return true;
    }

    class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(@NonNull ScaleGestureDetector detector) {
            scale = scale * detector.getScaleFactor();
            if(scale >=10.0f)
                scale = 10f;
            if (scale <=0.1f)
                scale = 0.1f;
            return true;

        }
    }
}
