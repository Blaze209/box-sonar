package com.microsoft.identity.common.java.nativeauth.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class MFASubmitChallengeCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "MFASubmitChallengeCommandParameters";
    public final String challenge;
    public final String continuationToken;

    public static abstract class MFASubmitChallengeCommandParametersBuilder<C extends MFASubmitChallengeCommandParameters, B extends MFASubmitChallengeCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private String challenge;
        private String continuationToken;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(MFASubmitChallengeCommandParameters mFASubmitChallengeCommandParameters, MFASubmitChallengeCommandParametersBuilder<?, ?> mFASubmitChallengeCommandParametersBuilder) {
            mFASubmitChallengeCommandParametersBuilder.challenge(mFASubmitChallengeCommandParameters.challenge);
            mFASubmitChallengeCommandParametersBuilder.continuationToken(mFASubmitChallengeCommandParameters.continuationToken);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((MFASubmitChallengeCommandParameters) c, (MFASubmitChallengeCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B challenge(String str) {
            if (str == null) {
                throw new NullPointerException("challenge is marked non-null but is null");
            }
            this.challenge = str;
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
            return "MFASubmitChallengeCommandParameters.MFASubmitChallengeCommandParametersBuilder(super=" + super.toString() + ", challenge=" + this.challenge + ", continuationToken=" + this.continuationToken + ")";
        }
    }

    private static final class MFASubmitChallengeCommandParametersBuilderImpl extends MFASubmitChallengeCommandParametersBuilder<MFASubmitChallengeCommandParameters, MFASubmitChallengeCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.MFASubmitChallengeCommandParameters.MFASubmitChallengeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public MFASubmitChallengeCommandParametersBuilderImpl self() {
            return this;
        }

        private MFASubmitChallengeCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.MFASubmitChallengeCommandParameters.MFASubmitChallengeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public MFASubmitChallengeCommandParameters build() {
            return new MFASubmitChallengeCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof MFASubmitChallengeCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MFASubmitChallengeCommandParameters)) {
            return false;
        }
        MFASubmitChallengeCommandParameters mFASubmitChallengeCommandParameters = (MFASubmitChallengeCommandParameters) obj;
        if (!mFASubmitChallengeCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String challenge = getChallenge();
        String challenge2 = mFASubmitChallengeCommandParameters.getChallenge();
        if (challenge != null ? !challenge.equals(challenge2) : challenge2 != null) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = mFASubmitChallengeCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String challenge = getChallenge();
        int i = iHashCode * 59;
        int iHashCode2 = challenge == null ? 43 : challenge.hashCode();
        String continuationToken = getContinuationToken();
        return ((i + iHashCode2) * 59) + (continuationToken != null ? continuationToken.hashCode() : 43);
    }

    protected MFASubmitChallengeCommandParameters(MFASubmitChallengeCommandParametersBuilder<?, ?> mFASubmitChallengeCommandParametersBuilder) {
        super(mFASubmitChallengeCommandParametersBuilder);
        String str = ((MFASubmitChallengeCommandParametersBuilder) mFASubmitChallengeCommandParametersBuilder).challenge;
        this.challenge = str;
        if (str == null) {
            throw new NullPointerException("challenge is marked non-null but is null");
        }
        String str2 = ((MFASubmitChallengeCommandParametersBuilder) mFASubmitChallengeCommandParametersBuilder).continuationToken;
        this.continuationToken = str2;
        if (str2 == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static MFASubmitChallengeCommandParametersBuilder<?, ?> builder() {
        return new MFASubmitChallengeCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public MFASubmitChallengeCommandParametersBuilder<?, ?> toBuilder() {
        return new MFASubmitChallengeCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getChallenge() {
        return this.challenge;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "MFASubmitChallengeCommandParameters(authority=" + this.authority + ", challengeType=" + this.challengeType + ")";
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
