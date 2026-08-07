package io.split.android.client.storage.impressions;

import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.storage.common.PersistentStorage;
import io.split.android.client.storage.common.Storage;
import io.split.android.client.storage.common.StoragePusher;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsStorage implements Storage<KeyImpression>, StoragePusher<KeyImpression> {
    private final AbstractQueue<KeyImpression> mImpressions = new ConcurrentLinkedQueue();
    private final AtomicBoolean mIsPersistenceEnabled;
    private final PersistentStorage<KeyImpression> mPersistentStorage;

    public ImpressionsStorage(PersistentStorage<KeyImpression> persistentStorage, boolean isPersistenceEnabled) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.mIsPersistenceEnabled = atomicBoolean;
        this.mPersistentStorage = (PersistentStorage) Utils.checkNotNull(persistentStorage);
        atomicBoolean.set(isPersistenceEnabled);
    }

    @Override // io.split.android.client.storage.common.Storage
    public void enablePersistence(boolean enabled) {
        this.mIsPersistenceEnabled.set(enabled);
        if (enabled) {
            Logger.v("Persisting in memory impressions");
            ArrayList arrayList = new ArrayList(this.mImpressions);
            this.mImpressions.removeAll(arrayList);
            this.mPersistentStorage.pushMany(arrayList);
        }
        Logger.d("Persistence for impressions has been ".concat(enabled ? "enabled" : "disabled"));
    }

    @Override // io.split.android.client.storage.common.Storage, io.split.android.client.storage.common.StoragePusher
    public void push(KeyImpression element) {
        if (element == null) {
            return;
        }
        if (this.mIsPersistenceEnabled.get()) {
            Logger.v("Pushing impressions to persistent storage");
            this.mPersistentStorage.push(element);
        } else {
            Logger.v("Pushing impressions to in memory storage");
            this.mImpressions.add(element);
        }
    }

    @Override // io.split.android.client.storage.common.Storage
    public void clearInMemory() {
        this.mImpressions.clear();
    }
}
