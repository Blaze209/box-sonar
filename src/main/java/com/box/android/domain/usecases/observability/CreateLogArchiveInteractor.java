package com.box.android.domain.usecases.observability;

import android.net.Uri;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.IObservabilityService;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateLogArchiveInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0086B¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/usecases/observability/CreateLogArchiveInteractor;", "", "observabilityService", "Lcom/box/android/domain/services/IObservabilityService;", "<init>", "(Lcom/box/android/domain/services/IObservabilityService;)V", "invoke", "Lcom/box/android/domain/utils/result/Result;", "Landroid/net/Uri;", "Lcom/box/android/domain/models/DomainError;", "fileProviderAuthorityId", "", "logTag", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateLogArchiveInteractor {
    private final IObservabilityService observabilityService;

    @Inject
    public CreateLogArchiveInteractor(IObservabilityService observabilityService) {
        Intrinsics.checkNotNullParameter(observabilityService, "observabilityService");
        this.observabilityService = observabilityService;
    }

    public static /* synthetic */ Object invoke$default(CreateLogArchiveInteractor createLogArchiveInteractor, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return createLogArchiveInteractor.invoke(i, str, continuation);
    }

    public final Object invoke(int i, String str, Continuation<? super Result<? extends Uri, ? extends DomainError>> continuation) {
        return this.observabilityService.createLogArchiveFile(i, str, continuation);
    }
}
