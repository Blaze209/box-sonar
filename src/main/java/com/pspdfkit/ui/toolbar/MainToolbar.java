package com.pspdfkit.ui.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.appcompat.widget.Toolbar;
import com.pspdfkit.R;
import com.pspdfkit.internal.l;
import com.pspdfkit.internal.yo;

/* JADX INFO: loaded from: classes3.dex */
public class MainToolbar extends Toolbar {
    public MainToolbar(Context context) {
        super(wrapThemedContext(context));
        init();
    }

    private void init() {
        yo yoVar = (yo) new l(getContext()).c.getValue();
        setBackgroundColor(yoVar.a);
        setPopupTheme(yoVar.c);
        setTitleTextColor(yoVar.b);
    }

    private static ContextThemeWrapper wrapThemedContext(Context context) {
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__MainToolbar, R.attr.pspdf__mainToolbarStyle, R.style.PSPDFKit_MainToolbar);
        typedArrayObtainStyledAttributes.getClass();
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__MainToolbar_pspdf__toolbarTheme, androidx.appcompat.R.style.ThemeOverlay_AppCompat_Dark_ActionBar);
        typedArrayObtainStyledAttributes.recycle();
        return new ContextThemeWrapper(context, resourceId);
    }

    public MainToolbar(Context context, AttributeSet attributeSet) {
        super(wrapThemedContext(context), attributeSet);
        init();
    }

    public MainToolbar(Context context, AttributeSet attributeSet, int i) {
        super(wrapThemedContext(context), attributeSet, i);
        init();
    }
}
