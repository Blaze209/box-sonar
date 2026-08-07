package io.split.android.client.service.splits;

import io.split.android.client.dtos.Split;
import java.util.List;

/* JADX INFO: compiled from: FeatureFlagProcessStrategy.java */
/* JADX INFO: loaded from: classes4.dex */
class NamesProcessStrategy implements FeatureFlagProcessStrategy {
    private final List<String> mConfiguredValues;
    private final StatusProcessStrategy mStatusProcessStrategy;

    NamesProcessStrategy(List<String> configuredValues, StatusProcessStrategy statusProcessStrategy) {
        this.mConfiguredValues = configuredValues;
        this.mStatusProcessStrategy = statusProcessStrategy;
    }

    @Override // io.split.android.client.service.splits.FeatureFlagProcessStrategy
    public void process(List<Split> activeFeatureFlags, List<Split> archivedFeatureFlags, Split featureFlag) {
        if (this.mConfiguredValues.contains(featureFlag.name)) {
            this.mStatusProcessStrategy.process(activeFeatureFlags, archivedFeatureFlags, featureFlag);
        }
    }
}
