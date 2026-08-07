package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class xs {
    public final int a;
    public final int b;
    public final int c;

    public xs(Context context) {
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__NoteEditorView, R.attr.pspdf__noteEditorStyle, R.style.PSPDFKit_NoteEditorView);
        typedArrayObtainStyledAttributes.getClass();
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__NoteEditorView_pspdf__noteBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__tertiaryContainerLight));
        this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__NoteEditorView_pspdf__notePrimaryTextColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__NoteEditorView_pspdf__noteSecondaryTextColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__NoteEditorView_pspdf__commentColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        typedArrayObtainStyledAttributes.recycle();
    }
}
