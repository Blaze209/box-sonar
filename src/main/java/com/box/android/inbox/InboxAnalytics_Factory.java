package com.box.android.inbox;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxAnalytics_Factory implements Factory<InboxAnalytics> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxAnalytics get() {
        return newInstance();
    }

    public static InboxAnalytics_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static InboxAnalytics newInstance() {
        return new InboxAnalytics();
    }

    private static final class InstanceHolder {
        static final InboxAnalytics_Factory INSTANCE = new InboxAnalytics_Factory();

        private InstanceHolder() {
        }
    }
}
