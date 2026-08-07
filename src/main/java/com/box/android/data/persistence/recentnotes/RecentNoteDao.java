package com.box.android.data.persistence.recentnotes;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: RecentNoteDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u001c\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/recentnotes/RecentNoteDao;", "", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/data/persistence/recentnotes/RecentNoteEntity;", "upsertAll", "", "entities", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsert", "entity", "(Lcom/box/android/data/persistence/recentnotes/RecentNoteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RecentNoteDao {
    Object deleteAll(Continuation<? super Unit> continuation);

    Flow<List<RecentNoteEntity>> observeAll();

    Object upsert(RecentNoteEntity recentNoteEntity, Continuation<? super Unit> continuation);

    Object upsertAll(List<RecentNoteEntity> list, Continuation<? super Unit> continuation);
}
