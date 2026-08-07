package io.split.android.client.service.workmanager.splits;

import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.cipher.SplitCipherFactory;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.storage.general.GeneralInfoStorage;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorageProducer;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.storage.TelemetryStorage;

/* JADX INFO: loaded from: classes4.dex */
class StorageProvider {
    private final SplitCipher mCipher;
    private final SplitRoomDatabase mDatabase;
    private final boolean mShouldRecordTelemetry;

    StorageProvider(SplitRoomDatabase database, String apiKey, boolean encryptionEnabled, boolean shouldRecordTelemetry) {
        this.mDatabase = database;
        this.mCipher = SplitCipherFactory.create(apiKey, encryptionEnabled);
        this.mShouldRecordTelemetry = shouldRecordTelemetry;
    }

    SplitsStorage provideSplitsStorage() {
        SplitsStorage splitsStorage = StorageFactory.getSplitsStorage(this.mDatabase, this.mCipher);
        splitsStorage.loadLocal();
        return splitsStorage;
    }

    TelemetryStorage provideTelemetryStorage() {
        return StorageFactory.getTelemetryStorage(this.mShouldRecordTelemetry);
    }

    RuleBasedSegmentStorageProducer provideRuleBasedSegmentStorage() {
        RuleBasedSegmentStorageProducer ruleBasedSegmentStorageForWorker = StorageFactory.getRuleBasedSegmentStorageForWorker(this.mDatabase, this.mCipher);
        ruleBasedSegmentStorageForWorker.loadLocal();
        return ruleBasedSegmentStorageForWorker;
    }

    GeneralInfoStorage provideGeneralInfoStorage() {
        return StorageFactory.getGeneralInfoStorage(this.mDatabase);
    }
}
