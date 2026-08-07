package com.pspdfkit.internal;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class kc implements InputFilter {
    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        charSequence.getClass();
        spanned.getClass();
        int length = spanned.length();
        if (i4 - i3 == length) {
            return null;
        }
        boolean z = false;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = -1;
                break;
            }
            char cCharAt = spanned.charAt(i5);
            if (cCharAt == ',' || cCharAt == '.') {
                break;
            }
            i5++;
        }
        boolean z2 = i5 < 0 || !(Intrinsics.areEqual(charSequence, ".") || Intrinsics.areEqual(charSequence, ",") || (i4 > i5 && length - i5 > 5));
        if (!z2 || Intrinsics.areEqual(charSequence, ".") || Intrinsics.areEqual(charSequence, ",")) {
            z = z2;
        } else {
            try {
                float f = Float.parseFloat(new StringBuilder().append((Object) spanned.subSequence(0, i3)).append((Object) charSequence).append((Object) spanned.subSequence(i4, spanned.length())).toString());
                if (f <= Float.MAX_VALUE && 1.0E-5f <= f) {
                    z = true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (z) {
            return null;
        }
        return "";
    }
}
