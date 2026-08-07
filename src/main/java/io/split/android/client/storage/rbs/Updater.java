package io.split.android.client.storage.rbs;

import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.rbs.RuleBasedSegmentDao;
import io.split.android.client.storage.db.rbs.RuleBasedSegmentEntity;
import io.split.android.client.storage.general.GeneralInfoStorage;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
final class Updater implements Runnable {
    private final long mChangeNumber;
    private final SplitCipher mCipher;
    private final RuleBasedSegmentDao mDao;
    private final GeneralInfoStorage mGeneralInfoStorage;
    private final Set<RuleBasedSegment> mToAdd;
    private final Set<RuleBasedSegment> mToRemove;

    Updater(SplitCipher cipher, RuleBasedSegmentDao dao, GeneralInfoStorage generalInfoStorage, Set<RuleBasedSegment> toAdd, Set<RuleBasedSegment> toRemove, long changeNumber) {
        this.mCipher = (SplitCipher) Utils.checkNotNull(cipher);
        this.mDao = (RuleBasedSegmentDao) Utils.checkNotNull(dao);
        this.mGeneralInfoStorage = (GeneralInfoStorage) Utils.checkNotNull(generalInfoStorage);
        this.mToAdd = (Set) Utils.checkNotNull(toAdd);
        this.mToRemove = (Set) Utils.checkNotNull(toRemove);
        this.mChangeNumber = changeNumber;
    }

    @Override // java.lang.Runnable
    public void run() throws Exception {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<RuleBasedSegment> it = this.mToRemove.iterator();
            while (it.hasNext()) {
                String strEncrypt = this.mCipher.encrypt(it.next().getName());
                if (strEncrypt != null) {
                    arrayList.add(strEncrypt);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (RuleBasedSegment ruleBasedSegment : this.mToAdd) {
                if (ruleBasedSegment != null) {
                    try {
                        String strEncrypt2 = this.mCipher.encrypt(ruleBasedSegment.getName());
                        String strEncrypt3 = this.mCipher.encrypt(Json.toJson(ruleBasedSegment));
                        if (strEncrypt2 != null && strEncrypt3 != null) {
                            arrayList2.add(new RuleBasedSegmentEntity(strEncrypt2, strEncrypt3, System.currentTimeMillis()));
                        }
                    } catch (Exception e) {
                        Logger.e("Error parsing RBS with name " + ruleBasedSegment.getName() + ": " + e.getLocalizedMessage());
                    }
                }
            }
            this.mDao.delete(arrayList);
            this.mDao.insert(arrayList2);
            this.mGeneralInfoStorage.setRbsChangeNumber(this.mChangeNumber);
        } catch (Exception e2) {
            Logger.e("Error updating RBS: " + e2.getLocalizedMessage());
            throw e2;
        }
    }
}
