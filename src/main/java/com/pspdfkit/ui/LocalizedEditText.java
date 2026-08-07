package com.pspdfkit.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.pspdfkit.internal.no;

/* JADX INFO: loaded from: classes3.dex */
public class LocalizedEditText extends AppCompatEditText {
    public LocalizedEditText(Context context) {
        super(context);
    }

    private void setLocalizedTextFromAttributes(Context context, AttributeSet attributeSet, int i) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.text, R.attr.hint}, i, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        if (resourceId >= 0) {
            setText(no.a(context, resourceId, this));
        }
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        if (resourceId2 >= 0) {
            setHint(no.a(context, resourceId2, this));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public LocalizedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLocalizedTextFromAttributes(context, attributeSet, 0);
    }

    public LocalizedEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLocalizedTextFromAttributes(context, attributeSet, i);
    }
}
