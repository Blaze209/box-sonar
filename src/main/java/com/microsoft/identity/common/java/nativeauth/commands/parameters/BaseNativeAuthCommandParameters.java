package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.authorities.NativeAuthCIAMAuthority;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BaseNativeAuthCommandParameters extends CommandParameters implements ILoggable {
    private static final String TAG = "BaseNativeAuthCommandParameters";
    public final NativeAuthCIAMAuthority authority;

    @Nullable
    public final List<String> capabilities;

    @Nullable
    public final List<String> challengeType;

    public static abstract class BaseNativeAuthCommandParametersBuilder<C extends BaseNativeAuthCommandParameters, B extends BaseNativeAuthCommandParametersBuilder<C, B>> extends CommandParameters.CommandParametersBuilder<C, B> {
        private NativeAuthCIAMAuthority authority;
        private List<String> capabilities;
        private List<String> challengeType;

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(BaseNativeAuthCommandParameters baseNativeAuthCommandParameters, BaseNativeAuthCommandParametersBuilder<?, ?> baseNativeAuthCommandParametersBuilder) {
            baseNativeAuthCommandParametersBuilder.authority(baseNativeAuthCommandParameters.authority);
            baseNativeAuthCommandParametersBuilder.challengeType(baseNativeAuthCommandParameters.challengeType);
            baseNativeAuthCommandParametersBuilder.capabilities(baseNativeAuthCommandParameters.capabilities);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((BaseNativeAuthCommandParameters) c, (BaseNativeAuthCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B authority(NativeAuthCIAMAuthority nativeAuthCIAMAuthority) {
            this.authority = nativeAuthCIAMAuthority;
            return (B) self();
        }

        public B capabilities(@Nullable List<String> list) {
            this.capabilities = list;
            return (B) self();
        }

        public B challengeType(@Nullable List<String> list) {
            this.challengeType = list;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder(super=" + super.toString() + ", authority=" + this.authority + ", challengeType=" + this.challengeType + ", capabilities=" + this.capabilities + ")";
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof BaseNativeAuthCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseNativeAuthCommandParameters)) {
            return false;
        }
        BaseNativeAuthCommandParameters baseNativeAuthCommandParameters = (BaseNativeAuthCommandParameters) obj;
        if (!baseNativeAuthCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        NativeAuthCIAMAuthority authority = getAuthority();
        NativeAuthCIAMAuthority authority2 = baseNativeAuthCommandParameters.getAuthority();
        if (authority != null ? !authority.equals(authority2) : authority2 != null) {
            return false;
        }
        List<String> challengeType = getChallengeType();
        List<String> challengeType2 = baseNativeAuthCommandParameters.getChallengeType();
        if (challengeType != null ? !challengeType.equals(challengeType2) : challengeType2 != null) {
            return false;
        }
        List<String> capabilities = getCapabilities();
        List<String> capabilities2 = baseNativeAuthCommandParameters.getCapabilities();
        return capabilities != null ? capabilities.equals(capabilities2) : capabilities2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        NativeAuthCIAMAuthority authority = getAuthority();
        int iHashCode2 = (iHashCode * 59) + (authority == null ? 43 : authority.hashCode());
        List<String> challengeType = getChallengeType();
        int i = iHashCode2 * 59;
        int iHashCode3 = challengeType == null ? 43 : challengeType.hashCode();
        List<String> capabilities = getCapabilities();
        return ((i + iHashCode3) * 59) + (capabilities != null ? capabilities.hashCode() : 43);
    }

    protected BaseNativeAuthCommandParameters(BaseNativeAuthCommandParametersBuilder<?, ?> baseNativeAuthCommandParametersBuilder) {
        super(baseNativeAuthCommandParametersBuilder);
        this.authority = ((BaseNativeAuthCommandParametersBuilder) baseNativeAuthCommandParametersBuilder).authority;
        this.challengeType = ((BaseNativeAuthCommandParametersBuilder) baseNativeAuthCommandParametersBuilder).challengeType;
        this.capabilities = ((BaseNativeAuthCommandParametersBuilder) baseNativeAuthCommandParametersBuilder).capabilities;
    }

    public NativeAuthCIAMAuthority getAuthority() {
        return this.authority;
    }

    @Nullable
    public List<String> getChallengeType() {
        return this.challengeType;
    }

    @Nullable
    public List<String> getCapabilities() {
        return this.capabilities;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public void logParameters(String str, String str2) {
        Logger.infoWithObject(str, null, str2, this);
    }
}
