package com.box.android.preview;

import com.box.android.coreservices.utilities.PreviewOrigin;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.preview.PreviewContentType;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxThumbnailRequests.kt */
/* JADX INFO: loaded from: classes12.dex */
@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/BoxThumbnailRequests;", "", "<init>", "()V", "getCachePreviewRequest", "Lcom/box/androidsdk/content/requests/BoxRequestsFile$DownloadThumbnail;", "previewController", "Lcom/box/android/domain/controller/IPreviewController;", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "session", "Lcom/box/androidsdk/content/models/BoxSession;", "createPreviewContentType", "Lcom/box/android/domain/preview/PreviewContentType$Representation;", "format", "Lcom/box/androidsdk/content/requests/BoxRequestsFile$DownloadThumbnail$Format;", "previewMinWith", "", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxThumbnailRequests {
    public static final int $stable = 0;
    private static final int PREVIEW_MIN_WIDTH = 1024;

    @Inject
    public BoxThumbnailRequests() {
    }

    public final BoxRequestsFile.DownloadThumbnail getCachePreviewRequest(IPreviewController previewController, BoxFile boxFile, BoxSession session) {
        Intrinsics.checkNotNullParameter(previewController, "previewController");
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        Intrinsics.checkNotNullParameter(session, "session");
        if (session.getAuthInfo() == null) {
            throw new IllegalArgumentException("A valid BoxSession must be provided to cache image preview".toString());
        }
        return previewController.getApiPreview().getDownloadThumbnailRequest(previewController.getStorage().createPreviewOutputStream(boxFile, (String) null, createPreviewContentType(BoxRequestsFile.DownloadThumbnail.Format.JPG, 1024)), boxFile.getUserId()).setMinSize(1024).setFormat(BoxRequestsFile.DownloadThumbnail.Format.JPG);
    }

    public final PreviewContentType.Representation createPreviewContentType(BoxRequestsFile.DownloadThumbnail.Format format, int previewMinWith) {
        Intrinsics.checkNotNullParameter(format, "format");
        PreviewOrigin previewOrigin = PreviewOrigin.INSTANCE;
        String string = format.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return previewOrigin.representationWithExtension(string, Integer.valueOf(previewMinWith));
    }
}
