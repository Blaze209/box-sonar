package com.box.android.domain.usecases.observability;

import com.box.android.domain.models.AuthenticationInfoModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.IObservabilityService;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthenticationInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/usecases/observability/AuthenticationInteractor;", "", "observabilityService", "Lcom/box/android/domain/services/IObservabilityService;", "<init>", "(Lcom/box/android/domain/services/IObservabilityService;)V", "authenticate", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/AuthenticationInfoModel;", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AuthenticationInteractor {
    private final IObservabilityService observabilityService;

    @Inject
    public AuthenticationInteractor(IObservabilityService observabilityService) {
        Intrinsics.checkNotNullParameter(observabilityService, "observabilityService");
        this.observabilityService = observabilityService;
    }

    public final Object authenticate(Continuation<? super Result<AuthenticationInfoModel, ? extends DomainError>> continuation) {
        return this.observabilityService.authenticate(continuation);
    }
}
