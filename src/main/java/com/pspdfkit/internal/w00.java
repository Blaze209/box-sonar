package com.pspdfkit.internal;

import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.internal.jni.NativeContentEditingResult;
import com.pspdfkit.utils.Size;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class w00 extends kn {
    public final Alignment g;

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
            try {
                iArr[Alignment.JUSTIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Alignment.BEGIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w00(i50 i50Var, Size size, Alignment alignment) {
        super(i50Var, size, null, null, i50.a(i50Var, null, alignment, null, 5));
        i50Var.getClass();
        alignment.getClass();
        this.g = alignment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pspdfkit.internal.ha, com.pspdfkit.internal.ga
    public final void a(g70 g70Var, NativeContentEditingResult nativeContentEditingResult) {
        float fWidth;
        float fWidth2;
        float fWidth3;
        float fWidth4;
        g70Var.getClass();
        nativeContentEditingResult.getClass();
        l50 l50Var = this.a.d;
        float f = l50Var.a.a;
        Alignment alignment = l50Var.b;
        int[] iArr = a.a;
        int i = iArr[alignment.ordinal()];
        if (i == 1) {
            int i2 = iArr[this.g.ordinal()];
            if (i2 == 2) {
                fWidth = this.a.e.a.getPageRect().width();
                fWidth4 = fWidth / 2;
                f += fWidth4;
            } else if (i2 == 3 || i2 == 4) {
                fWidth2 = this.a.e.a.getPageRect().width();
                fWidth3 = fWidth2 / 2;
                f -= fWidth3;
            }
        } else if (i == 2) {
            int i3 = iArr[this.g.ordinal()];
            if (i3 == 1) {
                fWidth2 = this.a.e.a.getPageRect().width();
                fWidth3 = fWidth2 / 2;
                f -= fWidth3;
            } else if (i3 == 3 || i3 == 4) {
                fWidth3 = this.a.e.a.getPageRect().width();
                f -= fWidth3;
            }
        } else {
            if (i != 3 && i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            int i4 = iArr[this.g.ordinal()];
            if (i4 == 1) {
                fWidth = this.a.e.a.getPageRect().width();
                fWidth4 = fWidth / 2;
                f += fWidth4;
            } else if (i4 == 2) {
                fWidth4 = this.a.e.a.getPageRect().width();
                f += fWidth4;
            }
        }
        l50 l50Var2 = this.a.d;
        if (f != l50Var2.a.a) {
            l50Var2.a = new t70(f, this.a.d.a.b);
        }
        l50 l50Var3 = this.a.d;
        Alignment alignment2 = this.g;
        l50Var3.getClass();
        alignment2.getClass();
        l50Var3.b = alignment2;
        super.a(g70Var, nativeContentEditingResult);
    }
}
