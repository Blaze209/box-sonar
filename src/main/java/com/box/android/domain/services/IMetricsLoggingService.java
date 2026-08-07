package com.box.android.domain.services;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.utils.result.Result;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IMetricsLoggingService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ0\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IMetricsLoggingService;", "", SemanticAttributes.DbSystemValues.CACHE, "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "genericEvent", "Lcom/box/android/domain/models/observability/Gen204Event;", "(Lcom/box/android/domain/models/observability/Gen204Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_UPLOAD_JOB, "deleteOnFailureForUserId", "", "deleteOnFailureForAllUsers", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMetricsLoggingService {
    Object cache(Gen204Event gen204Event, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object getCount(Continuation<? super Result<Integer, ? extends DomainError>> continuation);

    Object upload(String str, boolean z, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: IMetricsLoggingService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object upload$default(IMetricsLoggingService iMetricsLoggingService, String str, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upload");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return iMetricsLoggingService.upload(str, z, continuation);
    }
}
