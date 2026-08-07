package zipkin2.storage;

import java.util.List;
import zipkin2.Call;
import zipkin2.DependencyLink;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
public interface SpanStore {
    Call<List<DependencyLink>> getDependencies(long j, long j2);

    @Deprecated
    Call<List<String>> getServiceNames();

    @Deprecated
    Call<List<String>> getSpanNames(String str);

    @Deprecated
    Call<List<Span>> getTrace(String str);

    Call<List<List<Span>>> getTraces(QueryRequest queryRequest);
}
