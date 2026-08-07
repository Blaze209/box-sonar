package com.microsoft.intune.mam.policy.appconfig;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMAppConfigManager {
    @Deprecated
    MAMAppConfig getAppConfig(String str);

    MAMAppConfig getAppConfigForOID(String str);
}
