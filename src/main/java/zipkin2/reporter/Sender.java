package zipkin2.reporter;

import java.util.Collections;
import java.util.List;
import zipkin2.Call;
import zipkin2.Component;
import zipkin2.codec.Encoding;
import zipkin2.reporter.internal.InternalReporter;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Sender extends Component {
    public abstract Encoding encoding();

    public abstract int messageMaxBytes();

    public abstract int messageSizeInBytes(List<byte[]> list);

    public abstract Call<Void> sendSpans(List<byte[]> list);

    public int messageSizeInBytes(int i) {
        return messageSizeInBytes(Collections.singletonList(new byte[i]));
    }

    static {
        InternalReporter.instance = new InternalReporter() { // from class: zipkin2.reporter.Sender.1
            @Override // zipkin2.reporter.internal.InternalReporter
            public AsyncReporter.Builder toBuilder(AsyncReporter<?> asyncReporter) {
                return ((AsyncReporter.BoundedAsyncReporter) asyncReporter).toBuilder();
            }
        };
    }
}
