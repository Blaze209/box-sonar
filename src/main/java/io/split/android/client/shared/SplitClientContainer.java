package io.split.android.client.shared;

import io.split.android.client.SplitClient;
import io.split.android.client.api.Key;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitClientContainer {
    void destroy();

    Set<SplitClient> getAll();

    SplitClient getClient(Key key);

    void remove(Key key);
}
