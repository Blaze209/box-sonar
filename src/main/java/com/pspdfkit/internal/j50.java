package com.pspdfkit.internal;

import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.Size;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j50 {
    public transient Size a;
    public transient boolean b;

    public abstract String a();

    public final void a(Size size) {
        float f;
        float f2;
        if (size == null && (size = this.a) == null) {
            return;
        }
        this.a = size;
        h70 h70VarC = c();
        m50 m50VarB = b();
        h70VarC.getClass();
        m50VarB.getClass();
        PageRect pageRect = h70VarC.a;
        float fB = h70VarC.b();
        Float fC = m50VarB.c();
        pageRect.set(0.0f, 0.0f, ip.a(fB, fC != null ? fC.floatValue() : h70VarC.a().b.a), -h70VarC.a().b.b);
        float f3 = m50VarB.b().a + h70VarC.a().a.a;
        Float fC2 = m50VarB.c();
        if (fC2 != null) {
            if (fC2.floatValue() <= h70VarC.a().b.a) {
                fC2 = null;
            }
            if (fC2 != null) {
                float fFloatValue = fC2.floatValue();
                int i = h70.a.a[m50VarB.a().ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        f2 = m50VarB.b().a;
                    } else {
                        f = m50VarB.b().a;
                    }
                    h70VarC.b = f2 - f3;
                } else {
                    f = m50VarB.b().a;
                    fFloatValue /= 2.0f;
                }
                f2 = f - fFloatValue;
                h70VarC.b = f2 - f3;
            }
        }
        h70VarC.a.getPageRect().offset(f3 + h70VarC.b, (size.height - m50VarB.b().b) - h70VarC.a().a.b);
    }

    public abstract m50 b();

    public abstract h70 c();
}
