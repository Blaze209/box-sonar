package io.split.android.client.storage.general;

import io.split.android.client.storage.db.GeneralInfoDao;
import io.split.android.client.storage.db.GeneralInfoEntity;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class GeneralInfoStorageImpl implements GeneralInfoStorage {
    private static final String LAST_PROXY_CHECK_TIMESTAMP = "lastProxyCheckTimestamp";
    private static final String RBS_CHANGE_NUMBER = "rbsChangeNumber";
    private static final String ROLLOUT_CACHE_LAST_CLEAR_TIMESTAMP = "rolloutCacheLastClearTimestamp";
    private final GeneralInfoDao mGeneralInfoDao;

    public GeneralInfoStorageImpl(GeneralInfoDao generalInfoDao) {
        this.mGeneralInfoDao = (GeneralInfoDao) Utils.checkNotNull(generalInfoDao);
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public long getSplitsUpdateTimestamp() {
        GeneralInfoEntity byName = this.mGeneralInfoDao.getByName(GeneralInfoEntity.SPLITS_UPDATE_TIMESTAMP);
        if (byName != null) {
            return byName.getLongValue();
        }
        return 0L;
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public void setSplitsUpdateTimestamp(long timestamp) {
        this.mGeneralInfoDao.update(new GeneralInfoEntity(GeneralInfoEntity.SPLITS_UPDATE_TIMESTAMP, timestamp));
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public long getFlagsChangeNumber() {
        GeneralInfoEntity byName = this.mGeneralInfoDao.getByName(GeneralInfoEntity.CHANGE_NUMBER_INFO);
        if (byName != null) {
            return byName.getLongValue();
        }
        return -1L;
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public void setFlagsChangeNumber(long changeNumber) {
        this.mGeneralInfoDao.update(new GeneralInfoEntity(GeneralInfoEntity.CHANGE_NUMBER_INFO, changeNumber));
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public long getRbsChangeNumber() {
        GeneralInfoEntity byName = this.mGeneralInfoDao.getByName(RBS_CHANGE_NUMBER);
        if (byName != null) {
            return byName.getLongValue();
        }
        return -1L;
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public void setRbsChangeNumber(long changeNumber) {
        this.mGeneralInfoDao.update(new GeneralInfoEntity(RBS_CHANGE_NUMBER, changeNumber));
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public String getSplitsFilterQueryString() {
        GeneralInfoEntity byName = this.mGeneralInfoDao.getByName(GeneralInfoEntity.SPLITS_FILTER_QUERY_STRING);
        return byName != null ? byName.getStringValue() : "";
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public void setSplitsFilterQueryString(String queryString) {
        this.mGeneralInfoDao.update(new GeneralInfoEntity(GeneralInfoEntity.SPLITS_FILTER_QUERY_STRING, queryString));
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public String getDatabaseEncryptionMode() {
        GeneralInfoEntity byName = this.mGeneralInfoDao.getByName(GeneralInfoEntity.DATABASE_ENCRYPTION_MODE);
        return byName != null ? byName.getStringValue() : "";
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public void setDatabaseEncryptionMode(String value) {
        this.mGeneralInfoDao.update(new GeneralInfoEntity(GeneralInfoEntity.DATABASE_ENCRYPTION_MODE, value));
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public String getFlagsSpec() {
        GeneralInfoEntity byName = this.mGeneralInfoDao.getByName("flagsSpec");
        return byName != null ? byName.getStringValue() : "";
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public void setFlagsSpec(String value) {
        this.mGeneralInfoDao.update(new GeneralInfoEntity("flagsSpec", value));
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public long getRolloutCacheLastClearTimestamp() {
        GeneralInfoEntity byName = this.mGeneralInfoDao.getByName(ROLLOUT_CACHE_LAST_CLEAR_TIMESTAMP);
        if (byName != null) {
            return byName.getLongValue();
        }
        return 0L;
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public void setRolloutCacheLastClearTimestamp(long timestamp) {
        this.mGeneralInfoDao.update(new GeneralInfoEntity(ROLLOUT_CACHE_LAST_CLEAR_TIMESTAMP, timestamp));
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public void setLastProxyUpdateTimestamp(long timestamp) {
        this.mGeneralInfoDao.update(new GeneralInfoEntity(LAST_PROXY_CHECK_TIMESTAMP, timestamp));
    }

    @Override // io.split.android.client.storage.general.GeneralInfoStorage
    public long getLastProxyUpdateTimestamp() {
        GeneralInfoEntity byName = this.mGeneralInfoDao.getByName(LAST_PROXY_CHECK_TIMESTAMP);
        if (byName != null) {
            return byName.getLongValue();
        }
        return 0L;
    }
}
