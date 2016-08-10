package com.example.maksbkstgcom.customlayoutview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maks on 8/9/16.
 * email: m.levytskiy@gmail.com
 */
public class CustomLayoutView extends ViewGroup {

    private Map<Integer, Template> templateMap = new HashMap<>();

    {
        templateMap.put(1, new OnePhotoTemplate());
        templateMap.put(2, new TwoPhotoTemplate());
        templateMap.put(3, new ThreePhotoTemplate());
        templateMap.put(4, new FourPhotoTemplate());
        templateMap.put(5, new FivePhotoTemplate());
        templateMap.put(6, new CompositeTemplate(new ThreePhotoTemplate(), new ThreePhotoTemplate(), 3));
        templateMap.put(7, new CompositeTemplate(new FourPhotoTemplate(), new ThreePhotoTemplate(), 3));
        templateMap.put(8, new CompositeTemplate(new FivePhotoTemplate(), new ThreePhotoTemplate(), 3));
        templateMap.put(9, new CompositeTemplate(new FivePhotoTemplate(), new FourPhotoTemplate(), 3));
        templateMap.put(10, new CompositeTemplate(new FivePhotoTemplate(), new FivePhotoTemplate(), 3));
    }

    private int customCount = 0;

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
        Template template;
        if (customCount > 0) {
            template = templateMap.get(customCount);
        } else {
            template = templateMap.get(count);
        }

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            Rect rect = template.getRect(getMeasuredWidth(), getMeasuredHeight(), i);
            child.layout(rect.left, rect.top, rect.right, rect.bottom);
        }

    }

    public void setCustomCount(int value) {
        customCount = value;
    }

}
