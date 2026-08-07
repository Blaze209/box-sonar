package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.annotations.LineAnnotation;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.bq;
import com.pspdfkit.internal.ei;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.jni.NativeMeasurementCalculator;
import com.pspdfkit.internal.jni.NativeMeasurementCalibration;
import com.pspdfkit.internal.kc;
import com.pspdfkit.internal.mr;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.editor.ScreenAdjustingEditText;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.utils.PdfLog;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ScaleCalibrationPickerInspectorView extends FrameLayout implements PropertyInspectorView, PropertyInspectorTitleButtonListener {
    private static final String LOG_TAG = "CALIBRATION_PICKER";
    private Scale.UnitTo currentUnit;
    private Float currentValue;
    private boolean initiallyFocusValueText;
    private final String label;
    private LineAnnotation lineAnnotation;
    private CalibrationPickerListener listener;
    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private TextView spinnerText;
    private ScreenAdjustingEditText valueText;

    public interface CalibrationPickerListener {
        void onScaleCalibrationPicked(Float f, Scale.UnitTo unitTo);
    }

    public ScaleCalibrationPickerInspectorView(LineAnnotation lineAnnotation, Context context, String str, Scale.UnitTo unitTo, boolean z, CalibrationPickerListener calibrationPickerListener) {
        super(context);
        this.currentValue = null;
        uw.a(str, "label", null);
        uw.a(unitTo, "defaultUnit", null);
        uw.a(lineAnnotation, "lineAnnotation", null);
        this.lineAnnotation = lineAnnotation;
        this.label = str;
        this.listener = calibrationPickerListener;
        this.currentUnit = unitTo;
        this.initiallyFocusValueText = z;
        init();
    }

    private void init() {
        Context context = getContext();
        TypedArray typedArrayA = ex.a(context);
        int dimensionPixelSize = typedArrayA.getDimensionPixelSize(R.styleable.pspdf__PropertyInspector_pspdf__itemHeight, context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_item_height));
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__backgroundColor, -1);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__progressBackgroundTint, -7829368);
        int color = typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__textColor, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__errorColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight);
        typedArrayA.getBoolean(R.styleable.pspdf__PropertyInspector_pspdf__searchVisible, false);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__buttonIconTint, f60.a(context, androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight));
        typedArrayA.recycle();
        float dimension = context.getResources().getDimension(R.dimen.pspdf__inspector_text_size);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_preview_item_height);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_padding);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_vertical_padding);
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_scale_calibration_picker, null);
        viewInflate.setMinimumHeight(dimensionPixelSize);
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__label);
        textView.setText(this.label);
        textView.setTextColor(color);
        textView.setTextSize(0, dimension);
        addView(viewInflate, new FrameLayout.LayoutParams(-1, -2));
        initSpinner(viewInflate);
        initValueText(viewInflate);
        updateCalibration(null);
    }

    private void initSpinner(View view) {
        this.spinner = (Spinner) view.findViewById(R.id.pspdf__calibrate_unit_spinner);
        this.spinnerText = (TextView) view.findViewById(R.id.pspdf__calibrate_unit_text);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, new String[]{Scale.UnitTo.IN.getDisplayText(), Scale.UnitTo.MM.getDisplayText(), Scale.UnitTo.CM.getDisplayText(), Scale.UnitTo.FT.getDisplayText(), Scale.UnitTo.M.getDisplayText(), Scale.UnitTo.YD.getDisplayText(), Scale.UnitTo.KM.getDisplayText(), Scale.UnitTo.MI.getDisplayText()});
        this.spinnerAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.pspdf__inspector_scale_unit_spinner_item);
        this.spinner.setAdapter((SpinnerAdapter) this.spinnerAdapter);
        this.spinner.setDropDownHorizontalOffset(getContext().getResources().getDimensionPixelSize(R.dimen.pspdf__measurement_unit_spinner_dropdown_horizontal_offset));
        this.spinner.setSelection(this.spinnerAdapter.getPosition(this.currentUnit.getDisplayText()));
        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleCalibrationPickerInspectorView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                String string;
                Scale.UnitTo unitToFromString;
                if (i < Scale.UnitTo.values().length && (unitToFromString = Scale.UnitTo.fromString((string = ((TextView) view2).getText().toString()))) != null) {
                    ScaleCalibrationPickerInspectorView.this.spinnerText.setText(string);
                    ScaleCalibrationPickerInspectorView scaleCalibrationPickerInspectorView = ScaleCalibrationPickerInspectorView.this;
                    scaleCalibrationPickerInspectorView.setCalibration(scaleCalibrationPickerInspectorView.currentValue, unitToFromString, true);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.spinnerText.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleCalibrationPickerInspectorView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initSpinner$1(view2);
            }
        });
    }

    private void initValueText(View view) {
        ScreenAdjustingEditText screenAdjustingEditText = (ScreenAdjustingEditText) view.findViewById(R.id.pspdf__calibrate_value_text);
        this.valueText = screenAdjustingEditText;
        screenAdjustingEditText.setImeOptions(6);
        this.valueText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleCalibrationPickerInspectorView$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$initValueText$2(textView, i, keyEvent);
            }
        });
        this.valueText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleCalibrationPickerInspectorView.2
            private boolean ignore = false;

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z || this.ignore) {
                    return;
                }
                this.ignore = true;
                ScaleCalibrationPickerInspectorView.this.updateValueFromEditTextView();
                this.ignore = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSpinner$1(View view) {
        this.spinner.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initValueText$2(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        hn.c(textView);
        updateValueFromEditTextView();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLayout$0() {
        this.valueText.requestFocus();
    }

    private void updateInputFilters() {
        InputFilter kcVar;
        int i;
        if (this.currentUnit.isImperial()) {
            kcVar = new ei();
            i = 1;
        } else {
            kcVar = new kc();
            i = 8194;
        }
        this.valueText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50), kcVar});
        this.valueText.setInputType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateValueFromEditTextView() {
        this.valueText.clearFocus();
        String string = this.valueText.getText() != null ? this.valueText.getText().toString() : "";
        if (string.isEmpty()) {
            if (this.currentValue != null) {
                setCalibration(null, this.currentUnit, true);
                return;
            }
            return;
        }
        Double numberFromString = NativeMeasurementCalculator.parseNumberFromString(string, null);
        if (numberFromString == null) {
            PdfLog.e(LOG_TAG, "Calibration value could not be parsed: ".concat(string), new Object[0]);
            setCalibration(this.currentValue, this.currentUnit, false);
            return;
        }
        float fFloatValue = numberFromString.floatValue();
        if (fFloatValue < 1.0E-5f) {
            PdfLog.e(LOG_TAG, "Calibration value below minimum: " + fFloatValue, new Object[0]);
            setCalibration(this.currentValue, this.currentUnit, false);
        } else {
            if (Objects.equals(this.currentValue, Float.valueOf(fFloatValue))) {
                return;
            }
            setCalibration(Float.valueOf(fFloatValue), this.currentUnit, true);
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
    }

    public LineAnnotation getLineAnnotation() {
        return this.lineAnnotation;
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

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.initiallyFocusValueText) {
            this.initiallyFocusValueText = false;
            this.valueText.post(new Runnable() { // from class: com.pspdfkit.ui.inspector.views.ScaleCalibrationPickerInspectorView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onLayout$0();
                }
            });
        }
    }

    public void setCalibration(Float f, Scale.UnitTo unitTo, boolean z) {
        String str;
        CalibrationPickerListener calibrationPickerListener;
        boolean z2 = (Objects.equals(this.currentValue, f) && this.currentUnit == unitTo) ? false : true;
        this.currentValue = f;
        this.currentUnit = unitTo;
        this.spinner.setSelection(this.spinnerAdapter.getPosition(unitTo.getDisplayText()));
        this.spinnerText.setText(unitTo.getDisplayText());
        if (f != null) {
            str = bq.b.format(f);
            str.getClass();
        } else {
            str = "";
        }
        if (this.valueText.getText() == null || !this.valueText.getText().toString().equals(str)) {
            this.valueText.setText(str);
        }
        updateInputFilters();
        if (z && (calibrationPickerListener = this.listener) != null && z2) {
            calibrationPickerListener.onScaleCalibrationPicked(f, unitTo);
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
    }

    public void updateCalibration(Scale scale) {
        NativeMeasurementCalibration measurementCalibrationFromScale;
        if (scale == null) {
            scale = this.lineAnnotation.getInternal().getMeasurementScale();
        }
        if (scale == null || (measurementCalibrationFromScale = NativeMeasurementCalculator.getMeasurementCalibrationFromScale(this.lineAnnotation.getPoints().first, this.lineAnnotation.getPoints().second, mr.a(scale))) == null) {
            return;
        }
        setCalibration(Float.valueOf((float) measurementCalibrationFromScale.getValue()), mr.a(measurementCalibrationFromScale.getUnitTo()), false);
    }
}
