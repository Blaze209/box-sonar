package io.split.android.client.service.executor;

import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.dtos.Split;
import io.split.android.client.service.CleanUpDatabaseTask;
import io.split.android.client.service.events.EventsRecorderTask;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.rules.LoadRuleBasedSegmentsTask;
import io.split.android.client.service.rules.RuleBasedSegmentInPlaceUpdateTask;
import io.split.android.client.service.splits.FilterSplitsInCacheTask;
import io.split.android.client.service.splits.LoadSplitsTask;
import io.split.android.client.service.splits.SplitInPlaceUpdateTask;
import io.split.android.client.service.splits.SplitKillTask;
import io.split.android.client.service.splits.SplitsSyncTask;
import io.split.android.client.service.splits.SplitsUpdateTask;
import io.split.android.client.service.telemetry.TelemetryTaskFactory;
import io.split.android.client.storage.cipher.EncryptionMigrationTask;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.SplitRoomDatabase;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitTaskFactory extends TelemetryTaskFactory, ImpressionsTaskFactory {
    CleanUpDatabaseTask createCleanUpDatabaseTask(long maxTimestamp);

    EncryptionMigrationTask createEncryptionMigrationTask(String sdkKey, SplitRoomDatabase splitRoomDatabase, boolean encryptionEnabled, SplitCipher splitCipher);

    EventsRecorderTask createEventsRecorderTask();

    FilterSplitsInCacheTask createFilterSplitsInCacheTask();

    LoadRuleBasedSegmentsTask createLoadRuleBasedSegmentsTask();

    LoadSplitsTask createLoadSplitsTask();

    RuleBasedSegmentInPlaceUpdateTask createRuleBasedSegmentUpdateTask(RuleBasedSegment ruleBasedSegment, long changeNumber);

    SplitKillTask createSplitKillTask(Split split);

    SplitsSyncTask createSplitsSyncTask(boolean checkCacheExpiration);

    SplitInPlaceUpdateTask createSplitsUpdateTask(Split featureFlag, long since);

    SplitsUpdateTask createSplitsUpdateTask(Long since, Long rbsSince);
}
