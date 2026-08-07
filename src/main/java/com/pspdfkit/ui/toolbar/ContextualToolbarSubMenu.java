package com.pspdfkit.ui.toolbar;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.core.view.ViewCompat;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import com.pspdfkit.internal.a80;
import io.reactivex.rxjava3.core.Completable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ContextualToolbarSubMenu extends MAMViewGroup {
    private static final int FADING_EDGE_SIZE_DP = 48;
    private int backgroundColor;
    private int borderColor;
    private final int cornerRadiusPx;
    private final int fadingEdgeSize;
    private HorizontalScrollView horizontalScrollView;
    private final ContextualToolbarMenuBar menuBar;
    private ScrollView verticalScrollView;

    public ContextualToolbarSubMenu(Context context) {
        this(context, null);
    }

    private void refreshBackgroundColor() {
        float[] fArr;
        ToolbarCoordinatorLayout.LayoutParams.Position position = getPosition();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (position == ToolbarCoordinatorLayout.LayoutParams.Position.TOP) {
            float f = this.cornerRadiusPx;
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f};
        } else if (position == ToolbarCoordinatorLayout.LayoutParams.Position.LEFT) {
            float f2 = this.cornerRadiusPx;
            fArr = new float[]{0.0f, 0.0f, f2, f2, f2, f2, 0.0f, 0.0f};
        } else {
            float f3 = this.cornerRadiusPx;
            fArr = new float[]{f3, f3, 0.0f, 0.0f, 0.0f, 0.0f, f3, f3};
        }
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(this.backgroundColor);
        gradientDrawable.setStroke(1, this.borderColor);
        ViewCompat.setBackground(this, gradientDrawable);
    }

    public ContextualToolbarMenuBar getMenuBar() {
        return this.menuBar;
    }

    public ToolbarCoordinatorLayout.LayoutParams.Position getPosition() {
        ToolbarCoordinatorLayout.LayoutParams layoutParams;
        ToolbarCoordinatorLayout.LayoutParams.Position position = ToolbarCoordinatorLayout.LayoutParams.Position.TOP;
        if (!(getParent() instanceof ContextualToolbar) || (layoutParams = (ToolbarCoordinatorLayout.LayoutParams) ((ContextualToolbar) getParent()).getLayoutParams()) == null) {
            return position;
        }
        ToolbarCoordinatorLayout.LayoutParams.Position position2 = layoutParams.forcedPosition;
        return position2 != null ? position2 : layoutParams.position;
    }

    public Completable hideMenuItems(boolean z) {
        return this.menuBar.hideMenuItems(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            refreshBackgroundColor();
        }
        if (getPosition() == ToolbarCoordinatorLayout.LayoutParams.Position.TOP) {
            HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
            if (horizontalScrollView != null) {
                horizontalScrollView.layout(0, 0, horizontalScrollView.getMeasuredWidth(), this.horizontalScrollView.getMeasuredHeight());
                return;
            }
            return;
        }
        ScrollView scrollView = this.verticalScrollView;
        if (scrollView != null) {
            scrollView.layout(0, 0, scrollView.getMeasuredWidth(), this.verticalScrollView.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (getPosition() == ToolbarCoordinatorLayout.LayoutParams.Position.TOP) {
            if (this.horizontalScrollView == null) {
                HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
                this.horizontalScrollView = horizontalScrollView;
                horizontalScrollView.setHorizontalScrollBarEnabled(false);
                this.horizontalScrollView.setHorizontalFadingEdgeEnabled(true);
                this.horizontalScrollView.setFadingEdgeLength(this.fadingEdgeSize);
                this.horizontalScrollView.setOverScrollMode(2);
                refreshBackgroundColor();
            }
            ScrollView scrollView = this.verticalScrollView;
            if (scrollView != null && scrollView.getParent() == this) {
                removeView(this.verticalScrollView);
                this.verticalScrollView.removeAllViews();
            }
            if (this.horizontalScrollView.getParent() == null) {
                this.horizontalScrollView.addView(this.menuBar);
                addView(this.horizontalScrollView);
            }
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == Integer.MIN_VALUE && this.menuBar.getTotalChildrenSize().getWidth() > size) {
                size = this.menuBar.getScrollableMenuBarSize(size);
            }
            this.horizontalScrollView.measure(View.MeasureSpec.makeMeasureSpec(size, mode), i2);
            setMeasuredDimension(this.horizontalScrollView.getMeasuredWidth(), this.horizontalScrollView.getMeasuredHeight());
            return;
        }
        if (this.verticalScrollView == null) {
            ScrollView scrollView2 = new ScrollView(getContext());
            this.verticalScrollView = scrollView2;
            scrollView2.setVerticalScrollBarEnabled(false);
            this.verticalScrollView.setVerticalFadingEdgeEnabled(true);
            this.verticalScrollView.setFadingEdgeLength(this.fadingEdgeSize);
            this.verticalScrollView.setOverScrollMode(2);
            refreshBackgroundColor();
        }
        HorizontalScrollView horizontalScrollView2 = this.horizontalScrollView;
        if (horizontalScrollView2 != null && horizontalScrollView2.getParent() == this) {
            removeView(this.horizontalScrollView);
            this.horizontalScrollView.removeAllViews();
        }
        if (this.verticalScrollView.getParent() == null) {
            this.verticalScrollView.addView(this.menuBar);
            addView(this.verticalScrollView);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE && this.menuBar.getTotalChildrenSize().getHeight() > size2) {
            size2 = this.menuBar.getScrollableMenuBarSize(size2);
        }
        this.verticalScrollView.measure(i, View.MeasureSpec.makeMeasureSpec(size2, mode2));
        setMeasuredDimension(this.verticalScrollView.getMeasuredWidth(), this.verticalScrollView.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.menuBar.removeAllViews();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
        this.menuBar.setBackgroundColor(i);
        refreshBackgroundColor();
    }

    public void setBorderAndBackroundColor(int i, int i2) {
        setBorderColor(i);
        setBackgroundColor(i2);
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
    }

    public void setMenuItems(List<ContextualToolbarMenuItem> list) {
        this.menuBar.setMenuItems(list);
    }

    public Completable showMenuItems(boolean z) {
        return this.menuBar.showMenuItems(z);
    }

    public ContextualToolbarSubMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContextualToolbarSubMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ContextualToolbarMenuBar contextualToolbarMenuBar = new ContextualToolbarMenuBar(context, attributeSet, i);
        this.menuBar = contextualToolbarMenuBar;
        contextualToolbarMenuBar.setIsSubmenu(true);
        this.cornerRadiusPx = contextualToolbarMenuBar.getCornerRadiusPx();
        this.fadingEdgeSize = a80.a(getContext(), 48);
    }
}
