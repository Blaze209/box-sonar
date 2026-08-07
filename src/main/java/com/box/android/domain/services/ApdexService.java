package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.observability.ApdexType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ApdexService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J*\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH¦@¢\u0006\u0002\u0010\nJ*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tH¦@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ApdexService;", "", "startTracker", "", "apdex", "Lcom/box/android/domain/models/observability/ApdexType;", "identifier", "startCustomizedTracker", "startTimestamp", "", "(Lcom/box/android/domain/models/observability/ApdexType;Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMilestone", "", "milestone", "Lcom/box/android/domain/models/observability/ApdexType$Milestone;", "timestamp", "(Lcom/box/android/domain/models/observability/ApdexType$Milestone;Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endTrackerAsSuccess", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endTrackerAsFailure", "error", "Lcom/box/android/domain/models/DomainError;", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ApdexService {
    Object addMilestone(ApdexType.Milestone milestone, String str, Long l, Continuation<? super Unit> continuation);

    Object endTrackerAsFailure(String str, DomainError domainError, Continuation<? super Unit> continuation);

    Object endTrackerAsSuccess(String str, Continuation<? super Unit> continuation);

    Object startCustomizedTracker(ApdexType apdexType, String str, Long l, Continuation<? super String> continuation);

    String startTracker(ApdexType apdex, String identifier);

    /* JADX INFO: compiled from: ApdexService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object startCustomizedTracker$default(ApdexService apdexService, ApdexType apdexType, String str, Long l, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startCustomizedTracker");
        }
        if ((i & 4) != 0) {
            l = null;
        }
        return apdexService.startCustomizedTracker(apdexType, str, l, continuation);
    }

    static /* synthetic */ Object addMilestone$default(ApdexService apdexService, ApdexType.Milestone milestone, String str, Long l, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMilestone");
        }
        if ((i & 4) != 0) {
            l = null;
        }
        return apdexService.addMilestone(milestone, str, l, continuation);
    }
}
