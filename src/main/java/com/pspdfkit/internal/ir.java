package com.pspdfkit.internal;

import androidx.collection.LruCache;
import com.pspdfkit.internal.jni.NativeAnnotation;

/* JADX INFO: loaded from: classes3.dex */
public final class ir implements hr {
    public final LruCache<Long, NativeAnnotation> a = new LruCache<>(20000);

    @Override // com.pspdfkit.internal.hr
    public final NativeAnnotation a(kr krVar) {
        return this.a.get(Long.valueOf(krVar.c));
    }

    @Override // com.pspdfkit.internal.hr
    public final void b(kr krVar) {
        this.a.remove(Long.valueOf(krVar.c));
    }
}
