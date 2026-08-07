package com.box.android.data.persistence.representations;

import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: FileRepresentationsDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/representations/FileRepresentationsDao;", "", "insertRepresentation", "", "representationItemEntity", "Lcom/box/android/data/persistence/representations/RepresentationsItemEntity;", "(Lcom/box/android/data/persistence/representations/RepresentationsItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepresentationsForFile", "fileId", "Lcom/box/android/domain/models/ItemId$Remote;", "sha1", "", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FileRepresentationsDao {
    Object getRepresentationsForFile(ItemId.Remote remote, String str, Continuation<? super RepresentationsItemEntity> continuation);

    Object insertRepresentation(RepresentationsItemEntity representationsItemEntity, Continuation<? super Unit> continuation);
}
