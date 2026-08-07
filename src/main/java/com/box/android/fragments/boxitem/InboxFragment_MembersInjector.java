package com.box.android.fragments.boxitem;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.inbox.MfaCallbackIntentHandler;
import com.box.android.inbox.notifications.router.IInboxRouter;
import com.box.android.inbox.notifications.router.InboxNotificationRoutingMapper;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class InboxFragment_MembersInjector implements MembersInjector<InboxFragment> {
    private final Provider<IInboxRouter> inboxRouterProvider;
    private final Provider<MfaCallbackIntentHandler> mfaCallbackIntentHandlerProvider;
    private final Provider<InboxNotificationRoutingMapper> routingMapperProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private InboxFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<IInboxRouter> provider2, Provider<InboxNotificationRoutingMapper> provider3, Provider<MfaCallbackIntentHandler> provider4) {
        this.userContextManagerProvider = provider;
        this.inboxRouterProvider = provider2;
        this.routingMapperProvider = provider3;
        this.mfaCallbackIntentHandlerProvider = provider4;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(InboxFragment inboxFragment) {
        injectUserContextManager(inboxFragment, this.userContextManagerProvider.get());
        injectInboxRouter(inboxFragment, this.inboxRouterProvider.get());
        injectRoutingMapper(inboxFragment, this.routingMapperProvider.get());
        injectMfaCallbackIntentHandler(inboxFragment, this.mfaCallbackIntentHandlerProvider.get());
    }

    public static MembersInjector<InboxFragment> create(Provider<IUserContextManager> provider, Provider<IInboxRouter> provider2, Provider<InboxNotificationRoutingMapper> provider3, Provider<MfaCallbackIntentHandler> provider4) {
        return new InboxFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectUserContextManager(InboxFragment inboxFragment, IUserContextManager iUserContextManager) {
        inboxFragment.userContextManager = iUserContextManager;
    }

    public static void injectInboxRouter(InboxFragment inboxFragment, IInboxRouter iInboxRouter) {
        inboxFragment.inboxRouter = iInboxRouter;
    }

    public static void injectRoutingMapper(InboxFragment inboxFragment, InboxNotificationRoutingMapper inboxNotificationRoutingMapper) {
        inboxFragment.routingMapper = inboxNotificationRoutingMapper;
    }

    public static void injectMfaCallbackIntentHandler(InboxFragment inboxFragment, MfaCallbackIntentHandler mfaCallbackIntentHandler) {
        inboxFragment.mfaCallbackIntentHandler = mfaCallbackIntentHandler;
    }
}
