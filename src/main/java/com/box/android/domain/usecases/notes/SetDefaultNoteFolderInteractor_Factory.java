package com.box.android.domain.usecases.notes;

import com.box.android.domain.services.IDefaultNoteFolderService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class SetDefaultNoteFolderInteractor_Factory implements Factory<SetDefaultNoteFolderInteractor> {
    private final Provider<IDefaultNoteFolderService> defaultNoteFolderServiceProvider;
    private final Provider<NoteNameGenerator> noteNameGeneratorProvider;

    private SetDefaultNoteFolderInteractor_Factory(Provider<IDefaultNoteFolderService> provider, Provider<NoteNameGenerator> provider2) {
        this.defaultNoteFolderServiceProvider = provider;
        this.noteNameGeneratorProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SetDefaultNoteFolderInteractor get() {
        return newInstance(this.defaultNoteFolderServiceProvider.get(), this.noteNameGeneratorProvider.get());
    }

    public static SetDefaultNoteFolderInteractor_Factory create(Provider<IDefaultNoteFolderService> provider, Provider<NoteNameGenerator> provider2) {
        return new SetDefaultNoteFolderInteractor_Factory(provider, provider2);
    }

    public static SetDefaultNoteFolderInteractor newInstance(IDefaultNoteFolderService iDefaultNoteFolderService, NoteNameGenerator noteNameGenerator) {
        return new SetDefaultNoteFolderInteractor(iDefaultNoteFolderService, noteNameGenerator);
    }
}
