package com.box.android.browse.utilities;

import android.content.Context;
import com.box.android.browse.fragments.SearchFragment;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class FilesSearchHelper_Factory implements Factory<FilesSearchHelper> {
    private final Provider<IBrowseController> browseControllerProvider;
    private final Provider<Context> contextProvider;
    private final Provider<SearchFragment.SearchActionLogHelper> searchActionLogHelperProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private FilesSearchHelper_Factory(Provider<IBrowseController> provider, Provider<IUserContextManager> provider2, Provider<SearchFragment.SearchActionLogHelper> provider3, Provider<Context> provider4) {
        this.browseControllerProvider = provider;
        this.userContextManagerProvider = provider2;
        this.searchActionLogHelperProvider = provider3;
        this.contextProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesSearchHelper get() {
        return newInstance(this.browseControllerProvider.get(), this.userContextManagerProvider.get(), this.searchActionLogHelperProvider.get(), this.contextProvider.get());
    }

    public static FilesSearchHelper_Factory create(Provider<IBrowseController> provider, Provider<IUserContextManager> provider2, Provider<SearchFragment.SearchActionLogHelper> provider3, Provider<Context> provider4) {
        return new FilesSearchHelper_Factory(provider, provider2, provider3, provider4);
    }

    public static FilesSearchHelper newInstance(IBrowseController iBrowseController, IUserContextManager iUserContextManager, SearchFragment.SearchActionLogHelper searchActionLogHelper, Context context) {
        return new FilesSearchHelper(iBrowseController, iUserContextManager, searchActionLogHelper, context);
    }
}
