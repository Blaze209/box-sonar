package com.box.android.di;

import com.box.android.browse.fragments.SearchFragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideSearchActionLogHelperFactory implements Factory<SearchFragment.SearchActionLogHelper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SearchFragment.SearchActionLogHelper get() {
        return provideSearchActionLogHelper();
    }

    public static DefaultModule_Companion_ProvideSearchActionLogHelperFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SearchFragment.SearchActionLogHelper provideSearchActionLogHelper() {
        return (SearchFragment.SearchActionLogHelper) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideSearchActionLogHelper());
    }

    private static final class InstanceHolder {
        static final DefaultModule_Companion_ProvideSearchActionLogHelperFactory INSTANCE = new DefaultModule_Companion_ProvideSearchActionLogHelperFactory();

        private InstanceHolder() {
        }
    }
}
