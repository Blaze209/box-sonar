package zipkin2.storage;

import java.util.List;
import zipkin2.Call;

/* JADX INFO: loaded from: classes6.dex */
public interface ServiceAndSpanNames {
    Call<List<String>> getRemoteServiceNames(String str);

    Call<List<String>> getServiceNames();

    Call<List<String>> getSpanNames(String str);
}
