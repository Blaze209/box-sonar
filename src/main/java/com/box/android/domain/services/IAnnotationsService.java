package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.annotations.AnnotationTargetModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.models.annotations.FileVersionIdModel;
import com.box.android.domain.utils.result.Result;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IAnnotationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\b\u001a\u00020\tH&J\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010JB\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H¦@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H&J>\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0013\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010 ¨\u0006!À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IAnnotationsService;", "", "annotations", "Lcom/box/android/domain/utils/result/Result;", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "Lcom/box/android/domain/models/DomainError;", "fileVersionIdModel", "Lcom/box/android/domain/models/annotations/FileVersionIdModel;", "fetchAnnotationsFromRemote", "", "(Lcom/box/android/domain/models/annotations/FileVersionIdModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAnnotation", "annotationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAnnotation", "fileVersionId", "fileId", "message", "target", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/annotations/AnnotationTargetModel;Lcom/box/android/domain/models/annotations/AnnotationLocationModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAnnotationPayloadSizeNotAboveLimit", "", "annotationTargetModel", "updateAnnotation", "status", "Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/annotations/FileActivityModel$Status;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAnnotationsService {
    Result<Flow<List<FileActivityModel.AnnotationModel>>, DomainError> annotations(FileVersionIdModel fileVersionIdModel);

    Object createAnnotation(String str, String str2, String str3, AnnotationTargetModel annotationTargetModel, AnnotationLocationModel annotationLocationModel, Continuation<? super Result<FileActivityModel.AnnotationModel, ? extends DomainError>> continuation);

    Object deleteAnnotation(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object fetchAnnotationsFromRemote(FileVersionIdModel fileVersionIdModel, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    boolean isAnnotationPayloadSizeNotAboveLimit(AnnotationTargetModel annotationTargetModel);

    Object updateAnnotation(String str, String str2, FileActivityModel.Status status, String str3, Continuation<? super Result<FileActivityModel.AnnotationModel, ? extends DomainError>> continuation);
}
