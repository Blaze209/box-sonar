package com.box.android.fragments.boxitem;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.vm.TasksVMFactory;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MyTasksFragment_MembersInjector implements MembersInjector<MyTasksFragment> {
    private final Provider<BoxExtendedApiFile> mBoxExtendedApiFileProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<TasksVMFactory> mTasksVMFactoryProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private MyTasksFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<BoxExtendedApiFile> provider2, Provider<FeatureFlips> provider3, Provider<TasksVMFactory> provider4) {
        this.mUserContextManagerProvider = provider;
        this.mBoxExtendedApiFileProvider = provider2;
        this.mFeatureFlipsProvider = provider3;
        this.mTasksVMFactoryProvider = provider4;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MyTasksFragment myTasksFragment) {
        TasksFragment_MembersInjector.injectMUserContextManager(myTasksFragment, this.mUserContextManagerProvider.get());
        TasksFragment_MembersInjector.injectMBoxExtendedApiFile(myTasksFragment, this.mBoxExtendedApiFileProvider.get());
        TasksFragment_MembersInjector.injectMFeatureFlips(myTasksFragment, this.mFeatureFlipsProvider.get());
        injectMTasksVMFactory(myTasksFragment, this.mTasksVMFactoryProvider.get());
    }

    public static MembersInjector<MyTasksFragment> create(Provider<IUserContextManager> provider, Provider<BoxExtendedApiFile> provider2, Provider<FeatureFlips> provider3, Provider<TasksVMFactory> provider4) {
        return new MyTasksFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectMTasksVMFactory(MyTasksFragment myTasksFragment, TasksVMFactory tasksVMFactory) {
        myTasksFragment.mTasksVMFactory = tasksVMFactory;
    }
}
