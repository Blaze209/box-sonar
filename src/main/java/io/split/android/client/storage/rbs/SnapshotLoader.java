package io.split.android.client.storage.rbs;

import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.rbs.RuleBasedSegmentDao;
import io.split.android.client.storage.db.rbs.RuleBasedSegmentEntity;
import io.split.android.client.storage.general.GeneralInfoStorage;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
final class SnapshotLoader implements Callable<RuleBasedSegmentSnapshot> {
    private final SplitCipher mCipher;
    private final RuleBasedSegmentDao mDao;
    private final GeneralInfoStorage mGeneralInfoStorage;

    SnapshotLoader(RuleBasedSegmentDao dao, SplitCipher cipher, GeneralInfoStorage generalInfoStorage) {
        this.mDao = (RuleBasedSegmentDao) Utils.checkNotNull(dao);
        this.mCipher = (SplitCipher) Utils.checkNotNull(cipher);
        this.mGeneralInfoStorage = (GeneralInfoStorage) Utils.checkNotNull(generalInfoStorage);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public RuleBasedSegmentSnapshot call() throws Exception {
        try {
            return new RuleBasedSegmentSnapshot(convertToDTOs(this.mDao.getAll()), this.mGeneralInfoStorage.getRbsChangeNumber());
        } catch (Exception e) {
            Logger.e("Error loading RBS from persistent storage", e.getLocalizedMessage());
            throw e;
        }
    }

    private Map<String, RuleBasedSegment> convertToDTOs(List<RuleBasedSegmentEntity> entities) {
        HashMap map = new HashMap();
        if (entities != null) {
            for (RuleBasedSegmentEntity ruleBasedSegmentEntity : entities) {
                String strDecrypt = this.mCipher.decrypt(ruleBasedSegmentEntity.getName());
                String strDecrypt2 = this.mCipher.decrypt(ruleBasedSegmentEntity.getBody());
                if (strDecrypt != null && strDecrypt2 != null) {
                    try {
                        map.put(strDecrypt, (RuleBasedSegment) Json.fromJson(strDecrypt2, RuleBasedSegment.class));
                    } catch (Exception e) {
                        Logger.e("Error parsing RBS with name " + strDecrypt + ": " + e.getLocalizedMessage());
                    }
                }
            }
        }
        return map;
    }
}
