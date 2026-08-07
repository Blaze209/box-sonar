package io.split.android.client.storage.rbs;

import io.split.android.client.storage.db.rbs.RuleBasedSegmentDao;
import io.split.android.client.storage.general.GeneralInfoStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
class Clearer implements Runnable {
    private final RuleBasedSegmentDao mDao;
    private final GeneralInfoStorage mGeneralInfoStorage;

    public Clearer(RuleBasedSegmentDao dao, GeneralInfoStorage generalInfoStorage) {
        this.mDao = (RuleBasedSegmentDao) Utils.checkNotNull(dao);
        this.mGeneralInfoStorage = (GeneralInfoStorage) Utils.checkNotNull(generalInfoStorage);
    }

    @Override // java.lang.Runnable
    public void run() throws Exception {
        try {
            this.mDao.deleteAll();
            this.mGeneralInfoStorage.setRbsChangeNumber(-1L);
        } catch (Exception e) {
            Logger.e("Error clearing RBS: " + e.getLocalizedMessage());
            throw e;
        }
    }
}
