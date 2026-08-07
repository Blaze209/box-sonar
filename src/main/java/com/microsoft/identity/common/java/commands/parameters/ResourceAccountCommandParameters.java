package com.microsoft.identity.common.java.commands.parameters;

/* JADX INFO: loaded from: classes14.dex */
public class ResourceAccountCommandParameters extends TokenCommandParameters {
    private final String homeAccountId;

    public static abstract class ResourceAccountCommandParametersBuilder<C extends ResourceAccountCommandParameters, B extends ResourceAccountCommandParametersBuilder<C, B>> extends TokenCommandParameters.TokenCommandParametersBuilder<C, B> {
        private String homeAccountId;

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(ResourceAccountCommandParameters resourceAccountCommandParameters, ResourceAccountCommandParametersBuilder<?, ?> resourceAccountCommandParametersBuilder) {
            resourceAccountCommandParametersBuilder.homeAccountId(resourceAccountCommandParameters.homeAccountId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((ResourceAccountCommandParameters) c, (ResourceAccountCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B homeAccountId(String str) {
            if (str == null) {
                throw new NullPointerException("homeAccountId is marked non-null but is null");
            }
            this.homeAccountId = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "ResourceAccountCommandParameters.ResourceAccountCommandParametersBuilder(super=" + super.toString() + ", homeAccountId=" + this.homeAccountId + ")";
        }
    }

    private static final class ResourceAccountCommandParametersBuilderImpl extends ResourceAccountCommandParametersBuilder<ResourceAccountCommandParameters, ResourceAccountCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters.ResourceAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResourceAccountCommandParametersBuilderImpl self() {
            return this;
        }

        private ResourceAccountCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters.ResourceAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResourceAccountCommandParameters build() {
            return new ResourceAccountCommandParameters(this);
        }
    }

    protected ResourceAccountCommandParameters(ResourceAccountCommandParametersBuilder<?, ?> resourceAccountCommandParametersBuilder) {
        super(resourceAccountCommandParametersBuilder);
        String str = ((ResourceAccountCommandParametersBuilder) resourceAccountCommandParametersBuilder).homeAccountId;
        this.homeAccountId = str;
        if (str == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
    }

    public static ResourceAccountCommandParametersBuilder<?, ?> builder() {
        return new ResourceAccountCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public ResourceAccountCommandParametersBuilder<?, ?> toBuilder() {
        return new ResourceAccountCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof ResourceAccountCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResourceAccountCommandParameters)) {
            return false;
        }
        ResourceAccountCommandParameters resourceAccountCommandParameters = (ResourceAccountCommandParameters) obj;
        if (!resourceAccountCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String homeAccountId = getHomeAccountId();
        String homeAccountId2 = resourceAccountCommandParameters.getHomeAccountId();
        return homeAccountId != null ? homeAccountId.equals(homeAccountId2) : homeAccountId2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String homeAccountId = getHomeAccountId();
        return (iHashCode * 59) + (homeAccountId == null ? 43 : homeAccountId.hashCode());
    }

    public String getHomeAccountId() {
        return this.homeAccountId;
    }
}
