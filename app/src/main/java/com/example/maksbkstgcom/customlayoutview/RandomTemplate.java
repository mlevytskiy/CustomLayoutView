package com.example.maksbkstgcom.customlayoutview;

import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by maks on 8/10/16.
 * email: m.levytskiy@gmail.com
 */
public class RandomTemplate extends Template {

    private Rect[] rects;
    private static final int FAKE_HEIGHT = 600;
    private static final int FAKE_WIDTH = 350;

    public RandomTemplate(int count) {
        Rect parentRect = new Rect(0, 0, FAKE_WIDTH, FAKE_HEIGHT);
        rects = randomRects(count, parentRect);
    }

    @Override
    public RectF getRectF(float layoutWidth, float layoutHeight, int position) {
        return null;
    }

    @Override
    protected int getElementCount() {
        return 10;
    }


    public Rect getRect(float layoutWidth, float layoutHeight, int position) {
        Rect rect = rects[position];
//        float ch = layoutHeight/FAKE_HEIGHT;
//        float cw = layoutWidth/FAKE_WIDTH;
//        Rect resultRect = new Rect(rect);
//        resultRect.set((int) (rect.left*cw), (int) (rect.top*ch), (int) (rect.right*cw), (int) (rect.bottom*ch));
        return rect;
    }

    private Rect[] divRect(Rect rect) {
        float diff = (float) Math.random() * 3 + 1;
        if (Math.random() < 0.5) {
            return divVertical(rect, (int)((rect.right + rect.left)/diff));
        } else {
            return divHorizontal(rect, (int)((rect.bottom + rect.top)/diff));
        }
//


//        return divHorizontal(rect);
//        if (rect.width() * 3 < rect.height()) {
//            return divVertical(rect);
//        } else if (rect.height() * 2 < rect.width()) {
//            return divHorizontal(rect);
//        }
//        return divVertical(rect);
    }

    private Rect[] divRect(Rect rect, int x, int y) {
        Rect[] rects = new Rect[4];
        rects[0] = new Rect(rect.left, rect.top, x, y);
        rects[1] = new Rect(x, rect.left, rect.right, y);
        rects[2] = new Rect(rect.left, y, x, rect.bottom);
        rects[3] = new Rect(x, y, rect.right, rect.bottom);
        return rects;
    }

    private Rect[] divVertical(Rect rect, int x) {

        Rect[] result = new Rect[2];
        result[0] = new Rect(rect.left, rect.top, x, rect.bottom);
        result[1] = new Rect(x, rect.top, rect.right, rect.bottom);

        return result;
    }

    private Rect[] divHorizontal(Rect rect, int y) {
        Rect[] result = new Rect[2];
        result[0] = new Rect(rect.left, rect.top, rect.right, y);
        result[1] = new Rect(rect.left, y, rect.right, rect.bottom);
        return result;
    }

    private Rect choiceRect(Rect[] rects) {
//        int randomRectIndex = (int) (rects.length * Math.random());
        return rects[rects.length-1];
    }

    private Rect[] randomRects(int count, Rect parentRect) {
        if (count == 1) {
            return new Rect[] {parentRect};
        } else if (count == 2) {
            return divRect(parentRect);
        } else {
            Rect[] result = new Rect[count];
            Rect randomRect = parentRect;
            for (int  i = count-1; i >= 0; i--) {
                if ( i == 0) {
                    result[0] = parentRect;
                }
                Rect[] rects = divRect(randomRect);
                randomRect = choiceRect(rects);
                randomRects(i, randomRect);
                result[i] = anotherRect(randomRect, rects);
            }
            return result;
        }
    }

    private Rect anotherRect(Rect rect, Rect[] rects) {
        for (Rect item : rects) {
            if (rect != item) {
                return item;
            }
        }
        return null;
    }
}
