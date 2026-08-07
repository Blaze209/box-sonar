package com.box.android.data.persistence.logging;

import com.box.android.common.utilities.EnumUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Lcom/box/android/data/persistence/logging/CategoryConverter;", "", "<init>", "()V", "fromString", "Lcom/box/android/data/persistence/logging/MetricsCategory;", "string", "", "toString", "category", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CategoryConverter {
    public final MetricsCategory fromString(String string) {
        MetricsCategory metricsCategory;
        Intrinsics.checkNotNullParameter(string, "string");
        EnumUtils enumUtils = EnumUtils.INSTANCE;
        MetricsCategory[] metricsCategoryArrValues = MetricsCategory.values();
        int length = metricsCategoryArrValues.length;
        for (int i = 0; i < length; i++) {
            metricsCategory = metricsCategoryArrValues[i];
            if (Intrinsics.areEqual(metricsCategory.toString(), string)) {
                return metricsCategory;
            }
        }
        metricsCategory = null;
        return metricsCategory;
    }

    public final String toString(MetricsCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        return category.toString();
    }
}
