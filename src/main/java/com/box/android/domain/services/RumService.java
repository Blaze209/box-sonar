package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: RumService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H&JN\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H¦@¢\u0006\u0002\u0010\u0012J*\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011H¦@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H¦@¢\u0006\u0002\u0010!J(\u0010\"\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010#J&\u0010$\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010%¨\u0006&À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/RumService;", "", "init", "", "proxyUrl", "", "samplingRatio", "", "startSpan", "spanName", "identifier", "startCustomizedSpan", "customEventName", "parentSpanIdentifier", "makeCurrent", "", "startTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMilestone", "milestone", "timestamp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSpanAsSuccess", "spanId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOperation", "operationName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventName", "endSpanWithError", "error", "Lcom/box/android/domain/models/DomainError;", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAndEndSpanAsSuccess", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAndEndSpanAsError", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RumService {
    Object addMilestone(String str, String str2, Long l, Continuation<? super Unit> continuation);

    Object endSpanAsSuccess(String str, Continuation<? super Unit> continuation);

    Object endSpanWithError(String str, DomainError domainError, Continuation<? super Unit> continuation);

    void init(String proxyUrl, double samplingRatio);

    Object startCustomizedSpan(String str, String str2, String str3, String str4, boolean z, Long l, Continuation<? super String> continuation);

    String startSpan(String spanName, String identifier);

    Object updateAndEndSpanAsError(String str, DomainError domainError, String str2, Continuation<? super Unit> continuation);

    Object updateAndEndSpanAsSuccess(String str, String str2, String str3, Continuation<? super Unit> continuation);

    Object updateEventName(String str, String str2, Continuation<? super Unit> continuation);

    Object updateOperation(String str, String str2, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: RumService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void init$default(RumService rumService, String str, double d, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
        if ((i & 2) != 0) {
            d = 1.0d;
        }
        rumService.init(str, d);
    }

    static /* synthetic */ String startSpan$default(RumService rumService, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startSpan");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return rumService.startSpan(str, str2);
    }

    static /* synthetic */ Object startCustomizedSpan$default(RumService rumService, String str, String str2, String str3, String str4, boolean z, Long l, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startCustomizedSpan");
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            z = true;
        }
        if ((i & 32) != 0) {
            l = null;
        }
        return rumService.startCustomizedSpan(str, str2, str3, str4, z, l, continuation);
    }

    static /* synthetic */ Object addMilestone$default(RumService rumService, String str, String str2, Long l, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMilestone");
        }
        if ((i & 4) != 0) {
            l = null;
        }
        return rumService.addMilestone(str, str2, l, continuation);
    }
}
