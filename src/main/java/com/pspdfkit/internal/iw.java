package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.internal.jni.NativePlatformAnnotation;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class iw extends NativePlatformAnnotation {
    public static final AtomicInteger b = new AtomicInteger();
    public final WeakReference<Annotation> a;

    public iw(Annotation annotation) {
        this.a = new WeakReference<>(annotation);
        b.incrementAndGet();
    }

    public final void finalize() throws Throwable {
        super.finalize();
        b.decrementAndGet();
    }

    @Override // com.pspdfkit.internal.jni.NativePlatformAnnotation
    public final void flushProperties() {
    }
}
