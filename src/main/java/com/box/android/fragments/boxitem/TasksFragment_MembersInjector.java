package com.box.android.fragments.boxitem;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class TasksFragment_MembersInjector implements MembersInjector<TasksFragment> {
    private final Provider<BoxExtendedApiFile> mBoxExtendedApiFileProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private TasksFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<BoxExtendedApiFile> provider2, Provider<FeatureFlips> provider3) {
        this.mUserContextManagerProvider = provider;
        this.mBoxExtendedApiFileProvider = provider2;
        this.mFeatureFlipsProvider = provider3;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TasksFragment tasksFragment) {
        injectMUserContextManager(tasksFragment, this.mUserContextManagerProvider.get());
        injectMBoxExtendedApiFile(tasksFragment, this.mBoxExtendedApiFileProvider.get());
        injectMFeatureFlips(tasksFragment, this.mFeatureFlipsProvider.get());
    }

    public static MembersInjector<TasksFragment> create(Provider<IUserContextManager> provider, Provider<BoxExtendedApiFile> provider2, Provider<FeatureFlips> provider3) {
        return new TasksFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectMUserContextManager(TasksFragment tasksFragment, IUserContextManager iUserContextManager) {
        tasksFragment.mUserContextManager = iUserContextManager;
    }

    public static void injectMBoxExtendedApiFile(TasksFragment tasksFragment, BoxExtendedApiFile boxExtendedApiFile) {
        tasksFragment.mBoxExtendedApiFile = boxExtendedApiFile;
    }

    public static void injectMFeatureFlips(TasksFragment tasksFragment, FeatureFlips featureFlips) {
        tasksFragment.mFeatureFlips = featureFlips;
    }
}
