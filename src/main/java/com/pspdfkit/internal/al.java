package com.pspdfkit.internal;

import com.box.androidsdk.content.requests.BoxRequestEvent;
import com.facebook.imageutils.JfifUtil;
import com.pspdfkit.instant.client.InstantProgress;
import com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.instant.client.InstantAnnotationSyncManager", f = "InstantAnnotationSyncManager.kt", i = {0, 1, 2, 2, 2, 2, 3}, l = {208, JfifUtil.MARKER_EOI, 221, 229}, m = "applySyncChanges", n = {"changeApplicator", "changeApplicator", "changeApplicator", BoxRequestEvent.STREAM_TYPE_CHANGES, "it", "$i$a$-let-InstantAnnotationSyncManager$applySyncChanges$2", "changeApplicator"}, nl = {JfifUtil.MARKER_EOI, JfifUtil.MARKER_SOI, 220, 230}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "I$0", "L$0"}, v = 2)
public final class al extends ContinuationImpl {
    public Object a;
    public Object b;
    public Object c;
    public /* synthetic */ Object d;
    public final /* synthetic */ zk e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(zk zkVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = zkVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        zk zkVar = this.e;
        InstantProgress instantProgress = zk.g;
        return zkVar.a((NativeServerChangeApplicator) null, this);
    }
}
