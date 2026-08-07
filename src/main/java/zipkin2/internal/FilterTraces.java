package zipkin2.internal;

import java.util.ArrayList;
import java.util.List;
import zipkin2.Call;
import zipkin2.Span;
import zipkin2.storage.QueryRequest;

/* JADX INFO: loaded from: classes6.dex */
public final class FilterTraces implements Call.Mapper<List<List<Span>>, List<List<Span>>> {
    final QueryRequest request;

    public static Call.Mapper<List<List<Span>>, List<List<Span>>> create(QueryRequest queryRequest) {
        return new FilterTraces(queryRequest);
    }

    FilterTraces(QueryRequest queryRequest) {
        this.request = queryRequest;
    }

    @Override // zipkin2.Call.Mapper
    public List<List<Span>> map(List<List<Span>> list) {
        int size = list.size();
        if (size == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            List<Span> list2 = list.get(i);
            if (this.request.test(list2)) {
                arrayList.add(list2);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "FilterTraces{request=" + this.request + "}";
    }
}
