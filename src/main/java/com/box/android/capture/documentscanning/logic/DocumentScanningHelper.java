package com.box.android.capture.documentscanning.logic;

import com.box.android.capture.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DocumentScanningError;
import com.box.android.domain.models.DomainError;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScanningHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/DocumentScanningHelper;", "Lcom/box/android/capture/documentscanning/logic/IDocumentScanningHelper;", "<init>", "()V", "getMessageForError", "", "error", "Lcom/box/android/domain/models/DomainError;", "getLocalizedMessage", "resourceId", "", "logEvent", "", "eventName", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentScanningHelper implements IDocumentScanningHelper {
    public static final int $stable = 0;

    @Inject
    public DocumentScanningHelper() {
    }

    @Override // com.box.android.capture.documentscanning.logic.IDocumentScanningHelper
    public String getMessageForError(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (error instanceof DocumentScanningError.DocumentGenerationError) {
            return CommonBoxUtil.LS(R.string.document_scan_error_save);
        }
        if (error instanceof DocumentScanningError.OcrNotAvailable) {
            return CommonBoxUtil.LS(R.string.document_scan_error_ocr_body);
        }
        return CommonBoxUtil.LS(R.string.document_scan_error_generic);
    }

    @Override // com.box.android.capture.documentscanning.logic.IDocumentScanningHelper
    public String getLocalizedMessage(int resourceId) {
        return CommonBoxUtil.LS(resourceId);
    }

    @Override // com.box.android.capture.documentscanning.logic.IDocumentScanningHelper
    public void logEvent(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(eventName);
    }
}
