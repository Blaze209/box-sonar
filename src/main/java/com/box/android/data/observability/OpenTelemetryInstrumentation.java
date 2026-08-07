package com.box.android.data.observability;

import com.box.android.domain.models.DomainError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: OpenTelemetryInstrumentation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\tJ*\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/box/android/data/observability/OpenTelemetryInstrumentation;", "", "startSpan", "", "performanceType", "", "identifier", "startTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "addMilestone", "eventName", "timestamp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSpanAsSuccess", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSpanWithFailure", "error", "Lcom/box/android/domain/models/DomainError;", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OpenTelemetryInstrumentation {
    Object addMilestone(String str, String str2, Long l, Continuation<? super Unit> continuation);

    Object endSpanAsSuccess(String str, Continuation<? super Unit> continuation);

    Object endSpanWithFailure(String str, DomainError domainError, Continuation<? super Unit> continuation);

    void startSpan(String performanceType, String identifier, Long startTimestamp);

    /* JADX INFO: compiled from: OpenTelemetryInstrumentation.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void startSpan$default(OpenTelemetryInstrumentation openTelemetryInstrumentation, String str, String str2, Long l, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startSpan");
        }
        if ((i & 4) != 0) {
            l = null;
        }
        openTelemetryInstrumentation.startSpan(str, str2, l);
    }

    static /* synthetic */ Object addMilestone$default(OpenTelemetryInstrumentation openTelemetryInstrumentation, String str, String str2, Long l, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMilestone");
        }
        if ((i & 4) != 0) {
            l = null;
        }
        return openTelemetryInstrumentation.addMilestone(str, str2, l, continuation);
    }
}
