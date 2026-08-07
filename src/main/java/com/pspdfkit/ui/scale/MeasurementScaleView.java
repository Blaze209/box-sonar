package com.pspdfkit.ui.scale;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.internal.d60;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.p0;
import com.pspdfkit.internal.p10;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MeasurementScaleView extends FrameLayout {
    private AnnotatingController controller;
    private boolean isFabTargetVisible;
    private ViewGroup measurementScaleContainer;
    private ImageView scaleNotSetIcon;
    private TextView scaleTextView;
    private ImageView settingsIconView;

    public MeasurementScaleView(Context context) {
        super(context);
        this.isFabTargetVisible = false;
        init();
    }

    private void init() {
        Context context = getContext();
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__MeasurementTool, R.attr.pspdf__measurementToolsStyle, R.style.PSPDFKit_MeasurementTools);
        typedArrayObtainStyledAttributes.getClass();
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__measurementValuePopupBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryDark));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleListItemBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleListItemCheckColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleButtonForegroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleButtonBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        LayoutInflater.from(getContext()).inflate(R.layout.pspdf__measurement_scale_view, (ViewGroup) this, true);
        this.measurementScaleContainer = (ViewGroup) findViewById(R.id.pspdf_measurement_scale_view_container);
        this.scaleTextView = (TextView) findViewById(R.id.pspdf__measurement_scale_view_label);
        this.scaleNotSetIcon = (ImageView) findViewById(R.id.pspdf_meassurement_scale_view_not_set);
        ImageView imageView = (ImageView) findViewById(R.id.pspdf__measurement_scale_view_settings_icon);
        this.settingsIconView = imageView;
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color));
        CardView cardView = (CardView) findViewById(R.id.pspdf_measurement_scale_view_button);
        cardView.setCardBackgroundColor(color2);
        cardView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.scale.MeasurementScaleView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$init$0(View view) {
        int i;
        AnnotatingController annotatingController = this.controller;
        if (annotatingController == null) {
            return;
        }
        AnnotationTool activeAnnotationTool = annotatingController.getActiveAnnotationTool();
        if (activeAnnotationTool == null || ((i = p10.a.b[activeAnnotationTool.ordinal()]) != 1 && i != 2 && i != 3 && i != 4 && i != 5)) {
            List<Annotation> currentlySelectedAnnotations = this.controller.getCurrentlySelectedAnnotations();
            currentlySelectedAnnotations.getClass();
            if (currentlySelectedAnnotations.isEmpty()) {
                return;
            }
            Iterator<T> it = currentlySelectedAnnotations.iterator();
            while (it.hasNext()) {
                if (((Annotation) it.next()).isMeasurement()) {
                }
            }
            return;
        }
        this.controller.displayScalePicker();
    }

    public void bindController(AnnotatingController annotatingController) {
        this.controller = annotatingController;
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        super.fitSystemWindows(rect);
        return false;
    }

    public void setMeasurementScaleViewVisibility(boolean z, boolean z2) {
        if (this.isFabTargetVisible == z) {
            return;
        }
        this.isFabTargetVisible = z;
        ViewGroup viewGroup = this.measurementScaleContainer;
        if (z) {
            p0.b(viewGroup, z2);
        } else {
            p0.a(viewGroup, z2);
        }
    }

    public void unbindController() {
        if (this.controller != null) {
            this.controller = null;
        }
        setMeasurementScaleViewVisibility(false, true);
    }

    public void updateScaleLabel(String str, boolean z) {
        if (!z) {
            this.scaleTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.pspdf__errorContainer));
            this.scaleTextView.setText(no.a(getContext(), R.string.pspdf__set_scale, null));
            this.scaleNotSetIcon.setVisibility(0);
            return;
        }
        Context context = getContext();
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__MeasurementTool, R.attr.pspdf__measurementToolsStyle, R.style.PSPDFKit_MeasurementTools);
        typedArrayObtainStyledAttributes.getClass();
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__measurementValuePopupBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryDark));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleListItemBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleListItemCheckColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleButtonForegroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleButtonBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.scaleTextView.setTextColor(color);
        d60.a(this.scaleTextView, str);
        this.scaleNotSetIcon.setVisibility(8);
    }

    public MeasurementScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isFabTargetVisible = false;
        init();
    }

    public MeasurementScaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isFabTargetVisible = false;
        init();
    }
}
