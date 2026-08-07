package com.box.android.domain.usecases.notes;

import com.box.android.domain.services.IDefaultNoteFolderService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ResolveNewNoteLocationInteractor_Factory implements Factory<ResolveNewNoteLocationInteractor> {
    private final Provider<IDefaultNoteFolderService> defaultNoteFolderServiceProvider;
    private final Provider<NoteNameGenerator> noteNameGeneratorProvider;

    private ResolveNewNoteLocationInteractor_Factory(Provider<IDefaultNoteFolderService> provider, Provider<NoteNameGenerator> provider2) {
        this.defaultNoteFolderServiceProvider = provider;
        this.noteNameGeneratorProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ResolveNewNoteLocationInteractor get() {
        return newInstance(this.defaultNoteFolderServiceProvider.get(), this.noteNameGeneratorProvider.get());
    }

    public static ResolveNewNoteLocationInteractor_Factory create(Provider<IDefaultNoteFolderService> provider, Provider<NoteNameGenerator> provider2) {
        return new ResolveNewNoteLocationInteractor_Factory(provider, provider2);
    }

    public static ResolveNewNoteLocationInteractor newInstance(IDefaultNoteFolderService iDefaultNoteFolderService, NoteNameGenerator noteNameGenerator) {
        return new ResolveNewNoteLocationInteractor(iDefaultNoteFolderService, noteNameGenerator);
    }
}
