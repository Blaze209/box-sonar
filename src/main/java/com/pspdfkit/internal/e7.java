package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pspdfkit.R;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e7<T> extends FrameLayout implements PropertyInspectorView {
    private static final int DETAIL_PICKER_ITEM_SIZE_DP = 42;
    private static final int MAX_INLINE_ITEMS = 5;
    private final List<a<T>> availablePickerItems;
    private PropertyInspectorController controller;
    private GridLayout detailPickerLayout;
    private final String label;
    private int lastAvailableWidth;
    private ImageButton pickedItemView;
    private final List<ImageButton> pickerViews;
    private LinearLayout root;
    private T selectedItem;
    private dx style;
    private LinearLayout titleRow;

    public static class a<T> {
        public final vn a;
        public final T b;
        public Drawable c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(vn vnVar, Object obj) {
            this.a = vnVar;
            this.b = obj;
        }

        public final Drawable a() {
            if (this.c == null) {
                this.c = this.a.mutate();
            }
            return this.c;
        }
    }

    public static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public boolean a;

        public class a implements Parcelable.Creator<b> {
            @Override // android.os.Parcelable.Creator
            public final b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt() == 1;
        }
    }

    public e7(Context context, String str, List<a<T>> list, T t) {
        super(context);
        this.pickerViews = new ArrayList();
        this.lastAvailableWidth = Integer.MIN_VALUE;
        uw.a(str, "label", null);
        uw.a(list, "pickerItems", null);
        uw.a(t, "selectedItem", null);
        this.label = str;
        this.availablePickerItems = list;
        init(t);
    }

    private ImageButton createPickerButton(final a<T> aVar) {
        ImageButton imageButtonInflatePickerButton = inflatePickerButton();
        imageButtonInflatePickerButton.setTag(aVar.b);
        imageButtonInflatePickerButton.setImageDrawable(aVar.a);
        imageButtonInflatePickerButton.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.e7$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createPickerButton$1(aVar, view);
            }
        });
        return imageButtonInflatePickerButton;
    }

    private ImageButton inflatePickerButton() {
        return (ImageButton) LayoutInflater.from(getContext()).inflate(R.layout.pspdf__view_options_picker_item, (ViewGroup) this.root, false);
    }

    private void init(T t) {
        this.style = new dx(getContext());
        LinearLayout linearLayout = (LinearLayout) View.inflate(getContext(), R.layout.pspdf__view_inspector_options_picker, null);
        this.root = linearLayout;
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.pspdf__options_picker_title_row);
        this.titleRow = linearLayout2;
        linearLayout2.setMinimumHeight(this.style.a);
        TextView textView = (TextView) this.root.findViewById(R.id.pspdf__label);
        textView.setText(this.label);
        textView.setTextColor(this.style.c);
        textView.setTextSize(0, this.style.d);
        initPickerItems();
        setPickedItem(t, false);
        addView(this.root, new FrameLayout.LayoutParams(-1, -2));
    }

    private void initPickerItems() {
        int size = this.availablePickerItems.size();
        int i = 0;
        if (size <= 5) {
            while (i < size) {
                ImageButton imageButtonCreatePickerButton = createPickerButton(this.availablePickerItems.get(i));
                this.pickerViews.add(imageButtonCreatePickerButton);
                this.titleRow.addView(imageButtonCreatePickerButton);
                i++;
            }
            return;
        }
        ImageButton imageButtonInflatePickerButton = inflatePickerButton();
        this.pickedItemView = imageButtonInflatePickerButton;
        imageButtonInflatePickerButton.setClickable(false);
        this.pickedItemView.setBackground(null);
        this.titleRow.addView(this.pickedItemView);
        this.titleRow.setClickable(true);
        GridLayout gridLayout = (GridLayout) this.root.findViewById(R.id.pspdf__options_picker_detail_view);
        this.detailPickerLayout = gridLayout;
        gridLayout.setMinimumHeight(this.style.a);
        this.titleRow.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.e7$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initPickerItems$0(view);
            }
        });
        while (i < size) {
            ImageButton imageButtonCreatePickerButton2 = createPickerButton(this.availablePickerItems.get(i));
            this.pickerViews.add(imageButtonCreatePickerButton2);
            this.detailPickerLayout.addView(imageButtonCreatePickerButton2);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPickerButton$1(a aVar, View view) {
        setPickedItem(aVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPickerItems$0(View view) {
        showDetailPicker(this.detailPickerLayout.getVisibility() != 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRestoreInstanceState$2(b bVar) {
        showDetailPicker(bVar.a, true);
    }

    private void refreshSelectedItem() {
        if (this.selectedItem == null) {
            return;
        }
        for (ImageButton imageButton : this.pickerViews) {
            imageButton.setSelected(imageButton.getTag() == this.selectedItem);
        }
        if (this.pickedItemView != null) {
            for (a<T> aVar : this.availablePickerItems) {
                if (aVar.b == this.selectedItem) {
                    this.pickedItemView.setImageDrawable(aVar.a());
                    return;
                }
            }
        }
    }

    private void showDetailPicker(boolean z, boolean z2) {
        GridLayout gridLayout = this.detailPickerLayout;
        if (gridLayout == null) {
            return;
        }
        if (!z) {
            gridLayout.setVisibility(8);
            return;
        }
        gridLayout.setVisibility(0);
        refreshSelectedItem();
        if (z2) {
            return;
        }
        this.detailPickerLayout.setAlpha(0.0f);
        this.detailPickerLayout.animate().alpha(1.0f);
        PropertyInspectorController propertyInspectorController = this.controller;
        if (propertyInspectorController != null) {
            propertyInspectorController.ensureFullyVisible(this);
        }
    }

    private void updateDetailPickerLayoutParams() {
        if (this.detailPickerLayout == null) {
            return;
        }
        int measuredWidth = (getMeasuredWidth() - this.detailPickerLayout.getPaddingLeft()) - this.detailPickerLayout.getPaddingRight();
        int iA = a80.a(getContext(), 42);
        int iMax = Math.max(measuredWidth / iA, 2);
        int size = this.pickerViews.size();
        int iMax2 = (int) Math.max(Math.ceil(size / iMax), 1.0d);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(iA, iA);
        marginLayoutParams.rightMargin = ((measuredWidth - (iA * 2)) - ((iMax - 2) * iA)) / (iMax - 1);
        for (int i = 0; i < size; i++) {
            ImageButton imageButton = this.pickerViews.get(i);
            if (i < size - 1) {
                imageButton.setLayoutParams(new GridLayout.LayoutParams(marginLayoutParams));
            } else {
                imageButton.setLayoutParams(new GridLayout.LayoutParams((ViewGroup.MarginLayoutParams) new LinearLayout.LayoutParams(iA, iA)));
            }
        }
        this.detailPickerLayout.setRowCount(iMax2);
        this.detailPickerLayout.setColumnCount(iMax);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
        this.controller = propertyInspectorController;
    }

    public T getPickedItem() {
        return this.selectedItem;
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

    public abstract void onItemPicked(T t);

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.detailPickerLayout != null) {
            int measuredWidth = (getMeasuredWidth() - this.detailPickerLayout.getPaddingLeft()) - this.detailPickerLayout.getPaddingRight();
            if (getMeasuredWidth() <= 0 || getMeasuredWidth() == this.lastAvailableWidth) {
                this.lastAvailableWidth = measuredWidth;
            } else {
                this.lastAvailableWidth = measuredWidth;
                updateDetailPickerLayoutParams();
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        if (bVar.a) {
            getViewTreeObserver().addOnGlobalLayoutListener(new y70(this, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.internal.e7$$ExternalSyntheticLambda1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    this.f$0.lambda$onRestoreInstanceState$2(bVar);
                }
            }));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        GridLayout gridLayout = this.detailPickerLayout;
        bVar.a = gridLayout != null && gridLayout.getVisibility() == 0;
        return bVar;
    }

    public void setPickedItem(T t, boolean z) {
        this.selectedItem = t;
        refreshSelectedItem();
        if (z) {
            onItemPicked(t);
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        this.controller = null;
    }
}
