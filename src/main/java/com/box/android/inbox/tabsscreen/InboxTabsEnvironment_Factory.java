package com.box.android.inbox.tabsscreen;

import com.box.android.inbox.InboxAnalytics;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxTabsEnvironment_Factory implements Factory<InboxTabsEnvironment> {
    private final Provider<InboxAnalytics> analyticsProvider;

    private InboxTabsEnvironment_Factory(Provider<InboxAnalytics> provider) {
        this.analyticsProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxTabsEnvironment get() {
        return newInstance(this.analyticsProvider.get());
    }

    public static InboxTabsEnvironment_Factory create(Provider<InboxAnalytics> provider) {
        return new InboxTabsEnvironment_Factory(provider);
    }

    public static InboxTabsEnvironment newInstance(InboxAnalytics inboxAnalytics) {
        return new InboxTabsEnvironment(inboxAnalytics);
    }
}
