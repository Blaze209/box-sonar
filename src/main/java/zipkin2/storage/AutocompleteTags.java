package zipkin2.storage;

import java.util.List;
import zipkin2.Call;

/* JADX INFO: loaded from: classes6.dex */
public interface AutocompleteTags {
    Call<List<String>> getKeys();

    Call<List<String>> getValues(String str);
}
