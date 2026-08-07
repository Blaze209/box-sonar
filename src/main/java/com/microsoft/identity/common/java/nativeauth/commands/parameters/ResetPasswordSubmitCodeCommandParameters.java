package com.microsoft.identity.common.java.nativeauth.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class ResetPasswordSubmitCodeCommandParameters extends BaseNativeAuthCommandParameters {
    public final String code;
    public final String continuationToken;

    public static abstract class ResetPasswordSubmitCodeCommandParametersBuilder<C extends ResetPasswordSubmitCodeCommandParameters, B extends ResetPasswordSubmitCodeCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private String code;
        private String continuationToken;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(ResetPasswordSubmitCodeCommandParameters resetPasswordSubmitCodeCommandParameters, ResetPasswordSubmitCodeCommandParametersBuilder<?, ?> resetPasswordSubmitCodeCommandParametersBuilder) {
            resetPasswordSubmitCodeCommandParametersBuilder.code(resetPasswordSubmitCodeCommandParameters.code);
            resetPasswordSubmitCodeCommandParametersBuilder.continuationToken(resetPasswordSubmitCodeCommandParameters.continuationToken);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((ResetPasswordSubmitCodeCommandParameters) c, (ResetPasswordSubmitCodeCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B code(String str) {
            if (str == null) {
                throw new NullPointerException("code is marked non-null but is null");
            }
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

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "ResetPasswordSubmitCodeCommandParameters.ResetPasswordSubmitCodeCommandParametersBuilder(super=" + super.toString() + ", code=" + this.code + ", continuationToken=" + this.continuationToken + ")";
        }
    }

    private static final class ResetPasswordSubmitCodeCommandParametersBuilderImpl extends ResetPasswordSubmitCodeCommandParametersBuilder<ResetPasswordSubmitCodeCommandParameters, ResetPasswordSubmitCodeCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters.ResetPasswordSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordSubmitCodeCommandParametersBuilderImpl self() {
            return this;
        }

        private ResetPasswordSubmitCodeCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters.ResetPasswordSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordSubmitCodeCommandParameters build() {
            return new ResetPasswordSubmitCodeCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof ResetPasswordSubmitCodeCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResetPasswordSubmitCodeCommandParameters)) {
            return false;
        }
        ResetPasswordSubmitCodeCommandParameters resetPasswordSubmitCodeCommandParameters = (ResetPasswordSubmitCodeCommandParameters) obj;
        if (!resetPasswordSubmitCodeCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String code = getCode();
        String code2 = resetPasswordSubmitCodeCommandParameters.getCode();
        if (code != null ? !code.equals(code2) : code2 != null) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = resetPasswordSubmitCodeCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String code = getCode();
        int i = iHashCode * 59;
        int iHashCode2 = code == null ? 43 : code.hashCode();
        String continuationToken = getContinuationToken();
        return ((i + iHashCode2) * 59) + (continuationToken != null ? continuationToken.hashCode() : 43);
    }

    protected ResetPasswordSubmitCodeCommandParameters(ResetPasswordSubmitCodeCommandParametersBuilder<?, ?> resetPasswordSubmitCodeCommandParametersBuilder) {
        super(resetPasswordSubmitCodeCommandParametersBuilder);
        String str = ((ResetPasswordSubmitCodeCommandParametersBuilder) resetPasswordSubmitCodeCommandParametersBuilder).code;
        this.code = str;
        if (str == null) {
            throw new NullPointerException("code is marked non-null but is null");
        }
        String str2 = ((ResetPasswordSubmitCodeCommandParametersBuilder) resetPasswordSubmitCodeCommandParametersBuilder).continuationToken;
        this.continuationToken = str2;
        if (str2 == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static ResetPasswordSubmitCodeCommandParametersBuilder<?, ?> builder() {
        return new ResetPasswordSubmitCodeCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public ResetPasswordSubmitCodeCommandParametersBuilder<?, ?> toBuilder() {
        return new ResetPasswordSubmitCodeCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getCode() {
        return this.code;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "ResetPasswordSubmitCodeCommandParameters(authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
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
