package com.pspdfkit.internal;

import com.pspdfkit.annotations.VerticalTextAlignment;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class g7 {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[VerticalTextAlignment.values().length];
            try {
                iArr[VerticalTextAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerticalTextAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerticalTextAlignment.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final int a(VerticalTextAlignment verticalTextAlignment) {
        verticalTextAlignment.getClass();
        int i = a.a[verticalTextAlignment.ordinal()];
        if (i == 1) {
            return 48;
        }
        if (i == 2) {
            return 16;
        }
        if (i == 3) {
            return 80;
        }
        throw new NoWhenBranchMatchedException();
    }
}
