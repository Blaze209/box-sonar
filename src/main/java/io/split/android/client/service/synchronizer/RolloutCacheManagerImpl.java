package io.split.android.client.service.synchronizer;

import io.split.android.client.RolloutCacheConfiguration;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.RolloutDefinitionsCache;
import io.split.android.client.storage.cipher.EncryptionMigrationTask;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.storage.general.GeneralInfoStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class RolloutCacheManagerImpl implements RolloutCacheManager, SplitTask {
    public static final int MIN_CACHE_CLEAR_DAYS = 1;
    private final RolloutCacheConfiguration mConfig;
    private final EncryptionMigrationTask mEncryptionMigrationTask;
    private final GeneralInfoStorage mGeneralInfoStorage;
    private final RolloutDefinitionsCache[] mStorages;

    public RolloutCacheManagerImpl(SplitClientConfig splitClientConfig, SplitStorageContainer storageContainer, EncryptionMigrationTask encryptionMigrationTask) {
        this(storageContainer.getGeneralInfoStorage(), splitClientConfig.rolloutCacheConfiguration(), encryptionMigrationTask, storageContainer.getSplitsStorage(), storageContainer.getMySegmentsStorageContainer(), storageContainer.getMyLargeSegmentsStorageContainer(), storageContainer.getRuleBasedSegmentStorage());
    }

    RolloutCacheManagerImpl(GeneralInfoStorage generalInfoStorage, RolloutCacheConfiguration config, EncryptionMigrationTask encryptionMigrationTask, RolloutDefinitionsCache... storages) {
        this.mGeneralInfoStorage = (GeneralInfoStorage) Utils.checkNotNull(generalInfoStorage);
        this.mEncryptionMigrationTask = (EncryptionMigrationTask) Utils.checkNotNull(encryptionMigrationTask);
        this.mStorages = (RolloutDefinitionsCache[]) Utils.checkNotNull(storages);
        this.mConfig = (RolloutCacheConfiguration) Utils.checkNotNull(config);
    }

    @Override // io.split.android.client.service.synchronizer.RolloutCacheManager
    public void validateCache(SplitTaskExecutionListener listener) {
        try {
            Logger.v("Rollout cache manager: Validating cache");
            execute();
            Logger.v("Rollout cache manager: Migrating encryption");
            this.mEncryptionMigrationTask.execute();
            Logger.v("Rollout cache manager: Validation finished");
            listener.taskExecuted(SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK));
        } catch (Exception e) {
            Logger.e("Error occurred validating cache: " + e.getMessage());
            listener.taskExecuted(SplitTaskExecutionInfo.error(SplitTaskType.GENERIC_TASK));
        }
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            if (validateExpiration()) {
                clear();
            }
            return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
        } catch (Exception e) {
            Logger.e("Error occurred validating cache: " + e.getMessage());
            return SplitTaskExecutionInfo.error(SplitTaskType.GENERIC_TASK);
        }
    }

    private boolean validateExpiration() {
        long splitsUpdateTimestamp = this.mGeneralInfoStorage.getSplitsUpdateTimestamp();
        long days = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - splitsUpdateTimestamp);
        if (splitsUpdateTimestamp > 0 && days >= this.mConfig.getExpirationDays()) {
            Logger.v("Clearing rollout definitions cache due to expiration");
            return true;
        }
        if (!this.mConfig.isClearOnInit()) {
            return false;
        }
        long rolloutCacheLastClearTimestamp = this.mGeneralInfoStorage.getRolloutCacheLastClearTimestamp();
        if (rolloutCacheLastClearTimestamp < 1) {
            return true;
        }
        if (TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - rolloutCacheLastClearTimestamp) < 1) {
            return false;
        }
        Logger.v("Forcing rollout definitions cache clear");
        return true;
    }

    private void clear() {
        for (RolloutDefinitionsCache rolloutDefinitionsCache : this.mStorages) {
            rolloutDefinitionsCache.clear();
        }
        this.mGeneralInfoStorage.setRolloutCacheLastClearTimestamp(System.currentTimeMillis());
        Logger.v("Rollout definitions cache cleared");
    }
}
