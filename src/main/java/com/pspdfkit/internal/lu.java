package com.pspdfkit.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.rendering.PageRendererCoroutines", f = "PageRendererCoroutines.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {334}, m = "executeRender", n = {"options", "logTag", "customRender", "managedBitmap", "cancellationToken", "queueRequestTime", "queueWaitTime", "renderingStartTime"}, nl = {336}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "J$0", "J$1", "J$2"}, v = 2)
public final class lu extends ContinuationImpl {
    public jm a;
    public String b;
    public Object c;
    public zo d;
    public long e;
    public long f;
    public /* synthetic */ Object g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lu(ContinuationImpl continuationImpl) {
        super(continuationImpl);
        ConcurrentHashMap<String, ju.a> concurrentHashMap = ju.a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.h |= Integer.MIN_VALUE;
        ConcurrentHashMap<String, ju.a> concurrentHashMap = ju.a;
        return ju.a(null, null, 0, null, this);
    }
}
