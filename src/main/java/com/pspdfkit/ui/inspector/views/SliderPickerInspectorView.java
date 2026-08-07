package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.editor.UnitSelectionEditText;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;

/* JADX INFO: loaded from: classes3.dex */
public class SliderPickerInspectorView extends FrameLayout implements PropertyInspectorView {
    private final String label;
    SliderPickerListener listener;
    private final int maximumValue;
    private final int minimumValue;
    private SeekBar seekBarView;
    private TextView sliderLabelView;
    private UnitSelectionEditText unitEditText;
    private int value;

    public interface SliderPickerListener {
        void onValuePicked(SliderPickerInspectorView sliderPickerInspectorView, int i);
    }

    public SliderPickerInspectorView(Context context, String str, String str2, int i, int i2, int i3, SliderPickerListener sliderPickerListener) {
        super(context);
        this.value = Integer.MIN_VALUE;
        uw.a(str, "label", null);
        uw.a(str2, "unitLabel", null);
        this.label = str;
        this.minimumValue = i;
        this.maximumValue = i2;
        init(i3, sliderPickerListener, str2);
    }

    private void init(int i, SliderPickerListener sliderPickerListener, String str) {
        Context context = getContext();
        TypedArray typedArrayA = ex.a(context);
        int dimensionPixelSize = typedArrayA.getDimensionPixelSize(R.styleable.pspdf__PropertyInspector_pspdf__itemHeight, context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_item_height));
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__backgroundColor, -1);
        int color = typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__progressBackgroundTint, -7829368);
        int color2 = typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__textColor, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__errorColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight);
        typedArrayA.getBoolean(R.styleable.pspdf__PropertyInspector_pspdf__searchVisible, false);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__buttonIconTint, f60.a(context, androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight));
        typedArrayA.recycle();
        float dimension = context.getResources().getDimension(R.dimen.pspdf__inspector_text_size);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_preview_item_height);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_padding);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_vertical_padding);
        View.inflate(getContext(), R.layout.pspdf__view_inspector_slider_picker, this).setMinimumHeight(dimensionPixelSize);
        this.sliderLabelView = (TextView) findViewById(R.id.pspdf__sliderLabel);
        SeekBar seekBar = (SeekBar) findViewById(R.id.pspdf__sliderSeekBar);
        this.seekBarView = seekBar;
        seekBar.setProgressBackgroundTintList(ColorStateList.valueOf(color));
        UnitSelectionEditText unitSelectionEditText = (UnitSelectionEditText) findViewById(R.id.pspdf__sliderUnitEditText);
        this.unitEditText = unitSelectionEditText;
        unitSelectionEditText.setUnitLabel(str, i, this.minimumValue, this.maximumValue, new UnitSelectionEditText.UnitSelectionListener() { // from class: com.pspdfkit.ui.inspector.views.SliderPickerInspectorView$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.editor.UnitSelectionEditText.UnitSelectionListener
            public final void onValueSet(UnitSelectionEditText unitSelectionEditText2, int i2) {
                this.f$0.lambda$init$0(unitSelectionEditText2, i2);
            }
        });
        this.sliderLabelView.setTextColor(color2);
        this.sliderLabelView.setTextSize(0, dimension);
        this.unitEditText.setTextColor(color2);
        this.unitEditText.setTextSize(0, dimension);
        this.sliderLabelView.setText(this.label);
        this.seekBarView.setMax(this.maximumValue - this.minimumValue);
        this.seekBarView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.pspdfkit.ui.inspector.views.SliderPickerInspectorView.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int i2, boolean z) {
                SliderPickerInspectorView sliderPickerInspectorView = SliderPickerInspectorView.this;
                int i3 = sliderPickerInspectorView.minimumValue;
                SliderPickerInspectorView.this.setValue(Math.max(i3, Math.min(i2 + i3, sliderPickerInspectorView.maximumValue)), z);
                SliderPickerInspectorView.this.unitEditText.focusCheck();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar2) {
            }
        });
        setValue(i, false);
        this.listener = sliderPickerListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(UnitSelectionEditText unitSelectionEditText, int i) {
        setValue(i);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setValue(this.unitEditText.getValue());
    }

    public void setValue(int i) {
        setValue(i, true);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i, boolean z) {
        if (this.value == i) {
            return;
        }
        this.value = i;
        if (z) {
            i = Math.max(this.minimumValue, Math.min(i, this.maximumValue));
        }
        this.seekBarView.setProgress(i - this.minimumValue);
        this.unitEditText.setTextToFormat(i);
        SliderPickerListener sliderPickerListener = this.listener;
        if (sliderPickerListener == null || !z) {
            return;
        }
        sliderPickerListener.onValuePicked(this, i);
    }
}
