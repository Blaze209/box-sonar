package com.microsoft.identity.common.java.nativeauth.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class SignUpSubmitCodeCommandParameters extends SignUpContinueCommandParameters {
    private static final String TAG = "SignUpSubmitCodeCommandParameters";
    public final String code;

    public static abstract class SignUpSubmitCodeCommandParametersBuilder<C extends SignUpSubmitCodeCommandParameters, B extends SignUpSubmitCodeCommandParametersBuilder<C, B>> extends SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder<C, B> {
        private String code;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(SignUpSubmitCodeCommandParameters signUpSubmitCodeCommandParameters, SignUpSubmitCodeCommandParametersBuilder<?, ?> signUpSubmitCodeCommandParametersBuilder) {
            signUpSubmitCodeCommandParametersBuilder.code(signUpSubmitCodeCommandParameters.code);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignUpSubmitCodeCommandParameters) c, (SignUpSubmitCodeCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B code(String str) {
            if (str == null) {
                throw new NullPointerException("code is marked non-null but is null");
            }
            this.code = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignUpSubmitCodeCommandParameters.SignUpSubmitCodeCommandParametersBuilder(super=" + super.toString() + ", code=" + this.code + ")";
        }
    }

    private static final class SignUpSubmitCodeCommandParametersBuilderImpl extends SignUpSubmitCodeCommandParametersBuilder<SignUpSubmitCodeCommandParameters, SignUpSubmitCodeCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters.SignUpSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitCodeCommandParametersBuilderImpl self() {
            return this;
        }

        private SignUpSubmitCodeCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters.SignUpSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitCodeCommandParameters build() {
            return new SignUpSubmitCodeCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof SignUpSubmitCodeCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignUpSubmitCodeCommandParameters)) {
            return false;
        }
        SignUpSubmitCodeCommandParameters signUpSubmitCodeCommandParameters = (SignUpSubmitCodeCommandParameters) obj;
        if (!signUpSubmitCodeCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String code = getCode();
        String code2 = signUpSubmitCodeCommandParameters.getCode();
        return code != null ? code.equals(code2) : code2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String code = getCode();
        return (iHashCode * 59) + (code == null ? 43 : code.hashCode());
    }

    protected SignUpSubmitCodeCommandParameters(SignUpSubmitCodeCommandParametersBuilder<?, ?> signUpSubmitCodeCommandParametersBuilder) {
        super(signUpSubmitCodeCommandParametersBuilder);
        String str = ((SignUpSubmitCodeCommandParametersBuilder) signUpSubmitCodeCommandParametersBuilder).code;
        this.code = str;
        if (str == null) {
            throw new NullPointerException("code is marked non-null but is null");
        }
    }

    public static SignUpSubmitCodeCommandParametersBuilder<?, ?> builder() {
        return new SignUpSubmitCodeCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignUpSubmitCodeCommandParametersBuilder<?, ?> toBuilder() {
        return new SignUpSubmitCodeCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getCode() {
        return this.code;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignUpSubmitCodeCommandParameters(authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
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
