package com.microsoft.identity.common.java.interfaces;

import com.microsoft.identity.common.java.browser.IBrowserSelector;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.oauth2.IStateGenerator;
import com.microsoft.identity.common.java.strategies.IAuthorizationStrategyFactory;
import com.microsoft.identity.common.java.util.IBroadcaster;
import com.microsoft.identity.common.java.util.IClockSkewManager;
import com.microsoft.identity.common.java.util.IPlatformUtil;

/* JADX INFO: loaded from: classes14.dex */
public class PlatformComponents implements IPlatformComponents {
    private final IAuthorizationStrategyFactory mAuthorizationStrategyFactory;
    private final IBroadcaster mBroadcaster;
    private final IBrowserSelector mBrowserSelector;
    private final IClockSkewManager mClockSkewManager;
    private final IHttpClientWrapper mHttpClientWrapper;
    private final IPlatformUtil mPlatformUtil;
    private final IPopManagerSupplier mPopManagerLoader;
    private final IStateGenerator mStateGenerator;
    private final IStorageSupplier mStorageSupplier;

    public static abstract class PlatformComponentsBuilder<C extends PlatformComponents, B extends PlatformComponentsBuilder<C, B>> {
        private IAuthorizationStrategyFactory authorizationStrategyFactory;
        private IBroadcaster broadcaster;
        private IBrowserSelector browserSelector;
        private IClockSkewManager clockSkewManager;
        private IHttpClientWrapper httpClientWrapper;
        private IPlatformUtil platformUtil;
        private IPopManagerSupplier popManagerLoader;
        private IStateGenerator stateGenerator;
        private IStorageSupplier storageSupplier;

        public abstract C build();

        protected abstract B self();

        public B authorizationStrategyFactory(IAuthorizationStrategyFactory iAuthorizationStrategyFactory) {
            this.authorizationStrategyFactory = iAuthorizationStrategyFactory;
            return (B) self();
        }

        public B broadcaster(IBroadcaster iBroadcaster) {
            if (iBroadcaster == null) {
                throw new NullPointerException("broadcaster is marked non-null but is null");
            }
            this.broadcaster = iBroadcaster;
            return (B) self();
        }

        public B browserSelector(IBrowserSelector iBrowserSelector) {
            if (iBrowserSelector == null) {
                throw new NullPointerException("browserSelector is marked non-null but is null");
            }
            this.browserSelector = iBrowserSelector;
            return (B) self();
        }

        public B clockSkewManager(IClockSkewManager iClockSkewManager) {
            if (iClockSkewManager == null) {
                throw new NullPointerException("clockSkewManager is marked non-null but is null");
            }
            this.clockSkewManager = iClockSkewManager;
            return (B) self();
        }

        public B httpClientWrapper(IHttpClientWrapper iHttpClientWrapper) {
            if (iHttpClientWrapper == null) {
                throw new NullPointerException("httpClientWrapper is marked non-null but is null");
            }
            this.httpClientWrapper = iHttpClientWrapper;
            return (B) self();
        }

        public B platformUtil(IPlatformUtil iPlatformUtil) {
            if (iPlatformUtil == null) {
                throw new NullPointerException("platformUtil is marked non-null but is null");
            }
            this.platformUtil = iPlatformUtil;
            return (B) self();
        }

        public B popManagerLoader(IPopManagerSupplier iPopManagerSupplier) {
            if (iPopManagerSupplier == null) {
                throw new NullPointerException("popManagerLoader is marked non-null but is null");
            }
            this.popManagerLoader = iPopManagerSupplier;
            return (B) self();
        }

        public B stateGenerator(IStateGenerator iStateGenerator) {
            this.stateGenerator = iStateGenerator;
            return (B) self();
        }

        public B storageSupplier(IStorageSupplier iStorageSupplier) {
            if (iStorageSupplier == null) {
                throw new NullPointerException("storageSupplier is marked non-null but is null");
            }
            this.storageSupplier = iStorageSupplier;
            return (B) self();
        }

        public String toString() {
            return "PlatformComponents.PlatformComponentsBuilder(clockSkewManager=" + this.clockSkewManager + ", broadcaster=" + this.broadcaster + ", popManagerLoader=" + this.popManagerLoader + ", storageSupplier=" + this.storageSupplier + ", authorizationStrategyFactory=" + this.authorizationStrategyFactory + ", stateGenerator=" + this.stateGenerator + ", platformUtil=" + this.platformUtil + ", httpClientWrapper=" + this.httpClientWrapper + ", browserSelector=" + this.browserSelector + ")";
        }
    }

