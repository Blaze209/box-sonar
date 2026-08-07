package com.pspdfkit.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class xz implements zt {
    public final int a;
    public final boolean b;

    public xz(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // com.pspdfkit.internal.zt
    public final int a(int i) {
        return c(i);
    }

    @Override // com.pspdfkit.internal.zt
    public final int b(int i) {
        return c(i);
    }

    public final int c(int i) {
        if (i == 0 && this.b) {
            return 0;
        }
        int i2 = this.a;
        int i3 = i2 % 2;
        boolean z = this.b;
        if (i3 == 0) {
            if (!z) {
                return i % 2 == 1 ? i - 1 : i + 1;
            }
            if (i != i2 - 1) {
                return i % 2 == 0 ? i - 1 : i + 1;
            }
        } else {
            if (z) {
                return i % 2 == 0 ? i - 1 : i + 1;
            }
            if (i != i2 - 1) {
                return i % 2 == 1 ? i - 1 : i + 1;
            }
        }
        return i;
    }
}
