package com.box.android.data.datasource.jobs;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class JobsDataSource_Factory implements Factory<JobsDataSource> {
    private final Provider<UserData> userDataProvider;

    private JobsDataSource_Factory(Provider<UserData> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobsDataSource get() {
        return newInstance(this.userDataProvider.get());
    }

    public static JobsDataSource_Factory create(Provider<UserData> userDataProvider) {
        return new JobsDataSource_Factory(userDataProvider);
    }

    public static JobsDataSource newInstance(UserData userData) {
        return new JobsDataSource(userData);
    }
}
