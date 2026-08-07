package com.box.android.preview.annotations.ui.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import com.box.android.preview.R;
import com.box.android.preview.databinding.ColorPickerLayoutBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorPickerFragment.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/annotations/ui/views/ColorPickerFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "gridView", "Landroid/widget/GridView;", ColorPickerFragment.EXTRA_SELECTED_COLOR, "", "Ljava/lang/Integer;", "onColorPicked", "Lkotlin/Function1;", "", "getOnColorPicked", "()Lkotlin/jvm/functions/Function1;", "setOnColorPicked", "(Lkotlin/jvm/functions/Function1;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setupGridView", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ColorPickerFragment extends DialogFragment {
    public static final String EXTRA_SELECTED_COLOR = "selectedColor";
    private GridView gridView;
    private Function1<? super Integer, Unit> onColorPicked;
    private Integer selectedColor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public final Function1<Integer, Unit> getOnColorPicked() {
        return this.onColorPicked;
    }

    public final void setOnColorPicked(Function1<? super Integer, Unit> function1) {
        this.onColorPicked = function1;
    }

    /* JADX INFO: compiled from: ColorPickerFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/preview/annotations/ui/views/ColorPickerFragment$Companion;", "", "<init>", "()V", "EXTRA_SELECTED_COLOR", "", "newInstance", "Lcom/box/android/preview/annotations/ui/views/ColorPickerFragment;", ColorPickerFragment.EXTRA_SELECTED_COLOR, "", "(Ljava/lang/Integer;)Lcom/box/android/preview/annotations/ui/views/ColorPickerFragment;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ColorPickerFragment newInstance(Integer selectedColor) {
            ColorPickerFragment colorPickerFragment = new ColorPickerFragment();
            Bundle bundle = new Bundle();
            if (selectedColor != null) {
                selectedColor.intValue();
                bundle.putInt(ColorPickerFragment.EXTRA_SELECTED_COLOR, selectedColor.intValue());
            }
            colorPickerFragment.setArguments(bundle);
            return colorPickerFragment;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ColorPickerLayoutBinding colorPickerLayoutBindingInflate = ColorPickerLayoutBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(colorPickerLayoutBindingInflate, "inflate(...)");
        this.selectedColor = Integer.valueOf(requireArguments().getInt(EXTRA_SELECTED_COLOR));
        GridView colorPickerGrid = colorPickerLayoutBindingInflate.colorPickerGrid;
        Intrinsics.checkNotNullExpressionValue(colorPickerGrid, "colorPickerGrid");
        this.gridView = colorPickerGrid;
        setupGridView();
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(requireContext()).setView((View) colorPickerLayoutBindingInflate.getRoot()).setBackground(new ColorDrawable(0)).create();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.color_picker_dialog_width);
        Window window = alertDialogCreate.getWindow();
        Intrinsics.checkNotNull(window);
        window.setLayout(dimensionPixelSize, -2);
        window.setGravity(17);
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "apply(...)");
        return alertDialogCreate;
    }

    private final void setupGridView() {
        GridView gridView;
        List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.color.color_picker_white), Integer.valueOf(R.color.color_picker_light_grey), Integer.valueOf(R.color.color_picker_grey), Integer.valueOf(R.color.color_picker_dark_grey), Integer.valueOf(R.color.color_picker_black), Integer.valueOf(R.color.color_picker_dark_blue), Integer.valueOf(R.color.color_picker_dark_violet), Integer.valueOf(R.color.color_picker_dark_red), Integer.valueOf(R.color.color_picker_brown), Integer.valueOf(R.color.color_picker_dark_green), Integer.valueOf(R.color.color_picker_blue), Integer.valueOf(R.color.color_picker_violet), Integer.valueOf(R.color.color_picker_red), Integer.valueOf(R.color.color_picker_orange), Integer.valueOf(R.color.color_picker_green), Integer.valueOf(R.color.color_picker_light_blue), Integer.valueOf(R.color.color_picker_light_violet), Integer.valueOf(R.color.color_picker_light_red), Integer.valueOf(R.color.color_picker_yellow), Integer.valueOf(R.color.color_picker_light_green), Integer.valueOf(R.color.color_picker_pale_blue), Integer.valueOf(R.color.color_picker_pale_violet), Integer.valueOf(R.color.color_picker_pale_red), Integer.valueOf(R.color.color_picker_pale_yellow), Integer.valueOf(R.color.color_picker_pale_green)});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (true) {
            gridView = null;
            if (!it.hasNext()) {
                break;
            } else {
                arrayList.add(Integer.valueOf(ResourcesCompat.getColor(getResources(), ((Number) it.next()).intValue(), null)));
            }
        }
        ArrayList arrayList2 = arrayList;
        GridView gridView2 = this.gridView;
        if (gridView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridView");
        } else {
            gridView = gridView2;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        gridView.setAdapter((ListAdapter) new ColorPickerAdapter(contextRequireContext, arrayList2, this.selectedColor, new Function1() { // from class: com.box.android.preview.annotations.ui.views.ColorPickerFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ColorPickerFragment.setupGridView$lambda$1(this.f$0, ((Integer) obj).intValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupGridView$lambda$1(ColorPickerFragment colorPickerFragment, int i) {
        Function1<? super Integer, Unit> function1 = colorPickerFragment.onColorPicked;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
        colorPickerFragment.dismiss();
        return Unit.INSTANCE;
    }
}
