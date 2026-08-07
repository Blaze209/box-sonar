package com.box.android.browse.search;

import com.box.android.browse.utilities.FilesSearchHelper;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class FilesSearchEnvironment_Factory implements Factory<FilesSearchEnvironment> {
    private final Provider<FilesSearchHelper> filesSearchHelperProvider;

    private FilesSearchEnvironment_Factory(Provider<FilesSearchHelper> provider) {
        this.filesSearchHelperProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesSearchEnvironment get() {
        return newInstance(this.filesSearchHelperProvider.get());
    }

    public static FilesSearchEnvironment_Factory create(Provider<FilesSearchHelper> provider) {
        return new FilesSearchEnvironment_Factory(provider);
    }

    public static FilesSearchEnvironment newInstance(FilesSearchHelper filesSearchHelper) {
        return new FilesSearchEnvironment(filesSearchHelper);
    }
}
