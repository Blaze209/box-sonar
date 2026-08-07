package com.box.android.base.presentation.components.topbar.component.settings;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class DefaultAvatarComponentDataProvider_Factory implements Factory<DefaultAvatarComponentDataProvider> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultAvatarComponentDataProvider_Factory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DefaultAvatarComponentDataProvider get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static DefaultAvatarComponentDataProvider_Factory create(Provider<IUserContextManager> provider) {
        return new DefaultAvatarComponentDataProvider_Factory(provider);
    }

    public static DefaultAvatarComponentDataProvider newInstance(IUserContextManager iUserContextManager) {
        return new DefaultAvatarComponentDataProvider(iUserContextManager);
    }
}
