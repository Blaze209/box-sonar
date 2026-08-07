package com.microsoft.identity.common.java.providers.microsoft;

import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.java.util.SchemaUtil;
import com.microsoft.identity.common.java.util.StringUtil;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftRefreshToken extends RefreshToken {
    private String mClientId;
    private ClientInfo mClientInfo;
    private String mEnvironment;
    private String mFamilyId;
    private String mScope;

    public MicrosoftRefreshToken(String str, ClientInfo clientInfo, String str2, String str3, String str4, String str5) {
        super(str);
        this.mClientInfo = clientInfo;
        this.mScope = str2;
        this.mClientId = str3;
        this.mEnvironment = str4;
        this.mFamilyId = str5;
    }

    public MicrosoftRefreshToken(MicrosoftTokenResponse microsoftTokenResponse) {
        super(microsoftTokenResponse);
        if (microsoftTokenResponse == null) {
            throw new NullPointerException("tokenResponse is marked non-null but is null");
        }
        try {
            this.mClientInfo = new ClientInfo(microsoftTokenResponse.getClientInfo());
            this.mFamilyId = microsoftTokenResponse.getFamilyId();
            this.mScope = microsoftTokenResponse.getScope();
            this.mClientId = microsoftTokenResponse.getClientId();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getHomeAccountId() {
        return SchemaUtil.getHomeAccountId(this.mClientInfo);
    }

    public void setEnvironment(String str) {
        this.mEnvironment = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getEnvironment() {
        return this.mEnvironment;
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getClientId() {
        return this.mClientId;
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getSecret() {
        return getRefreshToken();
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getTarget() {
        return this.mScope;
    }

    @Override // com.microsoft.identity.common.java.dto.IRefreshTokenRecord
    public String getFamilyId() {
        return this.mFamilyId;
    }

    public boolean getIsFamilyRefreshToken() {
        return !StringUtil.isNullOrEmpty(this.mFamilyId);
    }

    public ClientInfo getClientInfo() {
        return this.mClientInfo;
    }
}
