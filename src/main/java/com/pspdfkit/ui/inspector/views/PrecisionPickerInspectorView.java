package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.measurements.MeasurementMode;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.qp;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PrecisionPickerInspectorView extends FrameLayout implements PropertyInspectorView {
    private static final String LOG_TAG = "PRECISION_PICKER";
    private static final List<MeasurementPrecision> allPrecisions;
    private static final List<MeasurementPrecision> decimalPrecisions;
    private final AnnotationType annotationType;
    private Scale.UnitTo currentUnit;
    private final String label;
    PrecisionPickerListener listener;
    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private TextView spinnerText;

    /* JADX INFO: renamed from: com.pspdfkit.ui.inspector.views.PrecisionPickerInspectorView$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$annotations$measurements$Scale$UnitTo;

        static {
            int[] iArr = new int[Scale.UnitTo.values().length];
            $SwitchMap$com$pspdfkit$annotations$measurements$Scale$UnitTo = iArr;
            try {
                iArr[Scale.UnitTo.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$measurements$Scale$UnitTo[Scale.UnitTo.FT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$measurements$Scale$UnitTo[Scale.UnitTo.YD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface PrecisionPickerListener {
        void onPrecisionPicked(MeasurementPrecision measurementPrecision);
    }

    static {
        MeasurementPrecision measurementPrecision = MeasurementPrecision.WHOLE;
        MeasurementPrecision measurementPrecision2 = MeasurementPrecision.ONE_DP;
        MeasurementPrecision measurementPrecision3 = MeasurementPrecision.TWO_DP;
        MeasurementPrecision measurementPrecision4 = MeasurementPrecision.THREE_DP;
        MeasurementPrecision measurementPrecision5 = MeasurementPrecision.FOUR_DP;
        decimalPrecisions = new ArrayList(Arrays.asList(measurementPrecision, measurementPrecision2, measurementPrecision3, measurementPrecision4, measurementPrecision5));
        allPrecisions = new ArrayList(Arrays.asList(measurementPrecision, measurementPrecision2, measurementPrecision3, measurementPrecision4, measurementPrecision5, MeasurementPrecision.WHOLE_INCH, MeasurementPrecision.HALVES_INCH, MeasurementPrecision.QUARTERS_INCH, MeasurementPrecision.EIGHTHS_INCH, MeasurementPrecision.SIXTEENTHS_INCH));
    }

    public PrecisionPickerInspectorView(Context context, String str, MeasurementPrecision measurementPrecision, Scale.UnitTo unitTo, AnnotationType annotationType, PrecisionPickerListener precisionPickerListener) {
        super(context);
        uw.a(str, "label", null);
        uw.a(measurementPrecision, "precision", null);
        this.label = str;
        this.listener = precisionPickerListener;
        this.annotationType = annotationType;
        init(measurementPrecision, unitTo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MeasurementPrecision getPrecisionFromSpinnerIndex(int i) {
        MeasurementPrecision measurementPrecisionPrecisionFromDisplayString;
        if (i < this.spinner.getCount() && (measurementPrecisionPrecisionFromDisplayString = MeasurementPrecision.precisionFromDisplayString((String) this.spinner.getItemAtPosition(i), this.currentUnit)) != null) {
            return measurementPrecisionPrecisionFromDisplayString;
        }
        MeasurementPrecision defaultPrecision = getDefaultPrecision();
        PdfLog.e(LOG_TAG, "Can't find the right measurement precision from the string! Using default " + defaultPrecision, new Object[0]);
        return defaultPrecision;
    }

    private int getSpinnerSelectionIndex(MeasurementPrecision measurementPrecision) {
        int position = this.spinnerAdapter.getPosition(MeasurementPrecision.toDisplayString(measurementPrecision, this.currentUnit));
        if (position != -1) {
            return position;
        }
        int position2 = this.spinnerAdapter.getPosition(MeasurementPrecision.toDisplayString(MeasurementValueConfiguration.defaultConfiguration().getPrecision(), this.currentUnit));
        if (position2 == -1) {
            return 0;
        }
        return position2;
    }

    private boolean hasFractionalPrecision(Scale.UnitTo unitTo) {
        MeasurementMode measurementMode;
        AnnotationType annotationType = this.annotationType;
        if (annotationType != null) {
            int i = qp.a.b[annotationType.ordinal()];
            if (i == 1) {
                measurementMode = MeasurementMode.DISTANCE;
            } else if (i != 2) {
                measurementMode = (i == 3 || i == 4 || i == 5) ? MeasurementMode.AREA : null;
            } else {
                measurementMode = MeasurementMode.PERIMETER;
            }
            if (measurementMode == MeasurementMode.AREA) {
                return false;
            }
        }
        int i2 = AnonymousClass2.$SwitchMap$com$pspdfkit$annotations$measurements$Scale$UnitTo[unitTo.ordinal()];
        return i2 == 1 || i2 == 2 || i2 == 3;
    }

    private void init(MeasurementPrecision measurementPrecision, Scale.UnitTo unitTo) {
        this.currentUnit = unitTo;
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
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_precision_picker, null);
        viewInflate.setMinimumHeight(dimensionPixelSize);
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__label);
        textView.setText(this.label);
        textView.setTextColor(color);
        textView.setTextSize(0, dimension);
        addView(viewInflate, new FrameLayout.LayoutParams(-1, -2));
        this.spinner = (Spinner) viewInflate.findViewById(R.id.pspdf__precision_spinner);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.pspdf__precision_spinner_text);
        this.spinnerText = textView2;
        textView2.setTextColor(color);
        setPrecision(prepareSpinner(measurementPrecision, unitTo), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareSpinner$0(View view) {
        this.spinner.performClick();
    }

    private MeasurementPrecision prepareSpinner(MeasurementPrecision measurementPrecision, Scale.UnitTo unitTo) {
        List<MeasurementPrecision> list = hasFractionalPrecision(unitTo) ? allPrecisions : decimalPrecisions;
        this.spinnerAdapter = new ArrayAdapter<>(getContext(), R.layout.pspdf__inspector_precision_spinner_item);
        Iterator<MeasurementPrecision> it = list.iterator();
        while (it.hasNext()) {
            this.spinnerAdapter.add(MeasurementPrecision.toDisplayString(it.next(), unitTo));
        }
        this.spinner.setAdapter((SpinnerAdapter) this.spinnerAdapter);
        this.spinner.setDropDownHorizontalOffset(getContext().getResources().getDimensionPixelSize(R.dimen.pspdf__measurement_precision_spinner_dropdown_horizontal_offset));
        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.pspdfkit.ui.inspector.views.PrecisionPickerInspectorView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= PrecisionPickerInspectorView.this.spinnerAdapter.getCount()) {
                    return;
                }
                MeasurementPrecision precisionFromSpinnerIndex = PrecisionPickerInspectorView.this.getPrecisionFromSpinnerIndex(i);
                PrecisionPickerInspectorView precisionPickerInspectorView = PrecisionPickerInspectorView.this;
                precisionPickerInspectorView.spinnerText.setText(MeasurementPrecision.toDisplayString(precisionFromSpinnerIndex, precisionPickerInspectorView.currentUnit));
                PrecisionPickerInspectorView.this.setPrecision(precisionFromSpinnerIndex, true);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.spinnerText.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.PrecisionPickerInspectorView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$prepareSpinner$0(view);
            }
        });
        return getPrecisionFromSpinnerIndex(getSpinnerSelectionIndex(measurementPrecision));
    }

    private void setSpinnerSelection(MeasurementPrecision measurementPrecision) {
        this.spinner.setSelection(getSpinnerSelectionIndex(measurementPrecision), true);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
    }

    public MeasurementPrecision getDefaultPrecision() {
        return MeasurementValueConfiguration.defaultConfiguration().getPrecision();
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

    public void onUnitChanged(Scale.UnitTo unitTo) {
        this.currentUnit = unitTo;
        setPrecision(prepareSpinner(getPrecisionFromSpinnerIndex(this.spinner.getSelectedItemPosition()), unitTo), true);
    }

    public void setPrecision(MeasurementPrecision measurementPrecision, boolean z) {
        PrecisionPickerListener precisionPickerListener;
        setSpinnerSelection(measurementPrecision);
        if (!z || (precisionPickerListener = this.listener) == null) {
            return;
        }
        precisionPickerListener.onPrecisionPicked(measurementPrecision);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
    }
}
