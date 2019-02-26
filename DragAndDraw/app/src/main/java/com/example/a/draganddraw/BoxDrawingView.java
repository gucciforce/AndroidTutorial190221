package com.example.a.draganddraw;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BoxDrawingView extends View {
    private static final String TAG = "BoxDrawingView";
    private Box mCurrentBox;
    List<Box> mBoxes = new ArrayList<>();
    public BoxDrawingView(Context context) {
        super(context);
    }

    public BoxDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());
        String action = "";
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mCurrentBox = new Box(current);
                mBoxes.add(mCurrentBox);
                //action = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_UP:
                mCurrentBox = null;
                break;
            case MotionEvent.ACTION_MOVE:
                //action = "ACTION_MOVE";
                if(mCurrentBox != null){
                    mCurrentBox.setCurrent(current);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                //action = "ACTION_CANCEL";
                break;
        }
        //Log.d(TAG, action+" at x = "+current.x +" , y = "+ current.y);
        return true;
    }
}
