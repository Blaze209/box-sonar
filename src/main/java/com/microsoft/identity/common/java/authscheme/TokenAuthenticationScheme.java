package com.microsoft.identity.common.java.authscheme;

/* JADX INFO: loaded from: classes14.dex */
public abstract class TokenAuthenticationScheme extends AbstractAuthenticationScheme implements ITokenAuthenticationSchemeInternal {
    public static final String SCHEME_DELIMITER = " ";
    private static final long serialVersionUID = 8007073391895830795L;

    public static abstract class TokenAuthenticationSchemeBuilder<C extends TokenAuthenticationScheme, B extends TokenAuthenticationSchemeBuilder<C, B>> extends AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder<C, B> {
        private static void $fillValuesFromInstanceIntoBuilder(TokenAuthenticationScheme tokenAuthenticationScheme, TokenAuthenticationSchemeBuilder<?, ?> tokenAuthenticationSchemeBuilder) {
        }

        @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public abstract B self();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((TokenAuthenticationScheme) c, (TokenAuthenticationSchemeBuilder<?, ?>) this);
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public String toString() {
            return "TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder(super=" + super.toString() + ")";
        }
    }

    protected TokenAuthenticationScheme(TokenAuthenticationSchemeBuilder<?, ?> tokenAuthenticationSchemeBuilder) {
        super(tokenAuthenticationSchemeBuilder);
    }

    @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    protected boolean canEqual(Object obj) {
        return obj instanceof TokenAuthenticationScheme;
    }

    @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof TokenAuthenticationScheme) && ((TokenAuthenticationScheme) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    public int hashCode() {
        return super.hashCode();
    }

    TokenAuthenticationScheme(String str) {
        super(str);
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
    }
}
