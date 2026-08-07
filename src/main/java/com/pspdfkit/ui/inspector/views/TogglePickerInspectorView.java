package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;

/* JADX INFO: loaded from: classes3.dex */
public class TogglePickerInspectorView extends FrameLayout implements PropertyInspectorView {
    private CheckBox checkBoxView;
    private boolean currentValue;
    private final TogglePickerListener listener;
    private final String offValue;
    private final String onValue;
    private TextView selectedValueView;

    public interface TogglePickerListener {
        void onSelectionChanged(TogglePickerInspectorView togglePickerInspectorView, boolean z);
    }

    public TogglePickerInspectorView(Context context, String str, String str2, String str3, boolean z, TogglePickerListener togglePickerListener) {
        super(context);
        this.currentValue = false;
        uw.a(str, "label", null);
        uw.a(str2, "onValue", null);
        uw.a(str3, "offValue", null);
        this.onValue = str2;
        this.offValue = str3;
        this.listener = togglePickerListener;
        init(str, z);
    }

    private void init(String str, boolean z) {
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
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_toggle_picker, this);
        viewInflate.setMinimumHeight(dimensionPixelSize);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.TogglePickerInspectorView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        TextView textView = (TextView) findViewById(R.id.pspdf__label);
        textView.setTextSize(0, dimension);
        textView.setTextColor(color);
        textView.setText(str);
        TextView textView2 = (TextView) findViewById(R.id.pspdf__value);
        this.selectedValueView = textView2;
        textView2.setTextSize(0, dimension);
        this.selectedValueView.setTextColor(color);
        CheckBox checkBox = (CheckBox) findViewById(R.id.pspdf__toggle);
        this.checkBoxView = checkBox;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pspdfkit.ui.inspector.views.TogglePickerInspectorView$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.f$0.lambda$init$1(compoundButton, z2);
            }
        });
        this.currentValue = z;
        setValue(z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        setValue(!this.checkBoxView.isChecked(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(CompoundButton compoundButton, boolean z) {
        setValue(z, true);
    }

    private void setValue(boolean z, boolean z2) {
        TogglePickerListener togglePickerListener;
        if (z2 && this.currentValue != z && (togglePickerListener = this.listener) != null) {
            togglePickerListener.onSelectionChanged(this, z);
        }
        this.currentValue = z;
        this.checkBoxView.setChecked(z);
        TextView textView = this.selectedValueView;
        if (z) {
            textView.setText(this.onValue);
        } else {
            textView.setText(this.offValue);
        }
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
    public void unbindController() {
    }
}
