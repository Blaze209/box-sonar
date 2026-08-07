package com.pspdfkit.internal;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class v40 {
    public int a;
    public ByteBuffer b;

    public final void a(int i, ByteBuffer byteBuffer) {
        this.b = byteBuffer;
        if (byteBuffer != null) {
            this.a = i;
        } else {
            this.a = 0;
        }
    }
}
