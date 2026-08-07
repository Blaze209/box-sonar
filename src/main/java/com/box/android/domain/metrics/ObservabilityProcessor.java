package com.box.android.domain.metrics;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.models.observability.ApdexType;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.RumService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: ObservabilityProcessor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0002\u0010\u0016J,\u0010\u0017\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ(\u0010\u001b\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010\u001fJX\u0010 \u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u00192\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u00192\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0019H\u0086@¢\u0006\u0002\u0010$JB\u0010%\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00102\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00028\u00000\bH\u0086@¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\u0004\u0018\u00018\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020.2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/box/android/domain/metrics/ObservabilityProcessor;", ExifInterface.GPS_DIRECTION_TRUE, "", "rumService", "Lcom/box/android/domain/services/RumService;", "apdexService", "Lcom/box/android/domain/services/ApdexService;", "sendEvent", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lcom/box/android/domain/services/RumService;Lcom/box/android/domain/services/ApdexService;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "metrics", "", "", "updateMetricMutex", "Lkotlinx/coroutines/sync/Mutex;", "launchMetric", "event", "observabilityId", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;", "updateLaunchData", "update", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOnLoadingStarted", "eventName", "apdexType", "Lcom/box/android/domain/models/observability/ApdexType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/observability/ApdexType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSuccessEvent", "onSuccessEvent", "getSuccessEventName", "getSuccessOperationName", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendErrorEvent", "error", "Lcom/box/android/domain/models/DomainError;", "customEventName", "onErrorEvent", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventData", "(Ljava/lang/String;)Ljava/lang/Object;", "hasData", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ObservabilityProcessor<T> {
    private final ApdexService apdexService;
    private final Map<String, T> metrics;
    private final RumService rumService;
    private final Function2<T, Continuation<? super Unit>, Object> sendEvent;
    private final Mutex updateMetricMutex;

    /* JADX INFO: renamed from: com.box.android.domain.metrics.ObservabilityProcessor$sendErrorEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObservabilityProcessor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.ObservabilityProcessor", f = "ObservabilityProcessor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {75, 76, 77}, m = "sendErrorEvent", n = {"observabilityId", "error", "customEventName", "onErrorEvent", "launchData", "updatedEvent", "observabilityId", "error", "customEventName", "onErrorEvent", "launchData", "updatedEvent", "observabilityId", "error", "customEventName", "onErrorEvent", "launchData", "updatedEvent"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObservabilityProcessor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ObservabilityProcessor<T> observabilityProcessor, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = observabilityProcessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.sendErrorEvent(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.ObservabilityProcessor$sendOnLoadingStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObservabilityProcessor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.ObservabilityProcessor", f = "ObservabilityProcessor.kt", i = {0, 0, 0}, l = {34}, m = "sendOnLoadingStarted", n = {"observabilityId", "eventName", "apdexType"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C15881 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObservabilityProcessor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15881(ObservabilityProcessor<T> observabilityProcessor, Continuation<? super C15881> continuation) {
            super(continuation);
            this.this$0 = observabilityProcessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.sendOnLoadingStarted(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.ObservabilityProcessor$sendSuccessEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObservabilityProcessor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.ObservabilityProcessor", f = "ObservabilityProcessor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {55, 56, 61}, m = "sendSuccessEvent", n = {"observabilityId", "onSuccessEvent", "getSuccessEventName", "getSuccessOperationName", "launchData", "updatedEvent", "observabilityId", "onSuccessEvent", "getSuccessEventName", "getSuccessOperationName", "launchData", "updatedEvent", "observabilityId", "onSuccessEvent", "getSuccessEventName", "getSuccessOperationName", "launchData", "updatedEvent"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class C15891 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObservabilityProcessor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15891(ObservabilityProcessor<T> observabilityProcessor, Continuation<? super C15891> continuation) {
            super(continuation);
            this.this$0 = observabilityProcessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.sendSuccessEvent(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.ObservabilityProcessor$updateLaunchData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObservabilityProcessor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.ObservabilityProcessor", f = "ObservabilityProcessor.kt", i = {0, 0, 0, 0}, l = {94}, m = "updateLaunchData", n = {"observabilityId", "update", "$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C15901 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObservabilityProcessor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15901(ObservabilityProcessor<T> observabilityProcessor, Continuation<? super C15901> continuation) {
            super(continuation);
            this.this$0 = observabilityProcessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateLaunchData(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObservabilityProcessor(RumService rumService, ApdexService apdexService, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> sendEvent) {
        Intrinsics.checkNotNullParameter(rumService, "rumService");
        Intrinsics.checkNotNullParameter(apdexService, "apdexService");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.rumService = rumService;
        this.apdexService = apdexService;
        this.sendEvent = sendEvent;
        this.metrics = new LinkedHashMap();
        this.updateMetricMutex = MutexKt.Mutex$default(false, 1, null);
    }

    public final String launchMetric(T event, String observabilityId) {
        Intrinsics.checkNotNullParameter(observabilityId, "observabilityId");
        this.metrics.put(observabilityId, event);
        return observabilityId;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateLaunchData(String str, Function1<? super T, ? extends T> function1, Continuation<? super Unit> continuation) {
        C15901 c15901;
        Mutex mutex;
        if (continuation instanceof C15901) {
            c15901 = (C15901) continuation;
            if ((c15901.label & Integer.MIN_VALUE) != 0) {
                c15901.label -= Integer.MIN_VALUE;
            } else {
                c15901 = new C15901(this, continuation);
            }
        } else {
            c15901 = new C15901(this, continuation);
        }
        Object obj = c15901.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15901.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.updateMetricMutex;
            c15901.L$0 = str;
            c15901.L$1 = function1;
            c15901.L$2 = mutex;
            c15901.I$0 = 0;
            c15901.label = 1;
            if (mutex.lock(null, c15901) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c15901.I$0;
            Mutex mutex2 = (Mutex) c15901.L$2;
            function1 = (Function1) c15901.L$1;
            String str2 = (String) c15901.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            str = str2;
        }
        try {
            T eventData = getEventData(str);
            if (eventData != null) {
                Map<String, T> map = this.metrics;
                Intrinsics.checkNotNull(str);
                map.put(str, function1.invoke(eventData));
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object sendOnLoadingStarted(String str, String str2, ApdexType apdexType, Continuation<? super Unit> continuation) {
        C15881 c15881;
        String str3;
        if (continuation instanceof C15881) {
            c15881 = (C15881) continuation;
            if ((c15881.label & Integer.MIN_VALUE) != 0) {
                c15881.label -= Integer.MIN_VALUE;
            } else {
                c15881 = new C15881(this, continuation);
            }
        } else {
            c15881 = new C15881(this, continuation);
        }
        C15881 c15882 = c15881;
        Object obj = c15882.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15882.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (hasData(str)) {
                RumService rumService = this.rumService;
                c15882.L$0 = str;
                c15882.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c15882.L$2 = apdexType;
                c15882.label = 1;
                if (RumService.startCustomizedSpan$default(rumService, str2, str2, str, null, false, null, c15882, 56, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            str3 = str;
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        apdexType = (ApdexType) c15882.L$2;
        str3 = (String) c15882.L$0;
        ResultKt.throwOnFailure(obj);
        if (str3 != null) {
            str3 = str;
            this.apdexService.startTracker(apdexType, str3);
        }
        str3 = str;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0125, code lost:
    
        if (r4.endTrackerAsSuccess(r11, r0) == r1) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendSuccessEvent(java.lang.String r11, kotlin.jvm.functions.Function1<? super T, ? extends T> r12, kotlin.jvm.functions.Function1<? super T, java.lang.String> r13, kotlin.jvm.functions.Function1<? super T, java.lang.String> r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.metrics.ObservabilityProcessor.sendSuccessEvent(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object sendSuccessEvent$default(ObservabilityProcessor observabilityProcessor, String str, Function1 function1, Function1 function2, Function1 function3, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            function3 = new Function1() { // from class: com.box.android.domain.metrics.ObservabilityProcessor.sendSuccessEvent.2
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
        }
        return observabilityProcessor.sendSuccessEvent(str, function1, function2, function3, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0115, code lost:
    
        if (r4.endTrackerAsFailure(r10, r14, r0) == r1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendErrorEvent(java.lang.String r10, com.box.android.domain.models.DomainError r11, java.lang.String r12, kotlin.jvm.functions.Function2<? super T, ? super com.box.android.domain.models.DomainError, ? extends T> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.metrics.ObservabilityProcessor.sendErrorEvent(java.lang.String, com.box.android.domain.models.DomainError, java.lang.String, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final T getEventData(String observabilityId) {
        if (observabilityId != null) {
            return this.metrics.get(observabilityId);
        }
        return null;
    }

    public final boolean hasData(String observabilityId) {
        return getEventData(observabilityId) != null;
    }
}
