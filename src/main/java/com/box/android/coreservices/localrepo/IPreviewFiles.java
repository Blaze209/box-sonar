package com.box.android.coreservices.localrepo;

import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public interface IPreviewFiles {
    void clearInMemoryCache();

    void deleteAllEncryptedPreviews();

    void deleteAllInternalPreviews();

    File getExternalPreviewDirectory();
}
