package com.geniusscansdk.scanflow;

import com.geniusscansdk.ocr.OcrProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Page.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toOcrInput", "Lcom/geniusscansdk/ocr/OcrProcessor$Input;", "Lcom/geniusscansdk/scanflow/Page;", "gssdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PageKt {
    public static final OcrProcessor.Input toOcrInput(Page page) {
        Intrinsics.checkNotNullParameter(page, "<this>");
        return new OcrProcessor.Input(page.getOriginalImage(), page.getQuadrangle(), null, 4, null);
    }
}
