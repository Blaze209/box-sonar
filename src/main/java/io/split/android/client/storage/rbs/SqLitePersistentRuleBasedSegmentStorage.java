package io.split.android.client.storage.rbs;

import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.db.rbs.RuleBasedSegmentDao;
import io.split.android.client.storage.general.GeneralInfoStorage;
import io.split.android.client.utils.Utils;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
class SqLitePersistentRuleBasedSegmentStorage implements PersistentRuleBasedSegmentStorage {
    private final SplitCipher mCipher;
    private final RuleBasedSegmentDao mDao;
    private final SplitRoomDatabase mDatabase;
    private final GeneralInfoStorage mGeneralInfoStorage;

    public SqLitePersistentRuleBasedSegmentStorage(SplitCipher cipher, SplitRoomDatabase database, GeneralInfoStorage generalInfoStorage) {
        this.mCipher = (SplitCipher) Utils.checkNotNull(cipher);
        this.mDatabase = (SplitRoomDatabase) Utils.checkNotNull(database);
        this.mDao = database.ruleBasedSegmentDao();
        this.mGeneralInfoStorage = (GeneralInfoStorage) Utils.checkNotNull(generalInfoStorage);
    }

    @Override // io.split.android.client.storage.rbs.PersistentRuleBasedSegmentStorage
    public RuleBasedSegmentSnapshot getSnapshot() {
        return (RuleBasedSegmentSnapshot) this.mDatabase.runInTransaction(new SnapshotLoader(this.mDao, this.mCipher, this.mGeneralInfoStorage));
    }

    @Override // io.split.android.client.storage.rbs.PersistentRuleBasedSegmentStorage
    public void update(Set<RuleBasedSegment> toAdd, Set<RuleBasedSegment> toRemove, long changeNumber) {
        this.mDatabase.runInTransaction(new Updater(this.mCipher, this.mDao, this.mGeneralInfoStorage, toAdd, toRemove, changeNumber));
    }

    @Override // io.split.android.client.storage.rbs.PersistentRuleBasedSegmentStorage
    public void clear() {
        this.mDatabase.runInTransaction(new Clearer(this.mDao, this.mGeneralInfoStorage));
    }
}
