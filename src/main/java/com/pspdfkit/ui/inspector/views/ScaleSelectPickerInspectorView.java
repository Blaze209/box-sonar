package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.d60;
import com.pspdfkit.internal.dx;
import com.pspdfkit.internal.e60;
import com.pspdfkit.internal.m2;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.o00;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class ScaleSelectPickerInspectorView extends FrameLayout implements PropertyInspectorView {
    private PropertyInspectorController controller;
    private MeasurementValueConfiguration currentConfiguration;
    private ImageView errorIndicator;
    private final m2 inspectorFactory;
    private final boolean isReadOnly;
    private final String label;
    MeasurementValueConfigurationPickerListener listener;
    private final MeasurementValueConfigurationEditor measurementValueConfigurationEditor;
    private PropertyInspector parentInspector;
    private ScaleConfigurationPickerInspectorDetailView scaleConfigurationPickerInspectorDetailView;
    private ScaleListPickerInspectorDetailView scaleListPicker;
    private TextView scaleText;
    final dx style;

    private ScaleSelectPickerInspectorView(Context context, String str, MeasurementValueConfiguration measurementValueConfiguration, m2 m2Var, boolean z, MeasurementValueConfigurationEditor measurementValueConfigurationEditor, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        super(context);
        this.controller = null;
        this.scaleConfigurationPickerInspectorDetailView = null;
        this.parentInspector = null;
        uw.a(context, "context", null);
        uw.a(str, "label", null);
        if (!z) {
            uw.a(m2Var, "inspectorFactory", null);
            uw.a(measurementValueConfigurationEditor, "measurementValueConfigurationEditor", null);
        }
        this.style = new dx(context);
        this.label = str;
        this.listener = measurementValueConfigurationPickerListener;
        this.currentConfiguration = measurementValueConfiguration;
        this.inspectorFactory = m2Var;
        this.isReadOnly = z;
        this.measurementValueConfigurationEditor = measurementValueConfigurationEditor;
        init();
    }

    private void init() {
        m2 m2Var;
        Annotation annotation = null;
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_scale_select_picker, null);
        viewInflate.setMinimumHeight(this.style.a);
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__label);
        textView.setText(this.label);
        textView.setTextColor(this.style.c);
        textView.setTextSize(0, this.style.d);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.pspdf__scale_content);
        this.scaleText = textView2;
        textView2.setTextSize(0, this.style.d);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.pspdf__expand_icon);
        if (this.isReadOnly) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageDrawable(a80.a(getContext(), R.drawable.pspdf__ic_chevron_right, this.style.c));
        }
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.pspdf__error_indicator);
        this.errorIndicator = imageView2;
        imageView2.setImageDrawable(a80.a(getContext(), R.drawable.pspdf__ic_input_error, this.style.g));
        addView(viewInflate, new FrameLayout.LayoutParams(-1, -2));
        setConfiguration(this.currentConfiguration, false);
        if (this.isReadOnly || (m2Var = this.inspectorFactory) == null || this.measurementValueConfigurationEditor == null) {
            return;
        }
        FragmentSpecialModeController fragmentSpecialModeControllerA = m2Var.a();
        if (fragmentSpecialModeControllerA instanceof AnnotatingController) {
            List<Annotation> currentlySelectedAnnotations = ((AnnotatingController) fragmentSpecialModeControllerA).getCurrentlySelectedAnnotations();
            if (!currentlySelectedAnnotations.isEmpty()) {
                annotation = currentlySelectedAnnotations.get(0);
            }
        }
        this.scaleListPicker = new ScaleListPickerInspectorDetailView(getContext(), this.label, this.inspectorFactory, this.measurementValueConfigurationEditor, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleSelectPickerInspectorView$$ExternalSyntheticLambda1
            @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
            public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration) {
                this.f$0.onConfigurationPicked(measurementValueConfiguration);
            }
        }, annotation);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleSelectPickerInspectorView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        showDetailView(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    /* JADX WARN: Code duplicated, block: B:15:0x0026  */
    public void lambda$showDetailView$1(MeasurementValueConfiguration measurementValueConfiguration) {
        o00 o00Var;
        if (Intrinsics.areEqual(e60.a, measurementValueConfiguration)) {
            MeasurementValueConfiguration measurementValueConfiguration2 = e60.a;
            if (!Intrinsics.areEqual(measurementValueConfiguration2 != null ? measurementValueConfiguration2.getName() : null, measurementValueConfiguration != null ? measurementValueConfiguration.getName() : null)) {
                e60.a = measurementValueConfiguration;
                o00Var = e60.b;
                if (o00Var != null) {
                    o00Var.a(measurementValueConfiguration);
                }
            }
        } else {
            e60.a = measurementValueConfiguration;
            o00Var = e60.b;
            if (o00Var != null) {
                o00Var.a(measurementValueConfiguration);
            }
        }
        ScaleListPickerInspectorDetailView scaleListPickerInspectorDetailView = this.scaleListPicker;
        if (scaleListPickerInspectorDetailView != null) {
            scaleListPickerInspectorDetailView.refreshScales();
        }
        setConfiguration(measurementValueConfiguration, true);
        MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener = this.listener;
        if (measurementValueConfigurationPickerListener != null) {
            measurementValueConfigurationPickerListener.onConfigurationPicked(measurementValueConfiguration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration) {
        setConfiguration(measurementValueConfiguration, true);
    }

    private void showDetailView(boolean z) {
        if (this.controller == null || this.inspectorFactory == null) {
            return;
        }
        MeasurementValueConfiguration measurementValueConfiguration = this.currentConfiguration;
        if (measurementValueConfiguration == null) {
            measurementValueConfiguration = e60.a;
        }
        if (measurementValueConfiguration == null) {
            if (this.parentInspector == null) {
                return;
            }
            if (this.scaleConfigurationPickerInspectorDetailView == null) {
                this.scaleConfigurationPickerInspectorDetailView = ScaleConfigurationPickerInspectorDetailView.createNewScaleDetailView(getContext(), this.inspectorFactory, null, null, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleSelectPickerInspectorView$$ExternalSyntheticLambda0
                    @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
                    public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration2) {
                        this.f$0.lambda$showDetailView$1(measurementValueConfiguration2);
                    }
                });
            }
            this.parentInspector.showDetailView(this.scaleConfigurationPickerInspectorDetailView, no.a(getContext(), R.string.pspdf__picker_scale, null), true);
            return;
        }
        ScaleListPickerInspectorDetailView scaleListPickerInspectorDetailView = this.scaleListPicker;
        if (scaleListPickerInspectorDetailView == null) {
            return;
        }
        scaleListPickerInspectorDetailView.refreshScales();
        this.scaleListPicker.setSelectedScale(measurementValueConfiguration);
        this.controller.showDetailView(this.scaleListPicker.getView(), this.label, z);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
        this.controller = propertyInspectorController;
        this.parentInspector = propertyInspectorController instanceof PropertyInspector ? (PropertyInspector) propertyInspectorController : null;
    }

    public MeasurementValueConfiguration getCurrentConfigurationValue() {
        return this.currentConfiguration;
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

    public void setConfiguration(MeasurementValueConfiguration measurementValueConfiguration, boolean z) {
        MeasurementValueConfiguration measurementValueConfiguration2 = this.currentConfiguration;
        this.currentConfiguration = measurementValueConfiguration;
        ImageView imageView = this.errorIndicator;
        if (measurementValueConfiguration != null) {
            imageView.setVisibility(8);
            boolean z2 = this.isReadOnly;
            TextView textView = this.scaleText;
            if (z2) {
                d60.a(textView, this.currentConfiguration.getDefaultName(false));
            } else {
                d60.a(textView, this.currentConfiguration.getNameForDisplay(false));
            }
            TextView textView2 = this.scaleText;
            boolean z3 = this.isReadOnly;
            dx dxVar = this.style;
            textView2.setTextColor(z3 ? dxVar.h : dxVar.c);
        } else {
            imageView.setVisibility(0);
            this.scaleText.setText(getContext().getString(R.string.pspdf__set_scale));
            this.scaleText.setTextColor(this.style.g);
        }
        if (!z || this.listener == null || Objects.equals(measurementValueConfiguration2, this.currentConfiguration)) {
            return;
        }
        this.listener.onConfigurationPicked(measurementValueConfiguration);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        this.controller = null;
    }

    public ScaleSelectPickerInspectorView(Context context, String str, MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        this(context, str, measurementValueConfiguration, null, true, null, measurementValueConfigurationPickerListener);
    }

    public ScaleSelectPickerInspectorView(Context context, String str, MeasurementValueConfiguration measurementValueConfiguration, m2 m2Var, MeasurementValueConfigurationEditor measurementValueConfigurationEditor, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        this(context, str, measurementValueConfiguration, m2Var, false, measurementValueConfigurationEditor, measurementValueConfigurationPickerListener);
    }
}
