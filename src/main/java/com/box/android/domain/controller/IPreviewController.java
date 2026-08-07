package com.box.android.domain.controller;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.androidsdk.content.BoxApiFolder;
import com.box.androidsdk.content.BoxApiPreview;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFile;
import java.io.InputStream;

/* JADX INFO: loaded from: classes11.dex */
public interface IPreviewController {
    InputStream downloadThumbnail(BoxFile boxFile, int i, boolean z) throws BoxException;

    void execute(Runnable runnable);

    BoxApiFolder getApiFolder();

    BoxApiPreview getApiPreview();

    IBrowseController getBrowseController();

    FeatureFlips getFeatureFlips();

    IBoxStorage getStorage();

    boolean isTextSelectionEnabled();
}
