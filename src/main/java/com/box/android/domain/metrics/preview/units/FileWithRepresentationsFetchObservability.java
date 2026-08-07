package com.box.android.domain.metrics.preview.units;

import com.box.android.domain.models.DomainError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: FileWithRepresentationsFetchObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/metrics/preview/units/FileWithRepresentationsFetchObservability;", "", "fileWithRepresentationsFetchStarted", "", "observabilityId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileWithRepresentationsFetchSuccessRemote", "fileWithRepresentationsFetchSuccessCache", "fileWithRepresentationsFetchError", "error", "Lcom/box/android/domain/models/DomainError;", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FileWithRepresentationsFetchObservability {
    Object fileWithRepresentationsFetchError(String str, DomainError domainError, Continuation<? super Unit> continuation);

    Object fileWithRepresentationsFetchStarted(String str, Continuation<? super Unit> continuation);

    Object fileWithRepresentationsFetchSuccessCache(String str, Continuation<? super Unit> continuation);

    Object fileWithRepresentationsFetchSuccessRemote(String str, Continuation<? super Unit> continuation);
}
