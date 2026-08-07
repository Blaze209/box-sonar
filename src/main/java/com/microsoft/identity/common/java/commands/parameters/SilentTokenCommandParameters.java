package com.microsoft.identity.common.java.commands.parameters;

import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryB2CAuthority;
import com.microsoft.identity.common.java.authorities.CIAMAuthority;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.TerminalException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;

/* JADX INFO: loaded from: classes14.dex */
public class SilentTokenCommandParameters extends TokenCommandParameters {
    private static final String TAG = "SilentTokenCommandParameters";
    private static final Object sLock = new Object();

    public static abstract class SilentTokenCommandParametersBuilder<C extends SilentTokenCommandParameters, B extends SilentTokenCommandParametersBuilder<C, B>> extends TokenCommandParameters.TokenCommandParametersBuilder<C, B> {
        private static void $fillValuesFromInstanceIntoBuilder(SilentTokenCommandParameters silentTokenCommandParameters, SilentTokenCommandParametersBuilder<?, ?> silentTokenCommandParametersBuilder) {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SilentTokenCommandParameters) c, (SilentTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SilentTokenCommandParameters.SilentTokenCommandParametersBuilder(super=" + super.toString() + ")";
        }
    }

    private static final class SilentTokenCommandParametersBuilderImpl extends SilentTokenCommandParametersBuilder<SilentTokenCommandParameters, SilentTokenCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters.SilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SilentTokenCommandParametersBuilderImpl self() {
            return this;
        }

        private SilentTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters.SilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SilentTokenCommandParameters build() {
            return new SilentTokenCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof SilentTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SilentTokenCommandParameters) && ((SilentTokenCommandParameters) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        return super.hashCode();
    }

    protected SilentTokenCommandParameters(SilentTokenCommandParametersBuilder<?, ?> silentTokenCommandParametersBuilder) {
        super(silentTokenCommandParametersBuilder);
    }

    public static SilentTokenCommandParametersBuilder<?, ?> builder() {
        return new SilentTokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SilentTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new SilentTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters
    public void validate() throws ArgumentException {
        super.validate();
        if (getAccount() == null) {
            Logger.warn(TAG, "The account set on silent operation parameters is NULL.");
        } else if (!isAuthorityB2C() && !isAuthorityCIAM() && !authorityMatchesAccountEnvironment()) {
            throw new ArgumentException("acquireTokenSilent", "authority", "Authority passed to silent parameters does not match with the cloud associated to the account.");
        }
    }

    private boolean isAuthorityB2C() {
        return getAuthority() instanceof AzureActiveDirectoryB2CAuthority;
    }

    private boolean isAuthorityCIAM() {
        return getAuthority() instanceof CIAMAuthority;
    }

    private boolean authorityMatchesAccountEnvironment() {
        try {
            if (!AzureActiveDirectory.isInitialized()) {
                performCloudDiscovery();
            }
            AzureActiveDirectoryCloud azureActiveDirectoryCloudFromHostName = AzureActiveDirectory.getAzureActiveDirectoryCloudFromHostName(getAccount().getEnvironment());
            return azureActiveDirectoryCloudFromHostName != null && azureActiveDirectoryCloudFromHostName.getPreferredNetworkHostName().equals(getAuthority().getAuthorityURL().getAuthority());
        } catch (ClientException e) {
            String errorCode = e.getErrorCode();
            Logger.error(TAG + ":authorityMatchesAccountEnvironment", "Unable to perform cloud discovery", e);
            throw new TerminalException("Unable to perform cloud discovery in order to validate request authority", e, errorCode);
        }
    }

    private static void performCloudDiscovery() throws ClientException {
        Logger.verbose(TAG + ":performCloudDiscovery", "Performing cloud discovery...");
        synchronized (sLock) {
            AzureActiveDirectory.performCloudDiscovery();
        }
    }
}
