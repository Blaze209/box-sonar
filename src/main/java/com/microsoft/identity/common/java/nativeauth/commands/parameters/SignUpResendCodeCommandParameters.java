package com.microsoft.identity.common.java.nativeauth.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class SignUpResendCodeCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "SignUpResendCodeCommandParameters";
    public final String continuationToken;

    public static abstract class SignUpResendCodeCommandParametersBuilder<C extends SignUpResendCodeCommandParameters, B extends SignUpResendCodeCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private String continuationToken;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(SignUpResendCodeCommandParameters signUpResendCodeCommandParameters, SignUpResendCodeCommandParametersBuilder<?, ?> signUpResendCodeCommandParametersBuilder) {
            signUpResendCodeCommandParametersBuilder.continuationToken(signUpResendCodeCommandParameters.continuationToken);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignUpResendCodeCommandParameters) c, (SignUpResendCodeCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B continuationToken(String str) {
            if (str == null) {
                throw new NullPointerException("continuationToken is marked non-null but is null");
            }
            this.continuationToken = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignUpResendCodeCommandParameters.SignUpResendCodeCommandParametersBuilder(super=" + super.toString() + ", continuationToken=" + this.continuationToken + ")";
        }
    }

    private static final class SignUpResendCodeCommandParametersBuilderImpl extends SignUpResendCodeCommandParametersBuilder<SignUpResendCodeCommandParameters, SignUpResendCodeCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpResendCodeCommandParameters.SignUpResendCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpResendCodeCommandParametersBuilderImpl self() {
            return this;
        }

        private SignUpResendCodeCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpResendCodeCommandParameters.SignUpResendCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpResendCodeCommandParameters build() {
            return new SignUpResendCodeCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof SignUpResendCodeCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignUpResendCodeCommandParameters)) {
            return false;
        }
        SignUpResendCodeCommandParameters signUpResendCodeCommandParameters = (SignUpResendCodeCommandParameters) obj;
        if (!signUpResendCodeCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = signUpResendCodeCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String continuationToken = getContinuationToken();
        return (iHashCode * 59) + (continuationToken == null ? 43 : continuationToken.hashCode());
    }

    protected SignUpResendCodeCommandParameters(SignUpResendCodeCommandParametersBuilder<?, ?> signUpResendCodeCommandParametersBuilder) {
        super(signUpResendCodeCommandParametersBuilder);
        String str = ((SignUpResendCodeCommandParametersBuilder) signUpResendCodeCommandParametersBuilder).continuationToken;
        this.continuationToken = str;
        if (str == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static SignUpResendCodeCommandParametersBuilder<?, ?> builder() {
        return new SignUpResendCodeCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignUpResendCodeCommandParametersBuilder<?, ?> toBuilder() {
        return new SignUpResendCodeCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignUpResendCodeCommandParameters(authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
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
