package io.split.android.client.storage.db;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitDao {
    void delete(List<String> names);

    void deleteAll();

    List<SplitEntity> getAll();

    void insert(SplitEntity split);

    void insert(List<SplitEntity> splits);

    void update(String formerName, String name, String body);
}
