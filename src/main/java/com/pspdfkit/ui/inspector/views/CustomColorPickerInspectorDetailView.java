package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.pspdfkit.R;
import com.pspdfkit.internal.f9;
import com.pspdfkit.internal.fc;
import com.pspdfkit.internal.j9;
import com.pspdfkit.internal.n70;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.ui.inspector.ColorPaletteView;
import com.pspdfkit.internal.ui.inspector.ColorPreviewView;
import com.pspdfkit.internal.ui.views.WrapContentViewPager;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CustomColorPickerInspectorDetailView extends LinearLayout implements ColorPickerInspectorView.ColorPickerDetailView {
    private static final int PAGES = 2;
    private static final int PAGE_PALETTES = 0;
    private final f9 colorHistory;
    private ColorPreviewView colorPreviewView;
    private final j9 colorVariationGenerator;
    private final List<Integer> colors;
    private fc customColorPickerView;
    private CustomColorPickerState lastState;
    private ColorPickerInspectorView.ColorPickerListener listener;
    private WrapContentViewPager modePager;
    private ColorPaletteView paletteColorView;
    private ColorPaletteView recentColorsPalette;
    private TextView recentColorsPaletteTitle;
    private ColorPaletteView variationsColorView;

    /* JADX INFO: renamed from: com.pspdfkit.ui.inspector.views.CustomColorPickerInspectorDetailView$1, reason: invalid class name */
    public class AnonymousClass1 extends PagerAdapter {
        final /* synthetic */ Context val$context;
        final /* synthetic */ int val$defaultValue;
        final /* synthetic */ LayoutInflater val$layoutInflater;

        public AnonymousClass1(LayoutInflater layoutInflater, int i, Context context) {
            this.val$layoutInflater = layoutInflater;
            this.val$defaultValue = i;
            this.val$context = context;
        }

        private View createCustomColorPickerView() {
            CustomColorPickerInspectorDetailView customColorPickerInspectorDetailView = CustomColorPickerInspectorDetailView.this;
            Context context = this.val$context;
            context.getClass();
            customColorPickerInspectorDetailView.customColorPickerView = new fc(context);
            CustomColorPickerInspectorDetailView.this.customColorPickerView.setCurrentColor(this.val$defaultValue);
            CustomColorPickerInspectorDetailView.this.customColorPickerView.setListener(new fc.a() { // from class: com.pspdfkit.ui.inspector.views.CustomColorPickerInspectorDetailView$1$$ExternalSyntheticLambda0
                @Override // com.pspdfkit.internal.fc.a
                public final void a(int i) {
                    this.f$0.lambda$createCustomColorPickerView$1(i);
                }
            });
            CustomColorPickerInspectorDetailView customColorPickerInspectorDetailView2 = CustomColorPickerInspectorDetailView.this;
            CustomColorPickerState customColorPickerState = customColorPickerInspectorDetailView2.lastState;
            if (customColorPickerState != null) {
                customColorPickerInspectorDetailView2.modePager.setCurrentItem(customColorPickerState.currentPage);
                CustomColorPickerInspectorDetailView customColorPickerInspectorDetailView3 = CustomColorPickerInspectorDetailView.this;
                customColorPickerInspectorDetailView3.customColorPickerView.setCurrentMode(customColorPickerInspectorDetailView3.lastState.currentCustomPickerMode);
            }
            return CustomColorPickerInspectorDetailView.this.customColorPickerView;
        }

        private View createPaletteView() {
            View viewInflate = this.val$layoutInflater.inflate(R.layout.pspdf__color_palette_view, (ViewGroup) CustomColorPickerInspectorDetailView.this, false);
            CustomColorPickerInspectorDetailView.this.recentColorsPaletteTitle = (TextView) viewInflate.findViewById(R.id.pspdf__recently_used_palette_title);
            CustomColorPickerInspectorDetailView.this.recentColorsPalette = (ColorPaletteView) viewInflate.findViewById(R.id.pspdf__recently_used_palette);
            CustomColorPickerInspectorDetailView.this.updateRecentColors();
            CustomColorPickerInspectorDetailView.this.recentColorsPalette.setShowSelectionIndicator(true);
            CustomColorPickerInspectorDetailView.this.paletteColorView = (ColorPaletteView) viewInflate.findViewById(R.id.pspdf__default_palette);
            CustomColorPickerInspectorDetailView customColorPickerInspectorDetailView = CustomColorPickerInspectorDetailView.this;
            customColorPickerInspectorDetailView.paletteColorView.setAvailableColors(customColorPickerInspectorDetailView.colors);
            CustomColorPickerInspectorDetailView.this.variationsColorView = (ColorPaletteView) viewInflate.findViewById(R.id.pspdf__color_variations_palette);
            CustomColorPickerInspectorDetailView.this.setSelectedColorInAllPalettes(this.val$defaultValue);
            ColorPaletteView.a aVar = new ColorPaletteView.a() { // from class: com.pspdfkit.ui.inspector.views.CustomColorPickerInspectorDetailView$1$$ExternalSyntheticLambda1
                @Override // com.pspdfkit.internal.ui.inspector.ColorPaletteView.a
                public final void a(ColorPaletteView colorPaletteView, int i) {
                    this.f$0.lambda$createPaletteView$0(colorPaletteView, i);
                }
            };
            CustomColorPickerInspectorDetailView.this.recentColorsPalette.setOnColorPickedListener(aVar);
            CustomColorPickerInspectorDetailView.this.paletteColorView.setOnColorPickedListener(aVar);
            CustomColorPickerInspectorDetailView.this.variationsColorView.setOnColorPickedListener(aVar);
            CustomColorPickerInspectorDetailView.this.updateColorVariations(this.val$defaultValue);
            return viewInflate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createCustomColorPickerView$1(int i) {
            CustomColorPickerInspectorDetailView.this.colorPicked(i);
            CustomColorPickerInspectorDetailView.this.updateColorVariations(i);
            ColorPaletteView colorPaletteView = CustomColorPickerInspectorDetailView.this.recentColorsPalette;
            if (colorPaletteView != null) {
                colorPaletteView.setShowSelectionIndicator(true);
            }
            ColorPaletteView colorPaletteView2 = CustomColorPickerInspectorDetailView.this.paletteColorView;
            if (colorPaletteView2 != null) {
                colorPaletteView2.setShowSelectionIndicator(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createPaletteView$0(ColorPaletteView colorPaletteView, int i) {
            CustomColorPickerInspectorDetailView.this.recentColorsPalette.setShowSelectionIndicator(false);
            CustomColorPickerInspectorDetailView.this.paletteColorView.setShowSelectionIndicator(false);
            CustomColorPickerInspectorDetailView.this.variationsColorView.setShowSelectionIndicator(false);
            colorPaletteView.setShowSelectionIndicator(true);
            CustomColorPickerInspectorDetailView.this.colorPicked(i);
            CustomColorPickerInspectorDetailView customColorPickerInspectorDetailView = CustomColorPickerInspectorDetailView.this;
            if (colorPaletteView != customColorPickerInspectorDetailView.variationsColorView) {
                customColorPickerInspectorDetailView.updateColorVariations(i);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            Context context = this.val$context;
            return i == 0 ? no.a(context, R.string.pspdf__color_picker_palette, null) : no.a(context, R.string.pspdf__custom_stamp, null);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (i == 0) {
                View viewCreatePaletteView = createPaletteView();
                viewGroup.addView(viewCreatePaletteView, -1, -2);
                return viewCreatePaletteView;
            }
            View viewCreateCustomColorPickerView = createCustomColorPickerView();
            viewGroup.addView(viewCreateCustomColorPickerView, -1, -2);
            return viewCreateCustomColorPickerView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public CustomColorPickerInspectorDetailView(Context context, int[] iArr, int i) {
        this(context, n70.a(iArr), i);
    }

    private void addColorToHistory(int i) {
        f9 f9Var = this.colorHistory;
        f9Var.getClass();
        if (Color.alpha(i) != 0) {
            List<Integer> recentlyUsedColors = f9Var.a.getRecentlyUsedColors();
            recentlyUsedColors.getClass();
            if (recentlyUsedColors.contains(Integer.valueOf(i))) {
                recentlyUsedColors.remove(Integer.valueOf(i));
            }
            recentlyUsedColors.add(0, Integer.valueOf(i));
            while (recentlyUsedColors.size() > 18) {
                recentlyUsedColors.remove(recentlyUsedColors.size() - 1);
            }
            f9Var.a.setRecentlyUsedColors(recentlyUsedColors);
        }
        updateRecentColors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void colorPicked(int i) {
        setSelectedColorInAllPalettes(i);
        this.colorPreviewView.setCurrentColor(i);
        fc fcVar = this.customColorPickerView;
        if (fcVar != null) {
            fcVar.setCurrentColor(i);
        }
        ColorPickerInspectorView.ColorPickerListener colorPickerListener = this.listener;
        if (colorPickerListener != null) {
            colorPickerListener.onColorPicked(this, i);
        }
    }

    private void init(Context context, int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        layoutInflaterFrom.inflate(R.layout.pspdf__color_picker_detail, (ViewGroup) this, true);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        ColorPreviewView colorPreviewView = (ColorPreviewView) findViewById(R.id.pspdf__color_preview_view);
        this.colorPreviewView = colorPreviewView;
        colorPreviewView.setPreviousColor(i);
        this.colorPreviewView.setCurrentColor(i);
        this.colorPreviewView.setOnPreviousColorSelected(new ColorPreviewView.a() { // from class: com.pspdfkit.ui.inspector.views.CustomColorPickerInspectorDetailView$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.ui.inspector.ColorPreviewView.a
            public final void a(int i2) {
                this.f$0.colorPicked(i2);
            }
        });
        WrapContentViewPager wrapContentViewPager = (WrapContentViewPager) findViewById(R.id.pspdf__color_mode_pager);
        this.modePager = wrapContentViewPager;
        wrapContentViewPager.setAdapter(new AnonymousClass1(layoutInflaterFrom, i, context));
        this.modePager.setPagingEnabled(false);
        ((TabLayout) findViewById(R.id.pspdf__color_mode_tabs)).setupWithViewPager(this.modePager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedColorInAllPalettes(int i) {
        ColorPaletteView colorPaletteView = this.recentColorsPalette;
        if (colorPaletteView != null) {
            if (colorPaletteView.d != i || !colorPaletteView.showSelectionIndicator) {
                colorPaletteView.d = i;
                colorPaletteView.a();
            }
            ColorPaletteView colorPaletteView2 = this.paletteColorView;
            if (colorPaletteView2.d != i || !colorPaletteView2.showSelectionIndicator) {
                colorPaletteView2.d = i;
                colorPaletteView2.a();
            }
            ColorPaletteView colorPaletteView3 = this.variationsColorView;
            if (colorPaletteView3.d == i && colorPaletteView3.showSelectionIndicator) {
                return;
            }
            colorPaletteView3.d = i;
            colorPaletteView3.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateColorVariations(int i) {
        ColorPaletteView colorPaletteView = this.variationsColorView;
        if (colorPaletteView != null) {
            this.colorVariationGenerator.getClass();
            colorPaletteView.setAvailableColors(j9.a(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecentColors() {
        if (this.recentColorsPalette != null) {
            List<Integer> recentlyUsedColors = this.colorHistory.a.getRecentlyUsedColors();
            recentlyUsedColors.getClass();
            this.recentColorsPalette.setAvailableColors(recentlyUsedColors);
            boolean zIsEmpty = recentlyUsedColors.isEmpty();
            TextView textView = this.recentColorsPaletteTitle;
            if (zIsEmpty) {
                textView.setVisibility(8);
                this.recentColorsPalette.setVisibility(8);
            } else {
                textView.setVisibility(0);
                this.recentColorsPalette.setVisibility(0);
            }
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
    }

    @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerDetailView
    public int getMaximumHeight() {
        return getMeasuredHeight();
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return this.colorPreviewView.getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMaxHeight() {
        return getMaximumHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMinHeight() {
        return getMinimumHeight();
    }

    @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerDetailView
    public Parcelable getState() {
        if (this.customColorPickerView != null) {
            return new CustomColorPickerState(this.modePager.getCurrentItem(), this.customColorPickerView.getCurrentMode());
        }
        return null;
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
    public void onHidden() {
        ColorPreviewView colorPreviewView = this.colorPreviewView;
        colorPreviewView.setPreviousColor(colorPreviewView.getCurrentColor());
        addColorToHistory(this.colorPreviewView.getCurrentColor());
    }

    @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerDetailView
    public void setOnColorPickedListener(ColorPickerInspectorView.ColorPickerListener colorPickerListener) {
        this.listener = colorPickerListener;
    }

    @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerDetailView
    public void setState(Parcelable parcelable) {
        if (parcelable instanceof CustomColorPickerState) {
            CustomColorPickerState customColorPickerState = (CustomColorPickerState) parcelable;
            if (this.customColorPickerView != null) {
                this.modePager.setCurrentItem(customColorPickerState.currentPage);
                this.customColorPickerView.setCurrentMode(customColorPickerState.currentCustomPickerMode);
            }
            this.lastState = customColorPickerState;
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        addColorToHistory(this.colorPreviewView.getCurrentColor());
    }

    public CustomColorPickerInspectorDetailView(Context context, List<Integer> list, int i) {
        super(context);
        this.colorVariationGenerator = new j9();
        uw.a(list, "colors", null);
        this.colors = new ArrayList(list);
        this.colorHistory = new f9(context);
        init(context, i);
    }

    public static class CustomColorPickerState implements Parcelable {
        public static final Parcelable.Creator<CustomColorPickerState> CREATOR = new Parcelable.Creator<CustomColorPickerState>() { // from class: com.pspdfkit.ui.inspector.views.CustomColorPickerInspectorDetailView.CustomColorPickerState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomColorPickerState createFromParcel(Parcel parcel) {
                return new CustomColorPickerState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomColorPickerState[] newArray(int i) {
                return new CustomColorPickerState[i];
            }
        };
        final int currentCustomPickerMode;
        final int currentPage;

        public CustomColorPickerState(int i, int i2) {
            this.currentPage = i;
            this.currentCustomPickerMode = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.currentPage);
            parcel.writeInt(this.currentCustomPickerMode);
        }

        private CustomColorPickerState(Parcel parcel) {
            this.currentPage = parcel.readInt();
            this.currentCustomPickerMode = parcel.readInt();
        }
    }
}
