package com.box.android.domain.metrics;

import com.box.android.domain.models.ForceUpdateReason;
import com.box.android.domain.models.observability.ForceUpdateEvent;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: ForceUpdateObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/metrics/ForceUpdateObservability;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "logForceUpdateTriggered", "", "forceUpdateReason", "Lcom/box/android/domain/models/ForceUpdateReason;", "logInAppUpdateStarted", "logInAppUpdateResumed", "logFallbackUpdateNotAvailable", "logFallbackUpdateCheckFailed", "logGooglePlayWebFallback", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForceUpdateObservability {
    private final CoroutineDispatcher coroutineDispatcher;
    private final CoroutineScope coroutineScope;
    private final MetricsUseCase metricsUseCase;

    @Inject
    public ForceUpdateObservability(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.metricsUseCase = metricsUseCase;
        this.coroutineDispatcher = coroutineDispatcher;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(coroutineDispatcher));
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.ForceUpdateObservability$logForceUpdateTriggered$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ForceUpdateObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.ForceUpdateObservability$logForceUpdateTriggered$1", f = "ForceUpdateObservability.kt", i = {0, 0, 0}, l = {34}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-ForceUpdateObservability$logForceUpdateTriggered$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C15821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ForceUpdateReason $forceUpdateReason;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15821(ForceUpdateReason forceUpdateReason, Continuation<? super C15821> continuation) {
            super(2, continuation);
            this.$forceUpdateReason = forceUpdateReason;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15821 c15821 = ForceUpdateObservability.this.new C15821(this.$forceUpdateReason, continuation);
            c15821.L$0 = obj;
            return c15821;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ForceUpdateObservability forceUpdateObservability = ForceUpdateObservability.this;
                    ForceUpdateReason forceUpdateReason = this.$forceUpdateReason;
                    Result.Companion companion = Result.INSTANCE;
                    MetricsUseCase metricsUseCase = forceUpdateObservability.metricsUseCase;
                    ForceUpdateEvent forceUpdateEvent = new ForceUpdateEvent(ForceUpdateEvent.EventSubType.Triggered, forceUpdateReason, null, null, 12, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.I$0 = 0;
                    this.label = 1;
                    obj = metricsUseCase.log(forceUpdateEvent, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Result.m14780constructorimpl((com.box.android.domain.utils.result.Result) obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }

    public final void logForceUpdateTriggered(ForceUpdateReason forceUpdateReason) {
        Intrinsics.checkNotNullParameter(forceUpdateReason, "forceUpdateReason");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C15821(forceUpdateReason, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.ForceUpdateObservability$logInAppUpdateStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ForceUpdateObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.ForceUpdateObservability$logInAppUpdateStarted$1", f = "ForceUpdateObservability.kt", i = {0, 0, 0}, l = {50}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-ForceUpdateObservability$logInAppUpdateStarted$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C15851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C15851(Continuation<? super C15851> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15851 c15851 = ForceUpdateObservability.this.new C15851(continuation);
            c15851.L$0 = obj;
            return c15851;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ForceUpdateObservability forceUpdateObservability = ForceUpdateObservability.this;
                    Result.Companion companion = Result.INSTANCE;
                    MetricsUseCase metricsUseCase = forceUpdateObservability.metricsUseCase;
                    ForceUpdateEvent forceUpdateEvent = new ForceUpdateEvent(ForceUpdateEvent.EventSubType.InAppUpdateStarted, null, null, null, 14, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.I$0 = 0;
                    this.label = 1;
                    obj = metricsUseCase.log(forceUpdateEvent, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Result.m14780constructorimpl((com.box.android.domain.utils.result.Result) obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }

    public final void logInAppUpdateStarted() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C15851(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.ForceUpdateObservability$logInAppUpdateResumed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ForceUpdateObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.ForceUpdateObservability$logInAppUpdateResumed$1", f = "ForceUpdateObservability.kt", i = {0, 0, 0}, l = {65}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-ForceUpdateObservability$logInAppUpdateResumed$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C15841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C15841(Continuation<? super C15841> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15841 c15841 = ForceUpdateObservability.this.new C15841(continuation);
            c15841.L$0 = obj;
            return c15841;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ForceUpdateObservability forceUpdateObservability = ForceUpdateObservability.this;
                    Result.Companion companion = Result.INSTANCE;
                    MetricsUseCase metricsUseCase = forceUpdateObservability.metricsUseCase;
                    ForceUpdateEvent forceUpdateEvent = new ForceUpdateEvent(ForceUpdateEvent.EventSubType.InAppUpdateResumed, null, null, null, 14, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.I$0 = 0;
                    this.label = 1;
                    obj = metricsUseCase.log(forceUpdateEvent, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Result.m14780constructorimpl((com.box.android.domain.utils.result.Result) obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }

    public final void logInAppUpdateResumed() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C15841(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.ForceUpdateObservability$logFallbackUpdateNotAvailable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ForceUpdateObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.ForceUpdateObservability$logFallbackUpdateNotAvailable$1", f = "ForceUpdateObservability.kt", i = {0, 0, 0}, l = {80}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-ForceUpdateObservability$logFallbackUpdateNotAvailable$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C15811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C15811(Continuation<? super C15811> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15811 c15811 = ForceUpdateObservability.this.new C15811(continuation);
            c15811.L$0 = obj;
            return c15811;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ForceUpdateObservability forceUpdateObservability = ForceUpdateObservability.this;
                    Result.Companion companion = Result.INSTANCE;
                    MetricsUseCase metricsUseCase = forceUpdateObservability.metricsUseCase;
                    ForceUpdateEvent forceUpdateEvent = new ForceUpdateEvent(ForceUpdateEvent.EventSubType.FallbackUpdateNotAvailable, null, null, null, 14, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.I$0 = 0;
                    this.label = 1;
                    obj = metricsUseCase.log(forceUpdateEvent, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Result.m14780constructorimpl((com.box.android.domain.utils.result.Result) obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }

    public final void logFallbackUpdateNotAvailable() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C15811(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.ForceUpdateObservability$logFallbackUpdateCheckFailed$1, reason: invalid class name */
    /* JADX INFO: compiled from: ForceUpdateObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.ForceUpdateObservability$logFallbackUpdateCheckFailed$1", f = "ForceUpdateObservability.kt", i = {0, 0, 0}, l = {95}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-ForceUpdateObservability$logFallbackUpdateCheckFailed$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ForceUpdateObservability.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ForceUpdateObservability forceUpdateObservability = ForceUpdateObservability.this;
                    Result.Companion companion = Result.INSTANCE;
                    MetricsUseCase metricsUseCase = forceUpdateObservability.metricsUseCase;
                    ForceUpdateEvent forceUpdateEvent = new ForceUpdateEvent(ForceUpdateEvent.EventSubType.FallbackUpdateCheckFailed, null, null, null, 14, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.I$0 = 0;
                    this.label = 1;
                    obj = metricsUseCase.log(forceUpdateEvent, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Result.m14780constructorimpl((com.box.android.domain.utils.result.Result) obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }

    public final void logFallbackUpdateCheckFailed() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.ForceUpdateObservability$logGooglePlayWebFallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ForceUpdateObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.ForceUpdateObservability$logGooglePlayWebFallback$1", f = "ForceUpdateObservability.kt", i = {0, 0, 0}, l = {110}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-ForceUpdateObservability$logGooglePlayWebFallback$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C15831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C15831(Continuation<? super C15831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15831 c15831 = ForceUpdateObservability.this.new C15831(continuation);
            c15831.L$0 = obj;
            return c15831;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ForceUpdateObservability forceUpdateObservability = ForceUpdateObservability.this;
                    Result.Companion companion = Result.INSTANCE;
                    MetricsUseCase metricsUseCase = forceUpdateObservability.metricsUseCase;
                    ForceUpdateEvent forceUpdateEvent = new ForceUpdateEvent(ForceUpdateEvent.EventSubType.GooglePlayWebFallback, null, null, null, 14, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.I$0 = 0;
                    this.label = 1;
                    obj = metricsUseCase.log(forceUpdateEvent, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Result.m14780constructorimpl((com.box.android.domain.utils.result.Result) obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }

    public final void logGooglePlayWebFallback() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C15831(null), 3, null);
    }
}
