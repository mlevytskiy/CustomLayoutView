package com.example.maksbkstgcom.customlayoutview;

import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by maks on 8/10/16.
 * email: m.levytskiy@gmail.com
 */
public class CompositeTemplate extends Template {

    private Template t1;
    private Template t2;
    private boolean isVertical = false;//getRandomBoolean();
    private int divCoef;


    public CompositeTemplate(Template t1, Template t2, int difCoef) {
        this.t1 = t1;
        this.t2 = t2;
        this.divCoef = difCoef;
    }

    @Override
    public RectF getRectF(float layoutWidth, float layoutHeight, int position) {
        RectF[] rectFs;
        if (isVertical) {
            rectFs = divVertical(new RectF(0, 0, layoutWidth, layoutHeight), (int) (layoutWidth/divCoef));
        } else {
            rectFs = divHorizontal(new RectF(0, 0, layoutWidth, layoutHeight), (int) (layoutHeight/divCoef));
        }
        if (position < t1.getElementCount()) {
            return t1.getRectF(rectFs[0].right - rectFs[0].left, rectFs[0].bottom - rectFs[0].top, position);
        } else {
            position = position - t1.getElementCount();
            RectF rectF = t2.getRectF(rectFs[1].right - rectFs[1].left, rectFs[1].bottom - rectFs[1].top, position);
            if (isVertical) {
                int x = (int) (layoutWidth/divCoef);
                rectF.right = rectF.right + x;
                rectF.left = rectF.left + x;
            } else {
                int y = (int) (layoutHeight/divCoef);
                rectF.bottom = rectF.bottom + y;
                rectF.top = rectF.top + y;
            }
            return rectF;
        }
    }

    @Override
    protected int getElementCount() {
        return t1.getElementCount() + t2.getElementCount();
    }

    private RectF[] divVertical(RectF rect, int x) {

        RectF[] result = new RectF[2];
        result[0] = new RectF(rect.left, rect.top, x, rect.bottom);
        result[1] = new RectF(x, rect.top, rect.right, rect.bottom);

        return result;
    }

    private RectF[] divHorizontal(RectF rect, int y) {
        RectF[] result = new RectF[2];
        result[0] = new RectF(rect.left, rect.top, rect.right, y);
        result[1] = new RectF(rect.left, y, rect.right, rect.bottom);
        return result;
    }

    private boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

}
