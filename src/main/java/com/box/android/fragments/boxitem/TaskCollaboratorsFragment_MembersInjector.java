package com.box.android.fragments.boxitem;

import com.box.android.domain.identity.IUserContextManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class TaskCollaboratorsFragment_MembersInjector implements MembersInjector<TaskCollaboratorsFragment> {
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private TaskCollaboratorsFragment_MembersInjector(Provider<IUserContextManager> provider) {
        this.mUserContextManagerProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TaskCollaboratorsFragment taskCollaboratorsFragment) {
        injectMUserContextManager(taskCollaboratorsFragment, this.mUserContextManagerProvider.get());
    }

    public static MembersInjector<TaskCollaboratorsFragment> create(Provider<IUserContextManager> provider) {
        return new TaskCollaboratorsFragment_MembersInjector(provider);
    }

    public static void injectMUserContextManager(TaskCollaboratorsFragment taskCollaboratorsFragment, IUserContextManager iUserContextManager) {
        taskCollaboratorsFragment.mUserContextManager = iUserContextManager;
    }
}
