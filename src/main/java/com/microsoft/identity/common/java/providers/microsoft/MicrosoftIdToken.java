package com.microsoft.identity.common.java.providers.microsoft;

import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftIdToken extends IDToken {
    public static final String AUDIENCE = "aud";
    public static final String ISSUED_AT = "iat";
    public static final String ISSUER = "iss";
    public static final String NOT_BEFORE = "nbf";
    public static final String OBJECT_ID = "oid";
    public static final String TENANT_ID = "tid";
    public static final String VERSION = "ver";

    public MicrosoftIdToken(String str) throws ServiceException {
        super(str);
    }
}
