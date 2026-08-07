package zipkin2.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import zipkin2.Call;
import zipkin2.Span;
import zipkin2.storage.SpanStore;
import zipkin2.storage.Traces;

/* JADX INFO: loaded from: classes6.dex */
public final class TracesAdapter implements Traces {
    final SpanStore delegate;

    public TracesAdapter(SpanStore spanStore) {
        this.delegate = spanStore;
    }

    @Override // zipkin2.storage.Traces
    public Call<List<Span>> getTrace(String str) {
        return this.delegate.getTrace(str);
    }

    @Override // zipkin2.storage.Traces
    public Call<List<List<Span>>> getTraces(Iterable<String> iterable) {
        if (iterable == null) {
            throw new NullPointerException("traceIds == null");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(getTrace(Span.normalizeTraceId(it.next())));
        }
        if (arrayList.isEmpty()) {
            return Call.emptyList();
        }
        return arrayList.size() == 1 ? ((Call) arrayList.get(0)).map(ToListOfTraces.INSTANCE) : new ScatterGather(arrayList);
    }

    enum ToListOfTraces implements Call.Mapper<List<Span>, List<List<Span>>> {
        INSTANCE;

        @Override // zipkin2.Call.Mapper
        public List<List<Span>> map(List<Span> list) {
            return list.isEmpty() ? Collections.emptyList() : Collections.singletonList(list);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "ToListOfTraces()";
        }
    }

    static final class ScatterGather extends AggregateCall<List<Span>, List<List<Span>>> {
        ScatterGather(List<Call<List<Span>>> list) {
            super(list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // zipkin2.internal.AggregateCall
        public List<List<Span>> newOutput() {
            return new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // zipkin2.internal.AggregateCall
        public void append(List<Span> list, List<List<Span>> list2) {
            if (list.isEmpty()) {
                return;
            }
            list2.add(list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // zipkin2.internal.AggregateCall
        public boolean isEmpty(List<List<Span>> list) {
            return list.isEmpty();
        }

        @Override // zipkin2.Call.Base, zipkin2.Call
        public ScatterGather clone() {
            return new ScatterGather(cloneCalls());
        }
    }

    public String toString() {
        return "TracesAdapter{" + this.delegate + "}";
    }
}
