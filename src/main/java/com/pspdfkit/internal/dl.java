package com.pspdfkit.internal;

import com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.instant.client.InstantAnnotationSyncManager", f = "InstantAnnotationSyncManager.kt", i = {0, 0}, l = {124}, m = "wantsToApplyChanges", n = {"document", "changeApplicator"}, nl = {130}, s = {"L$0", "L$1"}, v = 2)
public final class dl extends ContinuationImpl {
    public Object a;
    public NativeServerChangeApplicator b;
    public /* synthetic */ Object c;
    public final /* synthetic */ zk d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dl(zk zkVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = zkVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, null, this);
    }
}
