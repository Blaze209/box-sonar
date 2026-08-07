package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;

/* JADX INFO: loaded from: classes14.dex */
public interface IShareSingleSignOnState<T extends BaseAccount, U extends RefreshToken> {
    U getSingleSignOnState(T t);

    void setSingleSignOnState(T t, U u) throws ClientException;
}
