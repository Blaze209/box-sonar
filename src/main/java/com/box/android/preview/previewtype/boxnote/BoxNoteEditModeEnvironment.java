package com.box.android.preview.previewtype.boxnote;

import com.box.android.base.cpl.IClipboardService;
import com.box.android.domain.identity.IUserContextManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeEnvironment;", "", "requestBuilder", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteRequestBuilder;", "clipboardService", "Lcom/box/android/base/cpl/IClipboardService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNoteRequestBuilder;Lcom/box/android/base/cpl/IClipboardService;Lcom/box/android/domain/identity/IUserContextManager;)V", "getRequestBuilder", "()Lcom/box/android/preview/previewtype/boxnote/BoxNoteRequestBuilder;", "getClipboardService", "()Lcom/box/android/base/cpl/IClipboardService;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxNoteEditModeEnvironment {
    public static final int $stable = 8;
    private final IClipboardService clipboardService;
    private final BoxNoteRequestBuilder requestBuilder;
    private final IUserContextManager userContextManager;

    @Inject
    public BoxNoteEditModeEnvironment(BoxNoteRequestBuilder requestBuilder, IClipboardService clipboardService, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        Intrinsics.checkNotNullParameter(clipboardService, "clipboardService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.requestBuilder = requestBuilder;
        this.clipboardService = clipboardService;
        this.userContextManager = userContextManager;
    }

    public final BoxNoteRequestBuilder getRequestBuilder() {
        return this.requestBuilder;
    }

    public final IClipboardService getClipboardService() {
        return this.clipboardService;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }
}
