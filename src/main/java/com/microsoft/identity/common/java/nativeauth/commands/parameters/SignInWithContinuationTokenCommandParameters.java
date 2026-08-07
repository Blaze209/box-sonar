package com.microsoft.identity.common.java.nativeauth.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class SignInWithContinuationTokenCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "SignInWithContinuationTokenCommandParameters";
    public final String continuationToken;
    public final String username;

    public static abstract class SignInWithContinuationTokenCommandParametersBuilder<C extends SignInWithContinuationTokenCommandParameters, B extends SignInWithContinuationTokenCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private String continuationToken;
        private String username;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(SignInWithContinuationTokenCommandParameters signInWithContinuationTokenCommandParameters, SignInWithContinuationTokenCommandParametersBuilder<?, ?> signInWithContinuationTokenCommandParametersBuilder) {
            signInWithContinuationTokenCommandParametersBuilder.continuationToken(signInWithContinuationTokenCommandParameters.continuationToken);
            signInWithContinuationTokenCommandParametersBuilder.username(signInWithContinuationTokenCommandParameters.username);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignInWithContinuationTokenCommandParameters) c, (SignInWithContinuationTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B continuationToken(String str) {
            if (str == null) {
                throw new NullPointerException("continuationToken is marked non-null but is null");
            }
            this.continuationToken = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignInWithContinuationTokenCommandParameters.SignInWithContinuationTokenCommandParametersBuilder(super=" + super.toString() + ", continuationToken=" + this.continuationToken + ", username=" + this.username + ")";
        }

        public B username(String str) {
            this.username = str;
            return (B) self();
        }
    }

    private static final class SignInWithContinuationTokenCommandParametersBuilderImpl extends SignInWithContinuationTokenCommandParametersBuilder<SignInWithContinuationTokenCommandParameters, SignInWithContinuationTokenCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters.SignInWithContinuationTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInWithContinuationTokenCommandParametersBuilderImpl self() {
            return this;
        }

        private SignInWithContinuationTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters.SignInWithContinuationTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInWithContinuationTokenCommandParameters build() {
            return new SignInWithContinuationTokenCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof SignInWithContinuationTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInWithContinuationTokenCommandParameters)) {
            return false;
        }
        SignInWithContinuationTokenCommandParameters signInWithContinuationTokenCommandParameters = (SignInWithContinuationTokenCommandParameters) obj;
        if (!signInWithContinuationTokenCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = signInWithContinuationTokenCommandParameters.getContinuationToken();
        if (continuationToken != null ? !continuationToken.equals(continuationToken2) : continuationToken2 != null) {
            return false;
        }
        String username = getUsername();
        String username2 = signInWithContinuationTokenCommandParameters.getUsername();
        return username != null ? username.equals(username2) : username2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String continuationToken = getContinuationToken();
        int i = iHashCode * 59;
        int iHashCode2 = continuationToken == null ? 43 : continuationToken.hashCode();
        String username = getUsername();
        return ((i + iHashCode2) * 59) + (username != null ? username.hashCode() : 43);
    }

    protected SignInWithContinuationTokenCommandParameters(SignInWithContinuationTokenCommandParametersBuilder<?, ?> signInWithContinuationTokenCommandParametersBuilder) {
        super(signInWithContinuationTokenCommandParametersBuilder);
        String str = ((SignInWithContinuationTokenCommandParametersBuilder) signInWithContinuationTokenCommandParametersBuilder).continuationToken;
        this.continuationToken = str;
        if (str == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
        this.username = ((SignInWithContinuationTokenCommandParametersBuilder) signInWithContinuationTokenCommandParametersBuilder).username;
    }

    public static SignInWithContinuationTokenCommandParametersBuilder<?, ?> builder() {
        return new SignInWithContinuationTokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignInWithContinuationTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new SignInWithContinuationTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public String getUsername() {
        return this.username;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignInSubmitPasswordCommandParameters(username=" + this.username + ", authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return !toString().equals(toUnsanitizedString());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignInSubmitPasswordCommandParameters(authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }
}
