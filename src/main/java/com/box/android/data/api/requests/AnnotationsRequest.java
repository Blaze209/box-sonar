package com.box.android.data.api.requests;

import androidx.core.provider.FontsContractCompat;
import com.box.android.data.api.models.annotations.AnnotationDTO;
import com.box.android.data.api.models.annotations.AnnotationsDTO;
import com.box.android.data.api.models.annotations.CommentDTO;
import com.box.android.data.api.models.annotations.CreateAnnotationDTO;
import com.box.android.data.api.models.annotations.UpdateAnnotationDTO;
import com.box.android.data.api.models.comment.CreateCommentDTO;
import com.box.androidsdk.content.models.BoxIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: AnnotationsRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\tH§@¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000eJ,\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00052\b\b\u0001\u0010\u0013\u001a\u00020\u0014H§@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0013\u001a\u00020\u0018H§@¢\u0006\u0002\u0010\u0019J,\u0010\u001a\u001a\u00020\u00172\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u0013\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u001dH§@¢\u0006\u0002\u0010\u001e¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/AnnotationsRequest;", "", "getAnnotations", "Lcom/box/android/data/api/models/annotations/AnnotationsDTO;", "fileId", "", "fileVersionId", "marker", BoxIterator.FIELD_LIMIT, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAnnotation", "", "annotationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createReply", "Lcom/box/android/data/api/models/annotations/CommentDTO;", "commentID", "fileID", "body", "Lcom/box/android/data/api/models/comment/CreateCommentDTO;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/comment/CreateCommentDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAnnotation", "Lcom/box/android/data/api/models/annotations/AnnotationDTO;", "Lcom/box/android/data/api/models/annotations/CreateAnnotationDTO;", "(Lcom/box/android/data/api/models/annotations/CreateAnnotationDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAnnotation", "Lcom/box/android/data/api/models/annotations/UpdateAnnotationDTO;", "enableReplies", "", "(Ljava/lang/String;Lcom/box/android/data/api/models/annotations/UpdateAnnotationDTO;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AnnotationsRequest {
    @Headers({"Content-Type: application/vnd.box+json;version=v2", "Cookie: csrf-token=unused", "x-csrf-token: unused"})
    @POST("undoc/annotations")
    Object createAnnotation(@Body CreateAnnotationDTO createAnnotationDTO, Continuation<? super AnnotationDTO> continuation);

    @POST("undoc/annotations/{id}/replies")
    Object createReply(@Path("id") String str, @Query(FontsContractCompat.Columns.FILE_ID) String str2, @Body CreateCommentDTO createCommentDTO, Continuation<? super CommentDTO> continuation);

    @DELETE("undoc/annotations/{id}")
    Object deleteAnnotation(@Path("id") String str, Continuation<? super Unit> continuation);

    @GET("undoc/annotations")
    Object getAnnotations(@Query(FontsContractCompat.Columns.FILE_ID) String str, @Query("file_version_id") String str2, @Query("marker") String str3, @Query(BoxIterator.FIELD_LIMIT) Integer num, Continuation<? super AnnotationsDTO> continuation);

    @PUT("undoc/annotations/{id}")
    Object updateAnnotation(@Path("id") String str, @Body UpdateAnnotationDTO updateAnnotationDTO, @Query("enable_replies") boolean z, Continuation<? super AnnotationDTO> continuation);

    /* JADX INFO: compiled from: AnnotationsRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getAnnotations$default(AnnotationsRequest annotationsRequest, String str, String str2, String str3, Integer num, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnnotations");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            num = 100;
        }
        return annotationsRequest.getAnnotations(str, str2, str3, num, continuation);
    }
}
