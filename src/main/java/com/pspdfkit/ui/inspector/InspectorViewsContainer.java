package com.pspdfkit.ui.inspector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class InspectorViewsContainer extends MAMViewGroup {
    private final Rect insets;
    private PropertyInspector parent;
    private final Rect tempRect;
    private int verticalInset;

    public InspectorViewsContainer(Context context) {
        super(context);
        this.insets = new Rect();
        this.tempRect = new Rect();
        this.verticalInset = 0;
    }

    private void getChildDecorationInsets(PropertyInspectorView propertyInspectorView, Rect rect) {
        if (this.parent == null) {
            throw new NullPointerException("parent PropertyInspector");
        }
        rect.set(0, 0, 0, 0);
        for (PropertyInspector.ItemDecoration itemDecoration : this.parent.getItemDecorations()) {
            this.tempRect.set(0, 0, 0, 0);
            itemDecoration.getItemOffsets(this.tempRect, propertyInspectorView, this.parent);
            int i = rect.left;
            Rect rect2 = this.tempRect;
            rect.left = i + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void measureChild(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        getChildDecorationInsets((PropertyInspectorView) view, this.insets);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i2 += marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i4 += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        Rect rect = this.insets;
        view.measure(ViewGroup.getChildMeasureSpec(i, rect.left + rect.right + i2, layoutParams.width), ViewGroup.getChildMeasureSpec(i3, rect.top + rect.bottom + i4, layoutParams.height));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        PropertyInspector propertyInspector = this.parent;
        if (propertyInspector == null) {
            throw new NullPointerException("parent PropertyInspector");
        }
        Iterator<PropertyInspector.ItemDecoration> it = propertyInspector.getItemDecorations().iterator();
        while (it.hasNext()) {
            it.next().onDraw(canvas, this.parent);
        }
        super.dispatchDraw(canvas);
        Iterator<PropertyInspector.ItemDecoration> it2 = this.parent.getItemDecorations().iterator();
        while (it2.hasNext()) {
            it2.next().onDrawOver(canvas, this.parent);
        }
    }

    public int getVerticalInset() {
        return this.verticalInset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            getChildDecorationInsets((PropertyInspectorView) childAt, this.insets);
            int i6 = this.insets.left + i;
            if (childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i6 += marginLayoutParams.leftMargin;
                i2 += marginLayoutParams.topMargin;
            }
            int i7 = i2 + this.insets.top;
            childAt.layout(i6, i7, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i7);
            i2 = i7 + childAt.getMeasuredHeight() + this.insets.bottom;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        if (mode2 != 1073741824) {
            int i3 = 0;
            size2 = paddingRight;
            while (i3 < this.getChildCount()) {
                View childAt = this.getChildAt(i3);
                InspectorViewsContainer inspectorViewsContainer = this;
                int i4 = i;
                int i5 = i2;
                inspectorViewsContainer.measureChild(childAt, i4, paddingRight, i5, 0);
                int measuredWidth = childAt.getMeasuredWidth();
                Rect rect = inspectorViewsContainer.insets;
                size2 = Math.max(measuredWidth + rect.left + rect.right, size2);
                i3++;
                this = inspectorViewsContainer;
                i = i4;
                i2 = i5;
            }
        }
        InspectorViewsContainer inspectorViewsContainer2 = this;
        int i6 = i;
        int i7 = i2;
        if (mode != 1073741824) {
            int paddingBottom = inspectorViewsContainer2.getPaddingBottom() + inspectorViewsContainer2.getPaddingTop();
            inspectorViewsContainer2.verticalInset = 0;
            int i8 = paddingBottom;
            for (int i9 = 0; i9 < inspectorViewsContainer2.getChildCount(); i9++) {
                View childAt2 = inspectorViewsContainer2.getChildAt(i9);
                inspectorViewsContainer2.measureChild(childAt2, i6, paddingRight, i7, i8);
                int measuredHeight = childAt2.getMeasuredHeight();
                Rect rect2 = inspectorViewsContainer2.insets;
                int i10 = rect2.top;
                int i11 = rect2.bottom;
                i8 += measuredHeight + i10 + i11;
                inspectorViewsContainer2.verticalInset = i10 + i11 + inspectorViewsContainer2.verticalInset;
            }
            size = i8;
        }
        inspectorViewsContainer2.setMeasuredDimension(size2, size);
    }

    public void setParentInspector(PropertyInspector propertyInspector) {
        this.parent = propertyInspector;
    }

    public InspectorViewsContainer(Context context, PropertyInspector propertyInspector) {
        this(context);
        this.parent = propertyInspector;
    }
}
