package com.box.android.di;

import com.box.android.browse.fragments.SearchFragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideTimeLogHelperFactory implements Factory<SearchFragment.TimeLogHelper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SearchFragment.TimeLogHelper get() {
        return provideTimeLogHelper();
    }

    public static DefaultModule_Companion_ProvideTimeLogHelperFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SearchFragment.TimeLogHelper provideTimeLogHelper() {
        return (SearchFragment.TimeLogHelper) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideTimeLogHelper());
    }

    private static final class InstanceHolder {
        static final DefaultModule_Companion_ProvideTimeLogHelperFactory INSTANCE = new DefaultModule_Companion_ProvideTimeLogHelperFactory();

        private InstanceHolder() {
        }
    }
}
