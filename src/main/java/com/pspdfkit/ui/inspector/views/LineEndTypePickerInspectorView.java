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
public class LineEndTypePickerInspectorView extends e7<LineEndType> {
    LineEndTypePickerListener listener;

    public interface LineEndTypePickerListener {
        void onLineEndTypePicked(LineEndTypePickerInspectorView lineEndTypePickerInspectorView, LineEndType lineEndType);
    }

    public LineEndTypePickerInspectorView(Context context, String str, List<LineEndType> list, LineEndType lineEndType, boolean z, LineEndTypePickerListener lineEndTypePickerListener) {
        super(context, str, getPickerItems(context, list, z), lineEndType);
        this.listener = lineEndTypePickerListener;
    }

    private static List<e7.a<LineEndType>> getPickerItems(Context context, List<LineEndType> list, boolean z) {
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
        int iA2 = (int) un.a(context, 1, 2);
        for (LineEndType lineEndType : list) {
            Context context2 = context;
            arrayList.add(new e7.a(new vn(context2, iA, iA2, BorderStylePreset.SOLID, z ? lineEndType : LineEndType.NONE, !z ? lineEndType : LineEndType.NONE), lineEndType));
            context = context2;
        }
        return arrayList;
    }

    @Override // com.pspdfkit.internal.e7
    public void onItemPicked(LineEndType lineEndType) {
        LineEndTypePickerListener lineEndTypePickerListener = this.listener;
        if (lineEndTypePickerListener != null) {
            lineEndTypePickerListener.onLineEndTypePicked(this, lineEndType);
        }
    }
}
