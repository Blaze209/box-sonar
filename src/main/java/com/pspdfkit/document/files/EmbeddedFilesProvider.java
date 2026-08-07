package com.pspdfkit.document.files;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface EmbeddedFilesProvider {

    public interface EmbeddedFilesCallback {
        default void onError(Throwable th) {
        }

        boolean onFilesFound(Collection<EmbeddedFile> collection, Collection<EmbeddedFile> collection2, int i, boolean z);

        default boolean onPageProgress(int i, int i2) {
            return true;
        }
    }

    Maybe<EmbeddedFile> getEmbeddedFileWithFileNameAsync(String str, boolean z);

    Maybe<EmbeddedFile> getEmbeddedFileWithIdAsync(String str, boolean z);

    List<EmbeddedFile> getEmbeddedFiles(boolean z);

    Single<List<EmbeddedFile>> getEmbeddedFilesAsync(boolean z);

    void getEmbeddedFilesProgressive(boolean z, EmbeddedFilesCallback embeddedFilesCallback);

    boolean hasEmbeddedFiles();
}
