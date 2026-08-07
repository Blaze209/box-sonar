package io.split.android.client.storage.splits;

import io.split.android.client.dtos.Split;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface PersistentSplitsStorage {
    void clear();

    void close();

    void delete(List<String> splitNames);

    List<Split> getAll();

    String getFilterQueryString();

    String getFlagsSpec();

    SplitsSnapshot getSnapshot();

    void update(Split splitName);

    boolean update(ProcessedSplitChange splitChange, Map<String, Integer> mTrafficTypes, Map<String, Set<String>> mFlagSets);

    void updateFilterQueryString(String queryString);

    void updateFlagsSpec(String flagsSpec);
}
