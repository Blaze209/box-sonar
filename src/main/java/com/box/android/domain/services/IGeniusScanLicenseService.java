package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IGeniusScanLicenseService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IGeniusScanLicenseService;", "", "getLicenseKey", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLicenseKeyToCache", "", "licenseKey", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IGeniusScanLicenseService {
    Object getLicenseKey(Continuation<? super Result<String, ? extends DomainError>> continuation);

    void writeLicenseKeyToCache(String licenseKey);
}
