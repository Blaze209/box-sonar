package com.box.android.data.datasource;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DocumentScanCacheDataSource_Factory implements Factory<DocumentScanCacheDataSource> {
    private final Provider<UserData> userDataProvider;

    private DocumentScanCacheDataSource_Factory(Provider<UserData> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DocumentScanCacheDataSource get() {
        return newInstance(this.userDataProvider.get());
    }

    public static DocumentScanCacheDataSource_Factory create(Provider<UserData> userDataProvider) {
        return new DocumentScanCacheDataSource_Factory(userDataProvider);
    }

    public static DocumentScanCacheDataSource newInstance(UserData userData) {
        return new DocumentScanCacheDataSource(userData);
    }
}
