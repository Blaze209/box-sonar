package com.microsoft.identity.common.java.nativeauth.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class JITIntrospectCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "JITIntrospectCommandParameters";
    public final String continuationToken;

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof JITIntrospectCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JITIntrospectCommandParameters)) {
            return false;
        }
        JITIntrospectCommandParameters jITIntrospectCommandParameters = (JITIntrospectCommandParameters) obj;
        if (!jITIntrospectCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = jITIntrospectCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String continuationToken = getContinuationToken();
        return (iHashCode * 59) + (continuationToken == null ? 43 : continuationToken.hashCode());
    }

    public static abstract class JITIntrospectCommandParametersBuilder<C extends JITIntrospectCommandParameters, B extends JITIntrospectCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private String continuationToken;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(JITIntrospectCommandParameters jITIntrospectCommandParameters, JITIntrospectCommandParametersBuilder<?, ?> jITIntrospectCommandParametersBuilder) {
            jITIntrospectCommandParametersBuilder.continuationToken(jITIntrospectCommandParameters.continuationToken);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((JITIntrospectCommandParameters) c, (JITIntrospectCommandParametersBuilder<?, ?>) this);
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
            return "JITIntrospectCommandParameters.JITIntrospectCommandParametersBuilder(super=" + super.toString() + ", continuationToken=" + this.continuationToken + ")";
        }
    }

    private static final class JITIntrospectCommandParametersBuilderImpl extends JITIntrospectCommandParametersBuilder<JITIntrospectCommandParameters, JITIntrospectCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.JITIntrospectCommandParameters.JITIntrospectCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public JITIntrospectCommandParametersBuilderImpl self() {
            return this;
        }

        private JITIntrospectCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.JITIntrospectCommandParameters.JITIntrospectCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public JITIntrospectCommandParameters build() {
            return new JITIntrospectCommandParameters(this);
        }
    }

    protected JITIntrospectCommandParameters(JITIntrospectCommandParametersBuilder<?, ?> jITIntrospectCommandParametersBuilder) {
        super(jITIntrospectCommandParametersBuilder);
        String str = ((JITIntrospectCommandParametersBuilder) jITIntrospectCommandParametersBuilder).continuationToken;
        this.continuationToken = str;
        if (str == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static JITIntrospectCommandParametersBuilder<?, ?> builder() {
        return new JITIntrospectCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public JITIntrospectCommandParametersBuilder<?, ?> toBuilder() {
        return new JITIntrospectCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "JITChallengeAuthMethodCommandParameters()";
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
