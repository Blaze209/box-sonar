package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.stamps.PredefinedStampType;
import com.pspdfkit.annotations.stamps.StampPickerItem;

/* JADX INFO: loaded from: classes3.dex */
public final class g40 {
    public static final StampPickerItem a(Context context, int i, String str, String str2, StampPickerItem stampPickerItem) {
        context.getClass();
        str.getClass();
        if (stampPickerItem == null) {
            return null;
        }
        return StampPickerItem.fromPredefinedType(context, PredefinedStampType.CUSTOM).withTitle(str).withSubtitle(str2).withSize(stampPickerItem.getDefaultPdfWidth(), stampPickerItem.getDefaultPdfHeight()).withTextColor(Integer.valueOf(i)).build();
    }

    public static final String a(Context context, boolean z, boolean z2) {
        context.getClass();
        if (!z && !z2) {
            return null;
        }
        if (z && !z2) {
            return no.b(context);
        }
        if (!z) {
            return no.d(context);
        }
        return no.c(context);
    }
}
