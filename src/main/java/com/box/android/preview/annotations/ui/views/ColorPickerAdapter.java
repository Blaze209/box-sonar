package com.box.android.preview.annotations.ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.box.android.preview.R;
import com.box.android.preview.databinding.ColorPickerItemBinding;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorPickerAdapter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/box/android/preview/annotations/ui/views/ColorPickerAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "colors", "", "", ColorPickerFragment.EXTRA_SELECTED_COLOR, "onColorPicked", "Lkotlin/Function1;", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Integer;", "getCount", "getItem", "", ViewProps.POSITION, "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "createColorDrawable", "Landroid/graphics/drawable/LayerDrawable;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ColorPickerAdapter extends BaseAdapter {
    public static final int $stable = 8;
    private final List<Integer> colors;
    private final Context context;
    private final Function1<Integer, Unit> onColorPicked;
    private Integer selectedColor;

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ColorPickerAdapter(Context context, List<Integer> colors, Integer num, Function1<? super Integer, Unit> onColorPicked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(onColorPicked, "onColorPicked");
        this.context = context;
        this.colors = colors;
        this.selectedColor = num;
        this.onColorPicked = onColorPicked;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.colors.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.colors.get(position);
    }

    @Override // android.widget.Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        ColorPickerItemBinding colorPickerItemBindingInflate;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (convertView == null || (colorPickerItemBindingInflate = ColorPickerItemBinding.bind(convertView)) == null) {
            colorPickerItemBindingInflate = ColorPickerItemBinding.inflate(LayoutInflater.from(parent.getContext()));
            Intrinsics.checkNotNullExpressionValue(colorPickerItemBindingInflate, "inflate(...)");
        }
        LayerDrawable layerDrawableCreateColorDrawable = createColorDrawable();
        layerDrawableCreateColorDrawable.findDrawableByLayerId(R.id.color_item).setTint(this.colors.get(position).intValue());
        Drawable drawableFindDrawableByLayerId = layerDrawableCreateColorDrawable.findDrawableByLayerId(R.id.color_border);
        int iIntValue = this.colors.get(position).intValue();
        Integer num = this.selectedColor;
        drawableFindDrawableByLayerId.setAlpha((num != null && iIntValue == num.intValue()) ? 255 : 0);
        colorPickerItemBindingInflate.colorPickerImageView.setImageDrawable(layerDrawableCreateColorDrawable);
        colorPickerItemBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.box.android.preview.annotations.ui.views.ColorPickerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ColorPickerAdapter.getView$lambda$1(this.f$0, position, view);
            }
        });
        ConstraintLayout root = colorPickerItemBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getView$lambda$1(ColorPickerAdapter colorPickerAdapter, int i, View view) {
        colorPickerAdapter.selectedColor = colorPickerAdapter.colors.get(i);
        colorPickerAdapter.notifyDataSetChanged();
        colorPickerAdapter.onColorPicked.invoke(colorPickerAdapter.colors.get(i));
    }

    public final LayerDrawable createColorDrawable() {
        Drawable drawable = ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.color_picker_item_list, this.context.getTheme());
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        return (LayerDrawable) drawable;
    }
}
