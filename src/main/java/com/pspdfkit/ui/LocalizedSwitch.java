package com.pspdfkit.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import com.pspdfkit.internal.no;

/* JADX INFO: loaded from: classes3.dex */
public class LocalizedSwitch extends SwitchCompat {
    public LocalizedSwitch(Context context) {
        super(context);
    }

    private void setLocalizedTextFromAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.text}, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        if (resourceId >= 0) {
            setText(no.a(context, resourceId, this));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public LocalizedSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLocalizedTextFromAttributes(context, attributeSet, 0, 0);
    }

    public LocalizedSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLocalizedTextFromAttributes(context, attributeSet, i, 0);
    }
}
