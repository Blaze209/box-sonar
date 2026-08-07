package com.box.cirrus.providers;

import com.margelo.nitro.core.AnyMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: BoxAnalyticsProvider.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u0004\u0018\u00010\u0004H\u0000¨\u0006\u0005"}, d2 = {"toPropertiesMap", "", "", "", "Lcom/margelo/nitro/core/AnyMap;", "cirrus_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAnalyticsProviderKt {
    public static final Map<String, Object> toPropertiesMap(AnyMap anyMap) {
        HashMap<String, Object> hashMap;
        return (anyMap == null || (hashMap = anyMap.toHashMap()) == null) ? MapsKt.emptyMap() : hashMap;
    }
}
