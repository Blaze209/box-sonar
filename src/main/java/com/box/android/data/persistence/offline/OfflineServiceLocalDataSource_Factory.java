package com.box.android.data.persistence.offline;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class OfflineServiceLocalDataSource_Factory implements Factory<OfflineServiceLocalDataSource> {
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<UserData> userDataProvider;

    private OfflineServiceLocalDataSource_Factory(Provider<UserData> userDataProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.userDataProvider = userDataProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfflineServiceLocalDataSource get() {
        return newInstance(this.userDataProvider.get(), this.ioDispatcherProvider.get());
    }

    public static OfflineServiceLocalDataSource_Factory create(Provider<UserData> userDataProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new OfflineServiceLocalDataSource_Factory(userDataProvider, ioDispatcherProvider);
    }

    public static OfflineServiceLocalDataSource newInstance(UserData userData, CoroutineDispatcher ioDispatcher) {
        return new OfflineServiceLocalDataSource(userData, ioDispatcher);
    }
}
