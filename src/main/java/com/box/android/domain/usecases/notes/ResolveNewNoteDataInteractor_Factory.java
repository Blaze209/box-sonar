package com.box.android.domain.usecases.notes;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ResolveNewNoteDataInteractor_Factory implements Factory<ResolveNewNoteDataInteractor> {
    private final Provider<NoteNameGenerator> noteNameGeneratorProvider;

    private ResolveNewNoteDataInteractor_Factory(Provider<NoteNameGenerator> provider) {
        this.noteNameGeneratorProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ResolveNewNoteDataInteractor get() {
        return newInstance(this.noteNameGeneratorProvider.get());
    }

    public static ResolveNewNoteDataInteractor_Factory create(Provider<NoteNameGenerator> provider) {
        return new ResolveNewNoteDataInteractor_Factory(provider);
    }

    public static ResolveNewNoteDataInteractor newInstance(NoteNameGenerator noteNameGenerator) {
        return new ResolveNewNoteDataInteractor(noteNameGenerator);
    }
}
