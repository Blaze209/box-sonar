package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import java.util.Arrays;

/* JADX INFO: loaded from: classes14.dex */
public class SignInSubmitPasswordCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "SignInSubmitCodeCommandParameters";
    public final String continuationToken;
    public final char[] password;

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof SignInSubmitPasswordCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInSubmitPasswordCommandParameters)) {
            return false;
        }
        SignInSubmitPasswordCommandParameters signInSubmitPasswordCommandParameters = (SignInSubmitPasswordCommandParameters) obj;
        if (!signInSubmitPasswordCommandParameters.canEqual(this) || !super.equals(obj) || !Arrays.equals(getPassword(), signInSubmitPasswordCommandParameters.getPassword())) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = signInSubmitPasswordCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = (super.hashCode() * 59) + Arrays.hashCode(getPassword());
        String continuationToken = getContinuationToken();
        return (iHashCode * 59) + (continuationToken == null ? 43 : continuationToken.hashCode());
    }

    public static abstract class SignInSubmitPasswordCommandParametersBuilder<C extends SignInSubmitPasswordCommandParameters, B extends SignInSubmitPasswordCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private String continuationToken;
        private char[] password;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(SignInSubmitPasswordCommandParameters signInSubmitPasswordCommandParameters, SignInSubmitPasswordCommandParametersBuilder<?, ?> signInSubmitPasswordCommandParametersBuilder) {
            signInSubmitPasswordCommandParametersBuilder.password(signInSubmitPasswordCommandParameters.password);
            signInSubmitPasswordCommandParametersBuilder.continuationToken(signInSubmitPasswordCommandParameters.continuationToken);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignInSubmitPasswordCommandParameters) c, (SignInSubmitPasswordCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B continuationToken(String str) {
            if (str == null) {
                throw new NullPointerException("continuationToken is marked non-null but is null");
            }
            this.continuationToken = str;
            return (B) self();
        }

        public B password(char[] cArr) {
            if (cArr == null) {
                throw new NullPointerException("password is marked non-null but is null");
            }
            this.password = cArr;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder(super=" + super.toString() + ", password=" + Arrays.toString(this.password) + ", continuationToken=" + this.continuationToken + ")";
        }
    }

    private static final class SignInSubmitPasswordCommandParametersBuilderImpl extends SignInSubmitPasswordCommandParametersBuilder<SignInSubmitPasswordCommandParameters, SignInSubmitPasswordCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInSubmitPasswordCommandParametersBuilderImpl self() {
            return this;
        }

        private SignInSubmitPasswordCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInSubmitPasswordCommandParameters build() {
            return new SignInSubmitPasswordCommandParameters(this);
        }
    }

    protected SignInSubmitPasswordCommandParameters(SignInSubmitPasswordCommandParametersBuilder<?, ?> signInSubmitPasswordCommandParametersBuilder) {
        super(signInSubmitPasswordCommandParametersBuilder);
        char[] cArr = ((SignInSubmitPasswordCommandParametersBuilder) signInSubmitPasswordCommandParametersBuilder).password;
        this.password = cArr;
        if (cArr == null) {
            throw new NullPointerException("password is marked non-null but is null");
        }
        String str = ((SignInSubmitPasswordCommandParametersBuilder) signInSubmitPasswordCommandParametersBuilder).continuationToken;
        this.continuationToken = str;
        if (str == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static SignInSubmitPasswordCommandParametersBuilder<?, ?> builder() {
        return new SignInSubmitPasswordCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignInSubmitPasswordCommandParametersBuilder<?, ?> toBuilder() {
        return new SignInSubmitPasswordCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public char[] getPassword() {
        return this.password;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignInSubmitPasswordCommandParameters(authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
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
