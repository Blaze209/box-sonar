package com.box.android.data.api.interceptors;

import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.IOException;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: RetryRequestInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/api/interceptors/RetryRequestInterceptor;", "Lokhttp3/Interceptor;", "maxRetries", "", "defaultWaitTimeInSeconds", "<init>", "(II)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "retryRequest", "request", "Lokhttp3/Request;", "getRetryAfterFromResponse", "", "response", "defaultSeconds", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RetryRequestInterceptor implements Interceptor {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String RETRY_HEADER = "Retry-After";
    private final int defaultWaitTimeInSeconds;
    private final int maxRetries;

    /* JADX WARN: Illegal instructions before constructor call */
    public RetryRequestInterceptor() {
        int i = 0;
        this(i, i, 3, null);
    }

    public RetryRequestInterceptor(int i, int i2) {
        this.maxRetries = i;
        this.defaultWaitTimeInSeconds = i2;
        if (i < 0) {
            throw new IllegalArgumentException("Number of retries must be a positive integer".toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Wait time in seconds must be a positive integer".toString());
        }
    }

    public /* synthetic */ RetryRequestInterceptor(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 2 : i, (i3 & 2) != 0 ? 1 : i2);
    }

    /* JADX INFO: compiled from: RetryRequestInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/api/interceptors/RetryRequestInterceptor$Companion;", "", "<init>", "()V", "RETRY_HEADER", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.api.interceptors.RetryRequestInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: RetryRequestInterceptor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lokhttp3/Response;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.interceptors.RetryRequestInterceptor$intercept$1", f = "RetryRequestInterceptor.kt", i = {0, 0, 0, 0, 0}, l = {45}, m = "invokeSuspend", n = {"$this$runBlocking", "response", "originalRequest", "retryAttempts", "waitTimeInMillis"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response>, Object> {
        final /* synthetic */ Interceptor.Chain $chain;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Interceptor.Chain chain, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$chain = chain;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = RetryRequestInterceptor.this.new AnonymousClass1(this.$chain, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0089 -> B:17:0x008c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Response responseProceed;
            Request request;
            int i;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                int i3 = RetryRequestInterceptor.this.maxRetries;
                Request request2 = this.$chain.request();
                responseProceed = this.$chain.proceed(request2);
                request = request2;
                i = i3;
                Intrinsics.checkNotNull(responseProceed);
                if (responseProceed.isSuccessful() && responseProceed.code() == 429 && i > 0) {
                    RetryRequestInterceptor retryRequestInterceptor = RetryRequestInterceptor.this;
                    long retryAfterFromResponse = retryRequestInterceptor.getRetryAfterFromResponse(responseProceed, retryRequestInterceptor.defaultWaitTimeInSeconds);
                    BoxLogUtils.d(ExtensionsKt.getTAG(coroutineScope), "Received 429, retrying after waiting " + retryAfterFromResponse + " milliseconds");
                    this.L$0 = coroutineScope;
                    this.L$1 = responseProceed;
                    this.L$2 = request;
                    this.I$0 = i;
                    this.J$0 = retryAfterFromResponse;
                    this.label = 1;
                    if (DelayKt.delay(retryAfterFromResponse, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!responseProceed.isSuccessful() && i == 0) {
                        BoxLogUtils.w(ExtensionsKt.getTAG(coroutineScope), "Exhausted Retry attempts, returning error response");
                    }
                    return responseProceed;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                request = (Request) this.L$2;
                responseProceed = (Response) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            responseProceed.close();
            BoxLogUtils.v(ExtensionsKt.getTAG(coroutineScope), "Retrying request, Attempt No.: " + ((RetryRequestInterceptor.this.maxRetries - i) + 1));
            responseProceed = RetryRequestInterceptor.this.retryRequest(this.$chain, request);
            i--;
            Intrinsics.checkNotNull(responseProceed);
            if (responseProceed.isSuccessful()) {
            }
            if (!responseProceed.isSuccessful()) {
                BoxLogUtils.w(ExtensionsKt.getTAG(coroutineScope), "Exhausted Retry attempts, returning error response");
            }
            return responseProceed;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return (Response) BuildersKt.runBlocking(Dispatchers.getIO(), new AnonymousClass1(chain, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Response retryRequest(Interceptor.Chain chain, Request request) {
        return chain.proceed(request.newBuilder().build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getRetryAfterFromResponse(Response response, int defaultSeconds) {
        String strHeader = response.header("Retry-After", String.valueOf(defaultSeconds));
        Intrinsics.checkNotNull(strHeader);
        return ((long) Integer.parseInt(strHeader)) * 1000;
    }
}
