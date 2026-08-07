package com.box.android.domain.metrics.msal;

import com.box.android.domain.models.observability.DeviceMetric;
import com.box.android.domain.models.observability.Gen204ActionCompletionStatus;
import com.box.android.domain.models.observability.MsalEvent;
import com.box.android.domain.models.observability.UserMetric;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: MsalObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J;\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0011J/\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u0017\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J#\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0019J/\u0010\u001a\u001a\u00020\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\tJ#\u0010 \u001a\u00020\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/box/android/domain/metrics/msal/MsalObservability;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "logMsalLoginEvent", "", "completionStatus", "Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;", "failReason", "", "errorCode", "", "subtype", "(Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "logMsalRemediateEvent", "(Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;Ljava/lang/String;Ljava/lang/Integer;)V", "logMsalLoginStarted", "enrollmentMethod", "Lcom/box/android/domain/metrics/msal/EnrollmentMethod;", "logMsalLoginSucceeded", "logMsalLoginCanceled", "(Ljava/lang/Integer;Lcom/box/android/domain/metrics/msal/EnrollmentMethod;)V", "logMsalLoginFailed", "message", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/box/android/domain/metrics/msal/EnrollmentMethod;)V", "logMsalUpnMismatch", "logMsalRemediateStarted", "logMsalRemediateSucceeded", "logMsalRemediateFailed", "(Ljava/lang/String;Ljava/lang/Integer;)V", "logMsalPolicyBlocked", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "Lcom/box/android/domain/metrics/msal/PolicyBlockedReason;", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MsalObservability {
    private static final String UPN_MISMATCH_REASON = "upn mismatch";
    private static final String USER_CANCELED_REASON = "user canceled";
    private final CoroutineDispatcher ioDispatcher;
    private final MetricsUseCase metricsUseCase;

    @Inject
    public MsalObservability(MetricsUseCase metricsUseCase, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.metricsUseCase = metricsUseCase;
        this.ioDispatcher = ioDispatcher;
    }

    public static /* synthetic */ void logMsalLoginEvent$default(MsalObservability msalObservability, Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            gen204ActionCompletionStatus = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        msalObservability.logMsalLoginEvent(gen204ActionCompletionStatus, str, num, str2);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.msal.MsalObservability$logMsalLoginEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: MsalObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.msal.MsalObservability$logMsalLoginEvent$1", f = "MsalObservability.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Gen204ActionCompletionStatus $completionStatus;
        final /* synthetic */ Integer $errorCode;
        final /* synthetic */ String $failReason;
        final /* synthetic */ String $subtype;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$completionStatus = gen204ActionCompletionStatus;
            this.$failReason = str;
            this.$errorCode = num;
            this.$subtype = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MsalObservability.this.new AnonymousClass1(this.$completionStatus, this.$failReason, this.$errorCode, this.$subtype, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DeviceMetric deviceMetric = null;
                UserMetric userMetric = null;
                this.label = 1;
                if (MsalObservability.this.metricsUseCase.log(new MsalEvent(MsalEvent.EventType.Login, this.$completionStatus, this.$failReason, this.$errorCode, this.$subtype, deviceMetric, userMetric, 96, null), this) == coroutine_suspended) {
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

    public final void logMsalLoginEvent(Gen204ActionCompletionStatus completionStatus, String failReason, Integer errorCode, String subtype) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new AnonymousClass1(completionStatus, failReason, errorCode, subtype, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.msal.MsalObservability$logMsalRemediateEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MsalObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.msal.MsalObservability$logMsalRemediateEvent$1", f = "MsalObservability.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Gen204ActionCompletionStatus $completionStatus;
        final /* synthetic */ Integer $errorCode;
        final /* synthetic */ String $failReason;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15961(Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, Continuation<? super C15961> continuation) {
            super(2, continuation);
            this.$completionStatus = gen204ActionCompletionStatus;
            this.$failReason = str;
            this.$errorCode = num;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MsalObservability.this.new C15961(this.$completionStatus, this.$failReason, this.$errorCode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = null;
                DeviceMetric deviceMetric = null;
                UserMetric userMetric = null;
                this.label = 1;
                if (MsalObservability.this.metricsUseCase.log(new MsalEvent(MsalEvent.EventType.Remediate, this.$completionStatus, this.$failReason, this.$errorCode, str, deviceMetric, userMetric, 112, null), this) == coroutine_suspended) {
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

    public static /* synthetic */ void logMsalRemediateEvent$default(MsalObservability msalObservability, Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            gen204ActionCompletionStatus = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        msalObservability.logMsalRemediateEvent(gen204ActionCompletionStatus, str, num);
    }

    public final void logMsalRemediateEvent(Gen204ActionCompletionStatus completionStatus, String failReason, Integer errorCode) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new C15961(completionStatus, failReason, errorCode, null), 3, null);
    }

    public static /* synthetic */ void logMsalLoginStarted$default(MsalObservability msalObservability, EnrollmentMethod enrollmentMethod, int i, Object obj) {
        if ((i & 1) != 0) {
            enrollmentMethod = null;
        }
        msalObservability.logMsalLoginStarted(enrollmentMethod);
    }

    public final void logMsalLoginStarted(EnrollmentMethod enrollmentMethod) {
        logMsalLoginEvent$default(this, null, null, null, enrollmentMethod != null ? enrollmentMethod.getValue() : null, 7, null);
    }

    public static /* synthetic */ void logMsalLoginSucceeded$default(MsalObservability msalObservability, EnrollmentMethod enrollmentMethod, int i, Object obj) {
        if ((i & 1) != 0) {
            enrollmentMethod = null;
        }
        msalObservability.logMsalLoginSucceeded(enrollmentMethod);
    }

    public final void logMsalLoginSucceeded(EnrollmentMethod enrollmentMethod) {
        logMsalLoginEvent$default(this, Gen204ActionCompletionStatus.SUCCEEDED, null, null, enrollmentMethod != null ? enrollmentMethod.getValue() : null, 6, null);
    }

    public static /* synthetic */ void logMsalLoginCanceled$default(MsalObservability msalObservability, Integer num, EnrollmentMethod enrollmentMethod, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            enrollmentMethod = null;
        }
        msalObservability.logMsalLoginCanceled(num, enrollmentMethod);
    }

    public final void logMsalLoginCanceled(Integer errorCode, EnrollmentMethod enrollmentMethod) {
        logMsalLoginEvent(Gen204ActionCompletionStatus.CANCELLED, USER_CANCELED_REASON, errorCode, enrollmentMethod != null ? enrollmentMethod.getValue() : null);
    }

    public static /* synthetic */ void logMsalLoginFailed$default(MsalObservability msalObservability, String str, Integer num, EnrollmentMethod enrollmentMethod, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            enrollmentMethod = null;
        }
        msalObservability.logMsalLoginFailed(str, num, enrollmentMethod);
    }

    public final void logMsalLoginFailed(String message, Integer errorCode, EnrollmentMethod enrollmentMethod) {
        logMsalLoginEvent(Gen204ActionCompletionStatus.FAILED, message, errorCode, enrollmentMethod != null ? enrollmentMethod.getValue() : null);
    }

    public final void logMsalUpnMismatch(EnrollmentMethod enrollmentMethod) {
        Intrinsics.checkNotNullParameter(enrollmentMethod, "enrollmentMethod");
        logMsalLoginEvent$default(this, Gen204ActionCompletionStatus.FAILED, UPN_MISMATCH_REASON, null, enrollmentMethod.getValue(), 4, null);
    }

    public final void logMsalRemediateStarted() {
        logMsalRemediateEvent$default(this, null, null, null, 7, null);
    }

    public final void logMsalRemediateSucceeded() {
        logMsalRemediateEvent$default(this, Gen204ActionCompletionStatus.SUCCEEDED, null, null, 6, null);
    }

    public static /* synthetic */ void logMsalRemediateFailed$default(MsalObservability msalObservability, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        msalObservability.logMsalRemediateFailed(str, num);
    }

    public final void logMsalRemediateFailed(String message, Integer errorCode) {
        logMsalRemediateEvent(Gen204ActionCompletionStatus.FAILED, message, errorCode);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.msal.MsalObservability$logMsalPolicyBlocked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MsalObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.msal.MsalObservability$logMsalPolicyBlocked$1", f = "MsalObservability.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PolicyBlockedReason $reason;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15951(PolicyBlockedReason policyBlockedReason, Continuation<? super C15951> continuation) {
            super(2, continuation);
            this.$reason = policyBlockedReason;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MsalObservability.this.new C15951(this.$reason, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Integer num = null;
                String str = null;
                DeviceMetric deviceMetric = null;
                UserMetric userMetric = null;
                this.label = 1;
                if (MsalObservability.this.metricsUseCase.log(new MsalEvent(MsalEvent.EventType.PolicyBlocked, Gen204ActionCompletionStatus.FAILED, this.$reason.getValue(), num, str, deviceMetric, userMetric, 120, null), this) == coroutine_suspended) {
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

    public final void logMsalPolicyBlocked(PolicyBlockedReason reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new C15951(reason, null), 3, null);
    }
}
