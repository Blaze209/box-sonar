package io.split.android.client.storage.splits;

import io.split.android.client.dtos.Split;
import io.split.android.client.service.executor.parallel.SplitDeferredTaskItem;
import io.split.android.client.service.executor.parallel.SplitParallelTaskExecutor;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.SplitEntity;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public class SplitToSplitEntityTransformer implements SplitListTransformer<Split, SplitEntity> {
    private final SplitCipher mSplitCipher;
    private final SplitParallelTaskExecutor<List<SplitEntity>> mTaskExecutor;

    public SplitToSplitEntityTransformer(SplitParallelTaskExecutor<List<SplitEntity>> taskExecutor, SplitCipher splitCipher) {
        this.mTaskExecutor = (SplitParallelTaskExecutor) Utils.checkNotNull(taskExecutor);
        this.mSplitCipher = (SplitCipher) Utils.checkNotNull(splitCipher);
    }

    @Override // io.split.android.client.storage.splits.SplitListTransformer
    public List<SplitEntity> transform(List<Split> splits) {
        ArrayList arrayList = new ArrayList();
        if (splits != null) {
            int size = splits.size();
            if (size > this.mTaskExecutor.getAvailableThreads()) {
                Iterator<List<SplitEntity>> it = this.mTaskExecutor.execute(getSplitEntityTasks(splits, size)).iterator();
                while (it.hasNext()) {
                    arrayList.addAll(it.next());
                }
            } else {
                return getSplitEntities(splits, this.mSplitCipher);
            }
        }
        return arrayList;
    }

    @Override // io.split.android.client.storage.splits.SplitListTransformer
    @Deprecated
    public List<SplitEntity> transform(Map<String, Split> allNamesAndBodies) {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SplitEntity> getSplitEntities(List<Split> partition, SplitCipher cipher) {
        ArrayList arrayList = new ArrayList();
        for (Split split : partition) {
            String strEncrypt = cipher.encrypt(split.name);
            String strEncrypt2 = cipher.encrypt(Json.toJson(split));
            if (strEncrypt == null || strEncrypt2 == null) {
                Logger.e("Error encrypting split: " + split.name);
            } else {
                SplitEntity splitEntity = new SplitEntity();
                splitEntity.setName(strEncrypt);
                splitEntity.setBody(strEncrypt2);
                splitEntity.setUpdatedAt(System.currentTimeMillis() / 1000);
                arrayList.add(splitEntity);
            }
        }
        return arrayList;
    }

    private List<SplitDeferredTaskItem<List<SplitEntity>>> getSplitEntityTasks(List<Split> splits, int splitsSize) {
        List<List> listPartition = Utils.partition(splits, splitsSize / this.mTaskExecutor.getAvailableThreads());
        ArrayList arrayList = new ArrayList(listPartition.size());
        for (final List list : listPartition) {
            arrayList.add(new SplitDeferredTaskItem(new Callable<List<SplitEntity>>() { // from class: io.split.android.client.storage.splits.SplitToSplitEntityTransformer.1
                @Override // java.util.concurrent.Callable
                public List<SplitEntity> call() {
                    SplitToSplitEntityTransformer splitToSplitEntityTransformer = SplitToSplitEntityTransformer.this;
                    return splitToSplitEntityTransformer.getSplitEntities(list, splitToSplitEntityTransformer.mSplitCipher);
                }
            }));
        }
        return arrayList;
    }
}
