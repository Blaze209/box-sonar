package com.microsoft.intune.mam.client.identity;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMIdentityManager {
    MAMIdentity create(String str, String str2);

    MAMIdentity create(String str, String str2, String str3);

    MAMIdentity create(String str, String str2, String str3, String str4);

    MAMIdentity fetch(String str);

    MAMIdentity fetchFromUPN(String str);

    MAMIdentity fromString(String str);

    MAMIdentity insertOrUpdate(String str, String str2, String str3, String str4, boolean z);
}
