package com.box.android.domain.services;

import kotlin.Metadata;

/* JADX INFO: compiled from: IForceUpdateCoordinator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IForceUpdateCoordinator;", "", "enforceIfNeeded", "", "shouldValidateGQL", "", "onRemoteConfigUpdated", "onGQLValidationError", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IForceUpdateCoordinator {
    void enforceIfNeeded();

    void onGQLValidationError();

    void onRemoteConfigUpdated();

    boolean shouldValidateGQL();
}
