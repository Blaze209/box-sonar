package com.geniusscansdk.core;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LicenseKeyRefresher.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/geniusscansdk/core/LicenseKeyApi$Response;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.geniusscansdk.core.LicenseKeyRefresher$refresh$3", f = "LicenseKeyRefresher.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
final class LicenseKeyRefresher$refresh$3 extends SuspendLambda implements Function1<Continuation<? super Result<? extends LicenseKeyApi.Response>>, Object> {
    final /* synthetic */ String $licenseKey;
    final /* synthetic */ LicenseKeyRefresher.LicenseKeyRefreshReason $reason;
    int label;
    final /* synthetic */ LicenseKeyRefresher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LicenseKeyRefresher$refresh$3(LicenseKeyRefresher licenseKeyRefresher, LicenseKeyRefresher.LicenseKeyRefreshReason licenseKeyRefreshReason, String str, Continuation<? super LicenseKeyRefresher$refresh$3> continuation) {
        super(1, continuation);
        this.this$0 = licenseKeyRefresher;
        this.$reason = licenseKeyRefreshReason;
        this.$licenseKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new LicenseKeyRefresher$refresh$3(this.this$0, this.$reason, this.$licenseKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Result<? extends LicenseKeyApi.Response>> continuation) {
        return invoke2((Continuation<? super Result<LicenseKeyApi.Response>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Result<LicenseKeyApi.Response>> continuation) {
        return ((LicenseKeyRefresher$refresh$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM13557getLicenseKey0E7RQCE;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.logger.debug("Refreshing license key (" + this.$reason.getApiValue() + ")");
            this.label = 1;
            objM13557getLicenseKey0E7RQCE = this.this$0.api.m13557getLicenseKey0E7RQCE(this.$licenseKey, this.this$0.buildParams(this.$reason), this);
            if (objM13557getLicenseKey0E7RQCE == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objM13557getLicenseKey0E7RQCE = ((Result) obj).getValue();
        }
        return Result.m14779boximpl(objM13557getLicenseKey0E7RQCE);
    }
}
