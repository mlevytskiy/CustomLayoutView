package com.example.maksbkstgcom.customlayoutview;

import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by maks on 8/10/16.
 * email: m.levytskiy@gmail.com
 */
public class TwoPhotoTemplate extends Template {

    @Override
    public RectF getRectF(float layoutWidth, float layoutHeight, int position) {
        if (position == 0) {
            return new RectF(0, 0, layoutWidth*2/3, layoutHeight);
        } else {
            return new RectF(layoutWidth*2/3, 0, layoutWidth, layoutHeight);
        }
    }

    @Override
    protected int getElementCount() {
        return 2;
    }

}
