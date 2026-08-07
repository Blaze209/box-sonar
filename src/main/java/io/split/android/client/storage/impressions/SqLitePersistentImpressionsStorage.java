package io.split.android.client.storage.impressions;

import com.google.gson.JsonParseException;
import io.split.android.client.dtos.DeprecatedKeyImpression;
import io.split.android.client.dtos.Identifiable;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.common.SqLitePersistentStorage;
import io.split.android.client.storage.db.ImpressionDao;
import io.split.android.client.storage.db.ImpressionEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SqLitePersistentImpressionsStorage extends SqLitePersistentStorage<ImpressionEntity, KeyImpression> implements PersistentImpressionsStorage {
    private final ImpressionDao mDao;
    private final SplitRoomDatabase mDatabase;
    private final SplitCipher mSplitCipher;

    @Override // io.split.android.client.storage.common.StoragePusher
    public /* bridge */ /* synthetic */ void push(Object model) {
        super.push((Identifiable) model);
    }

    public SqLitePersistentImpressionsStorage(SplitRoomDatabase database, long expirationPeriod, SplitCipher splitCipher) {
        super(expirationPeriod);
        SplitRoomDatabase splitRoomDatabase = (SplitRoomDatabase) Utils.checkNotNull(database);
        this.mDatabase = splitRoomDatabase;
        this.mDao = splitRoomDatabase.impressionDao();
        this.mSplitCipher = (SplitCipher) Utils.checkNotNull(splitCipher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(ImpressionEntity entity) {
        this.mDao.insert(entity);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    protected void insert(List<ImpressionEntity> entities) {
        this.mDao.insert(entities);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public ImpressionEntity entityForModel(KeyImpression model) {
        ImpressionEntity impressionEntity = new ImpressionEntity();
        try {
            String strEncrypt = this.mSplitCipher.encrypt(Json.toJson(model));
            String strEncrypt2 = this.mSplitCipher.encrypt(model.feature);
            if (strEncrypt2 != null && strEncrypt != null) {
                impressionEntity.setStatus(0);
                impressionEntity.setBody(strEncrypt);
                impressionEntity.setTestName(strEncrypt2);
                impressionEntity.setCreatedAt(System.currentTimeMillis() / 1000);
                return impressionEntity;
            }
            Logger.e("Error encrypting impression");
            return null;
        } catch (JsonParseException e) {
            Logger.e("Error parsing impression: " + e.getMessage());
            return null;
        }
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
    protected void runInTransaction(List<ImpressionEntity> entities, int finalCount, long expirationPeriod) {
        this.mDatabase.runInTransaction(new GetAndUpdate(this.mDao, entities, finalCount, expirationPeriod));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public KeyImpression entityToModel(ImpressionEntity entity) throws JsonParseException {
        KeyImpression keyImpressionUpdateImpression;
        try {
            String testName = entity.getTestName();
            String body = entity.getBody();
            String strDecrypt = this.mSplitCipher.decrypt(testName);
            String strDecrypt2 = this.mSplitCipher.decrypt(body);
            if (strDecrypt == null || strDecrypt2 == null) {
                keyImpressionUpdateImpression = null;
            } else {
                keyImpressionUpdateImpression = (KeyImpression) Json.fromJson(strDecrypt2, KeyImpression.class);
                keyImpressionUpdateImpression.feature = strDecrypt;
            }
        } catch (JsonParseException unused) {
            String testName2 = entity.getTestName();
            String body2 = entity.getBody();
            String strDecrypt3 = this.mSplitCipher.decrypt(testName2);
            DeprecatedKeyImpression deprecatedKeyImpression = (DeprecatedKeyImpression) Json.fromJson(this.mSplitCipher.decrypt(body2), DeprecatedKeyImpression.class);
            deprecatedKeyImpression.feature = strDecrypt3;
            keyImpressionUpdateImpression = updateImpression(deprecatedKeyImpression);
        }
        if (keyImpressionUpdateImpression == null) {
            throw new JsonParseException("Error parsing stored impression");
        }
        keyImpressionUpdateImpression.storageId = entity.getId();
        return keyImpressionUpdateImpression;
    }

    private KeyImpression updateImpression(DeprecatedKeyImpression deprecated) {
        KeyImpression keyImpression = new KeyImpression();
        keyImpression.feature = deprecated.feature;
        keyImpression.bucketingKey = deprecated.bucketingKey;
        keyImpression.changeNumber = deprecated.changeNumber;
        keyImpression.keyName = deprecated.keyName;
        keyImpression.label = deprecated.label;
        keyImpression.time = deprecated.time;
        keyImpression.treatment = deprecated.treatment;
        return keyImpression;
    }

    static class GetAndUpdate extends SqLitePersistentStorage.GetAndUpdateTransaction<ImpressionEntity, KeyImpression> {
        final ImpressionDao mDao;

        public GetAndUpdate(ImpressionDao dao, List<ImpressionEntity> entities, int count, long expirationPeriod) {
            super(entities, count, expirationPeriod);
            this.mDao = dao;
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        protected List<ImpressionEntity> getBy(long timestamp, int status, int rowCount) {
            return this.mDao.getBy(timestamp, status, rowCount);
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        protected void updateStatus(List<Long> ids, int status) {
            this.mDao.updateStatus(ids, status);
        }
    }
}
