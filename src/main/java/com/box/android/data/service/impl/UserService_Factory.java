package com.box.android.data.service.impl;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UserService_Factory implements Factory<UserService> {
    private final Provider<UserData> userDataProvider;

    private UserService_Factory(Provider<UserData> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UserService get() {
        return newInstance(this.userDataProvider.get());
    }

    public static UserService_Factory create(Provider<UserData> userDataProvider) {
        return new UserService_Factory(userDataProvider);
    }

    public static UserService newInstance(UserData userData) {
        return new UserService(userData);
    }
}
