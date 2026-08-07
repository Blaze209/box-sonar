package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftIdToken;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryIdToken extends MicrosoftIdToken {
    public static final String IDENTITY_PROVIDER = "idp";
    public static final String PASSWORD_CHANGE_URL = "pwd_url";
    public static final String PASSWORD_EXPIRATION = "pwd_exp";
    public static final String UNIQUE_NAME = "unique_name";
    public static final String UPN = "upn";

    public AzureActiveDirectoryIdToken(String str) throws ServiceException {
        super(str);
    }
}
