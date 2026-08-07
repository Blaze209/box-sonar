package com.box.android.base.cpl;

import kotlin.Metadata;

/* JADX INFO: compiled from: IClipboardService.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/cpl/IClipboardService;", "", "copyTextToClipboard", "", "textToCopy", "", "label", "getTextFromClipboard", "getHtmlTextFromClipboard", "hasPasteData", "", "shouldShowCopyNotification", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IClipboardService {
    void copyTextToClipboard(String textToCopy, String label);

    String getHtmlTextFromClipboard();

    String getTextFromClipboard();

    boolean hasPasteData();

    boolean shouldShowCopyNotification();

    /* JADX INFO: compiled from: IClipboardService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void copyTextToClipboard$default(IClipboardService iClipboardService, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyTextToClipboard");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        iClipboardService.copyTextToClipboard(str, str2);
    }
}
