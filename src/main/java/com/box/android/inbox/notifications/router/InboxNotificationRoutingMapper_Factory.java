package com.box.android.inbox.notifications.router;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxNotificationRoutingMapper_Factory implements Factory<InboxNotificationRoutingMapper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxNotificationRoutingMapper get() {
        return newInstance();
    }

    public static InboxNotificationRoutingMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static InboxNotificationRoutingMapper newInstance() {
        return new InboxNotificationRoutingMapper();
    }

    private static final class InstanceHolder {
        static final InboxNotificationRoutingMapper_Factory INSTANCE = new InboxNotificationRoutingMapper_Factory();

        private InstanceHolder() {
        }
    }
}
