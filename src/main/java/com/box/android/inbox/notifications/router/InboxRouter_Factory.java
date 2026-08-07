package com.box.android.inbox.notifications.router;

import android.content.Context;
import com.box.android.coreservices.services.IntentServices;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxRouter_Factory implements Factory<InboxRouter> {
    private final Provider<Context> contextProvider;
    private final Provider<IntentServices> intentServicesProvider;

    private InboxRouter_Factory(Provider<Context> provider, Provider<IntentServices> provider2) {
        this.contextProvider = provider;
        this.intentServicesProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxRouter get() {
        return newInstance(this.contextProvider.get(), this.intentServicesProvider.get());
    }

    public static InboxRouter_Factory create(Provider<Context> provider, Provider<IntentServices> provider2) {
        return new InboxRouter_Factory(provider, provider2);
    }

    public static InboxRouter newInstance(Context context, IntentServices intentServices) {
        return new InboxRouter(context, intentServices);
    }
}
