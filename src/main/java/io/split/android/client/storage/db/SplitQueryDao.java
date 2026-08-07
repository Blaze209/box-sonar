package io.split.android.client.storage.db;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitQueryDao {
    Map<String, SplitEntity> getAllAsMap();

    void invalidate();
}
