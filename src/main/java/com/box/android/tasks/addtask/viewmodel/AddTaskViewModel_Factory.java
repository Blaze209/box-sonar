package com.box.android.tasks.addtask.viewmodel;

import androidx.lifecycle.SavedStateHandle;
import com.box.android.cpl.IStoreFactory;
import com.box.android.tasks.addtask.cpl.AddTaskEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class AddTaskViewModel_Factory implements Factory<AddTaskViewModel> {
    private final Provider<AddTaskEnvironment> environmentProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private AddTaskViewModel_Factory(Provider<AddTaskEnvironment> provider, Provider<IStoreFactory> provider2, Provider<SavedStateHandle> provider3) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
        this.savedStateHandleProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AddTaskViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get(), this.savedStateHandleProvider.get());
    }

    public static AddTaskViewModel_Factory create(Provider<AddTaskEnvironment> provider, Provider<IStoreFactory> provider2, Provider<SavedStateHandle> provider3) {
        return new AddTaskViewModel_Factory(provider, provider2, provider3);
    }

    public static AddTaskViewModel newInstance(AddTaskEnvironment addTaskEnvironment, IStoreFactory iStoreFactory, SavedStateHandle savedStateHandle) {
        return new AddTaskViewModel(addTaskEnvironment, iStoreFactory, savedStateHandle);
    }
}
