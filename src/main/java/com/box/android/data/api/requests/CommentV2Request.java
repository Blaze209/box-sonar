package com.box.android.data.api.requests;

import com.box.android.data.api.models.comment.CommentV2RequestDTO;
import com.box.android.data.api.models.comment.CommentV2ResponseDTO;
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

/* JADX INFO: compiled from: CommentV2Request.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ$\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007H§@¢\u0006\u0002\u0010\bJ.\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007H§@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000e¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/CommentV2Request;", "", "createComment", "Lcom/box/android/data/api/models/comment/CommentV2ResponseDTO;", "body", "Lcom/box/android/data/api/models/comment/CommentV2RequestDTO;", "fields", "", "(Lcom/box/android/data/api/models/comment/CommentV2RequestDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateComment", "commentId", "(Ljava/lang/String;Lcom/box/android/data/api/models/comment/CommentV2RequestDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteComment", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CommentV2Request {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST(BoxRequestsSearch.Search.CONTENT_TYPE_COMMENTS)
    Object createComment(@Body CommentV2RequestDTO commentV2RequestDTO, @Query("fields") String str, Continuation<? super CommentV2ResponseDTO> continuation);

    @DELETE("comments/{comment_id}")
    Object deleteComment(@Path("comment_id") String str, Continuation<? super Unit> continuation);

    @PUT("comments/{comment_id}")
    Object updateComment(@Path("comment_id") String str, @Body CommentV2RequestDTO commentV2RequestDTO, @Query("fields") String str2, Continuation<? super CommentV2ResponseDTO> continuation);

    /* JADX INFO: compiled from: CommentV2Request.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/api/requests/CommentV2Request$Companion;", "", "<init>", "()V", "DEFAULT_FIELDS", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String DEFAULT_FIELDS = "item,tagged_message,message,created_at,created_by,modified_at,permissions";

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: CommentV2Request.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object createComment$default(CommentV2Request commentV2Request, CommentV2RequestDTO commentV2RequestDTO, String str, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createComment");
        }
        if ((i & 2) != 0) {
            str = "item,tagged_message,message,created_at,created_by,modified_at,permissions";
        }
        return commentV2Request.createComment(commentV2RequestDTO, str, continuation);
    }

    static /* synthetic */ Object updateComment$default(CommentV2Request commentV2Request, String str, CommentV2RequestDTO commentV2RequestDTO, String str2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateComment");
        }
        if ((i & 4) != 0) {
            str2 = "item,tagged_message,message,created_at,created_by,modified_at,permissions";
        }
        return commentV2Request.updateComment(str, commentV2RequestDTO, str2, continuation);
    }
}
