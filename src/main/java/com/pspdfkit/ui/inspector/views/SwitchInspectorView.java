package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.LocalizedSwitch;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;

/* JADX INFO: loaded from: classes3.dex */
public class SwitchInspectorView extends FrameLayout implements PropertyInspectorView {
    private boolean isSwitchEnabled;
    private final String label;
    private final SwitchListener listener;
    private LocalizedSwitch localizedSwitch;

    public interface SwitchListener {
        void onSwitchValueChange(boolean z);
    }

    public SwitchInspectorView(Context context, String str, boolean z, SwitchListener switchListener) {
        super(context);
        uw.a(str, "label", null);
        this.label = str;
        this.listener = switchListener;
        this.isSwitchEnabled = z;
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
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_switch, null);
        viewInflate.setMinimumHeight(dimensionPixelSize);
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__label);
        textView.setText(this.label);
        textView.setTextColor(color);
        textView.setTextSize(0, dimension);
        LocalizedSwitch localizedSwitch = (LocalizedSwitch) viewInflate.findViewById(R.id.pspdf__secondary_units_switch);
        this.localizedSwitch = localizedSwitch;
        localizedSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pspdfkit.ui.inspector.views.SwitchInspectorView$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.lambda$init$0(compoundButton, z);
            }
        });
        addView(viewInflate, new FrameLayout.LayoutParams(-1, -2));
        setSwitchEnabled(this.isSwitchEnabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(CompoundButton compoundButton, boolean z) {
        setSwitchEnabled(z);
    }

    private void setSwitchEnabled(boolean z) {
        this.isSwitchEnabled = z;
        this.localizedSwitch.setChecked(z);
        SwitchListener switchListener = this.listener;
        if (switchListener != null) {
            switchListener.onSwitchValueChange(z);
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
