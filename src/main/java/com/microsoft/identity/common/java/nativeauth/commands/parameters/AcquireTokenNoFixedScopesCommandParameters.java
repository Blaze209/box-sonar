package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.TerminalException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;

/* JADX INFO: loaded from: classes14.dex */
public class AcquireTokenNoFixedScopesCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "AcquireTokenNoFixedScopesCommandParameters";
    private static final Object sLock = new Object();
    private final IAccountRecord account;
    private final AbstractAuthenticationScheme authenticationScheme;
    private final boolean forceRefresh;

    public static abstract class AcquireTokenNoFixedScopesCommandParametersBuilder<C extends AcquireTokenNoFixedScopesCommandParameters, B extends AcquireTokenNoFixedScopesCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private IAccountRecord account;
        private AbstractAuthenticationScheme authenticationScheme;
        private boolean forceRefresh;

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(AcquireTokenNoFixedScopesCommandParameters acquireTokenNoFixedScopesCommandParameters, AcquireTokenNoFixedScopesCommandParametersBuilder<?, ?> acquireTokenNoFixedScopesCommandParametersBuilder) {
            acquireTokenNoFixedScopesCommandParametersBuilder.account(acquireTokenNoFixedScopesCommandParameters.account);
            acquireTokenNoFixedScopesCommandParametersBuilder.authenticationScheme(acquireTokenNoFixedScopesCommandParameters.authenticationScheme);
            acquireTokenNoFixedScopesCommandParametersBuilder.forceRefresh(acquireTokenNoFixedScopesCommandParameters.forceRefresh);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((AcquireTokenNoFixedScopesCommandParameters) c, (AcquireTokenNoFixedScopesCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B account(IAccountRecord iAccountRecord) {
            this.account = iAccountRecord;
            return (B) self();
        }

        public B authenticationScheme(AbstractAuthenticationScheme abstractAuthenticationScheme) {
            if (abstractAuthenticationScheme == null) {
                throw new NullPointerException("authenticationScheme is marked non-null but is null");
            }
            this.authenticationScheme = abstractAuthenticationScheme;
            return (B) self();
        }

        public B forceRefresh(boolean z) {
            this.forceRefresh = z;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "AcquireTokenNoFixedScopesCommandParameters.AcquireTokenNoFixedScopesCommandParametersBuilder(super=" + super.toString() + ", account=" + this.account + ", authenticationScheme=" + this.authenticationScheme + ", forceRefresh=" + this.forceRefresh + ")";
        }
    }

    private static final class AcquireTokenNoFixedScopesCommandParametersBuilderImpl extends AcquireTokenNoFixedScopesCommandParametersBuilder<AcquireTokenNoFixedScopesCommandParameters, AcquireTokenNoFixedScopesCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.AcquireTokenNoFixedScopesCommandParameters.AcquireTokenNoFixedScopesCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public AcquireTokenNoFixedScopesCommandParametersBuilderImpl self() {
            return this;
        }

        private AcquireTokenNoFixedScopesCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.AcquireTokenNoFixedScopesCommandParameters.AcquireTokenNoFixedScopesCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public AcquireTokenNoFixedScopesCommandParameters build() {
            return new AcquireTokenNoFixedScopesCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof AcquireTokenNoFixedScopesCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AcquireTokenNoFixedScopesCommandParameters)) {
            return false;
        }
        AcquireTokenNoFixedScopesCommandParameters acquireTokenNoFixedScopesCommandParameters = (AcquireTokenNoFixedScopesCommandParameters) obj;
        if (!acquireTokenNoFixedScopesCommandParameters.canEqual(this) || !super.equals(obj) || isForceRefresh() != acquireTokenNoFixedScopesCommandParameters.isForceRefresh()) {
            return false;
        }
        IAccountRecord account = getAccount();
        IAccountRecord account2 = acquireTokenNoFixedScopesCommandParameters.getAccount();
        if (account != null ? !account.equals(account2) : account2 != null) {
            return false;
        }
        AbstractAuthenticationScheme authenticationScheme = getAuthenticationScheme();
        AbstractAuthenticationScheme authenticationScheme2 = acquireTokenNoFixedScopesCommandParameters.getAuthenticationScheme();
        return authenticationScheme != null ? authenticationScheme.equals(authenticationScheme2) : authenticationScheme2 == null;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = (super.hashCode() * 59) + (isForceRefresh() ? 79 : 97);
        IAccountRecord account = getAccount();
        int i = iHashCode * 59;
        int iHashCode2 = account == null ? 43 : account.hashCode();
        AbstractAuthenticationScheme authenticationScheme = getAuthenticationScheme();
        return ((i + iHashCode2) * 59) + (authenticationScheme != null ? authenticationScheme.hashCode() : 43);
    }

    protected AcquireTokenNoFixedScopesCommandParameters(AcquireTokenNoFixedScopesCommandParametersBuilder<?, ?> acquireTokenNoFixedScopesCommandParametersBuilder) {
        super(acquireTokenNoFixedScopesCommandParametersBuilder);
        this.account = ((AcquireTokenNoFixedScopesCommandParametersBuilder) acquireTokenNoFixedScopesCommandParametersBuilder).account;
        AbstractAuthenticationScheme abstractAuthenticationScheme = ((AcquireTokenNoFixedScopesCommandParametersBuilder) acquireTokenNoFixedScopesCommandParametersBuilder).authenticationScheme;
        this.authenticationScheme = abstractAuthenticationScheme;
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authenticationScheme is marked non-null but is null");
        }
        this.forceRefresh = ((AcquireTokenNoFixedScopesCommandParametersBuilder) acquireTokenNoFixedScopesCommandParametersBuilder).forceRefresh;
    }

    public static AcquireTokenNoFixedScopesCommandParametersBuilder<?, ?> builder() {
        return new AcquireTokenNoFixedScopesCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public AcquireTokenNoFixedScopesCommandParametersBuilder<?, ?> toBuilder() {
        return new AcquireTokenNoFixedScopesCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public IAccountRecord getAccount() {
        return this.account;
    }

    public AbstractAuthenticationScheme getAuthenticationScheme() {
        return this.authenticationScheme;
    }

    public boolean isForceRefresh() {
        return this.forceRefresh;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "AcquireTokenNoFixedScopesCommandParameters(account=" + this.account + ", authenticationScheme=" + getAuthenticationScheme() + ", forceRefresh=" + this.forceRefresh + ", authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return !toString().equals(toUnsanitizedString());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "AcquireTokenNoFixedScopesCommandParameters(authenticationScheme=" + getAuthenticationScheme() + ", forceRefresh=" + this.forceRefresh + ", authority=" + this.authority + ", challengeTypes=" + this.challengeType + ")";
    }

    public void validate() throws ArgumentException {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.verbose(sb.append(str).append(":validate").toString(), "Validating operation params...");
        if (this.authenticationScheme == null) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_NO_FIXED_SCOPE_OPERATION_NAME, ArgumentException.AUTHENTICATION_SCHEME_ARGUMENT_NAME, "authentication scheme is undefined");
        }
        if (getAccount() == null) {
            Logger.warn(str, "The account set on silent operation parameters is NULL.");
        }
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
