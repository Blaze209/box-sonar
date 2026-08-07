package com.box.android.data.persistence.annotations;

import androidx.paging.DataSource;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: FileActivityDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H'J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u000e\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H§@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH§@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH§@¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH§@¢\u0006\u0002\u0010 J\u001e\u0010\"\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH§@¢\u0006\u0002\u0010 J\u001e\u0010#\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH§@¢\u0006\u0002\u0010 J\u001e\u0010$\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH§@¢\u0006\u0002\u0010 J\u000e\u0010%\u001a\u00020\u0011H§@¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020\u0011H§@¢\u0006\u0002\u0010&¨\u0006(À\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/annotations/FileActivityDao;", "", "getActivities", "Landroidx/paging/DataSource$Factory;", "", "Lcom/box/android/data/persistence/annotations/FileActivityEntities;", "fileId", "", "getActivitiesV2", "Lkotlinx/coroutines/flow/Flow;", "", "incrementOrderNumber", "getRepliesForFileActivity", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "activityId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertActivity", "", "activityEntity", "Lcom/box/android/data/persistence/annotations/FileActivityEntity;", "(Lcom/box/android/data/persistence/annotations/FileActivityEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFileVersion", "fileVersionEntity", "Lcom/box/android/data/persistence/annotations/FileVersionEntity;", "(Lcom/box/android/data/persistence/annotations/FileVersionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertGroupedVersion", "groupedFileVersionsEntity", "Lcom/box/android/data/persistence/annotations/GroupedFileVersionsEntity;", "(Lcom/box/android/data/persistence/annotations/GroupedFileVersionsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteComments", "fetchedBefore", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteReplies", "deleteAnnotations", "deleteVersions", "deleteFileActivities", "cleanupAnnotations", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupComments", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FileActivityDao {
    Object cleanupAnnotations(Continuation<? super Unit> continuation);

    Object cleanupComments(Continuation<? super Unit> continuation);

    Object deleteAnnotations(String str, Date date, Continuation<? super Unit> continuation);

    Object deleteComments(String str, Date date, Continuation<? super Unit> continuation);

    Object deleteFileActivities(String str, Date date, Continuation<? super Unit> continuation);

    Object deleteReplies(String str, Date date, Continuation<? super Unit> continuation);

    Object deleteVersions(String str, Date date, Continuation<? super Unit> continuation);

    DataSource.Factory<Integer, FileActivityEntities> getActivities(String fileId);

    Flow<List<FileActivityEntities>> getActivitiesV2(String fileId);

    Object getRepliesForFileActivity(String str, Continuation<? super List<CommentEntity>> continuation);

    int incrementOrderNumber(String fileId);

    Object insertActivity(FileActivityEntity fileActivityEntity, Continuation<? super Unit> continuation);

    Object insertFileVersion(FileVersionEntity fileVersionEntity, Continuation<? super Unit> continuation);

    Object insertGroupedVersion(GroupedFileVersionsEntity groupedFileVersionsEntity, Continuation<? super Unit> continuation);
}
