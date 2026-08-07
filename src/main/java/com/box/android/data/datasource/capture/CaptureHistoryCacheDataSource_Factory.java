package com.box.android.data.datasource.capture;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CaptureHistoryCacheDataSource_Factory implements Factory<CaptureHistoryCacheDataSource> {
    private final Provider<UserData> userDataProvider;

    private CaptureHistoryCacheDataSource_Factory(Provider<UserData> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureHistoryCacheDataSource get() {
        return newInstance(this.userDataProvider.get());
    }

    public static CaptureHistoryCacheDataSource_Factory create(Provider<UserData> userDataProvider) {
        return new CaptureHistoryCacheDataSource_Factory(userDataProvider);
    }

    public static CaptureHistoryCacheDataSource newInstance(UserData userData) {
        return new CaptureHistoryCacheDataSource(userData);
    }
}
