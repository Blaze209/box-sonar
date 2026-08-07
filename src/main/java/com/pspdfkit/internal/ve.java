package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeDocumentProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class ve {
    public final bx a;
    public final bx b;

    public ve(boolean z) {
        int iMax = z ? Math.max((int) NativeDocumentProvider.getDefaultMaximumAlternateDocuments(), 1) : 1;
        synchronized (ar.class) {
            q10.c();
        }
        this.a = new bx("pspdfkit-render", iMax);
        ar.d();
        this.b = new bx("pspdfkit-metadata", 1);
    }

    public final void finalize() throws Throwable {
        this.a.b();
        this.b.b();
        super.finalize();
    }
}
