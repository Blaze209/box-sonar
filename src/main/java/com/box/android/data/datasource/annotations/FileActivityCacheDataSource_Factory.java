package com.box.android.data.datasource.annotations;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileActivityCacheDataSource_Factory implements Factory<FileActivityCacheDataSource> {
    private final Provider<UserData> userDataProvider;

    private FileActivityCacheDataSource_Factory(Provider<UserData> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileActivityCacheDataSource get() {
        return newInstance(this.userDataProvider.get());
    }

    public static FileActivityCacheDataSource_Factory create(Provider<UserData> userDataProvider) {
        return new FileActivityCacheDataSource_Factory(userDataProvider);
    }

    public static FileActivityCacheDataSource newInstance(UserData userData) {
        return new FileActivityCacheDataSource(userData);
    }
}
