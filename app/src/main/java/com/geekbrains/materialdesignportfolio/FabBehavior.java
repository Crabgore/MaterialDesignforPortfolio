package com.geekbrains.materialdesignportfolio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FabBehavior extends FloatingActionButton.Behavior {

    public FabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                               @NonNull FloatingActionButton child, @NonNull View target,
                               int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed,
                               int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed,
                dyUnconsumed, type);

        if (dyConsumed > 0) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            int margin = layoutParams.bottomMargin;
            child.animate().translationY(child.getWidth() + margin).setInterpolator(new AnticipateOvershootInterpolator()).start();
        } else if (dyConsumed < 0 ) {
            child.animate().translationY(0).setInterpolator(new AnticipateOvershootInterpolator()).start();
        }
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull FloatingActionButton child,
                                       @NonNull View directTargetChild, @NonNull View target,
                                       int axes, int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }
}
