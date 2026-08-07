package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.internal.e7;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.un;
import com.pspdfkit.internal.vn;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BorderStylePickerInspectorView extends e7<BorderStylePreset> {
    BorderStylePickerListener listener;

    public interface BorderStylePickerListener {
        void onBorderStylePicked(BorderStylePickerInspectorView borderStylePickerInspectorView, BorderStylePreset borderStylePreset);
    }

    public BorderStylePickerInspectorView(Context context, String str, List<BorderStylePreset> list, BorderStylePreset borderStylePreset, BorderStylePickerListener borderStylePickerListener) {
        super(context, str, getPickerItems(context, list), getDefaultPreset(list, borderStylePreset));
        this.listener = borderStylePickerListener;
    }

    private static BorderStylePreset getDefaultPreset(List<BorderStylePreset> list, BorderStylePreset borderStylePreset) {
        for (BorderStylePreset borderStylePreset2 : list) {
            if (borderStylePreset.equals(borderStylePreset2)) {
                return borderStylePreset2;
            }
        }
        for (BorderStylePreset borderStylePreset3 : list) {
            if (borderStylePreset.getBorderStyle() == borderStylePreset3.getBorderStyle() && borderStylePreset.getBorderEffect() == borderStylePreset3.getBorderEffect()) {
                return borderStylePreset3;
            }
        }
        return list.get(0);
    }

    private static List<e7.a<BorderStylePreset>> getPickerItems(Context context, List<BorderStylePreset> list) {
        ArrayList arrayList = new ArrayList();
        TypedArray typedArrayA = ex.a(context);
        typedArrayA.getDimensionPixelSize(R.styleable.pspdf__PropertyInspector_pspdf__itemHeight, context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_item_height));
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__backgroundColor, -1);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__progressBackgroundTint, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__textColor, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__errorColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight);
        typedArrayA.getBoolean(R.styleable.pspdf__PropertyInspector_pspdf__searchVisible, false);
        int iA = f60.a(context, androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__buttonIconTint, iA);
        typedArrayA.recycle();
        context.getResources().getDimension(R.dimen.pspdf__inspector_text_size);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_preview_item_height);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_padding);
        context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_vertical_padding);
        int iA2 = (int) un.a(context, 1, 1);
        for (BorderStylePreset borderStylePreset : list) {
            LineEndType lineEndType = LineEndType.NONE;
            Context context2 = context;
            arrayList.add(new e7.a(new vn(context2, iA, iA2, borderStylePreset, lineEndType, lineEndType), borderStylePreset));
            context = context2;
        }
        return arrayList;
    }

    @Override // com.pspdfkit.internal.e7
    public void onItemPicked(BorderStylePreset borderStylePreset) {
        BorderStylePickerListener borderStylePickerListener = this.listener;
        if (borderStylePickerListener != null) {
            borderStylePickerListener.onBorderStylePicked(this, borderStylePreset);
        }
    }
}
