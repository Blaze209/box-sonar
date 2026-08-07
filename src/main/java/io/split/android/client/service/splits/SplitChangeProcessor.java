package io.split.android.client.service.splits;

import io.split.android.client.FlagSetsFilter;
import io.split.android.client.SplitFilter;
import io.split.android.client.dtos.Split;
import io.split.android.client.dtos.SplitChange;
import io.split.android.client.storage.splits.ProcessedSplitChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SplitChangeProcessor {
    private final FlagSetsFilter mFlagSetsFilter;
    private final SplitFilter mSplitFilter;
    private final StatusProcessStrategy mStatusProcessStrategy;

    private SplitChangeProcessor() {
        this.mSplitFilter = null;
        this.mStatusProcessStrategy = new StatusProcessStrategy();
        this.mFlagSetsFilter = null;
    }

    public SplitChangeProcessor(Map<SplitFilter.Type, SplitFilter> filters, FlagSetsFilter flagSetsFilter) {
        if (filters == null || filters.isEmpty()) {
            this.mSplitFilter = null;
        } else {
            this.mSplitFilter = filters.values().iterator().next();
        }
        this.mStatusProcessStrategy = new StatusProcessStrategy();
        this.mFlagSetsFilter = flagSetsFilter;
    }

    public SplitChangeProcessor(SplitFilter splitFilter, FlagSetsFilter flagSetsFilter) {
        this.mSplitFilter = splitFilter;
        this.mFlagSetsFilter = flagSetsFilter;
        this.mStatusProcessStrategy = new StatusProcessStrategy();
    }

    public ProcessedSplitChange process(SplitChange splitChange) {
        if (splitChange == null || splitChange.splits == null) {
            return new ProcessedSplitChange(new ArrayList(), new ArrayList(), -1L, 0L);
        }
        return buildProcessedSplitChange(splitChange.splits, splitChange.till);
    }

    public ProcessedSplitChange process(Split featureFlag, long changeNumber) {
        return buildProcessedSplitChange(Collections.singletonList(featureFlag), changeNumber);
    }

    private ProcessedSplitChange buildProcessedSplitChange(List<Split> featureFlags, long changeNumber) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        FeatureFlagProcessStrategy processStrategy = getProcessStrategy(this.mSplitFilter);
        for (Split split : featureFlags) {
            if (split != null && split.name != null) {
                processStrategy.process(arrayList, arrayList2, split);
            }
        }
        return new ProcessedSplitChange(arrayList, arrayList2, changeNumber, System.currentTimeMillis());
    }

    private FeatureFlagProcessStrategy getProcessStrategy(SplitFilter splitFilter) {
        if (splitFilter == null || splitFilter.getValues().isEmpty()) {
            return this.mStatusProcessStrategy;
        }
        if (splitFilter.getType() == SplitFilter.Type.BY_SET && this.mFlagSetsFilter != null) {
            return new SetsProcessStrategy(this.mFlagSetsFilter, this.mStatusProcessStrategy);
        }
        if (splitFilter.getType() == SplitFilter.Type.BY_NAME) {
            return new NamesProcessStrategy(splitFilter.getValues(), this.mStatusProcessStrategy);
        }
        return this.mStatusProcessStrategy;
    }
}
