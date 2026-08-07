package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.util.SchemaUtil;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsAccount extends MicrosoftAccount {
    private static final String TAG = "MicrosoftStsAccount";

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    protected boolean canEqual(Object obj) {
        return obj instanceof MicrosoftStsAccount;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof MicrosoftStsAccount) && ((MicrosoftStsAccount) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public int hashCode() {
        return super.hashCode();
    }

    public MicrosoftStsAccount() {
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
    }

    public MicrosoftStsAccount(IDToken iDToken, ClientInfo clientInfo) {
        super(iDToken, clientInfo);
        if (iDToken == null) {
            throw new NullPointerException("idToken is marked non-null but is null");
        }
        if (clientInfo == null) {
            throw new NullPointerException("clientInfo is marked non-null but is null");
        }
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAuthorityType() {
        return MicrosoftAccount.AUTHORITY_TYPE_MS_STS;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    protected String getDisplayableIdFromClaims(Map<String, ?> map) {
        if (map == null) {
            throw new NullPointerException("claims is marked non-null but is null");
        }
        return SchemaUtil.getDisplayableId(map);
    }
}