    private static final class PlatformComponentsBuilderImpl extends PlatformComponentsBuilder<PlatformComponents, PlatformComponentsBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.interfaces.PlatformComponents.PlatformComponentsBuilder
        public PlatformComponentsBuilderImpl self() {
            return this;
        }

        private PlatformComponentsBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.interfaces.PlatformComponents.PlatformComponentsBuilder
        public PlatformComponents build() {
            return new PlatformComponents(this);
        }
    }

    protected PlatformComponents(PlatformComponentsBuilder<?, ?> platformComponentsBuilder) {
        IClockSkewManager iClockSkewManager = ((PlatformComponentsBuilder) platformComponentsBuilder).clockSkewManager;
        this.mClockSkewManager = iClockSkewManager;
        if (iClockSkewManager == null) {
            throw new NullPointerException("mClockSkewManager is marked non-null but is null");
        }
        IBroadcaster iBroadcaster = ((PlatformComponentsBuilder) platformComponentsBuilder).broadcaster;
        this.mBroadcaster = iBroadcaster;
        if (iBroadcaster == null) {
            throw new NullPointerException("mBroadcaster is marked non-null but is null");
        }
        IPopManagerSupplier iPopManagerSupplier = ((PlatformComponentsBuilder) platformComponentsBuilder).popManagerLoader;
        this.mPopManagerLoader = iPopManagerSupplier;
        if (iPopManagerSupplier == null) {
            throw new NullPointerException("mPopManagerLoader is marked non-null but is null");
        }
        IStorageSupplier iStorageSupplier = ((PlatformComponentsBuilder) platformComponentsBuilder).storageSupplier;
        this.mStorageSupplier = iStorageSupplier;
        if (iStorageSupplier == null) {
            throw new NullPointerException("mStorageSupplier is marked non-null but is null");
        }
        this.mAuthorizationStrategyFactory = ((PlatformComponentsBuilder) platformComponentsBuilder).authorizationStrategyFactory;
        this.mStateGenerator = ((PlatformComponentsBuilder) platformComponentsBuilder).stateGenerator;
        IPlatformUtil iPlatformUtil = ((PlatformComponentsBuilder) platformComponentsBuilder).platformUtil;
        this.mPlatformUtil = iPlatformUtil;
        if (iPlatformUtil == null) {
            throw new NullPointerException("mPlatformUtil is marked non-null but is null");
        }
        IHttpClientWrapper iHttpClientWrapper = ((PlatformComponentsBuilder) platformComponentsBuilder).httpClientWrapper;
        this.mHttpClientWrapper = iHttpClientWrapper;
        if (iHttpClientWrapper == null) {
            throw new NullPointerException("mHttpClientWrapper is marked non-null but is null");
        }
        IBrowserSelector iBrowserSelector = ((PlatformComponentsBuilder) platformComponentsBuilder).browserSelector;
        this.mBrowserSelector = iBrowserSelector;
        if (iBrowserSelector == null) {
            throw new NullPointerException("mBrowserSelector is marked non-null but is null");
        }
    }

    public static PlatformComponentsBuilder<?, ?> builder() {
        return new PlatformComponentsBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    public IClockSkewManager getClockSkewManager() {
        return this.mClockSkewManager;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    public IBroadcaster getBroadcaster() {
        return this.mBroadcaster;
    }

    public IPopManagerSupplier getPopManagerLoader() {
        return this.mPopManagerLoader;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    public IStorageSupplier getStorageSupplier() {
        return this.mStorageSupplier;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    public IAuthorizationStrategyFactory getAuthorizationStrategyFactory() {
        return this.mAuthorizationStrategyFactory;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    public IStateGenerator getStateGenerator() {
        return this.mStateGenerator;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    public IPlatformUtil getPlatformUtil() {
        return this.mPlatformUtil;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    public IHttpClientWrapper getHttpClientWrapper() {
        return this.mHttpClientWrapper;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPlatformComponents
    public IBrowserSelector getBrowserSelector() {
        return this.mBrowserSelector;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPopManagerSupplier
    public IDevicePopManager getDefaultDevicePopManager() throws ClientException {
        return this.mPopManagerLoader.getDefaultDevicePopManager();
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPopManagerSupplier
    public IDevicePopManager getDevicePopManager(String str) throws ClientException {
        return this.mPopManagerLoader.getDevicePopManager(str);
    }
}
