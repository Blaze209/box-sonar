package io.split.android.client.storage.db.rbs;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface RuleBasedSegmentDao {
    void delete(List<String> names);

    void deleteAll();

    List<RuleBasedSegmentEntity> getAll();

    void insert(RuleBasedSegmentEntity entity);

    void insert(List<RuleBasedSegmentEntity> entities);

    void update(String formerName, String name, String body);
}
