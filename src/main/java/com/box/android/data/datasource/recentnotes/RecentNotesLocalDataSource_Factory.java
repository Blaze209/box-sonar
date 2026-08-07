package com.box.android.data.datasource.recentnotes;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RecentNotesLocalDataSource_Factory implements Factory<RecentNotesLocalDataSource> {
    private final Provider<UserData> userDataProvider;

    private RecentNotesLocalDataSource_Factory(Provider<UserData> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecentNotesLocalDataSource get() {
        return newInstance(this.userDataProvider.get());
    }

    public static RecentNotesLocalDataSource_Factory create(Provider<UserData> userDataProvider) {
        return new RecentNotesLocalDataSource_Factory(userDataProvider);
    }

    public static RecentNotesLocalDataSource newInstance(UserData userData) {
        return new RecentNotesLocalDataSource(userData);
    }
}
