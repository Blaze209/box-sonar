package io.split.android.client.storage.events;

import com.google.gson.JsonParseException;
import io.split.android.client.dtos.Event;
import io.split.android.client.dtos.Identifiable;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.common.SqLitePersistentStorage;
import io.split.android.client.storage.db.EventDao;
import io.split.android.client.storage.db.EventEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SqLitePersistentEventsStorage extends SqLitePersistentStorage<EventEntity, Event> implements PersistentEventsStorage {
    private final EventDao mDao;
    private final SplitRoomDatabase mDatabase;
    private final SplitCipher mSplitCipher;

    @Override // io.split.android.client.storage.common.StoragePusher
    public /* bridge */ /* synthetic */ void push(Object model) {
        super.push((Identifiable) model);
    }

    public SqLitePersistentEventsStorage(SplitRoomDatabase database, long expirationPeriod, SplitCipher splitCipher) {
        super(expirationPeriod);
        SplitRoomDatabase splitRoomDatabase = (SplitRoomDatabase) Utils.checkNotNull(database);
        this.mDatabase = splitRoomDatabase;
        this.mDao = splitRoomDatabase.eventDao();
        this.mSplitCipher = (SplitCipher) Utils.checkNotNull(splitCipher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(EventEntity entity) {
        this.mDao.insert(entity);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    protected void insert(List<EventEntity> entities) {
        this.mDao.insert(entities);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public EventEntity entityForModel(Event model) {
        String strEncrypt = this.mSplitCipher.encrypt(Json.toJson(model));
        if (strEncrypt == null) {
            Logger.e("Error encrypting event");
            return null;
        }
        EventEntity eventEntity = new EventEntity();
        eventEntity.setBody(strEncrypt);
        eventEntity.setStatus(0);
        eventEntity.setCreatedAt(System.currentTimeMillis() / 1000);
        return eventEntity;
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
    protected void runInTransaction(List<EventEntity> entities, int finalCount, long expirationPeriod) {
        this.mDatabase.runInTransaction(new GetAndUpdate(this.mDao, entities, finalCount, expirationPeriod));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public Event entityToModel(EventEntity entity) throws JsonParseException {
        Event event = (Event) Json.fromJson(this.mSplitCipher.decrypt(entity.getBody()), Event.class);
        event.storageId = entity.getId();
        return event;
    }

    static class GetAndUpdate extends SqLitePersistentStorage.GetAndUpdateTransaction<EventEntity, Event> {
        final EventDao mDao;

        GetAndUpdate(EventDao dao, List<EventEntity> entities, int count, long expirationPeriod) {
            super(entities, count, expirationPeriod);
            this.mDao = dao;
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        protected List<EventEntity> getBy(long timestamp, int status, int rowCount) {
            return this.mDao.getBy(timestamp, status, rowCount);
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        protected void updateStatus(List<Long> ids, int status) {
            this.mDao.updateStatus(ids, status);
        }
    }
}
