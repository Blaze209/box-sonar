package com.pspdfkit.internal;

import android.net.Uri;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.providers.DataProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class ue {
    public static final String a(DocumentSource documentSource) {
        DataProvider dataProvider;
        documentSource.getClass();
        if (documentSource.getFileUri() != null) {
            Uri fileUri = documentSource.getFileUri();
            if (fileUri != null) {
                return wg.a(fileUri);
            }
            throw new IllegalStateException("fileUri is null");
        }
        if (documentSource.getDataProvider() == null || (dataProvider = documentSource.getDataProvider()) == null) {
            return null;
        }
        return dataProvider.getTitle();
    }
}
