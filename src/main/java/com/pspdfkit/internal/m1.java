package com.pspdfkit.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.inspector.views.FreeTextAnnotationPreviewInspectorView;
import com.pspdfkit.ui.inspector.views.InkAnnotationPreviewInspectorView;
import com.pspdfkit.ui.inspector.views.ShapeAnnotationPreviewInspectorView;

/* JADX INFO: loaded from: classes3.dex */
public final class m1 extends PropertyInspector.ItemDecoration {
    public final Drawable a;

    public m1(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{R.attr.listDivider});
        this.a = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspector.ItemDecoration
    public final void getItemOffsets(Rect rect, PropertyInspectorView propertyInspectorView, PropertyInspector propertyInspector) {
        super.getItemOffsets(rect, propertyInspectorView, propertyInspector);
        Drawable drawable = this.a;
        if (drawable == null) {
            return;
        }
        if ((propertyInspectorView instanceof ShapeAnnotationPreviewInspectorView) || (propertyInspectorView instanceof InkAnnotationPreviewInspectorView) || (propertyInspectorView instanceof FreeTextAnnotationPreviewInspectorView)) {
            rect.bottom = drawable.getIntrinsicHeight();
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspector.ItemDecoration
    public final void onDrawOver(Canvas canvas, PropertyInspector propertyInspector) {
        if (this.a == null) {
            super.onDrawOver(canvas, propertyInspector);
        }
        int paddingLeft = propertyInspector.getPaddingLeft();
        int width = propertyInspector.getWidth() - propertyInspector.getPaddingRight();
        if (propertyInspector.getInspectorViewCount() > 1) {
            PropertyInspectorView inspectorView = propertyInspector.getInspectorView(0);
            if ((inspectorView instanceof ShapeAnnotationPreviewInspectorView) || (inspectorView instanceof InkAnnotationPreviewInspectorView) || (inspectorView instanceof FreeTextAnnotationPreviewInspectorView)) {
                int bottom = inspectorView.getView().getBottom();
                Drawable drawable = this.a;
                drawable.setBounds(paddingLeft, bottom, width, drawable.getIntrinsicHeight() + bottom);
                this.a.draw(canvas);
            }
        }
    }
}
