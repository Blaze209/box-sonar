package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import java.util.Arrays;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public class SignUpStartCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "SignUpStartCommandParameters";

    @Nullable
    public final char[] password;

    @Nullable
    public final Map<String, String> userAttributes;
    public final String username;

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof SignUpStartCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignUpStartCommandParameters)) {
            return false;
        }
        SignUpStartCommandParameters signUpStartCommandParameters = (SignUpStartCommandParameters) obj;
        if (!signUpStartCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String username = getUsername();
        String username2 = signUpStartCommandParameters.getUsername();
        if (username != null ? username.equals(username2) : username2 == null) {
            return Arrays.equals(getPassword(), signUpStartCommandParameters.getPassword());
        }
        return false;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String username = getUsername();
        return (((iHashCode * 59) + (username == null ? 43 : username.hashCode())) * 59) + Arrays.hashCode(getPassword());
    }

    public static abstract class SignUpStartCommandParametersBuilder<C extends SignUpStartCommandParameters, B extends SignUpStartCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private char[] password;
        private Map<String, String> userAttributes;
        private String username;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(SignUpStartCommandParameters signUpStartCommandParameters, SignUpStartCommandParametersBuilder<?, ?> signUpStartCommandParametersBuilder) {
            signUpStartCommandParametersBuilder.username(signUpStartCommandParameters.username);
            signUpStartCommandParametersBuilder.userAttributes(signUpStartCommandParameters.userAttributes);
            signUpStartCommandParametersBuilder.password(signUpStartCommandParameters.password);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignUpStartCommandParameters) c, (SignUpStartCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B password(@Nullable char[] cArr) {
            this.password = cArr;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignUpStartCommandParameters.SignUpStartCommandParametersBuilder(super=" + super.toString() + ", username=" + this.username + ", userAttributes=" + this.userAttributes + ", password=" + Arrays.toString(this.password) + ")";
        }

        public B userAttributes(@Nullable Map<String, String> map) {
            this.userAttributes = map;
            return (B) self();
        }

        public B username(String str) {
            if (str == null) {
                throw new NullPointerException("username is marked non-null but is null");
            }
            this.username = str;
            return (B) self();
        }
    }

    private static final class SignUpStartCommandParametersBuilderImpl extends SignUpStartCommandParametersBuilder<SignUpStartCommandParameters, SignUpStartCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters.SignUpStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpStartCommandParametersBuilderImpl self() {
            return this;
        }

        private SignUpStartCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters.SignUpStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpStartCommandParameters build() {
            return new SignUpStartCommandParameters(this);
        }
    }

    protected SignUpStartCommandParameters(SignUpStartCommandParametersBuilder<?, ?> signUpStartCommandParametersBuilder) {
        super(signUpStartCommandParametersBuilder);
        String str = ((SignUpStartCommandParametersBuilder) signUpStartCommandParametersBuilder).username;
        this.username = str;
        if (str == null) {
            throw new NullPointerException("username is marked non-null but is null");
        }
        this.userAttributes = ((SignUpStartCommandParametersBuilder) signUpStartCommandParametersBuilder).userAttributes;
        this.password = ((SignUpStartCommandParametersBuilder) signUpStartCommandParametersBuilder).password;
    }

    public static SignUpStartCommandParametersBuilder<?, ?> builder() {
        return new SignUpStartCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignUpStartCommandParametersBuilder<?, ?> toBuilder() {
        return new SignUpStartCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getUsername() {
        return this.username;
    }

    @Nullable
    public Map<String, String> getUserAttributes() {
        return this.userAttributes;
    }

    @Nullable
    public char[] getPassword() {
        return this.password;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignUpStartCommandParameters(username=" + this.username + ", userAttributes=" + this.userAttributes + ", authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return !toString().equals(toUnsanitizedString());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignUpStartCommandParameters(authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }
}
