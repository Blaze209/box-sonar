package io.split.android.client.storage.cipher;

import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class DBCipher {
    private SplitCipher mFromCipher;
    private final boolean mMustApply;
    private SplitRoomDatabase mSplitDatabase;
    private TaskProvider mTaskProvider;
    private SplitCipher mToCipher;

    public DBCipher(String apiKey, SplitRoomDatabase splitDatabase, SplitEncryptionLevel fromLevel, SplitEncryptionLevel toLevel, SplitCipher toCipher) {
        this(splitDatabase, apiKey, toCipher, fromLevel, toLevel, new TaskProvider());
    }

    public DBCipher(SplitRoomDatabase splitDatabase, String apiKey, SplitCipher toCipher, SplitEncryptionLevel fromLevel, SplitEncryptionLevel toLevel, TaskProvider taskProvider) {
        boolean z = fromLevel != toLevel;
        this.mMustApply = z;
        if (z) {
            this.mFromCipher = SplitCipherFactory.create(apiKey, fromLevel);
            this.mToCipher = (SplitCipher) Utils.checkNotNull(toCipher);
            this.mSplitDatabase = (SplitRoomDatabase) Utils.checkNotNull(splitDatabase);
            this.mTaskProvider = (TaskProvider) Utils.checkNotNull(taskProvider);
        }
    }

    public void apply() {
        if (this.mMustApply) {
            this.mTaskProvider.get(this.mSplitDatabase, this.mFromCipher, this.mToCipher).execute();
        }
    }

    static class TaskProvider {
        TaskProvider() {
        }

        public ApplyCipherTask get(SplitRoomDatabase splitDatabase, SplitCipher fromCipher, SplitCipher toCipher) {
            return new ApplyCipherTask(splitDatabase, fromCipher, toCipher);
        }
    }
}
