package com.pspdfkit.internal;

import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.utils.PageRect;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h70 {
    public final transient PageRect a = new PageRect();
    public float b;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Alignment.values().length];
            try {
                iArr[Alignment.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Alignment.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public abstract ob a();

    public float b() {
        return 0.0f;
    }

    public abstract String c();
}
