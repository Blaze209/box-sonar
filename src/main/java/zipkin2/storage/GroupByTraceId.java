package zipkin2.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import zipkin2.Call;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
public final class GroupByTraceId implements Call.Mapper<List<Span>, List<List<Span>>> {
    final boolean strictTraceId;

    public static Call.Mapper<List<Span>, List<List<Span>>> create(boolean z) {
        return new GroupByTraceId(z);
    }

    GroupByTraceId(boolean z) {
        this.strictTraceId = z;
    }

    @Override // zipkin2.Call.Mapper
    public List<List<Span>> map(List<Span> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Span span : list) {
            String strTraceId = span.traceId();
            if (!this.strictTraceId) {
                strTraceId = StrictTraceId.lowerTraceId(strTraceId);
            }
            if (!linkedHashMap.containsKey(strTraceId)) {
                linkedHashMap.put(strTraceId, new ArrayList());
            }
            ((List) linkedHashMap.get(strTraceId)).add(span);
        }
        return new ArrayList(linkedHashMap.values());
    }

    public String toString() {
        return "GroupByTraceId{strictTraceId=" + this.strictTraceId + "}";
    }
}
