package com.box.android.domain.metrics;

import com.box.android.domain.models.observability.FileActivityEvent;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204FileActivityEventLogger.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/metrics/Gen204FileActivityEventLogger;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;)V", "success", "", "fileActivityAction", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "failure", "failureReason", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gen204FileActivityEventLogger {
    public static final String ACTION_COMMENT = "comment";
    public static final String ACTION_DELETE = "delete";
    public static final String ACTION_LOAD_ACTIVITIES = "load_activities";
    public static final String ACTION_LOAD_COLLABORATORS = "load_collaborators";
    public static final String ACTION_MODIFY = "modify";
    public static final String ACTION_REFRESH_ACTIVITIES = "refresh_activities";
    public static final String ACTION_REPLY = "reply";
    public static final String ACTION_RESOLVE = "resolve";
    public static final String ACTION_UNRESOLVE = "unresolve";
    private final MetricsUseCase metricsUseCase;

    @Inject
    public Gen204FileActivityEventLogger(MetricsUseCase metricsUseCase) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        this.metricsUseCase = metricsUseCase;
    }

    public final Object success(String str, Continuation<? super Unit> continuation) {
        Object objLog = this.metricsUseCase.log(new FileActivityEvent(str, null), continuation);
        return objLog == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLog : Unit.INSTANCE;
    }

    public final Object failure(String str, String str2, Continuation<? super Unit> continuation) {
        Object objLog = this.metricsUseCase.log(new FileActivityEvent(str, str2), continuation);
        return objLog == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLog : Unit.INSTANCE;
    }
}
