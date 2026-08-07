package com.microsoft.identity.common.java.commands.parameters;

import com.google.gson.annotations.Expose;
import com.microsoft.identity.common.java.broker.IBrokerAccount;
import com.microsoft.identity.common.java.request.BrokerRequestType;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerResourceAccountCommandParameters extends ResourceAccountCommandParameters implements IBrokerTokenCommandParameters {
    private final IBrokerAccount brokerAccount;

    @Expose
    private final String brokerVersion;

    @Expose
    private final String callerAppVersion;

    @Expose
    private final int callerUid;

    @Expose
    private final String homeTenantId;
    private final String localAccountId;

    @Expose
    private final String negotiatedBrokerProtocolVersion;
    private final BrokerRequestType requestType;

    public static abstract class BrokerResourceAccountCommandParametersBuilder<C extends BrokerResourceAccountCommandParameters, B extends BrokerResourceAccountCommandParametersBuilder<C, B>> extends ResourceAccountCommandParameters.ResourceAccountCommandParametersBuilder<C, B> {
        private IBrokerAccount brokerAccount;
        private String brokerVersion;
        private String callerAppVersion;
        private int callerUid;
        private String homeTenantId;
        private String localAccountId;
        private String negotiatedBrokerProtocolVersion;

        @Override // com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters.ResourceAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters.ResourceAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(BrokerResourceAccountCommandParameters brokerResourceAccountCommandParameters, BrokerResourceAccountCommandParametersBuilder<?, ?> brokerResourceAccountCommandParametersBuilder) {
            brokerResourceAccountCommandParametersBuilder.callerUid(brokerResourceAccountCommandParameters.callerUid);
            brokerResourceAccountCommandParametersBuilder.callerAppVersion(brokerResourceAccountCommandParameters.callerAppVersion);
            brokerResourceAccountCommandParametersBuilder.brokerVersion(brokerResourceAccountCommandParameters.brokerVersion);
            brokerResourceAccountCommandParametersBuilder.homeTenantId(brokerResourceAccountCommandParameters.homeTenantId);
            brokerResourceAccountCommandParametersBuilder.localAccountId(brokerResourceAccountCommandParameters.localAccountId);
            brokerResourceAccountCommandParametersBuilder.brokerAccount(brokerResourceAccountCommandParameters.brokerAccount);
            brokerResourceAccountCommandParametersBuilder.negotiatedBrokerProtocolVersion(brokerResourceAccountCommandParameters.negotiatedBrokerProtocolVersion);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters.ResourceAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((BrokerResourceAccountCommandParameters) c, (BrokerResourceAccountCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B brokerAccount(IBrokerAccount iBrokerAccount) {
            this.brokerAccount = iBrokerAccount;
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

        public B callerUid(int i) {
            this.callerUid = i;
            return (B) self();
        }

        public B homeTenantId(String str) {
            if (str == null) {
                throw new NullPointerException("homeTenantId is marked non-null but is null");
            }
            this.homeTenantId = str;
            return (B) self();
        }

        public B localAccountId(String str) {
            if (str == null) {
                throw new NullPointerException("localAccountId is marked non-null but is null");
            }
            this.localAccountId = str;
            return (B) self();
        }

        public B negotiatedBrokerProtocolVersion(String str) {
            this.negotiatedBrokerProtocolVersion = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters.ResourceAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "BrokerResourceAccountCommandParameters.BrokerResourceAccountCommandParametersBuilder(super=" + super.toString() + ", callerUid=" + this.callerUid + ", callerAppVersion=" + this.callerAppVersion + ", brokerVersion=" + this.brokerVersion + ", homeTenantId=" + this.homeTenantId + ", localAccountId=" + this.localAccountId + ", brokerAccount=" + this.brokerAccount + ", negotiatedBrokerProtocolVersion=" + this.negotiatedBrokerProtocolVersion + ")";
        }
    }

    private static final class BrokerResourceAccountCommandParametersBuilderImpl extends BrokerResourceAccountCommandParametersBuilder<BrokerResourceAccountCommandParameters, BrokerResourceAccountCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.BrokerResourceAccountCommandParameters.BrokerResourceAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters.ResourceAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public BrokerResourceAccountCommandParametersBuilderImpl self() {
            return this;
        }

        private BrokerResourceAccountCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.BrokerResourceAccountCommandParameters.BrokerResourceAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters.ResourceAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public BrokerResourceAccountCommandParameters build() {
            return new BrokerResourceAccountCommandParameters(this);
        }
    }

    protected BrokerResourceAccountCommandParameters(BrokerResourceAccountCommandParametersBuilder<?, ?> brokerResourceAccountCommandParametersBuilder) {
        super(brokerResourceAccountCommandParametersBuilder);
        this.requestType = BrokerRequestType.REGULAR;
        this.callerUid = ((BrokerResourceAccountCommandParametersBuilder) brokerResourceAccountCommandParametersBuilder).callerUid;
        this.callerAppVersion = ((BrokerResourceAccountCommandParametersBuilder) brokerResourceAccountCommandParametersBuilder).callerAppVersion;
        this.brokerVersion = ((BrokerResourceAccountCommandParametersBuilder) brokerResourceAccountCommandParametersBuilder).brokerVersion;
        String str = ((BrokerResourceAccountCommandParametersBuilder) brokerResourceAccountCommandParametersBuilder).homeTenantId;
        this.homeTenantId = str;
        if (str == null) {
            throw new NullPointerException("homeTenantId is marked non-null but is null");
        }
        String str2 = ((BrokerResourceAccountCommandParametersBuilder) brokerResourceAccountCommandParametersBuilder).localAccountId;
        this.localAccountId = str2;
        if (str2 == null) {
            throw new NullPointerException("localAccountId is marked non-null but is null");
        }
        this.brokerAccount = ((BrokerResourceAccountCommandParametersBuilder) brokerResourceAccountCommandParametersBuilder).brokerAccount;
        this.negotiatedBrokerProtocolVersion = ((BrokerResourceAccountCommandParametersBuilder) brokerResourceAccountCommandParametersBuilder).negotiatedBrokerProtocolVersion;
    }

    public static BrokerResourceAccountCommandParametersBuilder<?, ?> builder() {
        return new BrokerResourceAccountCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public BrokerResourceAccountCommandParametersBuilder<?, ?> toBuilder() {
        return new BrokerResourceAccountCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof BrokerResourceAccountCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BrokerResourceAccountCommandParameters)) {
            return false;
        }
        BrokerResourceAccountCommandParameters brokerResourceAccountCommandParameters = (BrokerResourceAccountCommandParameters) obj;
        if (!brokerResourceAccountCommandParameters.canEqual(this) || !super.equals(obj) || getCallerUid() != brokerResourceAccountCommandParameters.getCallerUid()) {
            return false;
        }
        String callerAppVersion = getCallerAppVersion();
        String callerAppVersion2 = brokerResourceAccountCommandParameters.getCallerAppVersion();
        if (callerAppVersion != null ? !callerAppVersion.equals(callerAppVersion2) : callerAppVersion2 != null) {
            return false;
        }
        String brokerVersion = getBrokerVersion();
        String brokerVersion2 = brokerResourceAccountCommandParameters.getBrokerVersion();
        if (brokerVersion != null ? !brokerVersion.equals(brokerVersion2) : brokerVersion2 != null) {
            return false;
        }
        String homeTenantId = getHomeTenantId();
        String homeTenantId2 = brokerResourceAccountCommandParameters.getHomeTenantId();
        if (homeTenantId != null ? !homeTenantId.equals(homeTenantId2) : homeTenantId2 != null) {
            return false;
        }
        String localAccountId = getLocalAccountId();
        String localAccountId2 = brokerResourceAccountCommandParameters.getLocalAccountId();
        if (localAccountId != null ? !localAccountId.equals(localAccountId2) : localAccountId2 != null) {
            return false;
        }
        IBrokerAccount brokerAccount = getBrokerAccount();
        IBrokerAccount brokerAccount2 = brokerResourceAccountCommandParameters.getBrokerAccount();
        if (brokerAccount != null ? !brokerAccount.equals(brokerAccount2) : brokerAccount2 != null) {
            return false;
        }
        String negotiatedBrokerProtocolVersion = getNegotiatedBrokerProtocolVersion();
        String negotiatedBrokerProtocolVersion2 = brokerResourceAccountCommandParameters.getNegotiatedBrokerProtocolVersion();
        if (negotiatedBrokerProtocolVersion != null ? !negotiatedBrokerProtocolVersion.equals(negotiatedBrokerProtocolVersion2) : negotiatedBrokerProtocolVersion2 != null) {
            return false;
        }
        BrokerRequestType requestType = getRequestType();
        BrokerRequestType requestType2 = brokerResourceAccountCommandParameters.getRequestType();
        return requestType != null ? requestType.equals(requestType2) : requestType2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = (super.hashCode() * 59) + getCallerUid();
        String callerAppVersion = getCallerAppVersion();
        int iHashCode2 = (iHashCode * 59) + (callerAppVersion == null ? 43 : callerAppVersion.hashCode());
        String brokerVersion = getBrokerVersion();
        int iHashCode3 = (iHashCode2 * 59) + (brokerVersion == null ? 43 : brokerVersion.hashCode());
        String homeTenantId = getHomeTenantId();
        int iHashCode4 = (iHashCode3 * 59) + (homeTenantId == null ? 43 : homeTenantId.hashCode());
        String localAccountId = getLocalAccountId();
        int iHashCode5 = (iHashCode4 * 59) + (localAccountId == null ? 43 : localAccountId.hashCode());
        IBrokerAccount brokerAccount = getBrokerAccount();
        int iHashCode6 = (iHashCode5 * 59) + (brokerAccount == null ? 43 : brokerAccount.hashCode());
        String negotiatedBrokerProtocolVersion = getNegotiatedBrokerProtocolVersion();
        int i = iHashCode6 * 59;
        int iHashCode7 = negotiatedBrokerProtocolVersion == null ? 43 : negotiatedBrokerProtocolVersion.hashCode();
        BrokerRequestType requestType = getRequestType();
        return ((i + iHashCode7) * 59) + (requestType != null ? requestType.hashCode() : 43);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public int getCallerUid() {
        return this.callerUid;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public String getCallerAppVersion() {
        return this.callerAppVersion;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public String getBrokerVersion() {
        return this.brokerVersion;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public String getHomeTenantId() {
        return this.homeTenantId;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public String getLocalAccountId() {
        return this.localAccountId;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public IBrokerAccount getBrokerAccount() {
        return this.brokerAccount;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public String getNegotiatedBrokerProtocolVersion() {
        return this.negotiatedBrokerProtocolVersion;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public BrokerRequestType getRequestType() {
        return this.requestType;
    }
}
