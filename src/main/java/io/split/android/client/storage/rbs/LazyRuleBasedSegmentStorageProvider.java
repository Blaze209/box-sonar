package io.split.android.client.storage.rbs;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public class LazyRuleBasedSegmentStorageProvider implements RuleBasedSegmentStorageProvider {
    private final AtomicReference<RuleBasedSegmentStorage> mRuleBasedSegmentStorageRef = new AtomicReference<>();

    public void set(RuleBasedSegmentStorage ruleBasedSegmentStorage) {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.mRuleBasedSegmentStorageRef, null, ruleBasedSegmentStorage)) {
            return;
        }
        Logger.w("RuleBasedSegmentStorage already set in LazyRuleBasedSegmentStorageProvider");
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageProvider
    public RuleBasedSegmentStorage get() {
        return this.mRuleBasedSegmentStorageRef.get();
    }
}
