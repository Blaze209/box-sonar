package io.split.android.client.service.splits;

import io.split.android.client.dtos.Split;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
interface FeatureFlagProcessStrategy {
    void process(List<Split> activeFeatureFlags, List<Split> archivedFeatureFlags, Split featureFlag);
}
