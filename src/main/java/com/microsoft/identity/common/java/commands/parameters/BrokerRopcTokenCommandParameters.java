package com.microsoft.identity.common.java.commands.parameters;

import com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.util.StringUtil;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerRopcTokenCommandParameters extends RopcTokenCommandParameters {
    private final String brokerVersion;
    private final String callerAppVersion;
    private final String callerPackageName;
    private final int callerUid;
    private final String negotiatedBrokerProtocolVersion;

    public static abstract class BrokerRopcTokenCommandParametersBuilder<C extends BrokerRopcTokenCommandParameters, B extends BrokerRopcTokenCommandParametersBuilder<C, B>> extends RopcTokenCommandParameters.RopcTokenCommandParametersBuilder<C, B> {
        private String brokerVersion;
        private String callerAppVersion;
        private String callerPackageName;
        private int callerUid;
        private String negotiatedBrokerProtocolVersion;

        @Override // com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters.RopcTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters.RopcTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(BrokerRopcTokenCommandParameters brokerRopcTokenCommandParameters, BrokerRopcTokenCommandParametersBuilder<?, ?> brokerRopcTokenCommandParametersBuilder) {
            brokerRopcTokenCommandParametersBuilder.callerPackageName(brokerRopcTokenCommandParameters.callerPackageName);
            brokerRopcTokenCommandParametersBuilder.callerUid(brokerRopcTokenCommandParameters.callerUid);
            brokerRopcTokenCommandParametersBuilder.callerAppVersion(brokerRopcTokenCommandParameters.callerAppVersion);
            brokerRopcTokenCommandParametersBuilder.brokerVersion(brokerRopcTokenCommandParameters.brokerVersion);
            brokerRopcTokenCommandParametersBuilder.negotiatedBrokerProtocolVersion(brokerRopcTokenCommandParameters.negotiatedBrokerProtocolVersion);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters.RopcTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((BrokerRopcTokenCommandParameters) c, (BrokerRopcTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B brokerVersion(String str) {
            this.brokerVersion = str;
            return (B) self();
        }

        public B callerAppVersion(String str) {
            this.callerAppVersion = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public B callerPackageName(String str) {
            this.callerPackageName = str;
            return (B) self();
        }

        public B callerUid(int i) {
            this.callerUid = i;
            return (B) self();
        }

        public B negotiatedBrokerProtocolVersion(String str) {
            this.negotiatedBrokerProtocolVersion = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters.RopcTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "BrokerRopcTokenCommandParameters.BrokerRopcTokenCommandParametersBuilder(super=" + super.toString() + ", callerPackageName=" + this.callerPackageName + ", callerUid=" + this.callerUid + ", callerAppVersion=" + this.callerAppVersion + ", brokerVersion=" + this.brokerVersion + ", negotiatedBrokerProtocolVersion=" + this.negotiatedBrokerProtocolVersion + ")";
        }
    }

    private static final class BrokerRopcTokenCommandParametersBuilderImpl extends BrokerRopcTokenCommandParametersBuilder<BrokerRopcTokenCommandParameters, BrokerRopcTokenCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.BrokerRopcTokenCommandParameters.BrokerRopcTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters.RopcTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public BrokerRopcTokenCommandParametersBuilderImpl self() {
            return this;
        }

        private BrokerRopcTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.BrokerRopcTokenCommandParameters.BrokerRopcTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters.RopcTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public BrokerRopcTokenCommandParameters build() {
            return new BrokerRopcTokenCommandParameters(this);
        }
    }

    protected BrokerRopcTokenCommandParameters(BrokerRopcTokenCommandParametersBuilder<?, ?> brokerRopcTokenCommandParametersBuilder) {
        super(brokerRopcTokenCommandParametersBuilder);
        this.callerPackageName = ((BrokerRopcTokenCommandParametersBuilder) brokerRopcTokenCommandParametersBuilder).callerPackageName;
        this.callerUid = ((BrokerRopcTokenCommandParametersBuilder) brokerRopcTokenCommandParametersBuilder).callerUid;
        this.callerAppVersion = ((BrokerRopcTokenCommandParametersBuilder) brokerRopcTokenCommandParametersBuilder).callerAppVersion;
        this.brokerVersion = ((BrokerRopcTokenCommandParametersBuilder) brokerRopcTokenCommandParametersBuilder).brokerVersion;
        this.negotiatedBrokerProtocolVersion = ((BrokerRopcTokenCommandParametersBuilder) brokerRopcTokenCommandParametersBuilder).negotiatedBrokerProtocolVersion;
    }

    public static BrokerRopcTokenCommandParametersBuilder<?, ?> builder() {
        return new BrokerRopcTokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public BrokerRopcTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new BrokerRopcTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof BrokerRopcTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BrokerRopcTokenCommandParameters)) {
            return false;
        }
        BrokerRopcTokenCommandParameters brokerRopcTokenCommandParameters = (BrokerRopcTokenCommandParameters) obj;
        if (!brokerRopcTokenCommandParameters.canEqual(this) || !super.equals(obj) || getCallerUid() != brokerRopcTokenCommandParameters.getCallerUid()) {
            return false;
        }
        String callerPackageName = getCallerPackageName();
        String callerPackageName2 = brokerRopcTokenCommandParameters.getCallerPackageName();
        if (callerPackageName != null ? !callerPackageName.equals(callerPackageName2) : callerPackageName2 != null) {
            return false;
        }
        String callerAppVersion = getCallerAppVersion();
        String callerAppVersion2 = brokerRopcTokenCommandParameters.getCallerAppVersion();
        if (callerAppVersion != null ? !callerAppVersion.equals(callerAppVersion2) : callerAppVersion2 != null) {
            return false;
        }
        String brokerVersion = getBrokerVersion();
        String brokerVersion2 = brokerRopcTokenCommandParameters.getBrokerVersion();
        if (brokerVersion != null ? !brokerVersion.equals(brokerVersion2) : brokerVersion2 != null) {
            return false;
        }
        String negotiatedBrokerProtocolVersion = getNegotiatedBrokerProtocolVersion();
        String negotiatedBrokerProtocolVersion2 = brokerRopcTokenCommandParameters.getNegotiatedBrokerProtocolVersion();
        return negotiatedBrokerProtocolVersion != null ? negotiatedBrokerProtocolVersion.equals(negotiatedBrokerProtocolVersion2) : negotiatedBrokerProtocolVersion2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = (super.hashCode() * 59) + getCallerUid();
        String callerPackageName = getCallerPackageName();
        int iHashCode2 = (iHashCode * 59) + (callerPackageName == null ? 43 : callerPackageName.hashCode());
        String callerAppVersion = getCallerAppVersion();
        int iHashCode3 = (iHashCode2 * 59) + (callerAppVersion == null ? 43 : callerAppVersion.hashCode());
        String brokerVersion = getBrokerVersion();
        int i = iHashCode3 * 59;
        int iHashCode4 = brokerVersion == null ? 43 : brokerVersion.hashCode();
        String negotiatedBrokerProtocolVersion = getNegotiatedBrokerProtocolVersion();
        return ((i + iHashCode4) * 59) + (negotiatedBrokerProtocolVersion != null ? negotiatedBrokerProtocolVersion.hashCode() : 43);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public String getCallerPackageName() {
        return this.callerPackageName;
    }

    public int getCallerUid() {
        return this.callerUid;
    }

    public String getCallerAppVersion() {
        return this.callerAppVersion;
    }

    public String getBrokerVersion() {
        return this.brokerVersion;
    }

    public String getNegotiatedBrokerProtocolVersion() {
        return this.negotiatedBrokerProtocolVersion;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters
    public void validate() throws ArgumentException {
        if (this.callerUid == 0) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_PASSWORD_OPERATION_NAME, "mCallerUId", "Caller Uid is not set");
        }
        if (StringUtil.isNullOrEmpty(this.callerPackageName)) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_PASSWORD_OPERATION_NAME, "mCallerPackageName", "Caller package name is not set");
        }
        if (getAuthority() == null) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_PASSWORD_OPERATION_NAME, "mAuthority", "Authority Url is not set");
        }
        if (getScopes() == null || getScopes().isEmpty()) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_PASSWORD_OPERATION_NAME, "mScopes", "Scope or resource is not set");
        }
        if (StringUtil.isNullOrEmpty(getClientId())) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_PASSWORD_OPERATION_NAME, "mClientId", "Client Id is not set");
        }
        if (!(getOAuth2TokenCache() instanceof BrokerOAuth2TokenCache)) {
            throw new ArgumentException("acquireTokenSilent", "mOauth2TokenCache", "OAuth2Cache not an instance of BrokerOAuth2TokenCache");
        }
    }
}
