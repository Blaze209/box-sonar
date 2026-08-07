package com.box.android.capture.documentscanning.logic;

import com.box.android.domain.models.DomainError;
import kotlin.Metadata;

/* JADX INFO: compiled from: DocumentScanningHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/IDocumentScanningHelper;", "", "getMessageForError", "", "error", "Lcom/box/android/domain/models/DomainError;", "getLocalizedMessage", "resourceId", "", "logEvent", "", "eventName", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IDocumentScanningHelper {
    String getLocalizedMessage(int resourceId);

    String getMessageForError(DomainError error);

    void logEvent(String eventName);
}
