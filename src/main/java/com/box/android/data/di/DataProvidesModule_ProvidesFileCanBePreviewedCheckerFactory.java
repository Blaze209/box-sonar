package com.box.android.data.di;

import com.box.android.data.service.impl.preview.helpers.FileCanBePreviewedChecker;
import com.box.android.domain.preview.IFileCanBePreviewedChecker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvidesFileCanBePreviewedCheckerFactory implements Factory<IFileCanBePreviewedChecker> {
    private final Provider<FileCanBePreviewedChecker> checkerProvider;
    private final DataProvidesModule module;

    private DataProvidesModule_ProvidesFileCanBePreviewedCheckerFactory(DataProvidesModule module, Provider<FileCanBePreviewedChecker> checkerProvider) {
        this.module = module;
        this.checkerProvider = checkerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IFileCanBePreviewedChecker get() {
        return providesFileCanBePreviewedChecker(this.module, this.checkerProvider.get());
    }

    public static DataProvidesModule_ProvidesFileCanBePreviewedCheckerFactory create(DataProvidesModule module, Provider<FileCanBePreviewedChecker> checkerProvider) {
        return new DataProvidesModule_ProvidesFileCanBePreviewedCheckerFactory(module, checkerProvider);
    }

    public static IFileCanBePreviewedChecker providesFileCanBePreviewedChecker(DataProvidesModule instance, FileCanBePreviewedChecker checker) {
        return (IFileCanBePreviewedChecker) Preconditions.checkNotNullFromProvides(instance.providesFileCanBePreviewedChecker(checker));
    }
}
