package com.microsoft.intune.mam.client.identity;

import com.microsoft.intune.mam.client.app.MAMComponents;

/* JADX INFO: loaded from: classes3.dex */
public final class ExternalIdentityUtils {
    public static MAMIdentity identityFromOID(String str) {
        return ((IdentityParamConverter) MAMComponents.get(IdentityParamConverter.class)).fromOidParam(str);
    }

    public static MAMIdentity fromUpnAndOid(String str, String str2) {
        return ((IdentityParamConverter) MAMComponents.get(IdentityParamConverter.class)).fromUpnAndOid(str, str2);
    }

    private ExternalIdentityUtils() {
    }
}
