package io.split.android.client.storage.splits;

import io.split.android.client.dtos.Split;
import io.split.android.client.storage.RolloutDefinitionsCache;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitsStorage extends RolloutDefinitionsCache {
    Split get(String name);

    Map<String, Split> getAll();

    String getFlagsSpec();

    Map<String, Split> getMany(List<String> splits);

    Set<String> getNamesByFlagSets(Collection<String> flagSets);

    String getSplitsFilterQueryString();

    long getTill();

    long getUpdateTimestamp();

    boolean isValidTrafficType(String name);

    boolean update(ProcessedSplitChange splitChange);

    void updateFlagsSpec(String flagsSpec);

    void updateSplitsFilterQueryString(String queryString);

    void updateWithoutChecks(Split split);
}
