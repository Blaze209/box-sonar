package com.box.android.preview.previewtype.boxnote;

import com.box.android.domain.preview.IFileCanBePreviewedChecker;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.ISessionManager;
import com.box.android.preview.preview.PreviewAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotesEnvironment;", "", "sessionManager", "Lcom/box/android/domain/services/ISessionManager;", "urlBuilder", "Lcom/box/android/preview/previewtype/boxnote/BoxNotesUrlBuilder;", "editModeEnvironment", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeEnvironment;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "fileCanBePreviewedChecker", "Lcom/box/android/domain/preview/IFileCanBePreviewedChecker;", "previewAnalytics", "Lcom/box/android/preview/preview/PreviewAnalytics;", "<init>", "(Lcom/box/android/domain/services/ISessionManager;Lcom/box/android/preview/previewtype/boxnote/BoxNotesUrlBuilder;Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeEnvironment;Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/domain/preview/IFileCanBePreviewedChecker;Lcom/box/android/preview/preview/PreviewAnalytics;)V", "getSessionManager", "()Lcom/box/android/domain/services/ISessionManager;", "getUrlBuilder", "()Lcom/box/android/preview/previewtype/boxnote/BoxNotesUrlBuilder;", "getEditModeEnvironment", "()Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeEnvironment;", "getItemService", "()Lcom/box/android/domain/services/IRemoteItemService;", "getFileCanBePreviewedChecker", "()Lcom/box/android/domain/preview/IFileCanBePreviewedChecker;", "getPreviewAnalytics", "()Lcom/box/android/preview/preview/PreviewAnalytics;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxNotesEnvironment {
    public static final int $stable = 8;
    private final BoxNoteEditModeEnvironment editModeEnvironment;
    private final IFileCanBePreviewedChecker fileCanBePreviewedChecker;
    private final IRemoteItemService itemService;
    private final PreviewAnalytics previewAnalytics;
    private final ISessionManager sessionManager;
    private final BoxNotesUrlBuilder urlBuilder;

    @Inject
    public BoxNotesEnvironment(ISessionManager sessionManager, BoxNotesUrlBuilder urlBuilder, BoxNoteEditModeEnvironment editModeEnvironment, IRemoteItemService itemService, IFileCanBePreviewedChecker fileCanBePreviewedChecker, PreviewAnalytics previewAnalytics) {
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(urlBuilder, "urlBuilder");
        Intrinsics.checkNotNullParameter(editModeEnvironment, "editModeEnvironment");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(fileCanBePreviewedChecker, "fileCanBePreviewedChecker");
        Intrinsics.checkNotNullParameter(previewAnalytics, "previewAnalytics");
        this.sessionManager = sessionManager;
        this.urlBuilder = urlBuilder;
        this.editModeEnvironment = editModeEnvironment;
        this.itemService = itemService;
        this.fileCanBePreviewedChecker = fileCanBePreviewedChecker;
        this.previewAnalytics = previewAnalytics;
    }

    public final ISessionManager getSessionManager() {
        return this.sessionManager;
    }

    public final BoxNotesUrlBuilder getUrlBuilder() {
        return this.urlBuilder;
    }

    public final BoxNoteEditModeEnvironment getEditModeEnvironment() {
        return this.editModeEnvironment;
    }

    public final IRemoteItemService getItemService() {
        return this.itemService;
    }

    public final IFileCanBePreviewedChecker getFileCanBePreviewedChecker() {
        return this.fileCanBePreviewedChecker;
    }

    public final PreviewAnalytics getPreviewAnalytics() {
        return this.previewAnalytics;
    }
}
