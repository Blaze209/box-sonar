package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationManager;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class kr implements jr {
    public final hr a;
    public final NativeAnnotationManager b;
    public final long c;
    public final long d;
    public final long e;
    public WeakReference<NativeAnnotation> f;

    public kr(ir irVar, NativeAnnotationManager nativeAnnotationManager, NativeAnnotation nativeAnnotation) {
        irVar.getClass();
        nativeAnnotationManager.getClass();
        nativeAnnotation.getClass();
        this.a = irVar;
        this.b = nativeAnnotationManager;
        this.c = nativeAnnotation.getIdentifier();
        Long annotationId = nativeAnnotation.getAnnotationId();
        if (annotationId == null) {
            throw new IllegalStateException("Can't create native annotation holder: nativeAnnotation.getAnnotationId() returned null.");
        }
        this.d = annotationId.longValue();
        Integer absolutePageIndex = nativeAnnotation.getAbsolutePageIndex();
        if (absolutePageIndex == null) {
            throw new IllegalStateException("Can't create native annotation holder: nativeAnnotation.absolutePageIndex() returned null.");
        }
        this.e = absolutePageIndex.intValue();
        this.f = new WeakReference<>(nativeAnnotation);
    }

    @Override // com.pspdfkit.internal.jr
    public final NativeAnnotation getNativeAnnotation() {
        NativeAnnotation nativeAnnotationA = this.f.get();
        if (nativeAnnotationA == null) {
            nativeAnnotationA = this.a.a(this);
            if (nativeAnnotationA == null && (nativeAnnotationA = this.b.getAnnotation(this.d, this.e)) == null) {
                throw new IllegalStateException("The NativeAnnotationHolder failed to retrieve a native annotation. It seems the NativeAnnotation was detached without updating the NativeAnnotationCache.");
            }
            this.f = new WeakReference<>(nativeAnnotationA);
        }
        return nativeAnnotationA;
    }

    @Override // com.pspdfkit.internal.jr
    public final void release() {
        this.a.b(this);
    }
}
