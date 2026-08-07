package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BaseSignInTokenCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "BaseSignInTokenCommandParameters";
    private final AbstractAuthenticationScheme authenticationScheme;

    @Nullable
    public final String claimsRequestJson;
    public final List<String> scopes;

    public static abstract class BaseSignInTokenCommandParametersBuilder<C extends BaseSignInTokenCommandParameters, B extends BaseSignInTokenCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private AbstractAuthenticationScheme authenticationScheme;
        private String claimsRequestJson;
        private List<String> scopes;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(BaseSignInTokenCommandParameters baseSignInTokenCommandParameters, BaseSignInTokenCommandParametersBuilder<?, ?> baseSignInTokenCommandParametersBuilder) {
            baseSignInTokenCommandParametersBuilder.scopes(baseSignInTokenCommandParameters.scopes);
            baseSignInTokenCommandParametersBuilder.claimsRequestJson(baseSignInTokenCommandParameters.claimsRequestJson);
            baseSignInTokenCommandParametersBuilder.authenticationScheme(baseSignInTokenCommandParameters.authenticationScheme);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((BaseSignInTokenCommandParameters) c, (BaseSignInTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B authenticationScheme(AbstractAuthenticationScheme abstractAuthenticationScheme) {
            this.authenticationScheme = abstractAuthenticationScheme;
            return (B) self();
        }

        public B claimsRequestJson(@Nullable String str) {
            this.claimsRequestJson = str;
            return (B) self();
        }

        public B scopes(List<String> list) {
            this.scopes = list;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder(super=" + super.toString() + ", scopes=" + this.scopes + ", claimsRequestJson=" + this.claimsRequestJson + ", authenticationScheme=" + this.authenticationScheme + ")";
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof BaseSignInTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseSignInTokenCommandParameters)) {
            return false;
        }
        BaseSignInTokenCommandParameters baseSignInTokenCommandParameters = (BaseSignInTokenCommandParameters) obj;
        if (!baseSignInTokenCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        List<String> scopes = getScopes();
        List<String> scopes2 = baseSignInTokenCommandParameters.getScopes();
        if (scopes != null ? !scopes.equals(scopes2) : scopes2 != null) {
            return false;
        }
        String claimsRequestJson = getClaimsRequestJson();
        String claimsRequestJson2 = baseSignInTokenCommandParameters.getClaimsRequestJson();
        if (claimsRequestJson != null ? !claimsRequestJson.equals(claimsRequestJson2) : claimsRequestJson2 != null) {
            return false;
        }
        AbstractAuthenticationScheme authenticationScheme = getAuthenticationScheme();
        AbstractAuthenticationScheme authenticationScheme2 = baseSignInTokenCommandParameters.getAuthenticationScheme();
        return authenticationScheme != null ? authenticationScheme.equals(authenticationScheme2) : authenticationScheme2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        List<String> scopes = getScopes();
        int iHashCode2 = (iHashCode * 59) + (scopes == null ? 43 : scopes.hashCode());
        String claimsRequestJson = getClaimsRequestJson();
        int i = iHashCode2 * 59;
        int iHashCode3 = claimsRequestJson == null ? 43 : claimsRequestJson.hashCode();
        AbstractAuthenticationScheme authenticationScheme = getAuthenticationScheme();
        return ((i + iHashCode3) * 59) + (authenticationScheme != null ? authenticationScheme.hashCode() : 43);
    }

    protected BaseSignInTokenCommandParameters(BaseSignInTokenCommandParametersBuilder<?, ?> baseSignInTokenCommandParametersBuilder) {
        super(baseSignInTokenCommandParametersBuilder);
        this.scopes = ((BaseSignInTokenCommandParametersBuilder) baseSignInTokenCommandParametersBuilder).scopes;
        this.claimsRequestJson = ((BaseSignInTokenCommandParametersBuilder) baseSignInTokenCommandParametersBuilder).claimsRequestJson;
        this.authenticationScheme = ((BaseSignInTokenCommandParametersBuilder) baseSignInTokenCommandParametersBuilder).authenticationScheme;
    }

    public List<String> getScopes() {
        return this.scopes;
    }

    @Nullable
    public String getClaimsRequestJson() {
        return this.claimsRequestJson;
    }

    public AbstractAuthenticationScheme getAuthenticationScheme() {
        return this.authenticationScheme;
    }
}
