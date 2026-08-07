package com.box.android.data.persistence.gql;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLDbHelper_Factory implements Factory<GQLDbHelper> {
    private final Provider<UserData> userDataProvider;

    private GQLDbHelper_Factory(Provider<UserData> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLDbHelper get() {
        return newInstance(this.userDataProvider.get());
    }

    public static GQLDbHelper_Factory create(Provider<UserData> userDataProvider) {
        return new GQLDbHelper_Factory(userDataProvider);
    }

    public static GQLDbHelper newInstance(UserData userData) {
        return new GQLDbHelper(userData);
    }
}
