package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.internal.c30;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.ui.views.UnderlinedTextView;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.y70;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputInspectorView extends FrameLayout implements PropertyInspectorView {
    private PropertyInspectorController controller;
    private EditText editText;
    private final String label;
    private TextView labelView;
    private TextInputListener listener;
    private FrameLayout textInputContainer;
    private UnderlinedTextView textView;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.pspdfkit.ui.inspector.views.TextInputInspectorView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean isDetailPickerVisible;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isDetailPickerVisible ? 1 : 0);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.isDetailPickerVisible = parcel.readInt() == 1;
        }
    }

    public interface TextInputListener {
        void onValuePicked(TextInputInspectorView textInputInspectorView, String str);
    }

    public TextInputInspectorView(Context context, String str, String str2, TextInputListener textInputListener) {
        super(context);
        uw.a(str, "label", null);
        uw.a(str2, "defaultValue", null);
        this.label = str;
        init(str2, textInputListener);
    }

    private void init(String str, TextInputListener textInputListener) {
        Context context = getContext();
        TypedArray typedArrayA = ex.a(context);
        int dimensionPixelSize = typedArrayA.getDimensionPixelSize(R.styleable.pspdf__PropertyInspector_pspdf__itemHeight, context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_item_height));
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__backgroundColor, -1);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__progressBackgroundTint, -7829368);
        int color = typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__textColor, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__errorColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight);
        typedArrayA.getBoolean(R.styleable.pspdf__PropertyInspector_pspdf__searchVisible, false);
        int iA = f60.a(context, androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__buttonIconTint, iA);
        typedArrayA.recycle();
        float dimension = context.getResources().getDimension(R.dimen.pspdf__inspector_text_size);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_preview_item_height);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_padding);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_vertical_padding);
        LayoutInflater.from(getContext()).inflate(R.layout.pspdf__view_inspector_text, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(R.id.pspdf__label);
        this.labelView = textView;
        textView.setText(this.label);
        this.labelView.setTextColor(color);
        this.labelView.setTextSize(0, dimension);
        UnderlinedTextView underlinedTextView = (UnderlinedTextView) findViewById(R.id.pspdf__text);
        this.textView = underlinedTextView;
        underlinedTextView.setTextColor(color);
        this.textView.setTextSize(0, dimension);
        this.textView.setUnderLineColor(iA);
        this.textInputContainer = (FrameLayout) findViewById(R.id.pspdf__text_input_container);
        EditText editText = (EditText) findViewById(R.id.pspdf__text_input);
        this.editText = editText;
        editText.setHint(this.label);
        this.editText.setTextColor(color);
        this.editText.setTextSize(0, dimension);
        this.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.pspdfkit.ui.inspector.views.TextInputInspectorView.1
            private int originalSoftInputMode;

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                TextInputInspectorView textInputInspectorView = TextInputInspectorView.this;
                if (z) {
                    this.originalSoftInputMode = hn.a(textInputInspectorView.getContext(), 16);
                } else {
                    hn.a(textInputInspectorView.getContext(), this.originalSoftInputMode);
                    hn.c(TextInputInspectorView.this.editText);
                }
            }
        });
        this.editText.addTextChangedListener(new c30() { // from class: com.pspdfkit.ui.inspector.views.TextInputInspectorView.2
            @Override // com.pspdfkit.internal.c30, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextInputInspectorView.this.setValue(editable.toString(), true);
            }
        });
        View viewFindViewById = findViewById(R.id.pspdf__text_picker_title_row);
        viewFindViewById.setMinimumHeight(dimensionPixelSize);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.TextInputInspectorView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        setValue(str, false);
        this.listener = textInputListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        showDetailPicker(this.textInputContainer.getVisibility() != 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRestoreInstanceState$2(SavedState savedState) {
        showDetailPicker(savedState.isDetailPickerVisible, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDetailPicker$1() {
        this.editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(String str, boolean z) {
        if (!z) {
            this.editText.setText(str);
        }
        this.textView.setText(str);
        TextInputListener textInputListener = this.listener;
        if (textInputListener == null || !z) {
            return;
        }
        textInputListener.onValuePicked(this, str);
    }

    private void showDetailPicker(boolean z, boolean z2) {
        FrameLayout frameLayout = this.textInputContainer;
        if (!z) {
            frameLayout.setVisibility(8);
            return;
        }
        frameLayout.setVisibility(0);
        if (z2) {
            return;
        }
        this.editText.setAlpha(0.0f);
        this.editText.animate().alpha(1.0f).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.inspector.views.TextInputInspectorView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showDetailPicker$1();
            }
        });
        PropertyInspectorController propertyInspectorController = this.controller;
        if (propertyInspectorController != null) {
            propertyInspectorController.ensureFullyVisible(this);
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
        this.controller = propertyInspectorController;
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

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public boolean isViewStateRestorationEnabled() {
        return true;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isDetailPickerVisible) {
            getViewTreeObserver().addOnGlobalLayoutListener(new y70(this, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.ui.inspector.views.TextInputInspectorView$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    this.f$0.lambda$onRestoreInstanceState$2(savedState);
                }
            }));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isDetailPickerVisible = this.editText.getVisibility() == 0;
        return savedState;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        this.controller = null;
    }
}
