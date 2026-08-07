package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.n70$a$$ExternalSyntheticRecord0;
import com.pspdfkit.ui.editor.ScreenAdjustingEditText;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;

/* JADX INFO: loaded from: classes3.dex */
public class ScaleNameInspectorView extends FrameLayout implements PropertyInspectorView {
    private NameChangeListener listener;
    private ScreenAdjustingEditText scaleName;

    public interface NameChangeListener {
        void onNameChanged(String str);
    }

    public ScaleNameInspectorView(Context context, String str, NameChangeListener nameChangeListener) {
        super(context);
        init(str);
        this.listener = nameChangeListener;
    }

    private void forwardName() {
        Editable text = this.scaleName.getText();
        String str = null;
        if (text != null) {
            String string = text.toString();
            if (!string.isEmpty() && !n70$a$$ExternalSyntheticRecord0.m14052m(string)) {
                str = string;
            }
        }
        this.listener.onNameChanged(str);
    }

    private void init(String str) {
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
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_scale_name_picker, null);
        viewInflate.setMinimumHeight(dimensionPixelSize);
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__label);
        textView.setTextColor(color);
        textView.setTextSize(0, dimension);
        ScreenAdjustingEditText screenAdjustingEditText = (ScreenAdjustingEditText) viewInflate.findViewById(R.id.pspdf__value_text);
        this.scaleName = screenAdjustingEditText;
        screenAdjustingEditText.setHint(R.string.pspdf__scale_unnamed);
        this.scaleName.setText(str);
        this.scaleName.setTextSize(0, dimension);
        this.scaleName.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleNameInspectorView$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$init$0(textView2, i, keyEvent);
            }
        });
        this.scaleName.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleNameInspectorView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.f$0.lambda$init$1(view, z);
            }
        });
        addView(viewInflate, new FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$init$0(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        hn.c(textView);
        forwardName();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view, boolean z) {
        if (z) {
            return;
        }
        forwardName();
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
