package com.example.maksbkstgcom.customlayoutview;

import android.graphics.RectF;

/**
 * Created by maks on 8/10/16.
 * email: m.levytskiy@gmail.com
 */
public class FivePhotoTemplate extends Template {

    @Override
    public RectF getRectF(float layoutWidth, float layoutHeight, int position) {
        switch (position) {
            case 0 : return new RectF(0, 0, layoutWidth*2/3, layoutHeight*4/7);
            case 1 : return new RectF(layoutWidth*2/3, 0, layoutWidth , layoutHeight*2/3);
            case 2 : return new RectF(layoutWidth*2/3, layoutHeight*2/3, layoutWidth , layoutHeight);
            case 3 : return new RectF(0, layoutHeight*4/7, layoutWidth*2/3/2 , layoutHeight);
            case 4 : return new RectF(layoutWidth*2/3/2, layoutHeight*4/7, layoutWidth*2/3 , layoutHeight);
            default: return new RectF(layoutWidth*2/3, layoutHeight*2/3, 1, 1);
        }
    }

    @Override
    protected int getElementCount() {
        return 5;
    }

}
