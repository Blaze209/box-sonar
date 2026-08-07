package com.microsoft.identity.common.java.nativeauth.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class ResetPasswordStartCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "ResetPasswordStartCommandParameters";
    public final String username;

    public static abstract class ResetPasswordStartCommandParametersBuilder<C extends ResetPasswordStartCommandParameters, B extends ResetPasswordStartCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private String username;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(ResetPasswordStartCommandParameters resetPasswordStartCommandParameters, ResetPasswordStartCommandParametersBuilder<?, ?> resetPasswordStartCommandParametersBuilder) {
            resetPasswordStartCommandParametersBuilder.username(resetPasswordStartCommandParameters.username);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((ResetPasswordStartCommandParameters) c, (ResetPasswordStartCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "ResetPasswordStartCommandParameters.ResetPasswordStartCommandParametersBuilder(super=" + super.toString() + ", username=" + this.username + ")";
        }

        public B username(String str) {
            if (str == null) {
                throw new NullPointerException("username is marked non-null but is null");
            }
            this.username = str;
            return (B) self();
        }
    }

    private static final class ResetPasswordStartCommandParametersBuilderImpl extends ResetPasswordStartCommandParametersBuilder<ResetPasswordStartCommandParameters, ResetPasswordStartCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters.ResetPasswordStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordStartCommandParametersBuilderImpl self() {
            return this;
        }

        private ResetPasswordStartCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters.ResetPasswordStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordStartCommandParameters build() {
            return new ResetPasswordStartCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof ResetPasswordStartCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResetPasswordStartCommandParameters)) {
            return false;
        }
        ResetPasswordStartCommandParameters resetPasswordStartCommandParameters = (ResetPasswordStartCommandParameters) obj;
        if (!resetPasswordStartCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String username = getUsername();
        String username2 = resetPasswordStartCommandParameters.getUsername();
        return username != null ? username.equals(username2) : username2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String username = getUsername();
        return (iHashCode * 59) + (username == null ? 43 : username.hashCode());
    }

    protected ResetPasswordStartCommandParameters(ResetPasswordStartCommandParametersBuilder<?, ?> resetPasswordStartCommandParametersBuilder) {
        super(resetPasswordStartCommandParametersBuilder);
        String str = ((ResetPasswordStartCommandParametersBuilder) resetPasswordStartCommandParametersBuilder).username;
        this.username = str;
        if (str == null) {
            throw new NullPointerException("username is marked non-null but is null");
        }
    }

    public static ResetPasswordStartCommandParametersBuilder<?, ?> builder() {
        return new ResetPasswordStartCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public ResetPasswordStartCommandParametersBuilder<?, ?> toBuilder() {
        return new ResetPasswordStartCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getUsername() {
        return this.username;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "ResetPasswordStartCommandParameters(username=" + this.username + ", authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return !toString().equals(toUnsanitizedString());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "ResetPasswordStartCommandParameters(authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }
}
