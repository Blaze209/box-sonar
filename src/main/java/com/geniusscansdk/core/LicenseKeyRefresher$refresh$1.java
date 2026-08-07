package com.geniusscansdk.core;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: LicenseKeyRefresher.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.geniusscansdk.core.LicenseKeyRefresher", f = "LicenseKeyRefresher.kt", i = {0}, l = {36}, m = "refresh-0E7RQCE", n = {"this"}, s = {"L$0"})
final class LicenseKeyRefresher$refresh$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LicenseKeyRefresher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LicenseKeyRefresher$refresh$1(LicenseKeyRefresher licenseKeyRefresher, Continuation<? super LicenseKeyRefresher$refresh$1> continuation) {
        super(continuation);
        this.this$0 = licenseKeyRefresher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13558refresh0E7RQCE = this.this$0.m13558refresh0E7RQCE(null, null, this);
        return objM13558refresh0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM13558refresh0E7RQCE : Result.m14779boximpl(objM13558refresh0E7RQCE);
    }
}
