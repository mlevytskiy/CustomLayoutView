package com.example.maksbkstgcom.customlayoutview;

import android.graphics.RectF;

/**
 * Created by maks on 8/10/16.
 * email: m.levytskiy@gmail.com
 */
public class OnePhotoTemplate extends Template {

    @Override
    public RectF getRectF(float layoutWidth, float layoutHeight, int position) {
        return new RectF(0, 0, layoutWidth, layoutHeight);
    }

    @Override
    protected int getElementCount() {
        return 1;
    }

}
