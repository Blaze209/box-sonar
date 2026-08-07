package com.box.android.data.datasource.comment;

import com.box.android.data.user.UserData;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CommentCacheDataSource_Factory implements Factory<CommentCacheDataSource> {
    private final Provider<UserData> userDataProvider;

    private CommentCacheDataSource_Factory(Provider<UserData> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CommentCacheDataSource get() {
        return newInstance(this.userDataProvider.get());
    }

    public static CommentCacheDataSource_Factory create(Provider<UserData> userDataProvider) {
        return new CommentCacheDataSource_Factory(userDataProvider);
    }

    public static CommentCacheDataSource newInstance(UserData userData) {
        return new CommentCacheDataSource(userData);
    }
}
