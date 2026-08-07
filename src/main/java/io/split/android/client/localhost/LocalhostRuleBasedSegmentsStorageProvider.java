package io.split.android.client.localhost;

import io.split.android.client.storage.rbs.RuleBasedSegmentStorage;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorageProvider;

/* JADX INFO: loaded from: classes4.dex */
class LocalhostRuleBasedSegmentsStorageProvider implements RuleBasedSegmentStorageProvider {
    private final RuleBasedSegmentStorage mRuleBasedSegmentStorage;

    LocalhostRuleBasedSegmentsStorageProvider(RuleBasedSegmentStorage ruleBasedSegmentStorage) {
        this.mRuleBasedSegmentStorage = ruleBasedSegmentStorage;
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageProvider
    public RuleBasedSegmentStorage get() {
        return this.mRuleBasedSegmentStorage;
    }
}
