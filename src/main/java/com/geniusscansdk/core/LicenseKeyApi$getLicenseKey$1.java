package com.geniusscansdk.core;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: LicenseKeyApi.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.geniusscansdk.core.LicenseKeyApi", f = "LicenseKeyApi.kt", i = {}, l = {37}, m = "getLicenseKey-0E7RQCE", n = {}, s = {})
final class LicenseKeyApi$getLicenseKey$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LicenseKeyApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LicenseKeyApi$getLicenseKey$1(LicenseKeyApi licenseKeyApi, Continuation<? super LicenseKeyApi$getLicenseKey$1> continuation) {
        super(continuation);
        this.this$0 = licenseKeyApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13557getLicenseKey0E7RQCE = this.this$0.m13557getLicenseKey0E7RQCE(null, null, this);
        return objM13557getLicenseKey0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM13557getLicenseKey0E7RQCE : Result.m14779boximpl(objM13557getLicenseKey0E7RQCE);
    }
}
