package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftIdToken;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsIdToken extends MicrosoftIdToken {
    public static final String AIO = "aio";
    public static final String EXPIRATION_TIME = "exp";
    public static final String UTI = "uti";

    public MicrosoftStsIdToken(String str) throws ServiceException {
        super(str);
    }
}
