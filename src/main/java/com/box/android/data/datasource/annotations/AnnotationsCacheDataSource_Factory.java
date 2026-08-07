package com.box.android.data.datasource.annotations;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AnnotationsCacheDataSource_Factory implements Factory<AnnotationsCacheDataSource> {
    private final Provider<UserData> userDataProvider;

    private AnnotationsCacheDataSource_Factory(Provider<UserData> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AnnotationsCacheDataSource get() {
        return newInstance(this.userDataProvider.get());
    }

    public static AnnotationsCacheDataSource_Factory create(Provider<UserData> userDataProvider) {
        return new AnnotationsCacheDataSource_Factory(userDataProvider);
    }

    public static AnnotationsCacheDataSource newInstance(UserData userData) {
        return new AnnotationsCacheDataSource(userData);
    }
}
