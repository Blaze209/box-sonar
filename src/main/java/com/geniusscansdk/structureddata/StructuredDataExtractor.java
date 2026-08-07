package com.geniusscansdk.structureddata;

import com.geniusscansdk.ocr.OcrResult;
import com.geniusscansdk.ocr.SpatialText;
import com.geniusscansdk.structureddata.reader.Receipt;
import com.geniusscansdk.structureddata.reader.ReceiptReader;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StructuredDataExtractor.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\f\u0010\n\u001a\u00020\u000b*\u00020\tH\u0002¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/structureddata/StructuredDataExtractor;", "", "<init>", "()V", "receiptFromOCRResult", "Lcom/geniusscansdk/structureddata/StructuredDataReceipt;", "fallbackLocale", "Ljava/util/Locale;", "ocrResult", "Lcom/geniusscansdk/ocr/OcrResult;", "toSpatialText", "Lcom/geniusscansdk/ocr/SpatialText;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StructuredDataExtractor {
    public final StructuredDataReceipt receiptFromOCRResult(Locale fallbackLocale, OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(fallbackLocale, "fallbackLocale");
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        Receipt receipt = ReceiptReader.read$default(new ReceiptReader(fallbackLocale, null, 0, 0.0d, 12, null), toSpatialText(ocrResult).getSpatialString(), false, 2, null);
        if (receipt != null) {
            return new StructuredDataReceipt(receipt);
        }
        return null;
    }

    private final SpatialText toSpatialText(OcrResult ocrResult) throws Exception {
        SpatialText spatialText = ocrResult.getSpatialText();
        if (spatialText != null) {
            return spatialText;
        }
        throw new Exception("The requested languages don't support structured data extraction.Please refer to the OCR languages documentation for more information.");
    }
}
