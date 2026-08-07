package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.java.exception.ClientException;

/* JADX INFO: loaded from: classes14.dex */
public interface AsymmetricRsaKeyFactory extends AsymmetricKeyFactory {
    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKeyFactory
    AsymmetricRsaKey generateAsymmetricKey(String str) throws ClientException;

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKeyFactory
    AsymmetricRsaKey loadAsymmetricKey(String str) throws ClientException;
}
