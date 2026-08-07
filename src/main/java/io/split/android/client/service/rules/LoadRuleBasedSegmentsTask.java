package io.split.android.client.service.rules;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class LoadRuleBasedSegmentsTask implements SplitTask {
    private final RuleBasedSegmentStorage mRuleBasedSegmentStorage;

    public LoadRuleBasedSegmentsTask(RuleBasedSegmentStorage ruleBasedSegmentStorage) {
        this.mRuleBasedSegmentStorage = (RuleBasedSegmentStorage) Utils.checkNotNull(ruleBasedSegmentStorage);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            this.mRuleBasedSegmentStorage.loadLocal();
            return SplitTaskExecutionInfo.success(SplitTaskType.LOAD_LOCAL_RULE_BASED_SEGMENTS);
        } catch (Exception e) {
            Logger.e("Error loading rule based segments: " + e.getLocalizedMessage());
            return SplitTaskExecutionInfo.error(SplitTaskType.LOAD_LOCAL_RULE_BASED_SEGMENTS);
        }
    }
}
