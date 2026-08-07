package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import java.util.Arrays;

/* JADX INFO: loaded from: classes14.dex */
public class SignUpSubmitPasswordCommandParameters extends SignUpContinueCommandParameters {
    private static final String TAG = "SignUpSubmitPasswordCommandParameters";
    public final char[] password;

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof SignUpSubmitPasswordCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignUpSubmitPasswordCommandParameters)) {
            return false;
        }
        SignUpSubmitPasswordCommandParameters signUpSubmitPasswordCommandParameters = (SignUpSubmitPasswordCommandParameters) obj;
        return signUpSubmitPasswordCommandParameters.canEqual(this) && super.equals(obj) && Arrays.equals(getPassword(), signUpSubmitPasswordCommandParameters.getPassword());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        return (super.hashCode() * 59) + Arrays.hashCode(getPassword());
    }

    public static abstract class SignUpSubmitPasswordCommandParametersBuilder<C extends SignUpSubmitPasswordCommandParameters, B extends SignUpSubmitPasswordCommandParametersBuilder<C, B>> extends SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder<C, B> {
        private char[] password;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(SignUpSubmitPasswordCommandParameters signUpSubmitPasswordCommandParameters, SignUpSubmitPasswordCommandParametersBuilder<?, ?> signUpSubmitPasswordCommandParametersBuilder) {
            signUpSubmitPasswordCommandParametersBuilder.password(signUpSubmitPasswordCommandParameters.password);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignUpSubmitPasswordCommandParameters) c, (SignUpSubmitPasswordCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B password(char[] cArr) {
            if (cArr == null) {
                throw new NullPointerException("password is marked non-null but is null");
            }
            this.password = cArr;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignUpSubmitPasswordCommandParameters.SignUpSubmitPasswordCommandParametersBuilder(super=" + super.toString() + ", password=" + Arrays.toString(this.password) + ")";
        }
    }

    private static final class SignUpSubmitPasswordCommandParametersBuilderImpl extends SignUpSubmitPasswordCommandParametersBuilder<SignUpSubmitPasswordCommandParameters, SignUpSubmitPasswordCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitPasswordCommandParameters.SignUpSubmitPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitPasswordCommandParametersBuilderImpl self() {
            return this;
        }

        private SignUpSubmitPasswordCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitPasswordCommandParameters.SignUpSubmitPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitPasswordCommandParameters build() {
            return new SignUpSubmitPasswordCommandParameters(this);
        }
    }

    protected SignUpSubmitPasswordCommandParameters(SignUpSubmitPasswordCommandParametersBuilder<?, ?> signUpSubmitPasswordCommandParametersBuilder) {
        super(signUpSubmitPasswordCommandParametersBuilder);
        char[] cArr = ((SignUpSubmitPasswordCommandParametersBuilder) signUpSubmitPasswordCommandParametersBuilder).password;
        this.password = cArr;
        if (cArr == null) {
            throw new NullPointerException("password is marked non-null but is null");
        }
    }

    public static SignUpSubmitPasswordCommandParametersBuilder<?, ?> builder() {
        return new SignUpSubmitPasswordCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignUpSubmitPasswordCommandParametersBuilder<?, ?> toBuilder() {
        return new SignUpSubmitPasswordCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public char[] getPassword() {
        return this.password;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignUpSubmitPasswordCommandParameters(authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return !toString().equals(toUnsanitizedString());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return toUnsanitizedString();
    }
}
