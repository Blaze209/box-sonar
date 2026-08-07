package com.apollographql.apollo3.internal;

import com.apollographql.apollo3.api.DeferredFragmentIdentifier;
import com.apollographql.apollo3.api.json.BufferedSourceJsonReader;
import com.apollographql.apollo3.api.json.JsonReaders;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import okio.BufferedSource;

/* JADX INFO: compiled from: DeferredJsonMerger.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0019\u001a\u00020\u001a2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u00062\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011j\u0002`\u0012H\u0002J\"\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011j\u0002`\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J2\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011j\u0002`\u00122\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011j\u0002`\u0012J \u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011j\u0002`\u00122\u0006\u0010!\u001a\u00020\u001fJ\"\u0010\"\u001a\u00020\u001a2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011j\u0002`\u0012H\u0002J2\u0010$\u001a\u0004\u0018\u00010\u00012\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011j\u0002`\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010&H\u0002J\u0006\u0010'\u001a\u00020\u001aR \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR#\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011j\u0002`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/apollographql/apollo3/internal/DeferredJsonMerger;", "", "()V", "_merged", "", "", "Lcom/apollographql/apollo3/internal/MutableJsonMap;", "_mergedFragmentIds", "", "Lcom/apollographql/apollo3/api/DeferredFragmentIdentifier;", "<set-?>", "", "hasNext", "getHasNext", "()Z", "isEmptyPayload", "merged", "", "Lcom/apollographql/apollo3/internal/JsonMap;", "getMerged", "()Ljava/util/Map;", "mergedFragmentIds", "", "getMergedFragmentIds", "()Ljava/util/Set;", "deepMerge", "", FirebaseAnalytics.Param.DESTINATION, "map", "jsonToMap", "json", "Lokio/BufferedSource;", "merge", "payload", "mergeData", "incrementalItem", "nodeAtPath", "path", "", "reset", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeferredJsonMerger {
    private final Map<String, Object> _merged;
    private final Set<DeferredFragmentIdentifier> _mergedFragmentIds;
    private boolean hasNext;
    private boolean isEmptyPayload;
    private final Map<String, Object> merged;
    private final Set<DeferredFragmentIdentifier> mergedFragmentIds;

    public DeferredJsonMerger() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this._merged = linkedHashMap;
        this.merged = linkedHashMap;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this._mergedFragmentIds = linkedHashSet;
        this.mergedFragmentIds = linkedHashSet;
        this.hasNext = true;
    }

    public final Map<String, Object> getMerged() {
        return this.merged;
    }

    public final Set<DeferredFragmentIdentifier> getMergedFragmentIds() {
        return this.mergedFragmentIds;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    /* JADX INFO: renamed from: isEmptyPayload, reason: from getter */
    public final boolean getIsEmptyPayload() {
        return this.isEmptyPayload;
    }

    public final Map<String, Object> merge(BufferedSource payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return merge((Map<String, ? extends Object>) jsonToMap(payload));
    }

    public final Map<String, Object> merge(Map<String, ? extends Object> payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (this.merged.isEmpty()) {
            this._merged.putAll(payload);
            return this.merged;
        }
        Object obj = payload.get("incremental");
        List<Map<String, ? extends Object>> list = obj instanceof List ? (List) obj : null;
        if (list == null) {
            this.isEmptyPayload = true;
        } else {
            this.isEmptyPayload = false;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Map<String, ? extends Object> map : list) {
                mergeData(map);
                Object obj2 = map.get(BoxAnalyticsParams.CATEGORY_ERRORS);
                List list2 = obj2 instanceof List ? (List) obj2 : null;
                if (list2 != null) {
                    CollectionsKt.addAll(arrayList, list2);
                }
                Object obj3 = map.get("extensions");
                Map map2 = obj3 instanceof Map ? (Map) obj3 : null;
                if (map2 != null) {
                    arrayList2.add(map2);
                }
            }
            if (!arrayList.isEmpty()) {
                this._merged.put(BoxAnalyticsParams.CATEGORY_ERRORS, arrayList);
            } else {
                this._merged.remove(BoxAnalyticsParams.CATEGORY_ERRORS);
            }
            if (!arrayList2.isEmpty()) {
                this._merged.put("extensions", MapsKt.mapOf(TuplesKt.to("incremental", arrayList2)));
            } else {
                this._merged.remove("extensions");
            }
        }
        Boolean bool = (Boolean) payload.get("hasNext");
        this.hasNext = bool != null ? bool.booleanValue() : false;
        return this.merged;
    }

    private final void mergeData(Map<String, ? extends Object> incrementalItem) {
        Map<String, ? extends Object> map = (Map) incrementalItem.get("data");
        Object obj = incrementalItem.get("path");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List<? extends Object> list = (List) obj;
        Object obj2 = this.merged.get("data");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>{ com.apollographql.apollo3.internal.DeferredJsonMergerKt.JsonMap }");
        Map<String, ? extends Object> map2 = (Map) obj2;
        if (map != null) {
            Object objNodeAtPath = nodeAtPath(map2, list);
            Intrinsics.checkNotNull(objNodeAtPath, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>{ com.apollographql.apollo3.internal.DeferredJsonMergerKt.MutableJsonMap }");
            deepMerge(TypeIntrinsics.asMutableMap(objNodeAtPath), map);
            this._mergedFragmentIds.add(new DeferredFragmentIdentifier(list, (String) incrementalItem.get("label")));
        }
    }

    private final void deepMerge(Map<String, Object> destination, Map<String, ? extends Object> map) {
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (destination.containsKey(key) && TypeIntrinsics.isMutableMap(destination.get(key))) {
                Object obj = destination.get(key);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>{ com.apollographql.apollo3.internal.DeferredJsonMergerKt.MutableJsonMap }");
                Map<String, Object> mapAsMutableMap = TypeIntrinsics.asMutableMap(obj);
                Map<String, ? extends Object> map2 = value instanceof Map ? (Map) value : null;
                if (map2 == null) {
                    throw new IllegalStateException(("'" + key + "' is an object in destination but not in map").toString());
                }
                deepMerge(mapAsMutableMap, map2);
            } else {
                destination.put(key, value);
            }
        }
    }

    private final Map<String, Object> jsonToMap(BufferedSource json) throws IOException {
        Object any = JsonReaders.readAny(new BufferedSourceJsonReader(json));
        Intrinsics.checkNotNull(any, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>{ com.apollographql.apollo3.internal.DeferredJsonMergerKt.JsonMap }");
        return (Map) any;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Map<java.lang.String, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    private final Object nodeAtPath(Map<String, ? extends Object> map, List<? extends Object> path) {
        for (Object obj : path) {
            if (map instanceof List) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                map = ((List) map).get(((Integer) obj).intValue());
            } else {
                Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>{ com.apollographql.apollo3.internal.DeferredJsonMergerKt.JsonMap }");
                map = ((Map) map).get(obj);
            }
        }
        return map;
    }

    public final void reset() {
        this._merged.clear();
        this._mergedFragmentIds.clear();
        this.hasNext = true;
        this.isEmptyPayload = false;
    }
}
