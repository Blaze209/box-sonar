package io.split.android.client.storage.cipher;

import com.box.androidsdk.content.requests.BoxRequestsFile;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.db.EventDao;
import io.split.android.client.storage.db.EventEntity;
import io.split.android.client.storage.db.GeneralInfoDao;
import io.split.android.client.storage.db.GeneralInfoEntity;
import io.split.android.client.storage.db.ImpressionDao;
import io.split.android.client.storage.db.ImpressionEntity;
import io.split.android.client.storage.db.ImpressionsCountDao;
import io.split.android.client.storage.db.ImpressionsCountEntity;
import io.split.android.client.storage.db.MyLargeSegmentDao;
import io.split.android.client.storage.db.MyLargeSegmentEntity;
import io.split.android.client.storage.db.MySegmentDao;
import io.split.android.client.storage.db.SegmentDao;
import io.split.android.client.storage.db.SegmentEntity;
import io.split.android.client.storage.db.SplitDao;
import io.split.android.client.storage.db.SplitEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.db.attributes.AttributesDao;
import io.split.android.client.storage.db.attributes.AttributesEntity;
import io.split.android.client.storage.db.impressions.unique.UniqueKeyEntity;
import io.split.android.client.storage.db.impressions.unique.UniqueKeysDao;
import io.split.android.client.storage.db.rbs.RuleBasedSegmentDao;
import io.split.android.client.storage.db.rbs.RuleBasedSegmentEntity;
import io.split.android.client.utils.logger.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ApplyCipherTask implements SplitTask {
    private final SplitCipher mFromCipher;
    private final SplitRoomDatabase mSplitDatabase;
    private final SplitCipher mToCipher;

    public ApplyCipherTask(SplitRoomDatabase splitDatabase, SplitCipher fromCipher, SplitCipher toCipher) {
        this.mSplitDatabase = splitDatabase;
        this.mFromCipher = fromCipher;
        this.mToCipher = toCipher;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            this.mSplitDatabase.runInTransaction(new Runnable() { // from class: io.split.android.client.storage.cipher.ApplyCipherTask.1
                @Override // java.lang.Runnable
                public void run() {
                    ApplyCipherTask applyCipherTask = ApplyCipherTask.this;
                    applyCipherTask.updateAttributes(applyCipherTask.mSplitDatabase.attributesDao());
                    ApplyCipherTask applyCipherTask2 = ApplyCipherTask.this;
                    applyCipherTask2.updateSplits(applyCipherTask2.mSplitDatabase, ApplyCipherTask.this.mSplitDatabase.generalInfoDao());
                    ApplyCipherTask applyCipherTask3 = ApplyCipherTask.this;
                    applyCipherTask3.updateSegments(applyCipherTask3.mSplitDatabase.mySegmentDao());
                    ApplyCipherTask applyCipherTask4 = ApplyCipherTask.this;
                    applyCipherTask4.updateLargeSegments(applyCipherTask4.mSplitDatabase.myLargeSegmentDao());
                    ApplyCipherTask applyCipherTask5 = ApplyCipherTask.this;
                    applyCipherTask5.updateImpressions(applyCipherTask5.mSplitDatabase.impressionDao());
                    ApplyCipherTask applyCipherTask6 = ApplyCipherTask.this;
                    applyCipherTask6.updateEvents(applyCipherTask6.mSplitDatabase.eventDao());
                    ApplyCipherTask applyCipherTask7 = ApplyCipherTask.this;
                    applyCipherTask7.updateImpressionsCount(applyCipherTask7.mSplitDatabase.impressionsCountDao());
                    ApplyCipherTask applyCipherTask8 = ApplyCipherTask.this;
                    applyCipherTask8.updateUniqueKeys(applyCipherTask8.mSplitDatabase.uniqueKeysDao());
                    ApplyCipherTask applyCipherTask9 = ApplyCipherTask.this;
                    applyCipherTask9.updateRuleBasedSegment(applyCipherTask9.mSplitDatabase.ruleBasedSegmentDao());
                }
            });
            return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
        } catch (Exception unused) {
            return SplitTaskExecutionInfo.error(SplitTaskType.GENERIC_TASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRuleBasedSegment(RuleBasedSegmentDao ruleBasedSegmentDao) {
        List<RuleBasedSegmentEntity> all = ruleBasedSegmentDao.getAll();
        if (all == null) {
            return;
        }
        for (RuleBasedSegmentEntity ruleBasedSegmentEntity : all) {
            String name = ruleBasedSegmentEntity.getName();
            String strDecrypt = this.mFromCipher.decrypt(name);
            String strDecrypt2 = this.mFromCipher.decrypt(ruleBasedSegmentEntity.getBody());
            String strEncrypt = this.mToCipher.encrypt(strDecrypt);
            String strEncrypt2 = this.mToCipher.encrypt(strDecrypt2);
            if (strEncrypt != null && strEncrypt2 != null) {
                ruleBasedSegmentDao.update(name, strEncrypt, strEncrypt2);
            } else {
                Logger.e("Error applying cipher to rule based segment storage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAttributes(AttributesDao attributesDao) {
        for (AttributesEntity attributesEntity : attributesDao.getAll()) {
            String userKey = attributesEntity.getUserKey();
            String strDecrypt = this.mFromCipher.decrypt(userKey);
            String strDecrypt2 = this.mFromCipher.decrypt(attributesEntity.getAttributes());
            String strEncrypt = this.mToCipher.encrypt(strDecrypt);
            String strEncrypt2 = this.mToCipher.encrypt(strDecrypt2);
            if (strEncrypt != null && strEncrypt2 != null) {
                attributesDao.update(userKey, strEncrypt, strEncrypt2);
            } else {
                Logger.e("Error applying cipher to attributes storage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUniqueKeys(UniqueKeysDao uniqueKeysDao) {
        for (UniqueKeyEntity uniqueKeyEntity : uniqueKeysDao.getAll()) {
            String strDecrypt = this.mFromCipher.decrypt(uniqueKeyEntity.getUserKey());
            String strDecrypt2 = this.mFromCipher.decrypt(uniqueKeyEntity.getFeatureList());
            String strEncrypt = this.mToCipher.encrypt(strDecrypt);
            String strEncrypt2 = this.mToCipher.encrypt(strDecrypt2);
            if (strEncrypt != null && strEncrypt2 != null) {
                uniqueKeyEntity.setUserKey(strEncrypt);
                uniqueKeyEntity.setFeatureList(strEncrypt2);
                uniqueKeysDao.insert(uniqueKeyEntity);
            } else {
                Logger.e("Error applying cipher to unique keys storage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateImpressionsCount(ImpressionsCountDao impressionsCountDao) {
        for (ImpressionsCountEntity impressionsCountEntity : impressionsCountDao.getAll()) {
            String strEncrypt = this.mToCipher.encrypt(this.mFromCipher.decrypt(impressionsCountEntity.getBody()));
            if (strEncrypt != null) {
                impressionsCountEntity.setBody(strEncrypt);
                impressionsCountDao.insert(impressionsCountEntity);
            } else {
                Logger.e("Error applying cipher to impression count storage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateImpressions(ImpressionDao impressionDao) {
        for (ImpressionEntity impressionEntity : impressionDao.getAll()) {
            String strDecrypt = this.mFromCipher.decrypt(impressionEntity.getTestName());
            String strDecrypt2 = this.mFromCipher.decrypt(impressionEntity.getBody());
            String strEncrypt = this.mToCipher.encrypt(strDecrypt);
            String strEncrypt2 = this.mToCipher.encrypt(strDecrypt2);
            if (strEncrypt != null && strEncrypt2 != null) {
                impressionEntity.setTestName(strEncrypt);
                impressionEntity.setBody(strEncrypt2);
                impressionDao.insert(impressionEntity);
            } else {
                Logger.e("Error applying cipher to impression storage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSegments(MySegmentDao mySegmentDao) {
        updateSegments(mySegmentDao, mySegmentDao.getAll());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLargeSegments(MyLargeSegmentDao myLargeSegmentDao) {
        updateSegments(myLargeSegmentDao, myLargeSegmentDao.getAll());
    }

    private void updateSegments(SegmentDao<? extends SegmentEntity> mySegmentDao, List<? extends SegmentEntity> items) {
        for (SegmentEntity segmentEntity : items) {
            String userKey = segmentEntity.getUserKey();
            String strDecrypt = this.mFromCipher.decrypt(userKey);
            String strDecrypt2 = this.mFromCipher.decrypt(segmentEntity.getSegmentList());
            String strEncrypt = this.mToCipher.encrypt(strDecrypt);
            String strEncrypt2 = this.mToCipher.encrypt(strDecrypt2);
            if (strEncrypt == null || strEncrypt2 == null) {
                Logger.e("Error applying cipher to my " + (segmentEntity instanceof MyLargeSegmentEntity ? BoxRequestsFile.DownloadAvatar.LARGE : "") + " segment");
            } else {
                mySegmentDao.update(userKey, strEncrypt, strEncrypt2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEvents(EventDao eventDao) {
        for (EventEntity eventEntity : eventDao.getAll()) {
            String strEncrypt = this.mToCipher.encrypt(this.mFromCipher.decrypt(eventEntity.getBody()));
            if (strEncrypt != null) {
                eventEntity.setBody(strEncrypt);
                eventDao.insert(eventEntity);
            } else {
                Logger.e("Error applying cipher to event");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSplits(SplitRoomDatabase splitDatabase, GeneralInfoDao generalInfoDao) {
        SplitDao splitDao = splitDatabase.splitDao();
        List<SplitEntity> all = splitDao.getAll();
        splitDatabase.getSplitQueryDao().invalidate();
        for (SplitEntity splitEntity : all) {
            String name = splitEntity.getName();
            String strDecrypt = this.mFromCipher.decrypt(name);
            String strDecrypt2 = this.mFromCipher.decrypt(splitEntity.getBody());
            String strEncrypt = this.mToCipher.encrypt(strDecrypt);
            String strEncrypt2 = this.mToCipher.encrypt(strDecrypt2);
            if (strEncrypt != null && strEncrypt2 != null) {
                splitDao.update(name, strEncrypt, strEncrypt2);
            } else {
                Logger.e("Error applying cipher to split storage");
            }
        }
        GeneralInfoEntity byName = generalInfoDao.getByName(GeneralInfoEntity.TRAFFIC_TYPES_MAP);
        if (byName != null && !byName.getStringValue().isEmpty()) {
            String strEncrypt3 = this.mToCipher.encrypt(this.mFromCipher.decrypt(byName.getStringValue()));
            if (strEncrypt3 != null) {
                generalInfoDao.update(new GeneralInfoEntity(GeneralInfoEntity.TRAFFIC_TYPES_MAP, strEncrypt3));
            } else {
                Logger.e("Error applying cipher to traffic types");
            }
        }
        GeneralInfoEntity byName2 = generalInfoDao.getByName(GeneralInfoEntity.FLAG_SETS_MAP);
        if (byName2 == null || byName2.getStringValue().isEmpty()) {
            return;
        }
        String strEncrypt4 = this.mToCipher.encrypt(this.mFromCipher.decrypt(byName2.getStringValue()));
        if (strEncrypt4 != null) {
            generalInfoDao.update(new GeneralInfoEntity(GeneralInfoEntity.FLAG_SETS_MAP, strEncrypt4));
        } else {
            Logger.e("Error applying cipher to flag sets");
        }
    }
}
