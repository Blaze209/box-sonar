package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class SignUpSubmitUserAttributesCommandParameters extends SignUpContinueCommandParameters {
    private static final String TAG = "SignUpSubmitUserAttributesCommandParameters";
    public final Map<String, String> userAttributes;

    public static abstract class SignUpSubmitUserAttributesCommandParametersBuilder<C extends SignUpSubmitUserAttributesCommandParameters, B extends SignUpSubmitUserAttributesCommandParametersBuilder<C, B>> extends SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder<C, B> {
        private Map<String, String> userAttributes;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(SignUpSubmitUserAttributesCommandParameters signUpSubmitUserAttributesCommandParameters, SignUpSubmitUserAttributesCommandParametersBuilder<?, ?> signUpSubmitUserAttributesCommandParametersBuilder) {
            signUpSubmitUserAttributesCommandParametersBuilder.userAttributes(signUpSubmitUserAttributesCommandParameters.userAttributes);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignUpSubmitUserAttributesCommandParameters) c, (SignUpSubmitUserAttributesCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignUpSubmitUserAttributesCommandParameters.SignUpSubmitUserAttributesCommandParametersBuilder(super=" + super.toString() + ", userAttributes=" + this.userAttributes + ")";
        }

        public B userAttributes(Map<String, String> map) {
            if (map == null) {
                throw new NullPointerException("userAttributes is marked non-null but is null");
            }
            this.userAttributes = map;
            return (B) self();
        }
    }

    private static final class SignUpSubmitUserAttributesCommandParametersBuilderImpl extends SignUpSubmitUserAttributesCommandParametersBuilder<SignUpSubmitUserAttributesCommandParameters, SignUpSubmitUserAttributesCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters.SignUpSubmitUserAttributesCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitUserAttributesCommandParametersBuilderImpl self() {
            return this;
        }

        private SignUpSubmitUserAttributesCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters.SignUpSubmitUserAttributesCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitUserAttributesCommandParameters build() {
            return new SignUpSubmitUserAttributesCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof SignUpSubmitUserAttributesCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignUpSubmitUserAttributesCommandParameters)) {
            return false;
        }
        SignUpSubmitUserAttributesCommandParameters signUpSubmitUserAttributesCommandParameters = (SignUpSubmitUserAttributesCommandParameters) obj;
        if (!signUpSubmitUserAttributesCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        Map<String, String> userAttributes = getUserAttributes();
        Map<String, String> userAttributes2 = signUpSubmitUserAttributesCommandParameters.getUserAttributes();
        return userAttributes != null ? userAttributes.equals(userAttributes2) : userAttributes2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        Map<String, String> userAttributes = getUserAttributes();
        return (iHashCode * 59) + (userAttributes == null ? 43 : userAttributes.hashCode());
    }

    protected SignUpSubmitUserAttributesCommandParameters(SignUpSubmitUserAttributesCommandParametersBuilder<?, ?> signUpSubmitUserAttributesCommandParametersBuilder) {
        super(signUpSubmitUserAttributesCommandParametersBuilder);
        Map<String, String> map = ((SignUpSubmitUserAttributesCommandParametersBuilder) signUpSubmitUserAttributesCommandParametersBuilder).userAttributes;
        this.userAttributes = map;
        if (map == null) {
            throw new NullPointerException("userAttributes is marked non-null but is null");
        }
    }

    public static SignUpSubmitUserAttributesCommandParametersBuilder<?, ?> builder() {
        return new SignUpSubmitUserAttributesCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignUpSubmitUserAttributesCommandParametersBuilder<?, ?> toBuilder() {
        return new SignUpSubmitUserAttributesCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public Map<String, String> getUserAttributes() {
        return this.userAttributes;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignUpSubmitUserAttributesCommandParameters(userAttributes=" + this.userAttributes + ", authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return !toString().equals(toUnsanitizedString());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignUpSubmitUserAttributesCommandParameters(authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }
}
