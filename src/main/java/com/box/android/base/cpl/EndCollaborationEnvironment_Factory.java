package com.box.android.base.cpl;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ILocalItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class EndCollaborationEnvironment_Factory implements Factory<EndCollaborationEnvironment> {
    private final Provider<ILocalItemService> localItemServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private EndCollaborationEnvironment_Factory(Provider<ILocalItemService> provider, Provider<IUserContextManager> provider2) {
        this.localItemServiceProvider = provider;
        this.userContextManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public EndCollaborationEnvironment get() {
        return newInstance(this.localItemServiceProvider.get(), this.userContextManagerProvider.get());
    }

    public static EndCollaborationEnvironment_Factory create(Provider<ILocalItemService> provider, Provider<IUserContextManager> provider2) {
        return new EndCollaborationEnvironment_Factory(provider, provider2);
    }

    public static EndCollaborationEnvironment newInstance(ILocalItemService iLocalItemService, IUserContextManager iUserContextManager) {
        return new EndCollaborationEnvironment(iLocalItemService, iUserContextManager);
    }
}
