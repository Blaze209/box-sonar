package com.microsoft.identity.common.java.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class GetAadDeviceIdCommandParameters extends CommandParameters {
    private String tenantId;

    public static abstract class GetAadDeviceIdCommandParametersBuilder<C extends GetAadDeviceIdCommandParameters, B extends GetAadDeviceIdCommandParametersBuilder<C, B>> extends CommandParameters.CommandParametersBuilder<C, B> {
        private String tenantId;

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(GetAadDeviceIdCommandParameters getAadDeviceIdCommandParameters, GetAadDeviceIdCommandParametersBuilder<?, ?> getAadDeviceIdCommandParametersBuilder) {
            getAadDeviceIdCommandParametersBuilder.tenantId(getAadDeviceIdCommandParameters.tenantId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((GetAadDeviceIdCommandParameters) c, (GetAadDeviceIdCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B tenantId(String str) {
            if (str == null) {
                throw new NullPointerException("tenantId is marked non-null but is null");
            }
            this.tenantId = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "GetAadDeviceIdCommandParameters.GetAadDeviceIdCommandParametersBuilder(super=" + super.toString() + ", tenantId=" + this.tenantId + ")";
        }
    }

    private static final class GetAadDeviceIdCommandParametersBuilderImpl extends GetAadDeviceIdCommandParametersBuilder<GetAadDeviceIdCommandParameters, GetAadDeviceIdCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.GetAadDeviceIdCommandParameters.GetAadDeviceIdCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public GetAadDeviceIdCommandParametersBuilderImpl self() {
            return this;
        }

        private GetAadDeviceIdCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.GetAadDeviceIdCommandParameters.GetAadDeviceIdCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public GetAadDeviceIdCommandParameters build() {
            return new GetAadDeviceIdCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof GetAadDeviceIdCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetAadDeviceIdCommandParameters)) {
            return false;
        }
        GetAadDeviceIdCommandParameters getAadDeviceIdCommandParameters = (GetAadDeviceIdCommandParameters) obj;
        if (!getAadDeviceIdCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String tenantId = getTenantId();
        String tenantId2 = getAadDeviceIdCommandParameters.getTenantId();
        return tenantId != null ? tenantId.equals(tenantId2) : tenantId2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String tenantId = getTenantId();
        return (iHashCode * 59) + (tenantId == null ? 43 : tenantId.hashCode());
    }

    protected GetAadDeviceIdCommandParameters(GetAadDeviceIdCommandParametersBuilder<?, ?> getAadDeviceIdCommandParametersBuilder) {
        super(getAadDeviceIdCommandParametersBuilder);
        String str = ((GetAadDeviceIdCommandParametersBuilder) getAadDeviceIdCommandParametersBuilder).tenantId;
        this.tenantId = str;
        if (str == null) {
            throw new NullPointerException("tenantId is marked non-null but is null");
        }
    }

    public static GetAadDeviceIdCommandParametersBuilder<?, ?> builder() {
        return new GetAadDeviceIdCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public GetAadDeviceIdCommandParametersBuilder<?, ?> toBuilder() {
        return new GetAadDeviceIdCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getTenantId() {
        return this.tenantId;
    }
}
