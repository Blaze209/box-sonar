package io.split.android.client.storage.cipher;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.db.GeneralInfoDao;
import io.split.android.client.storage.db.GeneralInfoEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class EncryptionMigrationTask implements SplitTask {
    private final String mApiKey;
    private final boolean mEncryptionEnabled;
    private final SplitRoomDatabase mSplitDatabase;
    private final SplitCipher mToCipher;

    public EncryptionMigrationTask(String apiKey, SplitRoomDatabase splitDatabase, boolean encryptionEnabled, SplitCipher toCipher) {
        this.mApiKey = (String) Utils.checkNotNull(apiKey);
        this.mSplitDatabase = (SplitRoomDatabase) Utils.checkNotNull(splitDatabase);
        this.mEncryptionEnabled = encryptionEnabled;
        this.mToCipher = (SplitCipher) Utils.checkNotNull(toCipher);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            System.currentTimeMillis();
            SplitEncryptionLevel fromLevel = getFromLevel(this.mSplitDatabase.generalInfoDao(), this.mEncryptionEnabled);
            SplitEncryptionLevel level = getLevel(this.mEncryptionEnabled);
            new DBCipher(this.mApiKey, this.mSplitDatabase, fromLevel, level, this.mToCipher).apply();
            updateCurrentLevel(level);
            return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
        } catch (Exception e) {
            Logger.e("Error while migrating encryption: " + e.getMessage());
            return SplitTaskExecutionInfo.error(SplitTaskType.GENERIC_TASK);
        }
    }

    private void updateCurrentLevel(SplitEncryptionLevel toLevel) {
        this.mSplitDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.DATABASE_ENCRYPTION_MODE, toLevel.toString()));
    }

    private static SplitEncryptionLevel getFromLevel(GeneralInfoDao generalInfoDao, boolean encryptionEnabled) {
        GeneralInfoEntity byName = generalInfoDao.getByName(GeneralInfoEntity.DATABASE_ENCRYPTION_MODE);
        if (byName != null) {
            return SplitEncryptionLevel.fromString(byName.getStringValue());
        }
        return getLevel(encryptionEnabled);
    }

    private static SplitEncryptionLevel getLevel(boolean encryptionEnabled) {
        if (encryptionEnabled) {
            return SplitEncryptionLevel.AES_128_CBC;
        }
        return SplitEncryptionLevel.NONE;
    }
}
