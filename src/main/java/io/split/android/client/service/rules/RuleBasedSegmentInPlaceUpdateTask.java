package io.split.android.client.service.rules;

import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class RuleBasedSegmentInPlaceUpdateTask implements SplitTask {
    private final long mChangeNumber;
    private final RuleBasedSegmentChangeProcessor mChangeProcessor;
    private final ISplitEventsManager mEventsManager;
    private final RuleBasedSegment mRuleBasedSegment;
    private final RuleBasedSegmentStorage mRuleBasedSegmentStorage;

    public RuleBasedSegmentInPlaceUpdateTask(RuleBasedSegmentStorage ruleBasedSegmentStorage, RuleBasedSegmentChangeProcessor changeProcessor, ISplitEventsManager eventsManager, RuleBasedSegment ruleBasedSegment, long changeNumber) {
        this.mRuleBasedSegmentStorage = (RuleBasedSegmentStorage) Utils.checkNotNull(ruleBasedSegmentStorage);
        this.mRuleBasedSegment = (RuleBasedSegment) Utils.checkNotNull(ruleBasedSegment);
        this.mChangeProcessor = (RuleBasedSegmentChangeProcessor) Utils.checkNotNull(changeProcessor);
        this.mEventsManager = eventsManager;
        this.mChangeNumber = changeNumber;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            ProcessedRuleBasedSegmentChange processedRuleBasedSegmentChangeProcess = this.mChangeProcessor.process(this.mRuleBasedSegment, this.mChangeNumber);
            if (this.mRuleBasedSegmentStorage.update(processedRuleBasedSegmentChangeProcess.getActive(), processedRuleBasedSegmentChangeProcess.getArchived(), this.mChangeNumber)) {
                this.mEventsManager.notifyInternalEvent(SplitInternalEvent.RULE_BASED_SEGMENTS_UPDATED);
            }
            Logger.v("Updated rule based segment");
            return SplitTaskExecutionInfo.success(SplitTaskType.RULE_BASED_SEGMENT_SYNC);
        } catch (Exception unused) {
            Logger.e("Could not update rule based segment");
            return SplitTaskExecutionInfo.error(SplitTaskType.RULE_BASED_SEGMENT_SYNC);
        }
    }
}
