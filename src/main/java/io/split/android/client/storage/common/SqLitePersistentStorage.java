package io.split.android.client.storage.common;

import com.google.gson.JsonParseException;
import io.split.android.client.dtos.Identifiable;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SqLitePersistentStorage<E extends Identifiable, M extends Identifiable> {
    protected static final int MAX_ROWS_PER_QUERY = 100;
    protected long mExpirationPeriod;

    protected abstract void deleteById(List<Long> ids);

    protected abstract int deleteByStatus(int status, long maxTimestamp);

    protected abstract void deleteOutdated(long expirationTime);

    protected abstract E entityForModel(M model);

    protected abstract M entityToModel(E entity) throws JsonParseException;

    protected abstract void insert(E entity);

    protected abstract void insert(List<E> entities);

    protected abstract void runInTransaction(List<E> entities, int finalCount, long expirationPeriod);

    protected abstract void updateStatus(List<Long> ids, int status);

    public SqLitePersistentStorage(long expirationPeriod) {
        this.mExpirationPeriod = expirationPeriod;
    }

    public void push(M model) {
        Identifiable identifiableEntityForModel;
        if (model == null || (identifiableEntityForModel = entityForModel(model)) == null) {
            return;
        }
        insert(identifiableEntityForModel);
    }

    public void pushMany(List<M> models) {
        if (models == null || models.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<M> it = models.iterator();
        while (it.hasNext()) {
            Identifiable identifiableEntityForModel = entityForModel(it.next());
            if (identifiableEntityForModel != null) {
                arrayList.add(identifiableEntityForModel);
            }
        }
        insert(arrayList);
    }

    public List<M> pop(int count) {
        ArrayList arrayList = new ArrayList();
        do {
            int iMin = Math.min(100, count);
            ArrayList arrayList2 = new ArrayList();
            runInTransaction(arrayList2, iMin, this.mExpirationPeriod);
            int size = arrayList2.size();
            count -= size;
            arrayList.addAll(arrayList2);
            if (size <= 0) {
                break;
            }
        } while (count > 0);
        return entitiesToModels(arrayList);
    }

    public void setActive(List<M> models) {
        Utils.checkNotNull(models);
        if (models.size() == 0) {
            return;
        }
        Iterator<List<Long>> it = getIdInChunks(models).iterator();
        while (it.hasNext()) {
            updateStatus(it.next(), 0);
        }
    }

    public List<KeyImpression> getCritical() {
        return new ArrayList();
    }

    public void delete(List<M> models) {
        Utils.checkNotNull(models);
        if (models.size() == 0) {
            return;
        }
        Iterator<List<Long>> it = getIdInChunks(models).iterator();
        while (it.hasNext()) {
            deleteById(it.next());
        }
    }

    public void deleteInvalid(long maxTimestamp) {
        int iDeleteByStatus = 1;
        while (iDeleteByStatus > 0) {
            iDeleteByStatus = deleteByStatus(1, maxTimestamp);
        }
        deleteOutdated(expirationTime());
    }

    private long expirationTime() {
        return (System.currentTimeMillis() / 1000) - this.mExpirationPeriod;
    }

    private List<M> entitiesToModels(List<E> entities) {
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = entities.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(entityToModel(it.next()));
            } catch (JsonParseException e) {
                Logger.e("Error parsing stored entity: " + e.getLocalizedMessage());
            } catch (Exception e2) {
                Logger.e("Unknown error parsing stored entity: " + e2.getLocalizedMessage());
            }
        }
        return arrayList;
    }

    private List<List<Long>> getIdInChunks(List<M> models) {
        ArrayList arrayList = new ArrayList();
        if (models == null) {
            return new ArrayList();
        }
        Iterator<M> it = models.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getId()));
        }
        return Utils.partition(arrayList, 100);
    }

    public static abstract class GetAndUpdateTransaction<E extends Identifiable, M> implements Runnable {
        int mCount;
        List<E> mEntities;
        long mExpirationPeriod;

        protected abstract List<E> getBy(long timestamp, int status, int rowCount);

        protected abstract void updateStatus(List<Long> ids, int status);

        public GetAndUpdateTransaction(List<E> entities, int count, long expirationPeriod) {
            this.mEntities = (List) Utils.checkNotNull(entities);
            this.mCount = count;
            this.mExpirationPeriod = expirationPeriod;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mEntities.addAll(getBy((System.currentTimeMillis() / 1000) - this.mExpirationPeriod, 0, this.mCount));
            updateStatus(getEntitiesId(this.mEntities), 1);
        }

        private List<Long> getEntitiesId(List<E> entities) {
            ArrayList arrayList = new ArrayList();
            if (entities != null) {
                Iterator<E> it = entities.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(it.next().getId()));
                }
            }
            return arrayList;
        }
    }
}
