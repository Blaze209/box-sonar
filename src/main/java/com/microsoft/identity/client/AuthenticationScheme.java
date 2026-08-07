package com.microsoft.identity.client;

import com.microsoft.identity.common.java.authscheme.INameable;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AuthenticationScheme implements INameable {
    private final String mSchemeName;

    protected AuthenticationScheme(String str) {
        this.mSchemeName = str;
    }

    @Override // com.microsoft.identity.common.java.authscheme.INameable
    public final String getName() {
        return this.mSchemeName;
    }
}
