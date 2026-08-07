package com.microsoft.identity.common.java.commands.parameters;

import com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams;

/* JADX INFO: loaded from: classes14.dex */
public class GenerateShrCommandParameters extends CommandParameters {
    private String mHomeAccountId;
    private IPoPAuthenticationSchemeParams mPopParameters;

    public static abstract class GenerateShrCommandParametersBuilder<C extends GenerateShrCommandParameters, B extends GenerateShrCommandParametersBuilder<C, B>> extends CommandParameters.CommandParametersBuilder<C, B> {
        private String homeAccountId;
        private IPoPAuthenticationSchemeParams popParameters;

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(GenerateShrCommandParameters generateShrCommandParameters, GenerateShrCommandParametersBuilder<?, ?> generateShrCommandParametersBuilder) {
            generateShrCommandParametersBuilder.homeAccountId(generateShrCommandParameters.mHomeAccountId);
            generateShrCommandParametersBuilder.popParameters(generateShrCommandParameters.mPopParameters);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((GenerateShrCommandParameters) c, (GenerateShrCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B homeAccountId(String str) {
            this.homeAccountId = str;
            return (B) self();
        }

        public B popParameters(IPoPAuthenticationSchemeParams iPoPAuthenticationSchemeParams) {
            this.popParameters = iPoPAuthenticationSchemeParams;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "GenerateShrCommandParameters.GenerateShrCommandParametersBuilder(super=" + super.toString() + ", homeAccountId=" + this.homeAccountId + ", popParameters=" + this.popParameters + ")";
        }
    }

    private static final class GenerateShrCommandParametersBuilderImpl extends GenerateShrCommandParametersBuilder<GenerateShrCommandParameters, GenerateShrCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters.GenerateShrCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public GenerateShrCommandParametersBuilderImpl self() {
            return this;
        }

        private GenerateShrCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters.GenerateShrCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public GenerateShrCommandParameters build() {
            return new GenerateShrCommandParameters(this);
        }
    }

    protected GenerateShrCommandParameters(GenerateShrCommandParametersBuilder<?, ?> generateShrCommandParametersBuilder) {
        super(generateShrCommandParametersBuilder);
        this.mHomeAccountId = ((GenerateShrCommandParametersBuilder) generateShrCommandParametersBuilder).homeAccountId;
        this.mPopParameters = ((GenerateShrCommandParametersBuilder) generateShrCommandParametersBuilder).popParameters;
    }

    public static GenerateShrCommandParametersBuilder<?, ?> builder() {
        return new GenerateShrCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public GenerateShrCommandParametersBuilder<?, ?> toBuilder() {
        return new GenerateShrCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof GenerateShrCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GenerateShrCommandParameters)) {
            return false;
        }
        GenerateShrCommandParameters generateShrCommandParameters = (GenerateShrCommandParameters) obj;
        if (!generateShrCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String homeAccountId = getHomeAccountId();
        String homeAccountId2 = generateShrCommandParameters.getHomeAccountId();
        if (homeAccountId != null ? !homeAccountId.equals(homeAccountId2) : homeAccountId2 != null) {
            return false;
        }
        IPoPAuthenticationSchemeParams popParameters = getPopParameters();
        IPoPAuthenticationSchemeParams popParameters2 = generateShrCommandParameters.getPopParameters();
        return popParameters != null ? popParameters.equals(popParameters2) : popParameters2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String homeAccountId = getHomeAccountId();
        int i = iHashCode * 59;
        int iHashCode2 = homeAccountId == null ? 43 : homeAccountId.hashCode();
        IPoPAuthenticationSchemeParams popParameters = getPopParameters();
        return ((i + iHashCode2) * 59) + (popParameters != null ? popParameters.hashCode() : 43);
    }

    public String getHomeAccountId() {
        return this.mHomeAccountId;
    }

    public IPoPAuthenticationSchemeParams getPopParameters() {
        return this.mPopParameters;
    }
}
