package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import java.util.Arrays;

/* JADX INFO: loaded from: classes14.dex */
public class ResetPasswordSubmitNewPasswordCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "ResetPasswordSubmitNewPasswordCommandParameters";
    public final String continuationToken;
    public final char[] newPassword;

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof ResetPasswordSubmitNewPasswordCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResetPasswordSubmitNewPasswordCommandParameters)) {
            return false;
        }
        ResetPasswordSubmitNewPasswordCommandParameters resetPasswordSubmitNewPasswordCommandParameters = (ResetPasswordSubmitNewPasswordCommandParameters) obj;
        if (!resetPasswordSubmitNewPasswordCommandParameters.canEqual(this) || !super.equals(obj) || !Arrays.equals(getNewPassword(), resetPasswordSubmitNewPasswordCommandParameters.getNewPassword())) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = resetPasswordSubmitNewPasswordCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = (super.hashCode() * 59) + Arrays.hashCode(getNewPassword());
        String continuationToken = getContinuationToken();
        return (iHashCode * 59) + (continuationToken == null ? 43 : continuationToken.hashCode());
    }

    public static abstract class ResetPasswordSubmitNewPasswordCommandParametersBuilder<C extends ResetPasswordSubmitNewPasswordCommandParameters, B extends ResetPasswordSubmitNewPasswordCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private String continuationToken;
        private char[] newPassword;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(ResetPasswordSubmitNewPasswordCommandParameters resetPasswordSubmitNewPasswordCommandParameters, ResetPasswordSubmitNewPasswordCommandParametersBuilder<?, ?> resetPasswordSubmitNewPasswordCommandParametersBuilder) {
            resetPasswordSubmitNewPasswordCommandParametersBuilder.newPassword(resetPasswordSubmitNewPasswordCommandParameters.newPassword);
            resetPasswordSubmitNewPasswordCommandParametersBuilder.continuationToken(resetPasswordSubmitNewPasswordCommandParameters.continuationToken);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((ResetPasswordSubmitNewPasswordCommandParameters) c, (ResetPasswordSubmitNewPasswordCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B continuationToken(String str) {
            if (str == null) {
                throw new NullPointerException("continuationToken is marked non-null but is null");
            }
            this.continuationToken = str;
            return (B) self();
        }

        public B newPassword(char[] cArr) {
            if (cArr == null) {
                throw new NullPointerException("newPassword is marked non-null but is null");
            }
            this.newPassword = cArr;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "ResetPasswordSubmitNewPasswordCommandParameters.ResetPasswordSubmitNewPasswordCommandParametersBuilder(super=" + super.toString() + ", newPassword=" + Arrays.toString(this.newPassword) + ", continuationToken=" + this.continuationToken + ")";
        }
    }

    private static final class ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl extends ResetPasswordSubmitNewPasswordCommandParametersBuilder<ResetPasswordSubmitNewPasswordCommandParameters, ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters.ResetPasswordSubmitNewPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl self() {
            return this;
        }

        private ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters.ResetPasswordSubmitNewPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordSubmitNewPasswordCommandParameters build() {
            return new ResetPasswordSubmitNewPasswordCommandParameters(this);
        }
    }

    protected ResetPasswordSubmitNewPasswordCommandParameters(ResetPasswordSubmitNewPasswordCommandParametersBuilder<?, ?> resetPasswordSubmitNewPasswordCommandParametersBuilder) {
        super(resetPasswordSubmitNewPasswordCommandParametersBuilder);
        char[] cArr = ((ResetPasswordSubmitNewPasswordCommandParametersBuilder) resetPasswordSubmitNewPasswordCommandParametersBuilder).newPassword;
        this.newPassword = cArr;
        if (cArr == null) {
            throw new NullPointerException("newPassword is marked non-null but is null");
        }
        String str = ((ResetPasswordSubmitNewPasswordCommandParametersBuilder) resetPasswordSubmitNewPasswordCommandParametersBuilder).continuationToken;
        this.continuationToken = str;
        if (str == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static ResetPasswordSubmitNewPasswordCommandParametersBuilder<?, ?> builder() {
        return new ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public ResetPasswordSubmitNewPasswordCommandParametersBuilder<?, ?> toBuilder() {
        return new ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public char[] getNewPassword() {
        return this.newPassword;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "ResetPasswordSubmitNewPasswordCommandParameters(authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
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
