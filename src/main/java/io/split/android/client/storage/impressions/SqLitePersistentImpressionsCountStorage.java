package io.split.android.client.storage.impressions;

import com.google.gson.JsonParseException;
import io.split.android.client.dtos.Identifiable;
import io.split.android.client.service.impressions.ImpressionsCountPerFeature;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.common.SqLitePersistentStorage;
import io.split.android.client.storage.db.ImpressionsCountDao;
import io.split.android.client.storage.db.ImpressionsCountEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SqLitePersistentImpressionsCountStorage extends SqLitePersistentStorage<ImpressionsCountEntity, ImpressionsCountPerFeature> implements PersistentImpressionsCountStorage {
    private final ImpressionsCountDao mDao;
    private final SplitRoomDatabase mDatabase;
    private final SplitCipher mSplitCipher;

    @Override // io.split.android.client.storage.common.StoragePusher
    public /* bridge */ /* synthetic */ void push(Object model) {
        super.push((Identifiable) model);
    }

    public SqLitePersistentImpressionsCountStorage(SplitRoomDatabase database, long expirationPeriod, SplitCipher splitCipher) {
        super(expirationPeriod);
        SplitRoomDatabase splitRoomDatabase = (SplitRoomDatabase) Utils.checkNotNull(database);
        this.mDatabase = splitRoomDatabase;
        this.mDao = splitRoomDatabase.impressionsCountDao();
        this.mSplitCipher = (SplitCipher) Utils.checkNotNull(splitCipher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(ImpressionsCountEntity entity) {
        this.mDao.insert(entity);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    protected void insert(List<ImpressionsCountEntity> entities) {
        this.mDao.insert(entities);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public ImpressionsCountEntity entityForModel(ImpressionsCountPerFeature model) {
        String strEncrypt = this.mSplitCipher.encrypt(Json.toJson(model));
        if (strEncrypt == null) {
            Logger.e("Error encrypting impression count");
            return null;
        }
        ImpressionsCountEntity impressionsCountEntity = new ImpressionsCountEntity();
        impressionsCountEntity.setBody(strEncrypt);
        impressionsCountEntity.setStatus(0);
        impressionsCountEntity.setCreatedAt(System.currentTimeMillis() / 1000);
        return impressionsCountEntity;
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
        this.mDao.delete(ids);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    protected void updateStatus(List<Long> ids, int status) {
        this.mDao.updateStatus(ids, status);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    protected void runInTransaction(List<ImpressionsCountEntity> entities, int finalCount, long expirationPeriod) {
        this.mDatabase.runInTransaction(new GetAndUpdate(this.mDao, entities, finalCount, expirationPeriod));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public ImpressionsCountPerFeature entityToModel(ImpressionsCountEntity entity) throws JsonParseException {
        ImpressionsCountPerFeature impressionsCountPerFeature = (ImpressionsCountPerFeature) Json.fromJson(this.mSplitCipher.decrypt(entity.getBody()), ImpressionsCountPerFeature.class);
        impressionsCountPerFeature.storageId = entity.getId();
        return impressionsCountPerFeature;
    }

    static class GetAndUpdate extends SqLitePersistentStorage.GetAndUpdateTransaction<ImpressionsCountEntity, ImpressionsCountPerFeature> {
        final ImpressionsCountDao mDao;

        public GetAndUpdate(ImpressionsCountDao dao, List<ImpressionsCountEntity> entities, int count, long expirationPeriod) {
            super(entities, count, expirationPeriod);
            this.mDao = dao;
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        protected List<ImpressionsCountEntity> getBy(long timestamp, int status, int rowCount) {
            return this.mDao.getBy(timestamp, status, rowCount);
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        protected void updateStatus(List<Long> ids, int status) {
            this.mDao.updateStatus(ids, status);
        }
    }
}
