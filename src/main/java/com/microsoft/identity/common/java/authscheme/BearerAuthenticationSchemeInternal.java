package com.microsoft.identity.common.java.authscheme;

/* JADX INFO: loaded from: classes14.dex */
public class BearerAuthenticationSchemeInternal extends TokenAuthenticationScheme implements ITokenAuthenticationSchemeInternal {
    public static final String SCHEME_BEARER = "Bearer";
    private static final long serialVersionUID = 823164758655077118L;

    public BearerAuthenticationSchemeInternal() {
        super("Bearer");
    }

    @Override // com.microsoft.identity.common.java.authscheme.ITokenAuthenticationSchemeInternal
    public String getAccessTokenForScheme(String str) {
        if (str != null) {
            return str;
        }
        throw new NullPointerException("accessToken is marked non-null but is null");
    }
}
