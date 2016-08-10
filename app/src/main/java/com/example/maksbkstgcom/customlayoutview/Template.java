package com.example.maksbkstgcom.customlayoutview;

import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by maks on 8/10/16.
 * email: m.levytskiy@gmail.com
 */
public abstract class Template {

    public abstract RectF getRectF(float layoutWidth, float layoutHeight, int position);

    protected abstract int getElementCount();

    public Rect getRect(float layoutWidth, float layoutHeight, int position) {
        RectF rectF = getRectF(layoutWidth, layoutHeight, position);
        return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

}
