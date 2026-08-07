package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class cq {
    public final int a;
    public final int b;

    public cq(Context context) {
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__MeasurementTool, R.attr.pspdf__measurementToolsStyle, R.style.PSPDFKit_MeasurementTools);
        typedArrayObtainStyledAttributes.getClass();
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__measurementValuePopupBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryDark));
        this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleListItemBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleListItemCheckColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleButtonForegroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleButtonBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
    }
}
