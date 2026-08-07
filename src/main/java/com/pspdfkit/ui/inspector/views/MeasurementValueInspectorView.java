package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.zs;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;

/* JADX INFO: loaded from: classes3.dex */
public class MeasurementValueInspectorView extends FrameLayout implements PropertyInspectorView {
    private final Annotation annotation;
    private final String label;
    private TextView measurementValueView;
    private zs onAnnotationPropertyChangeListener;

    public MeasurementValueInspectorView(Context context, String str, String str2, Annotation annotation) {
        super(context);
        uw.a(str, "label", null);
        uw.a(str2, "measurementValue", null);
        uw.a(annotation, "annotation", null);
        this.label = str;
        this.annotation = annotation;
        init(str2);
    }

    private void init(String str) {
        Context context = getContext();
        TypedArray typedArrayA = ex.a(context);
        int dimensionPixelSize = typedArrayA.getDimensionPixelSize(R.styleable.pspdf__PropertyInspector_pspdf__itemHeight, context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_item_height));
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__backgroundColor, -1);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__progressBackgroundTint, -7829368);
        int color = typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__textColor, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__errorColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        int color2 = ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight);
        typedArrayA.getBoolean(R.styleable.pspdf__PropertyInspector_pspdf__searchVisible, false);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__buttonIconTint, f60.a(context, androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight));
        typedArrayA.recycle();
        float dimension = context.getResources().getDimension(R.dimen.pspdf__inspector_text_size);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_preview_item_height);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_padding);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_vertical_padding);
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_measurement_value, null);
        viewInflate.setMinimumHeight(dimensionPixelSize);
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__label);
        textView.setText(this.label);
        textView.setTextColor(color);
        textView.setTextSize(0, dimension);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.pspdf__value_text);
        this.measurementValueView = textView2;
        textView2.setTextSize(0, dimension);
        this.measurementValueView.setTextColor(color2);
        addView(viewInflate, new FrameLayout.LayoutParams(-1, -2));
        setMeasurementValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onShown$0(Annotation annotation, int i, Object obj, Object obj2) {
        setMeasurementValue(this.annotation.getContents());
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
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
    public void onHidden() {
        super.onHidden();
        if (this.onAnnotationPropertyChangeListener != null) {
            this.annotation.getInternal().removeOnAnnotationPropertyChangeListener(this.onAnnotationPropertyChangeListener);
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void onShown() {
        super.onShown();
        if (this.annotation.getContents() == null || this.annotation.getContents().isEmpty()) {
            return;
        }
        this.onAnnotationPropertyChangeListener = new zs() { // from class: com.pspdfkit.ui.inspector.views.MeasurementValueInspectorView$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.zs
            public final void onAnnotationPropertyChange(Annotation annotation, int i, Object obj, Object obj2) {
                this.f$0.lambda$onShown$0(annotation, i, obj, obj2);
            }
        };
        this.annotation.getInternal().addOnAnnotationPropertyChangeListener(this.onAnnotationPropertyChangeListener);
    }

    public void setMeasurementValue(String str) {
        if (str.isEmpty()) {
            return;
        }
        this.measurementValueView.setText(str);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
    }
}
