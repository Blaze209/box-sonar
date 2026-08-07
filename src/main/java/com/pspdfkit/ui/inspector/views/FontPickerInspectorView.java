package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.y70;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FontPickerInspectorView extends FrameLayout implements PropertyInspectorView {
    private final List<Font> availableFonts;
    private PropertyInspectorController controller;
    private FontPickerInspectorDetailView detailView;
    private TextView fontView;
    private final FontPickerListener listener;

    public interface FontPickerListener {
        void onFontSelected(Font font);
    }

    public interface FontSizePickerListener {
        void onFontSelected(Integer num);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.pspdfkit.ui.inspector.views.FontPickerInspectorView.SavedState.1
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
        boolean isDetailViewVisible;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isDetailViewVisible ? 1 : 0);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.isDetailViewVisible = parcel.readInt() == 1;
        }
    }

    public FontPickerInspectorView(Context context, List<Font> list, Font font, FontPickerListener fontPickerListener) {
        super(context);
        ArrayList arrayList = new ArrayList(list);
        this.availableFonts = arrayList;
        if (font != null && font.getDefaultTypeface() == null) {
            arrayList.add(font);
        }
        this.listener = fontPickerListener;
        init(font);
    }

    private void init(Font font) {
        Context context = getContext();
        TypedArray typedArrayA = ex.a(context);
        int dimensionPixelSize = typedArrayA.getDimensionPixelSize(R.styleable.pspdf__PropertyInspector_pspdf__itemHeight, context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_item_height));
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__backgroundColor, -1);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__progressBackgroundTint, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__textColor, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__errorColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight);
        typedArrayA.getBoolean(R.styleable.pspdf__PropertyInspector_pspdf__searchVisible, false);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__buttonIconTint, f60.a(context, androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight));
        typedArrayA.recycle();
        context.getResources().getDimension(R.dimen.pspdf__inspector_text_size);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_preview_item_height);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_padding);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_vertical_padding);
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_font_picker, null);
        viewInflate.setMinimumHeight(dimensionPixelSize);
        this.fontView = (TextView) viewInflate.findViewById(R.id.pspdf__font_view);
        if (font == null) {
            font = ar.c().getAvailableFonts().get(0);
        }
        setFont(font, false);
        addView(viewInflate, new FrameLayout.LayoutParams(-1, -2));
        this.detailView = new FontPickerInspectorDetailView(getContext(), this.availableFonts, font, new FontPickerListener() { // from class: com.pspdfkit.ui.inspector.views.FontPickerInspectorView$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.inspector.views.FontPickerInspectorView.FontPickerListener
            public final void onFontSelected(Font font2) {
                this.f$0.lambda$init$0(font2);
            }
        });
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.FontPickerInspectorView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(Font font) {
        setFont(font, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view) {
        showDetailView(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRestoreInstanceState$2() {
        showDetailView(false);
    }

    private void setFont(Font font, boolean z) {
        this.fontView.setTypeface(font.getDefaultTypeface());
        Typeface defaultTypeface = font.getDefaultTypeface();
        TextView textView = this.fontView;
        if (defaultTypeface == null) {
            textView.setText(no.a(getContext(), R.string.pspdf__font_missing, this.fontView, font.getName()));
        } else {
            textView.setText(font.getName());
        }
        if (z) {
            this.listener.onFontSelected(font);
        }
    }

    private void showDetailView(boolean z) {
        PropertyInspectorController propertyInspectorController = this.controller;
        if (propertyInspectorController != null) {
            propertyInspectorController.showDetailView(this.detailView, no.a(getContext(), R.string.pspdf__picker_font, null), z);
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
        this.controller = propertyInspectorController;
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
    public boolean isViewStateRestorationEnabled() {
        return true;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isDetailViewVisible) {
            getViewTreeObserver().addOnGlobalLayoutListener(new y70(this, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.ui.inspector.views.FontPickerInspectorView$$ExternalSyntheticLambda2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    this.f$0.lambda$onRestoreInstanceState$2();
                }
            }));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        PropertyInspectorController propertyInspectorController = this.controller;
        savedState.isDetailViewVisible = propertyInspectorController != null && propertyInspectorController.getVisibleDetailView() == this.detailView;
        return savedState;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        this.controller = null;
    }
}
