package com.box.android.base.presentation.components.topbar.component.inbox;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IInboxNotificationService;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class InboxBadgeRepository_Factory implements Factory<InboxBadgeRepository> {
    private final Provider<IBaseModelController> baseMoCoProvider;
    private final Provider<BoxApiPrivate> boxApiPrivateProvider;
    private final Provider<IInboxNotificationService> inboxNotificationServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private InboxBadgeRepository_Factory(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2, Provider<IUserContextManager> provider3, Provider<IInboxNotificationService> provider4) {
        this.baseMoCoProvider = provider;
        this.boxApiPrivateProvider = provider2;
        this.userContextManagerProvider = provider3;
        this.inboxNotificationServiceProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxBadgeRepository get() {
        return newInstance(this.baseMoCoProvider.get(), this.boxApiPrivateProvider.get(), this.userContextManagerProvider.get(), this.inboxNotificationServiceProvider.get());
    }

    public static InboxBadgeRepository_Factory create(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2, Provider<IUserContextManager> provider3, Provider<IInboxNotificationService> provider4) {
        return new InboxBadgeRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static InboxBadgeRepository newInstance(IBaseModelController iBaseModelController, BoxApiPrivate boxApiPrivate, IUserContextManager iUserContextManager, IInboxNotificationService iInboxNotificationService) {
        return new InboxBadgeRepository(iBaseModelController, boxApiPrivate, iUserContextManager, iInboxNotificationService);
    }
}
