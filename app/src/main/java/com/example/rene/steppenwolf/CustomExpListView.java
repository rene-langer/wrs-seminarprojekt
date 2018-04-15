package com.example.rene.steppenwolf;

import android.content.Context;
import android.widget.ExpandableListView;

/**
 * https://github.com/ngocchung/ThreeLevelExpListView
 */

public class CustomExpListView extends ExpandableListView {
    public CustomExpListView(Context context) {
        super(context);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(960, MeasureSpec.AT_MOST);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(600, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
