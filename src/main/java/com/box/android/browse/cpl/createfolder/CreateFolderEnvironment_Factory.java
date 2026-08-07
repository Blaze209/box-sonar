package com.box.android.browse.cpl.createfolder;

import com.box.android.base.cpl.IItemNameValidator;
import com.box.android.browse.utilities.ICreateFolderHelper;
import com.box.android.domain.usecases.browse.CreateFolderUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CreateFolderEnvironment_Factory implements Factory<CreateFolderEnvironment> {
    private final Provider<ICreateFolderHelper> createFolderHelperProvider;
    private final Provider<CreateFolderUseCase> createFolderUseCaseProvider;
    private final Provider<IItemNameValidator> itemNameValidatorProvider;

    private CreateFolderEnvironment_Factory(Provider<CreateFolderUseCase> provider, Provider<ICreateFolderHelper> provider2, Provider<IItemNameValidator> provider3) {
        this.createFolderUseCaseProvider = provider;
        this.createFolderHelperProvider = provider2;
        this.itemNameValidatorProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateFolderEnvironment get() {
        return newInstance(this.createFolderUseCaseProvider.get(), this.createFolderHelperProvider.get(), this.itemNameValidatorProvider.get());
    }

    public static CreateFolderEnvironment_Factory create(Provider<CreateFolderUseCase> provider, Provider<ICreateFolderHelper> provider2, Provider<IItemNameValidator> provider3) {
        return new CreateFolderEnvironment_Factory(provider, provider2, provider3);
    }

    public static CreateFolderEnvironment newInstance(CreateFolderUseCase createFolderUseCase, ICreateFolderHelper iCreateFolderHelper, IItemNameValidator iItemNameValidator) {
        return new CreateFolderEnvironment(createFolderUseCase, iCreateFolderHelper, iItemNameValidator);
    }
}
