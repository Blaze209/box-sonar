package com.box.android.data.api.requests;

import androidx.core.provider.FontsContractCompat;
import com.box.android.data.api.models.annotations.CommentDTO;
import com.box.android.data.api.models.comment.CreateCommentDTO;
import com.box.android.data.api.models.comment.UpdateCommentDTO;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: CommentRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ,\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/CommentRequest;", "", "createComment", "Lcom/box/android/data/api/models/annotations/CommentDTO;", "fileID", "", "body", "Lcom/box/android/data/api/models/comment/CreateCommentDTO;", "(Ljava/lang/String;Lcom/box/android/data/api/models/comment/CreateCommentDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createReply", "commentID", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/comment/CreateCommentDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateComment", "Lcom/box/android/data/api/models/comment/UpdateCommentDTO;", "(Ljava/lang/String;Lcom/box/android/data/api/models/comment/UpdateCommentDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteComment", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CommentRequest {
    @POST(BoxRequestsSearch.Search.CONTENT_TYPE_COMMENTS)
    Object createComment(@Query(FontsContractCompat.Columns.FILE_ID) String str, @Body CreateCommentDTO createCommentDTO, Continuation<? super CommentDTO> continuation);

    @POST("comments/{id}/replies")
    Object createReply(@Path("id") String str, @Query(FontsContractCompat.Columns.FILE_ID) String str2, @Body CreateCommentDTO createCommentDTO, Continuation<? super CommentDTO> continuation);

    @DELETE("comments/{id}")
    Object deleteComment(@Path("id") String str, Continuation<? super Unit> continuation);

    @PUT("comments/{id}")
    Object updateComment(@Path("id") String str, @Body UpdateCommentDTO updateCommentDTO, Continuation<? super CommentDTO> continuation);
}
