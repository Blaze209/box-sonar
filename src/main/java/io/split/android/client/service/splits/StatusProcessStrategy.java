package io.split.android.client.service.splits;

import io.split.android.client.dtos.Split;
import io.split.android.client.dtos.Status;
import java.util.List;

/* JADX INFO: compiled from: FeatureFlagProcessStrategy.java */
/* JADX INFO: loaded from: classes4.dex */
class StatusProcessStrategy implements FeatureFlagProcessStrategy {
    StatusProcessStrategy() {
    }

    @Override // io.split.android.client.service.splits.FeatureFlagProcessStrategy
    public void process(List<Split> activeFeatureFlags, List<Split> archivedFeatureFlags, Split featureFlag) {
        if (featureFlag.status == Status.ACTIVE) {
            activeFeatureFlags.add(featureFlag);
        } else {
            archivedFeatureFlags.add(featureFlag);
        }
    }
}
