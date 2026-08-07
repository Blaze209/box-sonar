package com.box.android.data.user;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UserData_Factory implements Factory<UserData> {
    private final Provider<Context> contextProvider;
    private final Provider<DatabaseProvider> databaseProvider;

    private UserData_Factory(Provider<Context> contextProvider, Provider<DatabaseProvider> databaseProvider) {
        this.contextProvider = contextProvider;
        this.databaseProvider = databaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UserData get() {
        return newInstance(this.contextProvider.get(), this.databaseProvider.get());
    }

    public static UserData_Factory create(Provider<Context> contextProvider, Provider<DatabaseProvider> databaseProvider) {
        return new UserData_Factory(contextProvider, databaseProvider);
    }

    public static UserData newInstance(Context context, DatabaseProvider databaseProvider) {
        return new UserData(context, databaseProvider);
    }
}
