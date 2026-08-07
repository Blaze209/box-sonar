package com.box.android.domain.services;

import kotlin.Metadata;

/* JADX INFO: compiled from: IBVEManager.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\bH&J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\bH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IBVEManager;", "", "isVerifiedEnterprise", "", "setVerifiedEnterprise", "", "verified", "getVerifiedEnterpriseDomain", "", "setVerifiedEnterpriseDomain", "domain", "getBaseUri", "getCloudBaseUri", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IBVEManager {
    String getBaseUri();

    String getCloudBaseUri();

    String getVerifiedEnterpriseDomain();

    boolean isVerifiedEnterprise();

    void setVerifiedEnterprise(boolean verified);

    void setVerifiedEnterpriseDomain(String domain);
}
