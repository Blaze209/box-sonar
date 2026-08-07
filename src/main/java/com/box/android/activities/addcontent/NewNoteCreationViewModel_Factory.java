package com.box.android.activities.addcontent;

import com.box.android.cpl.IStoreFactory;
import com.box.android.domain.services.IDefaultNoteFolderService;
import com.box.android.domain.usecases.notes.ResolveNewNoteLocationUseCase;
import com.box.android.domain.usecases.notes.SetDefaultNoteFolderUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class NewNoteCreationViewModel_Factory implements Factory<NewNoteCreationViewModel> {
    private final Provider<IDefaultNoteFolderService> defaultNoteFolderServiceProvider;
    private final Provider<ResolveNewNoteLocationUseCase> resolveNewNoteLocationUseCaseProvider;
    private final Provider<SetDefaultNoteFolderUseCase> setDefaultNoteFolderUseCaseProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private NewNoteCreationViewModel_Factory(Provider<ResolveNewNoteLocationUseCase> provider, Provider<SetDefaultNoteFolderUseCase> provider2, Provider<IDefaultNoteFolderService> provider3, Provider<IStoreFactory> provider4) {
        this.resolveNewNoteLocationUseCaseProvider = provider;
        this.setDefaultNoteFolderUseCaseProvider = provider2;
        this.defaultNoteFolderServiceProvider = provider3;
        this.storeFactoryProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NewNoteCreationViewModel get() {
        return newInstance(this.resolveNewNoteLocationUseCaseProvider.get(), this.setDefaultNoteFolderUseCaseProvider.get(), this.defaultNoteFolderServiceProvider.get(), this.storeFactoryProvider.get());
    }

    public static NewNoteCreationViewModel_Factory create(Provider<ResolveNewNoteLocationUseCase> provider, Provider<SetDefaultNoteFolderUseCase> provider2, Provider<IDefaultNoteFolderService> provider3, Provider<IStoreFactory> provider4) {
        return new NewNoteCreationViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static NewNoteCreationViewModel newInstance(ResolveNewNoteLocationUseCase resolveNewNoteLocationUseCase, SetDefaultNoteFolderUseCase setDefaultNoteFolderUseCase, IDefaultNoteFolderService iDefaultNoteFolderService, IStoreFactory iStoreFactory) {
        return new NewNoteCreationViewModel(resolveNewNoteLocationUseCase, setDefaultNoteFolderUseCase, iDefaultNoteFolderService, iStoreFactory);
    }
}
