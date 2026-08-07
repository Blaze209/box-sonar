package com.microsoft.identity.common.adal.internal.tokensharing;

/* JADX INFO: loaded from: classes14.dex */
public interface ITokenShareInternal {
    String getMsaFamilyRefreshToken(String str) throws Exception;

    ITokenShareResultInternal getMsaFamilyRefreshTokenWithMetadata(String str) throws Exception;

    String getOrgIdFamilyRefreshToken(String str) throws Exception;

    ITokenShareResultInternal getOrgIdFamilyRefreshTokenWithMetadata(String str) throws Exception;

    void saveMsaFamilyRefreshToken(String str) throws Exception;

    void saveOrgIdFamilyRefreshToken(String str) throws Exception;
}
