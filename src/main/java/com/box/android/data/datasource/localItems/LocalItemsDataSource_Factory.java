package com.box.android.data.datasource.localItems;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class LocalItemsDataSource_Factory implements Factory<LocalItemsDataSource> {
    private final Provider<UserData> userDataProvider;

    private LocalItemsDataSource_Factory(Provider<UserData> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LocalItemsDataSource get() {
        return newInstance(this.userDataProvider.get());
    }

    public static LocalItemsDataSource_Factory create(Provider<UserData> userDataProvider) {
        return new LocalItemsDataSource_Factory(userDataProvider);
    }

    public static LocalItemsDataSource newInstance(UserData userData) {
        return new LocalItemsDataSource(userData);
    }
}
