package zipkin2.storage;

import java.util.List;
import zipkin2.Call;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
public interface SpanConsumer {
    Call<Void> accept(List<Span> list);
}
