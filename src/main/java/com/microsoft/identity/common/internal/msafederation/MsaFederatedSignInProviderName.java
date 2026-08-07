package com.microsoft.identity.common.internal.msafederation;

import kotlin.Metadata;

/* JADX INFO: compiled from: MsaFederatedSignInProviderName.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedSignInProviderName;", "", "idProviderName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getIdProviderName", "GOOGLE", "APPLE", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum MsaFederatedSignInProviderName {
    GOOGLE("google.com"),
    APPLE("apple.com");

    private final String idProviderName;

    MsaFederatedSignInProviderName(String str) {
        this.idProviderName = str;
    }

    public final String getIdProviderName() {
        return this.idProviderName;
    }
}
