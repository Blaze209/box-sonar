package com.pspdfkit.document;

import io.reactivex.rxjava3.core.Single;

/* JADX INFO: loaded from: classes3.dex */
public interface ImageDocument {
    PdfDocument getDocument();

    DocumentSource getImageDocumentSource();

    boolean isValidForEditing();

    boolean saveIfModified();

    boolean saveIfModified(DocumentSaveOptions documentSaveOptions, boolean z);

    boolean saveIfModified(boolean z);

    Single<Boolean> saveIfModifiedAsync();

    Single<Boolean> saveIfModifiedAsync(DocumentSaveOptions documentSaveOptions, boolean z);

    Single<Boolean> saveIfModifiedAsync(boolean z);
}
