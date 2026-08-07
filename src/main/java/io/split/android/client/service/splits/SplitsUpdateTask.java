package io.split.android.client.service.splits;

import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.synchronizer.SplitsChangeChecker;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorage;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class SplitsUpdateTask implements SplitTask {
    private SplitsChangeChecker mChangeChecker = new SplitsChangeChecker();
    private Long mChangeNumber;
    private final ISplitEventsManager mEventsManager;
    private Long mRbsChangeNumber;
    private final RuleBasedSegmentStorage mRuleBasedSegmentStorage;
    private final SplitsStorage mSplitsStorage;
    private final SplitsSyncHelper mSplitsSyncHelper;

    public SplitsUpdateTask(SplitsSyncHelper splitsSyncHelper, SplitsStorage splitsStorage, RuleBasedSegmentStorage ruleBasedSegmentStorage, Long since, Long rbsSince, ISplitEventsManager eventsManager) {
        this.mSplitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
        this.mRuleBasedSegmentStorage = (RuleBasedSegmentStorage) Utils.checkNotNull(ruleBasedSegmentStorage);
        this.mSplitsSyncHelper = (SplitsSyncHelper) Utils.checkNotNull(splitsSyncHelper);
        this.mChangeNumber = since;
        this.mRbsChangeNumber = rbsSince;
        this.mEventsManager = (ISplitEventsManager) Utils.checkNotNull(eventsManager);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        Long l = this.mChangeNumber;
        if (l == null || l.longValue() == 0) {
            this.mChangeNumber = Long.valueOf(this.mSplitsStorage.getTill());
        }
        Long l2 = this.mRbsChangeNumber;
        if (l2 == null || l2.longValue() == 0) {
            this.mRbsChangeNumber = Long.valueOf(this.mRuleBasedSegmentStorage.getChangeNumber());
        }
        long till = this.mSplitsStorage.getTill();
        long changeNumber = this.mRuleBasedSegmentStorage.getChangeNumber();
        if (this.mChangeNumber.longValue() <= till && this.mRbsChangeNumber.longValue() <= changeNumber) {
            Logger.d("Received change numbers are previous than stored ones. Avoiding update.");
            return SplitTaskExecutionInfo.success(SplitTaskType.SPLITS_SYNC);
        }
        SplitTaskExecutionInfo splitTaskExecutionInfoSync = this.mSplitsSyncHelper.sync(new SplitsSyncHelper.SinceChangeNumbers(this.mChangeNumber.longValue(), this.mRbsChangeNumber), 10);
        if (splitTaskExecutionInfoSync.getStatus() == SplitTaskExecutionStatus.SUCCESS) {
            SplitInternalEvent splitInternalEvent = SplitInternalEvent.SPLITS_FETCHED;
            if (this.mChangeChecker.changeNumberIsNewer(till, this.mSplitsStorage.getTill()) || this.mChangeChecker.changeNumberIsNewer(changeNumber, this.mRuleBasedSegmentStorage.getChangeNumber())) {
                splitInternalEvent = SplitInternalEvent.SPLITS_UPDATED;
            }
            this.mEventsManager.notifyInternalEvent(splitInternalEvent);
        }
        return splitTaskExecutionInfoSync;
    }

    public void setChangeChecker(SplitsChangeChecker changeChecker) {
        this.mChangeChecker = changeChecker;
    }
}
