package com.pspdfkit.ui.inspector.views;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorView;

/* JADX INFO: loaded from: classes3.dex */
public class PropertyInspectorDividerDecoration extends PropertyInspector.ItemDecoration {
    private final Drawable divider;

    public PropertyInspectorDividerDecoration(Context context) {
        this(context, null);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspector.ItemDecoration
    public void getItemOffsets(Rect rect, PropertyInspectorView propertyInspectorView, PropertyInspector propertyInspector) {
        super.getItemOffsets(rect, propertyInspectorView, propertyInspector);
        if (this.divider == null || propertyInspector.indexOfInspectorView(propertyInspectorView) == propertyInspector.getInspectorViewCount() - 1) {
            return;
        }
        rect.bottom = this.divider.getIntrinsicHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspector.ItemDecoration
    public void onDrawOver(Canvas canvas, PropertyInspector propertyInspector) {
        if (this.divider == null) {
            super.onDrawOver(canvas, propertyInspector);
        }
        int paddingLeft = propertyInspector.getPaddingLeft();
        int width = propertyInspector.getWidth() - propertyInspector.getPaddingRight();
        int inspectorViewCount = propertyInspector.getInspectorViewCount();
        for (int i = 0; i < inspectorViewCount - 1; i++) {
            int bottom = propertyInspector.getInspectorView(i).getView().getBottom();
            Drawable drawable = this.divider;
            drawable.setBounds(paddingLeft, bottom, width, drawable.getIntrinsicHeight() + bottom);
            this.divider.draw(canvas);
        }
    }

    public PropertyInspectorDividerDecoration(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.listDivider});
        this.divider = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public PropertyInspectorDividerDecoration(Drawable drawable) {
        this.divider = drawable;
    }
}
