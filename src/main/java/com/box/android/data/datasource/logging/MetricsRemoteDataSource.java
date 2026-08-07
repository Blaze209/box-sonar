package com.box.android.data.datasource.logging;

import com.box.android.data.api.requests.MetricsLoggingRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: MetricsRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/datasource/logging/MetricsRemoteDataSource;", "", "metricsLoggingRequest", "Lcom/box/android/data/api/requests/MetricsLoggingRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/MetricsLoggingRequest;Lcom/squareup/moshi/Moshi;)V", "getMetricsLoggingRequest", "()Lcom/box/android/data/api/requests/MetricsLoggingRequest;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "sendMetrics", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/errors/RemoteError;", "json", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class MetricsRemoteDataSource {
    private final MetricsLoggingRequest metricsLoggingRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.logging.MetricsRemoteDataSource$sendMetrics$1, reason: invalid class name */
    /* JADX INFO: compiled from: MetricsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.logging.MetricsRemoteDataSource", f = "MetricsRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {24}, m = "sendMetrics", n = {"json", "requestBody", "$i$f$resultOf", "$i$a$-resultOf-MetricsRemoteDataSource$sendMetrics$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetricsRemoteDataSource.this.sendMetrics(null, this);
        }
    }

    @Inject
    public MetricsRemoteDataSource(MetricsLoggingRequest metricsLoggingRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(metricsLoggingRequest, "metricsLoggingRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.metricsLoggingRequest = metricsLoggingRequest;
        this.moshi = moshi;
    }

    public final MetricsLoggingRequest getMetricsLoggingRequest() {
        return this.metricsLoggingRequest;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object sendMetrics(String str, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RequestBody requestBodyCreate$default = RequestBody.Companion.create$default(RequestBody.INSTANCE, "[" + str + "]", (MediaType) null, 1, (Object) null);
                BoxLogUtils.v("Writing metric event: " + str);
                MetricsLoggingRequest metricsLoggingRequest = this.metricsLoggingRequest;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(requestBodyCreate$default);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                if (metricsLoggingRequest.sendGen204Analytics(requestBodyCreate$default, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }
}
