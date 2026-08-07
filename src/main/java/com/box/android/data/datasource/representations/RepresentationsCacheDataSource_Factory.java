package com.box.android.data.datasource.representations;

import com.box.android.data.mappers.representations.RepresentationDTOEntityMapper;
import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RepresentationsCacheDataSource_Factory implements Factory<RepresentationsCacheDataSource> {
    private final Provider<RepresentationDTOEntityMapper> mapperProvider;
    private final Provider<UserData> userDataProvider;

    private RepresentationsCacheDataSource_Factory(Provider<UserData> userDataProvider, Provider<RepresentationDTOEntityMapper> mapperProvider) {
        this.userDataProvider = userDataProvider;
        this.mapperProvider = mapperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RepresentationsCacheDataSource get() {
        return newInstance(this.userDataProvider.get(), this.mapperProvider.get());
    }

    public static RepresentationsCacheDataSource_Factory create(Provider<UserData> userDataProvider, Provider<RepresentationDTOEntityMapper> mapperProvider) {
        return new RepresentationsCacheDataSource_Factory(userDataProvider, mapperProvider);
    }

    public static RepresentationsCacheDataSource newInstance(UserData userData, RepresentationDTOEntityMapper mapper) {
        return new RepresentationsCacheDataSource(userData, mapper);
    }
}
