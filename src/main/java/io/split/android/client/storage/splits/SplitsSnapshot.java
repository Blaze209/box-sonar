package io.split.android.client.storage.splits;

import io.split.android.client.dtos.Split;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SplitsSnapshot {
    private final long mChangeNumber;
    private final Map<String, Set<String>> mFlagSetsMap;
    private final String mFlagsSpec;
    private final List<Split> mSplits;
    private final String mSplitsFilterQueryString;
    private final Map<String, Integer> mTrafficTypesMap;
    private final long mUpdateTimestamp;

    public SplitsSnapshot(List<Split> splits, long changeNumber, long updateTimestamp, String splitsFilterQueryString, String flagsSpec, Map<String, Integer> trafficTypesMap, Map<String, Set<String>> flagSetsMap) {
        this.mChangeNumber = changeNumber;
        this.mSplits = splits;
        this.mUpdateTimestamp = updateTimestamp;
        this.mSplitsFilterQueryString = splitsFilterQueryString;
        this.mFlagsSpec = flagsSpec;
        this.mTrafficTypesMap = trafficTypesMap == null ? new HashMap<>() : trafficTypesMap;
        this.mFlagSetsMap = flagSetsMap == null ? new HashMap<>() : flagSetsMap;
    }

    public long getChangeNumber() {
        return this.mChangeNumber;
    }

    public long getUpdateTimestamp() {
        return this.mUpdateTimestamp;
    }

    public String getSplitsFilterQueryString() {
        return this.mSplitsFilterQueryString;
    }

    public List<Split> getSplits() {
        List<Split> list = this.mSplits;
        return list != null ? list : new ArrayList();
    }

    public String getFlagsSpec() {
        return this.mFlagsSpec;
    }

    public Map<String, Integer> getTrafficTypesMap() {
        return this.mTrafficTypesMap;
    }

    public Map<String, Set<String>> getFlagSetsMap() {
        return this.mFlagSetsMap;
    }
}
