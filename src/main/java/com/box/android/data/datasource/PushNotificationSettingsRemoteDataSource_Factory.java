package com.box.android.data.datasource;

import com.box.android.data.api.requests.PushNotificationSettingsRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PushNotificationSettingsRemoteDataSource_Factory implements Factory<PushNotificationSettingsRemoteDataSource> {
    private final Provider<Moshi> moshiProvider;
    private final Provider<PushNotificationSettingsRequest> pushNotificationSettingsRequestProvider;

    private PushNotificationSettingsRemoteDataSource_Factory(Provider<PushNotificationSettingsRequest> pushNotificationSettingsRequestProvider, Provider<Moshi> moshiProvider) {
        this.pushNotificationSettingsRequestProvider = pushNotificationSettingsRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PushNotificationSettingsRemoteDataSource get() {
        return newInstance(this.pushNotificationSettingsRequestProvider.get(), this.moshiProvider.get());
    }

    public static PushNotificationSettingsRemoteDataSource_Factory create(Provider<PushNotificationSettingsRequest> pushNotificationSettingsRequestProvider, Provider<Moshi> moshiProvider) {
        return new PushNotificationSettingsRemoteDataSource_Factory(pushNotificationSettingsRequestProvider, moshiProvider);
    }

    public static PushNotificationSettingsRemoteDataSource newInstance(PushNotificationSettingsRequest pushNotificationSettingsRequest, Moshi moshi) {
        return new PushNotificationSettingsRemoteDataSource(pushNotificationSettingsRequest, moshi);
    }
}
