package com.example.maksbkstgcom.customlayoutview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by maks on 8/9/16.
 * email: m.levytskiy@gmail.com
 */
public class CustomLayoutView extends ViewGroup {

    public CustomLayoutView(Context context) {
        super(context);
    }

    public CustomLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount();

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            Log.i("CL", "i=" + i + " left=" + 0 + " top=" + i * getMeasuredHeight() / 2
                    + " right=" + getMeasuredWidth() + " bottom=" + getMeasuredHeight() / (count / (i+1)));
            child.layout(0, i * getMeasuredHeight() / 2,
                    getMeasuredWidth(), getMeasuredHeight() / (count / (i+1)));
        }
    }

}
