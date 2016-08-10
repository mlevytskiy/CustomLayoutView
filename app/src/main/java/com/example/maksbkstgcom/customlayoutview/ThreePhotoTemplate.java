package com.example.maksbkstgcom.customlayoutview;

import android.graphics.RectF;

/**
 * Created by maks on 8/10/16.
 * email: m.levytskiy@gmail.com
 */
public class ThreePhotoTemplate extends Template {

    @Override
    public RectF getRectF(float layoutWidth, float layoutHeight, int position) {
        switch (position) {
            case 0 : return new RectF(0, 0, layoutWidth*2/3, layoutHeight);
            case 1 : return new RectF(layoutWidth*2/3, 0, layoutWidth , layoutHeight*2/3);
            case 2 : return new RectF(layoutWidth*2/3, layoutHeight*2/3, layoutWidth , layoutHeight);
            default: return new RectF(layoutWidth*2/3, layoutHeight*2/3, 1, 1);
        }
    }

    @Override
    protected int getElementCount() {
        return 3;
    }

}
