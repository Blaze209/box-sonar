package com.geniusscansdk.scanflow;

import com.box.android.data.api.models.annotations.Location;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ScanActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.geniusscansdk.scanflow.ScanActivity", f = "ScanActivity.kt", i = {0, 0}, l = {196}, m = "onPageScanned$gssdk_release", n = {"this", Location.TYPE_PAGE}, s = {"L$0", "L$1"})
final class ScanActivity$onPageScanned$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScanActivity$onPageScanned$1(ScanActivity scanActivity, Continuation<? super ScanActivity$onPageScanned$1> continuation) {
        super(continuation);
        this.this$0 = scanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onPageScanned$gssdk_release(null, this);
    }
}
