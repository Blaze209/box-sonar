package com.box.android.data.persistence.annotations;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: AnnotationsDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\u00102\u0006\u0010\f\u001a\u00020\rH'J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\rH§@¢\u0006\u0002\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/annotations/AnnotationsDao;", "", "insertAnnotation", "", "annotationEntity", "Lcom/box/android/data/persistence/annotations/AnnotationEntity;", "(Lcom/box/android/data/persistence/annotations/AnnotationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAnnotation", "deleteAnnotations", "", "fetchedBefore", "Ljava/util/Date;", "fileVersionId", "", "(Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnnotationForFileVersionId", "Lkotlinx/coroutines/flow/Flow;", "", "deleteAnnotation", "annotationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AnnotationsDao {
    Object deleteAnnotation(String str, Continuation<? super Unit> continuation);

    Object deleteAnnotations(Date date, String str, Continuation<? super Integer> continuation);

    Flow<List<AnnotationEntity>> getAnnotationForFileVersionId(String fileVersionId);

    Object insertAnnotation(AnnotationEntity annotationEntity, Continuation<? super Unit> continuation);

    Object updateAnnotation(AnnotationEntity annotationEntity, Continuation<? super Unit> continuation);
}
