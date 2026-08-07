package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.navigation.NavigationBarView;
import com.microsoft.intune.mam.client.widget.MAMTextView;
import com.pspdfkit.R;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.s60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;

/* JADX INFO: loaded from: classes3.dex */
public class FreeTextAnnotationPreviewInspectorView extends FrameLayout implements PropertyInspectorView, OnAnnotatingModeSettingsChangeListener {
    private final AnnotatingController annotationCreationController;
    private final TextView textView;
    private final Matrix unscaledPageToViewTransformation;

    public FreeTextAnnotationPreviewInspectorView(Context context, AnnotatingController annotatingController) {
        super(context);
        this.unscaledPageToViewTransformation = new Matrix();
        uw.a(annotatingController, "annotationCreationController", null);
        this.annotationCreationController = annotatingController;
        TypedArray typedArrayA = ex.a(context);
        typedArrayA.getDimensionPixelSize(R.styleable.pspdf__PropertyInspector_pspdf__itemHeight, context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_item_height));
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__backgroundColor, -1);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__progressBackgroundTint, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__textColor, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__errorColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight);
        typedArrayA.getBoolean(R.styleable.pspdf__PropertyInspector_pspdf__searchVisible, false);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__buttonIconTint, f60.a(context, androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight));
        typedArrayA.recycle();
        context.getResources().getDimension(R.dimen.pspdf__inspector_text_size);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_preview_item_height);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_padding);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_vertical_padding);
        setPadding(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3);
        MAMTextView mAMTextView = new MAMTextView(context);
        this.textView = mAMTextView;
        mAMTextView.setIncludeFontPadding(false);
        mAMTextView.setSingleLine(false);
        mAMTextView.setGravity(NavigationBarView.ITEM_GRAVITY_START_CENTER);
        mAMTextView.setTypeface(ar.c().b().getDefaultTypeface());
        mAMTextView.setHeight(dimensionPixelSize);
        mAMTextView.setText(R.string.pspdf__sample);
        addView(mAMTextView, -1, -2);
    }

    private void refreshAnnotationCreationParams() {
        this.textView.setTextColor(this.annotationCreationController.getColor());
        this.textView.setAlpha(this.annotationCreationController.getAlpha());
        this.textView.setTextSize(0, s60.a(this.unscaledPageToViewTransformation) * this.annotationCreationController.getTextSize());
        this.textView.setBackgroundColor(this.annotationCreationController.getFillColor());
        this.textView.setTypeface(this.annotationCreationController.getFont().getDefaultTypeface());
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
        ex.a(this.annotationCreationController.getFragment(), this.unscaledPageToViewTransformation);
        refreshAnnotationCreationParams();
        this.annotationCreationController.addOnSettingsChangeListener(this);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMaxHeight() {
        return 0;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMinHeight() {
        return 0;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getSuggestedHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public View getView() {
        return this;
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener
    public void onAnnotatingModeSettingsChange(AnnotatingController annotatingController) {
        refreshAnnotationCreationParams();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        this.annotationCreationController.removeOnSettingsChangeListener(this);
    }
}
