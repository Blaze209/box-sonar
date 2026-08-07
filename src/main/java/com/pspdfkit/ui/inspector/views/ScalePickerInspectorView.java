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
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.ei;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.ip;
import com.pspdfkit.internal.jni.NativeMeasurementCalculator;
import com.pspdfkit.internal.kc;
import com.pspdfkit.internal.mr;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.editor.ScreenAdjustingEditText;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.utils.PdfLog;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
public class ScalePickerInspectorView extends FrameLayout implements PropertyInspectorView {
    private static final String LOG_TAG = "SCALE_PICKER";
    private static int spinnerUnitDropdownHorizontalOffset;
    private ScaleCalibrationPickerInspectorView calibrationPickerInspectorView;
    private Scale currentScaleValue;
    private final String label;
    ScalePickerListener listener;
    private Spinner spinnerUnitFrom;
    private ArrayAdapter<String> spinnerUnitFromAdapter;
    private TextView spinnerUnitFromText;
    private Spinner spinnerUnitTo;
    private ArrayAdapter<String> spinnerUnitToAdapter;
    private TextView spinnerUnitToText;
    private ScreenAdjustingEditText valueFromText;
    private ScreenAdjustingEditText valueToText;

    public interface ScalePickerListener {
        void onScalePicked(Scale scale);
    }

    public ScalePickerInspectorView(Context context, String str, Scale scale, ScalePickerListener scalePickerListener) {
        super(context);
        uw.a(str, "label", null);
        uw.a(scale, "defaultValue", null);
        this.label = str;
        this.listener = scalePickerListener;
        this.currentScaleValue = scale;
        init();
    }

