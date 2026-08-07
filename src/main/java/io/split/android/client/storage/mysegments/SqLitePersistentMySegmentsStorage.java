package io.split.android.client.storage.mysegments;

import com.google.gson.JsonParseException;
import io.split.android.client.dtos.SegmentsChange;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.SegmentDao;
import io.split.android.client.storage.db.SegmentEntity;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes4.dex */
public class SqLitePersistentMySegmentsStorage<T extends SegmentEntity> implements PersistentMySegmentsStorage {
    private final SegmentEntity.Creator<T> mCreator;
    private final SegmentDao<T> mDao;
    private final SplitCipher mSplitCipher;

    @Override // io.split.android.client.storage.mysegments.PersistentMySegmentsStorage
    public void close() {
    }

    public SqLitePersistentMySegmentsStorage(SplitCipher splitCipher, SegmentDao<T> mySegmentDao, SegmentEntity.Creator<T> creator) {
        this.mDao = mySegmentDao;
        this.mSplitCipher = (SplitCipher) Utils.checkNotNull(splitCipher);
        this.mCreator = (SegmentEntity.Creator) Utils.checkNotNull(creator);
    }

    @Override // io.split.android.client.storage.mysegments.PersistentMySegmentsStorage
    public void set(String str, SegmentsChange segmentsChange) {
        if (segmentsChange == null || segmentsChange.getSegments() == null) {
            return;
        }
        String strEncrypt = this.mSplitCipher.encrypt(str);
        String strEncrypt2 = this.mSplitCipher.encrypt(Json.toJson(segmentsChange));
        if (strEncrypt == null || strEncrypt2 == null) {
            Logger.e("Error encrypting my segments");
        } else {
            this.mDao.update((T) this.mCreator.createEntity(strEncrypt, strEncrypt2, System.currentTimeMillis() / 1000));
        }
    }

    @Override // io.split.android.client.storage.mysegments.PersistentMySegmentsStorage
    public SegmentsChange getSnapshot(String userKey) {
        return getMySegmentsFromEntity(this.mDao.getByUserKey(this.mSplitCipher.encrypt(userKey)));
    }

    private SegmentsChange getMySegmentsFromEntity(SegmentEntity entity) {
        if (entity == null || Utils.isNullOrEmpty(entity.getSegmentList())) {
            return SegmentsChange.createEmpty();
        }
        String strDecrypt = this.mSplitCipher.decrypt(entity.getSegmentList());
        if (strDecrypt == null) {
            return SegmentsChange.createEmpty();
        }
        try {
            return (SegmentsChange) Json.fromJson(strDecrypt, SegmentsChange.class);
        } catch (JsonParseException | NullPointerException unused) {
            Logger.v("Parsing of segments DTO failed, returning as legacy");
            return SegmentsChange.create(new HashSet(Arrays.asList(strDecrypt.split(","))), (Long) null);
        }
    }
}
