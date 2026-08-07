package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.java.exception.ClientException;

/* JADX INFO: loaded from: classes14.dex */
public interface AsymmetricRsaKey extends AsymmetricKey {
    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    String decrypt(String str) throws ClientException;

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    String encrypt(String str) throws ClientException;

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    String getPublicKey() throws ClientException;

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    String getThumbprint() throws ClientException;

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    String sign(String str) throws ClientException;

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    boolean verify(String str, String str2);
}
