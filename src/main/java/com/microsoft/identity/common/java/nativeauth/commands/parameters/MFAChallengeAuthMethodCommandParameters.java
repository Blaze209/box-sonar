package com.microsoft.identity.common.java.nativeauth.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class MFAChallengeAuthMethodCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "MFAChallengeAuthMethodCommandParameters";
    public final String authMethodId;
    public final String continuationToken;

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof MFAChallengeAuthMethodCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MFAChallengeAuthMethodCommandParameters)) {
            return false;
        }
        MFAChallengeAuthMethodCommandParameters mFAChallengeAuthMethodCommandParameters = (MFAChallengeAuthMethodCommandParameters) obj;
        if (!mFAChallengeAuthMethodCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = mFAChallengeAuthMethodCommandParameters.getContinuationToken();
        if (continuationToken != null ? !continuationToken.equals(continuationToken2) : continuationToken2 != null) {
            return false;
        }
        String authMethodId = getAuthMethodId();
        String authMethodId2 = mFAChallengeAuthMethodCommandParameters.getAuthMethodId();
        return authMethodId != null ? authMethodId.equals(authMethodId2) : authMethodId2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String continuationToken = getContinuationToken();
        int i = iHashCode * 59;
        int iHashCode2 = continuationToken == null ? 43 : continuationToken.hashCode();
        String authMethodId = getAuthMethodId();
        return ((i + iHashCode2) * 59) + (authMethodId != null ? authMethodId.hashCode() : 43);
    }

    public static abstract class MFAChallengeAuthMethodCommandParametersBuilder<C extends MFAChallengeAuthMethodCommandParameters, B extends MFAChallengeAuthMethodCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private String authMethodId;
        private String continuationToken;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(MFAChallengeAuthMethodCommandParameters mFAChallengeAuthMethodCommandParameters, MFAChallengeAuthMethodCommandParametersBuilder<?, ?> mFAChallengeAuthMethodCommandParametersBuilder) {
            mFAChallengeAuthMethodCommandParametersBuilder.continuationToken(mFAChallengeAuthMethodCommandParameters.continuationToken);
            mFAChallengeAuthMethodCommandParametersBuilder.authMethodId(mFAChallengeAuthMethodCommandParameters.authMethodId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((MFAChallengeAuthMethodCommandParameters) c, (MFAChallengeAuthMethodCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B authMethodId(String str) {
            if (str == null) {
                throw new NullPointerException("authMethodId is marked non-null but is null");
            }
            this.authMethodId = str;
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
            return "MFAChallengeAuthMethodCommandParameters.MFAChallengeAuthMethodCommandParametersBuilder(super=" + super.toString() + ", continuationToken=" + this.continuationToken + ", authMethodId=" + this.authMethodId + ")";
        }
    }

    private static final class MFAChallengeAuthMethodCommandParametersBuilderImpl extends MFAChallengeAuthMethodCommandParametersBuilder<MFAChallengeAuthMethodCommandParameters, MFAChallengeAuthMethodCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.MFAChallengeAuthMethodCommandParameters.MFAChallengeAuthMethodCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public MFAChallengeAuthMethodCommandParametersBuilderImpl self() {
            return this;
        }

        private MFAChallengeAuthMethodCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.MFAChallengeAuthMethodCommandParameters.MFAChallengeAuthMethodCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public MFAChallengeAuthMethodCommandParameters build() {
            return new MFAChallengeAuthMethodCommandParameters(this);
        }
    }

    protected MFAChallengeAuthMethodCommandParameters(MFAChallengeAuthMethodCommandParametersBuilder<?, ?> mFAChallengeAuthMethodCommandParametersBuilder) {
        super(mFAChallengeAuthMethodCommandParametersBuilder);
        String str = ((MFAChallengeAuthMethodCommandParametersBuilder) mFAChallengeAuthMethodCommandParametersBuilder).continuationToken;
        this.continuationToken = str;
        if (str == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
        String str2 = ((MFAChallengeAuthMethodCommandParametersBuilder) mFAChallengeAuthMethodCommandParametersBuilder).authMethodId;
        this.authMethodId = str2;
        if (str2 == null) {
            throw new NullPointerException("authMethodId is marked non-null but is null");
        }
    }

    public static MFAChallengeAuthMethodCommandParametersBuilder<?, ?> builder() {
        return new MFAChallengeAuthMethodCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public MFAChallengeAuthMethodCommandParametersBuilder<?, ?> toBuilder() {
        return new MFAChallengeAuthMethodCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public String getAuthMethodId() {
        return this.authMethodId;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "MFAChallengeAuthMethodCommandParameters(authority=" + this.authority + ", challengeType=" + this.challengeType + ", authMethodId=" + this.authMethodId + ")";
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
