package com.box.android.utilities;

import com.box.android.domain.models.observability.AuthEvent;
import com.box.android.domain.models.observability.Gen204ActionCompletionStatus;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: AuthLoggerUtil.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/box/android/utilities/AuthLoggerUtil;", "", "<init>", "()V", "logAuthEvent", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "eventType", "Lcom/box/android/domain/models/observability/AuthEvent$EventType;", "completionStatus", "Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;", "failReason", "", "errorCode", "", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lcom/box/android/domain/models/observability/AuthEvent$EventType;Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;Ljava/lang/String;Ljava/lang/Integer;)V", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AuthLoggerUtil {
    public static final int $stable = 0;
    public static final AuthLoggerUtil INSTANCE = new AuthLoggerUtil();

    private AuthLoggerUtil() {
    }

    public static /* synthetic */ void logAuthEvent$default(MetricsUseCase metricsUseCase, AuthEvent.EventType eventType, Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            gen204ActionCompletionStatus = null;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        if ((i & 16) != 0) {
            num = null;
        }
        logAuthEvent(metricsUseCase, eventType, gen204ActionCompletionStatus, str, num);
    }

    /* JADX INFO: renamed from: com.box.android.utilities.AuthLoggerUtil$logAuthEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuthLoggerUtil.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.utilities.AuthLoggerUtil$logAuthEvent$1", f = "AuthLoggerUtil.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Gen204ActionCompletionStatus $completionStatus;
        final /* synthetic */ Integer $errorCode;
        final /* synthetic */ AuthEvent.EventType $eventType;
        final /* synthetic */ String $failReason;
        final /* synthetic */ MetricsUseCase $metricsUseCase;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MetricsUseCase metricsUseCase, AuthEvent.EventType eventType, Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$metricsUseCase = metricsUseCase;
            this.$eventType = eventType;
            this.$completionStatus = gen204ActionCompletionStatus;
            this.$failReason = str;
            this.$errorCode = num;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$metricsUseCase, this.$eventType, this.$completionStatus, this.$failReason, this.$errorCode, continuation);
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
                this.label = 1;
                if (this.$metricsUseCase.log(new AuthEvent(this.$eventType, this.$completionStatus, this.$failReason, this.$errorCode, null, null), this) == coroutine_suspended) {
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

    @JvmStatic
    public static final void logAuthEvent(MetricsUseCase metricsUseCase, AuthEvent.EventType eventType, Gen204ActionCompletionStatus completionStatus, String failReason, Integer errorCode) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new AnonymousClass1(metricsUseCase, eventType, completionStatus, failReason, errorCode, null), 2, null);
    }
}
