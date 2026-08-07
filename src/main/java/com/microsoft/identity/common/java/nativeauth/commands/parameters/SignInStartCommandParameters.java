package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public class SignInStartCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "SignInStartCommandParameters";

    @Nullable
    public final char[] password;
    public final String username;

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof SignInStartCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInStartCommandParameters)) {
            return false;
        }
        SignInStartCommandParameters signInStartCommandParameters = (SignInStartCommandParameters) obj;
        if (!signInStartCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String username = getUsername();
        String username2 = signInStartCommandParameters.getUsername();
        if (username != null ? username.equals(username2) : username2 == null) {
            return Arrays.equals(getPassword(), signInStartCommandParameters.getPassword());
        }
        return false;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String username = getUsername();
        return (((iHashCode * 59) + (username == null ? 43 : username.hashCode())) * 59) + Arrays.hashCode(getPassword());
    }

    public static abstract class SignInStartCommandParametersBuilder<C extends SignInStartCommandParameters, B extends SignInStartCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private char[] password;
        private String username;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(SignInStartCommandParameters signInStartCommandParameters, SignInStartCommandParametersBuilder<?, ?> signInStartCommandParametersBuilder) {
            signInStartCommandParametersBuilder.username(signInStartCommandParameters.username);
            signInStartCommandParametersBuilder.password(signInStartCommandParameters.password);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignInStartCommandParameters) c, (SignInStartCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B password(@Nullable char[] cArr) {
            this.password = cArr;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignInStartCommandParameters.SignInStartCommandParametersBuilder(super=" + super.toString() + ", username=" + this.username + ", password=" + Arrays.toString(this.password) + ")";
        }

        public B username(String str) {
            if (str == null) {
                throw new NullPointerException("username is marked non-null but is null");
            }
            this.username = str;
            return (B) self();
        }
    }

    private static final class SignInStartCommandParametersBuilderImpl extends SignInStartCommandParametersBuilder<SignInStartCommandParameters, SignInStartCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters.SignInStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInStartCommandParametersBuilderImpl self() {
            return this;
        }

        private SignInStartCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters.SignInStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInStartCommandParameters build() {
            return new SignInStartCommandParameters(this);
        }
    }

    protected SignInStartCommandParameters(SignInStartCommandParametersBuilder<?, ?> signInStartCommandParametersBuilder) {
        super(signInStartCommandParametersBuilder);
        String str = ((SignInStartCommandParametersBuilder) signInStartCommandParametersBuilder).username;
        this.username = str;
        if (str == null) {
            throw new NullPointerException("username is marked non-null but is null");
        }
        this.password = ((SignInStartCommandParametersBuilder) signInStartCommandParametersBuilder).password;
    }

    public static SignInStartCommandParametersBuilder<?, ?> builder() {
        return new SignInStartCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignInStartCommandParametersBuilder<?, ?> toBuilder() {
        return new SignInStartCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getUsername() {
        return this.username;
    }

    @Nullable
    public char[] getPassword() {
        return this.password;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignInStartCommandParameters(scopes=" + this.scopes + ", authenticationScheme=" + getAuthenticationScheme() + ", username=" + this.username + ", authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return !toString().equals(toUnsanitizedString());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignInStartCommandParameters(scopes=" + this.scopes + ", authenticationScheme=" + getAuthenticationScheme() + ", authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }
}
