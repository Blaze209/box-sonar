package com.microsoft.identity.common.java.nativeauth.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class JITContinueCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "JITContinueCommandParameters";
    public final String code;
    public final String continuationToken;
    public final String grantType;

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof JITContinueCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JITContinueCommandParameters)) {
            return false;
        }
        JITContinueCommandParameters jITContinueCommandParameters = (JITContinueCommandParameters) obj;
        if (!jITContinueCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String code = getCode();
        String code2 = jITContinueCommandParameters.getCode();
        if (code != null ? !code.equals(code2) : code2 != null) {
            return false;
        }
        String grantType = getGrantType();
        String grantType2 = jITContinueCommandParameters.getGrantType();
        if (grantType != null ? !grantType.equals(grantType2) : grantType2 != null) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = jITContinueCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String code = getCode();
        int iHashCode2 = (iHashCode * 59) + (code == null ? 43 : code.hashCode());
        String grantType = getGrantType();
        int i = iHashCode2 * 59;
        int iHashCode3 = grantType == null ? 43 : grantType.hashCode();
        String continuationToken = getContinuationToken();
        return ((i + iHashCode3) * 59) + (continuationToken != null ? continuationToken.hashCode() : 43);
    }

    public static abstract class JITContinueCommandParametersBuilder<C extends JITContinueCommandParameters, B extends JITContinueCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private String code;
        private String continuationToken;
        private String grantType;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(JITContinueCommandParameters jITContinueCommandParameters, JITContinueCommandParametersBuilder<?, ?> jITContinueCommandParametersBuilder) {
            jITContinueCommandParametersBuilder.code(jITContinueCommandParameters.code);
            jITContinueCommandParametersBuilder.grantType(jITContinueCommandParameters.grantType);
            jITContinueCommandParametersBuilder.continuationToken(jITContinueCommandParameters.continuationToken);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((JITContinueCommandParameters) c, (JITContinueCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B code(String str) {
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

        public B grantType(String str) {
            if (str == null) {
                throw new NullPointerException("grantType is marked non-null but is null");
            }
            this.grantType = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "JITContinueCommandParameters.JITContinueCommandParametersBuilder(super=" + super.toString() + ", code=" + this.code + ", grantType=" + this.grantType + ", continuationToken=" + this.continuationToken + ")";
        }
    }

    private static final class JITContinueCommandParametersBuilderImpl extends JITContinueCommandParametersBuilder<JITContinueCommandParameters, JITContinueCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.JITContinueCommandParameters.JITContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public JITContinueCommandParametersBuilderImpl self() {
            return this;
        }

        private JITContinueCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.JITContinueCommandParameters.JITContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public JITContinueCommandParameters build() {
            return new JITContinueCommandParameters(this);
        }
    }

    protected JITContinueCommandParameters(JITContinueCommandParametersBuilder<?, ?> jITContinueCommandParametersBuilder) {
        super(jITContinueCommandParametersBuilder);
        this.code = ((JITContinueCommandParametersBuilder) jITContinueCommandParametersBuilder).code;
        String str = ((JITContinueCommandParametersBuilder) jITContinueCommandParametersBuilder).grantType;
        this.grantType = str;
        if (str == null) {
            throw new NullPointerException("grantType is marked non-null but is null");
        }
        String str2 = ((JITContinueCommandParametersBuilder) jITContinueCommandParametersBuilder).continuationToken;
        this.continuationToken = str2;
        if (str2 == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static JITContinueCommandParametersBuilder<?, ?> builder() {
        return new JITContinueCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public JITContinueCommandParametersBuilder<?, ?> toBuilder() {
        return new JITContinueCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getCode() {
        return this.code;
    }

    public String getGrantType() {
        return this.grantType;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "JITSubmitChallengeCommandParameters(authority=" + this.authority + ", grantType=" + this.grantType + ")";
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
