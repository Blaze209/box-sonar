package com.pspdfkit.internal;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class h50 {
    public int a;
    public ByteBuffer b;
    public int c;
    public int d;
    public final l70 e;

    public h50() {
        if (l70.a == null) {
            l70.a = new m70();
        }
        this.e = l70.a;
    }

    public final int a(int i) {
        if (i < this.d) {
            return this.b.getShort(this.c + i);
        }
        return 0;
    }

    public final String b(int i) {
        ByteBuffer byteBuffer = this.b;
        l70 l70Var = this.e;
        int i2 = byteBuffer.getInt(i) + i;
        return l70Var.a(byteBuffer, i2 + 4, byteBuffer.getInt(i2));
    }

    public final int c(int i) {
        int i2 = i + this.a;
        return this.b.getInt(i2) + i2 + 4;
    }

    public final int d(int i) {
        int i2 = i + this.a;
        return this.b.getInt(this.b.getInt(i2) + i2);
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        this.b = byteBuffer;
        if (byteBuffer == null) {
            this.a = 0;
            this.c = 0;
            this.d = 0;
        } else {
            this.a = i;
            int i2 = i - byteBuffer.getInt(i);
            this.c = i2;
            this.d = this.b.getShort(i2);
        }
    }
}
