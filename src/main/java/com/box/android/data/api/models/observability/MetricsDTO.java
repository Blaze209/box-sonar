package com.box.android.data.api.models.observability;

import com.box.android.data.persistence.logging.MetricsCategory;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/data/api/models/observability/MetricsDTO;", "", "category", "Lcom/box/android/data/persistence/logging/MetricsCategory;", "eventType", "", "<init>", "(Lcom/box/android/data/persistence/logging/MetricsCategory;Ljava/lang/String;)V", "getCategory", "()Lcom/box/android/data/persistence/logging/MetricsCategory;", "getEventType", "()Ljava/lang/String;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class MetricsDTO {
    private final MetricsCategory category;
    private final String eventType;

    public MetricsDTO(@Json(name = "category") MetricsCategory category, @Json(name = "event_type") String eventType) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.category = category;
        this.eventType = eventType;
    }

    public final MetricsCategory getCategory() {
        return this.category;
    }

    public String getEventType() {
        return this.eventType;
    }
}
