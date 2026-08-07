package com.microsoft.identity.common.java.interfaces;

import kotlin.Metadata;

/* JADX INFO: compiled from: IRefreshTokenCredentialProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/microsoft/identity/common/java/interfaces/IRefreshTokenCredentialProvider;", "", "getRefreshTokenCredential", "", "inputUrl", "username", "getRefreshTokenCredentialUsingNewNonce", "nonce", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IRefreshTokenCredentialProvider {
    String getRefreshTokenCredential(String inputUrl, String username);

    String getRefreshTokenCredentialUsingNewNonce(String inputUrl, String username, String nonce);
}
