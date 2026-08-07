package com.box.android.preview.document.copytext;

import com.box.android.base.cpl.IClipboardService;
import com.box.android.preview.previewtype.document.copytext.TextSelectionManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopySelectedTextReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/preview/document/copytext/CopySelectedTextEnvironment;", "", "clipboardService", "Lcom/box/android/base/cpl/IClipboardService;", "textSelectionManager", "Lcom/box/android/preview/previewtype/document/copytext/TextSelectionManager;", "<init>", "(Lcom/box/android/base/cpl/IClipboardService;Lcom/box/android/preview/previewtype/document/copytext/TextSelectionManager;)V", "getClipboardService", "()Lcom/box/android/base/cpl/IClipboardService;", "getTextSelectionManager", "()Lcom/box/android/preview/previewtype/document/copytext/TextSelectionManager;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CopySelectedTextEnvironment {
    public static final int $stable = 8;
    private final IClipboardService clipboardService;
    private final TextSelectionManager textSelectionManager;

    @Inject
    public CopySelectedTextEnvironment(IClipboardService clipboardService, TextSelectionManager textSelectionManager) {
        Intrinsics.checkNotNullParameter(clipboardService, "clipboardService");
        Intrinsics.checkNotNullParameter(textSelectionManager, "textSelectionManager");
        this.clipboardService = clipboardService;
        this.textSelectionManager = textSelectionManager;
    }

    public final IClipboardService getClipboardService() {
        return this.clipboardService;
    }

    public final TextSelectionManager getTextSelectionManager() {
        return this.textSelectionManager;
    }
}
