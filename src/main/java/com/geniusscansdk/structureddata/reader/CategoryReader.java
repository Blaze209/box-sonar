package com.geniusscansdk.structureddata.reader;

import com.geniusscansdk.ocr.SpatialText;
import com.geniusscansdk.structureddata.ReceiptCategory;
import com.geniusscansdk.structureddata.data.CategoryData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CategoryReader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/structureddata/reader/CategoryReader;", "", "categoryData", "Lcom/geniusscansdk/structureddata/data/CategoryData;", "<init>", "(Lcom/geniusscansdk/structureddata/data/CategoryData;)V", "category", "Lcom/geniusscansdk/structureddata/ReceiptCategory;", "spatialText", "Lcom/geniusscansdk/ocr/SpatialText;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CategoryReader {
    private final CategoryData categoryData;

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryReader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CategoryReader(CategoryData categoryData) {
        Intrinsics.checkNotNullParameter(categoryData, "categoryData");
        this.categoryData = categoryData;
    }

    public /* synthetic */ CategoryReader(CategoryData categoryData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CategoryData() : categoryData);
    }

    public final ReceiptCategory category(SpatialText spatialText) {
        Intrinsics.checkNotNullParameter(spatialText, "spatialText");
        for (Map.Entry<ReceiptCategory, List<String>> entry : this.categoryData.getCategoryResources().entrySet()) {
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                if (spatialText.toLowercaseWords().contains(it.next())) {
                    return entry.getKey();
                }
            }
        }
        return ReceiptCategory.OTHER;
    }
}
