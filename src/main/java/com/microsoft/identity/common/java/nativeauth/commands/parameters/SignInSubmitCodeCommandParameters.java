package com.microsoft.identity.common.java.nativeauth.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class SignInSubmitCodeCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "SignInSubmitCodeCommandParameters";
    public final String code;
    public final String continuationToken;
    public final Boolean isMFAGrantType;

    public static abstract class SignInSubmitCodeCommandParametersBuilder<C extends SignInSubmitCodeCommandParameters, B extends SignInSubmitCodeCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private String code;
        private String continuationToken;
        private Boolean isMFAGrantType;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(SignInSubmitCodeCommandParameters signInSubmitCodeCommandParameters, SignInSubmitCodeCommandParametersBuilder<?, ?> signInSubmitCodeCommandParametersBuilder) {
            signInSubmitCodeCommandParametersBuilder.isMFAGrantType(signInSubmitCodeCommandParameters.isMFAGrantType);
            signInSubmitCodeCommandParametersBuilder.code(signInSubmitCodeCommandParameters.code);
            signInSubmitCodeCommandParametersBuilder.continuationToken(signInSubmitCodeCommandParameters.continuationToken);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignInSubmitCodeCommandParameters) c, (SignInSubmitCodeCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B code(String str) {
            if (str == null) {
                throw new NullPointerException("code is marked non-null but is null");
            }
            this.code = str;
            return (B) self();
        }

        public B continuationToken(String str) {
            if (str == null) {
                throw new NullPointerException("continuationToken is marked non-null but is null");
            }
            this.continuationToken = str;
            return (B) self();
        }

        public B isMFAGrantType(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("isMFAGrantType is marked non-null but is null");
            }
            this.isMFAGrantType = bool;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignInSubmitCodeCommandParameters.SignInSubmitCodeCommandParametersBuilder(super=" + super.toString() + ", isMFAGrantType=" + this.isMFAGrantType + ", code=" + this.code + ", continuationToken=" + this.continuationToken + ")";
        }
    }

    private static final class SignInSubmitCodeCommandParametersBuilderImpl extends SignInSubmitCodeCommandParametersBuilder<SignInSubmitCodeCommandParameters, SignInSubmitCodeCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters.SignInSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInSubmitCodeCommandParametersBuilderImpl self() {
            return this;
        }

        private SignInSubmitCodeCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters.SignInSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInSubmitCodeCommandParameters build() {
            return new SignInSubmitCodeCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof SignInSubmitCodeCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInSubmitCodeCommandParameters)) {
            return false;
        }
        SignInSubmitCodeCommandParameters signInSubmitCodeCommandParameters = (SignInSubmitCodeCommandParameters) obj;
        if (!signInSubmitCodeCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        Boolean isMFAGrantType = getIsMFAGrantType();
        Boolean isMFAGrantType2 = signInSubmitCodeCommandParameters.getIsMFAGrantType();
        if (isMFAGrantType != null ? !isMFAGrantType.equals(isMFAGrantType2) : isMFAGrantType2 != null) {
            return false;
        }
        String code = getCode();
        String code2 = signInSubmitCodeCommandParameters.getCode();
        if (code != null ? !code.equals(code2) : code2 != null) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = signInSubmitCodeCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        Boolean isMFAGrantType = getIsMFAGrantType();
        int iHashCode2 = (iHashCode * 59) + (isMFAGrantType == null ? 43 : isMFAGrantType.hashCode());
        String code = getCode();
        int i = iHashCode2 * 59;
        int iHashCode3 = code == null ? 43 : code.hashCode();
        String continuationToken = getContinuationToken();
        return ((i + iHashCode3) * 59) + (continuationToken != null ? continuationToken.hashCode() : 43);
    }

    protected SignInSubmitCodeCommandParameters(SignInSubmitCodeCommandParametersBuilder<?, ?> signInSubmitCodeCommandParametersBuilder) {
        super(signInSubmitCodeCommandParametersBuilder);
        Boolean bool = ((SignInSubmitCodeCommandParametersBuilder) signInSubmitCodeCommandParametersBuilder).isMFAGrantType;
        this.isMFAGrantType = bool;
        if (bool == null) {
            throw new NullPointerException("isMFAGrantType is marked non-null but is null");
        }
        String str = ((SignInSubmitCodeCommandParametersBuilder) signInSubmitCodeCommandParametersBuilder).code;
        this.code = str;
        if (str == null) {
            throw new NullPointerException("code is marked non-null but is null");
        }
        String str2 = ((SignInSubmitCodeCommandParametersBuilder) signInSubmitCodeCommandParametersBuilder).continuationToken;
        this.continuationToken = str2;
        if (str2 == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static SignInSubmitCodeCommandParametersBuilder<?, ?> builder() {
        return new SignInSubmitCodeCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignInSubmitCodeCommandParametersBuilder<?, ?> toBuilder() {
        return new SignInSubmitCodeCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public Boolean getIsMFAGrantType() {
        return this.isMFAGrantType;
    }

    public String getCode() {
        return this.code;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignInSubmitCodeCommandParameters(authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return !toString().equals(toUnsanitizedString());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return toUnsanitizedString();
    }
}
