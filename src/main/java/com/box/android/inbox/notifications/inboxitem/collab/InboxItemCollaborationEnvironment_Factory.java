package com.box.android.inbox.notifications.inboxitem.collab;

import com.box.android.common.utilities.Clock;
import com.box.android.domain.services.IInboxCollaborationService;
import com.box.android.inbox.mfasetup.MfaSetupAnalytics;
import com.box.android.inbox.mfasetup.MfaSetupDialogEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxItemCollaborationEnvironment_Factory implements Factory<InboxItemCollaborationEnvironment> {
    private final Provider<Clock> clockProvider;
    private final Provider<IInboxCollaborationService> inboxCollaborationServiceProvider;
    private final Provider<MfaSetupAnalytics> mfaSetupAnalyticsProvider;
    private final Provider<MfaSetupDialogEnvironment> mfaSetupDialogEnvironmentProvider;

    private InboxItemCollaborationEnvironment_Factory(Provider<MfaSetupAnalytics> provider, Provider<IInboxCollaborationService> provider2, Provider<MfaSetupDialogEnvironment> provider3, Provider<Clock> provider4) {
        this.mfaSetupAnalyticsProvider = provider;
        this.inboxCollaborationServiceProvider = provider2;
        this.mfaSetupDialogEnvironmentProvider = provider3;
        this.clockProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxItemCollaborationEnvironment get() {
        return newInstance(this.mfaSetupAnalyticsProvider.get(), this.inboxCollaborationServiceProvider.get(), this.mfaSetupDialogEnvironmentProvider.get(), this.clockProvider.get());
    }

    public static InboxItemCollaborationEnvironment_Factory create(Provider<MfaSetupAnalytics> provider, Provider<IInboxCollaborationService> provider2, Provider<MfaSetupDialogEnvironment> provider3, Provider<Clock> provider4) {
        return new InboxItemCollaborationEnvironment_Factory(provider, provider2, provider3, provider4);
    }

    public static InboxItemCollaborationEnvironment newInstance(MfaSetupAnalytics mfaSetupAnalytics, IInboxCollaborationService iInboxCollaborationService, MfaSetupDialogEnvironment mfaSetupDialogEnvironment, Clock clock) {
        return new InboxItemCollaborationEnvironment(mfaSetupAnalytics, iInboxCollaborationService, mfaSetupDialogEnvironment, clock);
    }
}
