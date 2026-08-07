package com.microsoft.intune.mam.client.identity;

/* JADX INFO: loaded from: classes3.dex */
public interface IdentityParamConverter {
    void emitUpnUsageWarnings(String str);

    MAMIdentity fromOidParam(String str);

    MAMIdentity fromUpnAndOid(String str, String str2);

    MAMIdentity fromUpnParam(String str);
}
