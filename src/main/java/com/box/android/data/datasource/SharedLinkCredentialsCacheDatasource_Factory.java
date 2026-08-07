package com.box.android.data.datasource;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class SharedLinkCredentialsCacheDatasource_Factory implements Factory<SharedLinkCredentialsCacheDatasource> {
    private final Provider<UserData> userDataProvider;

    private SharedLinkCredentialsCacheDatasource_Factory(Provider<UserData> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SharedLinkCredentialsCacheDatasource get() {
        return newInstance(this.userDataProvider.get());
    }

    public static SharedLinkCredentialsCacheDatasource_Factory create(Provider<UserData> userDataProvider) {
        return new SharedLinkCredentialsCacheDatasource_Factory(userDataProvider);
    }

    public static SharedLinkCredentialsCacheDatasource newInstance(UserData userData) {
        return new SharedLinkCredentialsCacheDatasource(userData);
    }
}
