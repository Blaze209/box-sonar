package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.pspdfkit.R;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.dx;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;

/* JADX INFO: loaded from: classes3.dex */
public class UnitsPickerInspectorView extends FrameLayout implements PropertyInspectorView {
    private static int spinnerUnitDropdownHorizontalOffset;
    private Scale.UnitTo currentUnit;
    private final String label;
    UnitPickerListener listener;
    private Spinner spinnerUnit;
    private ArrayAdapter<String> spinnerUnitAdapter;
    private TextView spinnerUnitText;

    public interface UnitPickerListener {
        void onUnitPicked(Scale.UnitTo unitTo);
    }

    public UnitsPickerInspectorView(Context context, String str, Scale.UnitTo unitTo, UnitPickerListener unitPickerListener) {
        super(context);
        uw.a(str, "label", null);
        uw.a(unitTo, "defaultValue", null);
        this.label = str;
        this.listener = unitPickerListener;
        this.currentUnit = unitTo;
        init();
    }

    private void init() {
        if (spinnerUnitDropdownHorizontalOffset == 0) {
            spinnerUnitDropdownHorizontalOffset = getContext().getResources().getDimensionPixelSize(R.dimen.pspdf__measurement_unit_spinner_dropdown_horizontal_offset);
        }
        dx dxVar = new dx(getContext());
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_units_picker, null);
        viewInflate.setMinimumHeight(dxVar.a);
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__label);
        textView.setText(this.label);
        textView.setTextColor(dxVar.c);
        textView.setTextSize(0, dxVar.d);
        addView(viewInflate, new FrameLayout.LayoutParams(-1, -2));
        prepareSpinners(viewInflate, dxVar);
        setUnit(this.currentUnit, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareSpinners$0(View view) {
        this.spinnerUnit.performClick();
    }

    private void prepareSpinners(View view, dx dxVar) {
        this.spinnerUnit = (Spinner) view.findViewById(R.id.pspdf__unit_spinner);
        TextView textView = (TextView) view.findViewById(R.id.pspdf__unit_spinner_text);
        this.spinnerUnitText = textView;
        textView.setTextColor(dxVar.c);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.pspdf__inspector_precision_spinner_item, new String[]{Scale.UnitTo.IN.getDisplayText(), Scale.UnitTo.MM.getDisplayText(), Scale.UnitTo.CM.getDisplayText(), Scale.UnitTo.FT.getDisplayText(), Scale.UnitTo.M.getDisplayText(), Scale.UnitTo.YD.getDisplayText(), Scale.UnitTo.KM.getDisplayText(), Scale.UnitTo.MI.getDisplayText()});
        this.spinnerUnitAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.pspdf__inspector_unit_spinner_item);
        this.spinnerUnit.setAdapter((SpinnerAdapter) this.spinnerUnitAdapter);
        this.spinnerUnit.setDropDownHorizontalOffset(spinnerUnitDropdownHorizontalOffset);
        this.spinnerUnit.setSelection(this.spinnerUnitAdapter.getPosition(this.currentUnit.getDisplayText()));
        this.spinnerUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.pspdfkit.ui.inspector.views.UnitsPickerInspectorView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                String string;
                Scale.UnitTo unitToFromString;
                if (i < Scale.UnitTo.values().length && (unitToFromString = Scale.UnitTo.fromString((string = ((TextView) view2).getText().toString()))) != null) {
                    UnitsPickerInspectorView.this.spinnerUnitText.setText(string);
                    UnitsPickerInspectorView.this.setUnit(unitToFromString, true);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.spinnerUnitText.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.UnitsPickerInspectorView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$prepareSpinners$0(view2);
            }
        });
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
    }

    public Scale.UnitTo getCurrentUnit() {
        return this.currentUnit;
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

    public void setUnit(Scale.UnitTo unitTo, boolean z) {
        UnitPickerListener unitPickerListener;
        boolean zEquals = this.currentUnit.equals(unitTo);
        this.currentUnit = unitTo;
        this.spinnerUnit.setSelection(this.spinnerUnitAdapter.getPosition(unitTo.getDisplayText()));
        this.spinnerUnitText.setText(unitTo.getDisplayText());
        if (!z || (unitPickerListener = this.listener) == null || zEquals) {
            return;
        }
        unitPickerListener.onUnitPicked(unitTo);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
    }
}
