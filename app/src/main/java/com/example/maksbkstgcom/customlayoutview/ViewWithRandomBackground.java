package com.example.maksbkstgcom.customlayoutview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by maks on 8/9/16.
 * email: m.levytskiy@gmail.com
 */
public class ViewWithRandomBackground extends View {

    public ViewWithRandomBackground(Context context) {
        super(context);
        init();
    }

    public ViewWithRandomBackground(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViewWithRandomBackground(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setBackgroundColor(getRandomColor());
    }

    private int getRandomColor() {
        Random rand = new Random();
        return Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

}
