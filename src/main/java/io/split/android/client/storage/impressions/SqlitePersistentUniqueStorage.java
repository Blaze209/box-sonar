package io.split.android.client.storage.impressions;

import com.google.gson.JsonParseException;
import io.split.android.client.dtos.Identifiable;
import io.split.android.client.service.impressions.unique.UniqueKey;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.common.SqLitePersistentStorage;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.db.impressions.unique.UniqueKeyEntity;
import io.split.android.client.storage.db.impressions.unique.UniqueKeysDao;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SqlitePersistentUniqueStorage extends SqLitePersistentStorage<UniqueKeyEntity, UniqueKey> implements PersistentImpressionsUniqueStorage {
    private final UniqueKeysDao mDao;
    private final SplitRoomDatabase mDatabase;
    private final SplitCipher mSplitCipher;

    @Override // io.split.android.client.storage.common.StoragePusher
    public /* bridge */ /* synthetic */ void push(Object model) {
        super.push((Identifiable) model);
    }

    public SqlitePersistentUniqueStorage(SplitRoomDatabase database, long expirationPeriod, SplitCipher splitCipher) {
        super(expirationPeriod);
        SplitRoomDatabase splitRoomDatabase = (SplitRoomDatabase) Utils.checkNotNull(database);
        this.mDatabase = splitRoomDatabase;
        this.mDao = splitRoomDatabase.uniqueKeysDao();
        this.mSplitCipher = (SplitCipher) Utils.checkNotNull(splitCipher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(UniqueKeyEntity entity) {
        this.mDao.insert(entity);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    protected void insert(List<UniqueKeyEntity> entities) {
        this.mDao.insert(entities);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public UniqueKeyEntity entityForModel(UniqueKey model) {
        String strEncrypt = this.mSplitCipher.encrypt(model.getKey());
        String strEncrypt2 = this.mSplitCipher.encrypt(Json.toJson(model.getFeatures()));
        if (strEncrypt == null || strEncrypt2 == null) {
            Logger.e("Error encrypting unique key");
            return null;
        }
        return new UniqueKeyEntity(strEncrypt, strEncrypt2, System.currentTimeMillis() / 1000, 0);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    protected int deleteByStatus(int status, long maxTimestamp) {
        return this.mDao.deleteByStatus(status, maxTimestamp, 100);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    protected void deleteOutdated(long expirationTime) {
        this.mDao.deleteOutdated(expirationTime);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    protected void deleteById(List<Long> ids) {
        this.mDao.deleteById(ids);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    protected void updateStatus(List<Long> ids, int status) {
        this.mDao.updateStatus(ids, status);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    protected void runInTransaction(List<UniqueKeyEntity> entities, int finalCount, long expirationPeriod) {
        this.mDatabase.runInTransaction(new GetAndUpdate(this.mDao, entities, finalCount, expirationPeriod));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public UniqueKey entityToModel(UniqueKeyEntity entity) throws JsonParseException {
        UniqueKey uniqueKey = new UniqueKey(this.mSplitCipher.decrypt(entity.getUserKey()), (Set) Json.fromJson(this.mSplitCipher.decrypt(entity.getFeatureList()), Set.class));
        uniqueKey.setStorageId(entity.getId());
        return uniqueKey;
    }

    static class GetAndUpdate extends SqLitePersistentStorage.GetAndUpdateTransaction<UniqueKeyEntity, UniqueKey> {
        private final UniqueKeysDao mDao;

        public GetAndUpdate(UniqueKeysDao dao, List<UniqueKeyEntity> entities, int count, long expirationPeriod) {
            super(entities, count, expirationPeriod);
            this.mDao = dao;
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        protected List<UniqueKeyEntity> getBy(long timestamp, int status, int rowCount) {
            return this.mDao.getBy(timestamp, status, rowCount);
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        protected void updateStatus(List<Long> ids, int status) {
            this.mDao.updateStatus(ids, status);
        }
    }
}
