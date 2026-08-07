package com.box.android.data.datasource.observability;

import android.content.Context;
import com.box.android.data.persistence.IFileSystem;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class LogsCacheDataSource_Factory implements Factory<LogsCacheDataSource> {
    private final Provider<Context> appContextProvider;
    private final Provider<IFileSystem> fileSystemProvider;
    private final Provider<Moshi> moshiProvider;

    private LogsCacheDataSource_Factory(Provider<Context> appContextProvider, Provider<Moshi> moshiProvider, Provider<IFileSystem> fileSystemProvider) {
        this.appContextProvider = appContextProvider;
        this.moshiProvider = moshiProvider;
        this.fileSystemProvider = fileSystemProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LogsCacheDataSource get() {
        return newInstance(this.appContextProvider.get(), this.moshiProvider.get(), this.fileSystemProvider.get());
    }

    public static LogsCacheDataSource_Factory create(Provider<Context> appContextProvider, Provider<Moshi> moshiProvider, Provider<IFileSystem> fileSystemProvider) {
        return new LogsCacheDataSource_Factory(appContextProvider, moshiProvider, fileSystemProvider);
    }

    public static LogsCacheDataSource newInstance(Context appContext, Moshi moshi, IFileSystem fileSystem) {
        return new LogsCacheDataSource(appContext, moshi, fileSystem);
    }
}
