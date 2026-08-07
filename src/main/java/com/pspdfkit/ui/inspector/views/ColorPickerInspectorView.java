package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.pspdfkit.R;
import com.pspdfkit.internal.e9;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.n70;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.y70;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerInspectorView extends FrameLayout implements PropertyInspectorView {
    private static final int COLOR_CIRCLE_BORDER_WIDTH_DP = 1;
    private static final int COLOR_CIRCLE_RADIUS_DP = 8;
    private final List<Integer> availableDrawingColors;
    private ImageView colorView;
    private PropertyInspectorController controller;
    private ColorPickerDetailView detailView;
    private final String label;
    ColorPickerListener listener;

    public interface ColorPickerDetailView extends PropertyInspectorView {
        int getMaximumHeight();

        default Parcelable getState() {
            return null;
        }

        void setOnColorPickedListener(ColorPickerListener colorPickerListener);

        default void setState(Parcelable parcelable) {
        }
    }

    public interface ColorPickerListener {
        void onColorPicked(PropertyInspectorView propertyInspectorView, int i);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.SavedState.1
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
        Parcelable detailViewState;
        boolean isDetailViewVisible;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isDetailViewVisible ? 1 : 0);
            if (this.detailViewState == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeParcelable(this.detailViewState, i);
            }
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.isDetailViewVisible = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                this.detailViewState = parcel.readParcelable(getClass().getClassLoader());
            }
        }
    }

    public ColorPickerInspectorView(Context context, String str, int[] iArr, int i, ColorPickerListener colorPickerListener) {
        this(context, str, n70.a(iArr), i, colorPickerListener);
    }

    private void init(int i) {
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
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_color_picker, null);
        viewInflate.setMinimumHeight(dimensionPixelSize);
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__label);
        this.colorView = (ImageView) viewInflate.findViewById(R.id.pspdf__color);
        textView.setText(this.label);
        textView.setTextColor(color);
        textView.setTextSize(0, dimension);
        setColor(i, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.pspdf__expand_icon);
        Drawable drawable = AppCompatResources.getDrawable(getContext(), R.drawable.pspdf__ic_chevron_right);
        DrawableCompat.setTint(drawable, color);
        imageView.setImageDrawable(drawable);
        addView(viewInflate, new FrameLayout.LayoutParams(-1, -2));
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.ColorPickerInspectorView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        showDetailView(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRestoreInstanceState$2() {
        showDetailView(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setColorPickerDetailView$1(PropertyInspectorView propertyInspectorView, int i) {
        setColor(i, true);
    }

    private void showDetailView(boolean z) {
        PropertyInspectorController propertyInspectorController = this.controller;
        if (propertyInspectorController != null) {
            propertyInspectorController.showDetailView(this.detailView.getView(), this.label, z);
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

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.detailView.getView().measure(i, i2);
        super.onMeasure(i, i2);
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
            getViewTreeObserver().addOnGlobalLayoutListener(new y70(this, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.ui.inspector.views.ColorPickerInspectorView$$ExternalSyntheticLambda1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    this.f$0.lambda$onRestoreInstanceState$2();
                }
            }));
        }
        Parcelable parcelable2 = savedState.detailViewState;
        if (parcelable2 != null) {
            this.detailView.setState(parcelable2);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        PropertyInspectorController propertyInspectorController = this.controller;
        savedState.isDetailViewVisible = propertyInspectorController != null && propertyInspectorController.getVisibleDetailView() == this.detailView;
        savedState.detailViewState = this.detailView.getState();
        return savedState;
    }

    public void setColor(int i, boolean z) {
        ColorPickerListener colorPickerListener;
        ImageView imageView = this.colorView;
        Context context = getContext();
        int i2 = i == 0 ? -1 : i;
        double[] dArr = {d, 0.0d, 0.0d};
        ColorUtils.RGBToLAB(Color.red(i2), Color.green(i2), Color.blue(i2), dArr);
        double d = dArr[0] * ((double) 0.9f);
        imageView.setImageDrawable(new e9(context, ColorUtils.LABToColor(d, dArr[1], dArr[2]), i, 8.0f, 8.0f, 1.0f));
        if (!z || (colorPickerListener = this.listener) == null) {
            return;
        }
        colorPickerListener.onColorPicked(this, i);
    }

    public void setColorPickerDetailView(ColorPickerDetailView colorPickerDetailView) {
        this.detailView = colorPickerDetailView;
        colorPickerDetailView.setOnColorPickedListener(new ColorPickerListener() { // from class: com.pspdfkit.ui.inspector.views.ColorPickerInspectorView$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
            public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i) {
                this.f$0.lambda$setColorPickerDetailView$1(propertyInspectorView, i);
            }
        });
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        this.controller = null;
    }

    public ColorPickerInspectorView(Context context, String str, List<Integer> list, int i, ColorPickerListener colorPickerListener) {
        this(context, str, list, i, null, colorPickerListener);
    }

    public ColorPickerInspectorView(Context context, String str, List<Integer> list, int i, ColorPickerDetailView colorPickerDetailView, ColorPickerListener colorPickerListener) {
        super(context);
        uw.a(str, "label", null);
        uw.a(list, "colors", null);
        this.listener = colorPickerListener;
        ArrayList arrayList = new ArrayList(list);
        this.availableDrawingColors = arrayList;
        this.label = str;
        init(i);
        setColorPickerDetailView(colorPickerDetailView == null ? new ColorPickerInspectorDetailView(getContext(), (List<Integer>) arrayList, i, false) : colorPickerDetailView);
    }
}
