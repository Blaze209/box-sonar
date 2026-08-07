package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.java.exception.ClientException;

/* JADX INFO: loaded from: classes14.dex */
public interface AsymmetricKeyFactory {
    boolean clearAsymmetricKey(String str) throws ClientException;

    AsymmetricKey generateAsymmetricKey(String str) throws ClientException;

    AsymmetricKey loadAsymmetricKey(String str) throws ClientException;
}