    private void init() {
        if (spinnerUnitDropdownHorizontalOffset == 0) {
            spinnerUnitDropdownHorizontalOffset = getContext().getResources().getDimensionPixelSize(R.dimen.pspdf__measurement_unit_spinner_dropdown_horizontal_offset);
        }
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
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_scale_picker, null);
        viewInflate.setMinimumHeight(dimensionPixelSize);
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__label);
        textView.setText(this.label);
        textView.setTextColor(color);
        textView.setTextSize(0, dimension);
        addView(viewInflate, new FrameLayout.LayoutParams(-1, -2));
        prepareSpinners(viewInflate);
        prepareValueTexts(viewInflate);
        setScale(this.currentScaleValue, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareSpinners$0(View view) {
        this.spinnerUnitFrom.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareSpinners$1(View view) {
        this.spinnerUnitTo.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$prepareValueTexts$2(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        hn.c(textView);
        onValueEditTextViewUpdated(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$prepareValueTexts$3(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        hn.c(textView);
        onValueEditTextViewUpdated(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onValueEditTextViewUpdated(boolean z) {
        Scale scale;
        String strValueOf = String.valueOf((z ? this.valueFromText : this.valueToText).getText());
        Double numberFromString = NativeMeasurementCalculator.parseNumberFromString(strValueOf, null);
        if (numberFromString == null) {
            PdfLog.e(LOG_TAG, "Scale from or to value could not be parsed: ".concat(strValueOf), new Object[0]);
            setScale(this.currentScaleValue, false, false);
            return;
        }
        float fMax = Math.max(1.0E-5f, Math.min(numberFromString.floatValue(), Float.MAX_VALUE));
        Scale scale2 = this.currentScaleValue;
        if (ip.a(fMax, new BigDecimal(Double.toString(z ? scale2.getValueFrom() : scale2.getValueTo())).setScale(5, RoundingMode.HALF_UP).floatValue())) {
            return;
        }
        Scale scale3 = this.currentScaleValue;
        if (z) {
            scale3.getClass();
            scale = new Scale(fMax, scale3.unitFrom, scale3.getValueTo(), scale3.unitTo, strValueOf, scale3.toDescription);
        } else {
            scale3.getClass();
            scale = new Scale(scale3.getValueFrom(), scale3.unitFrom, fMax, scale3.unitTo, scale3.fromDescription, strValueOf);
        }
        if (NativeMeasurementCalculator.isMeasurementScaleValid(mr.a(scale))) {
            setScale(scale, true, true);
        } else {
            PdfLog.e(LOG_TAG, "Scale validation failed", new Object[0]);
            setScale(this.currentScaleValue, false, false);
        }
    }

    private void prepareSpinners(View view) {
        this.spinnerUnitFrom = (Spinner) view.findViewById(R.id.pspdf__unit_from_spinner);
        this.spinnerUnitTo = (Spinner) view.findViewById(R.id.pspdf__unit_to_spinner);
        this.spinnerUnitFromText = (TextView) view.findViewById(R.id.pspdf__unit_from_spinner_text);
        this.spinnerUnitToText = (TextView) view.findViewById(R.id.pspdf__unit_to_spinner_text);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, new String[]{Scale.UnitFrom.IN.getDisplayText(), Scale.UnitFrom.MM.getDisplayText(), Scale.UnitFrom.CM.getDisplayText(), Scale.UnitFrom.PT.getDisplayText()});
        this.spinnerUnitFromAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.pspdf__inspector_scale_unit_spinner_item);
        this.spinnerUnitFrom.setAdapter((SpinnerAdapter) this.spinnerUnitFromAdapter);
        this.spinnerUnitFrom.setDropDownHorizontalOffset(spinnerUnitDropdownHorizontalOffset);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, new String[]{Scale.UnitTo.IN.getDisplayText(), Scale.UnitTo.MM.getDisplayText(), Scale.UnitTo.CM.getDisplayText(), Scale.UnitTo.FT.getDisplayText(), Scale.UnitTo.M.getDisplayText(), Scale.UnitTo.YD.getDisplayText(), Scale.UnitTo.KM.getDisplayText(), Scale.UnitTo.MI.getDisplayText()});
        this.spinnerUnitToAdapter = arrayAdapter2;
        arrayAdapter2.setDropDownViewResource(R.layout.pspdf__inspector_scale_unit_spinner_item);
        this.spinnerUnitTo.setAdapter((SpinnerAdapter) this.spinnerUnitToAdapter);
        this.spinnerUnitTo.setDropDownHorizontalOffset(spinnerUnitDropdownHorizontalOffset);
        this.spinnerUnitFrom.setSelection(this.spinnerUnitFromAdapter.getPosition(this.currentScaleValue.unitFrom.getDisplayText()));
        this.spinnerUnitTo.setSelection(this.spinnerUnitToAdapter.getPosition(this.currentScaleValue.unitTo.getDisplayText()));
        this.spinnerUnitFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.pspdfkit.ui.inspector.views.ScalePickerInspectorView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                String string;
                Scale.UnitFrom unitFromFromString;
                if (i < Scale.UnitFrom.values().length && (unitFromFromString = Scale.UnitFrom.fromString((string = ((TextView) view2).getText().toString()))) != null) {
                    ScalePickerInspectorView.this.spinnerUnitFromText.setText(string);
                    ScalePickerInspectorView scalePickerInspectorView = ScalePickerInspectorView.this;
                    Scale scale = scalePickerInspectorView.currentScaleValue;
                    scale.getClass();
                    scalePickerInspectorView.setScale(new Scale(scale.getValueFrom(), unitFromFromString, scale.getValueTo(), scale.unitTo, scale.unitFrom.isImperial() != unitFromFromString.isImperial() ? null : scale.fromDescription, scale.toDescription), true, true);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.spinnerUnitTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.pspdfkit.ui.inspector.views.ScalePickerInspectorView.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                String string;
                Scale.UnitTo unitToFromString;
                if (i < Scale.UnitTo.values().length && (unitToFromString = Scale.UnitTo.fromString((string = ((TextView) view2).getText().toString()))) != null) {
                    ScalePickerInspectorView.this.spinnerUnitToText.setText(string);
                    ScalePickerInspectorView scalePickerInspectorView = ScalePickerInspectorView.this;
                    Scale scale = scalePickerInspectorView.currentScaleValue;
                    scale.getClass();
                    scalePickerInspectorView.setScale(new Scale(scale.getValueFrom(), scale.unitFrom, scale.getValueTo(), unitToFromString, scale.fromDescription, scale.unitTo.isImperial() != unitToFromString.isImperial() ? null : scale.toDescription), true, true);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.spinnerUnitFromText.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.ScalePickerInspectorView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$prepareSpinners$0(view2);
            }
        });
        this.spinnerUnitToText.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.ScalePickerInspectorView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$prepareSpinners$1(view2);
            }
        });
    }

    private void prepareValueTexts(View view) {
        this.valueFromText = (ScreenAdjustingEditText) view.findViewById(R.id.pspdf__value_from_text);
        this.valueToText = (ScreenAdjustingEditText) view.findViewById(R.id.pspdf__value_to_text);
        this.valueFromText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.pspdfkit.ui.inspector.views.ScalePickerInspectorView$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$prepareValueTexts$2(textView, i, keyEvent);
            }
        });
        this.valueToText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.pspdfkit.ui.inspector.views.ScalePickerInspectorView$$ExternalSyntheticLambda3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$prepareValueTexts$3(textView, i, keyEvent);
            }
        });
        this.valueFromText.setImeOptions(6);
        this.valueToText.setImeOptions(6);
        this.valueFromText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.pspdfkit.ui.inspector.views.ScalePickerInspectorView.3
            private boolean ignore = false;

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z || this.ignore) {
                    return;
                }
                this.ignore = true;
                ScalePickerInspectorView.this.onValueEditTextViewUpdated(true);
                this.ignore = false;
            }
        });
        this.valueToText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.pspdfkit.ui.inspector.views.ScalePickerInspectorView.4
            private boolean ignore = false;

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z || this.ignore) {
                    return;
                }
                this.ignore = true;
                ScalePickerInspectorView.this.onValueEditTextViewUpdated(false);
                this.ignore = false;
            }
        });
    }

    private void updateInputFilters() {
        InputFilter kcVar;
        int i;
        int i2;
        InputFilter kcVar2;
        InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(50);
        if (this.currentScaleValue.unitFrom.isImperial()) {
            kcVar = new ei();
            i = 1;
        } else {
            kcVar = new kc();
            i = 8194;
        }
        if (this.currentScaleValue.unitTo.isImperial()) {
            kcVar2 = new ei();
            i2 = 1;
        } else {
            i2 = 8194;
            kcVar2 = new kc();
        }
        this.valueFromText.setFilters(new InputFilter[]{lengthFilter, kcVar});
        this.valueFromText.setInputType(i);
        this.valueToText.setFilters(new InputFilter[]{lengthFilter, kcVar2});
        this.valueToText.setInputType(i2);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
    }

    public Scale getCurrentScaleValue() {
        return this.currentScaleValue;
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

    public void setCalibrationPicker(ScaleCalibrationPickerInspectorView scaleCalibrationPickerInspectorView) {
        this.calibrationPickerInspectorView = scaleCalibrationPickerInspectorView;
    }

    public void setScale(Scale scale, boolean z, boolean z2) {
        ScalePickerListener scalePickerListener;
        boolean zEquals = this.currentScaleValue.equals(scale);
        this.currentScaleValue = scale;
        this.spinnerUnitFrom.setSelection(this.spinnerUnitFromAdapter.getPosition(scale.unitFrom.getDisplayText()));
        this.spinnerUnitTo.setSelection(this.spinnerUnitToAdapter.getPosition(scale.unitTo.getDisplayText()));
        this.spinnerUnitFromText.setText(scale.unitFrom.getDisplayText());
        this.spinnerUnitToText.setText(scale.unitTo.getDisplayText());
        String fromValueString = scale.getFromValueString();
        String toValueString = scale.getToValueString();
        if (this.valueFromText.getText() == null || !fromValueString.equals(this.valueFromText.getText().toString())) {
            this.valueFromText.setText(fromValueString);
        }
        if (this.valueToText.getText() == null || !toValueString.equals(this.valueToText.getText().toString())) {
            this.valueToText.setText(toValueString);
        }
        updateInputFilters();
        if (z && (scalePickerListener = this.listener) != null && !zEquals) {
            scalePickerListener.onScalePicked(scale);
        }
        ScaleCalibrationPickerInspectorView scaleCalibrationPickerInspectorView = this.calibrationPickerInspectorView;
        if (scaleCalibrationPickerInspectorView == null || !z2) {
            return;
        }
        scaleCalibrationPickerInspectorView.updateCalibration(scale);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
    }
}
