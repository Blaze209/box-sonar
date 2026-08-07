package io.split.android.client.storage.rbs;

import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.general.GeneralInfoStorage;

/* JADX INFO: loaded from: classes4.dex */
public class SqLitePersistentRuleBasedSegmentStorageProvider implements PersistentRuleBasedSegmentStorage.Provider {
    private final SqLitePersistentRuleBasedSegmentStorage mPersistentStorage;

    public SqLitePersistentRuleBasedSegmentStorageProvider(SplitCipher cipher, SplitRoomDatabase database, GeneralInfoStorage generalInfoStorage) {
        this.mPersistentStorage = new SqLitePersistentRuleBasedSegmentStorage(cipher, database, generalInfoStorage);
    }

    @Override // io.split.android.client.storage.rbs.PersistentRuleBasedSegmentStorage.Provider
    public PersistentRuleBasedSegmentStorage get() {
        return this.mPersistentStorage;
    }
}
