package com.box.android.clientadmin.integrity;

import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityServiceException;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: IntegrityAPICaller.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ6\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0013J*\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/box/android/clientadmin/integrity/IntegrityAPICaller;", "", "<init>", "()V", "nonceCalculator", "Lcom/box/android/clientadmin/integrity/PlayIntegrityNonceCalculator;", "getIntegrityApiToken", "Lcom/box/android/domain/utils/result/Result;", "", "uniqueValue", "timeoutMillis", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Ljava/lang/String;JLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestIntegrityTokenWithRetires", "", "maxRetries", "", "(Ljava/lang/String;ILkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestIntegrityToken", "manager", "Lcom/google/android/play/core/integrity/IntegrityManager;", "nonce", "(Lcom/google/android/play/core/integrity/IntegrityManager;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldRetry", "", "throwable", "trackIntegrityAPISuccess", "", "trackIntegrityAPIError", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IntegrityAPICaller {
    public static final int $stable = 0;
    private static final int DEFAULT_RETIRES = 2;
    private static final long TIMEOUT_INCREMENT_MS = 5000;
    private final PlayIntegrityNonceCalculator nonceCalculator = new PlayIntegrityNonceCalculator();
    private static final String TAG = "IntegrityAPICaller";

    /* JADX INFO: renamed from: com.box.android.clientadmin.integrity.IntegrityAPICaller$getIntegrityApiToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: IntegrityAPICaller.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.clientadmin.integrity.IntegrityAPICaller", f = "IntegrityAPICaller.kt", i = {0, 0, 0}, l = {44}, m = "getIntegrityApiToken", n = {"uniqueValue", "dispatcher", "timeoutMillis"}, s = {"L$0", "L$1", "J$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
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
            return IntegrityAPICaller.this.getIntegrityApiToken(null, 0L, null, this);
        }
    }

    @Inject
    public IntegrityAPICaller() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getIntegrityApiToken(String str, long j, CoroutineDispatcher coroutineDispatcher, Continuation<? super Result<String, String>> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object objWithTimeout = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWithTimeout);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, coroutineDispatcher, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(coroutineDispatcher);
                anonymousClass1.J$0 = j;
                anonymousClass1.label = 1;
                objWithTimeout = TimeoutKt.withTimeout(j, anonymousClass2, anonymousClass1);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j2 = anonymousClass1.J$0;
                ResultKt.throwOnFailure(objWithTimeout);
            }
            return (Result) objWithTimeout;
        } catch (Throwable th) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            BoxLogUtils.e(TAG2, "Unexpected exception", th);
            trackIntegrityAPIError(th);
            String simpleName = Reflection.getOrCreateKotlinClass(th.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "Unknown exception";
            }
            return new Result.Error(simpleName);
        }
    }

    public static /* synthetic */ Object getIntegrityApiToken$default(IntegrityAPICaller integrityAPICaller, String str, long j, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        return integrityAPICaller.getIntegrityApiToken(str, j, coroutineDispatcher, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.clientadmin.integrity.IntegrityAPICaller$getIntegrityApiToken$2, reason: invalid class name */
    /* JADX INFO: compiled from: IntegrityAPICaller.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.clientadmin.integrity.IntegrityAPICaller$getIntegrityApiToken$2", f = "IntegrityAPICaller.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends String, ? extends String>>, Object> {
        final /* synthetic */ CoroutineDispatcher $dispatcher;
        final /* synthetic */ String $uniqueValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, CoroutineDispatcher coroutineDispatcher, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$uniqueValue = str;
            this.$dispatcher = coroutineDispatcher;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IntegrityAPICaller.this.new AnonymousClass2(this.$uniqueValue, this.$dispatcher, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends String, ? extends String>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<String, String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<String, String>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = IntegrityAPICaller.requestIntegrityTokenWithRetires$default(IntegrityAPICaller.this, this.$uniqueValue, 0, this.$dispatcher, this, 2, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            IntegrityAPICaller integrityAPICaller = IntegrityAPICaller.this;
            boolean z = result instanceof Result.Success;
            if (z) {
                integrityAPICaller.trackIntegrityAPISuccess();
            } else if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            IntegrityAPICaller integrityAPICaller2 = IntegrityAPICaller.this;
            if (z) {
                return result;
            }
            if (result instanceof Result.Error) {
                Throwable th = (Throwable) ((Result.Error) result).getValue();
                String str = IntegrityAPICaller.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                BoxLogUtils.e(str, "Failed to fetch integrity token", th);
                integrityAPICaller2.trackIntegrityAPIError(th);
                return new Result.Error(String.valueOf(th));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    static /* synthetic */ Object requestIntegrityTokenWithRetires$default(IntegrityAPICaller integrityAPICaller, String str, int i, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        if ((i2 & 4) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        return integrityAPICaller.requestIntegrityTokenWithRetires(str, i, coroutineDispatcher, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestIntegrityTokenWithRetires(String str, int i, CoroutineDispatcher coroutineDispatcher, Continuation<? super Result<String, ? extends Throwable>> continuation) {
        String strCalculate = this.nonceCalculator.calculate(str);
        IntegrityManager integrityManagerCreate = IntegrityManagerFactory.create(ApplicationProvider.getApplication());
        Intrinsics.checkNotNullExpressionValue(integrityManagerCreate, "create(...)");
        return FlowKt.first(FlowKt.flowOn(FlowKt.m16356catch(FlowKt.retryWhen(FlowKt.flow(new C10022(integrityManagerCreate, strCalculate, null)), new AnonymousClass3(i, this, null)), new AnonymousClass4(null)), coroutineDispatcher), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.clientadmin.integrity.IntegrityAPICaller$requestIntegrityTokenWithRetires$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IntegrityAPICaller.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.clientadmin.integrity.IntegrityAPICaller$requestIntegrityTokenWithRetires$2", f = "IntegrityAPICaller.kt", i = {0, 1, 1, 1, 1, 1}, l = {71, 72}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "token", "$i$f$onSuccess", "$i$a$-onSuccess-IntegrityAPICaller$requestIntegrityTokenWithRetires$2$1"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C10022 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends String, ? extends Throwable>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ IntegrityManager $manager;
        final /* synthetic */ String $nonce;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10022(IntegrityManager integrityManager, String str, Continuation<? super C10022> continuation) {
            super(2, continuation);
            this.$manager = integrityManager;
            this.$nonce = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10022 c10022 = IntegrityAPICaller.this.new C10022(this.$manager, this.$nonce, continuation);
            c10022.L$0 = obj;
            return c10022;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends String, ? extends Throwable>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<String, ? extends Throwable>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<String, ? extends Throwable>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C10022) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x007c  */
        /* JADX WARN: Code duplicated, block: B:26:0x0080  */
        /* JADX WARN: Code duplicated, block: B:28:0x0089  */
        /* JADX WARN: Code duplicated, block: B:30:0x008f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Result result;
            Result result2;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = IntegrityAPICaller.this.requestIntegrityToken(this.$manager, this.$nonce, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                result2 = (Result) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            result = result2;
            if (!(result instanceof Result.Success)) {
                return Unit.INSTANCE;
            }
            if (result instanceof Result.Error) {
                throw ((Throwable) ((Result.Error) result).getValue());
            }
            throw new NoWhenBranchMatchedException();
            result = (Result) obj;
            if (result instanceof Result.Success) {
                String str = (String) ((Result.Success) result).getValue();
                Result.Success success = new Result.Success(str);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = result;
                this.L$2 = SpillingKt.nullOutSpilledVariable(str);
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 2;
                if (flowCollector.emit(success, this) != coroutine_suspended) {
                    result2 = result;
                    result = result2;
                }
                return coroutine_suspended;
            }
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(result instanceof Result.Success)) {
                return Unit.INSTANCE;
            }
            if (result instanceof Result.Error) {
                throw ((Throwable) ((Result.Error) result).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.box.android.clientadmin.integrity.IntegrityAPICaller$requestIntegrityTokenWithRetires$3, reason: invalid class name */
    /* JADX INFO: compiled from: IntegrityAPICaller.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "", "throwable", "attempt", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.clientadmin.integrity.IntegrityAPICaller$requestIntegrityTokenWithRetires$3", f = "IntegrityAPICaller.kt", i = {0, 0}, l = {76}, m = "invokeSuspend", n = {"throwable", "attempt"}, s = {"L$0", "J$0"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function4<FlowCollector<? super Result<? extends String, ? extends Throwable>>, Throwable, Long, Continuation<? super Boolean>, Object> {
        final /* synthetic */ int $maxRetries;
        /* synthetic */ long J$0;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ IntegrityAPICaller this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(int i, IntegrityAPICaller integrityAPICaller, Continuation<? super AnonymousClass3> continuation) {
            super(4, continuation);
            this.$maxRetries = i;
            this.this$0 = integrityAPICaller;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends String, ? extends Throwable>> flowCollector, Throwable th, Long l, Continuation<? super Boolean> continuation) {
            return invoke((FlowCollector<? super Result<String, ? extends Throwable>>) flowCollector, th, l.longValue(), continuation);
        }

        public final Object invoke(FlowCollector<? super Result<String, ? extends Throwable>> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$maxRetries, this.this$0, continuation);
            anonymousClass3.L$0 = th;
            anonymousClass3.J$0 = j;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th = (Throwable) this.L$0;
            long j = this.J$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (j >= this.$maxRetries || !this.this$0.shouldRetry(th)) {
                    z = false;
                } else {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(th);
                    this.J$0 = j;
                    this.label = 1;
                    if (DelayKt.delay((1 + j) * 5000, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: renamed from: com.box.android.clientadmin.integrity.IntegrityAPICaller$requestIntegrityTokenWithRetires$4, reason: invalid class name */
    /* JADX INFO: compiled from: IntegrityAPICaller.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "", "it"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.clientadmin.integrity.IntegrityAPICaller$requestIntegrityTokenWithRetires$4", f = "IntegrityAPICaller.kt", i = {0, 0}, l = {82}, m = "invokeSuspend", n = {"$this$catch", "it"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends String, ? extends Throwable>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends String, ? extends Throwable>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<String, ? extends Throwable>>) flowCollector, th, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<String, ? extends Throwable>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.L$0 = flowCollector;
            anonymousClass4.L$1 = th;
            return anonymousClass4.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(th);
                this.label = 1;
                if (flowCollector.emit(new Result.Error(th), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestIntegrityToken(IntegrityManager integrityManager, String str, Continuation<? super Result<String, ? extends Throwable>> continuation) {
        Task<IntegrityTokenResponse> taskRequestIntegrityToken = integrityManager.requestIntegrityToken(IntegrityTokenRequest.builder().setNonce(str).build());
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        final Function1<IntegrityTokenResponse, Unit> function1 = new Function1<IntegrityTokenResponse, Unit>() { // from class: com.box.android.clientadmin.integrity.IntegrityAPICaller$requestIntegrityToken$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntegrityTokenResponse integrityTokenResponse) {
                invoke2(integrityTokenResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IntegrityTokenResponse integrityTokenResponse) {
                String str2 = IntegrityAPICaller.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                BoxLogUtils.i(str2, "IntegrityAPI call success");
                Continuation<Result<String, ? extends Throwable>> continuation2 = safeContinuation2;
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                continuation2.resumeWith(kotlin.Result.m14780constructorimpl(new Result.Success(integrityTokenResponse.token())));
            }
        };
        taskRequestIntegrityToken.addOnSuccessListener(new OnSuccessListener(function1) { // from class: com.box.android.clientadmin.integrity.IntegrityAPICaller$sam$com_google_android_gms_tasks_OnSuccessListener$0
            private final /* synthetic */ Function1 function;

            {
                Intrinsics.checkNotNullParameter(function1, "function");
                this.function = function1;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                this.function.invoke(obj);
            }
        });
        taskRequestIntegrityToken.addOnFailureListener(new OnFailureListener() { // from class: com.box.android.clientadmin.integrity.IntegrityAPICaller$requestIntegrityToken$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String str2 = IntegrityAPICaller.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                BoxLogUtils.e(str2, "IntegrityAPI call error " + it);
                Continuation<Result<String, ? extends Throwable>> continuation2 = safeContinuation2;
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                continuation2.resumeWith(kotlin.Result.m14780constructorimpl(new Result.Error(it)));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldRetry(Throwable throwable) {
        IntegrityServiceException integrityServiceException = throwable instanceof IntegrityServiceException ? (IntegrityServiceException) throwable : null;
        Integer numValueOf = integrityServiceException != null ? Integer.valueOf(integrityServiceException.getErrorCode()) : null;
        if (numValueOf != null && numValueOf.intValue() == -8) {
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == -12) {
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == -17) {
            return true;
        }
        return numValueOf != null && numValueOf.intValue() == -100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackIntegrityAPISuccess() {
        BoxAnalytics.trackEvent$default(BoxAnalytics.INSTANCE, "observability", BoxAnalyticsParams.ACTION_INTEGRITY_API, "Success", null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackIntegrityAPIError(Throwable throwable) {
        String simpleName;
        if (throwable instanceof IntegrityServiceException) {
            simpleName = "API error code: " + ((IntegrityServiceException) throwable).getErrorCode();
        } else {
            simpleName = Reflection.getOrCreateKotlinClass(throwable.getClass()).getSimpleName();
        }
        BoxAnalytics.trackEvent$default(BoxAnalytics.INSTANCE, "observability", BoxAnalyticsParams.ACTION_INTEGRITY_API, simpleName, null, 8, null);
    }
}
