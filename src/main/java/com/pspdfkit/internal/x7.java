package com.pspdfkit.internal;

import android.graphics.Bitmap;
import java.io.Closeable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class x7 implements Closeable {
    public final Bitmap a;
    public final FunctionReferenceImpl b;
    public boolean c;

    /* JADX WARN: Multi-variable type inference failed */
    public x7(Bitmap bitmap, Function0<Unit> function0) {
        this.a = bitmap;
        this.b = (FunctionReferenceImpl) function0;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.FunctionReferenceImpl] */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.invoke();
    }
}
