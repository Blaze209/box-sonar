package com.geniusscansdk.structureddata.reader;

import com.box.androidsdk.content.models.BoxOrder;
import com.geniusscansdk.ocr.SpatialText;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: compiled from: DateReader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/geniusscansdk/structureddata/reader/AdditionalDateReader;", "", BoxOrder.SORT_DATE, "", "Ljava/util/Date;", "fullText", "Lcom/geniusscansdk/ocr/SpatialText;", "locale", "Ljava/util/Locale;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AdditionalDateReader {
    List<Date> date(SpatialText fullText, Locale locale);
}
