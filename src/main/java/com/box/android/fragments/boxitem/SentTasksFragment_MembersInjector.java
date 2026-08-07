package com.box.android.fragments.boxitem;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.vm.TasksVMFactory;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class SentTasksFragment_MembersInjector implements MembersInjector<SentTasksFragment> {
    private final Provider<BoxExtendedApiFile> mBoxExtendedApiFileProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<TasksVMFactory> mTasksVMFactoryProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private SentTasksFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<BoxExtendedApiFile> provider2, Provider<FeatureFlips> provider3, Provider<TasksVMFactory> provider4) {
        this.mUserContextManagerProvider = provider;
        this.mBoxExtendedApiFileProvider = provider2;
        this.mFeatureFlipsProvider = provider3;
        this.mTasksVMFactoryProvider = provider4;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SentTasksFragment sentTasksFragment) {
        TasksFragment_MembersInjector.injectMUserContextManager(sentTasksFragment, this.mUserContextManagerProvider.get());
        TasksFragment_MembersInjector.injectMBoxExtendedApiFile(sentTasksFragment, this.mBoxExtendedApiFileProvider.get());
        TasksFragment_MembersInjector.injectMFeatureFlips(sentTasksFragment, this.mFeatureFlipsProvider.get());
        injectMTasksVMFactory(sentTasksFragment, this.mTasksVMFactoryProvider.get());
    }

    public static MembersInjector<SentTasksFragment> create(Provider<IUserContextManager> provider, Provider<BoxExtendedApiFile> provider2, Provider<FeatureFlips> provider3, Provider<TasksVMFactory> provider4) {
        return new SentTasksFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectMTasksVMFactory(SentTasksFragment sentTasksFragment, TasksVMFactory tasksVMFactory) {
        sentTasksFragment.mTasksVMFactory = tasksVMFactory;
    }
}
