package com.box.android.data.datasource.inboxnotifications;

import com.box.android.data.user.UserData;
import com.box.android.domain.identity.IUserContextManager;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class InboxNotificationLocalDataSource_Factory implements Factory<InboxNotificationLocalDataSource> {
    private final Provider<Moshi> moshiProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;
    private final Provider<UserData> userDataProvider;

    private InboxNotificationLocalDataSource_Factory(Provider<UserData> userDataProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<Moshi> moshiProvider) {
        this.userDataProvider = userDataProvider;
        this.userContextManagerProvider = userContextManagerProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxNotificationLocalDataSource get() {
        return newInstance(this.userDataProvider.get(), this.userContextManagerProvider.get(), this.moshiProvider.get());
    }

    public static InboxNotificationLocalDataSource_Factory create(Provider<UserData> userDataProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<Moshi> moshiProvider) {
        return new InboxNotificationLocalDataSource_Factory(userDataProvider, userContextManagerProvider, moshiProvider);
    }

    public static InboxNotificationLocalDataSource newInstance(UserData userData, IUserContextManager userContextManager, Moshi moshi) {
        return new InboxNotificationLocalDataSource(userData, userContextManager, moshi);
    }
}
