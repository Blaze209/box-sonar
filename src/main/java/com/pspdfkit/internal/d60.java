package com.pspdfkit.internal;

import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public final class d60 {
    public static final void a(TextView textView, String str) {
        textView.getClass();
        str.getClass();
        if (str.length() > 20) {
            str = str.substring(0, 17) + "...";
        }
        textView.setText(str);
    }
}
