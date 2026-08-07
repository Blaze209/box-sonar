package com.pspdfkit.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.LowResProvider", f = "LowResProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {121, 127}, m = "performRendering", n = {"bitmapSize", "pageRenderOptions", "cachedRef", "skipCache", "bitmapSize", "pageRenderOptions", "cachedRef", "skipCache"}, nl = {123, 129}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"}, v = 2)
public final class po extends ContinuationImpl {
    public Object a;
    public Object b;
    public Object c;
    public /* synthetic */ Object d;
    public final /* synthetic */ to e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public po(to toVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = toVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, false, this);
    }
}
