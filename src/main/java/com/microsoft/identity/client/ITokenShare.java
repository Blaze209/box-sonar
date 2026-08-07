package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal;

/* JADX INFO: loaded from: classes14.dex */
public interface ITokenShare extends ITokenShareInternal {
    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    String getMsaFamilyRefreshToken(String str) throws MsalClientException;

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    TokenShareResult getMsaFamilyRefreshTokenWithMetadata(String str) throws MsalClientException;

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    String getOrgIdFamilyRefreshToken(String str) throws MsalClientException;

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    TokenShareResult getOrgIdFamilyRefreshTokenWithMetadata(String str) throws MsalClientException;

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    void saveMsaFamilyRefreshToken(String str) throws MsalClientException;

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    void saveOrgIdFamilyRefreshToken(String str) throws MsalClientException;
}
