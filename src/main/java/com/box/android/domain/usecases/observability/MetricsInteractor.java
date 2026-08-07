package com.box.android.domain.usecases.observability;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.services.IMetricsLoggingService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.auth.OAuthActivity;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B$\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0011\u0010\u0004\u001a\r\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0096@¢\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0096@¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u000bH\u0096@¢\u0006\u0002\u0010\u000eJ\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\r\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/domain/usecases/observability/MetricsInteractor;", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "metricsLoggingService", "Lcom/box/android/domain/services/IMetricsLoggingService;", "metricDecorators", "", "Lcom/box/android/domain/usecases/observability/MetricDecorator;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "(Lcom/box/android/domain/services/IMetricsLoggingService;Ljava/util/Set;)V", "uploadMetrics", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadMetricsOnLogOut", OAuthActivity.USER_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadMetricsOnLogOutAllUsers", "getMetricsCountInCache", "", "log", "event", "Lcom/box/android/domain/models/observability/Gen204Event;", "(Lcom/box/android/domain/models/observability/Gen204Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricsInteractor implements MetricsUseCase {
    private final Set<MetricDecorator> metricDecorators;
    private final IMetricsLoggingService metricsLoggingService;

    @Inject
    public MetricsInteractor(IMetricsLoggingService metricsLoggingService, Set<MetricDecorator> metricDecorators) {
        Intrinsics.checkNotNullParameter(metricsLoggingService, "metricsLoggingService");
        Intrinsics.checkNotNullParameter(metricDecorators, "metricDecorators");
        this.metricsLoggingService = metricsLoggingService;
        this.metricDecorators = metricDecorators;
    }

    @Override // com.box.android.domain.usecases.observability.MetricsUseCase
    public Object uploadMetrics(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return IMetricsLoggingService.upload$default(this.metricsLoggingService, null, false, continuation, 3, null);
    }

    @Override // com.box.android.domain.usecases.observability.MetricsUseCase
    public Object uploadMetricsOnLogOut(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return IMetricsLoggingService.upload$default(this.metricsLoggingService, str, false, continuation, 2, null);
    }

    @Override // com.box.android.domain.usecases.observability.MetricsUseCase
    public Object uploadMetricsOnLogOutAllUsers(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return IMetricsLoggingService.upload$default(this.metricsLoggingService, null, true, continuation, 1, null);
    }

    @Override // com.box.android.domain.usecases.observability.MetricsUseCase
    public Object getMetricsCountInCache(Continuation<? super Result<Integer, ? extends DomainError>> continuation) {
        return this.metricsLoggingService.getCount(continuation);
    }

    @Override // com.box.android.domain.usecases.observability.MetricsUseCase
    public Object log(Gen204Event gen204Event, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        Iterator<T> it = this.metricDecorators.iterator();
        while (it.hasNext()) {
            gen204Event = ((MetricDecorator) it.next()).decorate(gen204Event);
        }
        return this.metricsLoggingService.cache(gen204Event, continuation);
    }
}
