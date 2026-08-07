package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.pspdfkit.internal.h9;
import com.pspdfkit.internal.n70;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerInspectorDetailView extends ScrollView implements ColorPickerInspectorView.ColorPickerDetailView {
    private static final double DEFAULT_MIN_ROWS_COUNT = 1.5d;
    private h9 colorPickerView;
    private final List<Integer> colors;

    public ColorPickerInspectorDetailView(Context context, int[] iArr, int i, boolean z) {
        this(context, n70.a(iArr), i, z);
    }

    private void init(Context context, int i, boolean z) {
        h9 h9Var = new h9(context, this.colors, z);
        this.colorPickerView = h9Var;
        h9Var.setShowSelectionIndicator(true);
        h9 h9Var2 = this.colorPickerView;
        if (h9Var2.f != i) {
            h9Var2.f = i;
            h9Var2.a();
        }
        addView(this.colorPickerView, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnColorPickedListener$0(ColorPickerInspectorView.ColorPickerListener colorPickerListener, h9 h9Var, int i) {
        colorPickerListener.onColorPicked(this, i);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
    }

    @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerDetailView
    public int getMaximumHeight() {
        return this.colorPickerView.getMeasuredHeight();
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        h9 h9Var = this.colorPickerView;
        int measuredWidth = getMeasuredWidth() - 10;
        return ((h9Var.b ? (int) ((((double) measuredWidth) / 5.5d) - 10.0d) : (measuredWidth / 5) - 10) + 10) * ((int) Math.min(this.colors.size() / 5.0f, 1.5d));
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMaxHeight() {
        return getMaximumHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMinHeight() {
        return getMinimumHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getSuggestedHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public View getView() {
        return this;
    }

    @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerDetailView
    public void setOnColorPickedListener(final ColorPickerInspectorView.ColorPickerListener colorPickerListener) {
        h9 h9Var = this.colorPickerView;
        if (colorPickerListener != null) {
            h9Var.setOnColorPickedListener(new h9.a() { // from class: com.pspdfkit.ui.inspector.views.ColorPickerInspectorDetailView$$ExternalSyntheticLambda0
                @Override // com.pspdfkit.internal.h9.a
                public final void a(h9 h9Var2, int i) {
                    this.f$0.lambda$setOnColorPickedListener$0(colorPickerListener, h9Var2, i);
                }
            });
        } else {
            h9Var.setOnColorPickedListener(null);
        }
    }

    public void setShowSelectionIndicator(boolean z) {
        this.colorPickerView.setShowSelectionIndicator(z);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
    }

    public ColorPickerInspectorDetailView(Context context, List<Integer> list, int i, boolean z) {
        super(context);
        uw.a(list, "colors", null);
        this.colors = new ArrayList(list);
        init(context, i, z);
    }
}
