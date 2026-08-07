package com.microsoft.identity.common.java.nativeauth.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class JITChallengeAuthMethodCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "JITChallengeAuthMethodCommandParameters";
    public final String authMethodChallengeType;
    public final String challengeChannel;
    public final String continuationToken;
    public final String verificationContact;

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof JITChallengeAuthMethodCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JITChallengeAuthMethodCommandParameters)) {
            return false;
        }
        JITChallengeAuthMethodCommandParameters jITChallengeAuthMethodCommandParameters = (JITChallengeAuthMethodCommandParameters) obj;
        if (!jITChallengeAuthMethodCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String verificationContact = getVerificationContact();
        String verificationContact2 = jITChallengeAuthMethodCommandParameters.getVerificationContact();
        if (verificationContact != null ? !verificationContact.equals(verificationContact2) : verificationContact2 != null) {
            return false;
        }
        String authMethodChallengeType = getAuthMethodChallengeType();
        String authMethodChallengeType2 = jITChallengeAuthMethodCommandParameters.getAuthMethodChallengeType();
        if (authMethodChallengeType != null ? !authMethodChallengeType.equals(authMethodChallengeType2) : authMethodChallengeType2 != null) {
            return false;
        }
        String challengeChannel = getChallengeChannel();
        String challengeChannel2 = jITChallengeAuthMethodCommandParameters.getChallengeChannel();
        if (challengeChannel != null ? !challengeChannel.equals(challengeChannel2) : challengeChannel2 != null) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = jITChallengeAuthMethodCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String verificationContact = getVerificationContact();
        int iHashCode2 = (iHashCode * 59) + (verificationContact == null ? 43 : verificationContact.hashCode());
        String authMethodChallengeType = getAuthMethodChallengeType();
        int iHashCode3 = (iHashCode2 * 59) + (authMethodChallengeType == null ? 43 : authMethodChallengeType.hashCode());
        String challengeChannel = getChallengeChannel();
        int i = iHashCode3 * 59;
        int iHashCode4 = challengeChannel == null ? 43 : challengeChannel.hashCode();
        String continuationToken = getContinuationToken();
        return ((i + iHashCode4) * 59) + (continuationToken != null ? continuationToken.hashCode() : 43);
    }

    public static abstract class JITChallengeAuthMethodCommandParametersBuilder<C extends JITChallengeAuthMethodCommandParameters, B extends JITChallengeAuthMethodCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private String authMethodChallengeType;
        private String challengeChannel;
        private String continuationToken;
        private String verificationContact;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(JITChallengeAuthMethodCommandParameters jITChallengeAuthMethodCommandParameters, JITChallengeAuthMethodCommandParametersBuilder<?, ?> jITChallengeAuthMethodCommandParametersBuilder) {
            jITChallengeAuthMethodCommandParametersBuilder.verificationContact(jITChallengeAuthMethodCommandParameters.verificationContact);
            jITChallengeAuthMethodCommandParametersBuilder.authMethodChallengeType(jITChallengeAuthMethodCommandParameters.authMethodChallengeType);
            jITChallengeAuthMethodCommandParametersBuilder.challengeChannel(jITChallengeAuthMethodCommandParameters.challengeChannel);
            jITChallengeAuthMethodCommandParametersBuilder.continuationToken(jITChallengeAuthMethodCommandParameters.continuationToken);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((JITChallengeAuthMethodCommandParameters) c, (JITChallengeAuthMethodCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B authMethodChallengeType(String str) {
            if (str == null) {
                throw new NullPointerException("authMethodChallengeType is marked non-null but is null");
            }
            this.authMethodChallengeType = str;
            return (B) self();
        }

        public B challengeChannel(String str) {
            if (str == null) {
                throw new NullPointerException("challengeChannel is marked non-null but is null");
            }
            this.challengeChannel = str;
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
            return "JITChallengeAuthMethodCommandParameters.JITChallengeAuthMethodCommandParametersBuilder(super=" + super.toString() + ", verificationContact=" + this.verificationContact + ", authMethodChallengeType=" + this.authMethodChallengeType + ", challengeChannel=" + this.challengeChannel + ", continuationToken=" + this.continuationToken + ")";
        }

        public B verificationContact(String str) {
            if (str == null) {
                throw new NullPointerException("verificationContact is marked non-null but is null");
            }
            this.verificationContact = str;
            return (B) self();
        }
    }

    private static final class JITChallengeAuthMethodCommandParametersBuilderImpl extends JITChallengeAuthMethodCommandParametersBuilder<JITChallengeAuthMethodCommandParameters, JITChallengeAuthMethodCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.JITChallengeAuthMethodCommandParameters.JITChallengeAuthMethodCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public JITChallengeAuthMethodCommandParametersBuilderImpl self() {
            return this;
        }

        private JITChallengeAuthMethodCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.JITChallengeAuthMethodCommandParameters.JITChallengeAuthMethodCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public JITChallengeAuthMethodCommandParameters build() {
            return new JITChallengeAuthMethodCommandParameters(this);
        }
    }

    protected JITChallengeAuthMethodCommandParameters(JITChallengeAuthMethodCommandParametersBuilder<?, ?> jITChallengeAuthMethodCommandParametersBuilder) {
        super(jITChallengeAuthMethodCommandParametersBuilder);
        String str = ((JITChallengeAuthMethodCommandParametersBuilder) jITChallengeAuthMethodCommandParametersBuilder).verificationContact;
        this.verificationContact = str;
        if (str == null) {
            throw new NullPointerException("verificationContact is marked non-null but is null");
        }
        String str2 = ((JITChallengeAuthMethodCommandParametersBuilder) jITChallengeAuthMethodCommandParametersBuilder).authMethodChallengeType;
        this.authMethodChallengeType = str2;
        if (str2 == null) {
            throw new NullPointerException("authMethodChallengeType is marked non-null but is null");
        }
        String str3 = ((JITChallengeAuthMethodCommandParametersBuilder) jITChallengeAuthMethodCommandParametersBuilder).challengeChannel;
        this.challengeChannel = str3;
        if (str3 == null) {
            throw new NullPointerException("challengeChannel is marked non-null but is null");
        }
        String str4 = ((JITChallengeAuthMethodCommandParametersBuilder) jITChallengeAuthMethodCommandParametersBuilder).continuationToken;
        this.continuationToken = str4;
        if (str4 == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static JITChallengeAuthMethodCommandParametersBuilder<?, ?> builder() {
        return new JITChallengeAuthMethodCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public JITChallengeAuthMethodCommandParametersBuilder<?, ?> toBuilder() {
        return new JITChallengeAuthMethodCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getVerificationContact() {
        return this.verificationContact;
    }

    public String getAuthMethodChallengeType() {
        return this.authMethodChallengeType;
    }

    public String getChallengeChannel() {
        return this.challengeChannel;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "JITChallengeAuthMethodCommandParameters(authority=" + this.authority + ", challengeType=" + this.challengeType + ")";
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
