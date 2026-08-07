package com.pspdfkit.internal;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.pspdfkit.R;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;

/* JADX INFO: loaded from: classes3.dex */
public final class rk extends FrameLayout implements PropertyInspectorView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rk(Context context) {
        super(context);
        context.getClass();
        addView(View.inflate(context, R.layout.pspdf__view_inspector_spacer, null));
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public final void bindController(PropertyInspectorController propertyInspectorController) {
        propertyInspectorController.getClass();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMaxHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMinHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getSuggestedHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public View getView() {
        return this;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public final void unbindController() {
    }
}
