package io.split.android.client.service.splits;

import io.split.android.client.FlagSetsFilter;
import io.split.android.client.dtos.Split;
import java.util.List;

/* JADX INFO: compiled from: FeatureFlagProcessStrategy.java */
/* JADX INFO: loaded from: classes4.dex */
class SetsProcessStrategy implements FeatureFlagProcessStrategy {
    private final FlagSetsFilter mFlagSetsFilter;
    private final StatusProcessStrategy mStatusProcessStrategy;

    SetsProcessStrategy(FlagSetsFilter flagSetsFilter, StatusProcessStrategy statusProcessStrategy) {
        this.mStatusProcessStrategy = statusProcessStrategy;
        this.mFlagSetsFilter = flagSetsFilter;
    }

    @Override // io.split.android.client.service.splits.FeatureFlagProcessStrategy
    public void process(List<Split> activeFeatureFlags, List<Split> archivedFeatureFlags, Split featureFlag) {
        if (featureFlag.sets == null || featureFlag.sets.isEmpty()) {
            archivedFeatureFlags.add(featureFlag);
        } else if (!this.mFlagSetsFilter.intersect(featureFlag.sets)) {
            archivedFeatureFlags.add(featureFlag);
        } else {
            this.mStatusProcessStrategy.process(activeFeatureFlags, archivedFeatureFlags, featureFlag);
        }
    }
}
